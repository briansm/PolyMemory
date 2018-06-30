
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
            for(int x=0;x<listT.size();x++) {
                System.out.println(((Tokens)listT.get(x)).getTok());
            }
        }
    
    
        public void Inicio(){
            if(valor.getTok().equals("Token_[")){
                System.out.println("Si Reconoce");
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
            //InicioP-> EPSILON
            //Nada
        }
        
        public void Modul(){
            Sub();
            ModulP();
    
        }
        
        public void ModulP(){
             Sub();
             ModulP();
    
        }
        
        public void Sub(){
            if(valor.getTok().equals("Token_[")){
                parea("Token_[");
                M();
                parea("Token_]");
            }
    
        }
        
        public void M(){
            if(valor.getTok().equals("Token_Juego")){
                parea("Token_Juego");
                parea("Token_]");
                MJ();
                parea("Token_[");
                parea("Token_End-Juego");
            }else if(valor.getTok().equals("Token_Usuario")){
                parea("Token_Usuario");
                parea("Token_]");
                MU();
                parea("Token_[");
                parea("Token_End-Usuario");
            }else if(valor.getTok().equals("Token_Sonido")){
                parea("Token_Sonido");
                parea("Token_]");
                MS();
                parea("Token_[");
                parea("Token_End-Sonido");
            }else if(valor.getTok().equals("Token_Carta")){
                parea("Token_Carta");
                parea("Token_]");
                MC();
                parea("Token_[");
                parea("Token_End-Carta");
            }
        }
        
        public void MJ(){
            Juego();
            MJP();
        }
        
        public void Juego(){
            if(valor.getTok().equals("Token_[")){
                parea("Token_[");
                JuegoP();
                parea("Token_]");
            }
        }
        
        public void JuegoP(){
            if(valor.getTok().equals("Token_Nivel")){
                parea("Token_Nivel");
                parea("Token_]");
                SN();
                parea("Token_[");
                parea("Token_End-Nivel");
            }else if(valor.getTok().equals("Token_Tiempo")){
                parea("Token_Tiempo");
                parea("Token_]");
                ST();
                parea("Token_[");
                parea("Token_End-Tiempo");
            }
        }
        
        public void SN(){
        
        }
        
        public void ST(){
        
        }
        
        public void MJP(){
        
        }
        
        public void MU(){
        
        }
        public void MS(){
        
        }
        public void MC(){
        
        }
        
        
        
        
        public void parea(String p){
            if(!p.equals(valor.getTok())){
                System.out.println("Se esperaba...");
            }
            recorrido+=1;
            valor= listT.get(recorrido);
            }
}
