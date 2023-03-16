# Convertidor Múltiple
![](https://github.com/GioScarp/convertidor_monedas/blob/main/convertidor_moneda/resources/Readme_Recursos/Conversor_Multiple.png)

Convertidor Múltiple es una aplicación que cuenta con dos convertidores: uno para monedas y otro para temperaturas. Con esta app podrás conocer el valor de una moneda en otra, de acuerdo con la tasa de cambio actual. Además, podrás convertir temperaturas a diferentes unidades de medida.

Esta app es una solución al challenge "Convertidor de Moneda" propuesto por Alura Latam Oracle-One Next Education. 

## Table of Contents

- [Requisitos del Challenge](#requisitos-del-challenge)
- [Extras](#extras)
- [Demo](#demo)
- [Características](#características)
- [Pasos de instalación](#pasos-de-instalación)
  - [JAR](#ejecutable-jar)
  - [Intellij](#intellij-idea)
- [Proceso](#proceso)
- [License](#licencia)
- [Autor](#autor)

# Requisitos del Challenge

       - Convertir de la moneda de tu país a Dólar
       - Convertir de la moneda de tu país  a Euros
       - Convertir de la moneda de tu país  a Libras Esterlinas
       - Convertir de la moneda de tu país  a Yen Japonés
       - Convertir de la moneda de tu país  a Won sul-coreano

Recordando que también debe ser posible convertir inversamente.
### Extras
Como desafío extra te animamos a que dejes fluir tu creatividad, si puedo convertir divisas, ¿tal vez pueda añadir a mi programa otros tipos de conversiones?
# Demo
![](https://github.com/GioScarp/convertidor_monedas/blob/main/convertidor_moneda/resources/Readme_Recursos/Convertidor_Multiple.gif)

# Características
* Consumo de Appi's [Exchange Rate Data API](https://apilayer.com/marketplace/exchangerates_data-api) 
* Tasa de cambio actual de las diferentes monedas disponibles
* Interfaz gráfica agradable e intuitiva
* Validaciones a los datos ingresados por parte del usuario
* Texto informativos a medida de que el usuario interactua con la app
# Pasos de instalación
### Ejecutable JAR
1. Descargue el release del proyecto o directamente de [aquí]()
2. Descomprima el archivo zip
3. Ejecute el archivo extraido Jar Conversor_Moneda.jar y disfrute
### Intellij IDEA
1. Clonar el repositorio
2. Abir proyecto en Intellij
3. Run main y disfrutar

# Proceso
### Tecnologías usadas
* Java 17
* GitHub
* Photoshop
### Estructura del proyecto
* Resources
* src
    * Config
        * Properties
    * Controladores
        * Controlador Moneda
        * Controlador Temperatura
    * Vistas
        * Vista Moneda
        * Vista Temperatura
        * Vista Main
#### Clase Moneda
    public class Moneda {
        private String nombre;
        private String simbolo;
        private ImageIcon icono;

        public Moneda(){
        }
    }
#### Clase Temperatura

    public class Temperatura {
        private double temperatura;
        private String simbolo;
        private String nombre;
        private ImageIcon icon;
    
        public Temperatura(){

        }
    }

### Validaciones
* Solo son válidos números enteros o decimales
* Para el convertidor de moneda no se aceptan valores negativos o valor 0
* Para poder convertir se debe seleccionar las monedas correspondientes o la temperatura principal
    
# Licencia
Este proyecto está licenciado bajo la Licencia MIT
# Autor
Creado con 💙 por Giovanni Scarpetta

