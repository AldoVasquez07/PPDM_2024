package Ejercicio_1

class Utils {
    fun conversionNumero(mensaje: String): Double{
        while(true) {
            // Imprimiendo mensaje pasado como parámetro
            print(mensaje)
            // Leyendo Número
            var numero = readln()

            try {
                // Realizando conversión a Double
                var num = numero.toDouble()
                if (num != null) {
                    if (num > 0) {
                        // Evitando nulos y valores menores o iguales a 0
                        return num
                    }
                    else{
                        // Imprimiendo caso de ingresar un numero <= 0
                        println("-- Debe Ingresar un número mayor a 0 --")
                    }
                } else {
                    // Imprimiendo en caso de no ingresar un numero
                    println("-- Debe ingresar un Numero --")
                }
            } catch (e: NumberFormatException) {
                // Imprimiendo caso de una conversión ERRONEA
                println("-- Debe ingresar un Numero Valido --")
            }
        }
    }

}