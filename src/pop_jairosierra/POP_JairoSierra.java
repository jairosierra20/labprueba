/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pop_jairosierra;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Jairo Sierra
 */
public class POP_JairoSierra {

    static Scanner leer = new Scanner(System.in);
    static Random r = new Random();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Bienvenido a Batalla Naval");
        System.out.println("Las reglas del juego son simples:\n"
                + " Cada nave debe ser situada en el campo de batalla de forma aleatoria.\n"
                + " Cada nave puede ser situada horizontal o verticalmente.\n"
                + " Una nave es destruida hasta que todas sus casillas hayan sido destruidas, por lo que al\n"
                + "realizar el disparo en una casilla esta no debe desaparecer, debe marcarse como acierto o\n"
                + "fallo.\n"
                + " Al destruir una nave, el sistema debe anunciar la nave que fue destruida y de quien era esa\n"
                + "nave.\n"
                + " Los turnos deben decidirse al azar.\n"
                + " El sistema debe anunciar si el usuario fallo, acertó o si este le dio a una casilla que ya había\n"
                + "acertado\n"
                + " El disparo que el jugador realice deberá denotarse en términos de (i, j), ya sea pidiendo\n"
                + "una por una las coordenadas o haciéndolo de forma completa.");
        System.out.println("Simbologia:\n Portaviones = *\n"
                + " Acorazado = +\n"
                + " Destructor = $\n"
                + " Submarino = &\n"
                + " Patrullero = ?");
        char[][] t1 = new char[10][10];
        t1 = portaviones(t1);
        t1 = acorazado(t1);
        t1 = destructor(t1);
        t1 = submarino(t1);
        t1 = patrullero(t1);
        char[][] t2 = new char[10][10];
        t2 = portaviones(t2);
        t2 = acorazado(t2);
        t2 = destructor(t2);
        t2 = submarino(t2);
        t2 = patrullero(t2);
        for (int i = 0; i < 999999; i++) {//turnos probables
            int al = 1 + r.nextInt(2);
            if (al == 1) {
                System.out.println("Turno de Honduras");
                imprimeMatriz(t1, 0, 0);
                System.out.println();
                System.out.println("Ingrese la coordenada de su disparo x: ");
                int x = leer.nextInt();
                while (x >= 10 || x < 0) {
                    System.out.println("Ingrese un valor correcto: ");
                    x = leer.nextInt();
                }//fin del while de la coordenada x
                System.out.println("Ingrese la coordenada de su disparo y: ");
                int y = leer.nextInt();
                while (y >= 10 || y < 0) {
                    System.out.println("Ingrese un valor correcto: ");
                    x = leer.nextInt();
                }//fin del while de la coordenada y
                disparos(x, y, t2);
                gane(x,y,t2);
                repetido(x,y,t2);
            } else {
                System.out.println("Turno de Islandia");
                imprimeMatriz(t2, 0, 0);
                System.out.println();
                System.out.println("Ingrese la coordenada de su disparo x: ");
                int x = leer.nextInt();
                while (x >= 10 || x < 0) {
                    System.out.println("Ingrese un valor correcto: ");
                    x = leer.nextInt();
                }//fin del while de la coordenada x
                System.out.println("Ingrese la coordenada de su disparo y: ");
                int y = leer.nextInt();
                while (y >= 10 || y < 0) {
                    System.out.println("Ingrese un valor correcto: ");
                    x = leer.nextInt();
                }//fin del while de la coordenada y
                disparos(x, y, t1);
                if(gane(x,y,t1)==true){
                  break;
                }
                repetido(x,y,t1);
            }
        }//fin del for de los turnos
    }//fin del main

    public static void imprimeMatriz(char matriz[][], int filas, int cols) {//Imprime la matriz de manera recursiva
        if (filas == matriz.length - 1 && cols == matriz[0].length - 1) {
            System.out.print("[" + matriz[filas][cols] + "]\t");
        } else {
            if (cols == matriz[0].length - 1) {
                System.out.println("[" + matriz[filas][cols] + "]\t");
                imprimeMatriz(matriz, filas + 1, 0);
            } else {
                System.out.print("[" + matriz[filas][cols] + "]\t");
                imprimeMatriz(matriz, filas, cols + 1);
            }
        }
    }//fin del metodo que imprime la matriz recursivamente

    public static char[][] portaviones(char[][] t) {
        int pos = 0 + r.nextInt(2);
        int cont1 = 0;
        if (pos == 1) {
            int i1 = 0 + r.nextInt(4);
            int j1 = 0 + r.nextInt(9);
            while (cont1 < 5) {
                i1++;
                t[i1][j1] = '*';
                cont1++;
            }
        }//fin de la posicion 
        else {
            int i1 = 0 + r.nextInt(9);
            int j1 = 0 + r.nextInt(4);
            while (cont1 < 5) {
                j1++;
                t[i1][j1] = '*';
                cont1++;
            }
        }//fin del else      
        return t;
    }//metodo de los portaviones

    public static char[][] acorazado(char[][] t) {
        int pos = 0 + r.nextInt(2);
        int cont2 = 0;
        if (pos == 1) {
            int j2 = 0 + r.nextInt(9);
            int i2 = 0 + r.nextInt(4);
            while (cont2 < 4) {
                if (t[i2][j2] != '*') {
                    i2++;
                    t[i2][j2] = '+';
                } else {
                    cont2 = 0;
                }
                cont2++;
            }
        }//fin del if de posicion
        else {
            int j2 = 0 + r.nextInt(4);
            int i2 = 0 + r.nextInt(9);
            while (cont2 < 4) {
                if (t[i2][j2] != '*') {
                    j2++;
                    t[i2][j2] = '+';
                } else {
                    cont2 = 0;
                }
                cont2++;
            }
        }//fin del else
        return t;
    }//fin de acorazado

    public static char[][] destructor(char[][] t) {
        int pos = r.nextInt(2);
        int cont3 = 0;
        if (pos == 1) {
            int j3 = 0 + r.nextInt(9);
            int i3 = 0 + r.nextInt(4);
            while (cont3 < 3) {
                if (t[i3][j3] != '*' && t[i3][j3] != '+') {
                    i3++;
                    t[i3][j3] = '$';
                } else {
                    cont3 = 0;
                }
                cont3++;
            }
        }//fin del if de la posicion
        else {
            int j3 = 0 + r.nextInt(4);
            int i3 = 0 + r.nextInt(9);
            while (cont3 < 3) {
                if (t[i3][j3] != '*' && t[i3][j3] != '+') {
                    j3++;
                    t[i3][j3] = '$';
                } else {
                    cont3 = 0;
                }
                cont3++;
            }
        }//fin del else
        return t;
    }//fin del destructor

    public static char[][] submarino(char[][] t) {
        int pos = r.nextInt(2);
        int cont4 = 0;
        if (pos == 1) {
            int j4 = 0 + r.nextInt(9);
            int i4 = 0 + r.nextInt(4);
            while (cont4 < 3) {
                if (t[i4][j4] != '*' && t[i4][j4] != '+' && t[i4][j4] != '$') {
                    i4++;
                    t[i4][j4] = '&';
                } else {
                    cont4 = 0;
                }
                cont4++;
            }
        }//fin del if de la posicion
        else {
            int j4 = 0 + r.nextInt(4);
            int i4 = 0 + r.nextInt(9);
            while (cont4 < 3) {
                if (t[i4][j4] != '*' && t[i4][j4] != '+' && t[i4][j4] != '$') {
                    j4++;
                    t[i4][j4] = '&';
                } else {
                    cont4 = 0;
                }
                cont4++;
            }
        }//fin del else de la posicion
        return t;
    }//fin de submarino

    public static char[][] patrullero(char[][] t) {
        int pos = r.nextInt(2);
        int cont5 = 0;
        if (pos == 1) {
            int j5 = 0 + r.nextInt(9);
            int i5 = 0 + r.nextInt(4);
            while (cont5 < 2) {
                if (t[i5][j5] != '*' && t[i5][j5] != '+' && t[i5][j5] != '$' && t[i5][j5] != '&') {
                    i5++;
                    t[i5][j5] = '?';
                } else {
                    cont5 = 0;
                }
                cont5++;
            }
        } else {
            int j5 = 0 + r.nextInt(4);
            int i5 = 0 + r.nextInt(9);
            while (cont5 < 2) {
                if (t[i5][j5] != '*' && t[i5][j5] != '+' && t[i5][j5] != '$' && t[i5][j5] != '&') {
                    j5++;
                    t[i5][j5] = '?';
                } else {
                    cont5 = 0;
                }
                cont5++;
            }
        }//fin del else  
        return t;
    }//fin de patrullero

    public static void disparos(int x, int y, char[][] t) {
        if (t[x][y] == '+' || t[x][y] == '*' || t[x][y] == '?' || t[x][y] == '$' || t[x][y] == '&') {
            System.out.println("Acerto en su disparo");
            t[x][y] = '!';
        } else {
            System.out.println("Fallo en su disparo");
        }
    }//fin de disparos

    public static boolean gane(int x,int y,char[][] t) {
       int cont=0;
       boolean ban=false;
        if (t[x][y] == '+' || t[x][y] == '*' || t[x][y] == '?' || t[x][y] == '$' || t[x][y] == '&') {
            cont++;
        }
        if(cont>=17){
            System.out.println("Gano el juego");
            ban=true;
        }
        else{
            ban=false;
        }
        return ban;
    }//fin del gane
    public static void repetido(int x,int y, char [][] t){
        if (t[x][y] == '!') {
            System.out.println("Disparo repetido");
        }
    }
}//fin de la clase
