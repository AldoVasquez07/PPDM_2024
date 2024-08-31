package Ejercicio4.Modelo

abstract class Material {
    // Generando Atributos Abstractos
    abstract var titulo: String
    abstract var autor: String
    abstract var anioPublicacion: String
    abstract var tipo: String
    abstract var estado: Boolean

    // Generando Funcion Abstracto
    abstract fun mostrarDetalles()
}