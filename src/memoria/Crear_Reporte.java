
package memoria;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Crear_Reporte {
    File archivo;
    
    
    public void guardarReporte(String codigoHTML, String tipoReporte){
        String nombreArchivo = "";
        if(tipoReporte == "Simbolos"){
            nombreArchivo="C:\\Users\\Dell E5420\\Documents\\SEMESTRES\\Simbolos.html";
           
        }else if(tipoReporte == "Error"){
            nombreArchivo="C:\\Users\\Dell E5420\\Documents\\SEMESTRES\\Errores.html";
        }
        archivo = new File(nombreArchivo);
        try(FileWriter fw = new FileWriter(archivo)){
            fw.write(codigoHTML);
            System.out.println("sdkflkasmdlkf");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
