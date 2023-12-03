package puntuaciones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PuntuacionesVista extends JFrame implements ActionListener {
    
    private JPanel pnTitle, pnImages, pnPlayers, pnPts, pnExit;
    private JLabel lbPuntuaciones, lbPlayer1, lbPlayer2, lbPlayer3, lbPlayer4, lbPunt1, lbPunt2, lbPunt3, lbPunt4;
    private JButton btGold, btBronze, btSilver, btGray, btExit;
    
    public PuntuacionesVista() {

        this.getContentPane().setBackground(Color.DARK_GRAY);
        this.setLayout(new BorderLayout(30,5));
        this.setLocation(500,200);
        this.setSize(300, 300);
        this.setLocationRelativeTo(null);

        pnTitle = new JPanel();
        pnTitle.setLayout(new FlowLayout());
        pnTitle.setBackground(Color.DARK_GRAY);
        pnTitle.setBorder(BorderFactory.createRaisedBevelBorder());

        pnImages = new JPanel();
        pnImages.setLayout(new GridLayout(4,1,10,30));
        pnImages.setBackground(Color.DARK_GRAY);

        pnPlayers = new JPanel();
        pnPlayers.setLayout(new GridLayout(4,1,5,30));
        pnPlayers.setBackground(Color.DARK_GRAY);

        pnPts = new JPanel();
        pnPts.setLayout(new GridLayout(4,1,5,30));
        pnPts.setBackground(Color.DARK_GRAY);
        
        pnExit = new JPanel();
        pnExit.setLayout(new FlowLayout());
        pnExit.setBackground(Color.DARK_GRAY);

        lbPuntuaciones = new JLabel("P U N T U A C I O N E S");
        lbPuntuaciones.setFont(new Font("Times New Roman",Font.BOLD,21));

        btGold = new JButton("  1°  ");
        btGold.setFont(new Font("Times New Roman",Font.BOLD,15));

        btGold.setBackground(Color.YELLOW);
        btGold.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder()));

        btBronze = new JButton("  2°  ");
        btBronze.setFont(new Font("Times New Roman",Font.BOLD,15));

        btBronze.setBackground(Color.ORANGE);
        btBronze.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder()));

        btSilver = new JButton("  3°  ");
        btSilver.setFont(new Font("Times New Roman",Font.BOLD,15));
        btSilver.setBackground(Color.GRAY);
        btSilver.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder()));
        
        btGray = new JButton("  4°  ");
        btGray.setFont(new Font("Times New Roman",Font.BOLD,15));
        btGray.setBackground(Color.WHITE);
        btGray.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder()));

        lbPlayer1 = new JLabel("EQUIPO8");
        lbPlayer1.setFont(new Font("Times New Roman",Font.TYPE1_FONT,15));
        lbPlayer1.setBackground(Color.red);
        lbPlayer1.setOpaque(true);
        lbPlayer1.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder()));

        lbPlayer2 = new JLabel("EQUIPO8");
        lbPlayer2.setFont(new Font("Times New Roman",Font.TYPE1_FONT,15));
        lbPlayer2.setBackground(Color.green);
        lbPlayer2.setOpaque(true);
        lbPlayer2.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder()));

        lbPlayer3 = new JLabel("EQUIPO8");
        lbPlayer3.setFont(new Font("Times New Roman",Font.TYPE1_FONT,15));
        lbPlayer3.setBackground(Color.cyan);
        lbPlayer3.setOpaque(true);
        lbPlayer3.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder()));

        lbPlayer4 = new JLabel("EQUIPO8");
        lbPlayer4.setFont(new Font("Times New Roman",Font.TYPE1_FONT,15));
        lbPlayer4.setBackground(Color.pink);
        lbPlayer4.setOpaque(true);
        lbPlayer4.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder()));
        
        lbPunt1 = new JLabel("0000");
        add(lbPunt1);
        lbPunt1.setFont(new Font("Times New Roman",Font.TYPE1_FONT,15));
        lbPunt1.setBackground(Color.red);
        lbPunt1.setOpaque(true);
        lbPunt1.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder()));

        lbPunt2 = new JLabel("0000");
        add(lbPunt2);
        lbPunt2.setFont(new Font("Times New Roman",Font.TYPE1_FONT,15));
        lbPunt2.setBackground(Color.green);
        lbPunt2.setOpaque(true);
        lbPunt2.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder()));

        lbPunt3 = new JLabel("0000");
        add(lbPunt3);
        lbPunt3.setFont(new Font("Times New Roman",Font.TYPE1_FONT,15));
        lbPunt3.setBackground(Color.cyan);
        lbPunt3.setOpaque(true);
        lbPunt3.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder()));

        lbPunt4 = new JLabel("0000");
        add(lbPunt4);
        lbPunt4.setFont(new Font("Times New Roman",Font.TYPE1_FONT,15));
        lbPunt4.setBackground(Color.pink);
        lbPunt4.setOpaque(true);
        lbPunt4.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder()));
        
        btExit = new JButton("  SALIR ");
        btExit.setForeground(Color.WHITE);
        btExit.setBackground(Color.BLUE);
        btExit.setBorder(BorderFactory.createRaisedBevelBorder());
        btExit.addActionListener(this);
        add(pnTitle,BorderLayout.NORTH);
        pnTitle.add(lbPuntuaciones);
        pnTitle.setBackground(Color.MAGENTA);
        add(pnImages,BorderLayout.WEST);
        pnImages.add(btGold);
        pnImages.add(btBronze);
        pnImages.add(btSilver);
        pnImages.add(btGray);
        add(pnPlayers,BorderLayout.CENTER);
        pnPlayers.add(lbPlayer1);
        pnPlayers.add(lbPlayer2);
        pnPlayers.add(lbPlayer3);
        pnPlayers.add(lbPlayer4);
        add(pnPts,BorderLayout.EAST);
        pnPts.add(lbPunt1);
        pnPts.add(lbPunt2);
        pnPts.add(lbPunt3);
        pnPts.add(lbPunt4);
        add(pnExit,BorderLayout.SOUTH);
        pnExit.add(btExit);
    }

    private void setupUI() {
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        this.setVisible(false);
    }
    //actualizamos puntuaciones
    public void actualizarPuntuacion1(int puntuacionU){
       lbPunt1.setText(  String.valueOf(puntuacionU));
    }
    
    public void actualizarPuntuacion2(int puntuacionU){
       lbPunt2.setText(  String.valueOf(puntuacionU));
    }
    
    public void actualizarPuntuacion3(int puntuacionU){
       lbPunt3.setText( String.valueOf(puntuacionU));
    }
    
    public void actualizarPuntuacion4(int puntuacionU){
       lbPunt4.setText( String.valueOf(puntuacionU));
    }
    //actualizamos nombre
    public void actualizarNombre1(String user){
       lbPlayer1.setText(String.valueOf(user));
    }
    public void actualizarNombre2(String user){
       lbPlayer2.setText(String.valueOf(user));
    }
    public void actualizarNombre3(String user){
       lbPlayer3.setText(String.valueOf(user));
    }
    public void actualizarNombre4(String user){
       lbPlayer4.setText(String.valueOf(user));
    }
    
    //obtenemos texto para cambiarlo y poder comparar
     public String obtenerTextoJLabel1() {
        return lbPunt1.getText();
    }

    public String obtenerTextoJLabel2() {
        return lbPunt2.getText();
    }

    public String obtenerTextoJLabel3() {
        return lbPunt3.getText();
    }

    public String obtenerTextoJLabel4() {
        return lbPunt4.getText();
    }
    
    public static void mostrarInterfaz() {
        SwingUtilities.invokeLater(() -> {
            
                PuntuacionesVista puntuaciones = new PuntuacionesVista();
                puntuaciones.setupUI(); // Llama al método setupUI para hacer visible la ventana
           
        });
   }
}