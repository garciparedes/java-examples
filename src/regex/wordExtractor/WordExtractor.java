package regex.wordExtractor;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by garciparedes on 16/02/16.
 */
public class WordExtractor {

    private static final Scanner SCANNER= new Scanner(System.in);

    private static final String REGEX = "\\S+";
    private static final Pattern PATTERN = Pattern.compile(REGEX);

    public static void main(String[] args) {

        Matcher matcher = PATTERN.matcher(SCANNER.nextLine());
        boolean found = false;
        while (matcher.find()) {
            System.out.printf("%s on (%d,%d)%n",
                    matcher.group(),
                    matcher.start(),
                    matcher.end());
            found = true;
        }
        if (!found) {
            System.out.printf("NOT FOUND%n");
        }
    }
}
