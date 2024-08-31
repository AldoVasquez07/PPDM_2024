package Ejercicio3.Modelo

class Rectangulo(private val largo: Double, private val ancho: Double) : Shape() {
    override var area: Double = 0.0
    override var perimetro: Double = 0.0

    override fun calcularArea() {
        area = largo * ancho
    }

    override fun calcularPerimetro() {
        perimetro = 2 * (largo + ancho)
    }
}
