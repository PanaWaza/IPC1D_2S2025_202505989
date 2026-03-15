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
public class Estudiante {
    int rol;
    String nombre;
    int carnet;
    String contraseña;
    String carrera;
    int prestamosActivos = 0;
    int prestamosVencidos = 0;
    
    // gloval
    static ArrayList <Estudiante>estudiante =new ArrayList<>();

    // constructor estudiante 5 parametros
    public Estudiante(int rol,String nombre, int carnet,String contraseña,String carrera,int prestamosActivos,int prestamosVencidos) {
        this.rol = rol;
        this.nombre=nombre;
        this.carnet= carnet;
        this.contraseña = contraseña;
        this.carrera= carrera;
        this.prestamosActivos= prestamosActivos;
        this.prestamosVencidos = prestamosVencidos;
    }
    
    //  almacenamientos de estudiantes 
    static void saveStudent (int rol,String nombre, int carnet,String contraseña,String carrera,int prestamosActivos,int prestamosVencidos){
       Estudiante nuevoEstudiante = new Estudiante(rol,nombre, carnet,contraseña,carrera, prestamosActivos, prestamosVencidos);
       estudiante.add(nuevoEstudiante);
   }

    
    // evaluar datos registro (ventana dos paquete Ventanas)
   public static boolean DatosRegistro(String name, int id, String password,String carrera, boolean guardar){
       // buscar si ya exite el carnet
       for (Estudiante estudiante1 : estudiante) {
           if (estudiante1.carnet == id) {
               return true;
           }
       }
       if (guardar == true) {
           saveStudent(1,name,id,password,carrera,0,0);
       }
       return false;
   }
    
   public static String getName(int id){
       String name = "";
       for (Estudiante estudiante1 : estudiante) {
           if (estudiante1.carnet ==  id ) {
              name = estudiante1.nombre; 
           }
       } 
       return name;
   }
   
    
    /*
    Listar todos los estudiantes registrados con su estado actual. 
    */
    
    
    /*
    Eliminar el registro de un estudiante, siempre que no tenga préstamos activos o vencidos 
pendientes.
    */
    
}
