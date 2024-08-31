package Ejercicio4.Modelo

abstract class Material {
    abstract var titulo: String
    abstract var autor: String
    abstract var anioPublicacion: String

    abstract fun mostrarDetalles()
}