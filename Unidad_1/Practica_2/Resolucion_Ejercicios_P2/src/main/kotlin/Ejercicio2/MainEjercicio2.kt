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

fun listarProductos(lista: MutableList<Producto>){
    lista.forEachIndexed { index, producto ->
        println("Producto ${index + 1}: Precio original = ${producto.getPrecio()}, Descuento = ${producto.getDescuento()}%, Precio final = ${producto.precioDescontado()}")
    }
}

fun main(){
    // Declarando Separador
    val separador = "************************************"
    // Instanciando la clase utils
    val utils = Utils()
    // Creando una Lista de Productos
    val listaProductos = mutableListOf<Producto>()

    while(true){
        println(separador)
        // Mostrando Menu
        generarMenu()
        // Solicitando opcion
        val opcion = utils.conversionEntero("\nSu opcion: ", 0,5)

        if (opcion == 5){
            // Caso de selecionar la opcion de salir
            return
        }
        println(separador)
    }
}