package sample.Code;

import javax.swing.*;
import java.nio.file.SimpleFileVisitor;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Stack;

public class EvalVisitor extends ProgramBaseVisitor<String> {

    Stack<HashSet<Simbolo>> stack = new Stack<>();
    HashSet<Simbolo> globalStack = new HashSet<>();
    String error = "";
    int ambito = 0;
    Stack<String> scopeName = new Stack<>();


    @Override

    public String visitClassDecl(ProgramParser.ClassDeclContext ctx){
        String ScopeName = ctx.ID().getText();
        HashSet<Simbolo> hashSet = new HashSet<>();
        scopeName.push(ScopeName);
        stack.push(hashSet);
        return visitChildren(ctx);
    }

    @Override
    //Metodo para verificar que una variable ya ha sido creada
    public String visitVarDecl_ID(ProgramParser.VarDecl_IDContext ctx){
        HashSet<Simbolo> hashSet = stack.pop();
        String tipo =ctx.varType().getText();
        String id = ctx.ID().getText();
        Simbolo s = new Simbolo(id, tipo, 0, ambito,null);
        if(hashSet.contains(s)){
            if(!error.contains("Error en la linea: "+ ctx.getStart().getLine() +". La variable  \"" + id + "\" ya ha sido creada en "+ scopeName.peek()+".\n")){
                error +="Error en la linea: "+ ctx.getStart().getLine() +". La variable  \"" + id + "\" ya ha sido creada en "+ scopeName.peek()+".\n";
            }
        }else{
            hashSet.add(s);
        }
        //Añadiendo la ultima hash set
        stack.push(hashSet);
        return visitChildren(ctx);
    }

    @Override

    public String visitStructDecl(ProgramParser.StructDeclContext ctx){
        String struct = ctx.STRUCT().getText();
        String id = ctx.ID().getText();
        HashSet<Simbolo> hashSet = stack.pop();
        Simbolo s = new Simbolo(id, struct, 0,ambito,null);
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
        Simbolo s = new Simbolo(id, type, 0, ambito, firm);
        if(hashSet.contains(s)){
            error += "Error en la linea: "+ ctx.getStart().getLine() +". El metodo \"" + id + "\" ya ha sido creado.\n";
        }else{
            hashSet.add(s);
        }
        stack.push(hashSet);

        //Creando la nueva tabla de simbolos para el metodo
        HashSet<Simbolo> newHashSet = new HashSet<>();
        stack.push(newHashSet);
        //visitChildren(ctx);
        //stack.pop();
        //scopeName.pop();
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
        String variable = ctx.ID().getText();
        boolean existe = false;
        for (HashSet<Simbolo> h:stack) {
            Simbolo s = new Simbolo(variable,null,0,ambito, null);
            if(h.contains(s) || globalStack.contains(s)){
                existe=true;
            }
        }
        if(existe==false){
            error +="Error en la linea: "+ ctx.getStart().getLine() +". La variable \"" + variable +"\" no ha sido creada aun.\n";
        }
        return visitChildren(ctx);
    }

    @Override
    public String visitLocationA(ProgramParser.LocationAContext ctx) {
        String variable = ctx.ID().getText();

        for (HashSet<Simbolo> h:stack) {
            //HashSet<Simbolo> hashSet = stack.peek();
            Simbolo s = new Simbolo(variable,null,0,ambito, null);
            if(!h.contains(s) ){
                error +="Error en la linea: "+ ctx.getStart().getLine() +". La variable \"" + variable +"\" no ha sido creada aun.\n";
            }
        }

        return visitChildren(ctx);
    }

    @Override
    //Metodo para verificar cuando un arreglo esta siendo declarado
    public String visitVarDecl_IDarray(ProgramParser.VarDecl_IDarrayContext ctx) {
        //JOptionPane.showMessageDialog(null,"Entre aca");
        String number = ctx.NUM().getText();
        int n = Integer.parseInt(number);

        Simbolo s = new Simbolo(ctx.ID().getText(),ctx.varType().getText(),n,ambito, null);
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
                    //Obtenidno los datos del parametro, tipo y ID
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
                        try{
                            String p = ctx.arg().get(i).getText();
                            if(paramType.equals("int")){
                                Integer.parseInt(p);
                            }else if(paramType.equals("boolean")){
                                if(!p.toLowerCase().equals("true") && !p.toLowerCase().equals("false")){
                                    error+="Error en la linea: "+ ctx.getStart().getLine() +". Los tipos en el parametro #" + x +" no coinciden. Se esperaba "+paramType+".\n";
                                }
                            }else{
                                //Saber que hacer para validar Chars
                            }
                        }catch (Exception e){
                            error+="Error en la linea: "+ ctx.getStart().getLine() +". Los tipos en el parametro #" + x +" no coinciden. Se esperaba "+paramType+".\n";
                        }
                    }else{
                        if(!elSim.getTipo().equals(paramType)){
                            int x = i+1;
                            error+="Error en la linea: "+ ctx.getStart().getLine() +". Los tipos en el parametro #" + x +" no coinciden. Se recibio " +elSim.getTipo()+", se esperaba "+paramType+".\n";
                        }
                    }
                }
            }else{
                error+="Error en la linea: "+ ctx.getStart().getLine() +". Se recibieron " + cantParam+" argumentos, se esperaban "+ paramSize+", en el metodo "+methodId+".\n";
            }
        }
        return visitChildren(ctx);
    }

    @Override public String visitStmt_return(ProgramParser.Stmt_returnContext ctx) {
        for(int i=0; i<ctx.expression().getChildCount();i++){
            System.out.println(ctx.expression().getChild(i).getText());
        }

        return visitChildren(ctx); }


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

    public Stack<HashSet<Simbolo>> getStack() {
        return stack;
    }

    public String getError() {
        return error;
    }

    public int getAmbito() {
        return ambito;
    }

    public void existeMain(){
        //JOptionPane.showMessageDialog(null,stack.size());
        boolean existe = false;
        for (HashSet<Simbolo> h: stack) {

            for (Simbolo s:h) {
                if(s.getNombre().equals("main")){
                    if(s.getFirma().equals("")){
                        existe = true;
                    }
                }
            }

        }

        if(existe==false){
            error+="Se espero un metodo principal \"main\" que no tuviera parametros.\n";
        }
    }
}

