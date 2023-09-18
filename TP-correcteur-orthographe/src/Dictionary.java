import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Dictionary {

    private String absoluteFilePath;
    private List<String> listVocab;

    public Dictionary(String cheminAbsoluFichierMot) {
        this.absoluteFilePath = cheminAbsoluFichierMot;
        fillListVocab();
    }

    public void fillListVocab() {
        try {
            File file = new File(this.absoluteFilePath);
            FileReader fileReader = new FileReader(file);

            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuffer stringBuffer = new StringBuffer();
            String line;

            this.listVocab = new ArrayList<>();

            while ((line = bufferedReader.readLine()) != null) {
                this.listVocab.add(line);
            }
            fileReader.close();

        } catch(IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public String getAbsoluteFilePath() {
        return absoluteFilePath;
    }

    public void setAbsoluteFilePath(String absoluteFilePath) {
        this.absoluteFilePath = absoluteFilePath;
    }

    public List<String> getListVocab() {
        return listVocab;
    }

    public void setListVocab(List<String> listVocab) {
        this.listVocab = listVocab;
    }

    public void printListVocab() {
        for (String word : listVocab) {
            System.out.println(word);
        }
    }

}
