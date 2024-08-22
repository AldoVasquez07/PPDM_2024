package Ejercicio_1

fun main() {
    // Solicitando la puntuacion, mediante una funcion que contiene un try-catch
    var puntuacion = readln().toInt()

    //Se está leyendo el sueldo de manera explicita
    var sueldo = readln().toDouble()

    // Haciendo el switch del tipo de puntuacion obtenida, segun el valor ingresado
    var tipo_puntuacion = when(puntuacion){
        in 0..3 -> "Inaceptable"
        in 4..6 -> "Aceptable"
        in 7..10 -> "Meritorio"
        else -> "error"
    }

    // Mostrando el tipo de puntuacion obtenida
    println("\nNivel de rendimiento: $tipo_puntuacion")
    // Realizando calculo del Dinero Recibido
    println("Cantidad de Dinero Recibido: ${sueldo * (puntuacion.toDouble()/10)}")
}