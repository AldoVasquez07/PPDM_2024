package Ejercicio4.Modelo

import Ejercicio4.Interfaces.IBiblioteca

// Clase que implementa la interfaz IBiblioteca
class Biblioteca : IBiblioteca {
    // Lista de materiales disponibles
    private val materialesDisponibles = mutableListOf<Material>()

    // Mapa de usuarios y sus materiales en préstamo
    private val usuarios = mutableMapOf<Usuario, MutableList<Material>>()

    // Registra un nuevo material en la biblioteca
    override fun registrarMaterial(material: Material) {
        materialesDisponibles.add(material)
        println("Material registrado: ${material.mostrarDetalles()}")
    }

    // Registra un nuevo usuario
    override fun registrarUsuario(usuario: Usuario) {
        usuarios.putIfAbsent(usuario, mutableListOf())
        println("Usuario registrado: $usuario")
    }

    // Realiza un préstamo de material a un usuario
    override fun prestamo(usuario: Usuario, material: Material): Boolean {
        if (materialesDisponibles.contains(material)) {
            materialesDisponibles.remove(material)
            usuarios[usuario]?.add(material)
            println("Préstamo realizado: ${material.mostrarDetalles()} a ${usuario.nombre} ${usuario.apellido}")
            return true
        }
        println("El material no está disponible para préstamo.")
        return false
    }

    // Realiza la devolución de un material
    override fun devolucion(usuario: Usuario, material: Material): Boolean {
        if (usuarios[usuario]?.contains(material) == true) {
            usuarios[usuario]?.remove(material)
            materialesDisponibles.add(material)
            println("Devolución realizada: ${material.mostrarDetalles()} de ${usuario.nombre} ${usuario.apellido}")
            return true
        }
        println("El usuario no tiene ese material en préstamo.")
        return false
    }

    // Devuelve la lista de materiales disponibles
    override fun mostrarMaterialesDisponibles(): List<Material> {
        return materialesDisponibles
    }

    // Muestra los materiales reservados por un usuario
    override fun mostrarMaterialesReservados(usuario: Usuario): List<Material> {
        return usuarios[usuario] ?: listOf()
    }
}