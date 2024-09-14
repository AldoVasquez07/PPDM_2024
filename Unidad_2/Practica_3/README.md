# Práctica 3 - Programación para Dispositivos Móviles

Este repositorio contiene los ejercicios solicitados en la Práctica 3 del curso **Programación para Dispositivos Móviles**. Los ejercicios están resueltos utilizando el lenguaje de programación **Kotlin** y el entorno de desarrollo *Android Studio*.

## Estructura de la Práctica 3

- **Ejercicios_Propuestos**: Contiene la resolución de cada ejercicio solicitado.
- **Rubrica**: Contiene la auto-evaluación correspondiente a la práctica.
- **README.md**: Incluye el objetivo, estructura e instrucciones del repositorio.

## Instrucciones para Ejecutar los Ejercicios

1. **Clonar el repositorio** en su máquina local utilizando el siguiente comando:
    ```bash
    git clone https://github.com/AldoVasquez07/PPDM_2024.git
    ```
2. **Navegar** a la carpeta de los ejercicios propuestos:
    ```bash
    cd PPDM_2024/Unidad_2/Practica_3/Resolucion_Ejercicios
    ```
3. **Abrir el proyecto** `Ejercicio_1` o `Ejercicio_2` utilizando el IDE Android Studio.
4. Dentro de IntelliJ IDEA, **navegar** a:
    ```
    src/main/kotlin/
    ```
5. Seleccionar la carpeta correspondiente al ejercicio que se desea ejecutar (`Ejercicio_1`, `Ejercicio_2`, `Ejercicio_3`, `Ejercicio_4`).
6. Se debe tener en cuenta que, la estructura de cada carpeta es: (`Controlador`, `Modelo`, `Interface`) 
6. **Ejecutar** el código haciendo clic derecho en el archivo `Controlador/Main_Ejercicio_X.kt` y seleccionando `Run`.
7. **Observar los resultados** en la consola de salida.

## Estructura Detallada del Proyecto

```plaintext

PPDM_2024/
├── Ejercicios_Propuestos_P2/
│   ├── .idea/
│   ├── out/
│   ├── src/
│   │   ├── main/
│   │   │   └── kotlin/
│   │   │       ├── Ejercicio_1/
│   │   │       │   ├── Modelo/
│   │   │       │   │   ├── CuentaBancaria.kt
│   │   │       │   │   └── Utils.kt
│   │   │       │   └── Controlador/
│   │   │       │       └── MainEjercicio1.kt
│   │   │       ├── Ejercicio_2/
│   │   │       │   ├── Modelo/
│   │   │       │   │   ├── Producto.kt
│   │   │       │   │   └── Utils.kt
│   │   │       │   └── Controlador/
│   │   │       │       └── MainEjercicio2.kt
│   │   │       ├── Ejercicio_3/
│   │   │       │   ├── Modelo/
│   │   │       │   │   ├── Circulo.kt
│   │   │       │   │   ├── Cuadrado.kt
│   │   │       │   │   ├── Rectangulo.kt
│   │   │       │   │   └── Shape.kt
│   │   │       │   └── Controlador/
│   │   │       │       └── MainEjercicio3.kt
│   │   │       ├── Ejercicio_4/
│   │   │       │   ├── Interfaces/
│   │   │       │   │   └── IBiblioteca.kt
│   │   │       │   ├── Modelo/
│   │   │       │   │   ├── Biblioteca.kt
│   │   │       │   │   ├── Libro.kt
│   │   │       │   │   ├── Material.kt
│   │   │       │   │   ├── Revista.kt
│   │   │       │   │   └── Usuario.kt
│   │   │       │   └── Controlador/
│   │   │       │       └── MainEjercicio4.kt
│   ├── .gitignore
│   └── Resolucion_Ejercicios_P2.iml
├── Rubrica/
│   └── Rubrica_Practica_2.docx
└── README.md
