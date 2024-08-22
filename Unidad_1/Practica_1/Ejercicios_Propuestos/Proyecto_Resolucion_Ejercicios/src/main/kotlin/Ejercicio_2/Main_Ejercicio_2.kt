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

fun mostrarResultadoPartida(elementoJugador: String, elementoComputadora: String){

    // Creando una variable separador de tipo constante
    val separador = "\n" +
            "****************************************************************"

    println(separador)

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

    println(separador)
}

fun continuarPartida(): Boolean{
    // Lista con los dos valores posibles
    val lista = listOf("Y", "n")
    while (true) {
        //recibiendo respuesta
        print("¿Desea Continuar? (Y/n): ")
        var opc = readln()
        // consultado si la opcion selecionada está en la lista
        if(opc in lista) {
            if (opc == lista[0]){
                // caso de Y
                return true
            }
            else{
                // caso de n
                return false
            }
        } else {
            //Caso de que la opcion no esté en la lista
            println("--Debe Ingresar una Opcion Valida--")
        }
    }
}

fun main() {
    val separador = "\n" +
            "///////////////////////////////////////////////////\n"

    do {
        println(separador)

        var opcionJugador = leerElemento()

        //Asignando Elemento al Jugador
        var elementoJugador = generarElemento(opcionJugador)

        //Asignando Elemento a la Computadora mediante un numero Aleatorio de 1 a 3
        var elementoComputadora = generarElemento(Random.nextInt(1, 4))

        //Mostrando los Resultados de la partida
        mostrarResultadoPartida(elementoJugador, elementoComputadora)

        println(separador)
    } while(continuarPartida())
}
