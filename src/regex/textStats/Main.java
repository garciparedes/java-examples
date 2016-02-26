package regex.textStats;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by garciparedes on 25/02/16.
 */
public class Main {

    private static final Scanner SCANNER= new Scanner(System.in);


    private static final String REGEX = "";

    private static final Pattern PATTERN = Pattern.compile(REGEX);

    private static final String REQUEST_FILE_ROUTE_MESSAGE = "Introduzca la ruta del fichero:";
    private static final String REQUEST_FILE_ROUTE_MESSAGE_NOT_FOUND = "No se ha encontrado el fichero";

    public static void main(String[] args) {

        String fileRoute;
        if (args.length == 1){
            fileRoute = args[0];
        } else {
            System.out.println(REQUEST_FILE_ROUTE_MESSAGE);
            fileRoute = SCANNER.nextLine();
        }

        try {
            String text;
            text = new String(Files.readAllBytes(Paths.get(fileRoute)));
            //TODO Text Stats
        } catch (IOException e) {
            System.out.println(REQUEST_FILE_ROUTE_MESSAGE_NOT_FOUND);
            System.exit(-1);
        }
    }
}
