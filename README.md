# sortByFrequency

### Archivos en la carpeta src

>***Main.java*** = Se encuentra el código para resolver el problema.

>***GeneradorCasos.java*** = Clase que genera un archivo de texto con el número de casos indicado por el usuario.

>***PruebaDeCasos.java*** = Esta clase funciona como un test para ver si un algortimo x logra solucionar el problema.

### ¿Cómo usar el generador de casos?
Al correr la clase, el programa le preguntará el número de casos que quiere generar, una vez hecho esto se creará un archivo .txt que se alojara en la carpeta **casos**.


### ¿Cómo hacer el test de los casos?
Para esto tendremos que correr la clase ***PruebaDeCasos.java***, el programa preguntará por el nombre del archivo que contiene los casos **(El archivo se debe encontrar en la carpeta ***casos***)**, se coloca junto con su extensión (casos.txt). Cuando se realicé este proceso el programa imprimirá en la consola los casos con sus respectivos resultados y a su vez se creará un archivo .txt en la carpeta ***respuesta*** con la información que se imprimió. 

### ¿Cómo cambiar el algoritmo que se esta testeando?

Para esto tenemos que entrar en la clase ***PruebaDeCasos.java*** y en la línea 40 cambiar el método que se llama, este debe recibir un arreglo de enteros y retornar uno igual con la solución. 



![code](https://user-images.githubusercontent.com/62387528/198905161-74d619d0-bc59-4a45-a618-5782f51d0bc9.png)

