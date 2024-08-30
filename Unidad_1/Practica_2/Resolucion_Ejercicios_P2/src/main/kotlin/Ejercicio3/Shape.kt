package Ejercicio3

abstract class Shape {
    abstract var area: Double
    abstract var perimetro: Double

    abstract fun calcularArea()
    abstract fun calcularPerimetro()

    fun imprimirResultados() {
        println("Área: $area")
        println("Perímetro: $perimetro")
    }
}
