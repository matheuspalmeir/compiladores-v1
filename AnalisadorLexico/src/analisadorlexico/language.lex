package analisadorlexico;

%%

%{

public ArrayList<Simbolo> tabelaSimbolos;

public int linha;
public int coluna;


  LexicalAnalyzer(java.io.Reader in, ArrayList<Simbolo> s) {
    this.zzReader = in;
    this.tabelaSimbolos = s;
    this.linha = 0;
    this.coluna = 0;
    
  }
private void imprimir(String descricao, String lexema) {
    Simbolo atual = new Simbolo();
    String[] list = descricao.split(",");
    
    atual.setLinha(this.yyline);
    atual.setColuna(this.yycolumn);
    atual.setDescricao(list[1]);
    atual.setToken(list[0]);
    atual.setLexema(lexema);

imprimir("INVÁLIDO,Caractere inválido", yytext());


                        try {
                            int num = Integer.parseInt(yytext());
                            if (num < 2147483646) {
                                imprimir("INT,Número Inteiro", yytext());
                            }
                        } catch (Exception e) {
                            imprimir("INVÁLIDO,Inteiro maior que o Limite", yytext());
                            System.out.println(e.getMessage());
                        }
    
    this.tabelaSimbolos.add(atual);
    //System.out.println(lexema + " - " + descricao);
}

%}


%line

%column

%class LexicalAnalyzer
%type void

BRANCO = [\n| |\t|\r]
OP_SUB = "-"
OP_SOMA = "+"
OP_MULT = "*"
OP_DIV = "/"
SIMBOLO_ESPECIAL = ":="| "<"| ">"| "<="| ">="| ";" | "," | ":" 
SIMBOLO_FINAL = "."

PALAVRA_RESERVADA_INT = "int"
PALAVRA_RESERVADA_FLOAT = "float"
PALAVRA_RESERVADA_BEGIN = "begin"
PALAVRA_RESERVADA_END = "end"
PALAVRA_RESERVADA_IF = "if"
PALAVRA_RESERVADA_THEN = "then"
PALAVRA_RESERVADA_ELSE = "else"
PALAVRA_RESERVADA_ENDIF = "endif"
PALAVRA_RESERVADA_AND = "and"
PALAVRA_RESERVADA_DIV = "div"
PALAVRA_RESERVADA_WRITE = "write"
PALAVRA_RESERVADA_READ = "read"
PALAVRA_RESERVADA_OR = "or"
PALAVRA_RESERVADA_WHILE = "while"
PALAVRA_RESERVADA_PROCEDURE = "procedure"
PALAVRA_RESERVADA_BOOLEAN = "boolean"
PALAVRA_RESERVADA_TRUE = "true"
PALAVRA_RESERVADA_FALSE = "false"
PALAVRA_RESERVADA_PROGRAM = "program"
PALAVRA_RESERVADA_VAR = "var"
IDENTIFICADOR = [a-zA-Z]([a-zA-Z]|[0-9])*

AP = "("
FP = ")"

NUMERO_INT = 0 | [1-9][0-9]*
NUMERO_REAL = 0|[1-9][0-9]*[","|"."][0-9][0-9]*

TraditionalComment   = "/*" [^*] ~"*/" | "/*" "*"+ "/"
EndOfLineComment     = "//" {InputCharacter}* {LineTerminator}?
DocumentationComment = "/**" {CommentContent} "*"+ "/"
CommentContent       = ( [^*] | \*+ [^/*] )*

LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]

COMENTARIO = {TraditionalComment} | {EndOfLineComment} | {DocumentationComment}

%%

{BRANCO}	{}
{OP_SUB}	{imprimir("OP_SUB,Operador de subtração", yytext());}
{OP_SOMA}	{imprimir("OP_SOMA,Operador de soma", yytext());}
{OP_MULT}	{imprimir("OP_MULT,Operador de multiplicação", yytext());}
{OP_DIV}	{imprimir("OP_DIV,Operador de divisão", yytext());}
{AP}		{imprimir("AP,Abre parêntese", yytext());}
{FP}		{imprimir("FP,Fecha parêntese", yytext());}
{NUMERO_INT} {imprimir("NUMERO_INT, Número inteiro", yytext());}
{NUMERO_REAL} {imprimir("NUMERO_REAL, Número real", yytext());}
{PALAVRA_RESERVADA_INT}		{imprimir("PALAVRA_RESERVADA_INT,Número Inteiro", yytext());}
{PALAVRA_RESERVADA_FLOAT}   	{imprimir("PALAVRA_RESERVADA_FLOAT,Número Real", yytext());}
{SIMBOLO_ESPECIAL} {imprimir("SIMBOLO_ESPECIAL, Simbolo Especial", yytext());}
{PALAVRA_RESERVADA_BEGIN} {imprimir("PALAVRA_RESERVADA_BEGIN, Palavra 'begin'", yytext());}
{PALAVRA_RESERVADA_END} {imprimir("PALAVRA_RESERVADA_END, Palavra 'end'", yytext());}
{PALAVRA_RESERVADA_DIV} {imprimir("PALAVRA_RESERVADA_DIV, Palavra 'div'", yytext());}
{PALAVRA_RESERVADA_WRITE} {imprimir("PALAVRA_RESERVADA_WRITE, write" ,yytext());}
{PALAVRA_RESERVADA_READ} {imprimir("PALAVRA_RESERVADA_READ, read" ,yytext());}
{PALAVRA_RESERVADA_IF} {imprimir("PALAVRA_RESERVADA_IF, Palavra 'if'", yytext());}
{PALAVRA_RESERVADA_THEN} {imprimir("PALAVRA_RESERVADA_THEN, Palavra 'then'", yytext());}
{PALAVRA_RESERVADA_ELSE} {imprimir("PALAVRA_RESERVADA_ELSE, Palavra 'else'", yytext());}
{PALAVRA_RESERVADA_ENDIF} {imprimir ("PALAVRA_RESERVADA_ENDIF, Palavra 'endif'" ,yytext());}
{PALAVRA_RESERVADA_AND} {imprimir("PALAVRA_RESERVADA_AND, Palavra 'and'" ,yytext());}
{PALAVRA_RESERVADA_OR}  {imprimir("PALAVRA_RESERVADA_OR, Palavra 'or'" ,yytext());}
{PALAVRA_RESERVADA_WHILE} {imprimir("PALAVRA_RESERVADA_WHILE, Palavra 'while'" ,yytext());}
{PALAVRA_RESERVADA_PROCEDURE} {imprimir("PALAVRA_RESERVADA_PROCEDURE, Palavra 'procedure'" ,yytext());}
{PALAVRA_RESERVADA_BOOLEAN} {imprimir("PALAVRA_RESERVADA_BOOLEAN, Palavra 'boolean'" ,yytext());}
{PALAVRA_RESERVADA_TRUE} {imprimir("PALAVRA_RESERVADA_TRUE, Palavra 'true'" ,yytext());}
{PALAVRA_RESERVADA_FALSE} {imprimir("PALAVRA_RESERVADA_FALSE, Palavra 'false'" ,yytext());}
{PALAVRA_RESERVADA_PROGRAM} {imprimir("PALAVRA_RESERVADA_PROGRAM, Palavra 'program'", yytext());}
{PALAVRA_RESERVADA_VAR} {imprimir("PALAVRA_RESERVADA_VAR, Palavra 'var'", yytext());}
{IDENTIFICADOR} {imprimir("IDENTIFICADOR, Palavra é variável" ,yytext());}
{COMENTARIO} {imprimir("COMENTÁRIO, Comentário inserido" ,yytext());}
{SIMBOLO_FINAL} {imprimir("SIMBOLO_FINAL, Ponto final" ,yytext());}




. { throw new RuntimeException("Caractere inválido " + yytext()); }