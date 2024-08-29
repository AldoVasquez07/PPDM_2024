package Ejercicio_1

class CuentaBancaria {
    var numero: String = ""
    var contrasena: String = ""
    var saldo: Double = 0.0
    var limite: Double = 0.0
    var montoRetirado: Double = 0.0
    var fechaCreacion: String = ""

    fun retiro(cantidad: Double){
        if (montoRetirado + cantidad <= limite) {
            saldo -= cantidad
            montoRetirado += cantidad
            println("Monto Retirado: $montoRetirado")
        }
        else{
            println("Ya excedió el límite de su tarjeta")
        }
    }
}