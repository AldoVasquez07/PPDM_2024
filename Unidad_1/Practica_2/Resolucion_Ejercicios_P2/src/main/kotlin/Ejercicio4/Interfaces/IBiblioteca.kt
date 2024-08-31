package Ejercicio4.Interfaces

import Ejercicio4.Modelo.Material
import Ejercicio4.Modelo.Usuario

// Interface Para Biblioteca
interface IBiblioteca{
    fun registrarMaterial(material: Material)
    fun registrarUsuario(usuario: Usuario)
    fun prestamo()
    fun devolucion()
    fun mostrarMaterialesDisponibles()
    fun mostrarMaterialesReservados()
}