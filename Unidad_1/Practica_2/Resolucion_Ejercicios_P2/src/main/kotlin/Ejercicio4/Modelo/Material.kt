package Ejercicio4.Modelo

abstract class Material {
    abstract var titulo: String
    abstract var autor: String
    abstract var aniPublicacion: String

    abstract fun mostrarDetalles()
}