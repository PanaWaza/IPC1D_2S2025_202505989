/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bibliosystem;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Pana_Waza
 */
public class Bitacora {
    
    
    public static  void CrearBitacora() {
        try (FileWriter fw = new FileWriter("Bitacora.txt", true)) {
            fw.write("Nueva línea de texto\n");
            System.out.println("Proceso completado.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // [OPERACION][USUARIO][MODULO][FECHA DD/MM/AA][HORA HH:MM AM/PM] 
    
    public static  void appendBitacora(String Operacion,String carnet,String modulo) {
        String fecha = getFecha();
        String hora = getHora();
        
        String fila = Operacion + "," + carnet + "," + modulo + "," + fecha + "," +hora;
        
        try (FileWriter fw = new FileWriter("Bitacora.txt", true)) {
            fw.write(fila + System.lineSeparator());
        } catch (Exception e) {
            System.out.println("error al escribir bitacora " + e.getMessage());
        }
    }
    
    private static String getFecha() {
        LocalDate fecha = LocalDate.now();
        String Fecha = fecha.toString();
        return Fecha;
    }
    
    private static String getHora() {
        LocalTime fh = LocalTime.now();
        String FH = fh.toString();
        return FH;
    }
    
    // String  operacion ,  int  carnet , String  modulo (lugar de operacion)
    
}
