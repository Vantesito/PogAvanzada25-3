import org.junit.jupiter.api.Test;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

public class ContOcurrenciaTest {

    // Arreglo de prueba con números repetidos
    private final int[] datos = {4, 2, 7, 4, 8, 4, 2, 9};

    @Test
    public void testConteoLineal() {
        // El número 4 aparece 3 veces
        assertEquals(3, ContOcurrencia.conteoLineal(datos, 4));
        // El número 2 aparece 2 veces
        assertEquals(2, ContOcurrencia.conteoLineal(datos, 2));
        // El número 100 no aparece
        assertEquals(0, ContOcurrencia.conteoLineal(datos, 100));
    }

    @Test
    public void testConteoHash() {
        // Primero preparamos el diccionario
        Map<Integer, Integer> diccionario = ContOcurrencia.crearDiccionario(datos);

        // Luego consultamos
        assertEquals(3, ContOcurrencia.conteoHash(diccionario, 4));
        assertEquals(2, ContOcurrencia.conteoHash(diccionario, 2));
        assertEquals(0, ContOcurrencia.conteoHash(diccionario, 100));
    }
    @Test
    public void testCasosBordeConteoLineal() {
        // Arreglo vacío
        int[] vacio = {};
        assertEquals(0, ContOcurrencia.conteoLineal(vacio, 5));

        // n = 1
        int[] unElemento = {10};
        assertEquals(1, ContOcurrencia.conteoLineal(unElemento, 10));
        assertEquals(0, ContOcurrencia.conteoLineal(unElemento, 5));

        // Todos los elementos son iguales
        int[] todosRepetidos = {7, 7, 7, 7, 7};
        assertEquals(5,ContOcurrencia.conteoLineal(todosRepetidos, 7));
    }

    @Test
    public void testCasosBordeConteoHash() {
        //Arreglo vacío
        int[] vacio = {};
        java.util.Map<Integer, Integer> dictVacio = ContOcurrencia.crearDiccionario(vacio);
        assertEquals(0, ContOcurrencia.conteoHash(dictVacio, 5));

        //n = 1
        int[] unElemento = {10};
        java.util.Map<Integer, Integer> dictUnElemento = ContOcurrencia.crearDiccionario(unElemento);
        assertEquals(1, ContOcurrencia.conteoHash(dictUnElemento, 10));
        assertEquals(0, ContOcurrencia.conteoHash(dictUnElemento, 5));

        //Todos los elementos son iguales
        int[] todosRepetidos = {7, 7, 7, 7, 7};
        java.util.Map<Integer, Integer> dictRepetidos = ContOcurrencia.crearDiccionario(todosRepetidos);
        assertEquals(5, ContOcurrencia.conteoHash(dictRepetidos, 7));
    }
}