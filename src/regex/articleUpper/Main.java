package regex.articleUpper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Created by garciparedes on 25/02/16.
 */
public class Main {

    private static final Scanner SCANNER= new Scanner(System.in);


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
            System.out.println(new String(Files.readAllBytes(Paths.get(fileRoute))));
        } catch (IOException e) {
            System.out.println(REQUEST_FILE_ROUTE_MESSAGE_NOT_FOUND);
            System.exit(-1);
        }
    }
}
