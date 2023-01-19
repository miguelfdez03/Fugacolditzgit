package fugacolditz;

import java.util.ArrayList;

public class Matriz {

    public String[][] tablero = new String[10][10];
    public ArrayList<Herramienta> herramientas;
    public Personaje personaje1;
    public Guardia guardiaG;
    boolean perder;

    public Matriz() {
        this.perder = false;
        herramientas = new ArrayList<Herramienta>();
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = "X";
            }
        }
    }

    public String imprimirTablero() {

        String pintar = "";

        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                pintar += " " + tablero[i][j] + " ";
            }
            pintar += "\n";
        }
        return pintar;
    }

    public void AniadirHerramienta(Herramienta herramienta) {

        boolean comprobar = false;

        while (!comprobar) {
            
            int x = (int) (Math.random() * 10);
            int y = (int) (Math.random() * 10);
            switch (herramienta.tipo) {

                case "Uniforme":                    
                   do{
                    try {
                            if(comprobarPosition(x-2, y)){
                                if(comprobarPosition(x+2, y)){
                                    if(comprobarPosition(x+1, y+1)){
                                        if(comprobarPosition(x, y+1)){
                                            if(comprobarPosition(x-1, y+1)){
                                                if(comprobarPosition(x+1, y-1)){
                                                    if(comprobarPosition(x, y-1)){
                                                        if(comprobarPosition(x-1, y-1)){
                                                            tablero[x][y] = "U";
                                                            tablero[x + 1][y] = "U";
                                                            tablero[x - 1][y] = "U";
                                                            Posicion p = new Posicion(x, y);
                                                            Posicion p2 = new Posicion(x + 1, y);
                                                            Posicion p3 = new Posicion(x - 1, y);
                                                            herramienta.posicionHerramienta.add(p);
                                                            herramienta.posicionHerramienta.add(p2);
                                                            herramienta.posicionHerramienta.add(p3);
                                                            this.herramientas.add(herramienta);
                                                            comprobar = true;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                
                            }
                    } catch (ArrayIndexOutOfBoundsException n) {

                    }
                    }while(!comprobar); 
                    break;

                case "Alicates":
                    // Como ocupa 2 debemos decidir que dos casillas

                    if (comprobarPosition(x, y)) {
                        if (comprobarPosition(x - 1, y)) {
                            if (comprobarPosition(x + 1, y)) {
                                if (comprobarPosition(x, y + 1)) {
                                    if (comprobarPosition(x, y - 1)) {

                                        try {
                                            if (tablero[x - 1][y].equals("X")) {
                                                if (comprobarPosition(x - 2, y)) {
                                                    if (comprobarPosition(x - 1, y + 1)) {
                                                        if (comprobarPosition(x - 1, y - 1)) {
                                                            tablero[x][y] = "A";
                                                            tablero[x - 1][y] = "A";
                                                            Posicion p = new Posicion(x, y);
                                                            Posicion p2 = new Posicion(x - 1, y);
                                                            herramienta.posicionHerramienta.add(p);
                                                            herramienta.posicionHerramienta.add(p2);
                                                            this.herramientas.add(herramienta);
                                                            comprobar = true;

                                                        }
                                                    }
                                                }
                                            }
                                        } catch (ArrayIndexOutOfBoundsException e) {
                                            // Esta fuera del array
                                            try {
                                                if (tablero[x + 1][y].equals("X")) {
                                                    if (comprobarPosition(x + 2, y)) {
                                                        if (comprobarPosition(x + 1, y + 1)) {
                                                            if (comprobarPosition(x + 1, y - 1)) {
                                                                tablero[x][y] = "A";
                                                                tablero[x + 1][y] = "A";
                                                                Posicion p = new Posicion(x, y);
                                                                Posicion p2 = new Posicion(x + 1, y);
                                                                herramienta.posicionHerramienta.add(p);
                                                                herramienta.posicionHerramienta.add(p2);
                                                                this.herramientas.add(herramienta);
                                                                comprobar = true;

                                                            }
                                                        }
                                                    }
                                                }

                                            } catch (ArrayIndexOutOfBoundsException a) {

                                                try {
                                                    if (tablero[x][y - 1].equals("X")) {
                                                        if (comprobarPosition(x, y - 2)) {
                                                            if (comprobarPosition(x - 1, y - 1)) {
                                                                if (comprobarPosition(x + 1, y - 1)) {
                                                                    tablero[x][y] = "A";
                                                                    tablero[x][y - 1] = "A";
                                                                    Posicion p = new Posicion(x, y);
                                                                    Posicion p2 = new Posicion(x, y - 1);
                                                                    herramienta.posicionHerramienta.add(p);
                                                                    herramienta.posicionHerramienta.add(p2);
                                                                    this.herramientas.add(herramienta);
                                                                    comprobar = true;

                                                                }
                                                            }
                                                        }
                                                    }
                                                } catch (ArrayIndexOutOfBoundsException u) {

                                                    try {
                                                        if (tablero[x][y + 1].equals("X")) {
                                                            if (comprobarPosition(x, y + 2)) {
                                                                if (comprobarPosition(x - 1, y + 1)) {
                                                                    if (comprobarPosition(x + 1, y + 1)) {
                                                                        tablero[x][y] = "A";
                                                                        tablero[x][y + 1] = "A";
                                                                        Posicion p = new Posicion(x, y);
                                                                        Posicion p2 = new Posicion(x, y + 1);
                                                                        herramienta.posicionHerramienta.add(p);
                                                                        herramienta.posicionHerramienta.add(p2);
                                                                        this.herramientas.add(herramienta);
                                                                        comprobar = true;

                                                                    }
                                                                }
                                                            }
                                                        }
                                                    } catch (ArrayIndexOutOfBoundsException q) {

                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    break;

                case "Pasaporte":
                    try{
                 if (comprobarPosition(x, y)) {
                        if (comprobarPosition(x - 1, y)) {
                            if (comprobarPosition(x + 1, y)) {
                                if (comprobarPosition(x, y + 1)) {
                                    if (comprobarPosition(x, y - 1)) {
                                        tablero[x][y] = "P";
                                        Posicion p = new Posicion(x, y);
                                        herramienta.posicionHerramienta.add(p);
                                            this.herramientas.add(herramienta);
                                            comprobar = true;
                                    }
                                }
                            }
                        }
                    }
                    }catch(ArrayIndexOutOfBoundsException a){
                            
                            }
                    break;

            }
        }
    }

    public void AniadirPersonaje() {
        boolean comprobar = false;

        while (!comprobar) {
            int x = (int) (Math.random() * 10);
            int y = (int) (Math.random() * 10);
            if (comprobarPosition(x, y) && comprobarPosition(x - 1, y) && comprobarPosition(x - 2, y)
                    && comprobarPosition(x + 1, y) && comprobarPosition(x + 2, y)
                    && comprobarPosition(x, y + 1) && comprobarPosition(x, y + 2)
                    && comprobarPosition(x, y - 1) && comprobarPosition(x, y - 2)) {

                Posicion po = new Posicion(x, y);
                Personaje p = new Personaje(po);
                tablero[x][y] = "O";
                this.personaje1 = p;
                comprobar = true;
            }

        }
    }

    public void aniadirGuardia(Guardia g) {
        boolean valido = false;

        while (!valido) {
            int x = (int) (Math.random() * 10);
            int y = (int) (Math.random() * 10);

            if (comprobarPosition(x, y)) {
                g.x=x;
                g.y=y;
                tablero[x][y] = "G";
                valido = true;
            }
        }
    }

    public void moverG(Matriz matriz, Guardia g) {
        try{
        int ale = (int) ((Math.random() * 4 + 1));
        switch (ale) {
            case 1:
                //arriba
                if((matriz.tablero[g.x - 1][g.y].equalsIgnoreCase("U"))||(matriz.tablero[g.x - 1][g.y].equalsIgnoreCase("A"))
                        ||(matriz.tablero[g.x - 1][g.y].equalsIgnoreCase("P"))||(matriz.tablero[g.x - 1][g.y].equalsIgnoreCase("G"))){
                    moverG(matriz,g);
                }else{
                matriz.tablero[g.x - 1][g.y] = "G";
                matriz.tablero[g.x][g.y] = "X";
                g.x = g.x - 1;}
                break;
            case 2:
                //abajo
                if((matriz.tablero[g.x + 1][g.y].equalsIgnoreCase("U"))||(matriz.tablero[g.x + 1][g.y].equalsIgnoreCase("A"))
                        ||(matriz.tablero[g.x + 1][g.y].equalsIgnoreCase("P"))||(matriz.tablero[g.x + 1][g.y].equalsIgnoreCase("G"))){
                    moverG(matriz,g);
                }else{
                matriz.tablero[g.x + 1][g.y] = "G";
                matriz.tablero[g.x][g.y] = "X";
                g.x = g.x + 1;
                break;}
            case 3:
                //izquierda
                if((matriz.tablero[g.x][g.y-1].equalsIgnoreCase("U"))||(matriz.tablero[g.x][g.y-1].equalsIgnoreCase("A"))
                        ||(matriz.tablero[g.x][g.y-1].equalsIgnoreCase("P"))||(matriz.tablero[g.x][g.y-1].equalsIgnoreCase("G"))){
                    moverG(matriz,g);
                }else{
                matriz.tablero[g.x][g.y - 1] = "G";
                matriz.tablero[g.x][g.y] = "X";
                g.y = g.y - 1;
                break;}
            case 4:
                //derecha
                if((matriz.tablero[g.x][g.y+1].equalsIgnoreCase("U"))||(matriz.tablero[g.x][g.y+1].equalsIgnoreCase("A"))
                        ||(matriz.tablero[g.x][g.y+1].equalsIgnoreCase("P"))||(matriz.tablero[g.x][g.y+1].equalsIgnoreCase("G"))){
                    moverG(matriz,g);
                }else{
                matriz.tablero[g.x][g.y + 1] = "G";
                matriz.tablero[g.x][g.y] = "X";
                g.y = g.y + 1;}
                break;
        }
        }catch(ArrayIndexOutOfBoundsException e){
            moverG(matriz,g);
        }
    }

    public boolean comprobarPosition(int x, int y) {

        boolean valido = false;

        // Compruebo que esa casilla esta libre;
        try {
            if (tablero[x][y].equals("X")) {
                valido = true;
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            valido = true;
        }

        return valido;

    }

    public boolean EndGame() {
        return this.perder;
    }
}
