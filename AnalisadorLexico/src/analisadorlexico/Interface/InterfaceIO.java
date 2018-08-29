/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisadorlexico.Interface;

import analisadorlexico.Controlador;
import analisadorlexico.Simbolo;
import java.awt.Color;
import java.awt.Component;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Matheus Palmeira
 */
public class InterfaceIO extends javax.swing.JFrame {

    public Controlador c;
    public ArrayList<Simbolo> saida;
    public DefaultTableModel model;
    public String CLASS;

    /**
     * Creates new form InterfaceIO
     */
    public InterfaceIO() {
        initComponents();
        this.CLASS = "";
        this.outputTextArea.setEditable(false);
        this.setExtendedState(MAXIMIZED_BOTH);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        inputTextArea = new javax.swing.JTextArea();
        editorLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        outputTextArea = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tokenTable = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        arquivoMenu = new javax.swing.JMenu();
        abrirMenuItem = new javax.swing.JMenuItem();
        salvarMenuItem = new javax.swing.JMenuItem();
        sairMenuItem = new javax.swing.JMenuItem();
        lexicoMenu = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        inputTextArea.setColumns(20);
        inputTextArea.setRows(5);
        jScrollPane1.setViewportView(inputTextArea);

        editorLabel.setText("Editor ");

        jLabel2.setText("Saída");

        outputTextArea.setColumns(20);
        outputTextArea.setRows(5);
        jScrollPane2.setViewportView(outputTextArea);

        jLabel3.setText("Tabela de Tokens");

        tokenTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Lexema", "Token", "Linha", "Coluna"
            }
        ));
        jScrollPane4.setViewportView(tokenTable);

        arquivoMenu.setText("Arquivo");

        abrirMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        abrirMenuItem.setText("Abrir");
        abrirMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirMenuItemActionPerformed(evt);
            }
        });
        arquivoMenu.add(abrirMenuItem);

        salvarMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        salvarMenuItem.setText("Salvar");
        salvarMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarMenuItemActionPerformed(evt);
            }
        });
        arquivoMenu.add(salvarMenuItem);

        sairMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        sairMenuItem.setText("Sair");
        sairMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairMenuItemActionPerformed(evt);
            }
        });
        arquivoMenu.add(sairMenuItem);

        jMenuBar1.add(arquivoMenu);

        lexicoMenu.setText("Analisador Léxico");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F8, 0));
        jMenuItem1.setText("Executar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        lexicoMenu.add(jMenuItem1);

        jMenuBar1.add(lexicoMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(editorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(290, 290, 290))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(editorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void abrirMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirMenuItemActionPerformed
        JTextField textLocal = new JTextField();
        String expressao = "";
        JFileChooser file = new JFileChooser();
        int result = file.showOpenDialog(null);
        file.setFileSelectionMode(JFileChooser.FILES_ONLY);
        String pasta = file.getSelectedFile().getAbsolutePath();
        File arquivo = new File(pasta);

        try {
            Scanner br = new Scanner(arquivo);

            //Realizando a leitura da imagem e valorando a matriz a partir dos valores retirados do arquivo. 
            while (br.hasNext()) {
                expressao += br.nextLine();
            }
            System.out.println(expressao);
            c = new Controlador(expressao);
            //c.setExpr(expressao);
            inputTextArea.setText(expressao);
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(InterfaceIO.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_abrirMenuItemActionPerformed

    private void salvarMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarMenuItemActionPerformed
        FileWriter writer = null;
        try {
            String caminho = JOptionPane.showInputDialog(null, "Insira o caminho que deseja salvar a imagem" + "\nExemplo: C://Windows/Users/Você/Pasta");
            String nomeArquivo = JOptionPane.showInputDialog(null, "Insira o nome que deseja salvar o arquivo");
            String caminhoCompleto = caminho + nomeArquivo + ".txt";
            File arquivo = new File(caminhoCompleto);
            writer = new FileWriter(arquivo);
            int i, j;
            //Setando configurações iniciais da imagem para o arquivo
            writer.write(inputTextArea.getText());
            //if (arquivo.length() != 0) {
            //  JOptionPane.showMessageDialog(null, "Arquivo foi gravado com sucesso!");
            //} else {
            //  JOptionPane.showMessageDialog(null, "Arquivo não foi gravado! Algum erro ocorreu");
            //}
        } catch (IOException ex) {
            Logger.getLogger(InterfaceIO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(InterfaceIO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_salvarMenuItemActionPerformed

    private void sairMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairMenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sairMenuItemActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        String expr = inputTextArea.getText();
        c = new Controlador(expr);
        String outText = "";
        Object[] line = new Object[4];
        boolean erro = false;
        ArrayList<Simbolo> erros = new ArrayList();

        this.model = (DefaultTableModel) tokenTable.getModel();
        model.setRowCount(0);

        try {
            this.saida = c.analiseLexica();
            c.imprimirSimbolos();

            for (int i = 0; i < this.saida.size(); i++) {
                Simbolo atual;
                atual = this.saida.get(i);

                //outText += atual.getLexema() + " , " + atual.getDescricao() + "\n";
                line[1] = atual.getToken();
                line[0] = atual.getLexema();
                line[2] = atual.getLinha();
                line[3] = atual.getColuna();

                if (atual.getToken().equals("INVÁLIDO")) {
                    erros.add(atual);
                    erro = true;
                }

                this.model.addRow(line);

            }

            if (erro) {
                outputTextArea.setForeground(Color.RED);
                outText += "\nAnálise Léxica encontrou erro (s)! Corrija e execute novamente!\n";
                for (int i = 0; i < erros.size(); i++) {
                    outText += erros.get(i).getLexema() + " , " + erros.get(i).getDescricao() + "\n";
                }

            } else {
                outputTextArea.setForeground(Color.GREEN);
                outText += "\n Análise Léxica executada com sucesso! Léxica correta.";
            }
            this.tokenTable.setModel(model);
            outputTextArea.setText(outText);
            colorirTabela();

        } catch (IOException ex) {
            Logger.getLogger(InterfaceIO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    public void colorirTabela() {
        this.CLASS = "INVÁLIDO";
        this.tokenTable.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                Color c = Color.WHITE;
                Object texto = table.getValueAt(row, 1);
                if (texto != null && CLASS.equals(texto.toString())) c = Color.RED;
                    label.setBackground(c);
                    tokenTable.setSelectionForeground(Color.GREEN);  
                return label;
            }
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfaceIO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceIO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceIO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceIO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfaceIO().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem abrirMenuItem;
    private javax.swing.JMenu arquivoMenu;
    private javax.swing.JLabel editorLabel;
    private javax.swing.JTextArea inputTextArea;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JMenu lexicoMenu;
    private javax.swing.JTextArea outputTextArea;
    private javax.swing.JMenuItem sairMenuItem;
    private javax.swing.JMenuItem salvarMenuItem;
    private javax.swing.JTable tokenTable;
    // End of variables declaration//GEN-END:variables
}
