import java.io.File;

public class TareaEliminarDirectorio implements Tarea {
    File destino;

    public TareaEliminarDirectorio(File destino) {
        this.destino = destino;
    }

    public long espacioRequerido() {
        return 0;
    }

    public String toString() {
        return "ELIMINAR DIRECTORIO " + destino.getAbsolutePath();
    }
}
