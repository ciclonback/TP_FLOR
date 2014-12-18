import java.io.File;

public class TareaEliminarArchivo implements Tarea {
    File destino;

    public TareaEliminarArchivo(File destino) {
        this.destino = destino;
    }

    public long espacioRequerido() {
        return 0;
    }

    public String toString() {
        return "ELIMINAR ARCHIVO " + destino.getAbsolutePath();
    }
    
}
