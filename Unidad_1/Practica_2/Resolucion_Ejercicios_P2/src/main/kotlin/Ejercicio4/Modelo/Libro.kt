package Ejercicio4.Modelo

class Libro(titulo: String, autor: String, anioPublicacion: Int, var genero: String, var numeroPaginas: Int
) : Material(titulo, autor, anioPublicacion) {

    // Mostrando los detalles de la clase
    override fun mostrarDetalles(): String {
        return "Libro - Título: $titulo, Autor: $autor, Año: $anioPublicacion, Género: $genero, Páginas: $numeroPaginas"
    }
}