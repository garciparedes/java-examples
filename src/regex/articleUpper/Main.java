package regex.articleUpper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Sergio Garcia Prado
 *
 * Programa Java encargado de convertir todos los
 * articulos determinados (el, los, la, las) de un
 * texto dado a mayusculas.
 *
 * La ruta del texto de entrada puede ser introducida como
 * argumento al programa o una vez iniciado mediante peticion
 * del mismo.
 *
 * Created by garciparedes on 25/02/16.
 *
 */
public class Main {


    /**
     * Expresion Regular.
     * Sirve para localizar el siguiente patron:
     *      espacio/simbolo + articuloDeterminado + espacio/simbol
     *
     *
     * <code>RG_DELIMITATION</code> representa espacio/simbolo
     *
     *
     * <code>RG_ARTICLE</code> representa el articulo determinado.
     *
     *      Se permite que el primer caracter del articulo determinado sea
     *      una letra mayuscula para incluir los que comienzan una frase.
     *
     *
     * <code>REGEX</code> representa la expresion regular completa.
     */
    private static final String RG_DELIMITATION = "\\b";
    private static final String RG_ARTICLE = "(([Ee]l)|([Ll]((a(s)?)|os)))";
    private static final String REGEX = RG_DELIMITATION + RG_ARTICLE + RG_DELIMITATION;


    /**
     * Mensajes informativos para el usuario.
     */
    private static final String REQUEST_FILE_ROUTE_MESSAGE = "Introduzca la ruta del fichero:";
    private static final String REQUEST_FILE_ROUTE_MESSAGE_NOT_FOUND = "No se ha encontrado el fichero: ";



    /**
     * Metodo main del programa.
     *
     * Es quien inicia la ejecucion.
     *
     * @param args argumentos enviados al programa.
     */
    public static void main(String[] args) {

        /**
         * Declaracion de filePath que representa la
         * ruta del fichero donde esta el texto a convertir.
         *
         * Se asigna el argumento de entrada en el caso de que exista
         * y sino se pide la ruta por entrada estandar.
         *
         */
        String filePath;
        if (args.length == 1){
            filePath = args[0];
        } else {
            System.out.println(REQUEST_FILE_ROUTE_MESSAGE);
            filePath = (new Scanner(System.in)).nextLine();
        }

        /**
         * Abrimos el fichero a convertir y después se imprime por
         * salida estandar el resultado de la funcion articleToUpperCase()
         *
         * En el caso de que haya un problema al abrir el fichero
         * se muestra un mensaje de error y el programa termina.
         */
        try {
            String text;
            text = new String(Files.readAllBytes(Paths.get(filePath)));

            System.out.println(articleToUpperCase(text));
            System.exit(0);

        } catch (IOException e) {
            System.out.println(REQUEST_FILE_ROUTE_MESSAGE_NOT_FOUND + filePath);
            System.exit(-1);
        }
    }



    /**
     * Funcion articleToUpperCase
     *
     * Es la funcion encargada de localizar los articulos
     * determinados y convertirlos a mayusculas.
     *
     * @param text texto original donde se buscan los articulos determinados.
     *
     * @return Nuevo texto con articulos determinados en mayusculas.
     */
    private static String articleToUpperCase(String text) {

        /**
         * Declaracion del Matcher que analiza el texto a partir de
         * la expresion regular <code>PATTERN</code> y del
         * StringBuffer donde almacenaremos el nuevo texto.
         */
        Matcher matcher = (Pattern.compile(REGEX)).matcher(text);
        StringBuffer s = new StringBuffer();

        /**
         * Bucle encargado de reemplazar los articulos
         * determinados por sus corresponientes en mayusculas.
         *
         * El metodo appendTail() agrega la parte final del texto
         * en la cual ya no hay mas ocurrencias (en este caso articulos determinados).
         */
        while (matcher.find()) {
            matcher.appendReplacement(s, matcher.group().toUpperCase());
        }
        matcher.appendTail(s);

        return s.toString();
    }
}
