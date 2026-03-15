/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bibliosystem;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Pana_Waza
 */
public class LectorArchivoLibros {
    
    /*
     this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.publishYear = publisYear;
        this.ejemplares = ejemplares;
        this.IBN = IBN;
    */
    
    public static boolean LectorArchivo (){
        File archivo = new File("C:\\Users\\Pana_Waza\\Desktop\\documentos txt proyecto 1\\Libros.txt");
        try(Scanner leer = new Scanner(archivo)){
            while(leer.hasNextLine()){
                String linea = leer.nextLine();
                String [] datos = linea.split(",");
                String titulo = datos[0];
                String autor = datos[1];
                String genero = datos[2];
                String Puby = datos[3];
                // combertir a entero limpiar los espacios en blanco por el parseint  
                int Nejem = Integer.parseInt(datos[4].trim());
                // otra forma poco mas larga
                String ibn = datos[5]; // se dejo como cadena ya que el ibn es muy grande para ser contenido en un int
                Libro.saveBooks(titulo, autor, genero, Puby, Nejem, ibn);
            }
            leer.close();
        }
        catch(FileNotFoundException e){
            System.out.println(" Problemas a leer el archivo libros ");
        }
        
        return true;
    }
    
    
}
    

