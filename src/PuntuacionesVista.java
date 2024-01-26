package vistas;

public class PuntuacionesVista extends javax.swing.JFrame {
    /**
     * Creates new form PuntuacionesVista
     * @param String[]
     */
    public PuntuacionesVista() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbPuntuaciones = new javax.swing.JLabel();
        btnPlayer1 = new javax.swing.JButton();
        lbPlayer1 = new javax.swing.JLabel();
        lbPtn1 = new javax.swing.JLabel();
        btnPlayer2 = new javax.swing.JButton();
        lbPlayer2 = new javax.swing.JLabel();
        lbPtn2 = new javax.swing.JLabel();
        btnPlayer3 = new javax.swing.JButton();
        lbPlayer3 = new javax.swing.JLabel();
        lbPtn3 = new javax.swing.JLabel();
        btnPlayer4 = new javax.swing.JButton();
        lbPlayer4 = new javax.swing.JLabel();
        lbPtn4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Puntuaciones");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbPuntuaciones.setBackground(new java.awt.Color(0, 255, 255));
        lbPuntuaciones.setFont(new java.awt.Font("Times New Roman", 0, 21)); // NOI18N
        lbPuntuaciones.setForeground(new java.awt.Color(0, 0, 0));
        lbPuntuaciones.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPuntuaciones.setText("P U N T U A C I O N E S");
        lbPuntuaciones.setOpaque(true);
        jPanel1.add(lbPuntuaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 50));

        btnPlayer1.setBackground(new java.awt.Color(51, 255, 102));
        btnPlayer1.setForeground(new java.awt.Color(0, 0, 0));
        btnPlayer1.setText("1");
        btnPlayer1.setEnabled(false);
        jPanel1.add(btnPlayer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 64, 50, 20));

        lbPlayer1.setBackground(new java.awt.Color(51, 255, 102));
        lbPlayer1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbPlayer1.setForeground(new java.awt.Color(0, 0, 0));
        lbPlayer1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPlayer1.setText("\"S/N\"");
        lbPlayer1.setOpaque(true);
        jPanel1.add(lbPlayer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 170, 30));

        lbPtn1.setBackground(new java.awt.Color(51, 255, 102));
        lbPtn1.setForeground(new java.awt.Color(0, 0, 0));
        lbPtn1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPtn1.setText("0");
        lbPtn1.setOpaque(true);
        jPanel1.add(lbPtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, 40, 30));

        btnPlayer2.setBackground(new java.awt.Color(255, 255, 0));
        btnPlayer2.setForeground(new java.awt.Color(0, 0, 0));
        btnPlayer2.setText("2");
        btnPlayer2.setEnabled(false);
        jPanel1.add(btnPlayer2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 124, 50, -1));

        lbPlayer2.setBackground(new java.awt.Color(255, 255, 0));
        lbPlayer2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbPlayer2.setForeground(new java.awt.Color(0, 0, 0));
        lbPlayer2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPlayer2.setText("\"S/N\"");
        lbPlayer2.setOpaque(true);
        jPanel1.add(lbPlayer2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 170, 30));

        lbPtn2.setBackground(new java.awt.Color(255, 255, 0));
        lbPtn2.setForeground(new java.awt.Color(0, 0, 0));
        lbPtn2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPtn2.setText("0");
        lbPtn2.setOpaque(true);
        jPanel1.add(lbPtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, 40, 30));

        btnPlayer3.setBackground(new java.awt.Color(255, 153, 0));
        btnPlayer3.setForeground(new java.awt.Color(0, 0, 0));
        btnPlayer3.setText("3");
        btnPlayer3.setEnabled(false);
        jPanel1.add(btnPlayer3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 184, 50, -1));

        lbPlayer3.setBackground(new java.awt.Color(255, 153, 0));
        lbPlayer3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbPlayer3.setForeground(new java.awt.Color(0, 0, 0));
        lbPlayer3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPlayer3.setText("\"S/N\"");
        lbPlayer3.setOpaque(true);
        jPanel1.add(lbPlayer3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 170, 30));

        lbPtn3.setBackground(new java.awt.Color(255, 153, 0));
        lbPtn3.setForeground(new java.awt.Color(0, 0, 0));
        lbPtn3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPtn3.setText("0");
        lbPtn3.setOpaque(true);
        jPanel1.add(lbPtn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, 40, 30));

        btnPlayer4.setBackground(new java.awt.Color(255, 255, 255));
        btnPlayer4.setForeground(new java.awt.Color(0, 0, 0));
        btnPlayer4.setText("4");
        btnPlayer4.setEnabled(false);
        jPanel1.add(btnPlayer4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 244, 50, -1));

        lbPlayer4.setBackground(new java.awt.Color(255, 255, 255));
        lbPlayer4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbPlayer4.setForeground(new java.awt.Color(0, 0, 0));
        lbPlayer4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPlayer4.setText("\"S/N\"");
        lbPlayer4.setOpaque(true);
        jPanel1.add(lbPlayer4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 170, 30));

        lbPtn4.setBackground(new java.awt.Color(255, 255, 255));
        lbPtn4.setForeground(new java.awt.Color(0, 0, 0));
        lbPtn4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPtn4.setText("0");
        lbPtn4.setOpaque(true);
        jPanel1.add(lbPtn4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 240, 40, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 300));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPlayer1;
    private javax.swing.JButton btnPlayer2;
    private javax.swing.JButton btnPlayer3;
    private javax.swing.JButton btnPlayer4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbPlayer1;
    private javax.swing.JLabel lbPlayer2;
    private javax.swing.JLabel lbPlayer3;
    private javax.swing.JLabel lbPlayer4;
    private javax.swing.JLabel lbPtn1;
    private javax.swing.JLabel lbPtn2;
    private javax.swing.JLabel lbPtn3;
    private javax.swing.JLabel lbPtn4;
    private javax.swing.JLabel lbPuntuaciones;
    // End of variables declaration//GEN-END:variables
}