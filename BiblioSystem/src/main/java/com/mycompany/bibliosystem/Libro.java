/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bibliosystem;

import java.time.LocalDate;
import java.util.ArrayList;


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
    private String titulo;
    private String autor;
    private String genero;
    private String publishYear;
    private int ejemplares=0;
    
    // gloval     
    public static ArrayList <Libro> libros = new ArrayList<>();
    
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
       libros.add(nuevoLibro);
   }
    
   
   public static String getBookName(String ibn){
       String BookName;
       for (Libro libro : libros) {
           // van y chingan a su madre caracteres vacios 
           if (libro.IBN.trim().equals(ibn.trim())) {
               BookName = libro.titulo;
               return BookName;
           }
       }
       return BookName = ""; // retorno por si el ibn esta malo
   }
    
   public static String getDatePrestamo(){
       
       LocalDate fecha = LocalDate.now();
       String FechaPrestamo = fecha.toString();
       return FechaPrestamo;
   }
   
   // sumarle una semana a la fecha
   public static String SumaFecha(String fechaPrestamo){
       
       LocalDate date = LocalDate.parse(fechaPrestamo);
       date = date.plusWeeks(1);
       
       String Sdate = date.toString();
       
       return Sdate;
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
