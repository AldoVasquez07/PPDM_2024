package Ejercicio_1
import java.time.LocalDateTime

class CuentaBancaria {
    var numero: String = ""
    var contrasena: String = ""
    var saldo: Double = 0.0
    var limite: Double = 0.0
    var montoRetirado: Double = 0.0
    var fechaCreacion: String = ""
    var estado: Boolean = true


    fun crearCuentaBancaria(){
        // Preguntado si la Cuenta Existe
        if (this.estado) {
            var utils = Utils()
            println("**** Creación de Cuenta ****")
            // Leyendo numero de la cuenta
            this.numero = utils.determinarLongitudCadena("Numero de cuenta: ", 10)
            // Ingresando Contraseña
            print("Contraseña: ")
            this.contrasena = readln()
            // Usando set del Saldo
            this.saldo = utils.conversionNumero("Saldo: ")
            // Asignando limite
            this.limite = utils.conversionNumero("Limite: ")
            // Usando librería de Java para el LocalDate
            this.fechaCreacion = LocalDateTime.now().toString()
            // Estableciendo estado para determinar que la cuenta esta creada
            this.estado = false
        }
        else{
            // Caso de tener una cuenta
            println("-- Usted ya tiene una cuenta --")
        }
    }

    fun retiro(cantidad: Double){
        // Consultando si hay una cuenta creada
        if (!this.estado) {
            // Consultando si lo que se va a retirar ha superado el limite
            if (montoRetirado + cantidad <= limite) {
                // Realizando Retiro
                saldo -= cantidad
                montoRetirado += cantidad
                println("... Monto Retirado: $cantidad ...\n")
            } else {
                // Caso de haber superado el limite
                println("--Ya excedió el límite de su tarjeta--")
            }
        }
        else{
            // Caso de no tener una cuenta
            println("-- Necesita Crear una Cuenta --")
        }
    }

    fun recargarSaldo(cantidad: Double){
        // Consultado si se tiene una cuenta
        if(!this.estado) {
            // Recargando el saldo de la cuenta
            this.saldo += cantidad
            println("... Monto: $cantidad Ingresado con exito ...\n")
        }
        else{
            // Caso de no tener cuenta
            println("-- Necesita Crear una Cuenta --")
        }
    }
}