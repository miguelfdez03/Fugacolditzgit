package fugacolditz;

import java.util.Scanner;

public class Carcel {

    public static void main(String[] args) {
        //creacion de 3 guardias
        Guardia guardia1 = new Guardia(0, 0);
        Guardia guardia2 = new Guardia(-1, -1);
        Guardia guardia3 = new Guardia(-1, -1);
        System.out.println("Elige el nivel de dificultad(facil, medio, dificil):");
        System.out.println("si lo escribes mal se te asigna por defecto el modo dificl asique atento a lo que escribes :)");
        Scanner sc = new Scanner(System.in);
        String opcion = sc.next();


        //INICIALIZAMOS EL TABLERO
        Matriz tablero = new Matriz();

        Herramienta pasaporte = new Herramienta("Pasaporte");
        tablero.AniadirHerramienta(pasaporte);
        Herramienta alicates = new Herramienta("Alicates");
        tablero.AniadirHerramienta(alicates);
        Herramienta uniforme = new Herramienta("Uniforme");
        tablero.AniadirHerramienta(uniforme);
        if (opcion.equalsIgnoreCase("facil")) {
            tablero.aniadirGuardia(guardia1);

        } else if (opcion.equalsIgnoreCase("medio")) {
            tablero.aniadirGuardia(guardia1);
            tablero.aniadirGuardia(guardia2);
        } else {
            tablero.aniadirGuardia(guardia1);
            tablero.aniadirGuardia(guardia2);
            tablero.aniadirGuardia(guardia3);
        }
        tablero.AniadirPersonaje();
        System.out.println(tablero.imprimirTablero());
        int contador = 0;
        do {
            System.out.println("A que posicion quieres moverte?(W,A,S,D): ");
            String mov = sc.next();
            tablero.personaje1.mover(mov, tablero);
            if (opcion.equalsIgnoreCase("facil")) {
                tablero.moverG(tablero, guardia1);

            } else if (opcion.equalsIgnoreCase("medio")) {
                tablero.moverG(tablero, guardia1);
                tablero.moverG(tablero, guardia2);
            } else {
                tablero.moverG(tablero, guardia1);
                tablero.moverG(tablero, guardia2);
                tablero.moverG(tablero, guardia3);
            }
            System.out.println(tablero.imprimirTablero());
            contador++;
            if (tablero.personaje1.alicates && tablero.personaje1.pasaporte && tablero.personaje1.uniforme) {
                System.out.println("HAS GANADO!!!!");
                return;
            }
            if ((tablero.personaje1.posicion.x==guardia1.x)&&(tablero.personaje1.posicion.y==guardia1.y)
                    ||(tablero.personaje1.posicion.x==guardia2.x)&&(tablero.personaje1.posicion.y==guardia2.y)
                    ||(tablero.personaje1.posicion.x==guardia3.x)&&(tablero.personaje1.posicion.y==guardia3.y)) {
                tablero.perder=true;
            }
        } while ((!tablero.EndGame()) && (contador != 30));
        System.out.println("END GAME!");
        System.exit(0);
    }

}
