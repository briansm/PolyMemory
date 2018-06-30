
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
        
        public void MJP(){
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
            Nivel();
            SNP();
        }
        
        public void SNP(){
            Nivel();
            SNP();
        }
        
        
        
        public void Nivel(){
            if(valor.getTok().equals("Token_[")){
                parea("Token_[");
                NivelP();
                parea("Token_]");
            }
        }
        
        public void NivelP(){
            if(valor.getTok().equals("Token_Facil")){
                parea("Token_Facil");
                parea("Token_]");
                parea("Token_->");
                parea("Token_[");
                Operacion();
                parea("Token_#");
                Operacion();
            }else if(valor.getTok().equals("Token_Intermedio")){
                parea("Token_Intermedio");
                parea("Token_]");
                parea("Token_->");
                parea("Token_[");
                Operacion();
                parea("Token_#");
                Operacion();
            }else if(valor.getTok().equals("Token_Dificil")){
                parea("Token_Dificil");
                parea("Token_]");
                parea("Token_->");
                parea("Token_[");
                Operacion();
                parea("Token_#");
                Operacion();
            } 
        }
        
        
        public void ST(){
            Tiempo();
            STP();
        }
        
        public void STP(){
            Tiempo();
            STP();
        }
        
        public void Tiempo(){
            if(valor.getTok().equals("Token_[")){
                parea("Token_[");
                TiempoP();
                parea("Token_]");
            }
        
        }
        
        public void TiempoP(){
            if(valor.getTok().equals("Token_Facil")){
                parea("Token_Facil");
                parea("Token_]");
                parea("Token_->");
                parea("Token_[");
                Operacion();
              
            }else if(valor.getTok().equals("Token_Intermedio")){
                parea("Token_Intermedio");
                parea("Token_]");
                parea("Token_->");
                parea("Token_[");
                Operacion();
                
            }else if(valor.getTok().equals("Token_Dificil")){
                parea("Token_Dificil");
                parea("Token_]");
                parea("Token_->");
                parea("Token_[");
                Operacion();
                
            }   
        }
        
        
        public void MU(){
            Usuario();
            MUP();
        }
        
        public void MUP(){
            Usuario();
            MUP();
        }
        
        public void Usuario(){
            if(valor.getTok().equals("Token_[")){
                parea("Token_[");
                parea("Token_Nombre");
                parea("Token_]");
                parea("Token_->");
                parea("Token_[");
                parea("Token_Comillas");
                parea("Token_Id");
                parea("Token_Comillas");
                parea("Token_]");
            }
        }
        
        public void MS(){
            Sonido();
            MSP();
        }
        
        public void MSP(){
            Sonido();
            MSP();
        }
        
        public void Sonido(){
            if(valor.getTok().equals("Token_[")){
                parea("Token_[");
                parea("Token_Track");
                parea("Token_]");
                parea("Token_->");
                parea("Token_[");
                parea("Token_Comillas");
                parea("Token_Ruta");
                parea("Token_Comillas");
                parea("Token_]");
            }
        
        }
        
        public void MC(){
            if(valor.getTok().equals("Token_[")){
                parea("Token_[");
                parea("Token_Nombre");
                parea("Token_]");
                parea("Token_->");
                parea("Token_[");
                parea("Token_Comillas");
                parea("Token_Id");
                parea("Token_Comillas");
                parea("Token_]");
                
                parea("Token_[");
                parea("Token_Imagen");
                parea("Token_]");
                parea("Token_->");
                parea("Token_[");
                parea("Token_Comillas");
                parea("Token_Ruta");
                parea("Token_Comillas");
                parea("Token_]");
                
                parea("Token_[");
                parea("Token_Idioma");
                parea("Token_]");
                parea("Token_->");
                parea("Token_[");
                parea("Token_Comillas");
                parea("Token_Id");
                parea("Token_Comillas");
                parea("Token_]");
                
                parea("Token_[");
                parea("Token_Palabra");
                parea("Token_]");
                parea("Token_->");
                parea("Token_[");
                parea("Token_Comillas");
                parea("Token_Id");
                parea("Token_Comillas");
                parea("Token_]");
            }
        }
        
        
        public void Operacion(){
            T();
            EP();
        }
        
        public void EP(){
            if(valor.getTok().equals("Token_+")){
                parea("Token_+");
                T();
                EP();
            }else if(valor.getTok().equals("Token_-")){
                parea("Token_-");
                T();
                EP();
            } 
        }
        
        public void T(){
            F();
            TP();
        }
        
        public void TP(){
            if(valor.getTok().equals("Token_*")){
                parea("Token_*");
                F();
                TP();
            }else if(valor.getTok().equals("Token_/")){
                parea("Token_/");
                F();
                TP();
            }
        
        }
        
        public void F(){
            if(valor.getTok().equals("Token_Digito")){
                parea("Token_Digito");
            
            }else if(valor.getTok().equals("Token_Decimal")){
                parea("Token_Decimal");
            
            }
        
        }
        
        
        
        public void parea(String p){
            if(!p.equals(valor.getTok())){
                System.out.println("Se esperaba...");
            }
            
            if (!listT.isEmpty()) {
                 System.out.println(listT.get(listT.size()-1));
                }

                recorrido+=1;
                valor= listT.get(recorrido);
            
            
            }
        
        
        public String tipoE(String p){
            switch(p){
                case "Token_Configuracion":
                    return "Token_Configuracion";
                case "Token_Juego":
                    return "Token_Juego";
                case "Token_Nivel":
                    return "Token_Nivel";
                case "Token_Facil":
                    return "Token_Facil";
                case "Token_Intermedio":
                    return "Token_Intermedio";
                case "Token_Dificil":
                    return "Token_Dificil";
                case "Token_Tiempo":
                    return "Token_Tiempo";
                case "Token_Usuarios":
                    return "Token_Usuarios";
                case "Token_Nombre":
                    return "Token_Nombre";
                case "Token_Sonido":
                    return "Token_Sonido";
                case "Token_Track":
                    return "Token_Track";
                case "Token_Imagen":
                    return "Token_Imagen";
                case "Token_Idioma":
                    return "Token_Idioma";
                case "Token_Palabra":
                    return "Token_Palabra";
                case "Token_Carta":
                    return "Token_Carta";
                case "Token_End-Configuracion":
                    return "Token_End-Configuracion";
                case "Token_End-Nivel":
                    return "Token_End-Nivel";
                case "Token_End-Tiempo":
                    return "Token_End-Tiempo";
                case "Token_End-Juego":
                    return "Token_End-Juego";
                case "Token_End-Usuarios":
                    return "Token_End-Usuarios";
                case "Token_End-Sonido":
                    return "Token_End-Sonido";
                case "Token_End-Carta":
                    return "Token_End-Carta";
                case "Token_Comillas":
                    return "Token_Comillas";
                case "Token_Digito":
                    return "Token_Digito";
                case "Token_Decimal":
                    return "Token_Decimal";
                case "Token_+":
                    return "Token_+";
                case "Token_-":
                    return "Token_-";
                case "Token_*":
                    return "Token_*";
                case "Token_/":
                    return "Token_/"; 
                case "Token_->":
                    return "Token_->";
                case "Token_]":
                    return "Token_]";
                case "Token_[":
                    return "Token_[";
                case "Token_#":
                    return "Token_#"; 
                case "Token_Id":    
                    return  "Token_Id";
                default:
                return  "Desconocido";
                
        
        
        }
            
            
            
            
            
            
            
            
            
            
            
                
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
        
        
        }
}
