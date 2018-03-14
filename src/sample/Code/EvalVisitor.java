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
        scopeName.add(ScopeName);
        stack.push(hashSet);
        return visitChildren(ctx);
    }

    @Override
    //Metodo para verificar que una variable ya ha sido creada
    public String visitVarDecl_ID(ProgramParser.VarDecl_IDContext ctx){
        //Obteniendo el ultimo hashset del stack
        //if(ctx.parent.parent.getText().contains("class")){
           /* String tipo =" de tipo " + ctx.varType().getText();
            String id = ctx.ID().getText();
            Simbolo s = new Simbolo(id, tipo, 0, null);
            if(globalStack.contains(s)){
                error += "La variable  \"" + id + "\" ya ha sido creada en "+ scopeName.peek()+".\n";
            }else{
                globalStack.add(s);
            }*/
        //}else{
            HashSet<Simbolo> hashSet = stack.pop();
            String tipo =" de tipo " + ctx.varType().getText();
            String id = ctx.ID().getText();
            Simbolo s = new Simbolo(id, tipo, 0, null);
            if(hashSet.contains(s)){
                error += "La variable  \"" + id + "\" ya ha sido creada en "+ scopeName.peek()+".\n";
            }else{
                hashSet.add(s);
            }
            //Añadiendo la ultima hash set
            stack.push(hashSet);
        //}



        return visitChildren(ctx);
    }

    @Override

    public String visitStructDecl(ProgramParser.StructDeclContext ctx){
        String struct = ctx.STRUCT().getText();
        String id = ctx.ID().getText();
        HashSet<Simbolo> hashSet = stack.pop();
        Simbolo s = new Simbolo(id, struct, ambito,null);
        if(hashSet.contains(s)){
            error += "La estructura " + id + " ya ha sido creada.\n";
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
        scopeName.add(id);

        HashSet<Simbolo>  hashSet = stack.pop();
        Simbolo s = new Simbolo(id, type, ambito, firm);
        if(hashSet.contains(s)){
            error += "El metodo \"" + id + "\" ya ha sido creado.\n";
        }else{
            hashSet.add(s);
        }
        stack.push(hashSet);
        HashSet<Simbolo> newHashSet = new HashSet<>();
        stack.push(newHashSet);
        visitChildren(ctx);
        stack.pop();
        return visitChildren(ctx);
    }

    @Override
    public String visitLocation_id(ProgramParser.Location_idContext ctx) {
        String variable = ctx.ID().getText();
        boolean existe = false;
        for (HashSet<Simbolo> h:stack) {
            Simbolo s = new Simbolo(variable,null,ambito, null);
            if(h.contains(s) || globalStack.contains(s)){
                existe=true;
            }
        }
        if(existe==false){
            error +="La variable \"" + variable +"\" no ha sido creada aun.\n";
        }
        return visitChildren(ctx);
    }

    @Override
    public String visitLocationA(ProgramParser.LocationAContext ctx) {
        String variable = ctx.ID().getText();

        for (HashSet<Simbolo> h:stack) {
            //HashSet<Simbolo> hashSet = stack.peek();
            Simbolo s = new Simbolo(variable,null,ambito, null);
            if(!h.contains(s) ){
                error +="La variable \"" + variable +"\" no ha sido creada aun.\n";
            }
        }

        return visitChildren(ctx);
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
        JOptionPane.showMessageDialog(null,stack.size());
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

