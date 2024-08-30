package Ejercicio2

class Utils {
    fun conversionEntero(mensaje: String, limiteInferior: Int, limiteSuperior: Int): Int{
        while (true) {
            // Imprimiendo mensaje pasado por parametro
            print(mensaje)
            // Leyendo opcion
            var num = readln()
            try {
                // Realizando conversión a entero
                var numero = num.toInt()
                if (numero != null){
                    if (numero >= limiteInferior && numero <= limiteSuperior) {
                        // Retornando si el numero está dentro de las opciones
                        return numero
                    }
                    else{
                        // Caso de no ingresar una opcion dentro del limite
                        println("-- Ingrese una opcion valida --")
                    }
                }
                else{
                    // En caso de que al convertir sea nulo
                    println("-- Debe ingresar una opcion --")
                }
            } catch (e: NumberFormatException) {
                // Caso de error en la conversion a entero
                println("-- Debe ingresar un numero --")
            }
        }
    }
}