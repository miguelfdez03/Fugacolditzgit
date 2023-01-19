package fugacolditz;
import java.util.ArrayList;

public class Herramienta {
    String tipo;
    ArrayList<Posicion> posicionHerramienta;
    
    public Herramienta (String tipo){
        this.tipo=tipo;
        this.posicionHerramienta =new ArrayList<Posicion> ();
    }
}
