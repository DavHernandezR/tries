package base;

import java.util.Scanner;

public class MyString {

    static String reversarPalabras(String phrase) {

        String[] palabras = phrase.split(" ");

        for (int i = 0; i <= palabras.length - 1; i++) {
            String[] caracter = palabras[i].split("");
            String caracterReversado = caracter[caracter.length-1];

            for (int j = 2; j <= caracter.length; j++){
                caracterReversado = caracterReversado + caracter[caracter.length-j];
            }

            palabras[i]=caracterReversado;
        }

        String nuevaPhrase = palabras[0];

        for (int i = 1; i <= palabras.length - 1; i++){
            nuevaPhrase = nuevaPhrase + " " + palabras[i];
        }

        System.out.println("La cantidad de palabras que contiene la frase es: " + palabras.length);
        return nuevaPhrase;
    }

    static String reversarFrase(String phrase){

        char[] letras = new char[phrase.length()];
        phrase.getChars(0,phrase.length(), letras, 0);
        String nuevaPhrase = String.valueOf(letras[letras.length-1]);

        for(int i = 2; i <= letras.length; i++){
            nuevaPhrase = nuevaPhrase + letras[letras.length-i];
        }

        return nuevaPhrase;
    }

    static Integer contarLetras(String phrase){
        int contador = 0;
        int longitud = phrase.length();
        String espacio = " ";
        char spacio = espacio.charAt(0);
        for (int i = 0; i <= longitud-1; i++) {
            char caracter = phrase.charAt(i);
            if (caracter == spacio) {
                contador++;
            }
        }
        System.out.println("La cantidad de letras es: " + (longitud - contador));
        System.out.println("La cantidad de espacios es: " + contador);
        return 0;
    }

    static String encontrarPalabra(String phrase, String palabraBuscada){

        int posicionPalabra = phrase.indexOf(palabraBuscada);
        if ( posicionPalabra == -1) {
            System.out.println("La palabra buscada no existe");
        }
        else{
            System.out.println("La palabra buscada si está en la frase");

        }
        return "";
    }

    static String eliminarPalabrasDuplicadas(String phrase){

        String[] palabras = phrase.split(" ");
        for (int i = 0; i < palabras.length; i++){
            String[] palabraUnica = palabras[i].split("");
            for (int j = i + 1; j < palabras.length-1; j++){
                if (String.valueOf(palabraUnica) == String.valueOf(palabras[j])){
                    palabras[j] = "";
                }
            }
        }

        String nuevaPhrase = palabras[0];
        for (int i = 1; i <= palabras.length - 1; i++) {
            nuevaPhrase = nuevaPhrase + " " + palabras[i];
        }

        return nuevaPhrase;
    }

    public static void main(String[] args){

        System.out.println("Introduzca una frase: ");
        String phrase = "I am learning about classes and strings and maps";
        Scanner scannerEntry = new Scanner(System.in);
        phrase = scannerEntry.nextLine();
        System.out.println("La frase que introdujo es: "+phrase);

        System.out.println("La frase reversada es: "+reversarFrase(phrase));
        System.out.println("Cada palabra reversas queda: "+reversarPalabras(phrase));

        System.out.println("Introduzca una palabra para buscar en la frase: ");
        String palabraBuscada = "and";
        scannerEntry = new Scanner(System.in);
        palabraBuscada = scannerEntry.nextLine();
        encontrarPalabra(phrase, palabraBuscada);

        contarLetras(phrase);

        System.out.println(eliminarPalabrasDuplicadas(phrase));
    }
}
