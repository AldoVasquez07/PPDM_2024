package Ejercicio2.Modelo

class Producto {
    private var nombre: String = ""
    private var precio: Double = 0.0
    private var descuento: Double = 0.0

    fun producto(nombre: String, precio: Double, descuento: Double){
        this.nombre = nombre
        this.precio = precio
        this.descuento = descuento
    }

    fun getNombre(): String{
        return this.nombre
    }

    fun setNombre(nombre: String){
        this.nombre = nombre
    }

    // Agregando metodo Get para el precio
    fun getPrecio(): Double{
        return this.precio
    }

    // Agregando metodo Set con restriccion para el precio
    fun setPrecio(precio: Double){
        if (precio >= 0) {
            this.precio = precio
        } else {
            println("-- El precio no puede ser negativo --")
        }
    }

    // Agregando metodo Get para el descuento
    fun getDescuento(): Double {
        return descuento
    }

    // Agregando metodo Set con restriccion para el descuento
    fun setDescuento(descuento: Double) {
        if (descuento in 0.0..100.0) {
            this.descuento = descuento
        } else {
            println("-- El descuento debe estar entre 0 y 100 --")
        }
    }

    // Funcion para calcular el precio descontado del producto
    fun precioDescontado(): Double {
        return this.precio * (1 - this.descuento / 100)
    }
}