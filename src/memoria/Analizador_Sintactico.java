
package memoria;

import java.util.ArrayList;


public class Analizador_Sintactico {
    ArrayList<Tokens>listT;
    int recorrido;
    Tokens valor;
    
    
        public void Sintactico(ArrayList lt){
            listT=lt;
            recorrido=0;
            valor=listT.get(0);
            Inicio();
        }
    
    
        public void Inicio(){
            if(valor.getTok().equals("Token_[")){
                parea("Token_[");
                parea("Token_Configuracion");
                parea("Token_]");
                Modul();
                parea("Token_[");
                parea("Token_End-Configuracion");
                parea("Token_]");
                InicioP();
            }
        
        }
    
        public void InicioP(){
    
    
        }
        
        public void Modul(){
    
    
        }
        
        public void ModulP(){
    
    
        }
        
        public void parea(String p){
            if(!p.equals(valor.getTok())){
                System.out.println("Se esperaba...");
            }
            recorrido+=1;
            valor= listT.get(recorrido);
            }
}
