package Ejercicio_4

import kotlin.random.Random

fun main(){
    var cantidadIntentos = 5
    val numeroAleatorio = Random.nextInt(1,31)
    while (cantidadIntentos != 0){
        print("\rIntentos: $cantidadIntentos\n")
        print("\rAdiva un numero: ")
        var numero = readln().toInt()
        var pista: String? = ""
        if (numero > numeroAleatorio){
            pista = "El numero es menor"
        }
        else if (numero < numeroAleatorio){
            pista = "El numero es mayor"
        }
        else {
            print("\r¡GANASTE! El numero es: $numero")
        }

        println("\rPista: ${pista}")
        cantidadIntentos--
    }
}