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
    // Reasignando variable para hacer el decremento de intentos
    var cantidadIntentos = cantidad

    // Repitiendo por la cantidad de intentos
    while (cantidadIntentos != 0){
        println("\n----------------------------------")
        print("Intentos: $cantidadIntentos\n")
        print("Adiva un numero: ")
        var numero = leerNumero()
        var pista: String? = ""
        // Preguntando por el tamaño del numero
        if (numero > numeroAleatorio){
            // Caso de que sea menor al ingresado
            pista = "- El numero es menor -"
        }
        else if (numero < numeroAleatorio){
            // Caso de que sea mayor al ingresado
            pista = "- El numero es mayor -"
        }
        else {
            // Caso de que acertar el numero
            print("=== ¡GANASTE! El numero es: $numero ===\n")
            return
        }
        // Imprimiendo el caso como pista
        println("Pista: ${pista}")
        cantidadIntentos--
    }
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

fun main(){
    val separador = "\n*********************************************"
    // Bucle para poder jugar más veces
    do{
        println(separador)
        gestionPartida(5, Random.nextInt(1,31))
        println(separador)
    } while (continuarPartida())
}