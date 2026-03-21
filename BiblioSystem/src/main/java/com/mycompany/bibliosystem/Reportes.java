package com.mycompany.bibliosystem;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * @author Pana_Waza
 */
public class Reportes {

    public static void PrestamosVencidos() {
        String rutaEscritorio = "C:/Users/Pana_Waza/Desktop/Reportes";
        String nombreArchivo = "Reporte_Vencidos.html";
        java.nio.file.Path rutaCompleta = java.nio.file.Paths.get(rutaEscritorio).resolve(nombreArchivo);

        // 1. Definimos el formato de tus fechas (Día/Mes/Año)
        DateTimeFormatter formatoEspanol = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String html = """
        <html>
        <head>
            <meta charset='UTF-8'>
            <style>
                table { width: 100%; border-collapse: collapse; font-family: sans-serif; }
                th, td { border: 1px solid #dddddd; text-align: left; padding: 8px; }
                th { background-color: #f2f2f2; color: #333; }
                tr:nth-child(even) { background-color: #f9f9f9; }
                .vencido { color: red; font-weight: bold; }
                .atraso { color: #d35400; font-weight: bold; }
            </style>
        </head>
        <body>
            <h2>Listado de Préstamos Vencidos</h2>
            <table>
                <tr>
                    <th>Carnet</th>
                    <th>Libro</th>
                    <th>ISBN</th>
                    <th>Fecha Préstamo</th>
                    <th>Fecha Devolución</th>
                    <th>Estado</th>
                    <th>Días de Atraso</th>
                </tr>
        """;

        int ContadorPrestamos = prestamo.ContadorPrestamos;
        prestamo[] ListaPrestamos = prestamo.ListaPrestamos;
        LocalDate hoy = LocalDate.now();

        for (int i = 0; i < ContadorPrestamos; i++) {
            prestamo p = ListaPrestamos[i];

            if (p.getHistorial().equalsIgnoreCase("vencido")) {
                
                long diasAtraso = 0;
                try {
                    // AQUÍ ESTÁ EL CAMBIO: Usamos el formatoEspanol para leer la fecha
                    LocalDate fechaEntrega = LocalDate.parse(p.getFD(), formatoEspanol); 
                    diasAtraso = ChronoUnit.DAYS.between(fechaEntrega, hoy);
                } catch (Exception e) {
                    diasAtraso = 0; // Si algo falla, muestra 0
                }

                html += "<tr>";
                html += "<td>" + p.getCarnet() + "</td>";
                html += "<td>" + p.getNombreLibro() + "</td>";
                html += "<td>" + p.getIBN() + "</td>";
                html += "<td>" + p.getFP() + "</td>";
                html += "<td>" + p.getFD() + "</td>";
                html += "<td class='vencido'>" + p.getHistorial() + "</td>";
                html += "<td class='atraso'>" + diasAtraso + " días</td>";
                html += "</tr>";
            }
        }

        html += "</table></body></html>";

        try {
            if (java.nio.file.Files.notExists(java.nio.file.Paths.get(rutaEscritorio))) {
                java.nio.file.Files.createDirectories(java.nio.file.Paths.get(rutaEscritorio));
            }
            java.nio.file.Files.writeString(rutaCompleta, html);
            System.out.println("Reporte corregido generado en el escritorio.");
        } catch (java.io.IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    
    public static void LibrosDisponibles() {
        String rutaEscritorio = "C:/Users/Pana_Waza/Desktop/Reportes";
        String nombreArchivo = "Reporte_Libros_Disponibles.html";
        java.nio.file.Path rutaCompleta = java.nio.file.Paths.get(rutaEscritorio).resolve(nombreArchivo);

        // 1. Estructura HTML con un color diferente (Verde para disponibilidad)
        String html = """
        <html>
        <head>
            <meta charset='UTF-8'>
            <style>
                table { width: 100%; border-collapse: collapse; font-family: sans-serif; }
                th, td { border: 1px solid #dddddd; text-align: left; padding: 10px; }
                th { background-color: #27ae60; color: white; }
                tr:nth-child(even) { background-color: #f2f9f4; }
                .cantidad { font-weight: bold; color: #2c3e50; }
            </style>
        </head>
        <body>
            <h2>Reporte de Inventario: Libros Disponibles</h2>
            <table>
                <tr>
                    <th>Código (ISBN)</th>
                    <th>Título</th>
                    <th>Autor</th>
                    <th>Género</th>
                    <th>Año</th>
                    <th>Cantidad Disponible</th>
                </tr>
        """;

        // Invocar variables del objeto Libro
        int totalLibros = Libro.ContadorLibros;
        Libro[] listaLibros = Libro.libros;

        // 2. Recorremos el arreglo de libros
        for (int i = 0; i < totalLibros; i++) {
            Libro l = listaLibros[i];

            // 3. FILTRO: Solo si hay 1 o más ejemplares
            if (l.ejemplares > 0) {
                html += "<tr>";
                html += "<td>" + l.IBN + "</td>";
                html += "<td>" + l.titulo + "</td>";
                html += "<td>" + l.autor + "</td>";
                html += "<td>" + l.genero + "</td>";
                html += "<td>" + l.publishYear + "</td>";
                html += "<td class='cantidad'>" + l.ejemplares + " unidades</td>";
                html += "</tr>";
            }
        }

        // 4. Cierre del HTML
        html += """
            </table>
        </body>
        </html>
        """;

        // 5. Escritura del archivo
        try {
            if (java.nio.file.Files.notExists(java.nio.file.Paths.get(rutaEscritorio))) {
                java.nio.file.Files.createDirectories(java.nio.file.Paths.get(rutaEscritorio));
            }
            java.nio.file.Files.writeString(rutaCompleta, html);
            System.out.println("Reporte de libros disponibles generado con éxito.");
        } catch (java.io.IOException e) {
            System.out.println("Error al generar el reporte de libros: " + e.getMessage());
        }
    }
    
    
    
    public static void Top5Libros() {
        String rutaEscritorio = "C:/Users/Pana_Waza/Desktop/Reportes";
        String nombreArchivo = "Reporte_Top5_Libros.html";
        java.nio.file.Path rutaCompleta = java.nio.file.Paths.get(rutaEscritorio).resolve(nombreArchivo);

        int totalLibros = Libro.ContadorLibros;
        Libro[] listaOrdenada = new Libro[totalLibros];

        // 1. Copiamos los libros a un arreglo temporal
        for (int i = 0; i < totalLibros; i++) {
            listaOrdenada[i] = Libro.libros[i];
        }

        // 2. Ordenamiento usando el contador de la clase 'prestamo'
        for (int i = 0; i < totalLibros - 1; i++) {
            for (int j = 0; j < totalLibros - i - 1; j++) {

                // Usamos TU MÉTODO para saber cuántos préstamos tiene cada uno actualmente
                int conteoJ = prestamo.ValidacionParaEliminacionLibros(listaOrdenada[j].IBN);
                int conteoJ1 = prestamo.ValidacionParaEliminacionLibros(listaOrdenada[j + 1].IBN);

                boolean debeIntercambiar = false;

                if (conteoJ < conteoJ1) {
                    debeIntercambiar = true;
                } else if (conteoJ == conteoJ1) {
                    // Empate: Orden alfabético por título
                    if (listaOrdenada[j].titulo.compareToIgnoreCase(listaOrdenada[j + 1].titulo) > 0) {
                        debeIntercambiar = true;
                    }
                }

                if (debeIntercambiar) {
                    Libro temp = listaOrdenada[j];
                    listaOrdenada[j] = listaOrdenada[j + 1];
                    listaOrdenada[j + 1] = temp;
                }
            }
        }

        // 3. Generar el HTML
        String html = """
        <html>
        <head>
            <meta charset='UTF-8'>
            <style>
                table { width: 100%; border-collapse: collapse; font-family: sans-serif; }
                th, td { border: 1px solid #dddddd; text-align: left; padding: 12px; }
                th { background-color: #2c3e50; color: white; }
                .posicion { font-weight: bold; color: #f39c12; }
                tr:nth-child(even) { background-color: #f9f9f9; }
            </style>
        </head>
        <body>
            <h2>🏆 Top 5: Libros con Mayor Actividad</h2>
            <table>
                <tr>
                    <th>Ranking</th>
                    <th>Título</th>
                    <th>ISBN</th>
                    <th>Total Préstamos</th>
                </tr>
        """;

        int limite = Math.min(5, totalLibros);
        for (int i = 0; i < limite; i++) {
            Libro l = listaOrdenada[i];
            // Volvemos a llamar al conteo para mostrarlo en la celda
            int totalEnHistorial = prestamo.ValidacionParaEliminacionLibros(l.IBN);

            html += "<tr>";
            html += "<td class='posicion'>#" + (i + 1) + "</td>";
            html += "<td>" + l.titulo + "</td>";
            html += "<td>" + l.IBN + "</td>";
            html += "<td>" + totalEnHistorial + " préstamos registrados</td>";
            html += "</tr>";
        }

        html += "</table></body></html>";

        try {
            java.nio.file.Files.writeString(rutaCompleta, html);
            System.out.println("Reporte Top 5 (basado en historial) generado con éxito.");
        } catch (java.io.IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    
    
    public static void EstudiantesConPrestamos() {
        String rutaEscritorio = "C:/Users/Pana_Waza/Desktop/Reportes";
        String nombreArchivo = "Reporte_Estudiantes_Activos.html";
        java.nio.file.Path rutaCompleta = java.nio.file.Paths.get(rutaEscritorio).resolve(nombreArchivo);

        String html = """
        <html>
        <head>
            <meta charset='UTF-8'>
            <style>
                table { width: 100%; border-collapse: collapse; font-family: sans-serif; }
                th, td { border: 1px solid #dddddd; text-align: left; padding: 12px; }
                th { background-color: #2980b9; color: white; }
                tr:nth-child(even) { background-color: #f2f7fb; }
                .alerta { color: #e74c3c; font-weight: bold; }
                .limpio { color: #27ae60; }
            </style>
        </head>
        <body>
            <h2> Reporte de Estudiantes con Libros</h2>
            <table>
                <tr>
                    <th>Carné</th>
                    <th>Nombre</th>
                    <th>Carrera</th>
                    <th>Préstamos Activos</th>
                    <th>¿Tiene Vencidos?</th>
                </tr>
        """;

        // Recorremos tu arreglo de estudiantes
        for (int i = 0; i < Estudiante.ContadorEstudiante; i++) {
            Estudiante e = Estudiante.estudiante[i];

            int contadorActivos = 0;
            boolean tieneVencidos = false;

            // Buscamos en la lista de la clase prestamo
            for (int j = 0; j < prestamo.ContadorPrestamos; j++) {
                prestamo p = prestamo.ListaPrestamos[j];

                // Si el carné del préstamo coincide con el del estudiante
                if (p.getCarnet() == e.carnet) {
                    String estado = p.getHistorial().trim().toLowerCase();

                    if (estado.equals("activo")) {
                        contadorActivos++;
                    } else if (estado.equals("vencido")) {
                        tieneVencidos = true;
                    }
                }
            }

            // Solo mostramos al estudiante si tiene al menos 1 libro activo
            if (contadorActivos > 0) {
                html += "<tr>";
                html += "<td>" + e.carnet + "</td>";
                html += "<td>" + e.nombre + "</td>";
                html += "<td>" + e.carrera + "</td>";
                html += "<td><b>" + contadorActivos + "</b></td>";

                if (tieneVencidos) {
                    html += "<td class='alerta'>SÍ</td>";
                } else {
                    html += "<td class='limpio'>No</td>";
                }
                html += "</tr>";
            }
        }

        html += "</table></body></html>";

        try {
            java.nio.file.Files.writeString(rutaCompleta, html);
            System.out.println("Reporte de estudiantes generado exitosamente.");
        } catch (java.io.IOException ex) {
            System.out.println("Error al escribir el reporte: " + ex.getMessage());
        }
    }
}