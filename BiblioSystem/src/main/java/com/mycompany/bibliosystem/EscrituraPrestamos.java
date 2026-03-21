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
public class EscrituraPrestamos {
    
    public static void EliminarPrestamo(String carnetABuscar, String isbnABuscar) {
        File archivoPrestamos = new File("C:\\Users\\Pana_Waza\\Desktop\\documentos txt proyecto 1\\prestamos.txt");
        // Arreglo temporal para guardar los préstamos que NO vamos a eliminar
        String[] temporal = new String[200];
        int contador = 0;
        boolean encontrado = false;

        // 1. LEER Y FILTRAR
        try (Scanner lector = new Scanner(archivoPrestamos)) {
            while (lector.hasNextLine()) {
                String fila = lector.nextLine();
                if (fila.trim().isEmpty()) {
                    continue;
                }

                String[] datos = fila.split(",");

                // Extraemos los datos de las columnas 1 y 2
                String carnetEnArchivo = datos[0].trim();
                String isbnEnArchivo = datos[1].trim();

                // CONDICIÓN PARA ELIMINAR:
                // Si el carnet COINCIDE Y el ISBN COINCIDE, no lo guardamos en el arreglo
                if (carnetEnArchivo.equals(carnetABuscar) && isbnEnArchivo.equals(isbnABuscar)) {
                    encontrado = true;
                    System.out.println("Prestamo localizado y marcado para eliminar.");
                } else {
                    // Si no son iguales, la fila se mantiene en el sistema
                    temporal[contador] = fila;
                    contador++;
                }
            }
        } catch (Exception e) {
            System.out.println("Error al leer el archivo de prestamos: " + e.getMessage());
            return;
        }

        // 2. REESCRIBIR EL ARCHIVO
        try (PrintWriter escritor = new PrintWriter(new FileWriter(archivoPrestamos))) {
            for (int i = 0; i < contador; i++) {
                escritor.println(temporal[i]);
            }
        } catch (Exception e) {
            System.out.println("Error al actualizar el archivo: " + e.getMessage());
        }

        if (!encontrado) {
            System.out.println("No se encontro un prestamo con esos datos.");
        }
    }
    
    
    public static void RegistrarPrestamo(String carnet, String isbn, String titulo, String fechaInicio, String fechaFin, String estado) {
        File archivoPrestamos = new File("C:\\Users\\Pana_Waza\\Desktop\\documentos txt proyecto 1\\prestamos.txt");

        // Usamos 'true' en FileWriter para añadir al final sin borrar lo anterior
        try (PrintWriter escritor = new PrintWriter(new FileWriter(archivoPrestamos, true))) {

            // Construimos la línea con las 6 columnas separadas por comas
            String nuevaLinea ="\n" + carnet + "," + isbn + "," + titulo + "," + fechaInicio + "," + fechaFin + "," + estado;

            escritor.println(nuevaLinea);

            System.out.println("Préstamo registrado: " + titulo + " para el carnet " + carnet);

        } catch (IOException e) {
            System.out.println("Error al registrar el préstamo: " + e.getMessage());
        }
    }
    
}
