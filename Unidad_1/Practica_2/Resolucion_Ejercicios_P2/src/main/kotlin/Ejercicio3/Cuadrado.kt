package Ejercicio3

class Cuadrado(private val lado: Double): Shape() {
    override var area: Double = 0.0
    override var perimetro: Double = 0.0

    override fun calcularArea() {
        area = lado * lado
    }

    override fun calcularPerimetro() {
        perimetro = 4 * lado
    }
}
