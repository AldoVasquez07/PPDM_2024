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
    var utils = Utils()
    while(true){
        // Mostrando Menu
        generarMenu()
        // Solicitando opcion
        val opcion = utils.conversionEntero("\nSu opcion: ", 0,5)

        if (opcion == 5){
            // Caso de selecionar la opcion de salir
            return
        }

    }
}