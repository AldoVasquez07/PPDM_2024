package Ejercicio_2

import kotlin.random.Random

fun generarElemento(num: Int): String{
    // Asignando el elemento, según el número ingresado
    var elemento = when(num){
        1 -> "Piedra"
        2 -> "Papel"
        3 -> "Tijera"
        else -> "error"
    }
    return elemento
}

fun leerElemento(): Int{
    // Variable que permite Null
    var opcionJugador: Int?

    while(true) {
        // Creando Menú de Elementos
        println("=== Elija un elemento ===")
        println("1. Piedra")
        println("2. Papel")
        println("3. Tijera")
        print("\nSu opcion: ")

        var opcion = readln()

        // Implementando try-catch para las excepciones
        try {
            // Realizando conversion a Entero
            opcionJugador = opcion.toInt()
            if (opcionJugador != null) {
                if (opcionJugador in 1..3) {
                    return opcionJugador
                } else {
                    // Prohibiendo Valores fuera del rango
                    println("--Debe Ingresar una Opcion Valida--")
                }
            } else {
                // Prohibiendo nulos
                println("--Debe Ingresar una Opcion--")
            }
        } catch (e: NumberFormatException) {
            // Prohibiendo valores no enteros
            println("--Ingrese una Opcion Pertinente--")
        }
    }
}

fun main() {
    var opcionJugador = leerElemento()

    //Asignando Elemento al Jugador
    var elementoJugador = generarElemento(opcionJugador)

    //Asignando Elemento a la Computadora
    var elementoComputadora = generarElemento(Random.nextInt(1,4))

    println("\n*******************************************************************************")

    println("\n/ Jugador: $elementoJugador /-- VS --/ Computadora: $elementoComputadora /")

    val resultado = if (elementoJugador == elementoComputadora) {
        "Empate"
    } else if ((elementoJugador == "Piedra" && elementoComputadora == "Tijera") ||
        (elementoJugador == "Papel" && elementoComputadora == "Piedra") ||
        (elementoJugador == "Tijera" && elementoComputadora == "Papel")) {
        "¡Ganaste!"
    } else {
        "¡Perdiste!"
    }

    println("\nResultado: $resultado")

    println("\n*******************************************************************************")
}
