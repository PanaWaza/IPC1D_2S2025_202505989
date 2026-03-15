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
public class LectorArchivoPrestamos {
    
    public static boolean LectorPrestamos(){
        File archivo = new File("C:\\Users\\Pana_Waza\\Desktop\\documentos txt proyecto 1\\prestamos.txt");
        try(Scanner leer = new Scanner(archivo)){
            while(leer.hasNextLine()){
                String linea = leer.nextLine();
                String [] datos = linea.split(",");
                int carnet = Integer.parseInt(datos[0]);
                String ibn = datos[1].trim();
                String nombre = datos[2];
                String fechaP = datos[3];
                String fechaD = datos[4];
                String historial = datos[5];
                prestamo.guardarPrestamo(carnet, ibn, nombre, fechaP, fechaD,historial);
            }
            leer.close();
        }
        catch(FileNotFoundException e){
            System.out.println(" Problemas a leer el archivo prestamos ");
        }
        
        return true;
    }
    
}
