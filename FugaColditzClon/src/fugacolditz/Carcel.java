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
        Matriz t = new Matriz();

        Herramienta herramienta = new Herramienta("Pasaporte");
        t.AniadirHerramienta(herramienta);
        Herramienta herramienta1 = new Herramienta("Alicates");
        t.AniadirHerramienta(herramienta1);
        Herramienta uniforme = new Herramienta("Uniforme");
        t.AniadirHerramienta(uniforme);
        for (int i = 1; i <= guardias; i++) {
            t.aniadirGuardia();
        }
        t.AniadirPersonaje();
        System.out.println(t.imprimirTablero());
        int contador =0;
        do{
            System.out.println("A que posicion quieres moverte?(W,A,S,D): ");
            String mov = sc.next();
            t.personaje1.mover(mov, t);
            System.out.println(t.imprimirTablero());
            contador++;
            if (t.personaje1.alicates&&t.personaje1.pasaporte&&t.personaje1.uniforme){
                System.out.println("HAS GANADO!!!!");
                return;
            }
            t.moverG(t);
        }while((!t.EndGame())&&(contador != 30));
        System.out.println("END GAME!");
        System.exit(0);
    }

}
