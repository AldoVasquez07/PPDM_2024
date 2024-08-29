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

fun main() {
    println("*** ¡Bienvenido al Banco! ***")
    println("<< Ingrese una opción >>")
    println("1. Crear Cuenta")
    println("2. Retirar")
    println("3. Recargar")
    println("4. Salir")

    val opcion = leerOpcion()
}