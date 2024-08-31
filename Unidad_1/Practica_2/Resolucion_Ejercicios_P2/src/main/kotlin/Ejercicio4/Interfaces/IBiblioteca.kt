package Ejercicio4.Interfaces

import Ejercicio4.Modelo.Material
import Ejercicio4.Modelo.Usuario

// Interface Para Biblioteca
interface IBiblioteca {
    fun registrarMaterial(material: Material)
    fun registrarUsuario(usuario: Usuario)
    fun prestamo(usuario: Usuario, material: Material): Boolean
    fun devolucion(usuario: Usuario, material: Material): Boolean
    fun mostrarMaterialesDisponibles(): List<Material>
    fun mostrarMaterialesReservados(usuario: Usuario): List<Material>
}
