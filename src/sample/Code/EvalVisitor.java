package sample.Code;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class EvalVisitor extends ProgramBaseVisitor<String> {

    Stack<HashSet<Simbolo>> stack = new Stack<>();
    HashSet<Simbolo> globalStack = new HashSet<>();
    String methodT="";
    String error = "";
    int offset;
    int ifCounts;
    int whileCounts;
    int contTemps = 1;
    String intCode = "";
    Stack<String> scopeName = new Stack<>();


    @Override
    public String visitClassDecl(ProgramParser.ClassDeclContext ctx){
        String ScopeName = ctx.ID().getText();
        HashSet<Simbolo> hashSet = new HashSet<>();
        scopeName.push(ScopeName);
        stack.push(hashSet);
        return visitChildren(ctx);
    }

    /*
     *Metodo para crear una nueva variable.
     */
    @Override
    public String visitVarDecl_ID(ProgramParser.VarDecl_IDContext ctx){
        HashSet<Simbolo> hashSet = stack.pop();
        String tipo =ctx.varType().getText();
        String id = ctx.ID().getText();
        Simbolo s = new Simbolo(id, tipo, 0, offset,null);
        if(hashSet.contains(s)){
            if(!error.contains("Error en la linea: "+ ctx.getStart().getLine() +". La variable  \"" + id + "\" ya ha sido creada en "+ scopeName.peek()+".\n")){
                error +="Error en la linea: "+ ctx.getStart().getLine() +". La variable  \"" + id + "\" ya ha sido creada en "+ scopeName.peek()+".\n";
            }
        }else{
            hashSet.add(s);
            if(s.getTipo().equals("int")){
                offset += 4;
            }else if(s.getTipo().equals("char")){
                offset += 4;
            }else if(s.getTipo().equals("boolean")){
                offset += 1;
            }
        }
        //Añadiendo la ultima hash set
        stack.push(hashSet);
        return visitChildren(ctx);
    }

    @Override
    /*
     *Metodo para crear una nueva estructura.
     */
    public String visitStructDecl(ProgramParser.StructDeclContext ctx){
        String struct = ctx.STRUCT().getText();
        String id = ctx.ID().getText();
        HashSet<Simbolo> hashSet = stack.pop();
        Simbolo s = new Simbolo(id, struct, 0,offset,null);
        if(hashSet.contains(s)){
            error += "Error en la linea: "+ ctx.getStart().getLine() +". La estructura " + id + " ya ha sido creada.\n";
        }else{
            hashSet.add(s);
        }
        stack.push(hashSet);
        HashSet<Simbolo> newHashSet = new HashSet<>();
        stack.push(newHashSet);
        return visitChildren(ctx);
    }

    @Override

    public String visitMethodDecl(ProgramParser.MethodDeclContext ctx){
        ArrayList<Simbolo> simbolsArray = new ArrayList<>();
        int cI= 0;
        int cC = 0;
        int cB = 0;
        String type = ctx.methodType().getText();
        String id = ctx.ID().getText();
        String firm = "";
        int cantParametros = ctx.parameter().size();
        if(cantParametros!=0){
            for(int i=0;i<cantParametros;i++){
                String parametro = ctx.parameter().get(i).getText();
                String pType = "";
                String pId = "";
                if(parametro.contains("int")){
                    cI++;
                    pType = parametro.substring(0,3);
                    pId = parametro.substring(3);
                }else if(parametro.contains("char")){
                    cC++;
                    pType = parametro.substring(0,4);
                    pId = parametro.substring(4);
                }else{
                    cB++;
                    pType = parametro.substring(0,7);
                    pId = parametro.substring(7);
                }
                firm+=pType+" "+pId +", ";
                Simbolo s =  new Simbolo(pId, pType, 0, offset, null);
                if(pType.equals("int")){
                    offset += 4;
                }else if(s.getTipo().equals("char")){
                    offset += 4;
                }else if(s.getTipo().equals("boolean")){
                    offset += 1;
                }
                simbolsArray.add(s);
            }
        }
        scopeName.push(id);

        HashSet<Simbolo>  hashSet = stack.pop();
        Simbolo s = new Simbolo(id, type, 0, offset- 4*cI + 4*cC + cB, firm);
        if(hashSet.contains(s)){
            error += "Error en la linea: "+ ctx.getStart().getLine() +". El metodo \"" + id + "\" ya ha sido creado.\n";
        }else{
            hashSet.add(s);
            methodT = type;
            intCode +="BEGIN " +s.nombre + ":\n";
        }
        stack.push(hashSet);

        //Creando la nueva tabla de simbolos para el metodo
        HashSet<Simbolo> newHashSet = new HashSet<>();
        stack.push(newHashSet);
        stack.peek().addAll(simbolsArray);
        visit(ctx.block());
        intCode +="END "+ s.nombre + "\n";
        return "";
    }

    @Override
    public String visitFinblck(ProgramParser.FinblckContext ctx) {
        stack.pop();
        contTemps=1;
        return "";
    }

    @Override
    public String visitLocation_id(ProgramParser.Location_idContext ctx) {
        Simbolo locationSimbol = null;
        String locationType = "";
        String variable = ctx.ID().getText();
        boolean existe = false;
        for (HashSet<Simbolo> h:stack) {
            Simbolo s = new Simbolo(variable,null,0, offset, null);
            if(h.contains(s) || globalStack.contains(s)){
                existe=true;
                for (Simbolo simbol:h) {
                    if(simbol.equals(s)){
                        locationSimbol = simbol;
                    }
                }
            }
        }
        if(existe==false){
            String errorMessage = "Error en la linea: "+ ctx.getStart().getLine() +". La variable \"" + variable +"\" no ha sido creada aun.\n";
            if(!error.contains(errorMessage)){
                error+=errorMessage;
            }
        }else{
            locationType = locationSimbol.getTipo();
            visitChildren(ctx);
        }
        return locationType;
    }



    @Override
    public String visitLocationA(ProgramParser.LocationAContext ctx) {
        String variable = ctx.ID().getText();
        String locationArrayType = "";
        Simbolo theSymbol = null;

        if(searchSymbol(variable, stack) == null){
            String errorMessage ="Error en la linea: "+ ctx.getStart().getLine() +". La variable \"" + variable
                    +"\" no ha sido creada aun.\n";
            if(!error.contains(errorMessage)){
                error +=errorMessage;
            }
        }else{
            theSymbol = searchSymbol(variable, stack);
        }
        String expressionType = visit(ctx.expression());
        //dividiendo expressionType ej. int, 5
        //Parte 0 = tipo
        //Parte 1 = temporal
        String[] parts = splitString(expressionType);

        if(!parts[0].equals("int")){
            //error
            String errorMessage ="Error en la linea: "+ ctx.getStart().getLine() +". La expresion del indice del array debe ser del tipo int. Se recibio" + parts[0] +".\n";
            if(!error.contains(errorMessage)){
                error +=errorMessage;
            }
        }else{

            if(theSymbol!=null){
                locationArrayType = theSymbol.getTipo();
                visitChildren(ctx);
            }else{
                visitChildren(ctx);
            }
        }
        return locationArrayType;
    }

    @Override
    //Metodo para verificar cuando un arreglo esta siendo declarado
    public String visitVarDecl_IDarray(ProgramParser.VarDecl_IDarrayContext ctx) {

        String number = ctx.NUM().getText();
        int n = Integer.parseInt(number);

        Simbolo s = new Simbolo(ctx.ID().getText(),ctx.varType().getText(),n, offset, null);
        if(stack.peek().contains(s)){
            error+="Error en la linea: "+ ctx.getStart().getLine() +". El arreglo \""+ctx.ID().getText()+"\" ya ha sido creado en "+ scopeName.peek()+".\n";
        }else{
            if(n<=0){
                error+="Error en la linea: " + ctx.getStart().getLine() +". Number en la declaracion del array \""+ctx.ID().getText()+"\" debe ser mayor a 0.\n";
            }else{
                stack.peek().add(s);
                if(s.getTipo().equals("int")){
                    offset += 4*n;
                }else if(s.getTipo().equals("char")){
                    offset += 4*n;
                }else if(s.getTipo().equals("boolean")){
                    offset += 1*n;
                }
            }
        }

        return visitChildren(ctx);
    }

    @Override
    //Metodo para verificar cuando un metodo esta siendo declarado
    public String visitCallingMethod(ProgramParser.CallingMethodContext ctx) {
        String codeParams = "";
        //Variable para retornar el tipo del metodo
        String methodType = "";
        //Obteniendo el ID del metodo
        String methodId = ctx.ID().getText();
        //Obteniendo la cantidad de parametros del metodo
        int cantParam = ctx.arg().size();
        //Llendo a buscar el Simbolo en el stack.
        Simbolo t = searchSymbol(methodId, stack);
        if(t==null){
            error+="Error en la linea: "+ ctx.getStart().getLine() +". El metodo \""+methodId+"\" no ha sido creado aun.\n";
        }else{
            String[] params = t.getFirma().split(",");
            int paramSize = params.length-1;
            if(cantParam==paramSize){
                for(int i=0;i<paramSize;i++){
                    //Obteniendo los datos del parametro, tipo y ID
                    if(String.valueOf(params[i].charAt(0)).equals(" ")){
                        params[i] = params[i].substring(1);
                    }
                    String[] parts = params[i].split(" ");
                    String paramType = parts[0];
                    String paramId = parts[1];
                    Simbolo elSim = searchSymbol(ctx.arg().get(i).getText(),stack);
                    if(elSim==null){
                        //hacer aca lo que revisa las literales
                        int x =i+1;
                        String errorMessage = "";
                        String litType = visit(ctx.arg().get(i));
                        String[] litTypeParts = litType.split(",");

                        if(paramType.equals("int")){
                            if(!litTypeParts[0].equals("int")){
                                errorMessage="Error en la linea: "+ ctx.getStart().getLine() +". Los tipos en el parametro #" + x +" no coinciden. Se esperaba "+paramType+".\n";
                            }else{
                                intCode+= "t"+ contTemps+" = "+ litTypeParts[1]+"\n";
                                codeParams+= "PARAMS t" + contTemps + ", ";
                                contTemps++;
                            }
                        }else if(paramType.equals("boolean")){
                            if(!litTypeParts[0].equals("boolean")){
                                errorMessage="Error en la linea: "+ ctx.getStart().getLine() +". Los tipos en el parametro #" + x +" no coinciden. Se esperaba "+paramType+".\n";
                            }else{
                                intCode+= "t"+ contTemps+" = "+ litTypeParts[1]+"\n";
                                codeParams+= "PARAMS t" + contTemps + ", ";
                                contTemps++;
                            }
                        }else if(paramType.equals("char")){
                             if(!litTypeParts[0].equals("char")){
                                 errorMessage="Error en la linea: "+ ctx.getStart().getLine() +". Los tipos en el parametro #" + x +" no coinciden. Se esperaba "+paramType+".\n";
                             }else{
                                 intCode+= "t"+ contTemps+" = "+ litTypeParts[1]+"\n";
                                 codeParams+= "PARAMS t" + contTemps + ", ";
                                 contTemps++;
                             }
                        }
                        //Comprueba que el error no haya sido agregado anteriormente
                        if(!error.contains(errorMessage)){
                            error+=errorMessage;
                        }
                    }else{
                        if(!elSim.getTipo().equals(paramType)){
                            int x = i+1;
                            error+="Error en la linea: "+ ctx.getStart().getLine() +". Los tipos en el parametro #" + x +" no coinciden. Se recibio " +elSim.getTipo()+", se esperaba "+paramType+".\n";
                        }else{
                            intCode+= "t"+ contTemps+" = S["+ elSim.getOffset()+"]\n";
                            codeParams+= "PARAMS t" + contTemps + ", ";
                            contTemps++;
                        }
                    }
                }
                //String[] codeParamsParts = codeParams.split(", ");
                //for (String sub:codeParamsParts) {
                    //intCode+=sub+"\n";
                //}
                intCode+="GOTO " + ctx.ID().getText() + " "+codeParams+"\n";
                methodType=t.getTipo();

                //visitChildren(ctx);
            }else{
                error+="Error en la linea: "+ ctx.getStart().getLine() +". Se recibieron " + cantParam+" argumentos, se esperaban "+ paramSize+", en el metodo "+methodId+".\n";
                //visitChildren(ctx);
            }
        }
        return methodType;
    }

    @Override
    public String visitArgs(ProgramParser.ArgsContext ctx){
        String argsType = visit(ctx.expression());
        //visitChildren(ctx);
        return argsType;
    }

    //***********************************LOCATION AND LOCATION ARRAY************************************
    @Override
    public  String visitStmt_location(ProgramParser.Stmt_locationContext ctx) {
        String expressionType = visit(ctx.expression());
        String locationType = visit(ctx.location());

        //dividiendo expressionType ej. int, 5
        //Parte 0 = tipo
        //Parte 1 = temporal
        String[] parts = splitString(expressionType);

        String errorMessage = "Error en la linea: " +ctx.getStart().getLine()+", Los tipos en " +
                "la asignacion no coinciden. No se puede asignar \"" + parts[0] +"\" a \"" +
                locationType + "\"\n";

        if(!parts[0].equals(locationType)){
            if(!error.contains(errorMessage)){
              error+=errorMessage;
            }
        }else{
            Simbolo s = searchSymbol(ctx.location().getText(), stack);
            intCode+= "S[" + s.getOffset() + "] = " + parts[parts.length-1] + "\n";

        }
        //se cambio return
        return "";
    }

    @Override
    public String visitStmt_locationArray(ProgramParser.Stmt_locationArrayContext ctx) {
        String expressionType = visit(ctx.expression());
        String locationType = visit(ctx.locationArray());

        //dividiendo expressionType ej. int, 5
        //Parte 0 = tipo
        //Parte 1 = temporal
        String[] parts = splitString(expressionType);

        String errorMessage = "Error en la linea: " +ctx.getStart().getLine()+", Los tipos en " +
                "la asignacion no coinciden. No se puede asignar \"" + parts[0] +"\" a \"" +
                locationType + "\"\n";


        if(!parts[0].equals(locationType)){
            if(!error.contains(errorMessage)){
                error+=errorMessage;
            }
        }else{
            String t = ctx.locationArray().getText();
            String arrayID = t.substring(0, t.length()-3);
            String arrayN = t.substring(t.length()-2, t.length()-1);
            Simbolo s = searchSymbol(arrayID, stack);
            if(Integer.parseInt(arrayN)>= s.size){
                errorMessage = "Error en la linea: " +ctx.getStart().getLine()+", Array \""+ arrayID+"\", index out of bounds.\n";
                if(!error.contains(errorMessage)){
                    error+=errorMessage;
                }
            }else{
                int offsetStep = 0;
                if(s.getTipo().equals("int")){
                    offsetStep = 4;
                }else if(s.getTipo().equals("char")){
                    offsetStep = 4;
                }else if(s.getTipo().equals("boolean")){
                    offsetStep = 1;
                }
                offsetStep = s.getOffset() + offsetStep * Integer.parseInt(arrayN);
                intCode+= "S[" + offsetStep + "] = " + parts[parts.length-1] + "\n";
            }
        }
        return visitChildren(ctx);
    }

    @Override
    public String visitIntegers(ProgramParser.IntegersContext ctx) {
        //Retornando el tipo int
        String tipo = "int";
        String elTemporal = ctx.getText();
        return tipo + ", " + elTemporal;
    }


    @Override
    public String visitChars(ProgramParser.CharsContext ctx) {
        String tipo = "char";
        String elTemporal = ctx.getText();
        return tipo + ", " + elTemporal;
    }

    @Override
    public String visitBool_true(ProgramParser.Bool_trueContext ctx) {
        //Retornando tipo booleano
        String tipo = "boolean";
        String elTemporal = "true";
        return tipo + ", " + elTemporal;
    }

    @Override
    public String visitBool_false(ProgramParser.Bool_falseContext ctx) {
        //Retornando tipo boolean
        String tipo = "boolean";
        String elTemporal = "false";
        return tipo + ", " + elTemporal;
    }

    @Override
    public String visitExp_condOp(ProgramParser.Exp_condOpContext ctx) {
        String elTemporal = "";
        int cont = 0;
        String andExprType = visit(ctx.andExpr());
        //String andExprTemp = elTemporal;

        //dividiendo expressionType ej. int, 5
        //Parte 0 = tipo
        //Parte 1 = temporal
        String[] parts = splitString(andExprType);

        String expressionType = visit(ctx.expression());
        //dividiendo expressionType ej. int, 5
        //Parte 0 = tipo
        //Parte 1 = temporal
        String[] parts1 = splitString(expressionType);

        //String expressionTemp = elTemporal;
        String errorMessage = "";
        if(!parts[0].equals("boolean")){
            errorMessage="Error en la linea: " + ctx.getStart().getLine() +
                    ", \"" + ctx.andExpr().getText() + " debe de ser del tipo boolean.\n";
            if(!error.contains(errorMessage)){
                error+=errorMessage;
                cont++;
            }
        }else{
            cont++;
        }

        if(!parts1[0].equals("boolean")){
            errorMessage="Error en la linea: " + ctx.getStart().getLine() +
                    ", \"" + ctx.expression().getText() + "\" debe de ser del tipo boolean.\n";
            if(!error.contains(errorMessage)){
                error+=errorMessage;
            }
        }else{
            cont++;
        }
        if(cont==2){
            intCode+= "t" + contTemps + " = " + parts[parts.length-1] + ctx.cond_op_or().getText() + parts1[parts1.length-1] + "\n";
            elTemporal = "t"+contTemps;
            contTemps++;
        }

        return parts1[0] + ",  " + elTemporal;
    }

    @Override
    public String visitAnd_condOp(ProgramParser.And_condOpContext ctx){
        String elTemporal = "";

        int cont = 0;
        String andExprType = visit(ctx.andExpr());
        //String andExprTemp = elTemporal;

        //dividiendo expressionType ej. int, 5
        //Parte 0 = tipo
        //Parte 1 = temporal
        String[] parts = splitString(andExprType);


        String eqrExprType = visit(ctx.eqExpr());
        //String eqrExprTemp = elTemporal;
        //dividiendo expressionType ej. int, 5
        //Parte 0 = tipo
        //Parte 1 = temporal
        String[] parts1 = splitString(eqrExprType);



        String errorMessage ="";
        if(!parts[0].equals("boolean")){
            errorMessage="Error en la linea: " + ctx.getStart().getLine() +
                    ", \"" + ctx.andExpr().getText() + "\" debe de ser del tipo boolean.\n";
            if(!error.contains(errorMessage)){
                error+=errorMessage;
            }
        }else{
            cont++;
        }

        if(!parts1[0].equals("boolean")){
            errorMessage="Error en la linea: " + ctx.getStart().getLine() +
                    ", \"" + ctx.eqExpr().getText() + "\" debe de ser del tipo boolean.\n";
            if(!error.contains(errorMessage)){
                error+=errorMessage;
            }
        }else{
            cont++;
        }
        if(cont==2){

            intCode+= "t" + contTemps + " = " + parts[parts.length-1] + ctx.cond_op_and().getText() + parts1[parts1.length-1] + "\n";
            elTemporal = "t"+contTemps;
            contTemps++;
        }

        return parts[0] + ", " + elTemporal;
    }

    @Override
    public String visitUnaryExpr_diff(ProgramParser.UnaryExpr_diffContext ctx) {
        String valueType =  visit(ctx.value());
        if(!valueType.equals("boolean")){
            String errorMessage="Error en la linea: " + ctx.getStart().getLine() +
                    ", \"" + ctx.value().getText() + " debe de ser del tipo boolean.\n";
            if(!error.contains(errorMessage)){
                error+=errorMessage;
            }
        }
        return visitChildren(ctx);
    }

    //********************EQ-OPS*********************************
    @Override
    public String visitEqExpr_eqOp(ProgramParser.EqExpr_eqOpContext ctx){
        String elTemporal = "";
        String tipo = null;
        String eqExprType = visit(ctx.eqExpr());
        //String eqExprTemp = elTemporal;
        //dividiendo expressionType ej. int, 5
        //Parte 0 = tipo
        //Parte 1 = temporal
        String[] parts = splitString(eqExprType);

        String relationExprType = visit(ctx.relationExpr());
        //String relationExprTemp = elTemporal;
        //dividiendo expressionType ej. int, 5
        //Parte 0 = tipo
        //Parte 1 = temporal
        String[] parts1 = splitString(relationExprType);


        if(!parts[0].equals(parts1[0])){
            String errorMessage="Error en la linea: " + ctx.getStart().getLine() +
                    ", Los tipos no son compatibles.\n";
            if(!error.contains(errorMessage)){
                error+=errorMessage;
            }
        }else{

            intCode+= "t" + contTemps + " = " + parts[parts.length-1]+ ctx.eq_op().getText() + parts1[parts1.length-1] + "\n";
            elTemporal = "t"+contTemps;
            contTemps++;
            //visitChildren(ctx);
            tipo = "boolean";
        }
        return tipo + ", "+elTemporal;
    }


    //****************************rel-op*************************************
    @Override
    public String visitRelExpr_relOp(ProgramParser.RelExpr_relOpContext ctx){
        String elTemporal = "";

        int correctos =0;
        String tipo = null;
        String relationExprType = visit(ctx.relationExpr());
        //String relationExprTemp = elTemporal;
        //dividiendo expressionType ej. int, 5
        //Parte 0 = tipo
        //Parte 1 = temporal
        String[] parts = splitString(relationExprType);

        String addExprType = visit(ctx.addExpr());
        //String addExprTemp = elTemporal;
        //dividiendo expressionType ej. int, 5
        //Parte 0 = tipo
        //Parte 1 = temporal
        String[] parts1 = splitString(addExprType);

        String errorMessage ="";
        if(!parts[0].equals("int")){
            errorMessage="Error en la linea: " + ctx.getStart().getLine() +
                    ", \"" + ctx.relationExpr().getText() + "\" debe de ser del tipo int.\n";
            if(!error.contains(errorMessage)){
                error+=errorMessage;
            }
        }else{
            correctos++;
        }

        if(!parts1[0].equals("int")){
            errorMessage="Error en la linea: " + ctx.getStart().getLine() +
                    ", \"" + ctx.addExpr().getText() + "\" debe de ser del tipo int.\n";
            if(!error.contains(errorMessage)){
                error+=errorMessage;
            }
        }else{
            correctos++;
        }
        if(correctos==2){

            intCode+= "t" + contTemps + " = " + parts[parts.length-1] + ctx.rel_op().getText() + parts1[parts1.length-1]+ "\n";
            elTemporal = "t"+contTemps;
            contTemps++;
            //visitChildren(ctx);
            tipo = "boolean";
        }
        return tipo + ", " + elTemporal;
    }

    @Override
    public String visitAddExpr_arithOp(ProgramParser.AddExpr_arithOpContext ctx){
        String elTemporal = "";

        int cont = 0;
        String addExprType = visit(ctx.addExpr());
        //String addExprTemp = elTemporal;
        //dividiendo expressionType ej. int, 5
        //Parte 0 = tipo
        //Parte 1 = temporal
        String[] parts = splitString(addExprType);

        String multExprType = visit(ctx.multExpr());
        //String multExprTemp = elTemporal;
        //dividiendo expressionType ej. int, 5
        //Parte 0 = tipo
        //Parte 1 = temporal
        String[] parts1 = splitString(multExprType);

        String errorMessage ="";
        if(!parts[0].equals("int")){
            errorMessage="Error en la linea: " + ctx.getStart().getLine() +
                    ", \"" + ctx.addExpr().getText() + "\" debe de ser del tipo int.\n";
            if(!error.contains(errorMessage)){
                error+=errorMessage;
            }
        }else{
            cont++;
        }
        if(!parts1[0].equals("int")){
            errorMessage="Error en la linea: " + ctx.getStart().getLine() +
                    ", \"" + ctx.multExpr().getText() + "\" debe de ser del tipo int.\n";
            if(!error.contains(errorMessage)){
                error+=errorMessage;
            }
        }else{
            cont++;
        }

        if(cont==2){

            intCode+= "t" + contTemps + " = " + parts[parts.length-1] + ctx.arith_op().getText() + parts1[parts1.length-1] + "\n";
            elTemporal = "t"+contTemps;
            contTemps++;
        }

        return parts[0] + ", " + elTemporal;
    }

    @Override
    public String visitMultExpr_arithOp(ProgramParser.MultExpr_arithOpContext ctx){
        String elTemporal = "";
        int cont = 0;

        String unaryExprType = visit(ctx.unaryExpr());
        //String unaryExprTemp = elTemporal;
        //dividiendo expressionType ej. int, 5
        //Parte 0 = tipo
        //Parte 1 = temporal
        String[] parts1 = splitString(unaryExprType);

        String multExprType = visit(ctx.multExpr());
        //String multExprTemp = elTemporal;
        //dividiendo expressionType ej. int, 5
        //Parte 0 = tipo
        //Parte 1 = temporal
        String[] parts = splitString(multExprType);

        String errorMessage ="";
        if(!parts[0].equals("int")){
            errorMessage="Error en la linea: " + ctx.getStart().getLine() +
                    ", \"" + ctx.multExpr().getText() + "\" debe de ser del tipo int.\n";
            if(!error.contains(errorMessage)){
                error+=errorMessage;
            }
        }else{
            cont++;
        }

        if(!parts1[0].equals("int")){
            errorMessage="Error en la linea: " + ctx.getStart().getLine() +
                    ", \"" + ctx.unaryExpr().getText() + "\" debe de ser del tipo int.\n";
            if(!error.contains(errorMessage)){
                error+=errorMessage;
            }
        }else{
            cont++;
        }

        if(cont==2){

            intCode+= "t" + contTemps + " = " + parts[parts.length-1] + ctx.mult_op().getText() + parts1[parts1.length-1] + "\n";
            elTemporal = "t"+contTemps;
            contTemps++;
        }

        return parts[0] + ", " + elTemporal;
    }

    //*******************************if************************************

    @Override
    public String visitStmt_if(ProgramParser.Stmt_ifContext ctx){
        ifCounts++;
        intCode+="label_if_"+ifCounts+":\n";
        String expressionType = visit(ctx.expression());
        //dividiendo expressionType ej. int, 5
        //Parte 0 = tipo
        //Parte 1 = temporal
        String[] parts = splitString(expressionType);

        if(!parts[0].equals("boolean")){
            String errorMessage="Error en la linea: " + ctx.getStart().getLine() +
                    ", \"" + ctx.expression().getText() + "\" debe de ser del tipo boolean.\n";
            if(!error.contains(errorMessage)){
                error+=errorMessage;
            }
        }
        //Creando la nueva tabla de simbolos para el metodo
        HashSet<Simbolo> newHashSet = new HashSet<>();
        stack.push(newHashSet);
        intCode+="label_if_"+ifCounts+"_true:\n";
        visit(ctx.block());
        visit(ctx.statementElse());
        return "";
    }

    @Override
    public String visitStmt_while(ProgramParser.Stmt_whileContext ctx){
        whileCounts++;
        intCode+="label_while_"+whileCounts+":\n";

        String expressionType = visit(ctx.expression());
        //dividiendo expressionType ej. int, 5
        //Parte 0 = tipo
        //Parte 1 = temporal
        String[] parts = splitString(expressionType);

        if(!parts[0].equals("boolean")){
            String errorMessage="Error en la linea: " + ctx.getStart().getLine() +
                    ", \"" + ctx.expression().getText() + "\" debe de ser del tipo boolean.\n";
            if(!error.contains(errorMessage)){
                error+=errorMessage;
            }
        }

        //Creando la nueva tabla de simbolos para el metodo
        HashSet<Simbolo> newHashSet = new HashSet<>();
        stack.push(newHashSet);
        intCode+="if t" + contTemps + " == false GOTO END while_" + whileCounts+ "\n";
        intCode+="label_while_"+whileCounts+"_content:\n";
        visit(ctx.block());
        intCode+="GOTO label_while_"+whileCounts+"\n";
        intCode+="END while_" + whileCounts +"\n";
        return "";
    }

    /*
     *This method looks up for a symbol in the stack.
     */
    public Simbolo searchSymbol(String symbolId, Stack<HashSet<Simbolo>> stack){
        Simbolo s = null;
        Simbolo sb = new Simbolo(symbolId, null, 0, 0,null);
        for (HashSet<Simbolo> h:stack) {
            if(h.contains(sb)){
                for (Simbolo sim:h) {
                    if(sim.equals(sb)){
                        s = sim;
                    }
                }
            }
        }
        return s;
    }

    public String[] splitString(String string){
        String[] strings = string.split(", ");
        return strings;
    }

    @Override
    public String visitStmt_return(ProgramParser.Stmt_returnContext ctx) {
        String methodType = methodT;
        String returnType = visit(ctx.expression());
        //dividiendo expressionType ej. int, 5
        //Parte 0 = tipo
        //Parte 1 = temporal
        String[] parts = splitString(returnType);

        String errorMessage = "";
        if(methodType.equals("void")){
            errorMessage = "Error en la linea: "+ctx.getStart().getLine()+
                    ", El metodo no puede contener \"return\" si es de tipo void. \n";
            if(!error.contains(errorMessage)){
                error+=errorMessage;
            }
        }else if(!methodType.equals(parts[0])){
            errorMessage = "Error en la linea: "+ctx.getStart().getLine()+
                    ", El tipo de \"return\" y del metodo debe ser el mismo. \n";
            if(!error.contains(errorMessage)){
                error+=errorMessage;
            }
        }
        intCode+="RETURN "+ parts[1] +"\n";
        return visitChildren(ctx);
    }

    //*********************RETURN METHOD CALL***********************************
    @Override
    public String visitValue_methodCall(ProgramParser.Value_methodCallContext ctx){
        String methodType = visit(ctx.methodCall());
        //dividiendo expressionType ej. int, 5
        //Parte 0 = tipo
        //Parte 1 = temporal
        String[] parts = splitString(methodType);

        if(parts[0].equals("void")){
            String errorMessage = "Error en la linea: " + ctx.getStart().getLine()+
                    ", El tipo de retorno del metodo debe ser distinto de void.\n";
            if(!error.contains(errorMessage)){
                error+=errorMessage;
            }
        }
        return methodType;
    }

    @Override
    public String visitStmtElse(ProgramParser.StmtElseContext ctx){
        //Creando la nueva tabla de simbolos para el metodo
        intCode+="label_if_"+ifCounts+"_false:\n";
        HashSet<Simbolo> newHashSet = new HashSet<>();
        stack.push(newHashSet);
        return visitChildren(ctx);
    }

    @Override
    public String visitValue_location(ProgramParser.Value_locationContext ctx) {
        String loc = ctx.location().getText();
        Simbolo s = searchSymbol(loc, stack);
        String elTemporal = null;
        if(s == null){
            String errorMessage = "Error en la linea: "+ ctx.getStart().getLine() +". La variable \"" + loc +"\" no ha sido creada aun.\n";
            if(!error.contains(errorMessage)){
                error+=errorMessage;
            }
        }else{
            elTemporal = "S[" +s.getOffset()+"]";
        }
        return visitChildren(ctx) + ", " +elTemporal;
    }

    public Stack<HashSet<Simbolo>> getStack() {
        return stack;
    }

    public String getError() {
        return error;
    }

    public void existeMain(){
        boolean existe = false;
        for (HashSet<Simbolo> h: stack) {
            for (Simbolo s:h) {
                if(s.getNombre().equals("main")){
                    if(s.getFirma().equals("")){
                        if(s.getTipo().equals("void")){
                            existe = true;
                        }
                    }
                }
            }
        }
        if(existe==false){
            error+="Se espero un metodo principal \"main\" de tipo void que no tuviera parametros.\n";
        }
    }

}