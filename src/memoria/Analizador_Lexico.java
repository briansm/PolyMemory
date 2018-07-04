package memoria;

import java.util.ArrayList;

public class Analizador_Lexico {

    int estado = 0;
    int num = 0;
    int numer = 0;
    int fila = 1;
    int columna = -1;
    String lexema = "";
    public ArrayList<Datos> arregloToken = new ArrayList<Datos>();
    public ArrayList<Datos> arregloError = new ArrayList<Datos>();
    
    public ArrayList<Tokens> listaTok=new ArrayList<Tokens>();
    public static ArrayList<Lexemas> lista_lexemas=new ArrayList<Lexemas>();
    public static ArrayList<Niveles> lista_niveles=new ArrayList<Niveles>();
    public static ArrayList<Idiomas> lista_idiomas=new ArrayList<Idiomas>();
    public ArrayList<Lexemas> getLexem() {
        return lista_lexemas;
    }
    public ArrayList<Niveles> getNiveles() {
        return lista_niveles;
    }
    public ArrayList<Idiomas> getId() {
        return lista_idiomas;
    }
    public ArrayList<Tokens> getT() {
        return listaTok;
    }
    
    public ArrayList<Datos> getArrT() {
        return arregloToken;
    }

    public void setAT(ArrayList<Datos> arregloToken) {
        this.arregloToken = arregloToken;
    }

    public ArrayList<Datos> getArrE() {
        return arregloError;
    }

    public void setAE(ArrayList<Datos> arregloError) {
        this.arregloError = arregloError;
    }

    //-----------------Inicio--------------------------
    public void lexico(String entrada) {
       entrada += " ";
        char[] caracter = entrada.toCharArray();
        //----------loop que recorre el arreglo--------------------
        for (int i = 0; i < caracter.length; i++) {
            //-----------Fila y columna------------------------------
            switch (caracter[i]) {
                case 10:
                    fila++;
                    columna = -1;
                    break;
                case 9:
                    columna+=5;
                    break;
                case 32:
                    //columna++;
                    break;
                default:
                    columna++;
                    break;
            }
            //-------------Inicio_Analisis------------------------------
            switch (estado) {
                //---------Estado 0-------------------------------------
                case 0:
                    //-------letra-----------  
                    if (((caracter[i] >= 65 && caracter[i] <= 90)) || ((caracter[i] >= 97 && caracter[i] <= 122))) {
                        estado = 1;
                        lexema += caracter[i];
                    } //-------Numero----------- 
                    else if ((caracter[i] >= 48 && caracter[i] <= 57)) {
                        estado = 2;
                        lexema += caracter[i];
                    } else if (caracter[i] == 45) {
                        estado = 3;
                        lexema += caracter[i];
                    } else if (caracter[i] == 43) {
                        estado = 23;
                        lexema += caracter[i];
                    } else if (caracter[i] == 42) {
                        estado = 24;
                        lexema += caracter[i]; 
                    } else if (caracter[i] == 47) {
                        estado = 25;
                        lexema += caracter[i];     
                    } else if (caracter[i] == 91) {
                        estado = 20;
                        lexema += caracter[i];
                    } else if (caracter[i] == 93) {
                        estado = 21;
                        lexema += caracter[i];
                    } else if (caracter[i] == 34) {
                        estado = 22;
                        lexema += caracter[i];
                    } else if (caracter[i] == 35) {
                        estado = 26;
                        lexema += caracter[i];    
                    } else if ((caracter[i] >=1) && (caracter[i] <= 32)) {
                    } else {
                        
                        numer++;
                        arregloError.add(new Datos(numer, lexema+=caracter[i], fila, columna));
                        lexema = "";
                        estado = 0;
                    }
                    break;
                //-------------#Estado 1-------------------------------------
                case 1:
                    if (caracter[i] == 58) {
                        estado = 5;
                        lexema += caracter[i];
                    } //----Numero,letra,_-------------
                    else if (((caracter[i] >= 48 && caracter[i] <= 57)) || ((caracter[i] >= 65 && caracter[i] <= 90)) || ((caracter[i] >= 97 && caracter[i] <= 122)) || (caracter[i] == 95)) {
                        estado = 6;
                        lexema += caracter[i];
                    } else if (caracter[i] == 45) {
                        estado = 7;
                        lexema += caracter[i];
                    } else {
                        num++;
                        lista_lexemas.add(new Lexemas(lexema));
                        //listaTok.add(new Tokens(tipoT(lexema)));
                        arregloToken.add(new Datos(num, lexema, tipoT(lexema), fila, columna));
                        lexema = "";
                        estado = 0;
                        i--;
                    }

                    break;
                //------------#Estado 2-----------------------
                case 2:
                    //---------Numero-----------------------
                    if ((caracter[i] >= 48 && caracter[i] <= 57)) {
                        estado = 2;
                        lexema += caracter[i];
                    } else if (caracter[i] == 46) {
                        estado = 8;
                        lexema += caracter[i];
                    } else {
                        num++;
                        listaTok.add(new Tokens("Token_Digito"));
                        //lista_lexemas.add(new Lexemas(lexema));
                        arregloToken.add(new Datos(num, lexema, "Token_Digito", fila, columna));
                        lexema = "";
                        estado = 0;
                        i--;
                    }

                    break;
                //----------#Estado 3-------------------------
                case 3:
                    if (caracter[i] == 62) {
                        estado = 9;
                        lexema += caracter[i];
                    } 
                    else 
                    {
                        num++;
                        listaTok.add(new Tokens("Token_Simbolo"));
                        //lista_lexemas.add(new Lexemas(lexema));
                        arregloToken.add(new Datos(num, lexema, "Token_Simbolo", fila, columna));
                        lexema = "";
                        estado = 0;
                        i--;
                    }

                    break;
                //------------#Estado 4---------------------
                case 4:
                    num++;
                    listaTok.add(new Tokens("TOken_Simbolo"));
                    //lista_lexemas.add(new Lexemas(lexema));
                    arregloToken.add(new Datos(num, lexema, "Token_Simbolo", fila, columna));
                    lexema = "";
                    estado = 0;
                    i--;
                    break;
                //------------Estado 5---------------------
                case 5:
                    if (caracter[i] == 92) {
                        estado = 10;
                        lexema += caracter[i];
                    } else {
                        numer++;
                        arregloError.add(new Datos(numer, lexema+=caracter[i], fila, columna));
                        lexema = "";
                        estado = 0;
                    }
                    break;
                //------------#Estado 6---------------------
                case 6:
                    if (caracter[i] == 45) {
                        estado = 7;
                        lexema += caracter[i];
                    } //----Numero,letra,_-------------
                    else if ((((caracter[i] >= 48 && caracter[i] <= 57)) || ((caracter[i] >= 65 && caracter[i] <= 90))) || ((caracter[i] >= 97 && caracter[i] <= 122)) || caracter[i] == 95) {
                        estado = 6;
                        lexema += caracter[i];
                    } else {
                        num++;
                        listaTok.add(new Tokens(tipoT(lexema)));
                        tipoL(lexema);
                        
                        arregloToken.add(new Datos(num, lexema, tipoT(lexema), fila, columna));
                        lexema = "";
                        estado = 0;
                        i--;
                    }

                    break;
                //------------Estado 7---------------------
                case 7:
                    //----------Letra---------
                    if (((caracter[i] >= 65 && caracter[i] <= 90) || (caracter[i] >= 97 && caracter[i] <= 122))) {
                        estado = 11;
                        lexema += caracter[i];
                    } else {
                        numer++;
                        arregloError.add(new Datos(numer, lexema+=caracter[i], fila, columna));
                        lexema = "";
                        estado = 0;
                    }
                    break;
                //------------Estado 8---------------------
                case 8:
                    //----------Numero-----------------
                    if ((caracter[i] >= 48 && caracter[i] <= 57)) {
                        estado = 12;
                        lexema += caracter[i];
                    } else {
                        numer++;
                        arregloError.add(new Datos(numer, lexema+=caracter[i], fila, columna));
                        lexema = "";
                        estado = 0;
                    }
                    break;
                //------------#Estado 9---------------------
                case 9:
                    num++;
                    listaTok.add(new Tokens("Token_->"));
                    //lista_lexemas.add(new Lexemas(lexema));
                    arregloToken.add(new Datos(num, lexema, "Token_->", fila, columna));
                    lexema = "";
                    estado = 0;
                    i--;
                    break;
                //------------Estado 10---------------------
                case 10:
                    //----Numero,letra-------------
                    if ((caracter[i] >= 48 && caracter[i] <= 57) || ((caracter[i] >= 65 && caracter[i] <= 90) || (caracter[i] >= 97 && caracter[i] <= 122))) {
                        estado = 13;
                        lexema += caracter[i];
                    } else {
                        numer++;
                        arregloError.add(new Datos(numer, lexema+=caracter[i], fila, columna));
                        lexema = "";
                        estado = 0;
                    }
                    break;
                //------------#Estado 11---------------------
                case 11:
                    //----Numero,letra,_-------------
                    if ((((caracter[i] >= 48 && caracter[i] <= 57)) || ((caracter[i] >= 65 && caracter[i] <= 90))) || ((caracter[i] >= 97 && caracter[i] <= 122)) || caracter[i] == 95) {
                        estado = 11;
                        lexema += caracter[i];
                    } else {
                        num++;
                        listaTok.add(new Tokens( tipoT(lexema)));
                        //lista_lexemas.add(new Lexemas(lexema));
                        arregloToken.add(new Datos(num, lexema, tipoT(lexema), fila, columna));
                        lexema = "";
                        estado = 0;
                        i--;
                    }
                    break;
                //------------#Estado 12---------------------
                case 12:
                    //----------Numero
                    if ((caracter[i] >= 48 && caracter[i] <= 57)) {
                        estado = 12;
                        lexema += caracter[i];
                    } else {
                        num++;
                        listaTok.add(new Tokens("Token_Decimal"));
                        //lista_lexemas.add(new Lexemas(lexema));
                        arregloToken.add(new Datos(num, lexema, "Token_Decimal", fila, columna));
                        lexema = "";
                        estado = 0;
                        i--;
                    }

                    break;
                //------------Estado 13---------------------
                case 13:
                    //----Numero,letra,_-------------
                    if ((caracter[i] >= 48 && caracter[i] <= 57) || ((caracter[i] >= 65 && caracter[i] <= 90) || (caracter[i] >= 97 && caracter[i] <= 122)) || caracter[i] == 95) {
                        estado = 13;
                        lexema += caracter[i];
                    } else if (caracter[i] == 92) {
                        estado = 14;
                        lexema += caracter[i];
                    } else if (caracter[i] == 46) {
                        estado = 15;
                        lexema += caracter[i];
                    } else {
                        numer++;
                        arregloError.add(new Datos(numer, lexema+=caracter[i], fila, columna));
                        lexema = "";
                        estado = 0;
                    }
                    break;
                //------------Estado 14---------------------
                case 14:
                    //----Numero,letra-------------
                    if ((caracter[i] >= 48 && caracter[i] <= 57) || ((caracter[i] >= 65 && caracter[i] <= 90) || (caracter[i] >= 97 && caracter[i] <= 122))) {
                        estado = 16;
                        lexema += caracter[i];
                    } else {
                        numer++;
                        arregloError.add(new Datos(numer, lexema+=caracter[i], fila, columna));
                        lexema = "";
                        estado = 0;
                    }
                    break;
                //------------Estado 15---------------------
                case 15:
                    //---------------letra----------------------
                    if (((caracter[i] >= 65 && caracter[i] <= 90) || (caracter[i] >= 97 && caracter[i] <= 122))) {
                        estado = 17;
                        lexema += caracter[i];
                    } else {
                        numer++;
                        arregloError.add(new Datos(numer, lexema+=caracter[i], fila, columna));
                        lexema = "";
                        estado = 0;
                    }
                    break;
                //------------Estado 16---------------------
                case 16:
                    //----Numero,letra,_-------------
                    if ((caracter[i] >= 48 && caracter[i] <= 57) || ((caracter[i] >= 65 && caracter[i] <= 90) || (caracter[i] >= 97 && caracter[i] <= 122)) || caracter[i] == 95) {
                        estado = 16;
                        lexema += caracter[i];
                    } else if (caracter[i] == 92) {
                        estado = 14;
                        lexema += caracter[i];
                    } else if (caracter[i] == 46) {
                        estado = 15;
                        lexema += caracter[i];
                    } else {
                        numer++;
                        arregloError.add(new Datos(numer, lexema+=caracter[i], fila, columna));
                        lexema = "";
                        estado = 0;
                    }
                    break;
                //------------Estado 17---------------------
                case 17:
                    //-----------letra---------------------------
                    if (((caracter[i] >= 65 && caracter[i] <= 90) || (caracter[i] >= 97 && caracter[i] <= 122))) {
                        estado = 18;
                        lexema += caracter[i];
                    } else {
                        numer++;
                        arregloError.add(new Datos(numer, lexema+=caracter[i], fila, columna));
                        lexema = "";
                        estado = 0;
                    }
                    break;
                //------------Estado 18---------------------
                case 18:
                    //----Numero,letra-------------
                    if ((caracter[i] >= 48 && caracter[i] <= 57) || ((caracter[i] >= 65 && caracter[i] <= 90) || (caracter[i] >= 97 && caracter[i] <= 122))) {
                        estado = 19;
                        lexema += caracter[i];
                    } else {
                        numer++;
                        arregloError.add(new Datos(numer, lexema, fila, columna));
                        lexema = "";
                        estado = 0;
                    }
                    break;
                //------------#Estado 19---------------------
                case 19:
                    num++;
                    listaTok.add(new Tokens("Token_Ruta"));
                    //lista_lexemas.add(new Lexemas(lexema));
                    arregloToken.add(new Datos(num, lexema, "Token_Ruta", fila, columna));
                    lexema = "";
                    estado = 0;
                    i--;
                    break;
                //------------#Estado 20---------------------
                case 20:
                    num++;
                    listaTok.add(new Tokens("Token_["));
                    //lista_lexemas.add(new Lexemas(lexema));
                    arregloToken.add(new Datos(num, lexema, "Token_[", fila, columna));
                    lexema = "";
                    estado = 0;
                    i--;
                    break;
                //------------#Estado 21---------------------
                case 21:
                    num++;
                    listaTok.add(new Tokens("Token_]"));
                    //lista_lexemas.add(new Lexemas(lexema));
                    arregloToken.add(new Datos(num, lexema, "Token_]", fila, columna));
                    lexema = "";
                    estado = 0;
                    i--;
                    break;
                //------------#Estado 22---------------------
                case 22:
                    num++;
                    listaTok.add(new Tokens("Token_Comillas"));
                    //lista_lexemas.add(new Lexemas(lexema));
                    arregloToken.add(new Datos(num, lexema, "Token_Comillas", fila, columna));
                    lexema = "";
                    estado = 0;
                    i--;
                    break;
                //------------#Estado 23---------------------
                case 23:
                    num++;
                    listaTok.add(new Tokens("Token_+"));
                    //lista_lexemas.add(new Lexemas(lexema));
                    arregloToken.add(new Datos(num, lexema, "Token_+", fila, columna));
                    lexema = "";
                    estado = 0;
                    i--;
                    break;  
                 //------------#Estado 24---------------------
                case 24:
                    num++;
                    listaTok.add(new Tokens("Token_*"));
                    //lista_lexemas.add(new Lexemas(lexema));
                    arregloToken.add(new Datos(num, lexema, "Token_*", fila, columna));
                    lexema = "";
                    estado = 0;
                    i--;
                    break;
                //------------#Estado 25---------------------
                case 25:
                    num++;
                    listaTok.add(new Tokens("Token_/"));
                    //lista_lexemas.add(new Lexemas(lexema));
                    arregloToken.add(new Datos(num, lexema, "Token_/", fila, columna));
                    lexema = "";
                    estado = 0;
                    i--;
                    break;
                //------------#Estado 26---------------------
                case 26:
                    num++;
                    listaTok.add(new Tokens("Token_#"));
                    //lista_lexemas.add(new Lexemas(lexema));
                    arregloToken.add(new Datos(num, lexema, "Token_#", fila, columna));
                    lexema = "";
                    estado = 0;
                    i--;
                    break;      
                //------------Estado error---------------------
               /** case 100:
                    numer++;
                    arregloError.add(new Datos(numer, lexema, fila, columna));
                    lexema = "";
                    estado = 0;

                    break;
                **/
            }
            //---------FIN ANALISIS-----------------------
        }
        //------------FIN LOOP----------------------
        num=0;
        fila=1;
        columna=-1;
        listaTok.add(new Tokens("Fin"));
    }

    //--------Metodo Para Reconocer Tokens----------------------------
    public String tipoT(String lexema) {
        String tipo_token;
        String lexem=lexema.toLowerCase();
        switch (lexem) {
            case "configuracion":
                tipo_token = "Token_Configuracion";
                break;
            
            case "juego":
                tipo_token = "Token_Juego";
                break;
            
            case "nivel":
                tipo_token = "Token_Nivel";
                break;
            
            case "facil":
                tipo_token = "Token_Facil";
                break;
            
            case "intermedio":
                tipo_token = "Token_Intermedio";
                break;
            
            case "dificil":
                tipo_token = "Token_Dificil";
                break;
            
            case "tiempo":
                tipo_token = "Token_Tiempo";
                break;
            
            case "usuarios":
                tipo_token = "Token_Usuarios";
                break;
            
            case "nombre":
                tipo_token = "Token_Nombre";
                break;
            
            case "sonido":
                tipo_token = "Token_Sonido";
                break;
            
            case "track_1":
                tipo_token = "Token_Track";
                break;
            
            case "track_2":
                tipo_token = "Token_Track";
                break;
            
            case "track_3":
                tipo_token = "Token_Track";
                break;
            
            case "imagen":
                tipo_token = "Token_Imagen";
                break;
            
            case "idioma":
                tipo_token = "Token_Idioma";
                break;
            
            case "palabra":
                tipo_token = "Token_Palabra";
                break;
            
            case "carta":
                tipo_token = "Token_Carta";
                break;
            
            case "end-configuracion":
                tipo_token = "Token_End-Configuracion";
                break;
            
            case "end-nivel":
                tipo_token = "Token_End-Nivel";
                break;
            
            case "end-tiempo":
                tipo_token = "Token_End-Tiempo";
                break;
            
            case "end-juego":
                tipo_token = "Token_End-Juego";
                break;
            
            case "end-usuarios":
                tipo_token = "Token_End-Usuarios";
                break;
            
            case "end-sonido":
                tipo_token = "Token_End-Sonido";
                break;
            
            case "end-carta":
                tipo_token = "Token_End-Carta";
                break;
            
            default:
                tipo_token = "Token_Id";
                
                break;
        }
        return tipo_token;
    }
    
    
    //--------Metodo Para Reconocer Tokens----------------------------
    public String tipoL(String lexema) {
        String tipo_token="";
        String lexem=lexema.toLowerCase();
        switch (lexem) {
            case "configuracion":
                //tipo_token = "Token_Configuracion";
                break;
            
            case "juego":
                //tipo_token = "Token_Juego";
                break;
            
            case "nivel":
                //tipo_token = "Token_Nivel";
                break;
            
            case "facil":
                lista_niveles.add(new Niveles(lexema));
                //tipo_token = "Token_Facil";
                break;
            
            case "intermedio":
                lista_niveles.add(new Niveles(lexema));
                //tipo_token = "Token_Intermedio";
                break;
            
            case "dificil":
                lista_niveles.add(new Niveles(lexema));
                //tipo_token = "Token_Dificil";
                break;
            
            case "tiempo":
                //tipo_token = "Token_Tiempo";
                break;
            
            case "usuarios":
                //tipo_token = "Token_Usuarios";
                break;
            
            case "nombre":
                //tipo_token = "Token_Nombre";
                break;
            
            case "sonido":
                //tipo_token = "Token_Sonido";
                break;
            
            case "track_1":
                //tipo_token = "Token_Track";
                break;
            
            case "track_2":
                //tipo_token = "Token_Track";
                break;
            
            case "track_3":
                //tipo_token = "Token_Track";
                break;
            
            case "imagen":
                //tipo_token = "Token_Imagen";
                break;
            
            case "idioma":
                //tipo_token = "Token_Idioma";
                break;
            
            case "palabra":
                //tipo_token = "Token_Palabra";
                break;
            
            case "carta":
                //tipo_token = "Token_Carta";
                break;
            
            case "end-configuracion":
                //tipo_token = "Token_End-Configuracion";
                break;
            
            case "end-nivel":
                //tipo_token = "Token_End-Nivel";
                break;
            
            case "end-tiempo":
                //tipo_token = "Token_End-Tiempo";
                break;
            
            case "end-juego":
                //tipo_token = "Token_End-Juego";
                break;
            
            case "end-usuarios":
                //tipo_token = "Token_End-Usuarios";
                break;
            
            case "end-sonido":
                //tipo_token = "Token_End-Sonido";
                break;
            
            case "end-carta":
                //tipo_token = "Token_End-Carta";
                break;
            case "ingles":
                lista_idiomas.add(new Idiomas(lexema));
                //tipo_token = "ingles";
                break;    
            case "aleman":
                lista_idiomas.add(new Idiomas(lexema));
                //tipo_token = "ingles";
                break;
                case "frances":
                    lista_idiomas.add(new Idiomas(lexema));
                //tipo_token = "ingles";
                break;
                case "italiano":
                    lista_idiomas.add(new Idiomas(lexema));
                //tipo_token = "ingles";
                break;
                case "espanol":
                    lista_idiomas.add(new Idiomas(lexema));
                //tipo_token = "ingles";
                break;
                case "japones":
                    lista_idiomas.add(new Idiomas(lexema));
                //tipo_token = "ingles";
                break;
                case "portugues":
                    lista_idiomas.add(new Idiomas(lexema));
                //tipo_token = "ingles";
                break;
                case "irlandes":
                    lista_idiomas.add(new Idiomas(lexema));
                //tipo_token = "ingles";
                break;
                case "[":
                //tipo_token = "ingles";
                break;
                case "]":
                //tipo_token = "ingles";
                break;
                case "carta_1":
                //tipo_token = "ingles";
                break;
                case "carta_2":
                //tipo_token = "ingles";
                break;
                case "carta_3":
                //tipo_token = "ingles";
                break;
                case "carta_4":
                //tipo_token = "ingles";
                break;
                case "carta_5":
                //tipo_token = "ingles";
                break;
                case "carta_6":
                //tipo_token = "ingles";
                break;
                case "carta_7":
                //tipo_token = "ingles";
                break;
                case "carta_8":
                //tipo_token = "ingles";
                break;
                case "carta_9":
                //tipo_token = "ingles";
                break;
                case "carta_10":
                //tipo_token = "ingles";
                break;
                case "pantalon":
                case "ball":
                case "ballon":
                case "orange":
                case "naranja":
                case "guitar":
                case "gitarre":
                case "guitare":
                case "pants":
                case "hosen":
                case "pelota":
                case "guitarra":
                  
                
                //tipo_token = "ingles";
                
                //tipo_token = "ingles";
                break;
                
            default:
                tipo_token="id";
                lista_lexemas.add(new Lexemas(lexema));
                break;
        }
        return tipo_token;
    }

}
