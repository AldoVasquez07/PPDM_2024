package Ejercicio4.Modelo

class Revista: Material() {
    // Sobre-Escribiendo aspectos de la clase Abstracta Material
    override var titulo: String = ""
    override var autor: String = ""
    override var anioPublicacion: String = ""
    override var tipo: String = "Tipo"
    override var estado: Boolean = true

    // Atributos propios de la clase
    var issn: String = ""
    var volumen: Int = 0
    var numero: Int = 0
    var editorial: String = ""


    // Generando función para determinar los valores de la clase
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

    // Mostrando los detalles de la clase
    override fun mostrarDetalles(){
        print("Titulo: ${this.titulo}. ")
        print("Autor: ${this.autor}. ")
        print("Año de Publicacion: ${this.anioPublicacion}. ")
        print("ISSN: ${this.issn}. ")
        print("Volumen: ${this.volumen}. ")
        print("Número: ${this.numero}. ")
        print("Editorial: ${this.editorial}. ")
    }
}