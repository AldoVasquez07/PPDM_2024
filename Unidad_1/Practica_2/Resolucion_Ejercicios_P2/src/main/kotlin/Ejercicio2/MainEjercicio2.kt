package Ejercicio2

fun generarMenu(){
    // Imprimiendo menú basico
    println("¡Bienvenido!")
    println("1. Listar Productos")
    println("2. Generar Producto")
    println("3. Editar Producto")
    println("4. Eliminar Producto")
    println("5. Salir")
}

fun main(){
    while(true){
        generarMenu()
        val opcion = readln().toInt()

        if (opcion == 5){
            return
        }
    }
}