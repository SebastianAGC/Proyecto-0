grammar Program;

STRUCT :  'struct' ;
TRUE :    'true' ;
FALSE :   'false' ;
VOID :    'void' ;
IF :      'if' ;
ELSE :    'else' ;
WHILE :   'while' ;
RETURN :  'return' ;
INT :     'int' ;
CHAR :    'char' ;
BOOLEAN : 'boolean' ;

fragment LETTER : ('a'..'z'|'A'..'Z') ;
fragment DIGIT :'0'..'9' ;


ID : LETTER ( LETTER | DIGIT )* ;
NUM : DIGIT ( DIGIT )* ;
Char : LETTER;


WS : 
    [\t\r\n\f ]+ -> skip
    ;


program
	: 'class' ID '{' (declaration)* '}'     #classDecl
	;

declaration
	:	structDeclaration	    #decl_structDeclaration
	|	varDeclaration		    #decl_varDeclaration
	|	methodDeclaration	    #decl_methodDeclaration
	;
varDeclaration
	: 	varType ID ';'                  #varDecl_ID
	| 	varType ID '[' NUM ']' ';'      #varDecl_IDarray
	;


structDeclaration
	:	STRUCT ID '{' (varDeclaration)* '}'     #structDecl
	;

varType                                         
	: 	INT				            #var_int
	|	CHAR				        #var_char
	|	BOOLEAN				        #var_boolean
	|	STRUCT ID			        #var_structID
	|	structDeclaration           #var_structDecl
	| 	VOID				        #var_void
	;

methodDeclaration
	:	methodType ID '(' (parameter | (parameter (',' parameter)*)) ')' block     #methodDecl
	;

	
methodType
	:	INT                 #method_int
	|	CHAR				#method_char
	|	BOOLEAN				#method_boolean
	|	VOID				#method_void
	;

parameter
	: 	parameterType ID		    #param_ID
	|	parameterType ID '['']'     #param_ID_dots
	;
	
parameterType
	:	INT				    #param_int
	|	CHAR				#param_char
	|	BOOLEAN				#param_boolean
	;
	

block
	:	'{' (varDeclaration)*(statement)* '}'       #blck
	;

statement
	:	'if' '(' expression ')' block (statementElse)?	#stmt_if
	|	WHILE '(' expression ')' block			        #stmt_while
	|	'return' ( expression )? ';'			        #stmt_return
	|	methodCall ';'					                #stmt_methodCall
	| 	block										    #stmt_block
	|	location '=' expression ';'			            #stmt_location
    |   locationArray '=' expression ';'                #stmt_locationArray
	|	(expression)';'				                    #stmt_expression
	;

statementElse
    :	ELSE block      #stmtElse
    ;
	
location
	:	(ID)('.' locationMember)?       #location_id
	;
	
locationMember
	:	(ID)('.' locationMember)?    #locationMember_ID
    |   locationArray                #locationMember_locArray
	;

locationArray
        :   ID '[' expression ']' ('.' locationMember)? #locationA
            
        ;
locationArray2
        :   ID '[' expression ']' ('.' locationMember)? #locationA2
            
        ;

locationMethod
    : '.' locationMember        #locMethod
    ;    

expression 
	:	andExpr				            #exp_andExpr
	| 	expression cond_op andExpr  	#exp_condOp
	;

andExpr
	: 	eqExpr				            #and_eqExpr
	| 	andExpr cond_op eqExpr 	        #and_condOp
	;

eqExpr
	: 	relationExpr 			        #eqExpr_relationExpr
	| 	eqExpr eq_op relationExpr 	    #eqExpr_eqOp
	;

relationExpr
	: 	addExpr 			            #relExpr_addExpr
	| 	relationExpr rel_op addExpr 	#relExpr_relOp
	;

addExpr
	: 	multExpr 			            #addExpr_multExpr
	| 	addExpr arith_op multExpr 	    #addExpr_arithOp
	;

multExpr
	: 	unaryExpr 			            #multExpr_unaryExpr
	| 	multExpr arith_op unaryExpr     #multExpr_arithOp
	;


unaryExpr
	:  	'('(INT|CHAR)')'  value		#unaryExpr_intchar
	| 	'-' value 			        #unaryExpr_minus
	|	'!' value 			        #unaryExpr_diff
	|	value   	                #unaryExpr_value
	;

value
	:	location		            #value_location
    |   locationArray2              #value_locationArray2
	|	methodCall                  #value_methodCall
	|	literal                     #value_literal
	|	'(' expression ')'          #value_expr
	;


	
methodCall
	:	ID '(' (arg (',' arg)*)? ')' #callingMethod
	;
	
arg
	:	expression          #args
	;

arith_op
	:	'+'                 #ao_plus
	| 	'-'                 #ao_minus
	|	'*'                 #ao_mult
	|	'/'                 #ao_div
	|	'%'                 #ao_mod
	;

	
rel_op
	:	'<'                 #relop_lower
	|	'>'                 #relop_greater
	| 	'<='                #relop_lowerEq
	|	'>='                #relop_greaterEq
	;
	
eq_op
	:	'=='            #eqop_eq
	|	'!='            #eqop_diff
	;
	
cond_op
	: '||'              #condop_or
	| '&&'              #condop_and
	;


literal
	:	int_literal             #literal_int
	|	char_literal            #literal_char
	|	boolean_literal         #literal_bool
	;
	
int_literal
	:	NUM                     #integers
	;

char_literal
	:	Char                    #chars
	;
	
boolean_literal
	:	'true'                  #bool_true
	|	'false'                 #bool_false
	;