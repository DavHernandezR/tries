package base;

import java.util.HashMap;
import java.util.Scanner;

public class MyMap {
    public static void main(String[] args){

        HashMap<Integer, String> nombrePersonas = new HashMap<>();
        nombrePersonas.put(22,"David Hernandez");
        nombrePersonas.put(5,"Eliana Alvarez");
        nombrePersonas.put(19,"Alexandra Rodriguez");

        for (int i : nombrePersonas.keySet()) {
            System.out.println("El id de la persona es " + i + " y su nombre es " + nombrePersonas.get(i));
        }

        System.out.println("Introduzca un nombre a eliminar: ");
        String nombreEliminar = "Juan";
        Scanner scannerEntry = new Scanner(System.in);
        nombreEliminar = scannerEntry.nextLine();
        for (int i : nombrePersonas.keySet()) {
            if (nombrePersonas.get(i) == nombreEliminar){
                nombrePersonas.remove(i);
            }
        }

        System.out.println("Introduzca un ID a eliminar: ");
        int keyEliminar = 5;
        scannerEntry = new Scanner(System.in);
        keyEliminar = Integer.parseInt(scannerEntry.nextLine());
        nombrePersonas.remove(keyEliminar);

        System.out.println("Introduzca un nombre a insertar: ");
        String nombreNuevo = "Manuel";
        scannerEntry = new Scanner(System.in);
        nombreNuevo = scannerEntry.nextLine();
        System.out.println("Introduzca un ID a insertar: ");
        int idNuevo = 3;
        scannerEntry = new Scanner(System.in);
        idNuevo = Integer.parseInt(scannerEntry.nextLine());
        nombrePersonas.put(idNuevo, nombreNuevo);


    }
}
