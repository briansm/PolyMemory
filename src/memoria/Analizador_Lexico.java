
package memoria;


public class Analizador_Lexico {
    int estado=0;
    int fila=1;
    int columna=0;
    String lexema="";
    
    //-----------------Inicio--------------------------
    public void lexico(String entrada){
        char [] caracter=entrada.toCharArray();
        //----------loop que recorre el arreglo--------------------
        for(int i=0;i<caracter.length;i++){
            //-----------Fila y columna------------------------------
            if(caracter[i]==10){
                fila++;
                columna=0;
            }
            else
            {
                columna++;
            }
            
            //-------------Inicio_Analisis------------------------------
            switch(estado){
                //---------Estado 0-------------------------------------
                case 0:
                    if(Character.isLetter(caracter[i]))
                    {
                        estado=1;
                        lexema+=caracter[i];                    
                    }
                    else if(Character.isDigit(caracter[i]))
                    {
                        estado=2;
                        lexema+=caracter[i];
                    }
                    else if(caracter[i]==45)
                    {
                        estado=3;
                        lexema+=caracter[i];
                    }
                    else if(caracter[i]==42 || caracter[i]==43 || caracter[i]==47)
                    {
                        estado=4;
                        lexema+=caracter[i];
                    }
                break;
                //-------------#Estado 1-------------------------------------
                case 1:
                    if(caracter[i]==58)
                    {
                        estado=5;
                        lexema+=caracter[i];
                    }
                    else if(Character.isDigit(caracter[i])||Character.isLetter(caracter[i])||caracter[i]==95)
                    {
                        estado=6;
                        lexema+=caracter[i];
                    }
                    else if(caracter[i]==45)
                    {
                        estado=7;
                        lexema+=caracter[i];
                    }
                break;
                //------------#Estado 2-----------------------
                case 2:
                    if(Character.isDigit(caracter[i]))
                    {
                        estado=2;
                        lexema+=caracter[i];
                    }
                    else if(caracter[i]==46)
                    {
                        estado=8;
                        lexema+=caracter[i];
                    }
                break;
                //----------#Estado 3-------------------------
                case 3:
                    if(caracter[i]==62)
                    {
                        estado=9;
                        lexema+=caracter[i];
                    }
                break;
                //------------#Estado 4---------------------
                case 4:
                    
                break;
                //------------Estado 5---------------------
                case 5:
                    if(caracter[i]==92)
                    {
                        estado=10;
                        lexema+=caracter[i];  
                    }
                break;
                //------------#Estado 6---------------------
                case 6:
                    if(caracter[i]==45)
                    {
                        estado=7;
                        lexema+=caracter[i];  
                    }
                break;
                //------------Estado 7---------------------
                case 7:
                    if(Character.isLetter(caracter[i]))
                    {
                       estado=11;
                       lexema+=caracter[i];  
                    }
                break;
                //------------Estado 8---------------------
                case 8:
                    if(Character.isDigit(caracter[i]))
                    {
                       estado=12;
                       lexema+=caracter[i];  
                    }
                break;
                //------------#Estado 9---------------------
                case 9:
                    
                break;
                //------------Estado 10---------------------
                case 10:
                    if(Character.isDigit(caracter[i])||Character.isLetter(caracter[i]))
                    {
                        estado=13;
                        lexema+=caracter[i];
                    }
                break;
                //------------#Estado 11---------------------
                case 11:
                    if(Character.isDigit(caracter[i])||Character.isLetter(caracter[i])||caracter[i]==95)
                    {
                        estado=11;
                        lexema+=caracter[i];
                    }
                break;
                //------------#Estado 12---------------------
                case 12:
                    if(Character.isDigit(caracter[i]))
                    {
                       estado=12;
                       lexema+=caracter[i];  
                    }
                break;
                //------------Estado 13---------------------
                case 13:
                    if(Character.isDigit(caracter[i])||Character.isLetter(caracter[i])||caracter[i]==95)
                    {
                        estado=13;
                        lexema+=caracter[i];
                    }
                    else if(caracter[i]==92)
                    {
                        estado=14;
                        lexema+=caracter[i];
                    }
                    else if(caracter[i]==46)
                    {
                        estado=15;
                        lexema+=caracter[i];
                    }
                break;
                //------------Estado 14---------------------
                case 14:
                    if(Character.isDigit(caracter[i])||Character.isLetter(caracter[i]))
                    {
                        estado=16;
                        lexema+=caracter[i];
                    }
                break;
                //------------Estado 15---------------------
                case 15:
                    if(Character.isLetter(caracter[i]))
                    {
                       estado=17;
                       lexema+=caracter[i];  
                    }
                break;
                //------------Estado 16---------------------
                case 16:
                    if(Character.isDigit(caracter[i])||Character.isLetter(caracter[i])||caracter[i]==95)
                    {
                        estado=16;
                        lexema+=caracter[i];
                    }
                    else if(caracter[i]==92)
                    {
                        estado=14;
                        lexema+=caracter[i];
                    }
                    else if(caracter[i]==46)
                    {
                        estado=15;
                        lexema+=caracter[i];
                    }
                break;
                //------------Estado 17---------------------
                case 17:
                    if(Character.isLetter(caracter[i]))
                    {
                       estado=18;
                       lexema+=caracter[i];  
                    }
                break;
                //------------Estado 18---------------------
                case 18:
                    if(Character.isDigit(caracter[i])||Character.isLetter(caracter[i]))
                    {
                        estado=119;
                        lexema+=caracter[i];
                    }
                break;
                //------------#Estado 19---------------------
                case 19:
                    
                break;
                //------------Estado error---------------------
                case 100:
                    
                break;
                  
            }
            //---------FIN ANALISIS-----------------------
        }
        //------------FIN LOOP----------------------
    
    
    
    
    }
    
    
}
