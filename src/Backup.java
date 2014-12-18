import java.util.ArrayList;
import java.io.File;
import java.nio.file.Paths;
import java.nio.file.Path;

public class Backup {

    public Backup() {
        
    }

    public void correr(String origen, String destino) {
        long inicio = System.currentTimeMillis();
        ArrayList<Tarea> tareas = crearListadoTareas(origen, destino);
        ejecutarTareas(tareas);
        long fin = System.currentTimeMillis();
    }


    public void ejecutarTareas(ArrayList<Tarea> tareas) {
        System.out.println("Numero de tareas:" + tareas.size());
        for(Tarea tarea : tareas) {
            System.out.println(tarea.toString());
        }
    }
    
    public ArrayList<Tarea> crearListadoTareas(String origen, String destino) {
        return crearListadoTareas(new File(origen), new File(destino));
    }
    
    public ArrayList<Tarea> crearListadoTareas(File origen, File destino ) {

        ArrayList<Tarea> tareas = new ArrayList<Tarea>();
        
        File[] archivosEnOrigen = origen.listFiles();

        for ( File elemento : archivosEnOrigen) {
            File elementoDestino = new File(Paths.get(destino.getPath(), elemento.getName()).toString());
            if ( elemento.isDirectory() ) {
                crearTareaDirectorio(tareas, elemento, elementoDestino);
                tareas.addAll(crearListadoTareas(elemento,elementoDestino));
            } else {
                crearTareaArchivo(tareas, elemento, elementoDestino);
            }
        }

        if( destino.exists()) {
            File[] archivosEnDestino = destino.listFiles();

            for ( File elemento : archivosEnDestino) {
                File elementoOrigen = new File(Paths.get(origen.getPath(), elemento.getName()).toString());
                if (!elementoOrigen.exists()) {
                    crearTareasEliminar(tareas,elemento);
                }
            }
        }
        
        return tareas;
    }

    public void crearTareaDirectorio(ArrayList<Tarea> tareas, File origen, File destino) {
        if (!destino.exists()) {
            tareas.add(new TareaCrearDirectorio(destino));
        }
    }

    public void crearTareaArchivo(ArrayList<Tarea> tareas, File origen, File destino) {
        if(!destino.exists()) {
            tareas.add(new TareaCopiarArchivo(origen,destino));
        }
        else {
            long tamanoOrigen = origen.length();
            long tamanoDestino = destino.length();
            if(tamanoOrigen != tamanoDestino) {
                tareas.add(new TareaCopiarArchivo(origen,destino));
            }
        }
    }

    public void crearTareasEliminar(ArrayList<Tarea> tareas, File destino) {
        if(destino.isDirectory()) {
            File [] archivosEnDestino = destino.listFiles();
            for(File elemento : archivosEnDestino) {
                crearTareasEliminar(tareas, elemento);
            }
            tareas.add(new TareaEliminarDirectorio(destino));
        } else {
            tareas.add(new TareaEliminarArchivo(destino));
        }
    }
    
}
