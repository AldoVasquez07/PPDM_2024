package Ejercicio4.Modelo

import Ejercicio4.Interfaces.IBiblioteca

// Implementando Interface
class Biblioteca: IBiblioteca {
    // Generando listas para determinar los aspectos de la biblioteca
    var usuarios: MutableList<Usuario> = mutableListOf()
    var materiales: MutableList<Material> = mutableListOf()

    override fun registrarMaterial(){
        

    }
    override fun registrarUsuario(){

    }
    override fun prestamo(){

    }
    override fun devolucion(){

    }
    override fun mostrarMaterialesDisponibles(){

    }
    override fun mostrarMaterialesReservados(){

    }
}