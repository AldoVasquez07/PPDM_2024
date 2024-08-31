package Ejercicio1.Controlador

import Ejercicio1.Modelo.CuentaBancaria
import Ejercicio1.Modelo.Utils

fun leerOpcion(): Int{
    print("\nSu opcion: ")
    // Generando Lista con opciones válidas
    val opcionesValidas = listOf("1", "2", "3", "4")
    while (true) {
        val opcion = readln()
        // Consultando si la opcion ingresada es válida
        if (opcion in opcionesValidas) {
            // Retornando valor
            return opcion.toInt()
        } else {
            // Imprimiendo caso de no ingresar una opcion valida
            println("-- Debe ingresar una Opcion Válida--")
        }
    }
}

fun mostrarMenu() {
    // Declarando separadores estaticos
    val separador = "*****************************"
    // Imprimiendo Menú
    println(separador)
    println("*** ¡Bienvenido al Banco! ***")
    println("$separador\n")
    println("<< Ingrese una opción >>")
    println("1. Crear Cuenta")
    println("2. Retirar")
    println("3. Recargar")
    println("4. Salir")
}

fun identificarOpcion(cuenta: CuentaBancaria, utils: Utils, opcion: Int){

    when (opcion){
        // Creando cuenta
        1 -> cuenta.crearCuentaBancaria()
        // Retirando saldo Cuenta
        2 -> cuenta.retiro(utils.conversionNumero("-> Ingrese la cantidad a Retirar: "))
        // Recargando Cuenta
        3 -> cuenta.recargarSaldo(utils.conversionNumero("-> Ingrese el saldo a Recargar: "))
    }
}

fun main() {
    // Instanciando Clases Vitales
    var cuenta = CuentaBancaria()
    var utils =  Utils()
    // Declarando separador
    val separador =  "//////////////////////////////////////////////////"

    // Menu Basico
    while (true) {
        println(separador)
        mostrarMenu()
        var opcion = leerOpcion()

        // Retornando en caso de salir del menu
        if (opcion == 4) {
            return
        }
        // Ejecutando acción establecida
        identificarOpcion(cuenta, utils, opcion)
        println(separador + "\n\n")
    }
}