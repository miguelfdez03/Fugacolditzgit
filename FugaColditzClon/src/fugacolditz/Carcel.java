package fugacolditz;
import java.util.Scanner;

public class Carcel {
        public static void main(String[] args) {

        System.out.println("Elige el nivel de dificultad(facil, medio, dificil):");
        Scanner sc = new Scanner(System.in);
        String opcion = sc.next();

        int guardias = 0;

        if (opcion.equalsIgnoreCase("facil")) {
            guardias = 1;

        } else if (opcion.equalsIgnoreCase("medio")) {
            guardias = 2;
        } else {
            guardias = 3;
        }

        //INICIALIZAMOS EL TABLERO
        Matriz tablero = new Matriz();

        Herramienta herramienta = new Herramienta("Pasaporte");
        tablero.AniadirHerramienta(herramienta);
        Herramienta herramienta1 = new Herramienta("Alicates");
        tablero.AniadirHerramienta(herramienta1);
        Herramienta uniforme = new Herramienta("Uniforme");
        tablero.AniadirHerramienta(uniforme);
        for (int i = 1; i <= guardias; i++) {
            tablero.aniadirGuardia();
        }
        tablero.AniadirPersonaje();
        System.out.println(tablero.imprimirTablero());
        int contador =0;
        do{
            System.out.println("A que posicion quieres moverte?(W,A,S,D): ");
            String mov = sc.next();
            tablero.personaje1.mover(mov, tablero);
            tablero.moverG(tablero,tablero.guardiaG);
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
