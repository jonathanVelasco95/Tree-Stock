/**
 * Clase Producto
 *
 * Representa un nodo dentro del árbol binario de búsqueda.
 *
 * Cada producto contiene:
 * - Un ID que permite organizar los productos.
 * - Un nombre.
 * - Una referencia al producto de la izquierda.
 * - Una referencia al producto de la derecha.
 */
public class Producto {

    // Identificador único utilizado para ordenar y buscar el producto.
    int id;

    // Nombre del producto almacenado en el inventario.
    String nombre;

    /*
     * Referencia al nodo hijo izquierdo.
     *
     * En el árbol:
     * - Aquí se almacenan productos con un ID menor.
     */
    Producto izquierdo;

    /*
     * Referencia al nodo hijo derecho.
     *
     * En el árbol:
     * - Aquí se almacenan productos con un ID mayor.
     */
    Producto derecho;

    /**
     * Constructor de la clase Producto.
     *
     * Recibe el ID y el nombre del producto y
     * prepara las referencias izquierda y derecha.
     *
     * @param id Identificador del producto.
     * @param nombre Nombre del producto.
     */
    public Producto(int id, String nombre) {

        // Guardamos el ID recibido en el atributo del producto.
        this.id = id;

        // Guardamos el nombre recibido en el atributo del producto.
        this.nombre = nombre;

        /*
         * Al crear un producto todavía no tiene hijos.
         * Por eso ambas referencias comienzan en null.
         */
        this.izquierdo = null;
        this.derecho = null;
    }
}