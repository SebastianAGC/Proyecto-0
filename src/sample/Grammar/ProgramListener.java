// Generated from Program.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.tree.ParseTreeListener;
import sample.Code.ProgramParser;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ProgramParser}.
 */
public interface ProgramListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code classDecl}
	 * labeled alternative in {@link ProgramParser#program}.
	 * @param ctx the parse tree
	 */
	void enterClassDecl(ProgramParser.ClassDeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code classDecl}
	 * labeled alternative in {@link ProgramParser#program}.
	 * @param ctx the parse tree
	 */
	void exitClassDecl(ProgramParser.ClassDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code decl_structDeclaration}
	 * labeled alternative in {@link ProgramParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDecl_structDeclaration(ProgramParser.Decl_structDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code decl_structDeclaration}
	 * labeled alternative in {@link ProgramParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDecl_structDeclaration(ProgramParser.Decl_structDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code decl_varDeclaration}
	 * labeled alternative in {@link ProgramParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDecl_varDeclaration(ProgramParser.Decl_varDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code decl_varDeclaration}
	 * labeled alternative in {@link ProgramParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDecl_varDeclaration(ProgramParser.Decl_varDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code decl_methodDeclaration}
	 * labeled alternative in {@link ProgramParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDecl_methodDeclaration(ProgramParser.Decl_methodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code decl_methodDeclaration}
	 * labeled alternative in {@link ProgramParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDecl_methodDeclaration(ProgramParser.Decl_methodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varDecl_ID}
	 * labeled alternative in {@link ProgramParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVarDecl_ID(ProgramParser.VarDecl_IDContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varDecl_ID}
	 * labeled alternative in {@link ProgramParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVarDecl_ID(ProgramParser.VarDecl_IDContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varDecl_IDarray}
	 * labeled alternative in {@link ProgramParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVarDecl_IDarray(ProgramParser.VarDecl_IDarrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varDecl_IDarray}
	 * labeled alternative in {@link ProgramParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVarDecl_IDarray(ProgramParser.VarDecl_IDarrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code structDecl}
	 * labeled alternative in {@link ProgramParser#structDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterStructDecl(ProgramParser.StructDeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code structDecl}
	 * labeled alternative in {@link ProgramParser#structDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitStructDecl(ProgramParser.StructDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code var_int}
	 * labeled alternative in {@link ProgramParser#varType}.
	 * @param ctx the parse tree
	 */
	void enterVar_int(ProgramParser.Var_intContext ctx);
	/**
	 * Exit a parse tree produced by the {@code var_int}
	 * labeled alternative in {@link ProgramParser#varType}.
	 * @param ctx the parse tree
	 */
	void exitVar_int(ProgramParser.Var_intContext ctx);
	/**
	 * Enter a parse tree produced by the {@code var_char}
	 * labeled alternative in {@link ProgramParser#varType}.
	 * @param ctx the parse tree
	 */
	void enterVar_char(ProgramParser.Var_charContext ctx);
	/**
	 * Exit a parse tree produced by the {@code var_char}
	 * labeled alternative in {@link ProgramParser#varType}.
	 * @param ctx the parse tree
	 */
	void exitVar_char(ProgramParser.Var_charContext ctx);
	/**
	 * Enter a parse tree produced by the {@code var_boolean}
	 * labeled alternative in {@link ProgramParser#varType}.
	 * @param ctx the parse tree
	 */
	void enterVar_boolean(ProgramParser.Var_booleanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code var_boolean}
	 * labeled alternative in {@link ProgramParser#varType}.
	 * @param ctx the parse tree
	 */
	void exitVar_boolean(ProgramParser.Var_booleanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code var_structID}
	 * labeled alternative in {@link ProgramParser#varType}.
	 * @param ctx the parse tree
	 */
	void enterVar_structID(ProgramParser.Var_structIDContext ctx);
	/**
	 * Exit a parse tree produced by the {@code var_structID}
	 * labeled alternative in {@link ProgramParser#varType}.
	 * @param ctx the parse tree
	 */
	void exitVar_structID(ProgramParser.Var_structIDContext ctx);
	/**
	 * Enter a parse tree produced by the {@code var_structDecl}
	 * labeled alternative in {@link ProgramParser#varType}.
	 * @param ctx the parse tree
	 */
	void enterVar_structDecl(ProgramParser.Var_structDeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code var_structDecl}
	 * labeled alternative in {@link ProgramParser#varType}.
	 * @param ctx the parse tree
	 */
	void exitVar_structDecl(ProgramParser.Var_structDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code var_void}
	 * labeled alternative in {@link ProgramParser#varType}.
	 * @param ctx the parse tree
	 */
	void enterVar_void(ProgramParser.Var_voidContext ctx);
	/**
	 * Exit a parse tree produced by the {@code var_void}
	 * labeled alternative in {@link ProgramParser#varType}.
	 * @param ctx the parse tree
	 */
	void exitVar_void(ProgramParser.Var_voidContext ctx);
	/**
	 * Enter a parse tree produced by the {@code methodDecl}
	 * labeled alternative in {@link ProgramParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMethodDecl(ProgramParser.MethodDeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code methodDecl}
	 * labeled alternative in {@link ProgramParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMethodDecl(ProgramParser.MethodDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code method_int}
	 * labeled alternative in {@link ProgramParser#methodType}.
	 * @param ctx the parse tree
	 */
	void enterMethod_int(ProgramParser.Method_intContext ctx);
	/**
	 * Exit a parse tree produced by the {@code method_int}
	 * labeled alternative in {@link ProgramParser#methodType}.
	 * @param ctx the parse tree
	 */
	void exitMethod_int(ProgramParser.Method_intContext ctx);
	/**
	 * Enter a parse tree produced by the {@code method_char}
	 * labeled alternative in {@link ProgramParser#methodType}.
	 * @param ctx the parse tree
	 */
	void enterMethod_char(ProgramParser.Method_charContext ctx);
	/**
	 * Exit a parse tree produced by the {@code method_char}
	 * labeled alternative in {@link ProgramParser#methodType}.
	 * @param ctx the parse tree
	 */
	void exitMethod_char(ProgramParser.Method_charContext ctx);
	/**
	 * Enter a parse tree produced by the {@code method_boolean}
	 * labeled alternative in {@link ProgramParser#methodType}.
	 * @param ctx the parse tree
	 */
	void enterMethod_boolean(ProgramParser.Method_booleanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code method_boolean}
	 * labeled alternative in {@link ProgramParser#methodType}.
	 * @param ctx the parse tree
	 */
	void exitMethod_boolean(ProgramParser.Method_booleanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code method_void}
	 * labeled alternative in {@link ProgramParser#methodType}.
	 * @param ctx the parse tree
	 */
	void enterMethod_void(ProgramParser.Method_voidContext ctx);
	/**
	 * Exit a parse tree produced by the {@code method_void}
	 * labeled alternative in {@link ProgramParser#methodType}.
	 * @param ctx the parse tree
	 */
	void exitMethod_void(ProgramParser.Method_voidContext ctx);
	/**
	 * Enter a parse tree produced by the {@code param_ID}
	 * labeled alternative in {@link ProgramParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParam_ID(ProgramParser.Param_IDContext ctx);
	/**
	 * Exit a parse tree produced by the {@code param_ID}
	 * labeled alternative in {@link ProgramParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParam_ID(ProgramParser.Param_IDContext ctx);
	/**
	 * Enter a parse tree produced by the {@code param_ID_dots}
	 * labeled alternative in {@link ProgramParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParam_ID_dots(ProgramParser.Param_ID_dotsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code param_ID_dots}
	 * labeled alternative in {@link ProgramParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParam_ID_dots(ProgramParser.Param_ID_dotsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code param_int}
	 * labeled alternative in {@link ProgramParser#parameterType}.
	 * @param ctx the parse tree
	 */
	void enterParam_int(ProgramParser.Param_intContext ctx);
	/**
	 * Exit a parse tree produced by the {@code param_int}
	 * labeled alternative in {@link ProgramParser#parameterType}.
	 * @param ctx the parse tree
	 */
	void exitParam_int(ProgramParser.Param_intContext ctx);
	/**
	 * Enter a parse tree produced by the {@code param_char}
	 * labeled alternative in {@link ProgramParser#parameterType}.
	 * @param ctx the parse tree
	 */
	void enterParam_char(ProgramParser.Param_charContext ctx);
	/**
	 * Exit a parse tree produced by the {@code param_char}
	 * labeled alternative in {@link ProgramParser#parameterType}.
	 * @param ctx the parse tree
	 */
	void exitParam_char(ProgramParser.Param_charContext ctx);
	/**
	 * Enter a parse tree produced by the {@code param_boolean}
	 * labeled alternative in {@link ProgramParser#parameterType}.
	 * @param ctx the parse tree
	 */
	void enterParam_boolean(ProgramParser.Param_booleanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code param_boolean}
	 * labeled alternative in {@link ProgramParser#parameterType}.
	 * @param ctx the parse tree
	 */
	void exitParam_boolean(ProgramParser.Param_booleanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code blck}
	 * labeled alternative in {@link ProgramParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlck(ProgramParser.BlckContext ctx);
	/**
	 * Exit a parse tree produced by the {@code blck}
	 * labeled alternative in {@link ProgramParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlck(ProgramParser.BlckContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stmt_if}
	 * labeled alternative in {@link ProgramParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStmt_if(ProgramParser.Stmt_ifContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stmt_if}
	 * labeled alternative in {@link ProgramParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStmt_if(ProgramParser.Stmt_ifContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stmt_while}
	 * labeled alternative in {@link ProgramParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStmt_while(ProgramParser.Stmt_whileContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stmt_while}
	 * labeled alternative in {@link ProgramParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStmt_while(ProgramParser.Stmt_whileContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stmt_return}
	 * labeled alternative in {@link ProgramParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStmt_return(ProgramParser.Stmt_returnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stmt_return}
	 * labeled alternative in {@link ProgramParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStmt_return(ProgramParser.Stmt_returnContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stmt_methodCall}
	 * labeled alternative in {@link ProgramParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStmt_methodCall(ProgramParser.Stmt_methodCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stmt_methodCall}
	 * labeled alternative in {@link ProgramParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStmt_methodCall(ProgramParser.Stmt_methodCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stmt_block}
	 * labeled alternative in {@link ProgramParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStmt_block(ProgramParser.Stmt_blockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stmt_block}
	 * labeled alternative in {@link ProgramParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStmt_block(ProgramParser.Stmt_blockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stmt_location}
	 * labeled alternative in {@link ProgramParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStmt_location(ProgramParser.Stmt_locationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stmt_location}
	 * labeled alternative in {@link ProgramParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStmt_location(ProgramParser.Stmt_locationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stmt_locationArray}
	 * labeled alternative in {@link ProgramParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStmt_locationArray(ProgramParser.Stmt_locationArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stmt_locationArray}
	 * labeled alternative in {@link ProgramParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStmt_locationArray(ProgramParser.Stmt_locationArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stmt_expression}
	 * labeled alternative in {@link ProgramParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStmt_expression(ProgramParser.Stmt_expressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stmt_expression}
	 * labeled alternative in {@link ProgramParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStmt_expression(ProgramParser.Stmt_expressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stmtElse}
	 * labeled alternative in {@link ProgramParser#statementElse}.
	 * @param ctx the parse tree
	 */
	void enterStmtElse(ProgramParser.StmtElseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stmtElse}
	 * labeled alternative in {@link ProgramParser#statementElse}.
	 * @param ctx the parse tree
	 */
	void exitStmtElse(ProgramParser.StmtElseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code location_id}
	 * labeled alternative in {@link ProgramParser#location}.
	 * @param ctx the parse tree
	 */
	void enterLocation_id(ProgramParser.Location_idContext ctx);
	/**
	 * Exit a parse tree produced by the {@code location_id}
	 * labeled alternative in {@link ProgramParser#location}.
	 * @param ctx the parse tree
	 */
	void exitLocation_id(ProgramParser.Location_idContext ctx);
	/**
	 * Enter a parse tree produced by the {@code locationMember_ID}
	 * labeled alternative in {@link ProgramParser#locationMember}.
	 * @param ctx the parse tree
	 */
	void enterLocationMember_ID(ProgramParser.LocationMember_IDContext ctx);
	/**
	 * Exit a parse tree produced by the {@code locationMember_ID}
	 * labeled alternative in {@link ProgramParser#locationMember}.
	 * @param ctx the parse tree
	 */
	void exitLocationMember_ID(ProgramParser.LocationMember_IDContext ctx);
	/**
	 * Enter a parse tree produced by the {@code locationMember_locArray}
	 * labeled alternative in {@link ProgramParser#locationMember}.
	 * @param ctx the parse tree
	 */
	void enterLocationMember_locArray(ProgramParser.LocationMember_locArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code locationMember_locArray}
	 * labeled alternative in {@link ProgramParser#locationMember}.
	 * @param ctx the parse tree
	 */
	void exitLocationMember_locArray(ProgramParser.LocationMember_locArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code locationA}
	 * labeled alternative in {@link ProgramParser#locationArray}.
	 * @param ctx the parse tree
	 */
	void enterLocationA(ProgramParser.LocationAContext ctx);
	/**
	 * Exit a parse tree produced by the {@code locationA}
	 * labeled alternative in {@link ProgramParser#locationArray}.
	 * @param ctx the parse tree
	 */
	void exitLocationA(ProgramParser.LocationAContext ctx);
	/**
	 * Enter a parse tree produced by the {@code locationA2}
	 * labeled alternative in {@link ProgramParser#locationArray2}.
	 * @param ctx the parse tree
	 */
	void enterLocationA2(ProgramParser.LocationA2Context ctx);
	/**
	 * Exit a parse tree produced by the {@code locationA2}
	 * labeled alternative in {@link ProgramParser#locationArray2}.
	 * @param ctx the parse tree
	 */
	void exitLocationA2(ProgramParser.LocationA2Context ctx);
	/**
	 * Enter a parse tree produced by the {@code locMethod}
	 * labeled alternative in {@link ProgramParser#locationMethod}.
	 * @param ctx the parse tree
	 */
	void enterLocMethod(ProgramParser.LocMethodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code locMethod}
	 * labeled alternative in {@link ProgramParser#locationMethod}.
	 * @param ctx the parse tree
	 */
	void exitLocMethod(ProgramParser.LocMethodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exp_andExpr}
	 * labeled alternative in {@link ProgramParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExp_andExpr(ProgramParser.Exp_andExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exp_andExpr}
	 * labeled alternative in {@link ProgramParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExp_andExpr(ProgramParser.Exp_andExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exp_condOp}
	 * labeled alternative in {@link ProgramParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExp_condOp(ProgramParser.Exp_condOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exp_condOp}
	 * labeled alternative in {@link ProgramParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExp_condOp(ProgramParser.Exp_condOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code and_condOp}
	 * labeled alternative in {@link ProgramParser#andExpr}.
	 * @param ctx the parse tree
	 */
	void enterAnd_condOp(ProgramParser.And_condOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code and_condOp}
	 * labeled alternative in {@link ProgramParser#andExpr}.
	 * @param ctx the parse tree
	 */
	void exitAnd_condOp(ProgramParser.And_condOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code and_eqExpr}
	 * labeled alternative in {@link ProgramParser#andExpr}.
	 * @param ctx the parse tree
	 */
	void enterAnd_eqExpr(ProgramParser.And_eqExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code and_eqExpr}
	 * labeled alternative in {@link ProgramParser#andExpr}.
	 * @param ctx the parse tree
	 */
	void exitAnd_eqExpr(ProgramParser.And_eqExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code eqExpr_relationExpr}
	 * labeled alternative in {@link ProgramParser#eqExpr}.
	 * @param ctx the parse tree
	 */
	void enterEqExpr_relationExpr(ProgramParser.EqExpr_relationExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code eqExpr_relationExpr}
	 * labeled alternative in {@link ProgramParser#eqExpr}.
	 * @param ctx the parse tree
	 */
	void exitEqExpr_relationExpr(ProgramParser.EqExpr_relationExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code eqExpr_eqOp}
	 * labeled alternative in {@link ProgramParser#eqExpr}.
	 * @param ctx the parse tree
	 */
	void enterEqExpr_eqOp(ProgramParser.EqExpr_eqOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code eqExpr_eqOp}
	 * labeled alternative in {@link ProgramParser#eqExpr}.
	 * @param ctx the parse tree
	 */
	void exitEqExpr_eqOp(ProgramParser.EqExpr_eqOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code relExpr_addExpr}
	 * labeled alternative in {@link ProgramParser#relationExpr}.
	 * @param ctx the parse tree
	 */
	void enterRelExpr_addExpr(ProgramParser.RelExpr_addExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code relExpr_addExpr}
	 * labeled alternative in {@link ProgramParser#relationExpr}.
	 * @param ctx the parse tree
	 */
	void exitRelExpr_addExpr(ProgramParser.RelExpr_addExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code relExpr_relOp}
	 * labeled alternative in {@link ProgramParser#relationExpr}.
	 * @param ctx the parse tree
	 */
	void enterRelExpr_relOp(ProgramParser.RelExpr_relOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code relExpr_relOp}
	 * labeled alternative in {@link ProgramParser#relationExpr}.
	 * @param ctx the parse tree
	 */
	void exitRelExpr_relOp(ProgramParser.RelExpr_relOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addExpr_arithOp}
	 * labeled alternative in {@link ProgramParser#addExpr}.
	 * @param ctx the parse tree
	 */
	void enterAddExpr_arithOp(ProgramParser.AddExpr_arithOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addExpr_arithOp}
	 * labeled alternative in {@link ProgramParser#addExpr}.
	 * @param ctx the parse tree
	 */
	void exitAddExpr_arithOp(ProgramParser.AddExpr_arithOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addExpr_multExpr}
	 * labeled alternative in {@link ProgramParser#addExpr}.
	 * @param ctx the parse tree
	 */
	void enterAddExpr_multExpr(ProgramParser.AddExpr_multExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addExpr_multExpr}
	 * labeled alternative in {@link ProgramParser#addExpr}.
	 * @param ctx the parse tree
	 */
	void exitAddExpr_multExpr(ProgramParser.AddExpr_multExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multExpr_arithOp}
	 * labeled alternative in {@link ProgramParser#multExpr}.
	 * @param ctx the parse tree
	 */
	void enterMultExpr_arithOp(ProgramParser.MultExpr_arithOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multExpr_arithOp}
	 * labeled alternative in {@link ProgramParser#multExpr}.
	 * @param ctx the parse tree
	 */
	void exitMultExpr_arithOp(ProgramParser.MultExpr_arithOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multExpr_unaryExpr}
	 * labeled alternative in {@link ProgramParser#multExpr}.
	 * @param ctx the parse tree
	 */
	void enterMultExpr_unaryExpr(ProgramParser.MultExpr_unaryExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multExpr_unaryExpr}
	 * labeled alternative in {@link ProgramParser#multExpr}.
	 * @param ctx the parse tree
	 */
	void exitMultExpr_unaryExpr(ProgramParser.MultExpr_unaryExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryExpr_intchar}
	 * labeled alternative in {@link ProgramParser#unaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpr_intchar(ProgramParser.UnaryExpr_intcharContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryExpr_intchar}
	 * labeled alternative in {@link ProgramParser#unaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpr_intchar(ProgramParser.UnaryExpr_intcharContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryExpr_minus}
	 * labeled alternative in {@link ProgramParser#unaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpr_minus(ProgramParser.UnaryExpr_minusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryExpr_minus}
	 * labeled alternative in {@link ProgramParser#unaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpr_minus(ProgramParser.UnaryExpr_minusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryExpr_diff}
	 * labeled alternative in {@link ProgramParser#unaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpr_diff(ProgramParser.UnaryExpr_diffContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryExpr_diff}
	 * labeled alternative in {@link ProgramParser#unaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpr_diff(ProgramParser.UnaryExpr_diffContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryExpr_value}
	 * labeled alternative in {@link ProgramParser#unaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpr_value(ProgramParser.UnaryExpr_valueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryExpr_value}
	 * labeled alternative in {@link ProgramParser#unaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpr_value(ProgramParser.UnaryExpr_valueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code value_location}
	 * labeled alternative in {@link ProgramParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue_location(ProgramParser.Value_locationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code value_location}
	 * labeled alternative in {@link ProgramParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue_location(ProgramParser.Value_locationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code value_locationArray2}
	 * labeled alternative in {@link ProgramParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue_locationArray2(ProgramParser.Value_locationArray2Context ctx);
	/**
	 * Exit a parse tree produced by the {@code value_locationArray2}
	 * labeled alternative in {@link ProgramParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue_locationArray2(ProgramParser.Value_locationArray2Context ctx);
	/**
	 * Enter a parse tree produced by the {@code value_methodCall}
	 * labeled alternative in {@link ProgramParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue_methodCall(ProgramParser.Value_methodCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code value_methodCall}
	 * labeled alternative in {@link ProgramParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue_methodCall(ProgramParser.Value_methodCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code value_literal}
	 * labeled alternative in {@link ProgramParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue_literal(ProgramParser.Value_literalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code value_literal}
	 * labeled alternative in {@link ProgramParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue_literal(ProgramParser.Value_literalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code value_expr}
	 * labeled alternative in {@link ProgramParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue_expr(ProgramParser.Value_exprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code value_expr}
	 * labeled alternative in {@link ProgramParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue_expr(ProgramParser.Value_exprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code callingMethod}
	 * labeled alternative in {@link ProgramParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void enterCallingMethod(ProgramParser.CallingMethodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code callingMethod}
	 * labeled alternative in {@link ProgramParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void exitCallingMethod(ProgramParser.CallingMethodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code args}
	 * labeled alternative in {@link ProgramParser#arg}.
	 * @param ctx the parse tree
	 */
	void enterArgs(ProgramParser.ArgsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code args}
	 * labeled alternative in {@link ProgramParser#arg}.
	 * @param ctx the parse tree
	 */
	void exitArgs(ProgramParser.ArgsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ao_plus}
	 * labeled alternative in {@link ProgramParser#arith_op}.
	 * @param ctx the parse tree
	 */
	void enterAo_plus(ProgramParser.Ao_plusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ao_plus}
	 * labeled alternative in {@link ProgramParser#arith_op}.
	 * @param ctx the parse tree
	 */
	void exitAo_plus(ProgramParser.Ao_plusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ao_minus}
	 * labeled alternative in {@link ProgramParser#arith_op}.
	 * @param ctx the parse tree
	 */
	void enterAo_minus(ProgramParser.Ao_minusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ao_minus}
	 * labeled alternative in {@link ProgramParser#arith_op}.
	 * @param ctx the parse tree
	 */
	void exitAo_minus(ProgramParser.Ao_minusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ao_mult}
	 * labeled alternative in {@link ProgramParser#arith_op}.
	 * @param ctx the parse tree
	 */
	void enterAo_mult(ProgramParser.Ao_multContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ao_mult}
	 * labeled alternative in {@link ProgramParser#arith_op}.
	 * @param ctx the parse tree
	 */
	void exitAo_mult(ProgramParser.Ao_multContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ao_div}
	 * labeled alternative in {@link ProgramParser#arith_op}.
	 * @param ctx the parse tree
	 */
	void enterAo_div(ProgramParser.Ao_divContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ao_div}
	 * labeled alternative in {@link ProgramParser#arith_op}.
	 * @param ctx the parse tree
	 */
	void exitAo_div(ProgramParser.Ao_divContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ao_mod}
	 * labeled alternative in {@link ProgramParser#arith_op}.
	 * @param ctx the parse tree
	 */
	void enterAo_mod(ProgramParser.Ao_modContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ao_mod}
	 * labeled alternative in {@link ProgramParser#arith_op}.
	 * @param ctx the parse tree
	 */
	void exitAo_mod(ProgramParser.Ao_modContext ctx);
	/**
	 * Enter a parse tree produced by the {@code relop_lower}
	 * labeled alternative in {@link ProgramParser#rel_op}.
	 * @param ctx the parse tree
	 */
	void enterRelop_lower(ProgramParser.Relop_lowerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code relop_lower}
	 * labeled alternative in {@link ProgramParser#rel_op}.
	 * @param ctx the parse tree
	 */
	void exitRelop_lower(ProgramParser.Relop_lowerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code relop_greater}
	 * labeled alternative in {@link ProgramParser#rel_op}.
	 * @param ctx the parse tree
	 */
	void enterRelop_greater(ProgramParser.Relop_greaterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code relop_greater}
	 * labeled alternative in {@link ProgramParser#rel_op}.
	 * @param ctx the parse tree
	 */
	void exitRelop_greater(ProgramParser.Relop_greaterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code relop_lowerEq}
	 * labeled alternative in {@link ProgramParser#rel_op}.
	 * @param ctx the parse tree
	 */
	void enterRelop_lowerEq(ProgramParser.Relop_lowerEqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code relop_lowerEq}
	 * labeled alternative in {@link ProgramParser#rel_op}.
	 * @param ctx the parse tree
	 */
	void exitRelop_lowerEq(ProgramParser.Relop_lowerEqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code relop_greaterEq}
	 * labeled alternative in {@link ProgramParser#rel_op}.
	 * @param ctx the parse tree
	 */
	void enterRelop_greaterEq(ProgramParser.Relop_greaterEqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code relop_greaterEq}
	 * labeled alternative in {@link ProgramParser#rel_op}.
	 * @param ctx the parse tree
	 */
	void exitRelop_greaterEq(ProgramParser.Relop_greaterEqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code eqop_eq}
	 * labeled alternative in {@link ProgramParser#eq_op}.
	 * @param ctx the parse tree
	 */
	void enterEqop_eq(ProgramParser.Eqop_eqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code eqop_eq}
	 * labeled alternative in {@link ProgramParser#eq_op}.
	 * @param ctx the parse tree
	 */
	void exitEqop_eq(ProgramParser.Eqop_eqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code eqop_diff}
	 * labeled alternative in {@link ProgramParser#eq_op}.
	 * @param ctx the parse tree
	 */
	void enterEqop_diff(ProgramParser.Eqop_diffContext ctx);
	/**
	 * Exit a parse tree produced by the {@code eqop_diff}
	 * labeled alternative in {@link ProgramParser#eq_op}.
	 * @param ctx the parse tree
	 */
	void exitEqop_diff(ProgramParser.Eqop_diffContext ctx);
	/**
	 * Enter a parse tree produced by the {@code condop_or}
	 * labeled alternative in {@link ProgramParser#cond_op}.
	 * @param ctx the parse tree
	 */
	void enterCondop_or(ProgramParser.Condop_orContext ctx);
	/**
	 * Exit a parse tree produced by the {@code condop_or}
	 * labeled alternative in {@link ProgramParser#cond_op}.
	 * @param ctx the parse tree
	 */
	void exitCondop_or(ProgramParser.Condop_orContext ctx);
	/**
	 * Enter a parse tree produced by the {@code condop_and}
	 * labeled alternative in {@link ProgramParser#cond_op}.
	 * @param ctx the parse tree
	 */
	void enterCondop_and(ProgramParser.Condop_andContext ctx);
	/**
	 * Exit a parse tree produced by the {@code condop_and}
	 * labeled alternative in {@link ProgramParser#cond_op}.
	 * @param ctx the parse tree
	 */
	void exitCondop_and(ProgramParser.Condop_andContext ctx);
	/**
	 * Enter a parse tree produced by the {@code literal_int}
	 * labeled alternative in {@link ProgramParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral_int(ProgramParser.Literal_intContext ctx);
	/**
	 * Exit a parse tree produced by the {@code literal_int}
	 * labeled alternative in {@link ProgramParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral_int(ProgramParser.Literal_intContext ctx);
	/**
	 * Enter a parse tree produced by the {@code literal_char}
	 * labeled alternative in {@link ProgramParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral_char(ProgramParser.Literal_charContext ctx);
	/**
	 * Exit a parse tree produced by the {@code literal_char}
	 * labeled alternative in {@link ProgramParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral_char(ProgramParser.Literal_charContext ctx);
	/**
	 * Enter a parse tree produced by the {@code literal_bool}
	 * labeled alternative in {@link ProgramParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral_bool(ProgramParser.Literal_boolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code literal_bool}
	 * labeled alternative in {@link ProgramParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral_bool(ProgramParser.Literal_boolContext ctx);
	/**
	 * Enter a parse tree produced by the {@code integers}
	 * labeled alternative in {@link ProgramParser#int_literal}.
	 * @param ctx the parse tree
	 */
	void enterIntegers(ProgramParser.IntegersContext ctx);
	/**
	 * Exit a parse tree produced by the {@code integers}
	 * labeled alternative in {@link ProgramParser#int_literal}.
	 * @param ctx the parse tree
	 */
	void exitIntegers(ProgramParser.IntegersContext ctx);
	/**
	 * Enter a parse tree produced by the {@code chars}
	 * labeled alternative in {@link ProgramParser#char_literal}.
	 * @param ctx the parse tree
	 */
	void enterChars(ProgramParser.CharsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code chars}
	 * labeled alternative in {@link ProgramParser#char_literal}.
	 * @param ctx the parse tree
	 */
	void exitChars(ProgramParser.CharsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bool_true}
	 * labeled alternative in {@link ProgramParser#boolean_literal}.
	 * @param ctx the parse tree
	 */
	void enterBool_true(ProgramParser.Bool_trueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bool_true}
	 * labeled alternative in {@link ProgramParser#boolean_literal}.
	 * @param ctx the parse tree
	 */
	void exitBool_true(ProgramParser.Bool_trueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bool_false}
	 * labeled alternative in {@link ProgramParser#boolean_literal}.
	 * @param ctx the parse tree
	 */
	void enterBool_false(ProgramParser.Bool_falseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bool_false}
	 * labeled alternative in {@link ProgramParser#boolean_literal}.
	 * @param ctx the parse tree
	 */
	void exitBool_false(ProgramParser.Bool_falseContext ctx);
}