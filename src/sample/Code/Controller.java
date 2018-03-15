package sample.Code;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.gui.TreeViewer;

import javax.print.PrintException;
import javax.print.attribute.standard.DialogTypeSelection;
import java.io.File;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.StageStyle;

import java.awt.*;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.*;
import java.io.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;

import javafx.scene.layout.VBox;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Controller {

    @FXML private TabPane tabPane;
    @FXML private TextArea eltext;
    @FXML private TreeView<String> treeView;
    @FXML public TextArea errorsText;
    String program = "";

    public void cargarGramatica(){
        FileChooser fileChooser = new FileChooser();
        // Set extension filter
        FileChooser.ExtensionFilter extFilter =
                new FileChooser.ExtensionFilter("TEXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);

        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("TEXT files (*.txt)", "*.txt"));
        fileChooser.setTitle("Open Grammar File");
        File selectedFile = fileChooser.showOpenDialog(null);
        if(selectedFile!=null){
            selectedFile.getAbsoluteFile();
            eltext.setText(readFile(selectedFile));
        }

    }

    public void compilarButtonClicked() {
        eltext.setPrefRowCount(100);
        errorsText.setText("");
        program = eltext.getText();
        compile(program);
        tabPane.getSelectionModel().selectNext();

    }

    private String readFile(File file){
        StringBuilder stringBuffer = new StringBuilder();
        BufferedReader bufferedReader = null;
        String cadena="";
        try {

            bufferedReader = new BufferedReader(new FileReader(file));
            bufferedReader.toString();
            String text;

            while ((text = bufferedReader.readLine()) != null) {
                stringBuffer.append(text);
                cadena+=text+"\n";
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return cadena;
    }

    public void compile(String expression) {

        try{

            errorsText.setText("");
            CharStream stream = CharStreams.fromString(expression);
            ProgramLexer lexer  = new ProgramLexer(stream);
            lexer.removeErrorListeners();
            lexer.addErrorListener(ThrowingErrorListener.INSTANCE);

            TokenStream tokenStream = new CommonTokenStream(lexer);
            ProgramParser parser = new ProgramParser(tokenStream);
            parser.removeErrorListeners();
            parser.addErrorListener(ThrowingErrorListener.INSTANCE);
            ParseTree tree = parser.program();

            EvalVisitor eval = new EvalVisitor();
            eval.visit(tree);
            eval.existeMain();

            if(eval.getError().equals("")){
                //show AST in console
                System.out.println(tree.toStringTree(parser));

                //Show in GUI
                String raiz = tree.toStringTree(parser);

                //treeView.setRoot(generatingRoot(raiz));
                treeView.setRoot(generatingRoot(raiz, tree));
                errorsText.setText(raiz);

            }else{
                errorsText.setText(eval.getError());
            }

        }catch(Exception e){
            String m = e.toString();
            errorsText.setText(m);
        }


        /*
        TreeViewer viewer = new TreeViewer(Arrays.asList(parser.getRuleNames()), tree);
        viewer.setBorderColor(Color.WHITE);
        viewer.setBoxColor(Color.WHITE);
        try {
            viewer.save("tree.jpg");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (PrintException e) {
            e.printStackTrace();
        }*/


    }

    public TreeItem<String> generatingRoot(String tree, ParseTree treeP){
        TreeItem<String> root = new TreeItem<>("ARBOL SINTACTICO");
        //TreeItem<String> mainChild = readTree(tree, root);
        TreeItem<String> mainChild = treeGenerator(treeP, root);
        //root.getChildren().add(mainChild);
        return mainChild;
    }

    public TreeItem<String> readTree(String tree, TreeItem<String> root){
        TreeItem<String> child = new TreeItem<>();
        String evaluatedChar;
        String childContent = "";
        int contAbierto=0;
        int contCerrado=0;
        int indicador=0;
        int j=0;
        for(int i=0;i<tree.length();i++){
            evaluatedChar = String.valueOf(tree.charAt(i));
            if(evaluatedChar.equals("(")){
                //hacer si se abre nuevas llaves
                contAbierto++;
                j=i;
                while(contAbierto!=contCerrado){
                    j++;
                    evaluatedChar = String.valueOf(tree.charAt(j));
                    if(evaluatedChar.equals(")")){
                        contCerrado++;
                        indicador=j;
                    }else
                    if(evaluatedChar.equals("(")){
                        contAbierto++;
                    }else if(!evaluatedChar.equals(" ")){

                    }

                }

                child = readTree(tree.substring(i+1, indicador), child);
                i=indicador;
                //root.getChildren().add(child);
                contAbierto=0;
                contCerrado=0;

            }else if(evaluatedChar.equals(")")){
                //hacer si se cierra.
                child = new TreeItem<>(childContent);
                root.getChildren().add(child);
                childContent="";
            }else if(evaluatedChar.equals(" ")){
                //hacer si vacio
                if(!String.valueOf(tree.charAt(i+1)).equals(")")){
                    child = new TreeItem<>(childContent);
                    root.getChildren().add(child);
                    childContent="";
                }

                root.getChildren().add(readTree(tree.substring(i+1), child));
            }else{
                childContent+=evaluatedChar;
                if(i==tree.length()-1){
                    child = new TreeItem<>(childContent);
                    root.getChildren().add(child);
                }
             }
        }

        return root;
    }

    public TreeItem<String> treeGenerator(ParseTree t, TreeItem<String> root){
        for (int i=0;i<t.getChildCount();i++) {
            if(t.getChild(i).getChildCount()>0){
                TreeItem<String> rChild = new TreeItem<>();
                root.getChildren().add(treeGenerator(t.getChild(i),rChild));
            }else{
                TreeItem<String> child = new TreeItem<>(t.getChild(i).getText());
                root.getChildren().add(child);
            }
        }
        return root;
    }

}