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
                    } else if (caracter[i] == 42 || caracter[i] == 43 || caracter[i] == 47) {
                        estado = 4;
                        lexema += caracter[i];
                    } else if (caracter[i] == 91) {
                        estado = 20;
                        lexema += caracter[i];
                    } else if (caracter[i] == 93) {
                        estado = 21;
                        lexema += caracter[i];
                    } else if (caracter[i] == 34) {
                        estado = 4;
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
                        arregloToken.add(new Datos(num, lexema, "Token_Simbolo", fila, columna));
                        lexema = "";
                        estado = 0;
                        i--;
                    }

                    break;
                //------------#Estado 4---------------------
                case 4:
                    num++;
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
                        arregloToken.add(new Datos(num, lexema, "Token_Digito", fila, columna));
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
                    arregloToken.add(new Datos(num, lexema, "Token_Ruta", fila, columna));
                    lexema = "";
                    estado = 0;
                    i--;
                    break;
                //------------#Estado 20---------------------
                case 20:
                    num++;
                    arregloToken.add(new Datos(num, lexema, "Token_[", fila, columna));
                    lexema = "";
                    estado = 0;
                    i--;
                    break;
                //------------#Estado 19---------------------
                case 21:
                    num++;
                    arregloToken.add(new Datos(num, lexema, "Token_]", fila, columna));
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
    }

    //--------Metodo Para Reconocer Tokens----------------------------
    public String tipoT(String lexema) {
        String tipo_token = " ";

        if ((lexema.equals("Configuracion")) || (lexema.equals("configuracion"))) {
            tipo_token = "Token_Configuracion";
        } else if ((lexema.equals("Juego")) || (lexema.equals("juego"))) {
            tipo_token = "Token_Juego";
        } else if ((lexema.equals("Nivel")) || (lexema.equals("nivel"))) {
            tipo_token = "Token_Nivel";
        } else if ((lexema.equals("Facil")) || (lexema.equals("facil"))) {
            tipo_token = "Token_Facil";
        } else if ((lexema.equals("Intermedio")) || (lexema.equals("intermedio"))) {
            tipo_token = "Token_Intermedio";
        } else if ((lexema.equals("Dificil")) || (lexema.equals("dificil"))) {
            tipo_token = "Token_Dificil";
        } else if ((lexema.equals("Tiempo")) || (lexema.equals("Tiempo"))) {
            tipo_token = "Token_Tiempo";
        } else if ((lexema.equals("Usuarios")) || (lexema.equals("usuarios"))) {
            tipo_token = "Token_Usuarios";
        } else if ((lexema.equals("Nombre")) || (lexema.equals("nombre"))) {
            tipo_token = "Token_Nombre";
        } else if ((lexema.equals("Sonido")) || (lexema.equals("sonido"))) {
            tipo_token = "Token_Sonido";
        } else if ((lexema.equals("Track_1")) || (lexema.equals("track_1"))) {
            tipo_token = "Token_Track";
        } else if ((lexema.equals("Track_2")) || (lexema.equals("track_2"))) {
            tipo_token = "Token_Track";
        } else if ((lexema.equals("Track_3")) || (lexema.equals("track_3"))) {
            tipo_token = "Token_Track";
        } else if ((lexema.equals("Imagen")) || (lexema.equals("imagen"))) {
            tipo_token = "Token_Imagen";
        } else if ((lexema.equals("Idioma")) || (lexema.equals("idioma"))) {
            tipo_token = "Token_Idioma";
        } else if ((lexema.equals("Palabra")) || (lexema.equals("palabra"))) {
            tipo_token = "Token_Palabra";
        } else if ((lexema.equals("Carta")) || (lexema.equals("carta"))) {
            tipo_token = "Token_Carta";
        } else if ((lexema.equals("End-Configuracion")) || (lexema.equals("end-configuracion"))) {
            tipo_token = "Token_End-Configuracion";
        } else if ((lexema.equals("End-Nivel")) || (lexema.equals("end-nivel"))) {
            tipo_token = "Token_End-Nivel";
        } else if ((lexema.equals("End-Tiempo")) || (lexema.equals("end-tiempo"))) {
            tipo_token = "Token_End-Tiempo";
        } else if ((lexema.equals("End-Juego")) || (lexema.equals("end-juego"))) {
            tipo_token = "Token_End-Juego";
        } else if ((lexema.equals("End-Usuarios")) || (lexema.equals("end-usuarios"))) {
            tipo_token = "Token_End-Usuarios";
        } else if ((lexema.equals("End-Sonido")) || (lexema.equals("end-sonido"))) {
            tipo_token = "Token_End-Sonido";
        } else if ((lexema.equals("End-Carta")) || (lexema.equals("end-carta"))) {
            tipo_token = "Token_End-Carta";
        } else if (lexema == "->") {
            tipo_token = "Token_->";
        } else {
            tipo_token = "Token_Id";
        }
        return tipo_token;
    }

}
