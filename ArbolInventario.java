/**
 * Clase ArbolInventario
 *
 * Contiene la lógica del árbol binario de búsqueda.
 *
 * Permite:
 * - Insertar productos.
 * - Mostrar productos mediante recorrido inorden.
 * - Buscar productos por ID.
 */
public class ArbolInventario {

    // Raíz del árbol.
    Producto raiz;

    /**
     * Constructor del árbol.
     *
     * Inicialmente el árbol está vacío.
     */
    public ArbolInventario() {

        // No existe ningún nodo inicialmente.
        raiz = null;
    }

    /**
     * Inserta un nuevo producto en el árbol.
     *
     * @param id Identificador del producto.
     * @param nombre Nombre del producto.
     */
    public void insertar(int id, String nombre) {

        // Creamos el nuevo nodo.
        Producto nuevo = new Producto(id, nombre);

        /*
         * Si el árbol está vacío,
         * el nuevo producto se convierte en la raíz.
         */
        if (raiz == null) {

            raiz = nuevo;

        } else {

            /*
             * Si ya existe una raíz,
             * buscamos recursivamente dónde insertar.
             */
            raiz = insertarRecursivo(raiz, nuevo);
        }
    }

    /**
     * Método recursivo para insertar un producto.
     *
     * @param actual Nodo actual que estamos revisando.
     * @param nuevo Nuevo producto que queremos insertar.
     * @return Nodo actual.
     */
    private Producto insertarRecursivo(
            Producto actual,
            Producto nuevo) {

        /*
         * Si el nuevo ID es menor,
         * debemos ir hacia la izquierda.
         */
        if (nuevo.id < actual.id) {

            /*
             * Si no existe hijo izquierdo,
             * colocamos allí el nuevo producto.
             */
            if (actual.izquierdo == null) {

                actual.izquierdo = nuevo;

            } else {

                /*
                 * Si ya existe un nodo izquierdo,
                 * continuamos recorriendo esa rama.
                 */
                actual.izquierdo =
                        insertarRecursivo(
                                actual.izquierdo,
                                nuevo
                        );
            }

        /*
         * Si el nuevo ID es mayor,
         * debemos ir hacia la derecha.
         */
        } else if (nuevo.id > actual.id) {

            /*
             * Si no existe hijo derecho,
             * colocamos allí el nuevo producto.
             */
            if (actual.derecho == null) {

                actual.derecho = nuevo;

            } else {

                /*
                 * Si ya existe un nodo derecho,
                 * continuamos recorriendo esa rama.
                 */
                actual.derecho =
                        insertarRecursivo(
                                actual.derecho,
                                nuevo
                        );
            }
        }

        /*
         * Retornamos el nodo actual
         * para conservar la estructura del árbol.
         */
        return actual;
    }

    /**
     * Realiza un recorrido inorden.
     *
     * Orden:
     * izquierda -> nodo -> derecha
     *
     * @return No retorna información.
     */
    public void inorden() {

        // Comenzamos desde la raíz.
        inordenRecursivo(raiz);
    }

    /**
     * Método recursivo para recorrer el árbol.
     *
     * @param actual Nodo que estamos recorriendo.
     */
    private void inordenRecursivo(Producto actual) {

        /*
         * Si el nodo no es null,
         * podemos continuar el recorrido.
         */
        if (actual != null) {

            // Primero recorremos la izquierda.
            inordenRecursivo(actual.izquierdo);

            // Después mostramos el nodo actual.
            System.out.println(
                    "ID: " + actual.id
                    + " | Nombre: " + actual.nombre
            );

            // Finalmente recorremos la derecha.
            inordenRecursivo(actual.derecho);
        }
    }

    /**
     * Busca un producto mediante su ID.
     *
     * @param id ID que se desea buscar.
     * @return Producto encontrado o null.
     */
    public Producto buscar(int id) {

        // Comenzamos la búsqueda desde la raíz.
        return buscarRecursivo(raiz, id);
    }

    /**
     * Método recursivo para buscar un producto.
     *
     * @param actual Nodo actual.
     * @param id ID que buscamos.
     * @return Producto encontrado o null.
     */
    private Producto buscarRecursivo(
            Producto actual,
            int id) {

        /*
         * Si llegamos a null,
         * significa que el producto no existe.
         */
        if (actual == null) {

            return null;
        }

        /*
         * Si encontramos el ID,
         * retornamos el producto.
         */
        if (actual.id == id) {

            return actual;
        }

        /*
         * Si el ID buscado es menor,
         * buscamos hacia la izquierda.
         */
        if (id < actual.id) {

            return buscarRecursivo(
                    actual.izquierdo,
                    id
            );
        }

        /*
         * Si el ID buscado es mayor,
         * buscamos hacia la derecha.
         */
        return buscarRecursivo(
                actual.derecho,
                id
        );
    }
}