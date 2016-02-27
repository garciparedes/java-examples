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

            String text;
            text = new String(Files.readAllBytes(Paths.get(filePath)));

            Map<String, Integer> map= regex(text);

            printMap(map);

            System.exit(0);

        } catch (IOException e) {
            System.exit(-1);
        }

    }

    private static Map<String, Integer> regex(String text){
        Map<String, Integer> map= new HashMap<>();

        Matcher matcher = Pattern.compile(REGEX, Pattern.UNICODE_CHARACTER_CLASS)
                .matcher(text);

        while (matcher.find()) {
            map.put(matcher.group().toLowerCase(),
                    map.getOrDefault(matcher.group(), 0) + 1);
        }
        return map;
    }


    public static void printMap(Map<String, Integer> mp) {
        List<Map.Entry<String, Integer>> a = new ArrayList<>(mp.entrySet());

        Collections.sort(a, new ValueComparator());

        /*
        for (int i = 0; i < a.size(); i++){
            printLine(a.get(i).getValue(), a.get(i).getKey());
        }
        */

        for (int i = 0; i < 20; i++){
            printLine(a.get(i).getValue(), a.get(i).getKey());
        }
    }



    private static void printLine(long count, String word){
        System.out.printf("%10d\t%s\n",
                count, word);
    }



    private static class ValueComparator implements Comparator<Map.Entry<String, Integer>> {

        @Override
        public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
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
