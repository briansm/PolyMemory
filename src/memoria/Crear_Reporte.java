
package memoria;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Crear_Reporte {
    File archivo;
    
    
    public void guardarReporte(String codigoHTML, String tipoReporte){
        
        String nombreArchivo = "";
        if(tipoReporte == "Simbolos"){
            nombreArchivo="C:\\Users\\Dell E5420\\Documents\\Simbolos.html";
           
        }else if(tipoReporte == "Error"){
            nombreArchivo="C:\\Users\\Dell E5420\\Documents\\Errores.html";
            
        }else if(tipoReporte == "Sintactico"){
            nombreArchivo="C:\\Users\\Dell E5420\\Documents\\Sintactico.html";
        }else if(tipoReporte == "Reporte"){
            nombreArchivo="C:\\Users\\Dell E5420\\Documents\\Reporte.txt";
        }
        
        archivo = new File(nombreArchivo);
        try(FileWriter escritura = new FileWriter(archivo)){
            escritura.write(codigoHTML);
            System.out.println("sdkflkasmdlkf");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
