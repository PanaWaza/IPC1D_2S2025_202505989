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
public class LectorArchivoUsuarios {
    
    // -archivo- es solo la referencia al documento
    // -lector- llave de accedo al archivo
    
    public static Boolean LectorUsuarios(){
        File archivo = new File ("C:\\Users\\Pana_Waza\\Desktop\\documentos txt proyecto 1\\cuentas.txt");
        try(Scanner lector = new Scanner(archivo)){
            while(lector.hasNextLine()){
                String Linea = lector.nextLine();
                String[] datos = Linea.split(",");
                if(datos[0].equals("1")){ // esto es para diferenciar entre alumnos y moderadores
                    int rol = Integer.parseInt(datos[0]);
                    String nombre = datos [1];
                    int carnet = Integer.parseInt(datos[2]);
                    String contraseña = datos[3];
                    String carrera = datos[4];
                    int PresActivos = Integer.parseInt(datos[5].trim());
                    int PresVencidos = Integer.parseInt(datos[6].trim());
                    Estudiante.saveStudent(rol, nombre, carnet, contraseña, carrera, PresActivos, PresVencidos);
                }
                else {
                    int rolModerador = Integer.parseInt(datos[0]);
                    String nombreModerador = datos[1];
                    String contraeModerador = datos[2];
                    int carnet = Integer.parseInt(datos[3].trim());
                    Moderadores.saveModeradores(rolModerador,nombreModerador,contraeModerador,carnet);
                }
            }
            lector.close(); //cerrar el archivo una vez terminado de usar
        }
        catch(FileNotFoundException e){
            System.out.println(" Problemas al leer el archivo txt (archivo no encontrado)");
        }
        return true; // retorna verdadera para saber que la peticion fue hecha correctamente
    }
    
}
