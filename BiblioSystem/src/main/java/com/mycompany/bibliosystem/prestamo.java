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
    private String NombreLibro;
    private String IBN;
    private String FP; // FECHA PRESTAMO
    private String FD; // FECHA DEVOLUCION
    private String historial;
    
    
    public static prestamo[] ListaPrestamos = new prestamo[100] ; 
    public static int ContadorPrestamos = 0;
    
    prestamo(int carnet,String IBN, String NombreLibro,String FP, String FD,String historial){
        this.carnet = carnet;
        this.IBN = IBN;
        this.NombreLibro=NombreLibro;
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
