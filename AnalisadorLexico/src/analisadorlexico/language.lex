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
SIMBOLO_ESPECIAL = ":="| "<"| ">"| "<="| ">="| ";"
PALAVRA_RESERVADA_BEGIN = "begin"
PALAVRA_RESERVADA_END = "end"
PALAVRA_RESERVADA_IF = "if"
PALAVRA_RESERVADA_THEN = "then"
PALAVRA_RESERVADA_ELSE = "else"
PALAVRA_RESERVADA_ENDIF = "endif"
PALAVRA_RESERVADA_AND = "and"
PALAVRA_RESERVADA_OR = "or"
IDENTIFICADOR = [a-zA-Z]([a-zA-Z]|[0-9])*
AP = "("
FP = ")"


INT = 0|[1-9][0-9]*
REAL = 0|[1-9][0-9]*[","|"."][0-9][0-9]*

%%

{BRANCO}	{}
{OP_SUB}	{ imprimir("OP_SUB,Operador de subtração", yytext()); }
{OP_SOMA}	{ imprimir("OP_SOMA,Operador de soma", yytext()); }
{OP_MULT}	{ imprimir("OP_MULT,Operador de multiplicação", yytext()); }
{OP_DIV}	{ imprimir("OP_DIV,Operador de divisão", yytext()); }
{AP}		{ imprimir("AP,Abre parêntese", yytext()); }
{FP}		{ imprimir("FP,Fecha parêntese", yytext()); }
{INT}		{ imprimir("INT,Número Inteiro", yytext()); }
{REAL}   	{ imprimir("REAL,Número Real", yytext()); }
{SIMBOLO_ESPECIAL} { imprimir("SIMBOLO_ESPECIAL, Simbolo Especial", yytext());}
{PALAVRA_RESERVADA_BEGIN} { imprimir("PALAVRA_RESERVADA_BEGIN, Palavra 'begin'", yytext());}
{PALAVRA_RESERVADA_END} { imprimir("PALAVRA_RESERVADA_END, Palavra 'end'", yytext());}
{PALAVRA_RESERVADA_IF} { imprimir("PALAVRA_RESERVADA_IF, Palavra 'if'", yytext());}
{PALAVRA_RESERVADA_THEN} { imprimir("PALAVRA_RESERVADA_THEN, Palavra 'then'", yytext());}
{PALAVRA_RESERVADA_ELSE} { imprimir("PALAVRA_RESERVADA_ELSE, Palavra 'else'", yytext()); }
{PALAVRA_RESERVADA_ENDIF} { imprimir ("PALAVRA_RESERVADA_ENDIF, Palavra 'endif'" ,yytext()); }
{PALAVRA_RESERVADA_AND} { imprimir("PALAVRA_RESERVADA_AND, Palavra 'and'" ,yytext()); }
{PALAVRA_RESERVADA_OR}  { imprimir(" PALAVRA_RESERVADA_OR, Palavra 'or'" ,yytext()); }
{IDENTIFICADOR} { imprimir("IDENTIFICADOR, Palavra é variável" ,yytext()); }


. { throw new RuntimeException("Caractere inválido " + yytext()); }