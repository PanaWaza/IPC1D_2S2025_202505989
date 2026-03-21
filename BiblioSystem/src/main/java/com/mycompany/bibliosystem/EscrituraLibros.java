/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bibliosystem;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Pana_Waza
 */
public class EscrituraLibros {
    
    public static void EliminarLibro(String isbnABuscar) {
        // Ruta del archivo de libros
        File archivoLibros = new File("C:\\Users\\Pana_Waza\\Desktop\\documentos txt proyecto 1\\Libros.txt");
        String[] temporal = new String[200];
        int contador = 0;

        try (Scanner lector = new Scanner(archivoLibros)) {
            while (lector.hasNextLine()) {
                String fila = lector.nextLine();
                if (fila.trim().isEmpty()) {
                    continue;
                }


                String[] datos = fila.split(",");

                String isbnEnArchivo = datos[5].trim();


                if (!isbnEnArchivo.equals(isbnABuscar)) {
                    temporal[contador] = fila;
                    contador++;
                } else {
                    System.out.println("Libro con ISBN " + isbnABuscar + " encontrado y eliminado.");
                }
            }
        } catch (Exception e) {
            System.out.println("Error al leer el archivo de libros: " + e.getMessage());
            return;
        }


        try (PrintWriter escritor = new PrintWriter(new FileWriter(archivoLibros))) {
            for (int i = 0; i < contador; i++) {
                escritor.println(temporal[i]);
            }
        } catch (Exception e) {
            System.out.println("Error al guardar los cambios: " + e.getMessage());
        }
    }
    
    
    public static void AgregarLibro(String titulo, String autor, String genero, String anio, int ejemplares, String isbn) {
        // Ruta del archivo de libros
        File archivoLibros = new File("C:\\Users\\Pana_Waza\\Desktop\\documentos txt proyecto 1\\libros.txt");

        // 'true' en el constructor de FileWriter permite añadir al final sin borrar el contenido previo
        try (PrintWriter escritor = new PrintWriter(new FileWriter(archivoLibros, true))) {

            // Construimos la línea con el formato: Título, Autor, Género, Año, Ejemplares, ISBN
            // El año entra como texto y los ejemplares como número
            String nuevaLinea ="\n"+ titulo + "," + autor + "," + genero + "," + anio + "," + ejemplares + "," + isbn;

            escritor.println(nuevaLinea);

            System.out.println("Libro '" + titulo + "' guardado correctamente.");

        } catch (IOException e) {
            System.out.println("Error al intentar escribir en el archivo de libros: " + e.getMessage());
        }
    
    }
    
    
}
