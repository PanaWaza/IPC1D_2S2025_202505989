# IPCD_2S2025_202505989


# Bibiosystem - Guía de Desarrollo de Interfaces (GUI) en Java
``
Este repositorio contiene la documentación y guías técnicas para el desarrollo de interfaces gráficas de usuario (GUI) del proyecto **Bibiosystem**. El objetivo es estandarizar la creación de ventanas y componentes visuales utilizando las bibliotecas nativas de Java.

## 🚀 Descripción del Proyecto
Bibiosystem es un sistema integral diseñado para la gestión de información. Esta sección del proyecto se enfoca específicamente en la implementación de la capa de presentación, asegurando una experiencia de usuario (UX) intuitiva y funcional mediante Java Swing y AWT.

## 🛠️ Tecnologías Utilizadas
* **Lenguaje:** Java 
* **Bibliotecas de GUI:** * `javax.swing` (Componentes ligeros)
    * `java.awt` (Gestión de eventos y layouts)
* **IDE :** Apache NetBeans

## 📚 Contenido de la Guía
La guía incluida en este archivo abarca los siguientes puntos fundamentales:
1. **Configuración del JFrame:** Creación de la ventana principal y propiedades básicas (título, tamaño, cierre).
2. **Layout Managers:** Uso de `BorderLayout`, `GridLayout` y `FlowLayout` para organizar componentes.
3. **Componentes Visuales:** Implementación de `JButton`, `JTextField`, `JLabel`, `JTable` y otros elementos clave.
4. **Manejo de Eventos:** Uso de `ActionListener` para dar funcionalidad a los botones y controles.
5. **Estética:** Personalización de colores y fuentes para mantener la identidad visual de Bibiosystem.

## 💻 Ejemplo Rápido
```java
// Estructura básica recomendada para las ventanas de Bibiosystem
import javax.swing.*;

public class VentanaPrincipal extends JFrame {
    public VentanaPrincipal() {
        setTitle("Bibiosystem - Inicio");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}

