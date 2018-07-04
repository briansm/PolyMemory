/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoria;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/**
 *
 * @author Dell E5420
 */
public class Juego extends javax.swing.JFrame {

    /**
     * Creates new form Juego
     */
    Crear_Reporte cr=new Crear_Reporte();
    public String cadena;
    public String usuario;
    public void setCadena(String cadena){
        this.cadena=cadena;
    
    }
    
    public String getCadena(){
        return cadena;
    }
    public void setUsuario(String cadena){
        this.usuario=cadena;
    
    }
    
    public String getUsuario(){
        return usuario;
    }
    
    public Juego() {
        initComponents();
        ((JPanel)getContentPane()).setOpaque(false);
        ImageIcon fondo=new ImageIcon(this.getClass().getResource("/Imagenes/menu.png"));
        JLabel fon=new JLabel();
        fon.setIcon(fondo);
        getLayeredPane().add(fon,JLayeredPane.FRAME_CONTENT_LAYER);
        fon.setBounds(0,0,fondo.getIconWidth() , fondo.getIconHeight());
        
        
    }
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bandera = new javax.swing.JLabel();
        jl_Idioma = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jl_Usuario = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        naranja = new javax.swing.JLabel();
        t_pelota = new javax.swing.JTextField();
        pelota = new javax.swing.JLabel();
        t_pantalon = new javax.swing.JTextField();
        pantalon = new javax.swing.JLabel();
        t_naranja = new javax.swing.JTextField();
        guitarra = new javax.swing.JLabel();
        t_guitarra = new javax.swing.JTextField();
        btn_fin = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(java.awt.Color.black);

        jl_Idioma.setForeground(new java.awt.Color(255, 255, 255));
        jl_Idioma.setText("Idioma");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("USUARIO");

        jl_Usuario.setForeground(new java.awt.Color(255, 255, 255));
        jl_Usuario.setText("Carlos");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("TIEMPO");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reversa.png"))); // NOI18N

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/adelante.png"))); // NOI18N

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/play.png"))); // NOI18N

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("LETS GET IT ON.mp3");

        btn_fin.setText("Finalizar");
        btn_fin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_finActionPerformed(evt);
            }
        });

        jButton4.setText("Inicio");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jl_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(bandera, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(94, 94, 94)
                                .addComponent(jl_Idioma, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(jLabel4)))
                .addGap(171, 171, 171)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(t_pelota, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pelota, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(guitarra, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t_guitarra, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(naranja, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t_naranja, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pantalon, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t_pantalon, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(154, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_fin)
                .addGap(304, 304, 304))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bandera, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jl_Idioma))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(naranja)
                        .addComponent(pelota)))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t_pelota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t_naranja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jl_Usuario)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel3)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(pantalon)
                        .addComponent(guitarra)))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t_pantalon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t_guitarra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_fin)
                    .addComponent(jButton4))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_finActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_finActionPerformed
        int puntos=0;
        int correctas=0;
        if(jl_Idioma.getText().equals("Aleman")){
            if(t_pelota.getText().equals("ball")){
                puntos+=25;
                correctas++;
            }else if(t_naranja.getText().equals("orange")){
                puntos+=25;
                correctas++;
            }else if(t_guitarra.getText().equals("gitarre")){
                puntos+=25;
                correctas++;
            }else if(t_pantalon.getText().equals("hosen")){
                puntos+=25;
                correctas++;
            }
        
        
        }else if(jl_Idioma.getText().equals("Frances")){
            if(t_pelota.getText().equals("ballon")){
                puntos+=25;
                correctas++;
            }else if(t_naranja.getText().equals("orange")){
                puntos+=25;
                correctas++;
            }else if(t_guitarra.getText().equals("guitare")){
                puntos+=25;
                correctas++;
            }else if(t_pantalon.getText().equals("pantalon")){
                puntos+=25;
                correctas++;
            }
        
        
        }else if(jl_Idioma.getText().equals("Ingles")){
            if(t_pelota.getText().equals("ball")){
                puntos+=25;
                correctas++;
            }else if(t_naranja.getText().equals("orange")){
                puntos+=25;
                correctas++;
            }else if(t_guitarra.getText().equals("guitar")){
                puntos+=25;
                correctas++;
            }else if(t_pantalon.getText().equals("pants")){
                puntos+=25;
                correctas++;
            }
        }else if(jl_Idioma.getText().equals("Español")){
            if(t_pelota.getText().equals("pelota")){
                puntos+=25;
                correctas++;
            }else if(t_naranja.getText().equals("naranja")){
                puntos+=25;
                correctas++;
            }else if(t_guitarra.getText().equals("guitarra")){
                puntos+=25;
                correctas++;
            }else if(t_pantalon.getText().equals("pants")){
                puntos+=25;
                correctas++;
            }
        }
        
        
        String reporte = "[Reporte]\n"
                        +"[Juego]\n"
                        +"[Usuario]="+"["+jl_Usuario.getText()+"]\n"
                        +"[Tiempo]="+"["+"20"+"]\n"
                        +"[Idioma]="+"["+jl_Idioma.getText()+"]\n"
                        +"[Palabras Correctas]="+"["+correctas+"]\n"
                        +"[Fin-Juego]\n";
        
        cr.guardarReporte(reporte, "Reporte");
    }//GEN-LAST:event_btn_finActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        jl_Idioma.setText(cadena);
        jl_Usuario.setText(usuario);
        ImageIcon fondoPel=new ImageIcon(this.getClass().getResource("/Imagenes/pelota.jpg"));
        ImageIcon fondoNa=new ImageIcon(this.getClass().getResource("/Imagenes/naranja.jpg"));
        ImageIcon fondoPant=new ImageIcon(this.getClass().getResource("/Imagenes/pantalon.jpg"));
        ImageIcon fondoG=new ImageIcon(this.getClass().getResource("/Imagenes/guitarra.jpg"));
        pelota.setIcon(fondoPel);
        naranja.setIcon(fondoNa);
        pantalon.setIcon(fondoPant);
        guitarra.setIcon(fondoG);
        if(jl_Idioma.getText().equals("Aleman")){
            ImageIcon fondo=new ImageIcon(this.getClass().getResource("/Imagenes/alemania.png"));
            bandera.setIcon(fondo);
        }else if(jl_Idioma.getText().equals("Frances")){
            ImageIcon fondo=new ImageIcon(this.getClass().getResource("/Imagenes/francia.png"));
            bandera.setIcon(fondo);
        }else if(jl_Idioma.getText().equals("Ingles")){
            ImageIcon fondo=new ImageIcon(this.getClass().getResource("/Imagenes/usa.png"));
            bandera.setIcon(fondo);
        }else if(jl_Idioma.getText().equals("Español")){
            ImageIcon fondo=new ImageIcon(this.getClass().getResource("/Imagenes/guate.png"));
            bandera.setIcon(fondo);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Juego().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bandera;
    private javax.swing.JButton btn_fin;
    private javax.swing.JLabel guitarra;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jl_Idioma;
    private javax.swing.JLabel jl_Usuario;
    private javax.swing.JLabel naranja;
    private javax.swing.JLabel pantalon;
    private javax.swing.JLabel pelota;
    private javax.swing.JTextField t_guitarra;
    private javax.swing.JTextField t_naranja;
    private javax.swing.JTextField t_pantalon;
    private javax.swing.JTextField t_pelota;
    // End of variables declaration//GEN-END:variables
}
