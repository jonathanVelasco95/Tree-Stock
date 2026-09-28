/**
 * Clase Main
 *
 * Contiene el método principal del programa
 * y el menú interactivo de Tree-Stock.
 *
 * Opciones:
 * 1. Registrar Producto
 * 2. Mostrar Inventario
 * 3. Buscar Producto
 * 0. Salir
 */

import java.util.Scanner;

public class Main {

    /**
     * Método principal del programa.
     */
    public static void main(String[] args) {

        // Permite leer información ingresada por teclado.
        Scanner scanner = new Scanner(System.in);

        // Creamos el árbol que almacenará los productos.
        ArbolInventario inventario =
                new ArbolInventario();

        // Variable para almacenar la opción seleccionada.
        int opcion;

        /*
         * El menú se repite hasta que el usuario
         * seleccione la opción 0.
         */
        do {

            System.out.println("\n===== TREE-STOCK =====");
            System.out.println("1. Registrar Producto");
            System.out.println("2. Mostrar Inventario");
            System.out.println("3. Buscar Producto");
            System.out.println("0. Salir");

            // Solicitamos una opción.
            System.out.print("Seleccione una opcion: ");

            // Leemos la opción.
            opcion = scanner.nextInt();

            // Consumimos el salto de línea pendiente.
            scanner.nextLine();

            /*
             * Ejecutamos una acción dependiendo
             * de la opción seleccionada.
             */
            switch (opcion) {

                // Registrar producto.
                case 1:

                    System.out.print(
                            "Ingrese el ID del producto: "
                    );

                    int id = scanner.nextInt();

                    // Consumimos el salto de línea.
                    scanner.nextLine();

                    System.out.print(
                            "Ingrese el nombre del producto: "
                    );

                    String nombre =
                            scanner.nextLine();

                    // Insertamos el producto en el árbol.
                    inventario.insertar(id, nombre);

                    System.out.println(
                            "Producto registrado correctamente."
                    );

                    break;

                // Mostrar inventario.
                case 2:

                    System.out.println(
                            "\n===== INVENTARIO ORDENADO ====="
                    );

                    /*
                     * Verificamos si el árbol está vacío.
                     */
                    if (inventario.raiz == null) {

                        System.out.println(
                                "El inventario esta vacio."
                        );

                    } else {

                        // Mostramos los productos ordenados.
                        inventario.inorden();
                    }

                    break;

                // Buscar producto.
                case 3:

                    System.out.print(
                            "Ingrese el ID que desea buscar: "
                    );

                    int idBuscar =
                            scanner.nextInt();

                    /*
                     * Buscamos el producto utilizando
                     * su ID.
                     */
                    Producto encontrado =
                            inventario.buscar(idBuscar);

                    /*
                     * Si encontramos el producto,
                     * mostramos sus datos.
                     */
                    if (encontrado != null) {

                        System.out.println(
                                "Producto encontrado: ID: "
                                + encontrado.id
                                + " | Nombre: "
                                + encontrado.nombre
                        );

                    } else {

                        System.out.println(
                                "Producto no encontrado."
                        );
                    }

                    break;

                // Salir.
                case 0:

                    System.out.println(
                            "Saliendo de Tree-Stock..."
                    );

                    break;

                // Opción diferente a las disponibles.
                default:

                    System.out.println(
                            "Opcion no valida."
                    );

                    break;
            }

        } while (opcion != 0);

        // Cerramos Scanner.
        scanner.close();
    }
}