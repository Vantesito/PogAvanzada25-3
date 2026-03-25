public class Buscador {
    // Recorre elemento por elemento hasta encontrar el objetivo.
    public static int busquedaLineal(int[] arreglo, int objetivo) {
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == objetivo) {
                return i; // Retorna el índice donde lo encontró
            }
        }
        return -1; // No encontrado
    }

    // Asume que el arreglo ya está ordenado. Divide el problema a la mitad iterativamente.
    public static int busquedaBinaria(int[] arreglo, int objetivo) {
        int izquierda = 0;
        int derecha = arreglo.length - 1;

        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;

            if (arreglo[medio] == objetivo) {
                return medio; // Encontrado
            }
            if (arreglo[medio] < objetivo) {
                izquierda = medio + 1; // Buscar en la mitad derecha
            } else {
                derecha = medio - 1; // Buscar en la mitad izquierda
            }
        }
        return -1; // No encontrado
    }
}