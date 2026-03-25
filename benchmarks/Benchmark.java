import java.util.Arrays;
import java.util.Map;
import java.util.Random;

public class Benchmark {

    private static final int[] TAMANOS = {10_000, 50_000, 100_000, 500_000, 1_000_000};
    private static final int REPETICIONES = 20;

    public static void main(String[] args) {
        // (Warm-up)
        calentarJVM();

        // medición real
        System.out.println("Iniciando Benchmarks reales...\n");
        ejecutarBenchmarkBusqueda();
        System.out.println("--------------------------------------------------\n");
        ejecutarBenchmarkConteo();
    }
    private static void calentarJVM() {
        System.out.println("Calentando la Máquina Virtual de Java (JIT Compiler)...");
        int n = 50_000;
        int[] datos = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            datos[i] = random.nextInt(n);
        }
        Arrays.sort(datos);
        Map<Integer, Integer> diccionario = ContOcurrencia.crearDiccionario(datos);

        // Ejecutamos los métodos 10,000 veces sin medir el tiempo para que Java los optimice
        for (int i = 0; i < 10_000; i++) {
            Buscador.busquedaLineal(datos, -1);
            Buscador.busquedaBinaria(datos, -1);
            ContOcurrencia.conteoLineal(datos, -1);
            ContOcurrencia.conteoHash(diccionario, -1);
        }
        System.out.println("¡Calentamiento terminado!\n");
    }

    private static void ejecutarBenchmarkBusqueda() {
        System.out.println("=== BENCHMARK: BÚSQUEDA (Lineal vs Binaria) ===");
        System.out.printf("%-12s | %-20s | %-20s%n", "Tamaño (N)", "Lineal (Mediana ns)", "Binaria (Mediana ns)");
        System.out.println("-------------------------------------------------------------");

        Random random = new Random();

        for (int n : TAMANOS) {
            int[] datos = new int[n];
            for (int i = 0; i < n; i++) {
                datos[i] = random.nextInt(n);
            }
            Arrays.sort(datos); // Preparación separada

            int objetivo = -1; // Peor caso

            long[] tiemposLineal = new long[REPETICIONES];
            long[] tiemposBinaria = new long[REPETICIONES];

            for (int i = 0; i < REPETICIONES; i++) {
                // Medir Lineal
                long inicioLineal = System.nanoTime();
                Buscador.busquedaLineal(datos, objetivo);
                long finLineal = System.nanoTime();
                tiemposLineal[i] = finLineal - inicioLineal;

                // Medir Binaria
                long inicioBinaria = System.nanoTime();
                Buscador.busquedaBinaria(datos, objetivo);
                long finBinaria = System.nanoTime();
                tiemposBinaria[i] = finBinaria - inicioBinaria;
            }

            System.out.printf("%-12d | %-20.0f | %-20.0f%n",
                    n, calcularMediana(tiemposLineal), calcularMediana(tiemposBinaria));
        }
    }

    private static void ejecutarBenchmarkConteo() {
        System.out.println("=== BENCHMARK: CONTEO (Lineal vs Hash) ===");
        System.out.printf("%-12s | %-20s | %-20s%n", "Tamaño (N)", "Lineal (Mediana ns)", "Hash (Mediana ns)");
        System.out.println("-------------------------------------------------------------");

        Random random = new Random();

        for (int n : TAMANOS) {
            int[] datos = new int[n];
            for (int i = 0; i < n; i++) {
                datos[i] = random.nextInt(n / 10 + 1);
            }
            int objetivo = datos[random.nextInt(n)];

            // Preparación separada
            Map<Integer, Integer> diccionario = ContOcurrencia.crearDiccionario(datos);

            long[] tiemposLineal = new long[REPETICIONES];
            long[] tiemposHash = new long[REPETICIONES];

            for (int i = 0; i < REPETICIONES; i++) {
                // Medir Lineal
                long inicioLineal = System.nanoTime();
                ContOcurrencia.conteoLineal(datos, objetivo);
                long finLineal = System.nanoTime();
                tiemposLineal[i] = finLineal - inicioLineal;

                // Medir Hash
                long inicioHash = System.nanoTime();
                ContOcurrencia.conteoHash(diccionario, objetivo);
                long finHash = System.nanoTime();
                tiemposHash[i] = finHash - inicioHash;
            }

            System.out.printf("%-12d | %-20.0f | %-20.0f%n",
                    n, calcularMediana(tiemposLineal), calcularMediana(tiemposHash));
        }
    }

    private static double calcularMediana(long[] tiempos) {
        Arrays.sort(tiempos);
        int mitad = tiempos.length / 2;
        if (tiempos.length % 2 == 0) {
            return (tiempos[mitad - 1] + tiempos[mitad]) / 2.0;
        } else {
            return tiempos[mitad];
        }
    }
}