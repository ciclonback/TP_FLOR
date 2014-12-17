import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.sql.Time;
import java.util.ArrayList;
import javax.swing.JOptionPane;

//Calcular Tarea
public class Tarea{
    
    ArrayList<String> listaTareas = new ArrayList<String>();
    String tarea = "";
    int espacioRequerido;
    
    public String checkDirectory(File srcDir, File dstDir) {
        
        try{
               
                if (srcDir.isDirectory()) {
                    if (!dstDir.exists()) {
                     //Agrear a lista de tarea Crear Directorio
                     tarea = srcDir.getName() + "D";       
                     listaTareas.add(tarea);
                    }
                    else{
                     if (!dstDir.exists()) {
                          //Agrear a lista de tarea Crear Archivo
                          tarea = srcDir.getName() + "F";       
                          listaTareas.add(tarea);
                        }
                    }       
                }    
            }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error: al copiar"+e," ", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
            }
        
        return tarea;
    }
       
    
    public String crearListaTarea(File srcDir, File dstDir) {
        
        tarea = checkDirectory(srcDir, dstDir);
        
        File listFileO[] = srcDir.listFiles();
        File listFileD[] = srcDir.listFiles();

        //Verifica Archivos
        if (tarea.isEmpty()){
            
            try{
               
                if (listFileO != null) {
                for (int i = 0; i < listFileO.length; i++) {
                                        
                    for (int j = 0; j < listFileD.length; j++) {
                    if (listFileO[i].isDirectory()) {
                        checkDirectory(listFileO[i],listFileD[j] );
                    } else {
                    
                            }
                        }
                    }
                }
            }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error: al copiar"+e," ", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
            }
        }
        
        return tarea;
    }
    
}    

