package fugacolditz;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Personaje {

    Posicion posicion;
    boolean pasaporte;
    boolean alicates;
    boolean uniforme;
    String[] herramientas = {"P", "A", "U"};
    Scanner teclado = new Scanner(System.in);

    public Personaje(Posicion pos) {
        this.alicates = false;
        this.pasaporte = false;
        this.uniforme = false;
        this.posicion = pos;
    }

    public void mover(String direccion, Matriz tabla) {
        Scanner sc = new Scanner(System.in);
        try {
            switch (direccion.toUpperCase()) {
                case "W":
                    //swith COmprobacion // MOVER ARRIBA
                    movUp(tabla);
                    break;

                case "A":
                    //MOVIMIENTO IZQUIERDA
                    moveLeft(tabla);
                    break;
                case "S":
                    //MOVIMIENTO ABAJO
                    movDown(tabla);
                    break;

                case "D"://derecha
                    movRight(tabla);
                    break;
                default:
                    System.out.println("Por favor inserta una de las letras de la Cruceta de direccion");
                    System.out.println("A que posicion quieres moverte?(W,A,S,D): ");
                    String mov = sc.next();
                    mover(mov, tabla);
                    break;

            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("No puedes moverte en esa direccion");
        }

    }

    private void movDown(Matriz tabla) {
        if (tabla.tablero[posicion.x + 1][posicion.y].equals("P") ||
                tabla.tablero[posicion.x + 1][posicion.y].equals("A") ||
                tabla.tablero[posicion.x + 1][posicion.y].equals("U")) {
            if (recogerHerramienta(posicion.x + 1, posicion.y, tabla)) {
                tabla.tablero[posicion.x][posicion.y] = "X";
                tabla.tablero[posicion.x + 1][posicion.y] = "O";
                this.posicion = new Posicion(posicion.x + 1, posicion.y);
            }
        } else if (tabla.tablero[posicion.x + 1][posicion.y].equals("X")) {
            tabla.tablero[posicion.x][posicion.y] = "X";
            tabla.tablero[posicion.x + 1][posicion.y] = "O";
            this.posicion = new Posicion(posicion.x + 1, posicion.y);
        } else if (tabla.tablero[posicion.x + 1][posicion.y].equals("G")) {
            tabla.tablero[posicion.x][posicion.y] = "X";
            tabla.tablero[posicion.x + 1][posicion.y] = "O";
            tabla.perder = true;
        }
    }

    private void movUp(Matriz tabla) {
        if (tabla.tablero[posicion.x - 1][posicion.y].equals("P") ||
                tabla.tablero[posicion.x - 1][posicion.y].equals("A") ||
                tabla.tablero[posicion.x - 1][posicion.y].equals("U")) {
            if (recogerHerramienta(posicion.x - 1, posicion.y, tabla)) {
                tabla.tablero[posicion.x][posicion.y] = "X";
                tabla.tablero[posicion.x - 1][posicion.y] = "O";
                this.posicion = new Posicion(posicion.x - 1, posicion.y);
            }else{
                System.out.println("Has fallado");
            }

        } else if (tabla.tablero[posicion.x - 1][posicion.y].equals("X")) {
            tabla.tablero[posicion.x][posicion.y] = "X";
            tabla.tablero[posicion.x - 1][posicion.y] = "O";
            this.posicion = new Posicion(posicion.x - 1, posicion.y);
        } else if (tabla.tablero[posicion.x - 1][posicion.y].equals("G")) {
            tabla.tablero[posicion.x][posicion.y] = "X";
            tabla.tablero[posicion.x - 1][posicion.y] = "O";
            tabla.perder = true;
        }
    }

    private void moveLeft(Matriz tabla) {
        if (tabla.tablero[posicion.x][posicion.y - 1].equals("P") ||
                tabla.tablero[posicion.x][posicion.y - 1].equals("A") ||
                tabla.tablero[posicion.x][posicion.y - 1].equals("U")) {

            if (recogerHerramienta(posicion.x, posicion.y - 1, tabla)) {
                tabla.tablero[posicion.x][posicion.y] = "X";
                tabla.tablero[posicion.x][posicion.y - 1] = "O";
                this.posicion = new Posicion(posicion.x, posicion.y - 1);
            }
        } else if (tabla.tablero[posicion.x][posicion.y - 1].equals("X")) { /// x=1 y=0
            tabla.tablero[posicion.x][posicion.y] = "X";
            tabla.tablero[posicion.x][posicion.y - 1] = "O";
            this.posicion = new Posicion(posicion.x, posicion.y - 1);

        } else if (tabla.tablero[posicion.x][posicion.y - 1].equals("G")) {
            tabla.tablero[posicion.x][posicion.y] = "X";
            tabla.tablero[posicion.x][posicion.y - 1] = "O";
            this.posicion = new Posicion(posicion.x, posicion.y - 1);
            tabla.perder = true;

        }

    }

    private void movRight(Matriz tabla) {
        if (tabla.tablero[posicion.x][posicion.y + 1].equals("P") ||
                tabla.tablero[posicion.x][posicion.y + 1].equals("A") ||
                tabla.tablero[posicion.x][posicion.y + 1].equals("U")) {

            if (recogerHerramienta(posicion.x, posicion.y + 1, tabla)) {
                tabla.tablero[posicion.x][posicion.y] = "X";
                tabla.tablero[posicion.x][posicion.y + 1] = "O";
                this.posicion = new Posicion(posicion.x, posicion.y + 1);
            }
        } else if (tabla.tablero[posicion.x][posicion.y + 1].equals("X")) {
            tabla.tablero[posicion.x][posicion.y] = "X";
            tabla.tablero[posicion.x][posicion.y + 1] = "O";
            this.posicion = new Posicion(posicion.x, posicion.y + 1);
        } else if (tabla.tablero[posicion.x][posicion.y + 1].equals("G")) {
            tabla.tablero[posicion.x][posicion.y] = "X";
            tabla.tablero[posicion.x][posicion.y + 1] = "O";
            this.posicion = new Posicion(posicion.x, posicion.y + 1);
            tabla.perder = true;
        }
    }


    public boolean recogerHerramienta(int x, int y, Matriz t) {
        try {
            Scanner sc = new Scanner(System.in);
            int opcion;
            System.out.println("Para coger esta herramienta introduce tu movimiento(piedra=1,papel=2,tijeras=3):");
            opcion = sc.nextInt();
            boolean ganar = false;
            int aleatorio = (int) (Math.random() * 3 + 1);

            if (aleatorio == 1 && opcion == 2) { //piedra vs papel
                ganar = true;
                System.out.println("el bot a sacado piedra y tu papel!");
                System.out.println("te quedas con la herramienta");
            }

            if (aleatorio == 2 && opcion == 3) {//papel vs tijeras
                ganar = true;
                System.out.println("el bot a sacado papel y tu tijeras!");
                System.out.println("te quedas con la herramienta");

            }

            if (aleatorio == 3 && opcion == 1) {//tijeras vs piedra
                ganar = true;
                System.out.println("el bot a sacado tijeras y tu piedra!");
                System.out.println("te quedas con la herramienta");
            }

            if (aleatorio == opcion) {
                System.out.println("EMPATE");
                ganar = false;
            }

            if (ganar) {
                switch (t.tablero[x][y]) {

                    case "P":
                        for (Posicion p : t.herramientas.get(0).posicionHerramienta) {

                            t.tablero[p.x][p.y] = "X";
                        }

                        this.pasaporte = true;

                        break;

                    case "A":
                        for (Posicion p : t.herramientas.get(1).posicionHerramienta) {

                            t.tablero[p.x][p.y] = "X";
                        }

                        this.alicates = true;
                        break;

                    case "U":
                        for (Posicion p : t.herramientas.get(2).posicionHerramienta) {

                            t.tablero[p.x][p.y] = "X";
                        }
                        this.uniforme = true;
                        break;
                }
                return true;
            }


        } catch (InputMismatchException e) {
            System.out.println("Un numero del uno al 3 porfavor...");
            recogerHerramienta(x, y, t);
        }

        return false;
    }

}
