package Ejercicio_3

fun obtenerOpcionCalculadora(): Int{
    var opcionCalculadora: Int?
    while (true) {
        // Estableciendo menú de la Calculadora
        println("==== Menu ====")
        println("1. Suma")
        println("2. Resta")
        println("3. Multiplicacion")
        println("4. Division")
        println("5. Salir")

        // Solicitando opcion a escoger
        print("\nSu opcion: ")
        var opcion = readln()

        //Abriendo try-catch para el manejo de excepciones con la conversion a entero
        try{
            opcionCalculadora = opcion.toInt()
            if (opcionCalculadora != null) {
                if (opcionCalculadora in 1..5){
                    return opcionCalculadora
                }
                else{
                    // Numero fuera del rango
                    println("--Ingrese una opcion pertinente--")
                }
            }
            else{
                // Se debe ingresar un valor no nulo
                println("--Debe ingresar una opcion--")
            }
        }
        catch (e: NumberFormatException){
            // Caso de no ingresar un numero y fallo de conversion
            println("--Ingrese un valor entero--")
        }
    }
}

fun leerValores(valor: String): Double{
    var valorOperacion: Double?
    while(true) {
        try {
            // Convirtiendo el valor a Double
            valorOperacion = valor.toDouble()
            if (valorOperacion != null) {
                return valorOperacion
            } else {
                // Caso de ingresar un valor nulo
                println("--Debe ingresar un valor--")
            }
        } catch (e: NumberFormatException) {
            // Error al convertir a Double
            println("--Ingrese un valor numerico--")
        }
    }
}

fun obtenerResultado(opcion: Int, valor1: Double, valor2: Double){
    // switch para determinar la acción según la opcion
    var resultado = when (opcion) {
        1 -> valor1 + valor2
        2 -> valor1 - valor2
        3 -> valor1 * valor2
        4 -> valor1 / valor2
        else -> 0
    }
    // Retornando el resultado de dicha accion
    println("\n____ Resultado: $resultado ____\n")
}

fun main() {
    while (true) {
        println("*************************************")
        // Mostrando Menú y obteniendo la opcion
        var opcion = obtenerOpcionCalculadora()

        // Finalizacion codigo si la opcion es 5
        if (opcion == 5) {
            return
        }
        // Preguntando por los valores
        print("\nValor: ")
        var valor1 = leerValores(readln())
        var valor2: Double

        // Condicional para evitar la division entre 0
        if (opcion != 4) {
            print("Valor: ")
            valor2 = leerValores(readln())
        } else {
            while (true) {
                print("Valor: ")
                valor2 = leerValores(readln())
                if (valor2 == 0.0) {
                    println("--No se puede dividir entre 0--")
                    println("--Ingrese nuevamente un valor--")
                } else {
                    break
                }
            }
        }
        // Mostrando el resultado
        obtenerResultado(opcion, valor1, valor2)
    }
}