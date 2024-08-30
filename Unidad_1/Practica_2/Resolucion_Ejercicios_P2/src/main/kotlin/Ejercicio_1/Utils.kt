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

    fun determinarLongitudCadena(mensaje: String, longitud: Int): String{
        while (true) {
            // Imprimiendo mensaje pasado por parametro
            print(mensaje)
            // Leyendo cadena establecida
            var cadena = readln()

            if (cadena.length == longitud) {
                // Retornando cadena con longitud especifica
                return cadena
            } else {
                // Imprimiendo caso de ingresar una cadena con mayor o menor longitud
                println("-- Se deben ingresar $longitud caracteres --")
            }
        }
    }

}