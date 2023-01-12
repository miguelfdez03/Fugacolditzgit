package fugacolditz;
import java.util.Scanner;

public class Carcel {
        public static void main(String[] args) {
        //creacion de 3 guardias
        Guardia guardia1 = new Guardia(0,0);
        Guardia guardia2 = new Guardia(0,0);
        Guardia guardia3 = new Guardia(0,0);
        System.out.println("Elige el nivel de dificultad(facil, medio, dificil):");
        Scanner sc = new Scanner(System.in);
        String opcion = sc.next();

        int guardias = 0;

        

        //INICIALIZAMOS EL TABLERO
        Matriz tablero = new Matriz();

        Herramienta herramienta = new Herramienta("Pasaporte");
        tablero.AniadirHerramienta(herramienta);
        Herramienta herramienta1 = new Herramienta("Alicates");
        tablero.AniadirHerramienta(herramienta1);
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
        int contador =0;
        do{
            System.out.println("A que posicion quieres moverte?(W,A,S,D): ");
            String mov = sc.next();
            tablero.personaje1.mover(mov, tablero);
            tablero.moverG(tablero,guardia1);tablero.moverG(tablero,guardia2);tablero.moverG(tablero,guardia3);
            System.out.println(tablero.imprimirTablero());
            contador++;
            if (tablero.personaje1.alicates&&tablero.personaje1.pasaporte&&tablero.personaje1.uniforme){
                System.out.println("HAS GANADO!!!!");
                return;
            }            
        }while((!tablero.EndGame())&&(contador != 30));
        System.out.println("END GAME!");
        System.exit(0);
    }

}
