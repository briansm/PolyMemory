
package memoria;

import java.util.ArrayList;


public class Analizador_Sintactico {
    ArrayList<Tokens>listT;
    int recorrido;
    Tokens valor;
    public ArrayList<Datos> arregloSint = new ArrayList<Datos>();
    public ArrayList<Datos> getSint() {
        return arregloSint;
    }
    public void setSint(ArrayList<Datos> arregloSint) {
        this.arregloSint = arregloSint;
    }
    
    
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
                
                parea("Token_[");
                parea("Token_Configuracion");
                parea("Token_]");
                parea("Token_[");
                
                Modul();
                
               
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
                parea("Token_[");
                
                Modul();
                
                
                parea("Token_End-Configuracion");
                parea("Token_]");
                
                InicioP();
            }else{
                //InicioP-> EPSILON
                //Nada
                }
            
        }
        
        
        public void Modul(){
            if(valor.getTok().equals("Token_Juego")){
                
                parea("Token_Juego");
                parea("Token_]");
                parea("Token_[");
                
                MJ();
                
                parea("Token_End-Juego");
                parea("Token_]");
                parea("Token_[");
                ModulP();
            }else if(valor.getTok().equals("Token_Usuarios")){
                parea("Token_Usuarios");
                parea("Token_]");
                parea("Token_[");
                
                MU();
                
                parea("Token_End-Usuarios");
                parea("Token_]");
                parea("Token_[");
                ModulP();
            }else if(valor.getTok().equals("Token_Sonido")){
                parea("Token_Sonido");
                parea("Token_]");
                parea("Token_[");
                
                MS();
                
                parea("Token_End-Sonido");
                parea("Token_]");
                parea("Token_[");
                ModulP();
            }else if(valor.getTok().equals("Token_Carta")){
                parea("Token_Carta");
                parea("Token_]");
                parea("Token_[");
                
                MC();
                
                parea("Token_End-Carta");
                parea("Token_]");
                parea("Token_[");
                ModulP();
            }
        }
        
        public void ModulP(){
            if(valor.getTok().equals("Token_Juego")){
                
                parea("Token_Juego");
                parea("Token_]");
                parea("Token_[");
                
                MJ();
                
                parea("Token_End-Juego");
                parea("Token_]");
                parea("Token_[");
                ModulP();
            }else if(valor.getTok().equals("Token_Usuarios")){
                parea("Token_Usuarios");
                parea("Token_]");
                parea("Token_[");
                
                MU();
                
                parea("Token_End-Usuarios");
                parea("Token_]");
                parea("Token_[");
                ModulP();
            }else if(valor.getTok().equals("Token_Sonido")){
                parea("Token_Sonido");
                parea("Token_]");
                parea("Token_[");
                
                MS();
                
                parea("Token_End-Sonido");
                parea("Token_]");
                parea("Token_[");
                ModulP();
            }else if(valor.getTok().equals("Token_Carta")){
                parea("Token_Carta");
                parea("Token_]");
                parea("Token_[");
                
                MC();
                
                parea("Token_End-Carta");
                parea("Token_]");
                parea("Token_[");
                ModulP();
            }
        }
        
        
        
        
        public void MJ(){
           
           if(valor.getTok().equals("Token_Nivel")){
                parea("Token_Nivel");
                parea("Token_]");
                parea("Token_[");
                SN();
                
                parea("Token_End-Nivel");
                parea("Token_]");
                parea("Token_[");
                MJP();
            }else if(valor.getTok().equals("Token_Tiempo")){
                parea("Token_Tiempo");
                parea("Token_]");
                parea("Token_[");
                ST();
                
                parea("Token_End-Tiempo");
                parea("Token_]");
                parea("Token_[");
                MJP();
            }
            
        }
        
        public void MJP(){
            if(valor.getTok().equals("Token_Nivel")){
                parea("Token_Nivel");
                parea("Token_]");
                parea("Token_[");
                SN();
                
                parea("Token_End-Nivel");
                parea("Token_]");
                parea("Token_[");
                MJP();
            }else if(valor.getTok().equals("Token_Tiempo")){
                parea("Token_Tiempo");
                parea("Token_]");
                parea("Token_[");
                ST();
                
                parea("Token_End-Tiempo");
                parea("Token_]");
                parea("Token_[");
                MJP();
            }
        }
        

        
        public void SN(){
            if(valor.getTok().equals("Token_Facil")){
                parea("Token_Facil");
                parea("Token_]");
                parea("Token_->");
                parea("Token_[");
                Operacion();
                parea("Token_#");
                Operacion();
                parea("Token_]");
                parea("Token_[");
                SNP();
            }else if(valor.getTok().equals("Token_Intermedio")){
                parea("Token_Intermedio");
                parea("Token_]");
                parea("Token_->");
                parea("Token_[");
                Operacion();
                parea("Token_#");
                Operacion();
                parea("Token_]");
                parea("Token_[");
                SNP();
            }else if(valor.getTok().equals("Token_Dificil")){
                parea("Token_Dificil");
                parea("Token_]");
                parea("Token_->");
                parea("Token_[");
                Operacion();
                parea("Token_#");
                Operacion();
                parea("Token_]");
                parea("Token_[");
                SNP();
            } 
            
        }
        
        public void SNP(){
            if(valor.getTok().equals("Token_Facil")){
                parea("Token_Facil");
                parea("Token_]");
                parea("Token_->");
                parea("Token_[");
                Operacion();
                parea("Token_#");
                Operacion();
                parea("Token_]");
                parea("Token_[");
                SNP();
            }else if(valor.getTok().equals("Token_Intermedio")){
                parea("Token_Intermedio");
                parea("Token_]");
                parea("Token_->");
                parea("Token_[");
                Operacion();
                parea("Token_#");
                Operacion();
                parea("Token_]");
                parea("Token_[");
                SNP();
            }else if(valor.getTok().equals("Token_Dificil")){
                parea("Token_Dificil");
                parea("Token_]");
                parea("Token_->");
                parea("Token_[");
                Operacion();
                parea("Token_#");
                Operacion();
                parea("Token_]");
                parea("Token_[");
                SNP();
            } 
        }
        
        
        
        public void ST(){
           if(valor.getTok().equals("Token_Facil")){
                parea("Token_Facil");
                parea("Token_]");
                parea("Token_->");
                parea("Token_[");
                
                Operacion();
                parea("Token_]");
                parea("Token_[");
                STP();
            }else if(valor.getTok().equals("Token_Intermedio")){
                parea("Token_Intermedio");
                parea("Token_]");
                parea("Token_->");
                parea("Token_[");
                Operacion();
                
                parea("Token_]");
                parea("Token_[");
                STP();
            }else if(valor.getTok().equals("Token_Dificil")){
                parea("Token_Dificil");
                parea("Token_]");
                parea("Token_->");
                parea("Token_[");
                Operacion();
                
                parea("Token_]");
                parea("Token_[");
                STP();
            } 
            
        }
        
        public void STP(){
            if(valor.getTok().equals("Token_Facil")){
                parea("Token_Facil");
                parea("Token_]");
                parea("Token_->");
                parea("Token_[");
                
                Operacion();
                parea("Token_]");
                parea("Token_[");
                STP();
            }else if(valor.getTok().equals("Token_Intermedio")){
                parea("Token_Intermedio");
                parea("Token_]");
                parea("Token_->");
                parea("Token_[");
                Operacion();
                
                parea("Token_]");
                parea("Token_[");
                STP();
            }else if(valor.getTok().equals("Token_Dificil")){
                parea("Token_Dificil");
                parea("Token_]");
                parea("Token_->");
                parea("Token_[");
                Operacion();
                
                parea("Token_]");
                parea("Token_[");
                STP();
            } 
        }
        
        
        public void MU(){
            if(valor.getTok().equals("Token_Nombre")){
                
                parea("Token_Nombre");
                parea("Token_]");
                parea("Token_->");
                parea("Token_[");
                parea("Token_Comillas");
                parea("Token_Id");
                parea("Token_Comillas");
                parea("Token_]");
                parea("Token_[");
                MUP();
            }
            
        }
        
        public void MUP(){
            if(valor.getTok().equals("Token_Nombre")){
                
                parea("Token_Nombre");
                parea("Token_]");
                parea("Token_->");
                parea("Token_[");
                parea("Token_Comillas");
                parea("Token_Id");
                parea("Token_Comillas");
                parea("Token_]");
                parea("Token_[");
                MUP();
            }
        }
        
     
        
        public void MS(){
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
                MSP();
            }
            
        }
        
        public void MSP(){
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
                MSP();
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
                MCP();
            }
        }
        
        public void MCP(){
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
                MCP();
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
        
        
        
        public void parea(String terminal){
            if(valor.getTok().equals(terminal)){
                System.out.println("Si Reconoce  "+terminal);
                recorrido+=1;
                valor= listT.get(recorrido);
            }else{
                arregloSint.add(new Datos( terminal, 1, 1,"Se esperaba..."+tipoE(terminal)));
               // System.out.println("Se esperaba..."+tipoE(terminal));
                
            }
            
          //  if (!valor.getTok().equals("Fin")){
          //      recorrido+=1;
          //      valor= listT.get(recorrido);
          //  } 
            
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
