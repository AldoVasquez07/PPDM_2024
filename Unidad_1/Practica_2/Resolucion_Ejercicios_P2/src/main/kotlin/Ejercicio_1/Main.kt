package Ejercicio_1

fun leerOpcion(): Int{
    // Generando Lista con opciones válidas
    val opcionesValidas = listOf("1", "2", "3", "4")
    while (true) {
        val opcion = readln()
        // Consultando si la opcion ingresada es válida
        if (opcion in opcionesValidas) {
            return opcion.toInt()
        } else {
            println("-- Debe ingresar una Opcion Válida--")
        }
    }
}

fun mostrarMenu(): Int{
    // Declarando separadores estaticos
    val separador1 =  "//////////////////////////////////////////////////"
    val separador2 = "*****************************"
    // Imprimiendo Menú
    println(separador1)
    println(separador2)
    println("*** ¡Bienvenido al Banco! ***")
    println("$separador2\n")
    println("<< Ingrese una opción >>")
    println("1. Crear Cuenta")
    println("2. Retirar")
    println("3. Recargar")
    println("4. Salir")

    return leerOpcion()
}


fun main() {
    val opcion = mostrarMenu()


}