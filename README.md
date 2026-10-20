# Kata 2 - Entrada y Salida

## Objetivo de la entrega
El objetivo de esta práctica es aprender a separar bien las partes de un programa usando una arquitectura limpia. La idea principal es que la lógica del programa no sepa de dónde vienen los datos ni a dónde van. Para lograr esto, se han usado las clases `InputStream` y `OutputStream` en los constructores, obligando al programa a leer y escribir datos sin importarle si es un archivo, una URL o la propia consola.

## Versión de JDK
- **JDK:** Java 26.

## Cómo compilar y ejecutar
Para probar el código en un entorno como IntelliJ IDEA, solo tienes que ejecutar una de las dos clases principales:
1. **`MainLocal.java`**: Lee los datos del archivo local `gamesales.csv` y guarda el resultado en un archivo de texto llamado `resultados.txt`.
2. **`MainUrl.java`**: Descarga el CSV directamente desde internet y muestra el resultado de los cálculos por la consola.

## Estructura de la entrega y clases principales
El código está dividido en paquetes para no mezclar la lógica con la lectura de datos:
- **`model.Game`**: Es un `record` que guarda la información de un videojuego.
- **`io.GameReader` e `io.GameWriter`**: Las interfaces que dicen qué métodos hay que usar para leer y escribir.
- **`io.CsvGameReader`**: Lee el `InputStream` línea por línea. Tiene un parámetro en el constructor para saber si está leyendo el formato del CSV local o el formato del CSV de internet, y corta las columnas de forma diferente según el caso.
- **`io.StreamGameWriter`**: Recibe el mapa con los datos calculados y lo manda por el `OutputStream` que le pasemos.
- **`logic.GameProcessor`**: Se encarga solo de contar cuántos juegos hay por plataforma.
- **`MainLocal` y `MainUrl`**: Son los que abren los archivos o la conexión a internet y conectan todas las piezas anteriores.

## Repetición de la Kata y variaciones
Siguiendo las instrucciones, repetí el ejercicio en distintas ramas de Git para ir practicando e introduciendo pequeños cambios:
- **`first-try`**: Lo más básico. Leí de un archivo local y saqué el resultado por consola.
- **`second-try`**: Cambié el destino. En vez de la consola, hice que guardara el resumen en un archivo `.txt`.
- **`third-try`**: Cambié el origen. Conecté el lector a la URL de GitHub para descargar los datos.
- **`develop` y `master`**: Junté todo el trabajo y dejé los dos Mains para que se puedan probar ambas formas.

## Evidencias de verificación o pruebas realizadas
He comprobado que el programa no se rompe en estas situaciones:
- **Filas mal formadas:** Si el CSV tiene una fila con un error de formato, el `try-catch` dentro del lector captura el fallo, avisa en rojo por consola (`System.err`) y sigue leyendo la siguiente fila sin detener el programa.
- **Archivo no encontrado:** Si el archivo local no existe, el programa lo detecta y muestra un aviso claro en lugar de lanzar una excepción fea en pantalla.
- **Archivo vacío:** Si le pasamos un archivo sin datos, el programa procesa una lista vacía y no devuelve errores de tipo `null`.

## Enlace al vídeo explicativo
https://youtu.be/dgFp6eYA8xQ 