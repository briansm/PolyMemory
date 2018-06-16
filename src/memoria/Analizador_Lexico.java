
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
                  //-------letra-----------  
                  if((caracter[i]>=65 && caracter[i]<=90) ||(caracter[i]>=97 && caracter[i]<=122))
                    {
                        estado=1;
                        lexema+=caracter[i];                    
                    }
                  //-------Numero----------- 
                    else if((caracter[i]>=48 && caracter[i]<=57))
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
                    //----Numero,letra,_-------------
                    else if((caracter[i]>=48 && caracter[i]<=57)||((caracter[i]>=65 && caracter[i]<=90) ||(caracter[i]>=97 && caracter[i]<=122))||caracter[i]==95)
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
                    //---------Numero-----------------------
                    if((caracter[i]>=48 && caracter[i]<=57))
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
                    //----------Letra---------
                    if(((caracter[i]>=65 && caracter[i]<=90) ||(caracter[i]>=97 && caracter[i]<=122)))
                    {
                       estado=11;
                       lexema+=caracter[i];  
                    }
                break;
                //------------Estado 8---------------------
                case 8:
                    //----------Numero-----------------
                    if((caracter[i]>=48 && caracter[i]<=57))
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
                    //----Numero,letra-------------
                    if((caracter[i]>=48 && caracter[i]<=57)||((caracter[i]>=65 && caracter[i]<=90) ||(caracter[i]>=97 && caracter[i]<=122)))
                    {
                        estado=13;
                        lexema+=caracter[i];
                    }
                break;
                //------------#Estado 11---------------------
                case 11:
                    //----Numero,letra,_-------------
                    if((caracter[i]>=48 && caracter[i]<=57)||((caracter[i]>=65 && caracter[i]<=90) ||(caracter[i]>=97 && caracter[i]<=122))||caracter[i]==95)
                    {
                        estado=11;
                        lexema+=caracter[i];
                    }
                break;
                //------------#Estado 12---------------------
                case 12:
                    //----------Numero
                    if((caracter[i]>=48 && caracter[i]<=57))
                    {
                       estado=12;
                       lexema+=caracter[i];  
                    }
                break;
                //------------Estado 13---------------------
                case 13:
                    //----Numero,letra,_-------------
                    if((caracter[i]>=48 && caracter[i]<=57)||((caracter[i]>=65 && caracter[i]<=90) ||(caracter[i]>=97 && caracter[i]<=122))||caracter[i]==95)
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
                    //----Numero,letra-------------
                    if((caracter[i]>=48 && caracter[i]<=57)||((caracter[i]>=65 && caracter[i]<=90) ||(caracter[i]>=97 && caracter[i]<=122)))
                    {
                        estado=16;
                        lexema+=caracter[i];
                    }
                break;
                //------------Estado 15---------------------
                case 15:
                    //---------------letra----------------------
                    if(((caracter[i]>=65 && caracter[i]<=90) ||(caracter[i]>=97 && caracter[i]<=122)))
                    {
                       estado=17;
                       lexema+=caracter[i];  
                    }
                break;
                //------------Estado 16---------------------
                case 16:
                    //----Numero,letra,_-------------
                    if((caracter[i]>=48 && caracter[i]<=57)||((caracter[i]>=65 && caracter[i]<=90) ||(caracter[i]>=97 && caracter[i]<=122))||caracter[i]==95)
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
                    //-----------letra---------------------------
                    if(((caracter[i]>=65 && caracter[i]<=90) ||(caracter[i]>=97 && caracter[i]<=122)))
                    {
                       estado=18;
                       lexema+=caracter[i];  
                    }
                break;
                //------------Estado 18---------------------
                case 18:
                    //----Numero,letra-------------
                    if((caracter[i]>=48 && caracter[i]<=57)||((caracter[i]>=65 && caracter[i]<=90) ||(caracter[i]>=97 && caracter[i]<=122)))
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
