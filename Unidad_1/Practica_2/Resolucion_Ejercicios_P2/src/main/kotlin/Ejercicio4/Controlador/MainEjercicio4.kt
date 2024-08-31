package Ejercicio4.Controlador

import Ejercicio4.Modelo.*
import Ejercicio4.Interfaces.IBiblioteca

val utils = Utils()
val separador = "****************************************************"
val separador2 = "..................................................."

fun mostrarMenu() {
    // Mostrando Menu
    println("¡Bienvenido al Sistema de Gestión de Biblioteca!")
    println("Elija una opción:")
    println("1. Registrar Material")
    println("2. Registrar Usuario")
    println("3. Realizar Préstamo")
    println("4. Realizar Devolución")
    println("5. Mostrar Materiales Disponibles")
    println("6. Mostrar Materiales Reservados por Usuario")
    println("7. Salir")
}

fun generarLibro(): Libro {
    // Generando Instancia de la clase Libro
    val titulo = utils.leerCadena("Título del libro: ")
    val autor = utils.leerCadena("Autor del libro: ")
    val anio = utils.conversionEntero("Año de publicación: ", 1000, 2100)
    val genero = utils.leerCadena("Género del libro: ")
    val paginas = utils.conversionEntero("Número de páginas: ", 1, 10000)
    return Libro(titulo, autor, anio, genero, paginas)
}

fun generarRevista(): Revista {
    // Generando Instancia de la clase Revista
    val titulo = utils.leerCadena("Título de la revista: ")
    val autor = utils.leerCadena("Autor de la revista: ")
    val anio = utils.conversionEntero("Año de publicación: ", 1000, 2100)
    val issn = utils.leerCadena("ISSN de la revista: ")
    val volumen = utils.conversionEntero("Volumen de la revista: ", 1, 100)
    val numero = utils.conversionEntero("Número de la revista: ", 1, 1000)
    val editorial = utils.leerCadena("Editorial de la revista: ")
    return Revista(titulo, autor, anio, issn, volumen, numero, editorial)
}

fun registrarMaterial(biblioteca: IBiblioteca) {
    // Generando Sub Menu
    println("\n" + separador2)
    println("Seleccione el tipo de material a registrar:")
    println("1. Libro")
    println("2. Revista")
    //Leyendo opcion establecida
    val opcion = utils.conversionEntero("Opción: ", 1, 2)
    // Determinando que instancia generar
    val material = when (opcion) {
        1 -> generarLibro()
        2 -> generarRevista()
        else -> null
    }
    // Haciendo el Registro solo si el Material no es nulo
    material?.let {
        biblioteca.registrarMaterial(it)
    }
}

fun registrarUsuario(biblioteca: IBiblioteca) {
    // Registrando Usuario en el Map
    val nombre = utils.leerCadena("Nombre del usuario: ")
    val apellido = utils.leerCadena("Apellido del usuario: ")
    val edad = utils.conversionEntero("Edad del usuario: ", 0, 120)
    val usuario = Usuario(nombre, apellido, edad)
    biblioteca.registrarUsuario(usuario)
}

fun realizarPrestamo(biblioteca: IBiblioteca) {
    // Pidiendo datos del Usuario para realizar el prestamo
    val nombre = utils.leerCadena("Nombre del usuario: ")
    val apellido = utils.leerCadena("Apellido del usuario: ")
    val usuario = Usuario(nombre, apellido, 0)

    // Pidiendo datos del Libro para realizar el prestamo
    val titulo = utils.leerCadena("Título del material a prestar: ")
    // Buscando Material en el Map
    val material = biblioteca.mostrarMaterialesDisponibles().find { it.titulo == titulo }


    if (material != null) {
        if (biblioteca.prestamo(usuario, material)) {
            // Prestamo completado
            println("Préstamo realizado con éxito.")
        } else {
            // Caso de NO registrar el prestamo
            println("-- Error en el préstamo --")
        }
    } else {
        // Caso de que el material no se encuentre
        println("-- Material no encontrado --")
    }
}

fun realizarDevolucion(biblioteca: IBiblioteca) {
    // Pidiendo datos del Usuario para realizar la devolucion
    val nombre = utils.leerCadena("Nombre del usuario: ")
    val apellido = utils.leerCadena("Apellido del usuario: ")
    val usuario = Usuario(nombre, apellido, 0)

    // Pidiendo datos del Libro para realizar la devolucion
    val titulo = utils.leerCadena("Título del material a devolver: ")
    // Buscando Material en el Map
    val material = biblioteca.mostrarMaterialesReservados(usuario).find { it.titulo == titulo }


    if (material != null) {
        if (biblioteca.devolucion(usuario, material)) {
            // Devolucion completado
            println("... Devolución realizada con éxito ...")
        } else {
            // Caso de NO registrar la devolucion
            println("-- Error en la devolución --")
        }
    } else {
        // Caso de que el material no se encuentre
        println("-- Material no encontrado o no está reservado por este usuario --")
    }
}

fun mostrarMaterialesDisponibles(biblioteca: IBiblioteca) {
    // Realizando ForEach para los Materiales Disponibles
    println("Materiales disponibles:")
    biblioteca.mostrarMaterialesDisponibles().forEach {
        println(it.mostrarDetalles())
    }
}

fun mostrarMaterialesReservados(biblioteca: IBiblioteca) {
    val nombre = utils.leerCadena("Nombre del usuario: ")
    val apellido = utils.leerCadena("Apellido del usuario: ")
    val usuario = Usuario(nombre, apellido, 0)
    println("Materiales reservados por ${usuario.nombre} ${usuario.apellido}:")
    // Realizando ForEach para los Materiales Reservados
    biblioteca.mostrarMaterialesReservados(usuario).forEach {
        println(it.mostrarDetalles())
    }
}

fun main() {
    val biblioteca = Biblioteca()
    // Gestionando Menu
    while (true) {
        println("\n\n" + separador)
        mostrarMenu()
        val opcion = utils.conversionEntero("\nSu opción: ", 1, 7)
        when (opcion) {
            1 -> registrarMaterial(biblioteca)
            2 -> registrarUsuario(biblioteca)
            3 -> realizarPrestamo(biblioteca)
            4 -> realizarDevolucion(biblioteca)
            5 -> mostrarMaterialesDisponibles(biblioteca)
            6 -> mostrarMaterialesReservados(biblioteca)
            7 -> return
            else -> println("-- Opción no válida --")
        }
    }
}
