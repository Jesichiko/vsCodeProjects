package tetris;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

 
public class Tetris extends JFrame implements KeyListener {
    int pos[] = {0,1};
    boolean bottom = false;
    int n = 20;
    int m = 10;
    JButton b[][];
    Color tmp[][] = new Color[m][n];
    int rand = 0;
    int centralx = 0;
    int centraly = 0;
    int deltax = 0;
    int perim[][] = new int[m+4][n+4];
    or[][][] prof = new or[4][4][7];
    Color rnd[] = {Color.red, Color.yellow, Color.cyan, Color.green, Color.white, Color.blue, Color.orange};
    int rowsclrd = 0;
    Timer timer = new Timer(500, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Este código se ejecutará después del tiempo especificado
                movedown();
            // Verificar si hay filas completas y eliminarlas
                rowcheck();
                if(bottom == true){
                    bottom = false;
                    blockgen();
                }
            }
        });
    public Tetris(){
        for(int a = 0;a<4;a++){                 //El primer bucle (for (int a = 0; a < 4; a++)) itera sobre la dimensión a (representando las piezas).
            for(int d = 0;d<4;d++){             //El segundo bucle (for (int b = 0; b < 4; b++)) itera sobre la dimensión b (representando las filas de cada matriz de orientación).
                for(int c = 0;c<7;c++){         //El tercer bucle (for (int c = 0; c < 7; c++)) itera sobre la dimensión c (representando las columnas de cada matriz de orientación).
                    prof[a][d][c] = new or();   //se crea una nueva instancia de la clase or y se asigna a la posición correspondiente de la matriz tridimensional prof. Esto se realiza para cada posición en la matriz, lo que asegura que todas las orientaciones de todas las piezas estén inicializadas con instancias de la clase or.
                }
            }
        }
     
        prof[0][0][0].x = -1; //Estas líneas asignan valores a las propiedades x de instancias específicas de la clase or en la matriz prof. Parece que estas asignaciones están configurando las coordenadas x de una de las orientaciones de una pieza Tetris.
        prof[0][1][0].x = 0;
        prof[0][2][0].x = 0;
        prof[0][3][0].x = 1;
        prof[1][0][0].x = 0;
        prof[1][1][0].x = 0;
        prof[1][2][0].x = -1;  //Estas asignaciones definen las coordenadas horizontales de los bloques. habrá otras asignaciones en el código para las coordenadas y y color, lo que define completamente la forma y apariencia de las piezas en esa orientación específica.
        prof[1][3][0].x = -1;
        prof[2][0][0].x = 1;
        prof[2][1][0].x = 0;
        prof[2][2][0].x = 0;
        prof[2][3][0].x = -1;
        prof[3][0][0].x = 0;
        prof[3][1][0].x = 0;
        prof[3][2][0].x = 1;
        prof[3][3][0].x = 1;
        prof[0][0][1].x = -1;
        prof[0][1][1].x = -1;
        prof[0][2][1].x = 0;
        prof[0][3][1].x = 1;
        prof[1][0][1].x = -1;
        prof[1][1][1].x = 0;
        prof[1][2][1].x = 0;
        prof[1][3][1].x = 0;
        prof[2][0][1].x = 1;
        prof[2][1][1].x = 1;
        prof[2][2][1].x = 0;
        prof[2][3][1].x = -1;
        prof[3][0][1].x = 1;
        prof[3][1][1].x = 0;
        prof[3][2][1].x = 0;
        prof[3][3][1].x = 0;
        prof[0][0][2].x = -1;
        prof[0][1][2].x = 0;
        prof[0][2][2].x = 1;
        prof[0][3][2].x = 1;
        prof[1][0][2].x = 0;
        prof[1][1][2].x = 0;
        prof[1][2][2].x = 0;
        prof[1][3][2].x = -1;
        prof[2][0][2].x = 1;
        prof[2][1][2].x = 0;
        prof[2][2][2].x = -1;
        prof[2][3][2].x = -1;
        prof[3][0][2].x = 0;
        prof[3][1][2].x = 0;
        prof[3][2][2].x = 0;
        prof[3][3][2].x = 1;
        prof[0][0][3].x = -1;
        prof[0][1][3].x = 0;
        prof[0][2][3].x = 0;
        prof[0][3][3].x = 1;
        prof[1][0][3].x = -1;
        prof[1][1][3].x = -1;
        prof[1][2][3].x = 0;
        prof[1][3][3].x = 0;
        prof[2][0][3].x = 1;
        prof[2][1][3].x = 0;
        prof[2][2][3].x = 0;
        prof[2][3][3].x = -1;
        prof[3][0][3].x = 1;
        prof[3][1][3].x = 1;
        prof[3][2][3].x = 0;
        prof[3][3][3].x = 0;
        prof[0][0][4].x = -1;
        prof[0][1][4].x = 0;
        prof[0][2][4].x = 0;
        prof[0][3][4].x = 1;
        prof[1][0][4].x = 0;
        prof[1][1][4].x = 0;
        prof[1][2][4].x = -1;
        prof[1][3][4].x = 0;
        prof[2][0][4].x = 1;
        prof[2][1][4].x = 0;
        prof[2][2][4].x = 0;
        prof[2][3][4].x = -1;
        prof[3][0][4].x = 0;
        prof[3][1][4].x = 0;
        prof[3][2][4].x = 1;
        prof[3][3][4].x = 0;
        prof[0][0][5].x = 0;
        prof[0][1][5].x = 0;
        prof[0][2][5].x = 1;
        prof[0][3][5].x = 1;
        prof[1][0][5].x = 0;
        prof[1][1][5].x = 0;
        prof[1][2][5].x = 1;
        prof[1][3][5].x = 1;
        prof[2][0][5].x = 0;
        prof[2][1][5].x = 0;
        prof[2][2][5].x = 1;
        prof[2][3][5].x = 1;
        prof[3][0][5].x = 0;
        prof[3][1][5].x = 0;
        prof[3][2][5].x = 1;
        prof[3][3][5].x = 1;
        prof[0][0][6].x = -1;
        prof[0][1][6].x = 0;
        prof[0][2][6].x = 1;
        prof[0][3][6].x = 2;
        prof[1][0][6].x = 0;
        prof[1][1][6].x = 0;
        prof[1][2][6].x = 0;
        prof[1][3][6].x = 0;
        prof[2][0][6].x = 1;
        prof[2][1][6].x = 0;
        prof[2][2][6].x = -1;
        prof[2][3][6].x = -2;
        prof[3][0][6].x = 0;
        prof[3][1][6].x = 0;
        prof[3][2][6].x = 0;
        prof[3][3][6].x = 0;
        prof[0][0][0].y = 0;
        prof[0][1][0].y = 0;
        prof[0][2][0].y = 1;
        prof[0][3][0].y = 1;
        prof[1][0][0].y = -1;
        prof[1][1][0].y = 0;
        prof[1][2][0].y = 0;
        prof[1][3][0].y = 1;
        prof[2][0][0].y = 0;
        prof[2][1][0].y = 0;
        prof[2][2][0].y = -1;
        prof[2][3][0].y = -1;
        prof[3][0][0].y = 1;
        prof[3][1][0].y = 0;
        prof[3][2][0].y = 0;
        prof[3][3][0].y = -1;
        prof[0][0][1].y = 0;
        prof[0][1][1].y = 1;
        prof[0][2][1].y = 0;
        prof[0][3][1].y = 0;
        prof[1][0][1].y = -1;
        prof[1][1][1].y = -1;
        prof[1][2][1].y = 0;
        prof[1][3][1].y = 1;
        prof[2][0][1].y = -1;
        prof[2][1][1].y = 0;
        prof[2][2][1].y = 0;
        prof[2][3][1].y = 0;
        prof[3][0][1].y = 1;
        prof[3][1][1].y = 1;
        prof[3][2][1].y = 0;
        prof[3][3][1].y = -1;
        prof[0][0][2].y = 0;
        prof[0][1][2].y = 0;
        prof[0][2][2].y = 0;
        prof[0][3][2].y = 1;
        prof[1][0][2].y = -1;
        prof[1][1][2].y = 0;
        prof[1][2][2].y = 1;
        prof[1][3][2].y = 1;
        prof[2][0][2].y = 0;
        prof[2][1][2].y = 0;
        prof[2][2][2].y = 0;
        prof[2][3][2].y = -1;
        prof[3][0][2].y = 1;
        prof[3][1][2].y = 0;
        prof[3][2][2].y = -1;
        prof[3][3][2].y = -1;
        prof[0][0][3].y = 1;
        prof[0][1][3].y = 1;
        prof[0][2][3].y = 0;
        prof[0][3][3].y = 0;
        prof[1][0][3].y = -1;
        prof[1][1][3].y = 0;
        prof[1][2][3].y = 0;
        prof[1][3][3].y = 1;
        prof[2][0][3].y = -1;
        prof[2][1][3].y = -1;
        prof[2][2][3].y = 0;
        prof[2][3][3].y = 0;
        prof[3][0][3].y = 1;
        prof[3][1][3].y = 0;
        prof[3][2][3].y = 0;
        prof[3][3][3].y = -1;
        prof[0][0][4].y = 0;
        prof[0][1][4].y = 0;
        prof[0][2][4].y = 1;
        prof[0][3][4].y = 0;
        prof[1][0][4].y = -1;
        prof[1][1][4].y = 0;
        prof[1][2][4].y = 0;
        prof[1][3][4].y = 1;
        prof[2][0][4].y = 0;
        prof[2][1][4].y = 0;
        prof[2][2][4].y = -1;
        prof[2][3][4].y = 0;
        prof[3][0][4].y = 1;
        prof[3][1][4].y = 0;
        prof[3][2][4].y = 0;
        prof[3][3][4].y = -1;
        prof[0][0][5].y = 0;
        prof[0][1][5].y = 1;
        prof[0][2][5].y = 0;
        prof[0][3][5].y = 1;
        prof[1][0][5].y = 0;
        prof[1][1][5].y = 1;
        prof[1][2][5].y = 0;
        prof[1][3][5].y = 1;
        prof[2][0][5].y = 0;
        prof[2][1][5].y = 1;
        prof[2][2][5].y = 0;
        prof[2][3][5].y = 1;
        prof[3][0][5].y = 0;
        prof[3][1][5].y = 1;
        prof[3][2][5].y = 0;
        prof[3][3][5].y = 1;
        prof[0][0][6].y = 0;
        prof[0][1][6].y = 0;
        prof[0][2][6].y = 0;
        prof[0][3][6].y = 0;
        prof[1][0][6].y = -1;
        prof[1][1][6].y = 0;
        prof[1][2][6].y = 1;
        prof[1][3][6].y = 2;
        prof[2][0][6].y = 0;
        prof[2][1][6].y = 0;
        prof[2][2][6].y = 0;
        prof[2][3][6].y = 0;
        prof[3][0][6].y = -1;
        prof[3][1][6].y = 0;
        prof[3][2][6].y = 1;
        prof[3][3][6].y = 2;
        for (int y = 0;y<2;y++){
            for (int x = 0;x<m+4;x++){
                perim[x][y]= 1;
            }
        }
        for (int y = n+2;y<n+4;y++){  //Esta parte del código realiza varias operaciones relacionadas con la configuración del perímetro del tablero de Tetris y la inicialización de la interfaz de usuario.
            for (int x = 0;x<m+4;x++){ 
                perim[x][y]= 4;
            }
        }
        for (int y = 2;y<n+2;y++){
            for (int x = 0;x<2;x++){
                perim[x][y]= 2;
            }
        }
        for (int y = 2;y<n+2;y++){
            for (int x = m+2;x<m+4;x++){
                perim[x][y]= 2;
            }
        }
        for(int y = 0;y<n+4;y++){
            for (int x = 0;x<m+4;x++){
                System.out.print(perim[x][y]);
            }
            System.out.println("Aqui si jala");
        }
        b = new JButton [m][n];  //Se crea un arreglo bidimensional de botones llamado b con dimensiones m por n. Cada elemento de este arreglo será un botón en la interfaz gráfica.
        setLayout(new GridLayout(n,m)); //Se establece el diseño de la interfaz gráfica como una cuadrícula (GridLayout) con n filas y m columnas. Aquí, las dimensiones de la cuadrícula están definidas por las variables n y m.
        for (int y = 0;y<n;y++){  //Se utiliza un bucle anidado para recorrer todas las filas (y) y columnas (x) del arreglo de botones. Para cada posición (x, y), se realiza lo siguiente:
            for (int x = 0;x<m;x++){
                b[x][y] = new JButton(" "); //Se crea un nuevo botón y se asigna al elemento correspondiente en el arreglo b.
                tmp[x][y] = Color.DARK_GRAY; //Se asigna el color Color.DARK_GRAY a la posición (x, y) en el arreglo tmp.
                b[x][y].setBackground(Color.DARK_GRAY); //Se establece el color de fondo del botón en Color.DARK_GRAY.
                add(b[x][y]); //Se agrega el botón a la interfaz gráfica.
                b[x][y].setEnabled(false); //Se habilita el botón.
            }
        }
        setFocusable(true); //Esta línea establece la propiedad de enfoque del JFrame como verdadera. Esto es importante cuando se trabaja con eventos del teclado, ya que indica que el JFrame puede recibir el enfoque y responder a eventos de teclado
        addKeyListener(this); //Esto significa que el JFrame está escuchando eventos del teclado y tiene métodos como keyPressed, keyReleased, y keyTyped que responderán a acciones del teclado
        pack(); //Este método redimensiona el JFrame para que tenga el tamaño preferido de su diseño y componentes. 
        setVisible(true); //Hace visible el JFrame. Esta línea de código muestra la interfaz gráfica del juego Tetris al usuario.
         //Este método no está visible en el código proporcionado, pero se menciona al final. Supongo que es un método personalizado que se encarga de generar un nuevo bloque en el juego Tetris. La generación de bloques es fundamental para el progreso y la jugabilidad del juego.
        
    }//end constructor Mine()
 
    public void setSpeed(int s){
        timer.setDelay(s*1000);
    }
    
    class or {  //esta clase se utiliza para definir las coordenadas de los bloques en las diferentes formas y orientaciones que pueden tomar en el juego. 
        int x;
        int y;
    }
 
    public void blockgen(){
        Component temporaryLostComponent = null;
        pos[0] = 0;
        pos[1] = 1;
        rand = (int) (Math.floor(Math.random()*7+1));
        centralx = 4;
        centraly = 0;
        System.out.print(rand); // Verifica si las posiciones donde se generará el nuevo bloque están disponibles
        if ((b[4+prof[pos[0]][0][rand-1].x][prof[pos[0]][0][rand-1].y].getBackground() == Color.DARK_GRAY) &&
        (b[4+prof[pos[0]][1][rand-1].x][prof[pos[0]][1][rand-1].y].getBackground() == Color.DARK_GRAY) &&
        (b[4+prof[pos[0]][2][rand-1].x][prof[pos[0]][2][rand-1].y].getBackground() == Color.DARK_GRAY) &&
        (b[4+prof[pos[0]][3][rand-1].x][prof[pos[0]][3][rand-1].y].getBackground() == Color.DARK_GRAY)){ 
            //// Asigna el color del bloque al fondo de los botones correspondientes
            b[4+prof[pos[0]][0][rand-1].x][prof[pos[0]][0][rand-1].y].setBackground(rnd[rand-1]);
            b[4+prof[pos[0]][1][rand-1].x][prof[pos[0]][1][rand-1].y].setBackground(rnd[rand-1]);
            b[4+prof[pos[0]][2][rand-1].x][prof[pos[0]][2][rand-1].y].setBackground(rnd[rand-1]);
            b[4+prof[pos[0]][3][rand-1].x][prof[pos[0]][3][rand-1].y].setBackground(rnd[rand-1]);
            timer.start(); //// Iniciamos el temporizador, que practicamente es iniciar el juego
        } else {
            //// Si no hay espacio para el nuevo bloque, muestra un mensaje de Game Over y cierra el juego
            timer.stop();
            JOptionPane.showMessageDialog(temporaryLostComponent, "Game Over! You cleared "+rowsclrd+" rows, well done!");
            //System.exit(0);
        }
    }
 
    public void rotate(){
        if (pos[0] < 3){
            pos[1] = pos[0];
        pos[0]++;
        } else if (pos[0] == 3){
            pos[0] = 0;
            pos[1] = 3;
        } else {
            System.out.println("error");
        }
        // Verifica si es posible realizar la rotación sin colisiones con los bordes y otros bloques
        if ((perim[2+centralx+prof[pos[0]][0][rand-1].x][centraly+prof[pos[0]][0][rand-1].y+2] != 4) && (perim[2+centralx+prof[pos[0]][0][rand-1].x][centraly+prof[pos[0]][0][rand-1].y+2] != 1) && (perim[2+centralx+prof[pos[0]][0][rand-1].x][centraly+prof[pos[0]][0][rand-1].y+2] != 2) && (perim[2+centralx+prof[pos[0]][0][rand-1].x][centraly+prof[pos[0]][0][rand-1].y+2] != 3)
        && (perim[centralx+2+prof[pos[0]][1][rand-1].x][centraly+prof[pos[0]][1][rand-1].y+2] != 4) && (perim[centralx+2+prof[pos[0]][1][rand-1].x][centraly+prof[pos[0]][1][rand-1].y+2] != 1) && (perim[centralx+2+prof[pos[0]][1][rand-1].x][centraly+prof[pos[0]][1][rand-1].y+2] != 2) && (perim[centralx+2+prof[pos[0]][1][rand-1].x][centraly+prof[pos[0]][1][rand-1].y+2] != 3)
        && (perim[centralx+2+prof[pos[0]][2][rand-1].x][centraly+prof[pos[0]][2][rand-1].y+2] != 4) && (perim[centralx+2+prof[pos[0]][2][rand-1].x][centraly+prof[pos[0]][2][rand-1].y+2] != 1) && (perim[centralx+2+prof[pos[0]][2][rand-1].x][centraly+prof[pos[0]][2][rand-1].y+2] != 2) && (perim[centralx+2+prof[pos[0]][2][rand-1].x][centraly+prof[pos[0]][2][rand-1].y+2] != 3)
        && (perim[centralx+prof[pos[0]][3][rand-1].x+2][centraly+prof[pos[0]][3][rand-1].y+2] != 4) && (perim[centralx+prof[pos[0]][3][rand-1].x+2][centraly+prof[pos[0]][3][rand-1].y+2] != 1) && (perim[centralx+prof[pos[0]][3][rand-1].x+2][centraly+prof[pos[0]][3][rand-1].y+2] != 2) && (perim[centralx+prof[pos[0]][3][rand-1].x+2][centraly+prof[pos[0]][3][rand-1].y+2] != 3)){
            // Borra el bloque actual
            b[centralx+prof[pos[1]][0][rand-1].x][centraly+prof[pos[1]][0][rand-1].y].setBackground(Color.DARK_GRAY);
            b[centralx+prof[pos[1]][1][rand-1].x][centraly+prof[pos[1]][1][rand-1].y].setBackground(Color.DARK_GRAY);
            b[centralx+prof[pos[1]][2][rand-1].x][centraly+prof[pos[1]][2][rand-1].y].setBackground(Color.DARK_GRAY);
            b[centralx+prof[pos[1]][3][rand-1].x][centraly+prof[pos[1]][3][rand-1].y].setBackground(Color.DARK_GRAY);
            // Coloca el bloque rotado
            b[centralx+(prof[pos[0]][0][rand-1].x)][centraly+(prof[pos[0]][0][rand-1].y)].setBackground(rnd[rand-1]);
            b[centralx+(prof[pos[0]][1][rand-1].x)][centraly+(prof[pos[0]][1][rand-1].y)].setBackground(rnd[rand-1]);
            b[centralx+(prof[pos[0]][2][rand-1].x)][centraly+(prof[pos[0]][2][rand-1].y)].setBackground(rnd[rand-1]);
            b[centralx+(prof[pos[0]][3][rand-1].x)][centraly+(prof[pos[0]][3][rand-1].y)].setBackground(rnd[rand-1]);
        } else {
             // Si no es posible rotar, revierte la rotación
            if (pos[1] > 0){
                pos[0] = pos[1];
                pos[1]--;
            } else if (pos[1] == 0){
                pos[0] = 0;
                pos[1] = 3;
            }
        }
    }
 
 
    public int getxs(){
        int xs = 0;
        int[] xf = {-1, -1, -1, -1};
        // Itera sobre las 4 partes del bloque actual
        for (int d = 0;d<4;d++){
            // Verifica si la coordenada x actual ya se ha registrado
            if ((xf[0] != prof[pos[0]][d][rand-1].x) || (xf[1] != prof[pos[0]][d][rand-1].x) || (xf[2] != prof[pos[0]][d][rand-1].x) || (xf[3] != prof[pos[0]][d][rand-1].x)){
                // Registra la coordenada x actual
                xf[d] = prof[pos[0]][d][rand-1].x;
            }
        }
        // Cuenta el número de coordenadas x diferentes
        for (int d = 0;d<4;d++){
            if (xf[d] != -1){
                xs++;
            }
        }
        // Retorna el número de coordenadas x diferentes
        return xs;
    }
 
 
    public void movedown(){
        // Arrays para rastrear las diferentes posiciones relativas de las partes del bloque
        int[] m2 = {-1, -1, -1, -1};
        int[] m1 = {-1, -1, -1, -1};
        int[] zero = {-1, -1, -1, -1};
        int[] one = {-1, -1, -1, -1};
        int[] two = {-1, -1, -1, -1};
        // Llenar los arrays con las posiciones relativas de las partes del bloque
        for (int d = 0;d<4;d++){
            if (prof[pos[0]][d][rand-1].x == -2){
                m2[d] = d;
            } else if (prof[pos[0]][d][rand-1].x == -1){
                m1[d] = d;
            } else if (prof[pos[0]][d][rand-1].x == 0){
                zero[d] = d;
            } else if (prof[pos[0]][d][rand-1].x == 1){
                one[d] = d;
            } else if (prof[pos[0]][d][rand-1].x == 2){
                two[d] = d;
            }
        }
        // Variables temporales para almacenar las posiciones relativas más bajas en cada categoría
        int tmpm2 = -5;
        int tmpm1 = -5;
        int tmpzero = -5;
        int tmpone = -5;
        int tmptwo = -5;
        // Encontrar las posiciones relativas más bajas en cada categoría
        for (int d = 0;d<4;d++){
            if (m2[d] != -1){
                if (tmpm2<prof[pos[0]][m2[d]][rand-1].y){
                    tmpm2 = prof[pos[0]][m2[d]][rand-1].y;
                }
            }
            if (m1[d] != -1){
                if (tmpm1<prof[pos[0]][m1[d]][rand-1].y){
                    tmpm1 = prof[pos[0]][m1[d]][rand-1].y;
                }
            }
            if (zero[d] != -1){
                if (tmpzero<prof[pos[0]][zero[d]][rand-1].y){
                    tmpzero = prof[pos[0]][zero[d]][rand-1].y;
                }
            }
            if (one[d] != -1){
                if (tmpone<prof[pos[0]][one[d]][rand-1].y){
                    tmpone = prof[pos[0]][one[d]][rand-1].y;
                }
            }
            if (two[d] != -1){
                if (tmptwo<prof[pos[0]][two[d]][rand-1].y){
                    tmptwo = prof[pos[0]][two[d]][rand-1].y;
                }
            }
        }
        // Verificar si es posible mover el bloque hacia abajo
        int total = 0;
        for (int d = 0;d<4;d++){
            if (prof[pos[0]][d][rand-1].x == -2){
                if (perim[2+centralx+-2][2+centraly+tmpm2+1] != 4){
                    if(b[centralx+-2][centraly+tmpm2+1].getBackground() == Color.DARK_GRAY){
                        total++;
                    }
                }
            } else if (prof[pos[0]][d][rand-1].x == -1){
                if (perim[2+centralx+-1][2+centraly+tmpm1+1] != 4){
                    if (b[centralx+-1][centraly+tmpm1+1].getBackground() == Color.DARK_GRAY){
                        total++;
                    }
                }
            } else if (prof[pos[0]][d][rand-1].x == 0){
                if (perim[2+centralx][2+centraly+tmpzero+1] != 4){
                    if (b[centralx][centraly+tmpzero+1].getBackground() == Color.DARK_GRAY){
                        total++;
                    }
                }
            } else if (prof[pos[0]][d][rand-1].x == 1){
                if (perim[2+centralx+1][2+centraly+tmpone+1] != 4){
                    if (b[centralx+1][centraly+tmpone+1].getBackground() == Color.DARK_GRAY){
                        total++;
                    }
                }
            } else if (prof[pos[0]][d][rand-1].x == 2){
                if (perim[2+centralx+2][2+centraly+tmptwo+1] != 4){
                    if (b[centralx+2][centraly+tmptwo+1].getBackground() == Color.DARK_GRAY){
                        total++;
                    }
                }
            }
        }
        // Realizar el movimiento hacia abajo si es posible, de lo contrario, marcar el fondo como verdadero
        if (total == 4){
            // Borrar la posición anterior del bloque en el tablero
            b[centralx+prof[pos[0]][0][rand-1].x][centraly+prof[pos[0]][0][rand-1].y].setBackground(Color.DARK_GRAY);
            b[centralx+prof[pos[0]][1][rand-1].x][centraly+prof[pos[0]][1][rand-1].y].setBackground(Color.DARK_GRAY);
            b[centralx+prof[pos[0]][2][rand-1].x][centraly+prof[pos[0]][2][rand-1].y].setBackground(Color.DARK_GRAY);
            b[centralx+prof[pos[0]][3][rand-1].x][centraly+prof[pos[0]][3][rand-1].y].setBackground(Color.DARK_GRAY);
            // Actualizar la posición y dibujar el bloque en la nueva posición
            centraly++;
            b[centralx+prof[pos[0]][0][rand-1].x][centraly+prof[pos[0]][0][rand-1].y].setBackground(rnd[rand-1]);
            b[centralx+prof[pos[0]][1][rand-1].x][centraly+prof[pos[0]][1][rand-1].y].setBackground(rnd[rand-1]);
            b[centralx+prof[pos[0]][2][rand-1].x][centraly+prof[pos[0]][2][rand-1].y].setBackground(rnd[rand-1]);
            b[centralx+prof[pos[0]][3][rand-1].x][centraly+prof[pos[0]][3][rand-1].y].setBackground(rnd[rand-1]);
        } else {
            // Marcar el fondo como verdadero si no es posible mover más hacia abajo
            bottom = true;
        }
    }
    public void rowcheck(){
        int row = 0;
        for (int y = 0;y<20;y++){
             // Verificar si el fondo del botón en la posición (x, y) no es Color.DARK_GRAY
            for (int x = 0;x<10;x++){
                if (b[x][y].getBackground() != Color.DARK_GRAY){
                    row++;
                }
                // Si todos los botones en una fila tienen un fondo diferente a Color.DARK_GRAY, la fila está completa
                if (row == 10){
                    rowsclrd++; // Incrementar el contador de filas eliminadas
                    rowclear(y); // Llamar a la función para eliminar la fila completa
                }
            }
            row = 0; // Reiniciar el contador de celdas no oscuras para la siguiente fila
        }
    }
 
    public void rowclear(int y){
        int inc = 0;
        // Establecer el fondo de todos los botones en la fila y como Color.DARK_GRAY (eliminar la fila completa)
        for (int x = 0;x<10;x++){
            b[x][y].setBackground(Color.DARK_GRAY);
        }
        // Copiar el color de los botones desde las filas superiores hacia abajo para llenar el espacio vacío
        for (int c = y-1;c>-1;c--){
            for (int x = 0;x<10;x++){
                tmp[x][y-inc] = b[x][c].getBackground();
            }
            inc++;
        }
        // Copiar los colores temporales de nuevo a los botones del tablero
        for (int c = y;c>-1;c--){
            for (int x = 0;x<10;x++){
                b[x][c].setBackground(tmp[x][c]);
            }
        }
    }
 
    public void movelr(){
        int[] m2 = {-1, -1, -1, -1};
        int[] m1 = {-1, -1, -1, -1};
        int[] zero = {-1, -1, -1, -1};
        int[] one = {-1, -1, -1, -1};
        int[] two = {-1, -1, -1, -1};
        for (int d = 0;d<4;d++){
            // Identificar la posición relativa de las partes de la pieza en el eje y
            if (prof[pos[0]][d][rand-1].y == -2){
                m2[d] = d;
            } else if (prof[pos[0]][d][rand-1].y == -1){
                m1[d] = d;
            } else if (prof[pos[0]][d][rand-1].y == 0){
                zero[d] = d;
            } else if (prof[pos[0]][d][rand-1].y == 1){
                one[d] = d;
            } else if (prof[pos[0]][d][rand-1].y == 2){
                two[d] = d;
            }
        }
        int tmpm2 = -5;
        int tmpm1 = -5;
        int tmpzero = -5;
        int tmpone = -5;
        int tmptwo = -5;
        if (deltax == 1){
            // Identificar el valor de desplazamiento según la dirección (izquierda o derecha)
            for (int d = 0;d<4;d++){
                // Mover a la derecha
                if (m2[d] != -1){
                    if (tmpm2<prof[pos[0]][m2[d]][rand-1].x){
                        tmpm2 = prof[pos[0]][m2[d]][rand-1].x;
                    }
                }
                if (m1[d] != -1){
                    if (tmpm1<prof[pos[0]][m1[d]][rand-1].x){
                        tmpm1 = prof[pos[0]][m1[d]][rand-1].x;
                    }
                }
                if (zero[d] != -1){
                    if (tmpzero<prof[pos[0]][zero[d]][rand-1].x){
                        tmpzero = prof[pos[0]][zero[d]][rand-1].x;
                    }
                }
                if (one[d] != -1){
                    if (tmpone<prof[pos[0]][one[d]][rand-1].x){
                        tmpone = prof[pos[0]][one[d]][rand-1].x;
                    }
                }
                if (two[d] != -1){
                    if (tmptwo<prof[pos[0]][two[d]][rand-1].x){
                        tmptwo = prof[pos[0]][two[d]][rand-1].x;
                    }
                }
            }
        } else if (deltax == -1){
            // Mover a la izquierda
            tmpm2 = 5;
            tmpm1 = 5;
            tmpzero = 5;
            tmpone = 5;
            tmptwo = 5;
            for (int d = 0;d<4;d++){
                if (m2[d] != -1){
                    if (tmpm2>prof[pos[0]][m2[d]][rand-1].x){
                        tmpm2 = prof[pos[0]][m2[d]][rand-1].x;
                    }
                }
                if (m1[d] != -1){
                    if (tmpm1>prof[pos[0]][m1[d]][rand-1].x){
                        tmpm1 = prof[pos[0]][m1[d]][rand-1].x;
                    }
                }
                if (zero[d] != -1){
                    if (tmpzero>prof[pos[0]][zero[d]][rand-1].x){
                        tmpzero = prof[pos[0]][zero[d]][rand-1].x;
                    }
                }
                if (one[d] != -1){
                    if (tmpone>prof[pos[0]][one[d]][rand-1].x){
                        tmpone = prof[pos[0]][one[d]][rand-1].x;
                    }
                }
                if (two[d] != -1){
                    if (tmptwo>prof[pos[0]][two[d]][rand-1].x){
                        tmptwo = prof[pos[0]][two[d]][rand-1].x;
                    }
                }
            }
        }
        int total = 0;
         // Verificar si la pieza puede moverse a la nueva posición sin colisiones
        for (int d = 0;d<4;d++){
            if (prof[pos[0]][d][rand-1].y == -2){
                if (perim[2+centralx+deltax+tmpm2][2+centraly-2] != 2){
                    if(b[centralx+deltax+tmpm2][centraly-2].getBackground() == Color.DARK_GRAY){
                        total++;
                    }
                }
            } else if (prof[pos[0]][d][rand-1].y == -1){
                if (perim[2+centralx+deltax+tmpm1][2+centraly-1] != 2){
                    if (b[centralx+deltax+tmpm1][centraly-1].getBackground() == Color.DARK_GRAY){
                        total++;
                    }
                }
            } else if (prof[pos[0]][d][rand-1].y == 0){
                if (perim[2+centralx+deltax+tmpzero][2+centraly] != 2){
                    if (b[centralx+deltax+tmpzero][centraly].getBackground() == Color.DARK_GRAY){
                        total++;
                    }
                }
            } else if (prof[pos[0]][d][rand-1].y == 1){
                if (perim[2+centralx+deltax+tmpone][2+centraly+1] != 2){
                    if (b[centralx+deltax+tmpone][centraly+1].getBackground() == Color.DARK_GRAY){
                        total++;
                    }
                }
            } else if (prof[pos[0]][d][rand-1].y == 2){
                if (perim[2+centralx+deltax+tmptwo][2+centraly+2] != 2){
                    if (b[centralx+deltax+tmptwo][centraly+2].getBackground() == Color.DARK_GRAY){
                        total++;
                    }
                }
            }
            // Mover la pieza si no hay colisiones
        } if (total == 4){
            // Borrar la posición anterior de la pieza
            b[centralx+prof[pos[0]][0][rand-1].x][centraly+prof[pos[0]][0][rand-1].y].setBackground(Color.DARK_GRAY);
            b[centralx+prof[pos[0]][1][rand-1].x][centraly+prof[pos[0]][1][rand-1].y].setBackground(Color.DARK_GRAY);
            b[centralx+prof[pos[0]][2][rand-1].x][centraly+prof[pos[0]][2][rand-1].y].setBackground(Color.DARK_GRAY);
            b[centralx+prof[pos[0]][3][rand-1].x][centraly+prof[pos[0]][3][rand-1].y].setBackground(Color.DARK_GRAY);
            // Actualizar la posición central en el eje x
            centralx = centralx+deltax;
            // Colocar la pieza en la nueva posición
            b[centralx+prof[pos[0]][0][rand-1].x][centraly+prof[pos[0]][0][rand-1].y].setBackground(rnd[rand-1]);
            b[centralx+prof[pos[0]][1][rand-1].x][centraly+prof[pos[0]][1][rand-1].y].setBackground(rnd[rand-1]);
            b[centralx+prof[pos[0]][2][rand-1].x][centraly+prof[pos[0]][2][rand-1].y].setBackground(rnd[rand-1]);
            b[centralx+prof[pos[0]][3][rand-1].x][centraly+prof[pos[0]][3][rand-1].y].setBackground(rnd[rand-1]);
        }
    }
 
  
    //La función main es el punto de entrada principal para la ejecución de un programa en Java. En este caso, el código new Tetris(); crea una nueva instancia de la clase Tetris, que aparentemente es la clase principal del juego Tetris que estás desarrollando.
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT){ //KeyEvent.VK_RIGHT: Si la tecla presionada es la tecla de flecha derecha, se establece deltax en 1 y se llama al método movelr().
                deltax = 1;
                movelr();
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT){  //KeyEvent.VK_LEFT: Si la tecla presionada es la tecla de flecha izquierda, se establece deltax en -1 y se llama al método movelr().
            deltax = -1;
            movelr();
        }
        if (e.getKeyCode() == KeyEvent.VK_UP){  //KeyEvent.VK_UP: Si la tecla presionada es la tecla de flecha arriba, se llama al método rotate().
            rotate();
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN){ //KeyEvent.VK_DOWN: Si la tecla presionada es la tecla de flecha abajo, se llama al método movedown().
            movedown();
        }
    }
 
    @Override
    public void keyReleased(KeyEvent e) {
         //el método keyReleased está vacío en tu implementación. Este método se llama cuando una tecla que estaba presionada ha sido liberada. 
    } 
 
    @Override
    public void keyTyped(KeyEvent e) {
        //El método keyTyped(KeyEvent e) se llama cuando se presiona y luego se libera una tecla en una secuencia rápida. Dado que has dejado el método vacío, no se realizará ninguna acción específica cuando se complete la secuencia de presionar y liberar una tecla.
    }
}
