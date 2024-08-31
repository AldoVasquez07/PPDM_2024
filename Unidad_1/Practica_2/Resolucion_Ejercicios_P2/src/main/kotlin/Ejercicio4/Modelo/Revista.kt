package Ejercicio4.Modelo

class Revista: Material() {
    override var titulo: String = ""
    override var autor: String = ""
    override var anioPublicacion: String = ""
    var issn: String = ""
    var volumen: Int = 0
    var numero: Int = 0
    var editorial: String = ""

    fun libro(titulo: String, autor: String, anioPublicacion: String, issn: String, volumen: Int,
              numero: Int, editorial: String){
        this.titulo = titulo
        this.autor = autor
        this.anioPublicacion = anioPublicacion
        this.issn = issn
        this.volumen = volumen
        this.numero = numero
        this.editorial = editorial
    }

    override fun mostrarDetalles(){
        println("Titulo: ${this.titulo}")
        println("Autor: ${this.autor}")
        println("Año de Publicacion: ${this.anioPublicacion}")
        println("ISSN: ${this.issn}")
        println("Volumen: ${this.volumen}")
        println("Número: ${this.numero}")
        println("Editorial: ${this.editorial}")
    }
}