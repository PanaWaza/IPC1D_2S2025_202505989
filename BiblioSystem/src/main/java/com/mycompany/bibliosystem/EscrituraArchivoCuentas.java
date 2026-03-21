/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bibliosystem;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;


/**
 *
 * @author Pana_Waza
 */
public class EscrituraArchivoCuentas {
     //Formato Cuentas 2,Andrea Flores,Andrea2024,2024003
    // 1,Carlos Ruiz,2023003,Carlos99,Arquitectura,3,2
    // rol ,nombre, contra, carnet 
 
    
    public static  void IngresarEstudiante(String nombre,int carnet,String contraseña,String carrera,int activos,int vencidos) {
        // puntero
        try(FileWriter fw = new FileWriter ("C:\\Users\\Pana_Waza\\Desktop\\documentos txt proyecto 1\\cuentas.txt",true)) {// llave de acceso
            fw.write(" \n 1,"+nombre+","+carnet+","+contraseña+","+carrera+","+activos+","+vencidos);
        } catch (Exception e) {
            System.out.println("Problemaas a ingresar un nuevo estudiante !!");
        }
    }
    
    public static  void IngresarModerador(String nombre,String contraseña,int carnet) {
        // puntero
        try(FileWriter fw = new FileWriter ("C:\\Users\\Pana_Waza\\Desktop\\documentos txt proyecto 1\\cuentas.txt",true)) {// llave de acceso
            fw.write("\n 2,"+nombre+","+contraseña+","+carnet);
        } catch (Exception e) {
            System.out.println("Problemaas a ingresar un nuevo Moderador !!");
        }    
    }
    
    public static void EliminarEstudiante(int carnetABuscar) {
        File archivoOriginal = new File("C:\\Users\\Pana_Waza\\Desktop\\documentos txt proyecto 1\\cuentas.txt");
        String[] temporal = new String[500]; // Arreglo para guardar las líneas que se quedan
        int contador = 0;

        try (Scanner lector = new Scanner(archivoOriginal)) {
            while (lector.hasNextLine()) {
                String fila = lector.nextLine();
                String[] datos = fila.split(",");
                
                int carnetEnArchivo = Integer.parseInt(datos[2].trim());

                // Si NO es el carnet que buscamos, lo guardamos en el arreglo
                if (carnetEnArchivo != carnetABuscar) {
                    temporal[contador] = fila;
                    contador++;
                }
            }
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        // 2. Sobrescribir el archivo con las líneas filtradas
        try (PrintWriter escritor = new PrintWriter(new FileWriter(archivoOriginal))) {
            for (int i = 0; i < contador; i++) {
                escritor.println(temporal[i]);
            }
            System.out.println("Proceso de eliminación finalizado.");
        } catch (Exception e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }
    }
    
    
    public static void EliminarModerador(int carnetABuscar) {
        File archivoOriginal = new File("C:\\Users\\Pana_Waza\\Desktop\\documentos txt proyecto 1\\cuentas.txt");
        String[] temporal = new String[1000];
        int contador = 0;

        try (Scanner lector = new Scanner(archivoOriginal)) {
            while (lector.hasNextLine()) {
                String fila = lector.nextLine();
                if (fila.trim().isEmpty()) {
                    continue;
                }

                String[] datos = fila.split(",");

                
                String idFila = datos[0].trim();
                int carnetFila = Integer.parseInt(datos[3].trim());

             
                if (idFila.equals("2") && carnetFila == carnetABuscar) {
                    System.out.println("Fila encontrada y marcada para eliminar.");
                   
                } else {
                  
                    temporal[contador] = fila;
                    contador++;
                }
            }
        } catch (Exception e) {
            System.out.println("Error al procesar el archivo: " + e.getMessage());
            return;
        }

        // Guardar los cambios sobrescribiendo el archivo
        try (PrintWriter escritor = new PrintWriter(new FileWriter(archivoOriginal))) {
            for (int i = 0; i < contador; i++) {
                escritor.println(temporal[i]);
            }
            System.out.println("Archivo actualizado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al guardar los cambios: " + e.getMessage());
        }
    }
    
}
