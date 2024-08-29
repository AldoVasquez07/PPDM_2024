package Ejercicio_1

class CuentaBancaria {
    var numero: String = ""
    var contrasena: String = ""
    var saldo: Double = 0.0
    var limite: Double = 0.0
    var fechaCreacion: String = "dd/mm/aaaa"

    fun retiro(cantidad: Double){
        if (cantidad <= limite) {
            saldo -= cantidad
        }
        else{
            println("Ya excedió el límite de su tarjeta")
        }
    }
}