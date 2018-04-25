package sample.Code;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.stage.FileChooser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.fxmisc.richtext.CodeArea;
import org.fxmisc.richtext.LineNumberFactory;
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller implements Initializable {

    @FXML private TabPane tabPane;
    @FXML private CodeArea eltext;
    @FXML private TreeView<String> treeView;
    @FXML public TextArea errorsText;
    @FXML public TextArea intCodeText;
    String program = "";

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        eltext.setParagraphGraphicFactory(LineNumberFactory.get(eltext));
        errorsText.setWrapText(true);
    }

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
            eltext.replaceText(readFile(selectedFile));
        }
    }

    public void compilarButtonClicked() {
        errorsText.setText("");
        program = eltext.getText();
        compile(program);
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
                intCodeText.setText(eval.intCode);
                tabPane.getSelectionModel().select(2);

            }else{
                errorsText.setText(eval.getError());
                tabPane.getSelectionModel().select(1);
            }

        }catch(Exception e){
            String m = e.toString();
            errorsText.setText(m);
            tabPane.getSelectionModel().select(1);
        }

    }

    public TreeItem<String> generatingRoot(String tree, ParseTree treeP){
        TreeItem<String> root = new TreeItem<>("ARBOL SINTACTICO");
        TreeItem<String> mainChild = treeGenerator(treeP, root);
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