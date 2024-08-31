package Ejercicio4.Modelo

// Genarando la Clase Revista
class Revista(
    titulo: String, autor: String, anioPublicacion: Int, var issn: String, var volumen: Int, var numero: Int,
    var editorial: String) : Material(titulo, autor, anioPublicacion) {

    // Mostrando los detalles de la clase
    override fun mostrarDetalles(): String {
        return "Revista - Título: $titulo, Autor: $autor, Año: $anioPublicacion, ISSN: $issn, Volumen: $volumen," +
                "Número: $numero, Editorial: $editorial"
    }
}