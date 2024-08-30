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
    println("*** Listando Productos ***")
    lista.forEachIndexed { index, producto ->
        println("Producto ${index + 1}: Precio original = ${producto.getPrecio()}, Descuento = ${producto.getDescuento()}%, Precio final = ${producto.precioDescontado()}")
    }
}

fun generarProducto(lista: MutableList<Producto>, utils: Utils) {
    println("*** Creando Producto ***")
    print("Nombre: ")
    val nombre = readln()  // Leyendo el nombre del producto

    // Solicita y convierte los valores de precio y descuento
    val precio = utils.conversionDecimal("Precio: ", 0.0, 10000.0)
    val descuento = utils.conversionDecimal("Descuento: ", 0.0, 100.0)

    // Crea un nuevo producto y establece sus propiedades
    val producto = Producto().apply {
        setNombre(nombre)
        setPrecio(precio)
        setDescuento(descuento)
    }

    // Agregando el producto a la lista
    lista.add(producto)
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
        val opcion = utils.conversionEntero("\n|-> Su opcion: ", 0,5)

        if (opcion == 5){
            // Caso de selecionar la opcion de salir
            return
        }
        println(separador)
    }
}