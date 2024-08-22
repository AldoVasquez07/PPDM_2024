package Ejercicio_1

fun leerPuntuacion(): Int{
    //Se crea una variable que acepta nulos, por el caso de la conversión
    var puntuacion: Int?

    while(true){
        //Leemos la puntuacion de manera explicita
        print("Ingrese su Puntuacion: ")
        var numero = readln()

        // Generacion de try-catch en caso de una mala conversion
        try{
            //Realizando la conversion a entero
            puntuacion = numero.toInt()

            //En caso de ser null, no se ha ingrasado un valor
            if (puntuacion != null){
                //Preguntando si valor está de 0 a 10
                if (puntuacion in 0..10){
                    return puntuacion
                }
                else{
                    //En caso de que el numero esté por fuera del limite
                    println("--Debe ingresar una puntuacion desde 0 a 10--")
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

fun main() {
    // Solicitando la puntuacion, mediante una funcion que contiene un try-catch
    var puntuacion = leerPuntuacion()

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