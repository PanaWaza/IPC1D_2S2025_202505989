/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bibliosystem;


/**
 *
 * @author Pana_Waza
 */
public class Moderadores {
    int rol;
    String nombre;
    String contraseña;
    int carnet;
    // static ArrayList <Moderadores>ListaModeradores = new ArrayList <>();
    static Moderadores[] ListaModeradores = new Moderadores[10];
    public static int ContadorModeradores = 0;
    
    Moderadores(int rol,String nombre,String contraseña,int carnet){
        this.rol=rol;
        this.nombre= nombre;
        this.contraseña=contraseña;
        this.carnet=carnet;
    }
    
    static void saveModeradores(int rol ,String name, String password,int carnet){
        Moderadores accesoModerador = new Moderadores(rol,name,password,carnet);
        ListaModeradores[ContadorModeradores] = accesoModerador;
        ContadorModeradores ++ ;
    }
    
    public static String getName(int carnet, String password) {
    // Recorremos solo las posiciones que sabemos que tienen datos
    for (int i = 0; i < ContadorModeradores; i++) {
        // Accedemos a la posición i
        if (ListaModeradores[i].carnet == carnet && ListaModeradores[i].contraseña.equals(password)) {
            // Retornamos el nombre inmediatamente si encontramos coincidencia
            return ListaModeradores[i].nombre; 
        }
    }
    // Si terminamos el ciclo y no encontramos nada, devolvemos una cadena vacía
    return ""; 
}
    
}
