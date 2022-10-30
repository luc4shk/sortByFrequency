
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class PruebaDeCasos {

    static String respuesta = "";
    static int contador = 0;
    static int caso = 1;
    
    /**
     Método que lee el archivo y manda a llamar a los demas métodos
     */
    public static void main(String[] args) throws Exception {
        try {
            
            Scanner a = new Scanner(System.in);
            System.out.println("Ingrese el nombre del archivo (con su extensiónt txt), recuerde que el archivo debe estar en la carpeta casos:");
            String ruta="casos/";
             ruta += a.nextLine();
            File doc = new File(ruta);
            Scanner obj = new Scanner(doc);

            while (obj.hasNextLine()) {

                String msg = obj.nextLine().replaceAll("\\[", "").replaceAll("\\]", "").replaceAll(" ", "");
                String[] arreglo = msg.split(",");
                try{
                int[] arrayFinal = new int[arreglo.length];
                for (int i = 0; i < arreglo.length; i++) {
                    arrayFinal[i] = Integer.parseInt(arreglo[i]);
                }
                int[] arrayFinalOrdenado = new int[arrayFinal.length];
                for (int i = 0; i < arrayFinal.length; i++) {
                    arrayFinalOrdenado[i] = arrayFinal[i];
                }
                //Cambie el método "sortByFrequency3" por el que realizó el estudiante, por ejemplo puede usar el algorimoErroneo para prueba:
                arrayFinalOrdenado = Main.sortByFrequency3(arrayFinalOrdenado);

//                arrayFinalOrdenado = Main.algorimtoErroneoPrueba(arrayFinalOrdenado);
                
                
                impresion(arrayFinal, arrayFinalOrdenado);
                }catch(Exception e ){
                    System.out.println("\033[31m" + "Error en el caso:" + caso + "\u001B[0m");
                    System.out.println("---------------------------------------------------");
                    respuesta+="Error en el caso:" + caso +"\n"+"---------------------------------------------------"+"\n";
                    caso++;
                }
            }
            if (contador == 0) {
                System.out.println("\033[32m" + "¡TODOS LOS CASOS SON CORRECTOS!" + "\u001B[0m");

            } else {
                System.out.println("\033[31m" + "¡ALGUN/OS CASOS TIENEN ERRORES!" + "\u001B[0m");
            }
            crearArchivoRespuesta(ruta);
        } catch (Exception e) {
            
                 System.out.println("\033[31m" + "No se encuentra el archivo, verifique si se encuentra en la carpeta casos o si escribió mal el nombre." + "\u001B[0m");
            
        }

    }

    /**
     * Imprime cada caso (entrada,salida,esperado)
     *
     * @param int[] dos arreglos los cuales son el entrada y salida;
     *
     */
    public static void impresion(int[] arrayFinal, int[] arrayFinalOrdenado) {
        //Se obtiene la respuesta correcta del código Main en arrayEsperado
        int[] arrayEsperado = new int[arrayFinal.length];
        for (int i = 0; i < arrayEsperado.length; i++) {
            arrayEsperado[i] = arrayFinal[i];
        }
        arrayEsperado = Main.sortByFrequency3(arrayEsperado);

        System.out.println("Caso: #" + caso);
        respuesta += "Caso #" + caso + "\n";
        caso++;
        //Se comienza a imprimir cada caso
        System.out.println("\033[33m" + "Entrada:" + "\u001B[0m");
        respuesta += "Entrada:" + "\n";
        for (int i = 0; i < arrayFinal.length; i++) {
            if (i + 1 == arrayFinal.length) {
                System.out.println(arrayFinal[i]);
                respuesta += arrayFinal[i] + "\n";
            } else {
                System.out.print(arrayFinal[i] + ",");
                respuesta += arrayFinal[i] + ",";
            }
        }
        System.out.println("\033[33m" + "Salida:" + "\u001B[0m");
        respuesta += "Salida:" + "\n";
        for (int i = 0; i < arrayFinalOrdenado.length; i++) {
            if (i + 1 == arrayFinalOrdenado.length) {
                System.out.println(arrayFinalOrdenado[i]);
                respuesta += arrayFinalOrdenado[i] + "\n";;
            } else {
                System.out.print(arrayFinalOrdenado[i] + ",");
                respuesta += arrayFinalOrdenado[i] + ",";
            }
        }
        System.out.println("\033[33m" + "Esperando:" + "\u001B[0m");
        respuesta += "Esperando:" + "\n";
        for (int i = 0; i < arrayEsperado.length; i++) {
            if (i + 1 == arrayEsperado.length) {
                System.out.println(arrayEsperado[i]);
                respuesta += arrayEsperado[i] + "\n";
            } else {
                System.out.print(arrayEsperado[i] + ",");
                respuesta += arrayEsperado[i] + ",";
            }
        }
        comprobacion(arrayFinalOrdenado, arrayEsperado);
        System.out.println("---------------------------------------------------");
        respuesta += "---------------------------------------------------" + "\n";
    }

    /**
     * Método que realiza la comprobación de los dos arreglos e imprime un
     * resultado dependiendo de esto
     *
     * @param int[] dos arreglos de enteros a comparar
     * imprime Correcto si los arreglos son iguales, incorrecto si no lo son.
     */
    public static void comprobacion(int[] arrayFinalOrdenado, int[] arrayEsperado) {
        int cont = -1;
        String msg = "Resultado: ";
        respuesta += "Resultado: ";
        for (int i = 0; i < arrayFinalOrdenado.length; i++) {
            if (arrayFinalOrdenado[i] == arrayEsperado[i]) {
                cont++;
            }
            if (i + 1 == arrayEsperado.length) {
                if (i == cont) {
                    msg += "\033[32m" + "Correcto" + "\u001B[0m";
                    respuesta += "Correcto" + "\n";
                } else {
                    msg += "\033[31m" + "Incorrecto" + "\u001B[0m";
                    respuesta += "Incorrecto" + "\n";
                    contador++;
                }
            }
        }
        System.out.println(msg);
    }

    /**
    Método que crea el archivo de lo que se imprimió en consola 
     **/
    public static void crearArchivoRespuesta(String ruta) {
        try {
            String ruta2 = "respuesta/respuesta"+ruta.replaceAll("casos/", "");
            File file = new File(ruta2);

            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            if (respuesta.contains("Incorrecto")) {
                respuesta += "¡ALGUN/OS TEST TIENEN ERRORES!";
            } else {
                respuesta += "¡TODOS LOS TEST FUERON PASADOS!";
            }
            bw.write(respuesta);
            bw.close();
            ruta2 = ruta2.replaceAll("respuesta/", "");
            System.out.println("Archivo txt con los resultados fue creado en la carpeta respuesta, el nombre es: " + ruta2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
