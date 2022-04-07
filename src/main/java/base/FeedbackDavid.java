package base;

import java.util.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class FeedbackDavid {
    public static void main(String[] args) {

        HashMap<Integer, String> nombrePersonas = new HashMap<>();

        nombrePersonas.put(7, "Eliana");
        nombrePersonas.put(1, "Alexandra");
        nombrePersonas.put(8, "Juan");
        nombrePersonas.put(22, "David");
        nombrePersonas.put(32, "David");
        nombrePersonas.put(5, "Eliana");
        nombrePersonas.put(19, "Alexandra");
        nombrePersonas.put(9, "Juan");
        nombrePersonas.put(38, "David");
        nombrePersonas.put(41, "David");

        //mostrarNombres(nombrePersonas);
        //mostrarNombres(eliminarNombre(nombrePersonas));
        //mostrarNombres(eliminarKey(nombrePersonas));
        //mostrarNombres(insertarNombre(nombrePersonas));
        mostrarNombres(eliminarRepetidos(nombrePersonas));

    }

    public static HashMap<Integer, String> mostrarNombres(HashMap<Integer, String> nombrePersonas){

        for (int i : nombrePersonas.keySet()) {
            System.out.println("El id de la persona es " + i + " y su nombre es " + nombrePersonas.get(i));
        }

        return nombrePersonas;
    }

    public static HashMap<Integer, String> eliminarNombre(HashMap<Integer, String> nombrePersonas) {

        //String nombreEliminar = "Juan";
        Scanner scannerEntry = new Scanner(System.in);

        System.out.println("Introduzca un nombre a eliminar: ");
        String nombreEliminar = scannerEntry.nextLine();
        
        Iterator<Entry<Integer, String>> iterator = nombrePersonas.entrySet().iterator();
        while (iterator.hasNext()) {
          if (iterator.next().getValue().equals(nombreEliminar)) {
            iterator.remove();
            }
        }
        
        //Este código solo remueve uno de los repetidos por el break, si lo quito tengo una excepción: ConcurrentModificationException. Esto porque el HashMap
        //es unsynchronized por lo cual se debe usar entrySet.

       /* for (int i : nombrePersonas.keySet()) {

            if (nombrePersonas.get(i).equals(nombreEliminar)) {
                nombrePersonas.remove(i);
                break;
            }
        }*/

        return nombrePersonas;
    }

    public static HashMap<Integer, String> eliminarKey(HashMap<Integer, String> nombrePersonas){

        //int keyEliminar = 5;
        Scanner scannerEntry = new Scanner(System.in);

        System.out.println("Introduzca un ID a eliminar: ");
        int keyEliminar = Integer.parseInt(scannerEntry.nextLine());
        nombrePersonas.remove(keyEliminar);

        return nombrePersonas;
    }

    public static HashMap<Integer, String> insertarNombre(HashMap<Integer, String> nombrePersonas){

        //String nombreNuevo = "Manuel";
        Scanner scannerEntry = new Scanner(System.in);
        int idNuevo = 3;

        System.out.println("Introduzca un nombre a insertar: ");
        String nombreNuevo = scannerEntry.nextLine();

        System.out.println("Introduzca un ID a insertar: ");
        scannerEntry = new Scanner(System.in);

        idNuevo = Integer.parseInt(scannerEntry.nextLine());
        nombrePersonas.put(idNuevo, nombreNuevo);

        return nombrePersonas;
    }

    public static HashMap<Integer, String> eliminarRepetidos(HashMap<Integer, String> nombrePersonas){
        String valor = "";
        int contador = 0;
        HashMap<Integer, String> nombrePersonasAux = new HashMap<>();
        
        Iterator<Entry<Integer, String>> iterator = nombrePersonas.entrySet().iterator();
        while (iterator.hasNext()) {
            valor = iterator.next().getValue();
            if(nombrePersonasAux.containsValue(valor)){
                iterator.remove();
            }
            else{
                nombrePersonasAux.put(contador, valor);
            }
            contador++;
        }
        
        //Haciendo uso de hashmap es mucho más sencillo que mover los datos a un array y operar sobre el array. Te pongo un ejemplo de como lo haría yo, 
        //no queriendo decir que es la mejor forma, pero te muestro como hago uso de hashmap.

        /*String[] valores = new String[nombrePersonas.size()];
        int[] llaves = new int[nombrePersonas.size()];

        System.out.println("Eliminar repetidos: ");
        int contador = 0;
        for (int i : nombrePersonas.keySet()){
            llaves[contador] = i;
            valores[contador] = nombrePersonas.get(i);
            contador++;
        }

        for (int i = 0; i < valores.length; i++){
            String valorUnico = valores[i];
            for (int j = i + 1; j < valores.length; j++){
                String otroValor = valores[j];
                if (valorUnico.equals(otroValor)){
                    valores[j] = "";
                }
            }
        }

        for (int i = 0; i < valores.length; i++){
            if (valores[i].equals("")){
                nombrePersonas.remove(llaves[i]);
            }
        }*/

        return nombrePersonas;
    }
}
