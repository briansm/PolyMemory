
package memoria;

import java.io.*;


public class Abrir_Archivo {
    FileInputStream entrada;
    FileOutputStream salida;
    File Archivo;
    
    public String Abrir(File Archivo){
        String cadena="";
        try{
            entrada=new FileInputStream(Archivo);
            int asc=0;
            while((asc=entrada.read())!=-1){
            char caract=(char)asc;
            cadena+=caract;
            }
        }catch(Exception e){
        }
        return cadena;
    }
}
