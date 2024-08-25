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
        println("5. Limpiar Acumulado")
        println("6. Salir")

        // Solicitando opcion a escoger
        print("\nSu opcion: ")
        var opcion = readln()

        //Abriendo try-catch para el manejo de excepciones con la conversion a entero
        try{
            opcionCalculadora = opcion.toInt()
            if (opcionCalculadora != null) {
                if (opcionCalculadora in 1..6){
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

fun obtenerResultado(opcion: Int, valor1: Double, valor2: Double): Double{
    // switch para determinar la acción según la opcion
    var resultado = when (opcion) {
        1 -> "${valor1 + valor2}"
        2 -> "${valor1 - valor2}"
        3 -> "${valor1 * valor2}"
        4 -> "${valor1 / valor2}"
        else -> "Error!"
    }
    // Retornando el resultado de dicha accion
    println("\n____ Resultado: $resultado ____\n")
    return resultado.toDouble()
}


fun evitarDivisionPorCero(opcion: Int): Double {
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
    return valor2
}


fun main() {
    var valor1: Double
    var acumulador: Double = 0.0
    var contador: Int = 0
    while (true) {
        println("*************************************")
        println("Acumulador: $acumulador")
        // Mostrando Menú y obteniendo la opcion
        var opcion = obtenerOpcionCalculadora()

        // Finalizacion codigo si la opcion es 5
        if (opcion == 6) {
            return
        }

        if (opcion == 5) {
            acumulador = 0.0
            contador = 0
        }
        else {
            // Preguntando por los valores

            if (contador == 0) {
                print("\nValor: ")
                valor1 = leerValores(readln())
            }
            else{
                valor1 = acumulador
            }
            var valor2 = evitarDivisionPorCero(opcion)

            // Mostrando el resultado
            acumulador = obtenerResultado(opcion, valor1, valor2)
        }
        contador++
    }
}