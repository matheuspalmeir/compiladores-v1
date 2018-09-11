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
public class Erro {

    private String descricao;
    private int linha;
    private int coluna;
    private String tokenEsperado;

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the linha
     */
    public int getLinha() {
        return linha;
    }

    /**
     * @param linha the linha to set
     */
    public void setLinha(int linha) {
        this.linha = linha;
    }

    /**
     * @return the coluna
     */
    public int getColuna() {
        return coluna;
    }

    /**
     * @param coluna the coluna to set
     */
    public void setColuna(int coluna) {
        this.coluna = coluna;
    }

    /**
     * @return the tokenEsperado
     */
    public String getTokenEsperado() {
        return tokenEsperado;
    }

    /**
     * @param tokenEsperado the tokenEsperado to set
     */
    public void setTokenEsperado(String tokenEsperado) {
        this.tokenEsperado = tokenEsperado;
    }
}
