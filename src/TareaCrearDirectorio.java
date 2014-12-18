import java.io.File;

public class TareaCrearDirectorio implements Tarea {
    File destino;

    public TareaCrearDirectorio(File destino) {
        this.destino = destino;
    }
    
    public long espacioRequerido() {
        return 0;
    }

    public String toString() {
        return "CREAR DIRECTORIO " + destino.getAbsolutePath();
    }
    
}
