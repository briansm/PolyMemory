/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoria;


public class Lexemas {
    String valor_lexema="";
     
     
     public Lexemas(String lexema){
         this.valor_lexema=lexema;
     
     }
        
        public  String getTok(){
            return valor_lexema;
        }
}
