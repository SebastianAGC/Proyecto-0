package sample.Code;

import javax.swing.*;
import java.util.HashSet;
import java.util.Hashtable;
public class EvalVisitor extends ProgramBaseVisitor<String> {

    HashSet<Simbolo> hashSet = new HashSet<>();

    @Override

    public String visitVarDecl_ID(ProgramParser.VarDecl_IDContext ctx){
        String error ="";
        String tipo =" de tipo " + ctx.varType().getText();
        String id = ctx.ID().getText();
        Simbolo s = new Simbolo(id, tipo, 0, "");
        if(hashSet.contains(s)){
            error = "La variable " + id + " ya ha sido creada.";
            JOptionPane.showMessageDialog(null,error);
        }else{
            hashSet.add(s);
        }
        return error;
    }

}

