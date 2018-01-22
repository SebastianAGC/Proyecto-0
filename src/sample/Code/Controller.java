package sample.Code;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.AnchorPane;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.gui.TreeViewer;

//import org.antlr.v4.runtime.tree.gui.TreeViewer;


public class Controller {


    @FXML private TextArea eltext;
    @FXML private TreeView<String> treeView;
    @FXML private AnchorPane thePane;
    String program = "";

    public void compilarButtonClicked() {
        //String[] arg0 = { "-visitor", "S:\\Documents\\Grammar\\Hello.g4", "-package", "sample" };
        //org.antlr.v4.Tool.main(arg0);
        program = eltext.getText();
        compile(program);

    }

    public void compile(String expression) {

        //final LexerGrammar lg = (LexerGrammar) Grammar.load(HelloLexer);
        //final Grammar pg = Grammar.load(HelloParser, lg);
        //ANTLRStringStream input = new ANTLRStringStream(expression); // a character stream
        //HelloLexer lex = new HelloLexer((CharStream) input); // transforms characters into tokens
        //CommonTokenStream tokens = new CommonTokenStream((TokenSource) lex); // a token stream
        //HelloParser parser = new HelloParser((TokenStream) tokens); // transforms tokens into parse trees
        //ParserRuleContext<tokens> tree = parser.compilationUnit(); // parse
        //ParseTree t = parser.your_first_rule_name(); // creates the parse tree from the called rule
        //System.out.println("parse tree: " + t.toStringTree(parser));

        CharStream stream = new ANTLRInputStream(expression);
        calculatorLexer lexer  = new calculatorLexer(stream);
        TokenStream tokenStream = new CommonTokenStream(lexer);
        calculatorParser parser = new calculatorParser(tokenStream);
        ParseTree tree = parser.equation();

        //show AST in console
        System.out.println(tree.toStringTree(parser));

        //Show in GUI
        String raiz = tree.toStringTree(parser);
        String[] r = raiz.split(" ");
        r[0]=r[0].replace("(", "");
        TreeItem<String> root = new TreeItem<>(r[0]);
        ;
        //for (int i=0;i<tree.getChildCount();i++) {
           // TreeItem<String> child = new TreeItem<>(tree.getChild(i).getText());

            //root.getChildren().add(child);
        //}
        treeView.setRoot(treeGenerator(tree, root));
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