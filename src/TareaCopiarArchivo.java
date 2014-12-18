import java.io.File;

public class TareaCopiarArchivo implements Tarea {
    File origen;
    File destino;

    public TareaCopiarArchivo(File origen, File destino) {
        this.origen = origen;
        this.destino = destino;
    }
    
    public long espacioRequerido() {
        return 0;
    }

    public String toString() {
        return "COPIAR " + origen.getAbsolutePath() + " a " + destino.getAbsolutePath();
    }
    
}
