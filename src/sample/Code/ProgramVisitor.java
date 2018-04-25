// Generated from Program.g4 by ANTLR 4.7.1
package sample.Code;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ProgramParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ProgramVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code classDecl}
	 * labeled alternative in {@link ProgramParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDecl(ProgramParser.ClassDeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code decl_structDeclaration}
	 * labeled alternative in {@link ProgramParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl_structDeclaration(ProgramParser.Decl_structDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code decl_varDeclaration}
	 * labeled alternative in {@link ProgramParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl_varDeclaration(ProgramParser.Decl_varDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code decl_methodDeclaration}
	 * labeled alternative in {@link ProgramParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl_methodDeclaration(ProgramParser.Decl_methodDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varDecl_ID}
	 * labeled alternative in {@link ProgramParser#varDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDecl_ID(ProgramParser.VarDecl_IDContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varDecl_IDarray}
	 * labeled alternative in {@link ProgramParser#varDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDecl_IDarray(ProgramParser.VarDecl_IDarrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code structDecl}
	 * labeled alternative in {@link ProgramParser#structDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructDecl(ProgramParser.StructDeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code var_int}
	 * labeled alternative in {@link ProgramParser#varType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar_int(ProgramParser.Var_intContext ctx);
	/**
	 * Visit a parse tree produced by the {@code var_char}
	 * labeled alternative in {@link ProgramParser#varType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar_char(ProgramParser.Var_charContext ctx);
	/**
	 * Visit a parse tree produced by the {@code var_boolean}
	 * labeled alternative in {@link ProgramParser#varType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar_boolean(ProgramParser.Var_booleanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code var_structID}
	 * labeled alternative in {@link ProgramParser#varType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar_structID(ProgramParser.Var_structIDContext ctx);
	/**
	 * Visit a parse tree produced by the {@code var_structDecl}
	 * labeled alternative in {@link ProgramParser#varType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar_structDecl(ProgramParser.Var_structDeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code var_void}
	 * labeled alternative in {@link ProgramParser#varType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar_void(ProgramParser.Var_voidContext ctx);
	/**
	 * Visit a parse tree produced by the {@code methodDecl}
	 * labeled alternative in {@link ProgramParser#methodDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDecl(ProgramParser.MethodDeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code method_int}
	 * labeled alternative in {@link ProgramParser#methodType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod_int(ProgramParser.Method_intContext ctx);
	/**
	 * Visit a parse tree produced by the {@code method_char}
	 * labeled alternative in {@link ProgramParser#methodType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod_char(ProgramParser.Method_charContext ctx);
	/**
	 * Visit a parse tree produced by the {@code method_boolean}
	 * labeled alternative in {@link ProgramParser#methodType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod_boolean(ProgramParser.Method_booleanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code method_void}
	 * labeled alternative in {@link ProgramParser#methodType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod_void(ProgramParser.Method_voidContext ctx);
	/**
	 * Visit a parse tree produced by the {@code param_ID}
	 * labeled alternative in {@link ProgramParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam_ID(ProgramParser.Param_IDContext ctx);
	/**
	 * Visit a parse tree produced by the {@code param_ID_dots}
	 * labeled alternative in {@link ProgramParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam_ID_dots(ProgramParser.Param_ID_dotsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code param_int}
	 * labeled alternative in {@link ProgramParser#parameterType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam_int(ProgramParser.Param_intContext ctx);
	/**
	 * Visit a parse tree produced by the {@code param_char}
	 * labeled alternative in {@link ProgramParser#parameterType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam_char(ProgramParser.Param_charContext ctx);
	/**
	 * Visit a parse tree produced by the {@code param_boolean}
	 * labeled alternative in {@link ProgramParser#parameterType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam_boolean(ProgramParser.Param_booleanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code blck}
	 * labeled alternative in {@link ProgramParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlck(ProgramParser.BlckContext ctx);
	/**
	 * Visit a parse tree produced by the {@code finblck}
	 * labeled alternative in {@link ProgramParser#finbloque}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFinblck(ProgramParser.FinblckContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stmt_if}
	 * labeled alternative in {@link ProgramParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt_if(ProgramParser.Stmt_ifContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stmt_while}
	 * labeled alternative in {@link ProgramParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt_while(ProgramParser.Stmt_whileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stmt_return}
	 * labeled alternative in {@link ProgramParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt_return(ProgramParser.Stmt_returnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stmt_methodCall}
	 * labeled alternative in {@link ProgramParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt_methodCall(ProgramParser.Stmt_methodCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stmt_block}
	 * labeled alternative in {@link ProgramParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt_block(ProgramParser.Stmt_blockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stmt_location}
	 * labeled alternative in {@link ProgramParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt_location(ProgramParser.Stmt_locationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stmt_locationArray}
	 * labeled alternative in {@link ProgramParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt_locationArray(ProgramParser.Stmt_locationArrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stmt_expression}
	 * labeled alternative in {@link ProgramParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt_expression(ProgramParser.Stmt_expressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stmtElse}
	 * labeled alternative in {@link ProgramParser#statementElse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtElse(ProgramParser.StmtElseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code location_id}
	 * labeled alternative in {@link ProgramParser#location}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocation_id(ProgramParser.Location_idContext ctx);
	/**
	 * Visit a parse tree produced by the {@code locationMember_ID}
	 * labeled alternative in {@link ProgramParser#locationMember}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocationMember_ID(ProgramParser.LocationMember_IDContext ctx);
	/**
	 * Visit a parse tree produced by the {@code locationMember_locArray}
	 * labeled alternative in {@link ProgramParser#locationMember}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocationMember_locArray(ProgramParser.LocationMember_locArrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code locationA}
	 * labeled alternative in {@link ProgramParser#locationArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocationA(ProgramParser.LocationAContext ctx);
	/**
	 * Visit a parse tree produced by the {@code locMethod}
	 * labeled alternative in {@link ProgramParser#locationMethod}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocMethod(ProgramParser.LocMethodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exp_andExpr}
	 * labeled alternative in {@link ProgramParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp_andExpr(ProgramParser.Exp_andExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exp_condOp}
	 * labeled alternative in {@link ProgramParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp_condOp(ProgramParser.Exp_condOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code and_condOp}
	 * labeled alternative in {@link ProgramParser#andExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd_condOp(ProgramParser.And_condOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code and_eqExpr}
	 * labeled alternative in {@link ProgramParser#andExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd_eqExpr(ProgramParser.And_eqExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code eqExpr_relationExpr}
	 * labeled alternative in {@link ProgramParser#eqExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqExpr_relationExpr(ProgramParser.EqExpr_relationExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code eqExpr_eqOp}
	 * labeled alternative in {@link ProgramParser#eqExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqExpr_eqOp(ProgramParser.EqExpr_eqOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code relExpr_addExpr}
	 * labeled alternative in {@link ProgramParser#relationExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelExpr_addExpr(ProgramParser.RelExpr_addExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code relExpr_relOp}
	 * labeled alternative in {@link ProgramParser#relationExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelExpr_relOp(ProgramParser.RelExpr_relOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addExpr_arithOp}
	 * labeled alternative in {@link ProgramParser#addExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddExpr_arithOp(ProgramParser.AddExpr_arithOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addExpr_multExpr}
	 * labeled alternative in {@link ProgramParser#addExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddExpr_multExpr(ProgramParser.AddExpr_multExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multExpr_arithOp}
	 * labeled alternative in {@link ProgramParser#multExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultExpr_arithOp(ProgramParser.MultExpr_arithOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multExpr_unaryExpr}
	 * labeled alternative in {@link ProgramParser#multExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultExpr_unaryExpr(ProgramParser.MultExpr_unaryExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unaryExpr_intchar}
	 * labeled alternative in {@link ProgramParser#unaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpr_intchar(ProgramParser.UnaryExpr_intcharContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unaryExpr_minus}
	 * labeled alternative in {@link ProgramParser#unaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpr_minus(ProgramParser.UnaryExpr_minusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unaryExpr_diff}
	 * labeled alternative in {@link ProgramParser#unaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpr_diff(ProgramParser.UnaryExpr_diffContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unaryExpr_value}
	 * labeled alternative in {@link ProgramParser#unaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpr_value(ProgramParser.UnaryExpr_valueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code value_location}
	 * labeled alternative in {@link ProgramParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue_location(ProgramParser.Value_locationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code value_methodCall}
	 * labeled alternative in {@link ProgramParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue_methodCall(ProgramParser.Value_methodCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code value_literal}
	 * labeled alternative in {@link ProgramParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue_literal(ProgramParser.Value_literalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code value_expr}
	 * labeled alternative in {@link ProgramParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue_expr(ProgramParser.Value_exprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code callingMethod}
	 * labeled alternative in {@link ProgramParser#methodCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallingMethod(ProgramParser.CallingMethodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code args}
	 * labeled alternative in {@link ProgramParser#arg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgs(ProgramParser.ArgsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ao_plus}
	 * labeled alternative in {@link ProgramParser#arith_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAo_plus(ProgramParser.Ao_plusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ao_minus}
	 * labeled alternative in {@link ProgramParser#arith_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAo_minus(ProgramParser.Ao_minusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ao_mult}
	 * labeled alternative in {@link ProgramParser#mult_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAo_mult(ProgramParser.Ao_multContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ao_div}
	 * labeled alternative in {@link ProgramParser#mult_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAo_div(ProgramParser.Ao_divContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ao_mod}
	 * labeled alternative in {@link ProgramParser#mult_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAo_mod(ProgramParser.Ao_modContext ctx);
	/**
	 * Visit a parse tree produced by the {@code relop_lower}
	 * labeled alternative in {@link ProgramParser#rel_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelop_lower(ProgramParser.Relop_lowerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code relop_greater}
	 * labeled alternative in {@link ProgramParser#rel_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelop_greater(ProgramParser.Relop_greaterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code relop_lowerEq}
	 * labeled alternative in {@link ProgramParser#rel_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelop_lowerEq(ProgramParser.Relop_lowerEqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code relop_greaterEq}
	 * labeled alternative in {@link ProgramParser#rel_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelop_greaterEq(ProgramParser.Relop_greaterEqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code eqop_eq}
	 * labeled alternative in {@link ProgramParser#eq_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqop_eq(ProgramParser.Eqop_eqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code eqop_diff}
	 * labeled alternative in {@link ProgramParser#eq_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqop_diff(ProgramParser.Eqop_diffContext ctx);
	/**
	 * Visit a parse tree produced by the {@code condop_or}
	 * labeled alternative in {@link ProgramParser#cond_op_or}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondop_or(ProgramParser.Condop_orContext ctx);
	/**
	 * Visit a parse tree produced by the {@code condop_and}
	 * labeled alternative in {@link ProgramParser#cond_op_and}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondop_and(ProgramParser.Condop_andContext ctx);
	/**
	 * Visit a parse tree produced by the {@code literal_int}
	 * labeled alternative in {@link ProgramParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral_int(ProgramParser.Literal_intContext ctx);
	/**
	 * Visit a parse tree produced by the {@code literal_char}
	 * labeled alternative in {@link ProgramParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral_char(ProgramParser.Literal_charContext ctx);
	/**
	 * Visit a parse tree produced by the {@code literal_bool}
	 * labeled alternative in {@link ProgramParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral_bool(ProgramParser.Literal_boolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code integers}
	 * labeled alternative in {@link ProgramParser#int_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegers(ProgramParser.IntegersContext ctx);
	/**
	 * Visit a parse tree produced by the {@code chars}
	 * labeled alternative in {@link ProgramParser#char_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChars(ProgramParser.CharsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bool_true}
	 * labeled alternative in {@link ProgramParser#boolean_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool_true(ProgramParser.Bool_trueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bool_false}
	 * labeled alternative in {@link ProgramParser#boolean_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool_false(ProgramParser.Bool_falseContext ctx);
}