package Ejercicio_3

fun obtenerOpcionCalculadora(): Int{
    var opcionCalculadora: Int?
    while (true) {
        println("==== Menu ====")
        println("1. Suma")
        println("2. Resta")
        println("3. Multiplicacion")
        println("4. Division")
        println("5. Salir")

        print("\nSu opcion: ")
        var opcion = readln()

        try{
            opcionCalculadora = opcion.toInt()
            if (opcionCalculadora != null) {
                if (opcionCalculadora in 1..5){
                    return opcionCalculadora
                }
                else{
                    println("--Ingrese una opcion pertinente--")
                }
            }
            else{
                println("--Debe ingresar una opcion--")
            }
        }
        catch (e: NumberFormatException){
            println("Ingrese un valor entero")
        }
    }
}

fun leerValores(valor: String): Double{
    var valorOperacion: Double?
    while(true) {
        try {
            valorOperacion = valor.toDouble()
            if (valorOperacion != null) {
                return valorOperacion
            } else {
                println("--Debe ingresar un valor--")
            }
        } catch (e: NumberFormatException) {
            println("--Ingrese un valor numerico--")
        }
    }
}

fun obtenerResultado(opcion: Int, valor1: Double, valor2: Double){
    var resultado = when (opcion) {
        1 -> valor1 + valor2
        2 -> valor1 - valor2
        3 -> valor1 * valor2
        4 -> valor1 / valor2
        else -> 0
    }

    println("\nResultado: $resultado")
}

fun main() {
    while (true) {
        var opcion = obtenerOpcionCalculadora()

        if (opcion == 5) {
            return
        }
        print("\nValor: ")
        var valor1 = leerValores(readln())
        var valor2: Double

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
        obtenerResultado(opcion, valor1, valor2)
    }
}