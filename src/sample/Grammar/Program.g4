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
	: 'class' ID '{' (declaration)* '}'
	;

declaration
	:	structDeclaration	
	|	varDeclaration		
	|	methodDeclaration	
	;
varDeclaration
	: 	varType ID ';'
	| 	varType ID '[' NUM ']' ';'  
	;


structDeclaration
	:	STRUCT ID '{' (varDeclaration)* '}'
	;

varType                                         
	: 	INT				
	|	CHAR				
	|	BOOLEAN				
	|	STRUCT ID			
	|	structDeclaration              
	| 	VOID				
	;

methodDeclaration
	:	methodType ID '('  (parameter (',' parameter)*) ')' block
	;

	
methodType
	:	INT				
	|	CHAR				
	|	BOOLEAN				
	|	VOID				
	;

parameter
	: 	parameterType ID		
	|	parameterType ID '['']'
	;
	
parameterType
	:	INT				
	|	CHAR				
	|	BOOLEAN				
	;
	

block
	:	'{' (varDeclaration)*(statement)* '}'
	;

statement
	:	'if' '(' expression ')' block (statementElse)?	
	|	WHILE '(' expression ')' block			
	|	'return' ( expression )? ';'			
	|	methodCall ';'					
	| 	block										
	|	location '=' expression ';'			
    |   locationArray '=' expression ';'               
	|	(expression)';'				
	;

statementElse
    :	ELSE block
    ;
	
location
	:	(ID)('.' locationMember)?
	;
	
locationMember
	:	(ID)('.' locationMember)?    
    |   locationArray                
	;

locationArray
        :   ID '[' expression ']' ('.' locationMember)?
            
        ;
locationArray2
        :   ID '[' expression ']' ('.' locationMember)?
            
        ;

locationMethod
    : '.' locationMember
    ;    

expression 
	:	andExpr				
	| 	expression cond_op andExpr  	
	;

andExpr
	: 	eqExpr				 
	| 	andExpr cond_op eqExpr 	
	;

eqExpr
	: 	relationExpr 			
	| 	eqExpr eq_op relationExpr 	
	;

relationExpr
	: 	addExpr 			
	| 	relationExpr rel_op addExpr 	
	;

addExpr
	: 	multExpr 			
	| 	addExpr arith_op multExpr 	
	;

multExpr
	: 	unaryExpr 			
	| 	multExpr arith_op unaryExpr 
	;


unaryExpr
	:  	'('(INT|CHAR)')'  value		
	| 	'-' value 			
	|	'!' value 			
	|	value   	   
	;

value
	:	location		
    |   locationArray2                   
	|	methodCall	
	|	literal
	|	'(' expression ')'
	;


	
methodCall
	:	ID '(' (arg (',' arg)*)? ')' 
	;
	
arg
	:	expression
	;

arith_op
	:	'+'
	| 	'-'
	|	'*'
	|	'/'
	|	'%'
	|	'%'
	;

	
rel_op
	:	'<'
	|	'>'
	| 	'<='
	|	'>='
	;
	
eq_op
	:	'=='
	|	'!='
	;
	
cond_op
	: '||' 
	| '&&'
	;


literal
	:	int_literal
	|	char_literal
	|	boolean_literal
	;
	
int_literal
	:	NUM
	;

char_literal
	:	Char 
	;
	
boolean_literal
	:	'true'
	|	'false'
	;