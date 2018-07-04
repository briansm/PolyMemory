
package memoria;

import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Reportes {
    String html=" ";
    //------Declaracion de listas-----------------------
    ArrayList<Datos>list;
    ArrayList<Datos>lise;
    ArrayList<Datos>lisS;
    Crear_Reporte crearR=new Crear_Reporte();
    
    //---------Metodo para Reporte Tokens---------------
    public void CrearRT(ArrayList lista){
        list=lista;
        
        //------------------HTML-----------------------------------------------  
             html = "<html>\n"
                 +"<head>\n"
                +"<style type=\"text/css\">\n" //_____________________________style de css__________________________________________
                +"table {\n" +
                "	font-family: verdana,arial,sans-serif;\n" +
                "	font-size:11px;\n" +
                "	color:#333333;\n" +
                "	border-width: 1px;\n" +
                "	border-color: #666666;\n" +
                "	border-collapse: collapse;\n" +
                "	width: 100%;\n" +
                "}\n"
                +" th {\n" +
                "	border-width: 1px;\n" +
                "	padding: 8px;\n" +
                "	border-style: solid;\n" +
                "	background-color: #1DFF50;\n" +
                "	color: white;\n" +
                "}\n" +
                " td {\n" +
                "	border-width: 1px;\n" +
                "	padding: 8px;\n" +
                "	border-style: solid;\n" +
                "	border-color: #666666;\n" +
                "	background-color: #ffffff;\n" +
                "}\n" +
                " tr:nth-child(even){background-color: #f2f2f2}\n"
                +"</style>\n"
                +"<meta charset=\"UTF-8\">\n"
                +"<title>Reporte tokens</title>\n"
                +"</head\n>"
                +"<body background=\"\\Imagenes\\r2.jpg\">"
                +"<font color=\"Olive\" face=\"Comic Sans MS,arial\">"
                +"<h3>Lista de tokens</h3>"
                +"</font>"
                +"<table>\n"
                +"<tr>\n"
                    +"<th>No.</th>\n"
                    +"<th>Lexema</th>\n"
                    +"<th>Componente léxico</th>\n"
                    +"<th>Fila</th>\n"
                    +"<th>Columna</th>\n"
                +"</tr>\n";
        
            if(list!= null){
                System.out.println("456789878787897878976787678767876");
                }
            //------------LLENAR LA TABLA----------------------------
                for(int i=0;i<list.size();i++) {
                    html+="<tr>\n"
                            +"<td>"+((Datos)list.get(i)).getNumero()+"</td>\n"
                            +"<td>"+((Datos)list.get(i)).getLexi()+"</td>\n"
                            +"<td>"+((Datos)list.get(i)).getToken()+"</td>\n"
                            +"<td>"+((Datos)list.get(i)).getFila()+"</td>\n"
                            +"<td>"+((Datos)list.get(i)).getColum()+"</td>\n"
                        +"</tr>\n";
//                    System.out.println(html);
                }
            //----------------------FIN FOR----------------------------    
             html+="</table>\n "
                + "</body>\n "
                + "</html>";    
            //---------------------FIN HTML-----------------------------------------
      //------Falta generar archivo------     
            crearR.guardarReporte(html, "Simbolos");
            list.clear();
            
            
    }
    //-------------------------------Metodo para reporte errores---------------------
    public void CrearRE(ArrayList lista){
        lise = lista;
        String html1 = "<html>\n"
                 +"<head>\n"
                +"<style type=\"text/css\">\n" //_____________________________style de css__________________________________________
                +"table {\n" +
                "	font-family: verdana,arial,sans-serif;\n" +
                "	font-size:11px;\n" +
                "	color:#333333;\n" +
                "	border-width: 1px;\n" +
                "	border-color: #666666;\n" +
                "	border-collapse: collapse;\n" +
                "	width: 100%;\n" +
                "}\n"
                +" th {\n" +
                "	border-width: 1px;\n" +
                "	padding: 8px;\n" +
                "	border-style: solid;\n" +
                "	background-color: #1DFF50;\n" +
                "	color: white;\n" +
                "}\n" +
                " td {\n" +
                "	border-width: 1px;\n" +
                "	padding: 8px;\n" +
                "	border-style: solid;\n" +
                "	border-color: #666666;\n" +
                "	background-color: #ffffff;\n" +
                "}\n" +
                " tr:nth-child(even){background-color: #f2f2f2}\n"
                +"</style>\n"
                +"<meta charset=\"UTF-8\">\n"
                +"<title>Reporte errores</title>\n"
                +"</head\n>"
                +"<body background=\"\\Imagenes\\r2.jpg\">"
                +"<font color=\"Olive\" face=\"Comic Sans MS,arial\">"
                +"<h3>Lista de errores</h3>"
                +"</font>"
                +"<table>\n"
                +"<tr>\n"
                    +"<th>No.</th>\n"
                    +"<th>Lexema</th>\n"
                    +"<th>Fila</th>\n"
                    +"<th>Columna</th>\n"
                    +"<th>Error</th>\n"
                +"</tr>\n";
                
            if(lise!= null){
                System.out.println("456789878787897878976787678767876");
            }
                for(int i=0;i<lise.size();i++) {
                    html1+="<tr>\n"
                            +"<td>"+(i+1)+"</td>\n"
                            +"<td>"+((Datos)lise.get(i)).getError()+"</td>\n"
                            +"<td>"+((Datos)lise.get(i)).getFila()+"</td>\n"
                            +"<td>"+((Datos)lise.get(i)).getColum()+"</td>\n"
                            +"<td>"+((Datos)lise.get(i)).getTerror()+"</td>\n"
                        +"</tr>\n";
                }
            //----------------------FIN FOR----------------------------      
            html1+="</table>\n "
                + "</body>\n "
                + "</html>";
           //---------------------FIN HTML-----------------------------------------
      //------Falta generar archivo------  
           crearR.guardarReporte(html1, "Error");
           lise.clear();
    }
    
    //-------------------------------Metodo para reporte errores Sintacticos---------------------
    public void CrearRES(ArrayList lista){
        lisS = lista;
        String html2 = "<html>\n"
                 +"<head>\n"
                +"<style type=\"text/css\">\n" //_____________________________style de css__________________________________________
                +"table {\n" +
                "	font-family: verdana,arial,sans-serif;\n" +
                "	font-size:11px;\n" +
                "	color:#333333;\n" +
                "	border-width: 1px;\n" +
                "	border-color: #666666;\n" +
                "	border-collapse: collapse;\n" +
                "	width: 100%;\n" +
                "}\n"
                +" th {\n" +
                "	border-width: 1px;\n" +
                "	padding: 8px;\n" +
                "	border-style: solid;\n" +
                "	background-color: #1DFF50;\n" +
                "	color: white;\n" +
                "}\n" +
                " td {\n" +
                "	border-width: 1px;\n" +
                "	padding: 8px;\n" +
                "	border-style: solid;\n" +
                "	border-color: #666666;\n" +
                "	background-color: #ffffff;\n" +
                "}\n" +
                " tr:nth-child(even){background-color: #f2f2f2}\n"
                +"</style>\n"
                +"<meta charset=\"UTF-8\">\n"
                +"<title>Reporte errores</title>\n"
                +"</head\n>"
                +"<body background=\"\\Imagenes\\r2.jpg\">"
                +"<font color=\"Olive\" face=\"Comic Sans MS,arial\">"
                +"<h3>Lista de errores</h3>"
                +"</font>"
                +"<table>\n"
                +"<tr>\n"
                    +"<th>No.</th>\n"
                    +"<th>Lexema</th>\n"
                    +"<th>Fila</th>\n"
                    +"<th>Columna</th>\n"
                    +"<th>Error</th>\n"
                    +"<th>Descripcion</th>\n"
                +"</tr>\n";
                
            if(lisS!= null){
                System.out.println("456789878787897878976787678767876");
            }
                for(int i=0;i<lisS.size();i++) {
                    html2+="<tr>\n"
                            +"<td>"+(i+1)+"</td>\n"
                            +"<td>"+((Datos)lisS.get(i)).getTerm()+"</td>\n"
                            +"<td>"+(i+15)+"</td>\n"
                            +"<td>"+(i+25)+"</td>\n"
                            +"<td>"+((Datos)lisS.get(i)).getSerror()+"</td>\n"
                            +"<td>"+((Datos)lisS.get(i)).getDesc()+"</td>\n"
                        +"</tr>\n";
                }
            //----------------------FIN FOR----------------------------      
            html2+="</table>\n "
                + "</body>\n "
                + "</html>";
           //---------------------FIN HTML-----------------------------------------
      //------Falta generar archivo------  
           crearR.guardarReporte(html2, "Sintactico");
           lisS.clear();
    }
    
}
