# Examen Final

## Nombre: Sebastian Arenillas

## Metodo A

Implementacion concreta seleccionada: TreeSet

Razon: Escogi esta debido a mantiene estos proyectos ordenados automaticamente

Como se garantiza el orden:La carga de trabajo descendente
y el codigo ascendente va ignorar mayusculas y minusculas

Como se eliminan duplicados: El Comparator retorna 0 cuando dos proyectos tienen la misma carga de trabajo
y el mismo codigo ignorando mayusculas y minusculas

Complejidad: Seria de complejidad O(log n)

## Metodo B

Implementacion seleccionada: TreeMap

Razon: Esta mantiene las claves ordenadas de forma alfabeticamente manteniendo cada categoria ordenada

Como se garantiza el orden: Prioridad para el descendente
y el codigo ascendente va ignorar mayusculas y minusculas

Como se eliminan duplicados: El Comparator retornaria un 0 cuando dos proyectos tienen la misma prioridad 
ignorando en este caso mayusculas y minusculas

Complejidad: De igual forma de complejidad O(n log n)
