// Generated from Program.g4 by ANTLR 4.7.1
package sample.Code;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ProgramParser}.
 */
public interface ProgramListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ProgramParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(ProgramParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(ProgramParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(ProgramParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(ProgramParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclaration(ProgramParser.VarDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclaration(ProgramParser.VarDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#structDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterStructDeclaration(ProgramParser.StructDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#structDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitStructDeclaration(ProgramParser.StructDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#varType}.
	 * @param ctx the parse tree
	 */
	void enterVarType(ProgramParser.VarTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#varType}.
	 * @param ctx the parse tree
	 */
	void exitVarType(ProgramParser.VarTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclaration(ProgramParser.MethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclaration(ProgramParser.MethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#methodType}.
	 * @param ctx the parse tree
	 */
	void enterMethodType(ProgramParser.MethodTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#methodType}.
	 * @param ctx the parse tree
	 */
	void exitMethodType(ProgramParser.MethodTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(ProgramParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(ProgramParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#parameterType}.
	 * @param ctx the parse tree
	 */
	void enterParameterType(ProgramParser.ParameterTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#parameterType}.
	 * @param ctx the parse tree
	 */
	void exitParameterType(ProgramParser.ParameterTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(ProgramParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(ProgramParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(ProgramParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(ProgramParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#statementElse}.
	 * @param ctx the parse tree
	 */
	void enterStatementElse(ProgramParser.StatementElseContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#statementElse}.
	 * @param ctx the parse tree
	 */
	void exitStatementElse(ProgramParser.StatementElseContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#location}.
	 * @param ctx the parse tree
	 */
	void enterLocation(ProgramParser.LocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#location}.
	 * @param ctx the parse tree
	 */
	void exitLocation(ProgramParser.LocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#locationMember}.
	 * @param ctx the parse tree
	 */
	void enterLocationMember(ProgramParser.LocationMemberContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#locationMember}.
	 * @param ctx the parse tree
	 */
	void exitLocationMember(ProgramParser.LocationMemberContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#locationArray}.
	 * @param ctx the parse tree
	 */
	void enterLocationArray(ProgramParser.LocationArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#locationArray}.
	 * @param ctx the parse tree
	 */
	void exitLocationArray(ProgramParser.LocationArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#locationArray2}.
	 * @param ctx the parse tree
	 */
	void enterLocationArray2(ProgramParser.LocationArray2Context ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#locationArray2}.
	 * @param ctx the parse tree
	 */
	void exitLocationArray2(ProgramParser.LocationArray2Context ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#locationMethod}.
	 * @param ctx the parse tree
	 */
	void enterLocationMethod(ProgramParser.LocationMethodContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#locationMethod}.
	 * @param ctx the parse tree
	 */
	void exitLocationMethod(ProgramParser.LocationMethodContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(ProgramParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(ProgramParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#andExpr}.
	 * @param ctx the parse tree
	 */
	void enterAndExpr(ProgramParser.AndExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#andExpr}.
	 * @param ctx the parse tree
	 */
	void exitAndExpr(ProgramParser.AndExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#eqExpr}.
	 * @param ctx the parse tree
	 */
	void enterEqExpr(ProgramParser.EqExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#eqExpr}.
	 * @param ctx the parse tree
	 */
	void exitEqExpr(ProgramParser.EqExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#relationExpr}.
	 * @param ctx the parse tree
	 */
	void enterRelationExpr(ProgramParser.RelationExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#relationExpr}.
	 * @param ctx the parse tree
	 */
	void exitRelationExpr(ProgramParser.RelationExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#addExpr}.
	 * @param ctx the parse tree
	 */
	void enterAddExpr(ProgramParser.AddExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#addExpr}.
	 * @param ctx the parse tree
	 */
	void exitAddExpr(ProgramParser.AddExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#multExpr}.
	 * @param ctx the parse tree
	 */
	void enterMultExpr(ProgramParser.MultExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#multExpr}.
	 * @param ctx the parse tree
	 */
	void exitMultExpr(ProgramParser.MultExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#unaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpr(ProgramParser.UnaryExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#unaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpr(ProgramParser.UnaryExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(ProgramParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(ProgramParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void enterMethodCall(ProgramParser.MethodCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void exitMethodCall(ProgramParser.MethodCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#arg}.
	 * @param ctx the parse tree
	 */
	void enterArg(ProgramParser.ArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#arg}.
	 * @param ctx the parse tree
	 */
	void exitArg(ProgramParser.ArgContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#arith_op}.
	 * @param ctx the parse tree
	 */
	void enterArith_op(ProgramParser.Arith_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#arith_op}.
	 * @param ctx the parse tree
	 */
	void exitArith_op(ProgramParser.Arith_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#rel_op}.
	 * @param ctx the parse tree
	 */
	void enterRel_op(ProgramParser.Rel_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#rel_op}.
	 * @param ctx the parse tree
	 */
	void exitRel_op(ProgramParser.Rel_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#eq_op}.
	 * @param ctx the parse tree
	 */
	void enterEq_op(ProgramParser.Eq_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#eq_op}.
	 * @param ctx the parse tree
	 */
	void exitEq_op(ProgramParser.Eq_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#cond_op}.
	 * @param ctx the parse tree
	 */
	void enterCond_op(ProgramParser.Cond_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#cond_op}.
	 * @param ctx the parse tree
	 */
	void exitCond_op(ProgramParser.Cond_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(ProgramParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(ProgramParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#int_literal}.
	 * @param ctx the parse tree
	 */
	void enterInt_literal(ProgramParser.Int_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#int_literal}.
	 * @param ctx the parse tree
	 */
	void exitInt_literal(ProgramParser.Int_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#char_literal}.
	 * @param ctx the parse tree
	 */
	void enterChar_literal(ProgramParser.Char_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#char_literal}.
	 * @param ctx the parse tree
	 */
	void exitChar_literal(ProgramParser.Char_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#boolean_literal}.
	 * @param ctx the parse tree
	 */
	void enterBoolean_literal(ProgramParser.Boolean_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#boolean_literal}.
	 * @param ctx the parse tree
	 */
	void exitBoolean_literal(ProgramParser.Boolean_literalContext ctx);
}