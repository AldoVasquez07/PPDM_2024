package Ejercicio3.Modelo

abstract class Shape {
    abstract var nombre: String
    abstract var area: Double
    abstract var perimetro: Double

    abstract fun calcularArea()
    abstract fun calcularPerimetro()

    fun imprimirArea() {
        println("Área: $area")
    }
    fun imprimirPerimetro(){
        println("Perímetro: $perimetro")
    }
}
