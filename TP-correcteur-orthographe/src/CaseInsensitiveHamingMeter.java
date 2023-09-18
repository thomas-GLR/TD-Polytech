public class CaseInsensitiveHamingMeter {

    /*
    protected String firstString;
    protected String secondString;
    protected int lengthFirstString;
    protected int lengthSecondString;

    public CaseInsensitiveHamingMeter(String firstString, String secondString) {
        this.firstString = firstString;
        this.secondString = secondString;
        this.lengthFirstString = firstString.length();
        this.lengthSecondString = secondString.length();
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
            if (firstString.toUpperCase().charAt(indexLetter) != secondString.toUpperCase().charAt(indexLetter)) {
                hamingMeter++;
            }
        }

        return hamingMeter;
    }

}
