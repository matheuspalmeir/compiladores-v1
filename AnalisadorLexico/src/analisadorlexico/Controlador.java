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
    
    public Controlador(String entrada){
        this.expr = entrada;
        tabelaSimbolos = new ArrayList();
    }

    public ArrayList<Simbolo> analiseLexica() throws IOException{
        LexicalAnalyzer lexical = new LexicalAnalyzer(new StringReader(this.getExpr()), tabelaSimbolos);
        lexical.yylex();
        
        return this.tabelaSimbolos;
    }
    
    
    public void imprimirSimbolos(){
        for(int i= 0; i < this.tabelaSimbolos.size(); i++){
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