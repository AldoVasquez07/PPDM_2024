package Ejercicio_4

import kotlin.random.Random

fun leerNumero(): Int{
    //Se crea una variable que acepta nulos, por el caso de la conversión
    var numeroFinal: Int?

    while(true){
        //Leemos la puntuacion de manera explicita
        var numero = readln()

        // Generacion de try-catch en caso de una mala conversion
        try{
            //Realizando la conversion a entero
            numeroFinal = numero.toInt()

            //En caso de ser null, no se ha ingrasado un valor
            if (numeroFinal != null){
                //Preguntando si valor está de 0 a 30
                if (numeroFinal in 1..30){
                    return numeroFinal
                }
                else{
                    //En caso de que el numero esté por fuera del limite
                    println("--Debe ingresar una puntuacion desde 1 a 30--")
                }
            }
            else{
                //En caso de no haber ingresado un numero
                println("--Debe Igresar un numero--")
            }
        }
        catch(e: NumberFormatException){
            //Caso de no haber ingresado un valor numerico entero
            println("--Debe Ingresar un numero valido--")
        }
    }
}

fun gestionPartida(cantidad: Int, numeroAleatorio: Int){
    var cantidadIntentos = cantidad

    while (cantidadIntentos != 0){
        println("\n----------------------------------")
        print("Intentos: $cantidadIntentos\n")
        print("Adiva un numero: ")
        var numero = leerNumero()
        var pista: String? = ""
        if (numero > numeroAleatorio){
            pista = "- El numero es menor -"
        }
        else if (numero < numeroAleatorio){
            pista = "- El numero es mayor -"
        }
        else {
            print("=== ¡GANASTE! El numero es: $numero ===\n")
            return
        }

        println("Pista: ${pista}")
        cantidadIntentos--
    }
}

fun continuarPartida(): Boolean{
    val lista = listOf("Y", "n")
    while (true) {
        print("¿Desea Continuar? (Y/n): ")
        var opc = readln()
        if(opc in lista) {
            if (opc == lista[0]){
                return true
            }
            else{
                return false
            }
        } else {
            println("--Debe Ingresar una Opcion Valida--")
        }
    }
}

fun main(){
    val separador = "\n*********************************************"
    do{
        println(separador)
        gestionPartida(5, Random.nextInt(1,31))
        println(separador)
    } while (continuarPartida())
}