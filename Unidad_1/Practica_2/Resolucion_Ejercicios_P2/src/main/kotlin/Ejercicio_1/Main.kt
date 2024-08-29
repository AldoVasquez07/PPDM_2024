package Ejercicio_1

fun main() {
    val cuenta = CuentaBancaria()
    while(true){
        cuenta.retiro(readln().toDouble())
    }
}