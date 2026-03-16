/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bibliosystem;
import com.mycompany.bibliosystem.Ventanas.*;

/**
 *
 * @author Pana_Waza
 */
public class BiblioSystem {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        // leer archivo de texto de las cuentas
        LectorArchivoUsuarios.LectorUsuarios();
        // leer archivo txt libros
        LectorArchivoLibros.LectorArchivo();
        
        // leer archivo txt prestamos
        LectorArchivoPrestamos.LectorPrestamos();
        
        uno VentanaPrincipal = new uno ();
        VentanaPrincipal.setVisible(true);
    }
}
