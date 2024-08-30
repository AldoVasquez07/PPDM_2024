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

fun editarProducto(lista: MutableList<Producto>, index: Int, utils: Utils) {
    if (index < 0 || index >= lista.size) {
        println("Índice fuera de rango.")
        return
    }

    val producto = lista[index]

    println("*** Editando Producto ***")
    println("Producto actual: Nombre = ${producto.getNombre()}, Precio = ${producto.getPrecio()}, Descuento = ${producto.getDescuento()}%")

    print("Nuevo nombre (dejar en blanco para no cambiar): ")
    val nuevoNombre = readln().takeIf { it.isNotBlank() }
    if (nuevoNombre != null) {
        producto.setNombre(nuevoNombre)
    }

    val nuevoPrecio = utils.conversionDecimal("Nuevo precio (dejar en blanco para no cambiar): ", 0.0, 10000.0)
    if (nuevoPrecio != null) {
        producto.setPrecio(nuevoPrecio)
    }

    val nuevoDescuento = utils.conversionDecimal("Nuevo descuento (dejar en blanco para no cambiar): ", 0.0, 100.0)
    if (nuevoDescuento != null) {
        producto.setDescuento(nuevoDescuento)
    }

    println("Producto editado: Nombre = ${producto.getNombre()}, Precio = ${producto.getPrecio()}, Descuento = ${producto.getDescuento()}%")
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