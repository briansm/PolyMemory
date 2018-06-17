
package memoria;

import java.util.ArrayList;


public class Analizador_Lexico {
    int estado=0;
    int num=0;
    int numer=0;
    int fila=1;
    int columna=0;
    String lexema="";
    public ArrayList<Datos>arregloToken=new ArrayList<Datos>();
    public ArrayList<Datos>arregloError=new ArrayList<Datos>();
    
    public ArrayList<Datos> getArrT(){
        return arregloToken;
    }
    public void setAT(ArrayList<Datos> arregloToken){
        this.arregloToken=arregloToken;
    }
    public ArrayList<Datos>getArrE(){
        return arregloError;
    }
    public void setAE(ArrayList<Datos>arregloError){
        this.arregloError=arregloError;
    }
    
    
    
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
                    else
                    {
                        lexema+=caracter[i];
                        estado=100;
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
                    else if(caracter[i] == 32 || caracter[i] == 10 || caracter[i] == 9)
                    {
                        num++;
                        arregloToken.add(new Datos(num,lexema,tipoT(lexema),fila,columna));
                        lexema="";
                        estado=0;
                    }
                    else
                    {
                        lexema+=caracter[i];
                        estado=100;
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
                    else if(caracter[i] == 32 || caracter[i] == 10 || caracter[i] == 9)
                    {
                        num++;
                        arregloToken.add(new Datos(num,lexema,"Token_Digito",fila,columna));
                        lexema="";
                        estado=0;
                    }
                    else
                    {
                        lexema+=caracter[i];
                        estado=100;
                    }
                break;
                //----------#Estado 3-------------------------
                case 3:
                    if(caracter[i]==62)
                    {
                        estado=9;
                        lexema+=caracter[i];
                    }
                    else if(caracter[i] == 32 || caracter[i] == 10 || caracter[i] == 9)
                    {
                        num++;
                        arregloToken.add(new Datos(num,lexema,"Token_Simbolo",fila,columna));
                        lexema="";
                        estado=0;
                    }
                    else
                    {
                        lexema+=caracter[i];
                        estado=100;
                    }
                break;
                //------------#Estado 4---------------------
                case 4:
                        num++;
                        arregloToken.add(new Datos(num,lexema,"Token_Simbolo",fila,columna));
                        lexema="";
                        estado=0;
                break;
                //------------Estado 5---------------------
                case 5:
                    if(caracter[i]==92)
                    {
                        estado=10;
                        lexema+=caracter[i];  
                    }
                    else
                    {
                        lexema+=caracter[i];
                        estado=100;
                    }
                break;
                //------------#Estado 6---------------------
                case 6:
                    if(caracter[i]==45)
                    {
                        estado=7;
                        lexema+=caracter[i];  
                    }
                    else if(caracter[i] == 32 || caracter[i] == 10 || caracter[i] == 9)
                    {
                        num++;
                        arregloToken.add(new Datos(num,lexema,"Token_ID",fila,columna));
                        lexema="";
                        estado=0;
                    }
                    else
                    {
                        lexema+=caracter[i];
                        estado=100;
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
                    else
                    {
                        lexema+=caracter[i];
                        estado=100;
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
                    else
                    {
                        lexema+=caracter[i];
                        estado=100;
                    }
                break;
                //------------#Estado 9---------------------
                case 9:
                        num++;
                        arregloToken.add(new Datos(num,lexema,tipoT(lexema),fila,columna));
                        lexema="";
                        estado=0;
                break;
                //------------Estado 10---------------------
                case 10:
                    //----Numero,letra-------------
                    if((caracter[i]>=48 && caracter[i]<=57)||((caracter[i]>=65 && caracter[i]<=90) ||(caracter[i]>=97 && caracter[i]<=122)))
                    {
                        estado=13;
                        lexema+=caracter[i];
                    }
                    else
                    {
                        lexema+=caracter[i];
                        estado=100;
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
                    else
                    {
                        lexema+=caracter[i];
                        estado=100;
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
                    else if(caracter[i] == 32 || caracter[i] == 10 || caracter[i] == 9)
                    {
                        num++;
                        arregloToken.add(new Datos(num,lexema,"Token_Digito",fila,columna));
                        lexema="";
                        estado=0;
                    }
                    else
                    {
                        lexema+=caracter[i];
                        estado=100;
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
                    else
                    {
                        lexema+=caracter[i];
                        estado=100;
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
                    else
                    {
                        lexema+=caracter[i];
                        estado=100;
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
                    else
                    {
                        lexema+=caracter[i];
                        estado=100;
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
                    else
                    {
                        lexema+=caracter[i];
                        estado=100;
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
                    else
                    {
                        lexema+=caracter[i];
                        estado=100;
                    }
                break;
                //------------Estado 18---------------------
                case 18:
                    //----Numero,letra-------------
                    if((caracter[i]>=48 && caracter[i]<=57)||((caracter[i]>=65 && caracter[i]<=90) ||(caracter[i]>=97 && caracter[i]<=122)))
                    {
                        estado=19;
                        lexema+=caracter[i];
                    }
                    else
                    {
                        lexema+=caracter[i];
                        estado=100;
                    }
                break;
                //------------#Estado 19---------------------
                case 19:
                        num++;
                        arregloToken.add(new Datos(num,lexema,"Token_Simbolo",fila,columna));
                        lexema="";
                        estado=0;
                break;
                //------------Estado error---------------------
                case 100:
                    if(caracter[i] == 32 || caracter[i] == 10 || caracter[i] == 9)
                    {
                        numer++;
                        arregloToken.add(new Datos(numer,lexema,fila,columna));
                        lexema="";
                        estado=0;
                    }
                    else
                    {
                        lexema+=caracter[i];
                        estado=100;
                    }
                break;
                  
            }
            //---------FIN ANALISIS-----------------------
        }
        //------------FIN LOOP----------------------
 
    }
    
    //--------Metodo Para Reconocer Tokens----------------------------
    public String tipoT(String lexema){
        String tipo_token="";
        
        if(lexema=="Configuracion" || lexema=="configuracion"){
            tipo_token="Token_Configuracion";
        }
        else if(lexema=="Juego" || lexema=="juego")
        {
            tipo_token="Token_Juego";
        }
        else if(lexema=="Nivel" || lexema=="nivel")
        {
            tipo_token="Token_Nivel";
        }
        else if(lexema=="Facil" || lexema=="facil")
        {
            tipo_token="Token_Facil";
        }
        else if(lexema=="Intermedio" || lexema=="intermedio")
        {
            tipo_token="Token_Intermedio";
        }
        else if(lexema=="Dificil" || lexema=="dificil")
        {
            tipo_token="Token_Dificil";
        }
        else if(lexema=="Tiempo" || lexema=="tiempo")
        {
            tipo_token="Token_Tiempo";
        }
        else if(lexema=="Usuarios" || lexema=="usuarios")
        {
            tipo_token="Token_Usuarios";
        }
        else if(lexema=="Nombre" || lexema=="nombre")
        {
            tipo_token="Token_Nombre";
        }
        else if(lexema=="Sonido" || lexema=="sonido")
        {
            tipo_token="Token_Sonido";
        }
        else if(lexema=="Track_1" || lexema=="track_1")
        {
            tipo_token="Token_Track";
        }
        else if(lexema=="Imagen" || lexema=="imagen")
        {
            tipo_token="Token_Imagen";
        }
        else if(lexema=="Idioma" || lexema=="idioma")
        {
            tipo_token="Token_Idioma";
        }
        else if(lexema=="Palabra" || lexema=="palabra")
        {
            tipo_token="Token_Palabra";
        }
        else if(lexema=="Carta" || lexema=="carta")
        {
            tipo_token="Token_Carta";
        }
        else if(lexema=="End-Configuracion" || lexema=="end-configuracion")
        {
            tipo_token="Token_End-Configuracion";
        }
        else if(lexema=="End-Nivel" || lexema=="end-nivel")
        {
            tipo_token="Token_End-Nivel";
        }
        else if(lexema=="End-Tiempo" || lexema=="end-tiempo")
        {
            tipo_token="Token_End-Tiempo";
        }
        else if(lexema=="End-Juego" || lexema=="end-juego")
        {
            tipo_token="Token_End-Juego";
        }
        else if(lexema=="End-Usuarios" || lexema=="end-usuarios")
        {
            tipo_token="Token_End-Usuarios";
        }
        else if(lexema=="End-Sonido" || lexema=="end-sonido")
        {
            tipo_token="Token_End-Sonido";
        }
        else if(lexema=="End-Carta" || lexema=="end-carta")
        {
            tipo_token="Token_End-Carta";
        }
        else if(lexema=="End-Nivel" || lexema=="end-nivel")
        {
            tipo_token="Token_End-Nivel";
        }
        else if(lexema=="->")
        {
            tipo_token="Token_->";
        }
        
    return tipo_token;
    }
   
    
}
