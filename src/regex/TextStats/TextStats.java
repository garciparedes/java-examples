package regex.textStats;


import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Sergio Garcia Prado
 *
 * Programa Java encargado de devolver estadisticas
 * sobre un fichero de entrada.
 *
 * Las estadisticas que devuelve son las siguientes:
 *
 *      * Listado de cuentas ordenadas por frecuencia
 *      del conjunto de caracteres que aparecen
 *      en el fichero de entrada
 *
 *      * Listado de cuentas ordenadas por frecuencia
 *      del conjunto de palabras que aparecen
 *      en el fichero de entrada
 *
 *
 * La ruta del texto de entrada puede ser introducida como
 * argumento al programa o una vez iniciado mediante peticion
 * del mismo.
 *
 * Created by garciparedes on 16/02/16.
 */
public class TextStats {


    /**
     * Expresiones regulares:
     *
     *      * <code>RG_CHAR</code>: captura caracteres de palabras.
     *
     *      * <code>RG_WORD</code>: captura conjuntos de 1 o mas caracteres,
     *              lo que permite formar palabras.
     */
    private static final String RG_CHAR = "\\w";
    private static final String RG_WORD = RG_CHAR + "+";
    
    
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
         * Abrimos el fichero a convertir y después se invoca la
         * funcion WordExtractor() con el contenido del fichero como argumento.
         *
         * En el caso de que haya un problema al abrir el fichero
         * se muestra un mensaje de error y el programa termina.
         */
        try {
            String text;
            text = new String(Files.readAllBytes(Paths.get(filePath)));

            textStats(text);
            System.exit(0);
        
        } catch (IOException e) {
            System.out.println(REQUEST_FILE_ROUTE_MESSAGE_NOT_FOUND + filePath);
            System.exit(-1);
        }
    }


    /**
     * Metodo WordExtractor()
     *
     * Se encarga de analizar las apariciones de
     * caracteres y palabras del texto enviado como argumento.
     *
     * @param text texto sobre el cual se realizan las estadisticas
     *
     */
    private static void textStats(String text){

        /**
         * Mapas en los cuales se almacenaran cada una de
         * las palabras/caracteres como clave y
         * las cuentas como valor.
         *
         * Se ha decidido usar <code>Long</code> en lugar de
         * <code>Integer</code> debido a que las especificaciones
         * requerian que la cuenta tuviese hasta 10 cifras. En el caso
         * de <code>Integer</code> el valor 9.999.999.999 habria
         * provocado un desvordamiento.
         */
        Map<String, Long> mapWord = new HashMap<>();
        Map<String, Long> mapChar = new HashMap<>();


        /**
         * Matchers encargados de encontrar en el texto tanto
         * palabras como caracteres. En el caso de las palabras
         * sera el mismo para el texto completo mientras que en
         * el caso de los caracteres se crea una nueva instancia
         * segun cada palabra seleccionada.
         */
        Matcher matcherWord = Pattern.compile(RG_WORD, Pattern.UNICODE_CHARACTER_CLASS)
                .matcher(text.toLowerCase());
        Matcher matcherChar;

        /**
         * Bucle de ocurrencias de palabras, mientras encuentre alguna
         * incrementa su cuenta en el mapa
         */
        while (matcherWord.find()) {
            mapWord.put(matcherWord.group(),
                    mapWord.getOrDefault(matcherWord.group(), 0L) + 1);


            /**
             * Segun la ocurrencia de palabra encontrada se inicializa
             * otro matcher encargado de encontrar ocurrencias de
             * caracteres dentro de la palabra. Equivale a iterar por
             * los caracteres de la palabra ya que todos seran ocurrencias.
             */
            matcherChar = Pattern.compile(RG_CHAR, Pattern.UNICODE_CHARACTER_CLASS)
                    .matcher(matcherWord.group());

            /**
             * Bucle de ocurrencias de caracteres, mientras encuentre alguna
             * incrementa su cuenta en el mapa
             */
            while (matcherChar.find()){
                mapChar.put(matcherChar.group(),
                        mapChar.getOrDefault(matcherChar.group(), 0L) + 1);
            }
        }

        /**
         * Primero imprime el mapa de caracteres y despues
         * el de palabras ordenados de forma descendiente
         * segun el valor de la cuenta.
         */
        printMap(mapChar);
        printMap(mapWord);
    }


    /**
     * Metodo printMap().
     *
     * Se encarga de imprimir por pantalla la secuencia
     * de entradas que contiene ordenadas a partir del valor
     * de la cuenta.
     *
     * @param map Mapa a imprimir.
     */
    private static void printMap(Map<String, Long> map) {

        /**
         * Convertimos el mapa en una lista para despues
         * ordenarlo utilizando <code>ValueComparator</code>
         * que ordena de mayor a menor según el valor.
         */
        List<Map.Entry<String, Long>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new ValueComparator());

        /**
         * Iteramos la lista mostrando por pantalla
         * el contenido de la entrada.
         */
        for (Map.Entry<String, Long> element : list) {
            printLine(element.getValue(), element.getKey());
        }
        System.out.println();
    }


    /**
     *  Funcion printLine()
     *  
     *  Es la funcion encargada de imprimir en la
     *  salida estandar cada entrada con el siguiente
     *  formato:
     *
     *  "cuenta(10) + tabulador + palabra + saltoLinea"
     *
     *
     * @param count Numero de apariciones de la palabra en el texto.
     *
     * @param word Palabra que aparece en el texto.
     */
    private static void printLine(long count, String word){
        System.out.printf("%10d\t%s\n",
                count, word);
    }


    /**
     * Clase ValueComparator.
     *
     * Clase privada encagada de implementar la interfaz
     * <code>Comparator</code> necesaria para ordenar las entradas de <code>Map</code>.
     *
     */
    private static class ValueComparator implements Comparator<Map.Entry<String, Long>> {


        /**
         * Funcion compare().
         *
         * @param o1 Entrada1 a comparar.
         *
         * @param o2 Entrada2 a comparar.
         *
         * @return relacion entre Entrada1 y Entrada2:
         *           1 si Entrada1 < Entrada2
         *           0 si Entrada1 = Entrada2
         *          -1 si Entrada1 > Entrada2
         */
        @Override
        public int compare(Map.Entry<String, Long> o1, Map.Entry<String, Long> o2) {
            if (o1.getValue() < o2.getValue()){
                return 1;
            } else if (o1.getValue().equals(o2.getValue())){
                return 0;
            } else {
                return -1;
            }
        }
    }
}
