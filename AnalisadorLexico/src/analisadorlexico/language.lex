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
INVALIDO = [aA-zZ]*[aA-zZ]

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
{INVALIDO}      { imprimir("INVALIDO,Caracter Inválido", yytext()); }


. { throw new RuntimeException("Caractere inválido " + yytext()); }