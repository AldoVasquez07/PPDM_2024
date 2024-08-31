package Ejercicio4.Modelo

class Libro: Material() {
    override var titulo: String = ""
    override var autor: String = ""
    override var aniPublicacion: String = ""
    var genero: String = ""
    var numeroPaginas: Int = 0

    override fun mostrarDetalles(){
        println("Titulo: ${this.titulo}")
        println("Autor: ${this.autor}")
        println("Año de Publicacion: ${this.aniPublicacion}")
        println("Genero: ${this.genero}")
        println("N° Paginas: ${this.numeroPaginas}")
    }
}