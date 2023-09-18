public class HamingMeter extends CaseInsensitiveHamingMeter {

    /*
    public HamingMeter(String firstString, String secondString) {
        super(firstString, secondString);
    }
    */

    public int distance(String firstString, String secondString) {

        int lengthFirstString = firstString.length();
        int lengthSecondString = secondString.length();

        if (lengthFirstString != lengthSecondString) {
            return -1;
        }

        int hamingMeter = 0;

        for (int indexLetter = 0; indexLetter < lengthFirstString; indexLetter++) {
            if (firstString.charAt(indexLetter) != secondString.charAt(indexLetter)) {
                hamingMeter++;
            }
        }

        return hamingMeter;
    }

}
