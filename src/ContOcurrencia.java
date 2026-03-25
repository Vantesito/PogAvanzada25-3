import java.util.HashMap;
import java.util.Map;

public class ContOcurrencia {

    // Recorre el arreglo cada vez que quiera contar
    public static int conteoLineal(int[] arreglo, int objetivo) {
        int contador = 0;
        for (int num : arreglo) {
            if (num == objetivo) {
                contador++;
            }
        }
        return contador;
    }
    // Creacion Diccionario
    public static Map<Integer, Integer> crearDiccionario(int[] arreglo) {
        Map<Integer, Integer> diccionario = new HashMap<>();
        for (int num : arreglo) {
            // Si el número ya existe, suma 1. Si no, lo inicializa en 1.
            diccionario.put(num, diccionario.getOrDefault(num, 0) + 1);
        }
        return diccionario;
    }

    // Buscar
    public static int conteoHash(Map<Integer, Integer> diccionario, int objetivo) {
        // Busca la llave, si no existe retorna 0
        return diccionario.getOrDefault(objetivo, 0);
    }
}