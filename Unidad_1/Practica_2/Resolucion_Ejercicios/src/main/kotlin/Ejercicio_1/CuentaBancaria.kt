package Ejercicio_1

class CuentaBancaria {
    var numero: String = "0000 0000 0000 0000"
    var saldo: Double = 0.0
    var limite: Double = 0.0
    var tipo: String = "Normal"
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