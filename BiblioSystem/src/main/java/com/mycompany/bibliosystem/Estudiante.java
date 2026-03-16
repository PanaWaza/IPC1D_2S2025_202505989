/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bibliosystem;

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
        static Estudiante[] estudiante = new Estudiante [100];
        public static int ContadorEstudiante = 0;
        
        public Estudiante(int rol,String nombre, int carnet,String contraseña,String carrera,int prestamosActivos,int prestamosVencidos) {
            this.rol = rol;
            this.nombre=nombre;
            this.carnet= carnet;
            this.contraseña = contraseña;
            this.carrera= carrera;
            this.prestamosActivos= prestamosActivos;
            this.prestamosVencidos = prestamosVencidos;
        }
        
        // sobrecarcar el constructor con otra plantilla 
        public Estudiante (String nombre, int carnet, int prestamosActivos){
            this.nombre = nombre;
            this.carnet= carnet;
            this.prestamosActivos = prestamosActivos;
        }
        
    public static Object[][] TresDatosEstudiante() {
    
    Object[][] matriz = new Object[ContadorEstudiante][3]; 
    
    for (int i = 0; i < ContadorEstudiante; i++) {
        if (estudiante[i] != null) {
            matriz[i][0] = estudiante[i].nombre;
            matriz[i][1] = estudiante[i].carnet;
            matriz[i][2] = estudiante[i].prestamosActivos;
        }
    }
    return matriz;
}

        //  almacenamientos de estudiantes 
        public static void saveStudent (int rol,String nombre, int carnet,String contraseña,String carrera,int prestamosActivos,int prestamosVencidos){
           Estudiante nuevoEstudiante = new Estudiante(rol,nombre, carnet,contraseña,carrera, prestamosActivos, prestamosVencidos);
           estudiante[ContadorEstudiante] = nuevoEstudiante;
           ContadorEstudiante ++;
       }

    
    // evaluar datos registro (ventana dos paquete Ventanas)
        // si guardar es verdadero se guarda el estudiante
   public static boolean DatosRegistro(String name, int id, String password,String carrera, boolean guardar){
       // buscar si ya exite el carnet
       for (int i = 0; i < ContadorEstudiante; i++) { 
            if (estudiante[i].carnet == id) {
                return true; // el carnet ya existe 
            }
        }
       if (guardar == true) {
           saveStudent(1,name,id,password,carrera,0,0);
       }
       return false; // el carnet no existe
   }
    
   public static String getName(int id) {
    // Recorremos solo hasta el número real de estudiantes guardados
    for (int i = 0; i < ContadorEstudiante; i++) {
        // Accedemos a la posición i del arreglo
        if (estudiante[i].carnet == id) {
            return estudiante[i].nombre; // Retornamos apenas lo encontramos
        }
    }
    return ""; // O un mensaje que indique que no existe
}
   
   public static Object[] obtenerDatos(int carnet){
       
       Object[] datos = new Object[6];
       for (int i = 0; i < ContadorEstudiante; i++) {
           if (estudiante[i].carnet == carnet) {
               
               datos[0] = estudiante[i].nombre;
               datos[1] = estudiante[i].carnet;
               datos[2] = estudiante[i].contraseña;
               datos[3] = estudiante[i].carrera;
               datos[4] = estudiante[i].prestamosActivos;
               datos[5] = estudiante[i].prestamosVencidos;
           }
       }
       return datos ;
   }
   
   public static  void eliminarRegistro(int fila) {
    // 1. Validamos que la fila sea válida y que el contador sea mayor a 0
    if (fila >= 0 && fila < ContadorEstudiante) {
        
        // 2. Realizamos el desplazamiento (Shift) para cerrar el hueco
        for (int i = fila; i < ContadorEstudiante - 1; i++) {
            estudiante[i] = estudiante[i + 1];
        }
        
        // 3. Limpiamos la última posición original (la que quedó duplicada)
        estudiante[ContadorEstudiante - 1] = null;
        
        // 4. Reducimos el contador de objetos reales en memoria
        ContadorEstudiante--;
       
        
        System.out.println("Registro eliminado ");
    } else {
        System.out.println("Error: No has seleccionado una fila válida.");
    }
}
    
    /*
    Listar todos los estudiantes registrados con su estado actual. 
    */
    
    
    /*
    Eliminar el registro de un estudiante, siempre que no tenga préstamos activos o vencidos 
pendientes.
    */
    
}
