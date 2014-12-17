import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.sql.Time;
import javax.swing.JOptionPane;

public class BackUp{
    
   long comienzo = System.currentTimeMillis();
   
   File srcDir;
   File dstDir;
   
   public BackUp() throws ExceptionFaltaEspacioLibre{
   //Leer Perfil ???
   //tareas = Tarea.CrearListaTarea();
   
    if (verificaEspacioLibre(srcDir,dstDir)== false){
        throw new ExceptionFaltaEspacioLibre();
        
    }
    
    //ejecutarTareas(tareas);
    long fin = System.currentTimeMillis();
}
   public boolean verificaEspacioLibre(File srcDir, File dstDir){
        
                boolean exists = true;
                
                if(srcDir.compareTo(dstDir) < 0){
                
                exists = false;
                }
                
             return exists;
        }
   
    private static class ExceptionFaltaEspacioLibre extends Exception {

        public ExceptionFaltaEspacioLibre() {
            
            JOptionPane.showMessageDialog(null,"Error: No hay espacio libre suficiente para realizar la copia"," ", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
    
}