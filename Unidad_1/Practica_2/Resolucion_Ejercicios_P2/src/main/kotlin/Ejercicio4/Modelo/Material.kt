package Ejercicio4.Modelo

//Creando Clase Abstracta
abstract class Material(
    var titulo: String,
    var autor: String,
    var anioPublicacion: Int
) {
    abstract fun mostrarDetalles(): String
}