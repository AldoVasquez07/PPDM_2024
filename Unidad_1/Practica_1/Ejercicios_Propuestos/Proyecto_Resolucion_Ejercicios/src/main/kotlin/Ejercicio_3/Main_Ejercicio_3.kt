package Ejercicio_3

fun main(){
    println("==== Menu ====")
    println("1. Suma")
    println("2. Resta")
    println("3. Multiplicacion")
    println("4. Division")
    println("5. Salir")

    print("\nSu opcion: ")
    var opcion = readln().toInt()

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