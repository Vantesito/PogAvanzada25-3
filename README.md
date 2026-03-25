# Análisis de Rendimiento de Algoritmos

Este proyecto es un estudio práctico sobre el rendimiento de diferentes estructuras de datos y algoritmos al resolver problemas clásicos de la ciencia de la computación. El objetivo principal es contrastar implementaciones iterativas tradicionales contra alternativas optimizadas.

## Estructura del Repositorio

El proyecto sigue una estructura basada en Maven, adaptada para separar claramente el código fuente, las pruebas y los análisis de rendimiento:

* `src/`: Contiene el código fuente principal (Java).
* `tests/`: Contiene las pruebas unitarias automatizadas utilizando JUnit 5.
* `benchmarks/`: Scripts y clases dedicadas a la medición de tiempos de ejecución.
* `docs/`: Documentación adicional y reportes del proyecto.

## Problemas Implementados

Se han desarrollado dos módulos principales, cada uno con dos enfoques distintos para evaluar su complejidad temporal ($O(n)$ vs $O(1)$ o $O(\log n)$):

### A) Conteo de Ocurrencias
Determina la frecuencia de aparición de un elemento específico dentro de un conjunto de datos.
1. **Conteo Lineal:** Recorre secuencialmente todo el arreglo por cada consulta.
2. **Conteo con Diccionario (HashMap):** Pre-procesa los datos en una tabla Hash para permitir consultas de frecuencia casi instantáneas.

### C) Búsqueda de Elementos
Localiza la posición de un elemento objetivo dentro de un arreglo.
1. **Búsqueda Lineal:** Inspecciona cada elemento uno por uno hasta encontrar una coincidencia.
2. **Búsqueda Binaria:** Algoritmo de divide y vencerás que reduce el espacio de búsqueda a la mitad en cada paso (requiere que el arreglo esté ordenado previamente).

## Instrucciones de Ejecución
El proyecto está configurado para ser ejecutado fácilmente a través de Maven y cualquier IDE moderno compatible con Java (como IntelliJ IDEA)

### Ejecutar las Pruebas (Tests)
Para validar la correctitud de los algoritmos y comprobar los casos borde (arreglos vacíos, elementos únicos, repetidos, etc.), abre una terminal en la raíz del proyecto y ejecuta:
```bash
mvn test
