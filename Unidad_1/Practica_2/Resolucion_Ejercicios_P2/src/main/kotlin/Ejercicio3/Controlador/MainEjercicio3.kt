package Ejercicio3.Controlador

import Ejercicio2.Modelo.Utils
import Ejercicio3.Modelo.Circulo
import Ejercicio3.Modelo.Cuadrado
import Ejercicio3.Modelo.Rectangulo
import Ejercicio3.Modelo.Shape

// Instanciando la clase Utils
var utils = Utils()
val separador1 = "*******************************"
val separador2 = "..............................."

fun mostrarMenu(){
    // Mostrando Menu General
    println("¡Bienvenido!")
    println("Elija una Opcion")
    println("1. Circulo")
    println("2. Cuadrado")
    println("3. Rectangulo")
    println("4. Salir")
}

fun mostrarSubMenu(figura: String){
    // Mostrando Sub menu con respecto a la Figura
    println("... Figura: $figura ...")
    println("¿Que desea calcular?")
    println("1. Area")
    println("2. Perimetro")
    println("3. Volver")
}

fun generarCirculo(): Circulo{
    // Instanciando de la clase Circulo
    val circulo = Circulo(utils.conversionDecimal("Radio: ", 0.0, 1000000.0))
    return circulo
}

fun generarCuadrado(): Cuadrado{
    // Instanciando de la clase Cuadrado
    val cuadrado = Cuadrado(utils.conversionDecimal("Lado: ", 0.0, 1000000.0))
    return cuadrado
}

fun generarRectangulo(): Rectangulo {
    // Instanciando de la clase Rectangulo
    val rectangulo = Rectangulo(utils.conversionDecimal("Largo: ", 0.0, 1000000.0)
        ,utils.conversionDecimal("Ancho: ", 0.0, 1000000.0))
    return rectangulo
}

fun determinarFigura(opcion: Int): Shape? {
    // Determinando que tipo de figura es
    return when (opcion) {
        1 -> generarCirculo()
        2 -> generarCuadrado()
        3 -> generarRectangulo()
        else -> {
            println("-- Opción no válida --")
            null
        }
    }
}

fun determinarAccion(opcion: Int, figura: Shape) {
    // Determinando la accion de la figura
    when(opcion){
        1 -> {
            figura.calcularArea()
            figura.imprimirArea()
        }
        2 -> {
            figura.calcularPerimetro()
            figura.imprimirPerimetro()
        }
    }
}

fun main(){
    // Bucle inicial para la gestión del menú
    while (true) {
        println(separador1)
        // Mostrando el Menú
        mostrarMenu()
        // Leyendo la opcion del Menú
        val opcion = utils.conversionEntero("Su opcion: ", 1, 4)
        if (opcion != 4) {
            // Instanciando Figura de Tipo Shape
            var figura: Shape? = determinarFigura(opcion)
            // Bucle secundario para la gestión del submenú
            while(true && figura != null) {
                println(separador2)
                // Mostrando el Sub Menú
                mostrarSubMenu(figura.nombre)
                // Leyendo la opcion del Sub-Menú
                val subOpcion = utils.conversionEntero("Su opcion: ", 1, 3)

                if (subOpcion != 3) {
                    determinarAccion(subOpcion, figura)
                } else {
                    // Rompiendo el bucle para volver al menu principal
                    break
                }
            }
        } else {
            // Saliendo del Menu Principal
            return
        }
    }
}