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

    private static final String RG_CHAR = "\\w";
    private static final String RG_WORD = RG_CHAR + "+";


    /**
     *
     * @param args
     */
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

            textStats(text);

            System.exit(0);

        } catch (IOException e) {
            System.exit(-1);
        }

    }


    /**
     *
     *
     *
     * @param text
     *
     * @return
     */
    private static void textStats(String text){
        Map<String, Integer> mapWord= new HashMap<>();
        Map<String, Integer> mapChar= new HashMap<>();

        Matcher matcherWord = Pattern.compile(RG_WORD, Pattern.UNICODE_CHARACTER_CLASS)
                .matcher(text.toLowerCase());
        Matcher matcherChar;


        while (matcherWord.find()) {
            mapWord.put(matcherWord.group(),
                    mapWord.getOrDefault(matcherWord.group(), 0) + 1);


            matcherChar = Pattern.compile(RG_CHAR, Pattern.UNICODE_CHARACTER_CLASS)
                    .matcher(matcherWord.group());

            while (matcherChar.find()){
                mapChar.put(matcherChar.group(),
                        mapChar.getOrDefault(matcherChar.group(), 0) + 1);
            }
        }

        printMap(mapChar);
        printMap(mapWord);
    }


    /**
     *
     *
     *
     * @param map
     */
    public static void printMap(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new ValueComparator());

        for (int i = 0; i < list.size(); i++){
            printLine(list.get(i).getValue(), list.get(i).getKey());
        }
        System.out.println();
    }


    /**
     *
     *
     *
     * @param count
     *
     * @param word
     */
    private static void printLine(long count, String word){
        System.out.printf("%10d\t%s\n",
                count, word);
    }


    /**
     *
     *
     */
    private static class ValueComparator implements Comparator<Map.Entry<String, Integer>> {


        /**
         *
         * @param o1
         * @param o2
         * @return
         */
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
