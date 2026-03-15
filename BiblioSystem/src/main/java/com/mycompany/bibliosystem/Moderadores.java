/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bibliosystem;
import java.util.ArrayList;

/**
 *
 * @author Pana_Waza
 */
public class Moderadores {
    int rol;
    String nombre;
    String contraseña;
    int carnet;
    static ArrayList <Moderadores>ListaModeradores = new ArrayList <>();
    
    Moderadores(int rol,String nombre,String contraseña,int carnet){
        this.rol=rol;
        this.nombre= nombre;
        this.contraseña=contraseña;
        this.carnet=carnet;
    }
    
    static void saveModeradores(int rol ,String name, String password,int carnet){
        Moderadores accesoModerador = new Moderadores(rol,name,password,carnet);
        ListaModeradores.add(accesoModerador);
    }
    
    public static String getName(int carnet, String password){
        String nombre = "";
        for (Moderadores ListaModeradore : ListaModeradores) {
            if (ListaModeradore.carnet == carnet && ListaModeradore.contraseña.equals(password)) {
                nombre = ListaModeradore.nombre;
            }
        }
        return nombre;
    }
    
}
