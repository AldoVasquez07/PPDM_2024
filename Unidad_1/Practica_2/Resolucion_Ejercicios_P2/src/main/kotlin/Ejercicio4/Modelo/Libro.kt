package Ejercicio4.Modelo

class Libro: Material() {
    override var titulo: String = ""
    override var autor: String = ""
    override var anioPublicacion: String = ""
    var genero: String = ""
    var numeroPaginas: Int = 0

    fun libro(titulo: String, autor: String, anioPublicacion: String, genero: String, numeroPaginas: Int){
        this.titulo = titulo
        this.autor = autor
        this.anioPublicacion = anioPublicacion
        this.genero = genero
        this.numeroPaginas = numeroPaginas
    }

    override fun mostrarDetalles(){
        println("Titulo: ${this.titulo}")
        println("Autor: ${this.autor}")
        println("Año de Publicacion: ${this.anioPublicacion}")
        println("Genero: ${this.genero}")
        println("N° Paginas: ${this.numeroPaginas}")
    }
}