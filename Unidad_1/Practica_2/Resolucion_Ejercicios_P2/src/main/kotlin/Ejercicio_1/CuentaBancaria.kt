package Ejercicio_1
import java.awt.geom.Arc2D
import java.time.LocalDateTime

class CuentaBancaria {
    var numero: String = ""
    var contrasena: String = ""
    var saldo: Double = 0.0
    var limite: Double = 0.0
    var montoRetirado: Double = 0.0
    var fechaCreacion: String = ""
    var estado: Boolean = true

    fun setSaldo(saldo: Double){
        this.saldo = saldo
    }

    fun getSaldo(): Double{
        return this.saldo
    }

    fun crearCuentaBancaria(){
        if (this.estado) {
            var utils = Utils()
            println("**** Creación de Cuenta ****")
            this.numero = utils.determinarLongitudCadena("Numero de cuenta: ", 10)
            print("Contraseña: ")
            this.contrasena = readln()
            setSaldo(utils.conversionNumero("Saldo: "))
            this.limite = utils.conversionNumero("Limite: ")
            this.fechaCreacion = LocalDateTime.now().toString()
            this.estado = false
        }
        else{
            println("-- Usted ya tiene una cuenta --")
        }
    }

    fun retiro(cantidad: Double){
        if (!this.estado) {
            if (montoRetirado + cantidad <= limite) {
                saldo -= cantidad
                montoRetirado += cantidad
                println("... Monto Retirado: $cantidad ...\n")
            } else {
                println("--Ya excedió el límite de su tarjeta--")
            }
        }
        else{
            println("-- Necesita Crear una Cuenta --")
        }
    }

    fun recargarSaldo(cantidad: Double){
        if(!this.estado) {
            this.saldo += cantidad
            println("... Monto: $cantidad Ingresado con exito ...\n")
        }
        else{
            println("-- Necesita Crear una Cuenta --")
        }
    }
}