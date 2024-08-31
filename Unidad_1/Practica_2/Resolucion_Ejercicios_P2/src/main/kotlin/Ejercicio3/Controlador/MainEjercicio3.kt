package Ejercicio3.Controlador

import Ejercicio2.Modelo.Utils
import Ejercicio3.Modelo.Circulo
import Ejercicio3.Modelo.Cuadrado
import Ejercicio3.Modelo.Rectangulo


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

fun generarCirculo(){
    var circulo = Circulo(0.0)
}

fun generarCuadrado(){
    var cuadrado = Cuadrado(0.0)
}

fun generarRectangulo(){
    var rectangulo = Rectangulo(0.0,0.0)

}

fun main(){
    // Instanciando la clase Utils
    val utils = Utils()
    // Bucle inicial para la gestión del menú
    while (true) {
        // Mostrando el Menú
        mostrarMenu()
        // Leyendo la opcion del Menú
        val opcion = utils.conversionEntero("Su opcion: ", 1, 4)

        if (opcion != 4) {
            // Bucle secundario para la gestión del submenú
            while(true) {
                // Mostrando el Sub Menú
                mostrarSubMenu("")
                // Leyendo la opcion del Sub-Menú
                val subOpcion = utils.conversionEntero("Su opcion: ", 1, 3)

                if (subOpcion != 3) {
                    println()
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