import java.util.*;

public class SpellChecker {

    private HamingMeter hamingMeter;
    private Dictionary dictionary;

    public SpellChecker(HamingMeter hamingMeter, Dictionary dictionary) {
        this.hamingMeter = hamingMeter;
        this.dictionary = dictionary;
    }

    public List<String> isValidWord(String givenWord) {
        boolean wordExist = dictionary.getListVocab().contains(givenWord);

        int maxDistance = 4;

        // La distance max est de 4 donc si mot plus grand que 4 * 2 je garde 4
        if (givenWord.length() < 8) {
            maxDistance = givenWord.length() / 2;
        }

        List<String> listWord = new ArrayList<>();

        if (!wordExist) {

            Map<String, Integer> listSimilarWord = new LinkedHashMap<>();

            int numberOfWordFind = 0;

            for (String currentWord : dictionary.getListVocab()) {
                if (currentWord.length() == givenWord.length()) {
                    int distanceHaming = hamingMeter.distance(currentWord, givenWord);

                    if (distanceHaming <= maxDistance) {
                        listSimilarWord.put(currentWord, distanceHaming);
                    }
                }
            }

            List<Map.Entry<String, Integer>> list = new ArrayList<>(listSimilarWord.entrySet());
            list.sort(Map.Entry.comparingByValue());

            for (Map.Entry<String, Integer> entry : list) {
                listWord.add(entry.getKey());
            }

        }
        return listWord;
        
    }

}
