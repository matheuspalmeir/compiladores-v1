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
    private ArrayList<Erro> erros;
    private ArrayList<Simbolo> pilhaLeitura;
    private String expr;

    public Controlador(String entrada) {
        this.expr = entrada;
        tabelaSimbolos = new ArrayList();
        pilhaLeitura = new ArrayList();
        erros = new ArrayList();
    }

    public ArrayList<Simbolo> analiseLexica() throws IOException {
        LexicalAnalyzer lexical = new LexicalAnalyzer(new StringReader(this.getExpr()), tabelaSimbolos);
        lexical.yylex();

        return this.tabelaSimbolos;
    }

    public void analiseSintatica() {
        Erro erro = null;

        int estado = 0;
        int i = 0;

//        this.imprimirSimbolos();;
        while (i != this.tabelaSimbolos.size()) {
            Simbolo auxiliar;
            auxiliar = this.tabelaSimbolos.get(i);
            System.out.println("Estado: " + estado);
            switch (estado) {
                case 0: //Estado inicial que identifica <program>
                    if (!auxiliar.getToken().equals("PALAVRA_RESERVADA_PROGRAM")) {
                        erro = new Erro();
                        erro.setDescricao("O programa não foi definido!");
                        erro.setColuna(auxiliar.getColuna());
                        erro.setLinha(auxiliar.getLinha());
                        erro.setSimboloEsperado(auxiliar);
                        erro.setPosicaoTabela(i);
                        getErros().add(erro);
                        estado = -1;
                        i++;
                    } else {
                        this.pilhaLeitura.add(auxiliar);
                        estado = 1;
                        i++;
                    }
                    break;
                case 1: //Estado que identifica o identificador de um program <identificador> ;
                    if (auxiliar.getToken().equals("IDENTIFICADOR")) {
                        this.pilhaLeitura.add(auxiliar);
                        Simbolo aux;
                        i++;
                        aux = this.tabelaSimbolos.get(i);

                        if (aux.getToken().equals("SIMBOLO_ESPECIAL") && aux.getLexema().equals(";")) {
                            i++;
                            estado = 2;
                            this.pilhaLeitura.add(aux);
                            break;
                        } else {
                            erro = new Erro();
                            erro.setDescricao("Ponto e vírgula não foi identificado!");
                            erro.setColuna(aux.getColuna());
                            erro.setLinha(aux.getLinha());
                            erro.setSimboloEsperado(aux); //Token esperado era o SIMBOLO_ESPECIAL
                            erro.setPosicaoTabela(i + 1);
                            getErros().add(erro);
                            estado = -1;    //Aqui vou tratar quando falta um ponto e virgula no final. 
                            i++;
                            break;
                        }
                    } else { //Caso não exista um identificador depois da palavra program
                        erro = new Erro();
                        erro.setDescricao("Programa não foi identificado! Atribua um identificador");
                        erro.setColuna(auxiliar.getColuna());
                        erro.setLinha(auxiliar.getLinha());
                        erro.setSimboloEsperado(auxiliar); //Token esperado era o IDENTIFICADOR
                        erro.setPosicaoTabela(i);
                        getErros().add(erro);
                        estado = -1;
                        i++;
                        break;
                    }
                case 2: //Estado que identifica um bloco
                    if (auxiliar.getToken().equals("PALAVRA_RESERVADA_INT") || auxiliar.getToken().equals("PALAVRA_RESERVADA_FLOAT") || auxiliar.getToken().equals("PALAVRA_RESERVADA_BOOLEAN")) {
                        estado = 3; //Encontrar um ou mais identficadores  
                        this.pilhaLeitura.add(auxiliar);
                        i++;
                        break;
                    } else {
                        if (auxiliar.getToken().equals("PALAVRA_RESERVADA_PROCEDURE")) {
                            estado = 4; //Inicializar uma procedure
                            i++;
                            this.pilhaLeitura.add(auxiliar);
                            break;

                        } else {
                            if (auxiliar.getToken().equals("PALAVRA_RESERVADA_BEGIN")) {
                                estado = 5; //Iniciando um comando 
                                i++;
                                this.pilhaLeitura.add(auxiliar);
                                break;

                            } else {
                                erro = new Erro();
                                erro.setDescricao("Bloco não foi encontrado!");
                                erro.setColuna(auxiliar.getColuna());
                                erro.setLinha(auxiliar.getLinha());
                                erro.setSimboloEsperado(auxiliar); //Token esperado era o SIMBOLO_ESPECIAL
                                erro.setPosicaoTabela(i);
                                getErros().add(erro);
                                estado = -1;
                                i++;
                                break;
                            }
                        }
                    }
                case 3: {   //Lista de identificadores <lista de identificadores> ::= <identificador> {, <identificador>}
                    if (auxiliar.getToken().equals("IDENTIFICADOR")) {
                        this.pilhaLeitura.add(auxiliar);
                        i++;
                        auxiliar = this.tabelaSimbolos.get(i);
                        if (auxiliar.getToken().equals("SIMBOLO_ESPECIAL") && auxiliar.getLexema().equals(",")) {
                            estado = 3;
                            i++;
                            this.pilhaLeitura.add(auxiliar);
                            break;
                        } else {
                            if (auxiliar.getToken().equals("SIMBOLO_ESPECIAL") && auxiliar.getLexema().equals(";")) {
                                estado = 2;
                                i++;
                                this.pilhaLeitura.add(auxiliar);
                                break;
                            } else {
                                erro = new Erro();
                                erro.setDescricao("Ponto e vírgula ou vírgula não encontrado!");
                                erro.setColuna(auxiliar.getColuna());
                                erro.setLinha(auxiliar.getLinha());
                                erro.setSimboloEsperado(auxiliar); //Token esperado era o SIMBOLO_ESPECIAL
                                erro.setPosicaoTabela(i);
                                getErros().add(erro);
                                estado = -1;
                                i++;
                                break;
                            }
                        }
                    } else {
                        erro = new Erro();
                        erro.setDescricao("Identificador esperado");
                        erro.setColuna(auxiliar.getColuna());
                        erro.setLinha(auxiliar.getLinha());
                        erro.setSimboloEsperado(auxiliar); //Token esperado era o SIMBOLO_ESPECIAL
                        erro.setPosicaoTabela(i);
                        getErros().add(erro);
                        estado = -1;
                        i++;
                        break;
                    }
                }
                case 4: {//Esperado identificador de uma procedure (Estrutura de uma procedure)
                    if (auxiliar.getToken().equals("IDENTIFICADOR")) {
                        i++;
                        this.pilhaLeitura.add(auxiliar);
                        auxiliar = this.tabelaSimbolos.get(i);

                        //Se o identificador da procedure foi passado então, teremos um abre parêntese. 
                        if (auxiliar.getToken().equals("AP")) {
                            i++;
                            this.pilhaLeitura.add(auxiliar);
                            auxiliar = this.tabelaSimbolos.get(i);

                            //Abrindo o parentese então teremos uma palavra VAR para declaração de parâmetros
                            if (auxiliar.getToken().equals("PALAVRA_RESERVADA_VAR")) {
                                i++;
                                this.pilhaLeitura.add(auxiliar);
                                auxiliar = this.tabelaSimbolos.get(i);

                                //Após a palavra reservada será um identificador
                                if (auxiliar.getToken().equals("IDENTIFICADOR")) {
                                    i++;
                                    this.pilhaLeitura.add(auxiliar);
                                    auxiliar = this.tabelaSimbolos.get(i);
                                    //Após o identificador espera-se um simbolo :
                                    if (auxiliar.getToken().equals("SIMBOLO_ESPECIAL") && auxiliar.getLexema().equals(":")) {
                                        i++;
                                        this.pilhaLeitura.add(auxiliar);
                                        auxiliar = this.tabelaSimbolos.get(i);

                                        if (auxiliar.getToken().equals("PALAVRA_RESERVADA_INT") || auxiliar.getToken().equals("PALAVRA_RESERVADA_FLOAT") || auxiliar.getToken().equals("PALAVRA_RESERVADA_BOOLEAN")) {
                                            i++;
                                            this.pilhaLeitura.add(auxiliar);
                                            auxiliar = this.tabelaSimbolos.get(i);

                                            //Após o tipo fecha parentese seguido de ; 
                                            if (auxiliar.getToken().equals("FP")) {
                                                i++;
                                                this.pilhaLeitura.add(auxiliar);
                                                auxiliar = this.tabelaSimbolos.get(i);

                                                if (auxiliar.getToken().equals("SIMBOLO_ESPECIAL") && auxiliar.getLexema().equals(";")) {
                                                    estado = 2;
                                                    i++;
                                                    this.pilhaLeitura.add(auxiliar);
                                                    break;
                                                } else {
                                                    //Se não encontra ponto e virgula
                                                    erro = new Erro();
                                                    erro.setDescricao("Simbolo especial ponto e vírgula não encontrado!");
                                                    erro.setColuna(auxiliar.getColuna());
                                                    erro.setLinha(auxiliar.getLinha());
                                                    erro.setSimboloEsperado(auxiliar);
                                                    erro.setPosicaoTabela(i);
                                                    getErros().add(erro);
                                                    estado = -1;
                                                    i++;
                                                    break;
                                                }
                                            } else {
                                                //Não encontra o FP
                                                erro = new Erro();
                                                erro.setDescricao("Fecha parenteses não encontrado!");
                                                erro.setColuna(auxiliar.getColuna());
                                                erro.setLinha(auxiliar.getLinha());
                                                erro.setSimboloEsperado(auxiliar);
                                                erro.setPosicaoTabela(i);
                                                getErros().add(erro);
                                                estado = -1;
                                                i++;
                                                break;
                                            }
                                        } else {
                                            //erro da palavra reservada int
                                            erro = new Erro();
                                            erro.setDescricao("Tipo não definido!");
                                            erro.setColuna(auxiliar.getColuna());
                                            erro.setLinha(auxiliar.getLinha());
                                            erro.setSimboloEsperado(auxiliar);
                                            erro.setPosicaoTabela(i);
                                            getErros().add(erro);
                                            estado = -1;
                                            i++;
                                            break;
                                        }
                                    } else {
                                        //Erro do dois pontos
                                        erro = new Erro();
                                        erro.setDescricao("Simbolo especial : não encontrado");
                                        erro.setColuna(auxiliar.getColuna());
                                        erro.setLinha(auxiliar.getLinha());
                                        erro.setSimboloEsperado(auxiliar);
                                        erro.setPosicaoTabela(i);
                                        getErros().add(erro);
                                        estado = -1;
                                        i++;
                                        break;
                                    }
                                } else {
                                    //erro de identificador
                                    erro = new Erro();
                                    erro.setDescricao("Identificador não encontrado!");
                                    erro.setColuna(auxiliar.getColuna());
                                    erro.setLinha(auxiliar.getLinha());
                                    erro.setSimboloEsperado(auxiliar);
                                    erro.setPosicaoTabela(i);
                                    getErros().add(erro);
                                    estado = -1;
                                    i++;
                                    break;
                                }
                            } else {
                                //erro de palavra var
                                erro = new Erro();
                                erro.setDescricao("Palavra reservada var não identificada!");
                                erro.setColuna(auxiliar.getColuna());
                                erro.setLinha(auxiliar.getLinha());
                                erro.setSimboloEsperado(auxiliar);
                                erro.setPosicaoTabela(i);
                                getErros().add(erro);
                                estado = -1;
                                i++;
                                break;
                            }
                        } else {
                            //erro de ap
                            erro = new Erro();
                            erro.setDescricao("Abre parentese não identificado!!");
                            erro.setColuna(auxiliar.getColuna());
                            erro.setLinha(auxiliar.getLinha());
                            erro.setSimboloEsperado(auxiliar);
                            erro.setPosicaoTabela(i);
                            getErros().add(erro);
                            estado = -1;
                            i++;
                            break;
                        }
                    } else {
                        //erro de identificador da procedure
                        erro = new Erro();
                        erro.setDescricao("Identificador não encontrado!!");
                        erro.setColuna(auxiliar.getColuna());
                        erro.setLinha(auxiliar.getLinha());
                        erro.setSimboloEsperado(auxiliar);
                        erro.setPosicaoTabela(i);
                        getErros().add(erro);
                        estado = -1;
                        i++;
                        break;
                    }
                }
                case 5: { //Encontrando um comando composto begin <comando> end

                    //Pode ser uma atribuição
                    if (auxiliar.getToken().equals("IDENTIFICADOR")) {
                        this.pilhaLeitura.add(auxiliar);
                        i++;
                        auxiliar = this.tabelaSimbolos.get(i);
                        if (auxiliar.getToken().equals("SIMBOLO_ESPECIAL") && auxiliar.getLexema().equals(":=")) {
                            this.pilhaLeitura.add(auxiliar);
                            i++;
                            auxiliar = this.tabelaSimbolos.get(i);
                            //Setar um novo estado aqui porque posso ter uma atribuição ou uma expressão
                            //Novo estado para atribuição estado=6 novo 
                            if (auxiliar.getToken().equals("NUMERO_INT") || auxiliar.getToken().equals("NUMERO_REAL") || auxiliar.getToken().equals("PALAVRA_RESERVADA_TRUE") || auxiliar.getToken().equals("PALAVRA_RESERVADA_FALSE")) {
                                this.pilhaLeitura.add(auxiliar);
                                i++;
                                estado = 6; //Estado que termina uma atribuição de valores
                                break;
                            } else {
                                if (auxiliar.getToken().equals("IDENTIFICADOR")) {
                                    this.pilhaLeitura.add(auxiliar);
                                    i++;
                                    estado = 7; //Define uma expressão
                                    break;
                                } else {
                                    erro = new Erro();
                                    erro.setDescricao("Atribuição não definida!Falta uma expressão!");
                                    erro.setColuna(auxiliar.getColuna());
                                    erro.setLinha(auxiliar.getLinha());
                                    erro.setSimboloEsperado(auxiliar);
                                    erro.setPosicaoTabela(i);
                                    getErros().add(erro);
                                    estado = -1;
                                    i++;
                                    break;
                                }
                            }
                        } else {
                            if (auxiliar.getToken().equals("AP")) {
                                this.pilhaLeitura.add(auxiliar);
                                i++;
                                auxiliar = this.tabelaSimbolos.get(i);
                                estado = 11;
                                break;
                            } else {
                                erro = new Erro();
                                erro.setDescricao("Atribuição não encontrada! Falta o (");
                                erro.setColuna(auxiliar.getColuna());
                                erro.setLinha(auxiliar.getLinha());
                                erro.setSimboloEsperado(auxiliar);
                                erro.setPosicaoTabela(i);
                                getErros().add(erro);
                                estado = -1;
                                i++;
                                break;

                            }
                        }
                    }

                    if (auxiliar.getToken().equals("PALAVRA_RESERVADA_IF")) {
                        this.pilhaLeitura.add(auxiliar);
                        i++;
                        estado = 9; //Estado que define um if, then, else
                        break;
                    }

                    if (auxiliar.getToken().equals("PALAVRA_RESERVADA_WHILE")) {
                        this.pilhaLeitura.add(auxiliar);
                        i++;
                        estado = 9; //Estado que define um if, then, else
                        break;
                    }
                    
                    if (auxiliar.getToken().equals("PALAVRA_RESERVADA_ELSE")) {
                        this.pilhaLeitura.add(auxiliar);
                        i++;
                        estado = 5; //Estado que define um while
                        break;
                    }

                    if (auxiliar.getToken().equals("PALAVRA_RESERVADA_READ")) {
                        this.pilhaLeitura.add(auxiliar);
                        i++;
                        estado = 8; //Estado que define um while
                        break;
                    }

                    if (auxiliar.getToken().equals("PALAVRA_RESERVADA_WRITE")) {
                        this.pilhaLeitura.add(auxiliar);
                        i++;
                        estado = 8; //Estado que define um while
                        break;
                    }

                    if (auxiliar.getToken().equals("PALAVRA_RESERVADA_BEGIN")) {
                        this.pilhaLeitura.add(auxiliar);
                        i++;
                        estado = 5;
                        break;
                    }

                    if (auxiliar.getToken().equals("PALAVRA_RESERVADA_END")) {
                        this.pilhaLeitura.add(auxiliar);
                        i++;
                        estado = 6;
                        break;
                    }

                }
                case 6: { //Estado que define uma atribuição de 
                    //pAREI AQUI 13/11 - Desfazer esses ifs else, será so if -> if ;, if . , if Operadores
                    if (auxiliar.getToken().equals("SIMBOLO_ESPECIAL") && auxiliar.getLexema().equals(";")) {
                        this.pilhaLeitura.add(auxiliar);
                        i++;
                        estado = 5;
                        break;//Estado que define um comando composto de um begin 
                    }
//                    else {
//                            //Erro de final de atribuição falta simbolo especial!
//                            erro = new Erro();
//                            erro.setDescricao("Simbolo especial ; não encontrado");
//                            erro.setColuna(auxiliar.getColuna());
//                            erro.setLinha(auxiliar.getLinha());
//                            erro.setSimboloEsperado(auxiliar);
//                            erro.setPosicaoTabela(i);
//                            getErros().add(erro);
//                            estado = -1;
//                            i++;
//                            break;
//                        }

                    if (auxiliar.getToken().equals("SIMBOLO_FINAL")) {
                        this.pilhaLeitura.add(auxiliar);
                        i++;
                        if (i == this.pilhaLeitura.size()) {
                            System.out.println("Completado com sucesso!");
                            return;
                        } else {
                            erro = new Erro();
                            erro.setDescricao("Simbolo Final . encontrado em bloco");
                            erro.setColuna(auxiliar.getColuna());
                            erro.setLinha(auxiliar.getLinha());
                            erro.setSimboloEsperado(auxiliar);
                            erro.setPosicaoTabela(i);
                            getErros().add(erro);
                            estado = -1;
                            i++;
                            break;
                        }
                    }

                    if (auxiliar.getToken().equals("OP_SOMA") || auxiliar.getToken().equals("OP_SUB") || auxiliar.getToken().equals("OP_DIV") || auxiliar.getToken().equals("OP_MULT")) {
                        this.pilhaLeitura.add(auxiliar);
                        i++;
                        auxiliar = this.tabelaSimbolos.get(i);
                        if (auxiliar.getToken().equals("IDENTIFICADOR") || auxiliar.getToken().equals("NUMERO_REAL") || auxiliar.getToken().equals("NUMERO_INT")) {
                            this.pilhaLeitura.add(auxiliar);
                            i++;
                            auxiliar = this.tabelaSimbolos.get(i);
                            if (auxiliar.getToken().equals("SIMBOLO_ESPECIAL") && auxiliar.getLexema().equals(";")) {
                                this.pilhaLeitura.add(auxiliar);
                                System.out.println("Entrei aqui!");
                                i++;
                                estado = 5;
                                break;// Retorna ao estado que define um COMANDO
                            } else {
                                erro = new Erro();
                                erro.setDescricao("SIMBOLO_ESPECIAL ; não encontrado!");
                                erro.setColuna(auxiliar.getColuna());
                                erro.setLinha(auxiliar.getLinha());
                                erro.setSimboloEsperado(auxiliar);
                                erro.setPosicaoTabela(i);
                                getErros().add(erro);
                                estado = -1;
                                i++;
                                break;
                            }
                        } else {
                            //Erro falta um identificador ou um valor na expressao
                            erro = new Erro();
                            erro.setDescricao("Variável ou valor int/real não encontrado!");
                            erro.setColuna(auxiliar.getColuna());
                            erro.setLinha(auxiliar.getLinha());
                            erro.setSimboloEsperado(auxiliar);
                            erro.setPosicaoTabela(i);
                            getErros().add(erro);
                            estado = -1;
                            i++;
                            break;
                        }
                    }
                }

                case 7: {   //Estado que define uma expressão 
                    if (auxiliar.getToken().equals("OP_SOMA") || auxiliar.getToken().equals("OP_SUB") || auxiliar.getToken().equals("OP_DIV") || auxiliar.getToken().equals("OP_MULT") || auxiliar.getToken().equals("PALAVRA_RESERVADA_DIV") || auxiliar.getToken().equals("PALAVRA_RESERVADA_DIV")) {
                        this.pilhaLeitura.add(auxiliar);
                        i++;
                        auxiliar = this.tabelaSimbolos.get(i);
                        if (auxiliar.getToken().equals("IDENTIFICADOR") || auxiliar.getToken().equals("NUMERO_REAL") || auxiliar.getToken().equals("NUMERO_INT")) {
                            this.pilhaLeitura.add(auxiliar);
                            i++;
                            auxiliar = this.tabelaSimbolos.get(i);
                            if (auxiliar.getToken().equals("SIMBOLO_ESPECIAL") && auxiliar.getLexema().equals(";")) {
                                this.pilhaLeitura.add(auxiliar);
                                System.out.println("Entrei aqui!");
                                i++;
                                estado = 5;
                                break;// Retorna ao estado que define um COMANDO
                            } else {
                                erro = new Erro();
                                erro.setDescricao("SIMBOLO_ESPECIAL ; não encontrado!");
                                erro.setColuna(auxiliar.getColuna());
                                erro.setLinha(auxiliar.getLinha());
                                erro.setSimboloEsperado(auxiliar);
                                erro.setPosicaoTabela(i);
                                getErros().add(erro);
                                estado = -1;
                                i++;
                                break;
                            }
                        } else {
                            //Erro falta um identificador ou um valor na expressao
                            erro = new Erro();
                            erro.setDescricao("Variável ou valor int/real não encontrado!");
                            erro.setColuna(auxiliar.getColuna());
                            erro.setLinha(auxiliar.getLinha());
                            erro.setSimboloEsperado(auxiliar);
                            erro.setPosicaoTabela(i);
                            getErros().add(erro);
                            estado = -1;
                            i++;
                            break;
                        }
                    }
                }
                case 8: {
                    if (auxiliar.getToken().equals("AP")) {
                        this.pilhaLeitura.add(auxiliar);
                        estado = 10; //Estado que define uma expressão de uma condicional
                        i++;
                        break;
                    }
                }
                case 9: { //Estado que define um if then else
                    if (auxiliar.getToken().equals("AP")) {
                        this.pilhaLeitura.add(auxiliar);
                        estado = 10; //Estado que define uma expressão de uma condicional
                        i++;
                        break;
                    }
                }
                case 10: { //Definindo uma empressão de uma condicional seja while ou if. 
                    if (auxiliar.getToken().equals("IDENTIFICADOR")) {
                        this.pilhaLeitura.add(auxiliar);
                        i++;
                        auxiliar = this.tabelaSimbolos.get(i);
                        if (auxiliar.getToken().equals("SIMBOLO_ESPECIAL") && !auxiliar.getLexema().equals(":") && !auxiliar.getLexema().equals(";")) {
                            this.pilhaLeitura.add(auxiliar);
                            i++;
                            auxiliar = this.tabelaSimbolos.get(i);
                            if (auxiliar.getToken().equals("NUMERO_REAL") || auxiliar.getToken().equals("NUMERO_INT")) {
                                this.pilhaLeitura.add(auxiliar);
                                i++;
                                auxiliar = this.tabelaSimbolos.get(i);
                                if (auxiliar.getToken().equals("FP")) {
                                    this.pilhaLeitura.add(auxiliar);
                                    i++;
                                    estado = 5;
                                    break;
                                } else {
                                    erro = new Erro();
                                    erro.setDescricao("Fecha Parenteses ')' não encontrado");
                                    erro.setColuna(auxiliar.getColuna());
                                    erro.setLinha(auxiliar.getLinha());
                                    erro.setSimboloEsperado(auxiliar);
                                    erro.setPosicaoTabela(i);
                                    getErros().add(erro);
                                    estado = -1;
                                    i++;
                                    break;
                                }
                            } else {
                                erro = new Erro();
                                erro.setDescricao("Valor não foi encontrado");
                                erro.setColuna(auxiliar.getColuna());
                                erro.setLinha(auxiliar.getLinha());
                                erro.setSimboloEsperado(auxiliar);
                                erro.setPosicaoTabela(i);
                                getErros().add(erro);
                                estado = -1;
                                i++;
                                break;
                            }
                        } else {
                            if (auxiliar.getToken().equals("FP")) {
                                this.pilhaLeitura.add(auxiliar);
                                i++;
                                estado = 5;
                                break;
                            } else {
                                erro = new Erro();
                                erro.setDescricao("Fecha Parenteses ')' não encontrado");
                                erro.setColuna(auxiliar.getColuna());
                                erro.setLinha(auxiliar.getLinha());
                                erro.setSimboloEsperado(auxiliar);
                                erro.setPosicaoTabela(i);
                                getErros().add(erro);
                                estado = -1;
                                i++;
                                break;
                            }
                        }
                    } else {
                        erro = new Erro();
                        erro.setDescricao("Identificador não foi não encontrado");
                        erro.setColuna(auxiliar.getColuna());
                        erro.setLinha(auxiliar.getLinha());
                        erro.setSimboloEsperado(auxiliar);
                        erro.setPosicaoTabela(i);
                        getErros().add(erro);
                        estado = -1;
                        i++;
                        break;
                    }
                }

                case 11: {
                    if (auxiliar.getToken().equals("IDENTIFICADOR")) {
                        this.pilhaLeitura.add(auxiliar);
                        i++;
                        auxiliar = this.tabelaSimbolos.get(i);
                        if (auxiliar.getToken().equals("FP")) {
                            this.pilhaLeitura.add(auxiliar);
                            i++;
                            auxiliar = this.tabelaSimbolos.get(i);
                            if (auxiliar.getToken().equals("SIMBOLO_ESPECIAL")) {
                                this.pilhaLeitura.add(auxiliar);
                                i++;
                                auxiliar = this.tabelaSimbolos.get(i);
                                estado = 5;
                                break;
                            } else {
                                erro = new Erro();
                                erro.setDescricao("SIMBOLO ESPECIAL ; não foi não encontrado");
                                erro.setColuna(auxiliar.getColuna());
                                erro.setLinha(auxiliar.getLinha());
                                erro.setSimboloEsperado(auxiliar);
                                erro.setPosicaoTabela(i);
                                getErros().add(erro);
                                estado = -1;
                                i++;
                                break;
                            }
                        } else {
                            erro = new Erro();
                            erro.setDescricao("Fecha parenteses ) não foi não encontrado");
                            erro.setColuna(auxiliar.getColuna());
                            erro.setLinha(auxiliar.getLinha());
                            erro.setSimboloEsperado(auxiliar);
                            erro.setPosicaoTabela(i);
                            getErros().add(erro);
                            estado = -1;
                            i++;
                            break;
                        }
                    } else {
                        erro = new Erro();
                        erro.setDescricao("Identificador não foi não encontrado");
                        erro.setColuna(auxiliar.getColuna());
                        erro.setLinha(auxiliar.getLinha());
                        erro.setSimboloEsperado(auxiliar);
                        erro.setPosicaoTabela(i);
                        getErros().add(erro);
                        estado = -1;
                        i++;
                        break;

                    }
                }
                case -1: {
                    //Aqui no erro, na verdade eu preciso guardar o erro encontrado que é o getToken, e o esperado
                    //eu preciso setar no momento do erro. O que eu posso fazer é criar uma pilha dos que estão sendo lidos
                    //Após encontrar o erro, vou no topo da pilha e continuo a leitura. 
                    for (int j = 0; j < this.erros.size(); j++) {
                        System.out.println("Token esperado:" + this.erros.get(j).getSimboloEsperado().getToken()
                                + "\nDescrição: " + this.erros.get(j).getDescricao());

                    }

                    System.out.println("\nPilha de Leitura: ");
                    for (int j = 0; j < this.pilhaLeitura.size(); j++) {
                        System.out.println("\nToken: " + this.pilhaLeitura.get(j).getToken());
                        System.out.println("Lexema: " + this.pilhaLeitura.get(j).getLexema());
                    }

                    /*switch (aux.getFollow())   {
                        
                        case "IDENTIFICADOR": 
                            estado = 4;
                            break;
                        case "BLOCO":
                            estado = 2;
                            break;
                        case "PALAVRA_RESERVADA_INT": 
                            estado = 0;
                        
                        case "PALAVRA_RESERVADA_REAL": 
                            estado = 0; 
                    }*/
                    i = this.tabelaSimbolos.size();
                    break;
                }

            }

        }
    }

    /**
     * @return the erros
     */
    public ArrayList<Erro> getErros() {
        return erros;
    }

    /**
     * @param erros the erros to set
     */
    public void setErros(ArrayList<Erro> erros) {
        this.erros = erros;
    }

    public void setFirstFollow() {
        int i = 0;
        while (i != this.tabelaSimbolos.size()) {
            Simbolo auxiliar;
            auxiliar = this.tabelaSimbolos.get(i);
            switch (auxiliar.getToken()) {
                case "PALAVRA_RESERVADA_PROGRAM": {
                    this.tabelaSimbolos.get(i).setFollow("IDENTIFICADOR");
                    this.tabelaSimbolos.get(i).setEstado_atual(1);
                    break;
                }
                case "IDENTIFICADOR": {
                    this.tabelaSimbolos.get(i).setFollow("SIMBOLO_ESPECIAL");
                    this.tabelaSimbolos.get(i).setEstado_atual(10);
                    break;
                }

            }
        }
    }

    /*
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
PALAVRA_RESERVADA_OR = "or"
PALAVRA_RESERVADA_WHILE = "while"
PALAVRA_RESERVADA_PROCEDURE = "procedure"
PALAVRA_RESERVADA_BOOLEAN = "boolean"
PALAVRA_RESERVADA_TRUE = "true"
PALAVRA_RESERVADA_FALSE = "false"; 
PALAVRA_RESERVADA_PROGRAM = "program"
PALAVRA_RESERVADA_VAR = "var"
IDENTIFICADOR = [a-zA-Z]([a-zA-Z]|[0-9])*

AP = "("
FP = ")"

NUMERO_INT = 0 | [1-9][0-9]*
NUMERO_REAL = 0|[1-9][0-9]*[","|"."][0-9][0-9]*
     */
    public void imprimirSimbolos() {
        for (int i = 0; i < this.tabelaSimbolos.size(); i++) {
            Simbolo atual;
            atual = this.tabelaSimbolos.get(i);
            System.out.println("Token: " + atual.getToken() + "\n" + "Lexema: " + atual.getLexema() + "\n" + "Descrição: " + atual.getDescricao());
        }
    }

    public void mapeiafirstfollow() {
        for (int i = 0; i < this.tabelaSimbolos.size(); i++) {
            Simbolo atual;
            atual = this.tabelaSimbolos.get(i);
            switch (atual.getToken()) {
                case "PALAVRA_RESERVADA_PROGRAM":
                    atual.setFollow("IDENTIFICADOR");
                    atual.setFirst("$");
                    break;

                case "IDENTIFICADOR":
                    atual.setFollow("SIMBOLO_ESPECIAL");
                    atual.setFirst("");
                    break;

                case "PALAVRA_RESERVADA_INT":
                    atual.setFollow("IDENTIFICADOR");
                    atual.setFirst("SIMBOLO_ESPECIAL"); //
                    break;

                case "PALAVRA_RESERVADA_FLOAT":
                    atual.setFollow("IDENTIFICADOR");
                    atual.setFirst("SIMBOLO_ESPECIAL"); //
                    break;

                case "PALAVRA_RESERVADA_BEGIN":
                    atual.setFollow("IDENTIFICADOR");
                    atual.setFirst("SIMBOLO_ESPECIAL"); //
                    break;

                case "SIMBOLO_ESPECIAL":
                    atual.setFollow("BLOCO");
                    atual.setFirst("SIMBOLO_ESPECIAL"); //
                    break;
            }

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
