package regex.wordExtractor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by garciparedes on 16/02/16.
 */
public class WordExtractor {

    private static final String REGEX = "\\w+";

    public static void main(String[] args) {

        String filePath;
        if (args.length == 1){
            filePath = args[0];
        } else {
            filePath = (new Scanner(System.in)).nextLine();
        }

        try {
            TreeMap<String, Long> map= new TreeMap<>();
            String text;
            text = new String(Files.readAllBytes(Paths.get(filePath)));
            Matcher matcher = Pattern.compile(REGEX, Pattern.UNICODE_CHARACTER_CLASS)
                    .matcher(text);

            while (matcher.find()) {
                map.put(matcher.group().toLowerCase(),
                        map.getOrDefault(matcher.group(), 0L) + 1);
            }
            printMap(map);

            System.exit(0);

        } catch (IOException e) {
            System.exit(-1);
        }

    }
    public static void printMap(Map<String, Long> mp) {
        Iterator<Map.Entry<String, Long>> it = mp.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Long> pair = it.next();
            printLine(pair.getValue(), pair.getKey());
            it.remove();
        }
    }

    private static void printLine(long count, String word){
        System.out.printf("%10d\t%s\n",
                count, word);
    }
}
