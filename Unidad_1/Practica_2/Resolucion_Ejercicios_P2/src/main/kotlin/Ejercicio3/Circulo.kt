package Ejercicio3

class Circulo(private val radio: Double) : Shape() {
    override var area: Double = 0.0
    override var perimetro: Double = 0.0

    override fun calcularArea() {
        area = Math.PI * radio * radio
    }

    override fun calcularPerimetro() {
        perimetro = 2 * Math.PI * radio
    }
}
