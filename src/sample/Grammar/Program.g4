grammar Program;

STRUCT :  'struct' ;    #struct
TRUE :    'true' ;      #true
FALSE :   'false' ;     #false
VOID :    'void' ;      #void
IF :      'if' ;        #if
ELSE :    'else' ;      #else
WHILE :   'while' ;     #while
RETURN :  'return' ;    #return
INT :     'int' ;       #int
CHAR :    'char' ;      #char
BOOLEAN : 'boolean' ;   #boolean

fragment LETTER : ('a'..'z'|'A'..'Z') ;     #letter
fragment DIGIT :'0'..'9' ;                  #digit


ID : LETTER ( LETTER | DIGIT )* ;   #id
NUM : DIGIT ( DIGIT )* ;            #num
Char : LETTER;                      #char_letter


WS : 
    [\t\r\n\f ]+ -> skip                #ws
    ;


program
	: 'class' ID '{' (declaration)* '}'     #program
	;

declaration
	:	structDeclaration	    #structDeclaration
	|	varDeclaration		    #varDeclaration
	|	methodDeclaration	    #methodDeclaration
	;
varDeclaration
	: 	varType ID ';'                  #varDecl_ID
	| 	varType ID '[' NUM ']' ';'      #varDecl_IDarray
	;


structDeclaration
	:	STRUCT ID '{' (varDeclaration)* '}'     #structDeclaration
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
	:	methodType ID '(' parameter | (parameter (',' parameter)*) ')' block     #methodDeclaration
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
	:	'{' (varDeclaration)*(statement)* '}'       #block
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
	:	(ID)('.' locationMember)?       #location
	;
	
locationMember
	:	(ID)('.' locationMember)?    #locationMember_ID
    |   locationArray                #locationMember_locArray
	;

locationArray
        :   ID '[' expression ']' ('.' locationMember)? #locationArray
            
        ;
locationArray2
        :   ID '[' expression ']' ('.' locationMember)? #locationArray2
            
        ;

locationMethod
    : '.' locationMember        #locationMethod
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
	:	ID '(' (arg (',' arg)*)? ')' #methodCall
	;
	
arg
	:	expression          #arg
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
	:	NUM                     #int_literal
	;

char_literal
	:	Char                    #char_literal
	;
	
boolean_literal
	:	'true'                  #bool_true
	|	'false'                 #bool_false
	;