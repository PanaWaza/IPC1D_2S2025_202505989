/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bibliosystem;

import static com.mycompany.bibliosystem.Estudiante.ContadorEstudiante;
import static com.mycompany.bibliosystem.Estudiante.estudiante;
import static com.mycompany.bibliosystem.Estudiante.saveStudent;
import java.time.LocalDate;


/**
 *
 * @author Pana_Waza
 */

public class Libro {

    /**
     * @return the IBN
     */
    public String getIBN() {
        return IBN;
    }

    /**
     * @param IBN the IBN to set
     */
    public void setIBN(String IBN) {
        this.IBN = IBN;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the autor
     */
    public String getAutor() {
        return autor;
    }

    /**
     * @param autor the autor to set
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * @return the genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * @return the publishYear
     */
    public String getPublishYear() {
        return publishYear;
    }

    /**
     * @param publishYear the publishYear to set
     */
    public void setPublishYear(String publishYear) {
        this.publishYear = publishYear;
    }

    /**
     * @return the ejemplares
     */
    public int getEjemplares() {
        return ejemplares;
    }

    /**
     * @param ejemplares the ejemplares to set
     */
    public void setEjemplares(int ejemplares) {
        this.ejemplares = ejemplares;
    }
    public String IBN;
    public String titulo;
    public String autor;
    public String genero;
    public String publishYear;
    public int ejemplares=0;
    
    // gloval     
    //public static ArrayList <Libro> libros = new ArrayList<>();
    public static Libro[] libros =  new Libro [100];
    public static int ContadorLibros = 0;
    
    // constructor de objeto libro con 6 parametros
    public Libro(String titulo,String autor,String genero,String publisYear,int ejemplares, String IBN) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.publishYear = publisYear;
        this.ejemplares = ejemplares;
        this.IBN = IBN;
    }
    
    //  almacenamientos de libros 
  
   public static void saveBooks (String title,String autor,String genero,String publisYear,int ejemplares,String ibn){
       Libro nuevoLibro = new Libro(title,autor,genero,publisYear,ejemplares,ibn);
       libros[ContadorLibros] = nuevoLibro ;
       ContadorLibros ++;
   }
    
   // buscar si hay suficientes ejemplares disponibles (mas de 1 para hacer prestamo)
   public static boolean ejemp(String ibn){
       for (int i = 0; i < ContadorLibros; i++) {
           if (libros[i].IBN.trim().equals(ibn.trim()) && libros[i].ejemplares >= 1) {
              return true; 
           }
       }
       return false;
   }
   
   public static String getBookName(String ibn) {
    // Usamos el contador (limitador) para evitar errores con posiciones nulas
    for (int i = 0; i < ContadorLibros; i++) {
        // Validación de null por seguridad, aunque el contador ya ayuda
        if (libros[i] != null && libros[i].IBN.trim().equals(ibn.trim())) {
            return libros[i].titulo; // Retornamos directo
        }
    }
    
    return ""; // Retornamos vacío si no se encontró coincidencia
}

   
   public static String getDatePrestamo(){
       
       LocalDate fecha = LocalDate.now();
       String FechaPrestamo = fecha.toString();
       return FechaPrestamo;
   }
   
   // sumarle una semana a la fecha
   public static String SumaFecha(String fechaPrestamo){
       
       LocalDate date = LocalDate.parse(fechaPrestamo);
       date = date.plusDays(15);
       
       String Sdate = date.toString();
       
       return Sdate;
   }
   
   public static void SumaEjemplares(String ibn){
       for (int i = 0; i < ContadorLibros; i++) {
           if (libros[i].IBN.trim().equals(ibn.trim())) {
               libros[i].ejemplares++;
               return;
           }
       }
   }
   
   
   public static void RestaEjemplares(String ibn){
       for (int i = 0; i < ContadorLibros; i++) {
           if (libros[i].IBN.trim().equals(ibn.trim())) {
               libros[i].ejemplares--;
               return;
           }
       }
   }
   
   
   
   public static Object[] foundIbn(String ibn){
       Object[] fila = new Object [5];
       for (int i = 0; i < ContadorLibros; i++) {
           if (libros[i].IBN.trim().equals(ibn.trim())) {
               fila[0] = libros[i].titulo;
               fila[1] = libros[i].autor;
               fila[2] = libros[i].genero;
               fila[3] = libros[i].publishYear;
               fila[4] = libros[i].ejemplares;
               return fila;
           }
       }
       return fila;
   }
   
   public static Object [][] foundTitulo(String busqueda){
       Object[][] Matriz = new Object [100][5];
       int accesoTabla = 0;
       for (int i = 0; i < ContadorLibros; i++) {
           
           if (!(libros[i]==null)) {
                String acceso = libros[i].titulo.toLowerCase();
                busqueda = busqueda.toLowerCase().trim();
           
                if (acceso.trim().contains(busqueda)) {
                    Matriz[accesoTabla][0] = libros[i].titulo;
                    Matriz[accesoTabla][1] = libros[i].autor;
                    Matriz[accesoTabla][2] = libros[i].genero;
                    Matriz[accesoTabla][3] = libros[i].publishYear;
                    Matriz[accesoTabla][4] = libros[i].ejemplares;
                    accesoTabla++;
                }
            }
        }
           
       return Matriz;
   }
   
   
   public static Object [][] foundAutor(String busqueda){
       Object[][] Matriz = new Object [100][5];
       int accesoTabla = 0;
       for (int i = 0; i < ContadorLibros; i++) {
           
           if(!(libros[i] == null)){
               // trabajar todo en minusculas
                String acceso = libros[i].autor.toLowerCase();
                busqueda = busqueda.toLowerCase(); 
           
                if (acceso.trim().contains(busqueda.trim())) {
                    Matriz[accesoTabla][0] = libros[i].titulo;
                    Matriz[accesoTabla][1] = libros[i].autor;
                    Matriz[accesoTabla][2] = libros[i].genero;
                    Matriz[accesoTabla][3] = libros[i].publishYear;
                    Matriz[accesoTabla][4] = libros[i].ejemplares;
                    accesoTabla++;
                }
           }
       }
       return Matriz;
   }
   
   
   
   public static boolean DatosRegistro(String name, String id, String autor,String genero, String añoP, int Ejemplares, boolean guardar){
       // buscar si ya exite el carnet
       for (int i = 0; i < ContadorLibros; i++) { 
            if (libros[i].IBN.trim().equals(id.trim())) {
                libros[i].ejemplares = libros[i].ejemplares + Ejemplares; // aumentar los ejemplares del libro
                return true; // el libro ya existe
            }
        }
       if (guardar == true) {
           saveBooks(name,autor,genero,añoP,Ejemplares,id);
       }
       return false; // el libro no existe
   }
   
   public static Object[][] TresDatosLibro() {
    
    Object[][] matriz = new Object[ContadorLibros][5]; 
    
    for (int i = 0; i < ContadorLibros; i++) {
        if (libros[i] != null) {
            matriz[i][0] = libros[i].titulo;
            matriz[i][1] = libros[i].IBN;
            matriz[i][2] = libros[i].autor;
            matriz[i][3] = libros[i].publishYear;
            matriz[i][4] = libros[i].ejemplares;
            
        }
    }
    return matriz;
}
   
public static  void eliminarRegistro(int fila, int eliminados) {
    // 1. Validamos que la fila sea válida y que el contador sea mayor a 0
    if (fila >= 0 && fila < ContadorLibros) {
        
        if (true) {
            
        }
        
        if (libros[fila].ejemplares > eliminados) {
            libros[fila].ejemplares = libros[fila].ejemplares -eliminados;
        }
        else{
            // 2. Realizamos el desplazamiento (Shift) para cerrar el hueco
            for (int i = fila; i < ContadorLibros - 1; i++) {
                libros[i] = libros[i + 1];
            }
        
            // 3. Limpiamos la última posición original (la que quedó duplicada)
            estudiante[ContadorLibros - 1] = null;
        
            // 4. Reducimos el contador de objetos reales en memoria
            ContadorLibros--;
        }
        
        System.out.println("Registro libro eliminado ");
    } else {
        System.out.println("Error: No has seleccionado una fila válida.");
    }
}


   

    /*
    Permite buscar un libro por código interno o ISBN y modificar sus datos, excepto el 
código interno. La cantidad total de ejemplares puede modificarse siempre que el nuevo 
valor no sea menor a la cantidad actualmente prestada. 
    */
    
    
    
    /*
    Solo se puede eliminar un libro si no tiene préstamos activos. Si los tiene, el sistema 
muestra cuántos hay y rechaza la operación. 
    */
    
    
    
    /*
    El sistema ofrece búsqueda por ISBN (exacta), por título (parcial) y por autor (parcial). Los 
resultados se muestran en una tabla dentro de la interfaz. También existe la opción de 
listar todos los libros del catálogo con su disponibilidad actual. 
    */
    
    // crear metodo para validar la cantidad de digitos del codigo ibn
    // esto se puede hacer a la hora que se guarde el objeto

    
   
   
    
   
}
