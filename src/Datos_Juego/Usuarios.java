/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos_Juego;

import java.util.ArrayList;


public class Usuarios {
    
     public static ArrayList<String> arregloUsuarios = new ArrayList<String>();

    public ArrayList<String> getsuarios() {
        return arregloUsuarios;
    }

    public void setArregloErrores(ArrayList<String> arregloUsuarios) {
        this.arregloUsuarios = arregloUsuarios;
    }
}
