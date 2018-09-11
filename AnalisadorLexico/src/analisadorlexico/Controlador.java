/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisadorlexico;

/**
 *
 * @author Matheus Palmeira
 */
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import javax.swing.JTable;

public class Controlador {

    ArrayList<Simbolo> tabelaSimbolos;
    private String expr;

    public Controlador(String entrada) {
        this.expr = entrada;
        tabelaSimbolos = new ArrayList();
    }

    public ArrayList<Simbolo> analiseLexica() throws IOException {
        LexicalAnalyzer lexical = new LexicalAnalyzer(new StringReader(this.getExpr()), tabelaSimbolos);
        lexical.yylex();

        return this.tabelaSimbolos;
    }

    public void analiseSintatica() {
        Simbolo auxiliar;
        Erro erro = null;
        ArrayList<Erro> erros = new ArrayList();
        int estado = 0;
        int i = 0;

        while (i != this.tabelaSimbolos.size()) {
            auxiliar = this.tabelaSimbolos.get(i);
            switch (estado) {
                case 0:
                    if (!auxiliar.getToken().equals("PALAVRA_RESERVADA_PROGRAM")) {
                        erro = new Erro();
                        erro.setDescricao("O programa não foi definido!");
                        erro.setColuna(auxiliar.getColuna());
                        erro.setLinha(auxiliar.getLinha());
                        erro.setTokenEsperado(auxiliar.getToken());
                        erros.add(erro);
                        estado = -1;
                        i++;
                    } else {
                        estado = 1;
                        i++;
                    }
                    break;
                case 1: //Programa <programa>= <identificador> <bloco> 
                    if (auxiliar.getToken().equals("IDENTIFICADOR")) {
                        i++;
                        auxiliar = this.tabelaSimbolos.get(i);
                        if (auxiliar.getToken().equals("SIMBOLO_ESPECIAL") && auxiliar.getLexema().equals(";")) {
                            estado = 2;
                            i++;
                        } else {
                            erro = new Erro();
                            erro.setDescricao("Ponto e vírgula não encontrado!");
                            erro.setColuna(auxiliar.getColuna());
                            erro.setLinha(auxiliar.getLinha());
                            erro.setTokenEsperado(auxiliar.getToken());
                            erros.add(erro);
                            estado = -1;
                            i++;
                        }
                    } else {
                        erro = new Erro();
                        erro.setDescricao("Programa não foi identificado!");
                        erro.setColuna(auxiliar.getColuna());
                        erro.setLinha(auxiliar.getLinha());
                        erro.setTokenEsperado(auxiliar.getToken());
                        erros.add(erro);
                        estado = -1;
                        i++;
                    }
                case 2:
                    if (auxiliar.getToken().equals("PALAVRA_RESERVADA_INT") || auxiliar.getToken().equals("PALAVRA_RESERVADA_REAL")) {
                        estado = 3; //Encontrar um ou mais identficadores  
                        i++;
                    } else {
                        if (auxiliar.getToken().equals("PALAVRA_RESERVADA_PROCEDURE")) {
                            estado = 4; //Inicializar uma procedure
                            i++;
                            
                            
                        } else {
                            if (auxiliar.getToken().equals("PALAVRA_RESERVADA_BEGIN")) {
                                estado = 5; //Iniciando um comando 
                                i++;
                                
                            } else {
                                erro = new Erro();
                                erro.setDescricao("Bloco não foi encontrado!");
                                erro.setColuna(auxiliar.getColuna());
                                erro.setLinha(auxiliar.getLinha());
                                erro.setTokenEsperado(auxiliar.getToken());
                                erros.add(erro);
                                estado = -1;
                                i++;
                            }
                        }
                    }
                case 3: {
                    if(auxiliar.getToken().equals("IDENTIFICADOR")){
                        
                    }
                    
                }
                case -1: {

                }

            }

        }
    }

    /*BRANCO = [\n| |\t|\r];;
OP_SUB = "-"
OP_SOMA = "+"
OP_MULT = "*"
OP_DIV = "/"
SIMBOLO_ESPECIAL = ":="| "<"| ">"| "<="| ">="| ";" | "," | ":"
PALAVRA_RESERVADA_BEGIN = "begin"
PALAVRA_RESERVADA_END = "end"
PALAVRA_RESERVADA_IF = "if"
PALAVRA_RESERVADA_THEN = "then"
PALAVRA_RESERVADA_ELSE = "else"
PALAVRA_RESERVADA_ENDIF = "endif"
PALAVRA_RESERVADA_AND = "and"
PALAVRA_RESERVADA_DIV = "div"
PALAVRA_RESERVADA_OR = "or"
PALAVRA_RESERVADA_WHILE = "while"
PALAVRA_RESERVADA_PROCEDURE = "procedure"
PALAVRA_RESERVADA_BOOLEAN = "boolean"
PALAVRA_RESERVADA_TRUE = "true";
PALAVRA_RESERVADA_FALSE = "false"; 
PALAVRA_RESERVADA_PROGRAM = "program"
IDENTIFICADOR = [a-zA-Z]([a-zA-Z]|[0-9])*
AP = "("
FP = ")"


INT = 0 | [1-9][0-9]*
REAL = 0|[1-9][0-9]*[","|"."][0-9][0-9]*
     */
    public void imprimirSimbolos() {
        for (int i = 0; i < this.tabelaSimbolos.size(); i++) {
            Simbolo atual;
            atual = this.tabelaSimbolos.get(i);
            System.out.println("Token: " + atual.getToken() + "\n" + "Lexema: " + atual.getLexema() + "\n" + "Descrição: " + atual.getDescricao());
        }
    }

    /**
     * @return the expr
     */
    public String getExpr() {
        return expr;
    }

    /**
     * @param expr the expr to set
     */
    public void setExpr(String expr) {
        this.expr = expr;
    }

}
