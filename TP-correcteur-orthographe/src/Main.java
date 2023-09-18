import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    /*
    Cr´eez un programme qui prend en entr´ee deux mot, s´epar´es par espace, et
    affiche sur la sortie standard la distance de Hamming entre ces deux mots.
    Si les deux mot n’ont pas la mˆeme taille, un message d’avertissement sera
    affich´e. Si l’utilisateur ne fournit pas deux chaˆınes caract`ere, un message
    d’aide expliquant l’usage de votre programme sera affich´e
     */

    public static void main(String[] args) {

        /*
        System.out.println("Veuillez saisier deux mots séparé par un espace : ");
        Scanner scanner = new Scanner(System.in);

        String userInput = scanner.nextLine();
        //hamingWithoutArgs(userInput);
        hamingWithArgs(userInput);

        hamingWithArgs("bonjour Bonsoir");
        hamingWithArgs("bonjour Bonsoir -i");
        hamingWithArgs("-i bonjour Bonsoir");
        hamingWithArgs("bonjour -i Bonsoir");
        */

        Dictionary dictionary = new Dictionary("C:\\Users\\thoma\\Desktop\\APO\\TP-correcteur-orthographe\\src\\english.txt");

        //dictionary.printListVocab();

        HamingMeter hamingMeter = new HamingMeter();

        SpellChecker spellChecker = new SpellChecker(hamingMeter, dictionary);

        System.out.println("Veuillez saisir votre phrase : ");
        Scanner scanner = new Scanner(System.in);

        String sentanceInput = scanner.nextLine();

        StringTokenizer stringTokenizer = new StringTokenizer(sentanceInput);

        while (stringTokenizer.hasMoreTokens()) {
            String currentWord = stringTokenizer.nextToken();
            List<String> listWord = spellChecker.isValidWord(currentWord);

            if (!listWord.isEmpty()) {
                System.out.println("Misspell in word \"" + currentWord + "\"");
                System.out.print("Suggestions : " );

                String printListWord = "";

                int numberOfWord = 0;

                for (String word : listWord) {
                    numberOfWord++;
                    if (!printListWord.isEmpty()) {
                        printListWord += ", ";
                    }
                    printListWord += word;

                    if (numberOfWord == 5) {
                        break;
                    }
                }
                System.out.println(printListWord);
            }
        }

    }

    // Programme sans prise en compte des paramètres
    public static void hamingWithoutArgs(String userInput) {
        int indexSpace = userInput.indexOf(" ");

        String firstString = userInput.substring(0, indexSpace);
        String secondString = userInput.substring(indexSpace + 1);

        HamingMeter hamingMeter = new HamingMeter();

        int resultHaming = hamingMeter.distance(firstString, secondString);

        if (resultHaming == -1) {
            System.out.println("Attention les deux chaines de caractères doivent être de même taille !");
        } else {
            System.out.println("La distance de Haming entre " + firstString + " et " + secondString + " est de " + resultHaming);
        }
    }

    // Programme avec args
    public static void hamingWithArgs(String userInput) {

        int indexSpace = userInput.indexOf(" ");
        int indexSecondSpace = userInput.indexOf(" ", indexSpace + 1);

        String firstString = userInput.substring(0, indexSpace);
        String secondString = "";
        String thirdString = "";
        if (indexSecondSpace != -1) {
            secondString = userInput.substring(indexSpace + 1, indexSecondSpace);
            thirdString = userInput.substring(indexSecondSpace);
        } else {
            secondString = userInput.substring(indexSpace + 1);
        }

        if (firstString.contains("-i") || firstString.contains("--ignore-code") || secondString.contains("-i") || secondString.contains("--ignore-code") ) {
            System.out.println("Veuillez renseigner l'argument à la fin de votre saisie");
            return;
        }

        int resultHaming = 0;

        if (thirdString.contains("-i") || thirdString.contains("--ignore-code")) {
            // je prend pas en compte la casse

            CaseInsensitiveHamingMeter caseInsensitiveHamingMeter = new CaseInsensitiveHamingMeter();
            resultHaming = caseInsensitiveHamingMeter.distance(firstString, secondString);

        } else {
            HamingMeter hamingMeter = new HamingMeter();
            resultHaming = hamingMeter.distance(firstString, secondString);
        }

        if (resultHaming == -1) {
            System.out.println("Attention les deux chaines de caractères doivent être de même taille !");
        } else {
            System.out.println("La distance de Haming entre " + firstString + " et " + secondString + " est de " + resultHaming);
        }

    }

}