/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoria;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Dell E5420
 */
public class Ventana_Analisis extends javax.swing.JFrame {
    public boolean opcion=true;
    Analizador_Lexico analisis=new Analizador_Lexico();
    Reportes reportes= new Reportes();
    Crear_Reporte cr=new Crear_Reporte();
    
    JFileChooser selec=new JFileChooser();
    File archiv;
    Abrir_Archivo marchi=new Abrir_Archivo();
    
    public Ventana_Analisis() {
        initComponents();
        ((JPanel)getContentPane()).setOpaque(false);
        ImageIcon fondo=new ImageIcon(this.getClass().getResource("/Imagenes/img_1.jpg"));
        JLabel fon=new JLabel();
        fon.setIcon(fondo);
        getLayeredPane().add(fon,JLayeredPane.FRAME_CONTENT_LAYER);
        fon.setBounds(0,0,fondo.getIconWidth() , fondo.getIconHeight());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Area_editor = new javax.swing.JTextArea();
        btn_analizar = new javax.swing.JButton();
        btn_simbolos = new javax.swing.JButton();
        btn_errores = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Area_editor.setColumns(20);
        Area_editor.setRows(5);
        jScrollPane1.setViewportView(Area_editor);

        btn_analizar.setText("Abrir");
        btn_analizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_analizarActionPerformed(evt);
            }
        });

        btn_simbolos.setText("T.Simbolos");
        btn_simbolos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simbolosActionPerformed(evt);
            }
        });

        btn_errores.setText("T.Errores");
        btn_errores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_erroresActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_simbolos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_analizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_errores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(btn_analizar)
                        .addGap(34, 34, 34)
                        .addComponent(btn_simbolos)
                        .addGap(41, 41, 41)
                        .addComponent(btn_errores)))
                .addContainerGap(81, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_analizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_analizarActionPerformed
        if(opcion){
           
           if (selec.showDialog(this, "Abrir archivo")== JFileChooser.APPROVE_OPTION){
                 archiv=selec.getSelectedFile();
                if(archiv.getName().endsWith("lfp")){
                    String contenido=marchi.Abrir(archiv);
                    Area_editor.setText(contenido);
                }else{
                    JOptionPane.showMessageDialog(rootPane, "NO es un archivo .lfp");
                }
             
            }
           opcion=false;
           btn_analizar.setText("Analizar");
           }else{
                String entrada=Area_editor.getText();
                analisis.lexico(entrada);
                reportes.CrearRT(analisis.getArrT());
                reportes.CrearRE(analisis.getArrE());
                opcion=true;
                btn_analizar.setText("Analizar");
        }
        
        
        
        
        
        
    }//GEN-LAST:event_btn_analizarActionPerformed

    private void btn_simbolosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simbolosActionPerformed
        try {

            Desktop.getDesktop().browse(new URI("file:///C:/Users/Dell%20E5420/Documents/Simbolos.html"));

        } catch (URISyntaxException ex) {

            System.out.println(ex);

        }catch(IOException e){

            System.out.println(e);

        }
    }//GEN-LAST:event_btn_simbolosActionPerformed

    private void btn_erroresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_erroresActionPerformed
        try {

            Desktop.getDesktop().browse(new URI("file:///C:/Users/Dell%20E5420/Documents/Errores.html"));

        } catch (URISyntaxException ex) {

            System.out.println(ex);

        }catch(IOException e){

            System.out.println(e);

        }
    }//GEN-LAST:event_btn_erroresActionPerformed

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
            java.util.logging.Logger.getLogger(Ventana_Analisis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana_Analisis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana_Analisis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana_Analisis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana_Analisis().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Area_editor;
    private javax.swing.JButton btn_analizar;
    private javax.swing.JButton btn_errores;
    private javax.swing.JButton btn_simbolos;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
