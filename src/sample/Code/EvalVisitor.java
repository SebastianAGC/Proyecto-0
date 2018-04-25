package sample.Code;

import java.util.HashSet;
import java.util.Stack;

public class EvalVisitor extends ProgramBaseVisitor<String> {

    Stack<HashSet<Simbolo>> stack = new Stack<>();
    HashSet<Simbolo> globalStack = new HashSet<>();
    String methodT="";
    String error = "";
    int memory = 0;
    int offset;
    int contTemps = 0;
    String intCode = "";
    String elTemporal = "";
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
    * Metodo para crear una nueva estructura.
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
                    pType = parametro.substring(0,3);
                    pId = parametro.substring(3);
                }else if(parametro.contains("char")){
                    pType = parametro.substring(0,4);
                    pId = parametro.substring(4);
                }else{
                    pType = parametro.substring(0,7);
                    pId = parametro.substring(7);
                }
                firm+=pType+" "+pId +", ";
            }
            System.out.println(firm);
        }
        scopeName.push(id);

        HashSet<Simbolo>  hashSet = stack.pop();
        Simbolo s = new Simbolo(id, type, 0, offset, firm);
        if(hashSet.contains(s)){
            error += "Error en la linea: "+ ctx.getStart().getLine() +". El metodo \"" + id + "\" ya ha sido creado.\n";
        }else{
            hashSet.add(s);
            methodT = type;
            intCode += s.nombre + ":\n";
        }
        stack.push(hashSet);

        //Creando la nueva tabla de simbolos para el metodo
        HashSet<Simbolo> newHashSet = new HashSet<>();
        stack.push(newHashSet);
        return visitChildren(ctx);
    }

    @Override
    public String visitFinblck(ProgramParser.FinblckContext ctx) {
        stack.pop();
        scopeName.pop();
        return visitChildren(ctx);
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

        for (HashSet<Simbolo> h:stack) {
            //HashSet<Simbolo> hashSet = stack.peek();
            Simbolo s = new Simbolo(variable,null,0, offset, null);
            if(!h.contains(s) ){
                String errorMessage ="Error en la linea: "+ ctx.getStart().getLine() +". La variable \"" + variable
                        +"\" no ha sido creada aun.\n";
                if(!error.contains(errorMessage)){
                    error +=errorMessage;
                }
            }else{
                for (Simbolo symbol:h) {
                    if(symbol.equals(s)){
                        theSymbol = symbol;
                    }
                }
            }
        }
        if(theSymbol!=null){
            locationArrayType = theSymbol.getTipo();
            visitChildren(ctx);
        }else{
            visitChildren(ctx);
        }


        return locationArrayType;
    }

    @Override
    //Metodo para verificar cuando un arreglo esta siendo declarado
    public String visitVarDecl_IDarray(ProgramParser.VarDecl_IDarrayContext ctx) {
        //JOptionPane.showMessageDialog(null,"Entre aca");
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
            }
        }
        return visitChildren(ctx);
    }

    @Override
    //Metodo para verificar cuando un metodo esta siendo declarado
    public String visitCallingMethod(ProgramParser.CallingMethodContext ctx) {
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
                        if(paramType.equals("int")){
                            if(!visit(ctx.arg().get(i)).equals("int")){
                                errorMessage="Error en la linea: "+ ctx.getStart().getLine() +". Los tipos en el parametro #" + x +" no coinciden. Se esperaba "+paramType+".\n";
                            }
                        }else if(paramType.equals("boolean")){
                            if(!visit(ctx.arg().get(i)).equals("boolean")){
                                errorMessage="Error en la linea: "+ ctx.getStart().getLine() +". Los tipos en el parametro #" + x +" no coinciden. Se esperaba "+paramType+".\n";
                            }
                        }else if(paramType.equals("char")){
                             if(!visit(ctx.arg().get(i)).equals("char")){
                                 errorMessage="Error en la linea: "+ ctx.getStart().getLine() +". Los tipos en el parametro #" + x +" no coinciden. Se esperaba "+paramType+".\n";
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
                        }
                    }
                }
                methodType=t.getTipo();

                visitChildren(ctx);
            }else{
                error+="Error en la linea: "+ ctx.getStart().getLine() +". Se recibieron " + cantParam+" argumentos, se esperaban "+ paramSize+", en el metodo "+methodId+".\n";
                visitChildren(ctx);
            }
        }
        return methodType;
    }

    @Override
    public String visitArgs(ProgramParser.ArgsContext ctx){
        String argsType = visit(ctx.expression());
        visitChildren(ctx);
        return argsType;
    }

    //***********************************LOCATION************************************
    @Override
    public  String visitStmt_location(ProgramParser.Stmt_locationContext ctx) {
        String expressionType = visit(ctx.expression());
        String locationType = visit(ctx.location());
        String errorMessage = "Error en la linea: " +ctx.getStart().getLine()+", Los tipos en " +
                "la asignacion no coinciden. No se puede asignar \"" + expressionType +"\" a \"" +
                locationType + "\"\n";
        if(!expressionType.equals(locationType)){
            if(!error.contains(errorMessage)){
              error+=errorMessage;
            }
        }else{
            HashSet<Simbolo> table = stack.peek();
            for (Simbolo s: table) {
                String loc = ctx.location().getText();
                if(s.getNombre().equals(loc)){
                    intCode+= "S[" + s.getOffset() + "] = " + elTemporal + "\n";
                }
            }
        }
        //se cambio return
        return "";
    }

    @Override
    public String visitExp_andExpr(ProgramParser.Exp_andExprContext ctx){
        //Retornando el tipo el tipo
        String tipo = visitChildren(ctx);
        String temporalAndExpr = elTemporal;
        //contTemps++;
        //intCode+= "t" + contTemps + " = " + temporalAndExpr + "\n";
        return tipo;
    }
    @Override
    public String visitIntegers(ProgramParser.IntegersContext ctx) {
        //Retornando el tipo int
        String tipo = "int";
        elTemporal = ctx.getText();
        return tipo;
    }


    @Override
    public String visitChars(ProgramParser.CharsContext ctx) {
        String tipo = "char";
        elTemporal = ctx.getText();
        return tipo;
    }

    @Override
    public String visitBool_true(ProgramParser.Bool_trueContext ctx) {
        //Retornando tipo booleano
        String tipo = "boolean";
        elTemporal = tipo;
        return tipo;
    }

    @Override
    public String visitBool_false(ProgramParser.Bool_falseContext ctx) {
        //Retornando tipo boolean
        String tipo = "boolean";
        elTemporal = tipo;
        return tipo;
    }

    @Override
    public String visitExp_condOp(ProgramParser.Exp_condOpContext ctx) {
        int cont = 0;
        String andExprType = visit(ctx.andExpr());
        String andExprTemp = elTemporal;

        String expressionType = visit(ctx.expression());

        String expressionTemp = elTemporal;
        String errorMessage = "";
        if(!andExprType.equals("boolean")){
            errorMessage="Error en la linea: " + ctx.getStart().getLine() +
                    ", \"" + ctx.andExpr().getText() + " debe de ser del tipo boolean.\n";
            if(!error.contains(errorMessage)){
                error+=errorMessage;
                cont++;
            }
        }else{
            cont++;
        }

        if(!expressionType.equals("boolean")){
            errorMessage="Error en la linea: " + ctx.getStart().getLine() +
                    ", \"" + ctx.expression().getText() + "\" debe de ser del tipo boolean.\n";
            if(!error.contains(errorMessage)){
                error+=errorMessage;
            }
        }else{
            cont++;
        }
        if(cont==2){
            contTemps++;
            intCode+= "t" + contTemps + " = " + andExprTemp + ctx.cond_op().getText() + expressionTemp + "\n";
            elTemporal = "t"+contTemps;
        }
        return visitChildren(ctx);
    }

    @Override
    public String visitAnd_condOp(ProgramParser.And_condOpContext ctx){
        int cont = 0;
        String andExprType = visit(ctx.andExpr());
        String andExprTemp = elTemporal;

        String eqrExprType = visit(ctx.eqExpr());
        String eqrExprTemp = elTemporal;

        String errorMessage ="";
        if(!andExprType.equals("boolean")){
            errorMessage="Error en la linea: " + ctx.getStart().getLine() +
                    ", \"" + ctx.andExpr().getText() + "\" debe de ser del tipo boolean.\n";
            if(!error.contains(errorMessage)){
                error+=errorMessage;
            }
        }else{
            cont++;
        }

        if(!eqrExprType.equals("boolean")){
            errorMessage="Error en la linea: " + ctx.getStart().getLine() +
                    ", \"" + ctx.eqExpr().getText() + "\" debe de ser del tipo boolean.\n";
            if(!error.contains(errorMessage)){
                error+=errorMessage;
            }
        }else{
            cont++;
        }
        if(cont==2){
            contTemps++;
            intCode+= "t" + contTemps + " = " + andExprTemp + ctx.cond_op().getText() + eqrExprTemp + "\n";
            elTemporal = "t"+contTemps;
        }

        return visitChildren(ctx);
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
        int cont = 0;
        String tipo = null;
        String eqExprType = visit(ctx.eqExpr());
        String eqExprTemp = elTemporal;

        String relationExprType = visit(ctx.relationExpr());
        String relationExprTemp = elTemporal;

        if(!eqExprType.equals(relationExprType)){
            String errorMessage="Error en la linea: " + ctx.getStart().getLine() +
                    ", Los tipos no son compatibles.\n";
            if(!error.contains(errorMessage)){
                error+=errorMessage;
            }
        }else{
            contTemps++;
            intCode+= "t" + contTemps + " = " + eqExprTemp + ctx.eq_op().getText() + relationExprTemp + "\n";
            elTemporal = "t"+contTemps;
            visitChildren(ctx);
            tipo = "boolean";
        }
        return tipo;
    }


    //****************************rel-op*************************************
    @Override
    public String visitRelExpr_relOp(ProgramParser.RelExpr_relOpContext ctx){
        int correctos =0;
        String tipo = null;
        String relationExprType = visit(ctx.relationExpr());
        String relationExprTemp = elTemporal;

        String addExprType = visit(ctx.addExpr());
        String addExprTemp = elTemporal;

        String errorMessage ="";
        if(!relationExprType.equals("int")){
            errorMessage="Error en la linea: " + ctx.getStart().getLine() +
                    ", \"" + ctx.relationExpr().getText() + "\" debe de ser del tipo int.\n";
            if(!error.contains(errorMessage)){
                error+=errorMessage;
            }
        }else{
            correctos++;
        }

        if(!addExprType.equals("int")){
            errorMessage="Error en la linea: " + ctx.getStart().getLine() +
                    ", \"" + ctx.addExpr().getText() + "\" debe de ser del tipo int.\n";
            if(!error.contains(errorMessage)){
                error+=errorMessage;
            }
        }else{
            correctos++;
        }
        if(correctos==2){
            contTemps++;
            intCode+= "t" + contTemps + " = " + relationExprTemp + ctx.rel_op().getText() + addExprTemp + "\n";
            elTemporal = "t"+contTemps;
            visitChildren(ctx);
            tipo = "boolean";
        }
        return tipo;
    }

    @Override
    public String visitAddExpr_arithOp(ProgramParser.AddExpr_arithOpContext ctx){
        int cont = 0;
        String addExprType = visit(ctx.addExpr());
        String addExprTemp = elTemporal;

        String multExprType = visit(ctx.multExpr());
        String multExprTemp = elTemporal;

        String errorMessage ="";
        if(!addExprType.equals("int")){
            errorMessage="Error en la linea: " + ctx.getStart().getLine() +
                    ", \"" + ctx.addExpr().getText() + "\" debe de ser del tipo int.\n";
            if(!error.contains(errorMessage)){
                error+=errorMessage;
            }
        }else{
            cont++;
        }
        if(!multExprType.equals("int")){
            errorMessage="Error en la linea: " + ctx.getStart().getLine() +
                    ", \"" + ctx.multExpr().getText() + "\" debe de ser del tipo int.\n";
            if(!error.contains(errorMessage)){
                error+=errorMessage;
            }
        }else{
            cont++;
        }

        if(cont==2){
            contTemps++;
            intCode+= "t" + contTemps + " = " + addExprTemp + ctx.arith_op().getText() + multExprTemp + "\n";
            elTemporal = "t"+contTemps;
        }

        return visitChildren(ctx);
    }

    @Override
    public String visitMultExpr_arithOp(ProgramParser.MultExpr_arithOpContext ctx){
        int cont = 0;
        String multExprType = visit(ctx.multExpr());
        String multExprTemp = elTemporal;

        String unaryExprType = visit(ctx.unaryExpr());
        String unaryExprTemp = elTemporal;

        String errorMessage ="";
        if(!multExprType.equals("int")){
            errorMessage="Error en la linea: " + ctx.getStart().getLine() +
                    ", \"" + ctx.multExpr().getText() + "\" debe de ser del tipo int.\n";
            if(!error.contains(errorMessage)){
                error+=errorMessage;
            }
        }else{
            cont++;
        }

        if(!unaryExprType.equals("int")){
            errorMessage="Error en la linea: " + ctx.getStart().getLine() +
                    ", \"" + ctx.unaryExpr().getText() + "\" debe de ser del tipo int.\n";
            if(!error.contains(errorMessage)){
                error+=errorMessage;
            }
        }else{
            cont++;
        }

        if(cont==2){
            contTemps++;
            intCode+= "t" + contTemps + " = " + multExprTemp + ctx.arith_op().getText() + unaryExprTemp + "\n";
            elTemporal = "t"+contTemps;
        }

        return visitChildren(ctx);
    }

    //*******************************if************************************

    @Override
    public String visitStmt_if(ProgramParser.Stmt_ifContext ctx){
        String expressionType = visit(ctx.expression());
        if(!expressionType.equals("boolean")){
            String errorMessage="Error en la linea: " + ctx.getStart().getLine() +
                    ", \"" + ctx.expression().getText() + "\" debe de ser del tipo boolean.\n";
            if(!error.contains(errorMessage)){
                error+=errorMessage;
            }
        }
            //Creando la nueva tabla de simbolos para el metodo
            HashSet<Simbolo> newHashSet = new HashSet<>();
            stack.push(newHashSet);
        return visitChildren(ctx);
    }

    @Override
    public String visitStmt_while(ProgramParser.Stmt_whileContext ctx){
        String expressionType = visit(ctx.expression());
        if(!expressionType.equals("boolean")){
            String errorMessage="Error en la linea: " + ctx.getStart().getLine() +
                    ", \"" + ctx.expression().getText() + "\" debe de ser del tipo boolean.\n";
            if(!error.contains(errorMessage)){
                error+=errorMessage;
            }
        }
            //Creando la nueva tabla de simbolos para el metodo
            HashSet<Simbolo> newHashSet = new HashSet<>();
            stack.push(newHashSet);

        return visitChildren(ctx);
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

    @Override
    public String visitStmt_return(ProgramParser.Stmt_returnContext ctx) {
        String methodType = methodT;
        String returnType = visit(ctx.expression());
        String errorMessage = "";
        if(methodType.equals("void")){
            errorMessage = "Error en la linea: "+ctx.getStart().getLine()+
                    ", El metodo no puede contener \"return\" si es de tipo void. \n";
            if(!error.contains(errorMessage)){
                error+=errorMessage;
            }
        }else if(!methodType.equals(returnType)){
            errorMessage = "Error en la linea: "+ctx.getStart().getLine()+
                    ", El tipo de \"return\" y del metodo debe ser el mismo. \n";
            if(!error.contains(errorMessage)){
                error+=errorMessage;
            }
        }

        return visitChildren(ctx);
    }

    //*********************RETURN METHOD CALL***********************************
    @Override
    public String visitValue_methodCall(ProgramParser.Value_methodCallContext ctx){
        String methodType = visit(ctx.methodCall());
        if(methodType.equals("void")){
            String errorMessage = "Error en la linea: " + ctx.getStart().getLine()+
                    ", El tipo de retorno del metodo debe ser distinto de void.\n";
            if(!error.contains(errorMessage)){
                error+=errorMessage;
            }
        }
        return visitChildren(ctx);
    }

    @Override
    public String visitStmtElse(ProgramParser.StmtElseContext ctx){
        //Creando la nueva tabla de simbolos para el metodo
        HashSet<Simbolo> newHashSet = new HashSet<>();
        stack.push(newHashSet);
        return visitChildren(ctx);
    }

    @Override public String visitValue_location(ProgramParser.Value_locationContext ctx) {
        String loc = ctx.location().getText();
        Simbolo s = searchSymbol(loc, stack);
        elTemporal = "S[" +s.getOffset()+"]";
        /*
        HashSet<Simbolo> h = stack.peek();
        for (Simbolo s:h) {
            if(s.getNombre().equals(loc)){
                elTemporal = "S[" +s.getOffset()+"]";
            }
        }*/
        return visitChildren(ctx);
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

