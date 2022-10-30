
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
         int[] arreglo = {1,1,2,2,2,3};
         sortByFrequency3(arreglo);
    }

    /**
     Método que ordena por la frecuencia de sus elementos
     @param nums -> un arreglo de enteros
     @return un arreglo respectivamente ordenado
     ejemplo -> recibe [1,1,2,2,2,3] -> retorna [3,1,1,2,2,2]
     **/
    public static int[] sortByFrequency3(int[] nums) {
        //Creamos las dos listas con las cuales trabajaremos
        List listaDatos = new ArrayList<Integer>(nums.length);
        List listaFrecuencias = new ArrayList<Integer>();

        //Ordenamos el arreglo nums y lo añadimos a "listaDatos"
        Arrays.sort(nums);
        for (int el : nums) {
            listaDatos.add(el);
        }
        /*Llamamos a un método que halla las frecuencias de
          cada número en la lista y añadimos el resultado a la otra lista*/
        listaFrecuencias.addAll(hallarFrecuencias(listaDatos));
        /*Ordenamos la lista de frecuencias de la forma requerida*/
        listaFrecuencias = ordenarFrecuencias(listaFrecuencias);
        /*Vaciamos la lista para poder usarla*/
        listaDatos.removeAll(listaDatos);

        /*llenamos listaDatos con las frecuencias obtenidas*/
        int x = 0, z = 0;
        int cont = 0;
        for (int i = 0; i < listaFrecuencias.size(); i += 2) {
            cont = 0;
            x = Integer.parseInt(listaFrecuencias.get(i).toString());
            z = Integer.parseInt(listaFrecuencias.get(i + 1).toString());
            while (cont < x) {
                listaDatos.add(z);
                cont++;
            }
        }
        /*Pasamos la lista a un arreglo y retornamos*/
        int[] resultadoArray = new int[listaDatos.size()];
        for (int i = 0; i < listaDatos.size(); i++) {
            resultadoArray[i] = Integer.parseInt(listaDatos.get(i).toString());
        }
        return resultadoArray;
    }

    /**
     * Método para hallar la frecuencia de una lista de datos
     *
     * @param listaDatos --> Una lista de enteros
     * @return Una lista de Integer con las frecuencias de cada dato {valor,repeticiones} 
     * ejemplo -> recibe [1,1,2,2,2,3] -> retorna [1,2,2,3,3,1]
     *
     */
    private static List<Integer> hallarFrecuencias(List<Integer> listaDatos) {
        ArrayList<Integer> listaFrecuencias = new ArrayList<>();
        int freq = 0, temp = 0;
        for (int i = 0; i < listaDatos.size(); i++) {
            freq = Collections.frequency(listaDatos, listaDatos.get(i));
            listaFrecuencias.add(listaDatos.get(i));
            listaFrecuencias.add(freq);
            temp = freq;
            i += freq - 1;
        }
        return listaFrecuencias;
    }

    /**
     * Método que ordena la lista de frecuencias mediante las condiciones
     * requeridas por el problema
     *
     * @param listaFrecuencias --> lista que contiene las frecuencias
     * @return lista con las frecuencias ordenadas {repeticiones, valor}
     * ejemplo -> recibe [1,2,2,3,3,1] -> retorna [1, 3, 2, 1, 3, 2]
     */
    private static List<Integer> ordenarFrecuencias(List<Integer> listaFrecuencias) {
        int x = 0, y = 0, z = 0, a = 0;
        for (int i = 1; i < listaFrecuencias.size(); i += 2) {
            for (int j = i + 2; j < listaFrecuencias.size(); j += 2) {
                x = Integer.parseInt(listaFrecuencias.get(i).toString());
                y = Integer.parseInt(listaFrecuencias.get(j).toString());
                z = Integer.parseInt(listaFrecuencias.get(i - 1).toString());
                a = Integer.parseInt(listaFrecuencias.get(j - 1).toString());
                if (x < y) {
                    int temp2 = x;
                    listaFrecuencias.set(i, y);
                    listaFrecuencias.set(j, temp2);
                    int temp3 = z;
                    listaFrecuencias.set(i - 1, a);
                    listaFrecuencias.set(j - 1, temp3);
                } else if (x == 1 && y == 1) {
                    if (z > a) {
                        int temp2 = z;
                        listaFrecuencias.set(i - 1, a);
                        listaFrecuencias.set(j - 1, temp2);
                    }
                }else if(x==y){
                    if (z > a) {
                        int temp2 = z;
                        listaFrecuencias.set(i - 1, a);
                        listaFrecuencias.set(j - 1, temp2);
                    }
                }
            }
        }
        Collections.reverse(listaFrecuencias);
        return listaFrecuencias;
    }
    /**
    Algorimto usado para probar la efectividad de la comprobación
    **/
    public static int[] algorimtoErroneoPrueba(int[]arreglo){
        
            arreglo[0]=555;
        
    return arreglo;
    }
}
