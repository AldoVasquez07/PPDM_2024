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
                    println("Ingrese una opcion pertinente")
                }
            }
            else{
                println("Debe ingresar una opcion")
            }
        }
        catch (e: NumberFormatException){
            println("Ingrese un valor entero")
        }
    }
}

fun main(){
    var opcion = obtenerOpcionCalculadora()

    if (opcion == 5){
        return
    }

    var valor1 = readln().toDouble()
    var valor2 = readln().toDouble()

    var resultado = when(opcion){
        1 -> valor1 + valor2
        2 -> valor1 - valor2
        3 -> valor1 * valor2
        4 -> valor1 / valor2
        else -> 0
    }

    println("Resultado: $resultado")
}