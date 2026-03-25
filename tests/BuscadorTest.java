import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BuscadorTest {

    private final int[] datosOrdenados = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};

    @Test
    public void testBusquedaLineal() {
        // Debe encontrar el número 23 en el índice 5
        assertEquals(5, Buscador.busquedaLineal(datosOrdenados, 23));
        // No debe encontrar el número 100
        assertEquals(-1, Buscador.busquedaLineal(datosOrdenados, 100));
    }

    @Test
    public void testBusquedaBinaria() {
        // Debe encontrar el número 23 en el índice 5
        assertEquals(5, Buscador.busquedaBinaria(datosOrdenados, 23));
        // No debe encontrar el número 100
        assertEquals(-1, Buscador.busquedaBinaria(datosOrdenados, 100));
    }

    @Test
    public void testCasosBordeBusquedaLineal() {
        // Arreglo vacío
        int[] vacio = {};
        assertEquals(-1, Buscador.busquedaLineal(vacio, 10), "Debe retornar -1 si está vacío");

        // n = 1 (Elemento presente y no presente)
        int[] unElemento = {5};
        assertEquals(0, Buscador.busquedaLineal(unElemento, 5), "Debe encontrar el único elemento en índice 0");
        assertEquals(-1, Buscador.busquedaLineal(unElemento, 10), "No debe encontrar un elemento inexistente");

        // Elementos repetidos
        int[] repetidos = {2, 2, 2, 8, 8};
        assertEquals(0, Buscador.busquedaLineal(repetidos, 2), "La búsqueda lineal siempre encuentra la primera ocurrencia");
    }

    @Test
    public void testCasosBordeBusquedaBinaria() {
        // Arreglo vacío
        int[] vacio = {};
        assertEquals(-1, Buscador.busquedaBinaria(vacio, 10));

        //n = 1
        int[] unElemento = {5};
        assertEquals(0, Buscador.busquedaBinaria(unElemento, 5));
        assertEquals(-1, Buscador.busquedaBinaria(unElemento, 10));

        // Elementos repetidos
        int[] repetidos = {2, 2, 2, 8, 8};
        int resultado = Buscador.busquedaBinaria(repetidos, 2);
        assertTrue(resultado >= 0 && resultado <= 2, "Debe encontrar el número 2 en alguno de los índices válidos");
    }
}