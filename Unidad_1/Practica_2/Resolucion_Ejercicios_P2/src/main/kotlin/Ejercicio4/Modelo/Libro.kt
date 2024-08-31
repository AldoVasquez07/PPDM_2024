package Ejercicio4.Modelo

class Libro: Material() {
    // Sobre-Escribiendo aspectos de la clase Abstracta Material
    override var titulo: String = ""
    override var autor: String = ""
    override var anioPublicacion: String = ""
    override var tipo: String = "Libro"
    override var estado: Boolean = true

    //Integrando Atributos propios
    var genero: String = ""
    var numeroPaginas: Int = 0

    // Generando función para determinar los valores de la clase
    fun libro(titulo: String, autor: String, anioPublicacion: String, genero: String, numeroPaginas: Int){
        this.titulo = titulo
        this.autor = autor
        this.anioPublicacion = anioPublicacion
        this.genero = genero
        this.numeroPaginas = numeroPaginas
    }

    // Mostrando los detalles de la clase
    override fun mostrarDetalles(){
        print("Titulo: ${this.titulo}. ")
        print("Autor: ${this.autor}. ")
        print("Año de Publicacion: ${this.anioPublicacion}. ")
        print("Genero: ${this.genero}. ")
        print("N° Paginas: ${this.numeroPaginas}")
    }
}