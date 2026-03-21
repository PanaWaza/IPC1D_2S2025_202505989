/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bibliosystem;





/**
 *
 * @author Pana_Waza
 */
public class prestamo {
    private int carnet;
    public String NombreLibro;
    public String IBN;
    private String FP; // FECHA PRESTAMO
    private String FD; // FECHA DEVOLUCION
    private String historial;
    
    
    
    public static prestamo[] ListaPrestamos = new prestamo[100] ; 
    public static int ContadorPrestamos = 0;
    
    prestamo(int carnet,String IBN, String NombreLibro,String FP, String FD,String historial){
        this.NombreLibro=NombreLibro;
        this.carnet = carnet;
        this.IBN = IBN;
        this.FP= FP;
        this.FD=FD;
        this.historial=historial;
    }
    
    //  save prestamos
    public static void guardarPrestamo(int carnet ,String IBN , String NombreLibro,String FP, String FD,String historial){
        prestamo prestamistas = new prestamo(carnet,IBN,NombreLibro, FP, FD, historial);
        ListaPrestamos[ContadorPrestamos] = prestamistas;
        ContadorPrestamos++;
    }

    public static boolean ConfirmarExistenciPrestamo(int carnet, String ibn){
        for (int i = 0; i < ContadorPrestamos; i++) {
            if (ListaPrestamos[i].carnet == carnet && ListaPrestamos[i].IBN.trim().equals(ibn)) {
                return true;
            }
        }
        return false;
    }
    
    public static int ValidacionParaEliminacionLibros(String ibn){
        int cantidad=0;
        for (int i = 0; i < ContadorPrestamos; i++) {
            if (ListaPrestamos[i].IBN.trim().equals(ibn.trim())) {
                cantidad ++;
            }
        }
        return cantidad;
    }
    public static boolean CantidadPrestamos(int carnet){
        int cantidad=0;
        for (int i = 0; i < ContadorPrestamos; i++) {
            if (ListaPrestamos[i].carnet == carnet) {
                cantidad ++;
            }
        }
        return cantidad < 3;
    }
    
    public static boolean BuscarPrestamosVencidos(int carnet){
        for (int i = 0; i < ContadorPrestamos; i++) {
            if (ListaPrestamos[i].carnet == carnet && ListaPrestamos[i].historial.trim().toLowerCase().equals("vencido".trim()) ) {
               return true;
            }
        }
        return false;
    }
    
    
    public static Object[][] ObtenerPrestamosActivos(String carnet){
        int id = Integer.parseInt(carnet.trim());
        int llave = 0;
        Object[][] filas = new Object [3][5];
        for (int i = 0; i < ContadorPrestamos; i++) {
            if (ListaPrestamos[i].carnet == id  && ListaPrestamos[i].historial.trim().equalsIgnoreCase("activo")) {
                filas[llave][0]= ListaPrestamos[i].NombreLibro;
                filas[llave][1]= ListaPrestamos[i].IBN;
                filas[llave][2]= ListaPrestamos[i].FP;
                filas[llave][3]= ListaPrestamos[i].FD;
                filas[llave][4]= ListaPrestamos[i].historial;
                llave++;
            }
        }
        return filas;
    }
    
    
    
    public static void EliminarPrestamo(String carnet, String ibn) {
    int idC = Integer.parseInt(carnet.trim());
    String ibnLimpio = ibn.trim();

    for (int i = 0; i < ContadorPrestamos; i++) {
        if (ListaPrestamos[i] != null && 
            ListaPrestamos[i].carnet == idC && 
            ListaPrestamos[i].IBN.equals(ibnLimpio) && 
            ListaPrestamos[i].historial.equalsIgnoreCase("activo")) {
            
            // Marcamos como devuelto
            ListaPrestamos[i].historial = "devuelto"; 
            break; // Salimos del ciclo al encontrarlo
        }
    }
}
    
    public static String getEstadoLibro(int carnet ,String ibn){
        for (int i = 0; i < ContadorPrestamos; i++) {
            if (ListaPrestamos[i].carnet == carnet && ListaPrestamos[i].IBN.trim().equalsIgnoreCase(ibn)) {
                return ListaPrestamos[i].historial;
            }
        }
        return "";
    }
    
    /**
     * @return the carnet
     */
    public int getCarnet() {
        return carnet;
    }
    public String getHistorial(){
        return historial;
    }

    /**
     * @return the NombreLibro
     */
    public String getNombreLibro() {
        return NombreLibro;
    }

    /**
     * @return the IBN
     */
    public String getIBN() {
        return IBN;
    }

    /**
     * @return the FP
     */
    public String getFP() {
        return FP;
    }

    /**
     * @return the FD
     */
    public String getFD() {
        return FD;
    }
    
}
