package Ejercicio4.Modelo

import Ejercicio4.Interfaces.IBiblioteca

// Implementando Interface
class Biblioteca: IBiblioteca {
    // Generando listas para determinar los aspectos de la biblioteca
    var usuarios: MutableList<Usuario> = mutableListOf()
    var materiales: MutableList<Material> = mutableListOf()
    var util = Utils()

    override fun registrarMaterial(material: Material){
        println("... Registrando Material ...")
        materiales.add(material)
    }
    override fun registrarUsuario(usuario: Usuario){
        println("... Registrando Usuario ...")
        usuarios.add(usuario)
    }
    override fun prestamo(){
        mostrarMaterialesDisponibles()
        val index = this.util.conversionEntero("Pedir Prestado: ", 1, this.materiales.size)
        materiales[index].estado = false
    }
    override fun devolucion(){
        mostrarMaterialesReservados()
        val index = this.util.conversionEntero("Devolver: ", 1, this.materiales.size)
        materiales[index].estado = true
    }
    override fun mostrarMaterialesDisponibles(){
        this.materiales.forEachIndexed { index, material ->
            if(material.estado) {
                println("${index + 1}) Tipo: ${material.tipo}. ${material.mostrarDetalles()}")
            }
        }
    }
    override fun mostrarMaterialesReservados(){
        this.materiales.forEachIndexed { index, material ->
            if(!material.estado) {
                println("${index + 1}) Tipo: ${material.tipo}. ${material.mostrarDetalles()}")
            }
        }
    }
}