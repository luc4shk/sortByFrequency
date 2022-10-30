import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class GeneradorCasos {
    /**
     Crea un archivo txt con todos los casos
     **/
    public static void main(String[] args) {
        //Creamos el fichero de texto con los casos que el usario elija
        Scanner s = new Scanner(System.in);
        try {
            System.out.println("¿Cuántos casos quiere generar? ej:50");
            int casos = s.nextInt();
            String msg="";
            
            for (int i = 0; i < casos; i++) {
                int array[] = generarArreglo();
                for (int j = 0; j < array.length; j++) {
                     if(j+1==array.length){
                        msg+=array[j]+"]"+"\n";
                        
                    }else if(j==0){
                        msg+="[";
                    }else{
                        msg+=array[j]+",";
                    }
                }
              
            }
            String ruta = "casos/"+casos+"casos.txt";
            File file = new File(ruta);
            
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(msg);
            bw.close();
            System.out.println("Archivo txt creado en la carpeta casos, el nombre es: " + ruta.replaceAll("casos/", ""));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    /**
     Genera un arreglo random
     @return arreglo aleatorio
     **/
    public static int[] generarArreglo(){
    int tamanio = (int)(Math.random()*((100-(1))+1))+(1);
    int[] arreglo = new int[tamanio];
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i]=(int)(Math.random()*((100-(-100)+1))+(-100));
        }
    return arreglo;
    }
    
}
