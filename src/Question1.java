import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//Author: Sidney Thelusma
//Date: 4/5/18

public class Question1 {

    Question1(){

    }

    public File getDictionary() {
        return dictionary;
    }

    public void setDictionary(File dictionary) {
        this.dictionary = dictionary;
    }

    public List<String> getOutput() {
        return output;
    }

    public void setOutput(List<String> output) {
        this.output = output;
    }

    private File dictionary;
    private List<String> output = new ArrayList<>();


    public boolean doesFileExist(String filePath) {
        try {
            dictionary = new File(filePath);
            if (dictionary.exists() && dictionary.isFile()) {
                System.out.println("Valid file.");
            }
        }
        catch (Exception e){
            System.out.println("Something's up with this file.");
            return false;
        }

        return false;

    }

    public void readAndParse(File file){
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(file));
            String read = null;
            while ((read = in.readLine()) != null) {
                String[] wordAndMeanings = read.split("\\s*–\\s*");
                for (String entry : wordAndMeanings) {
                    output.add(entry.replace(", ", "\n")); //this second replace is a little hacky and could
                    //be optimized, perhaps with a better split
                }
            }
        } catch (IOException e) {
            System.out.println("There was a problem: " + e);
            e.printStackTrace();
        }
        finally {
            try {
                in.close();
            } catch (Exception e) {
            }
        }

    }

    public void printOutput(List<String> outputList){
        for (String entry: outputList){
            System.out.println(entry);
        }

    }

    public static void main(String args[]){
        Question1 q1 = new Question1();
        q1.doesFileExist("resources/Dictionary.txt");
        q1.readAndParse(q1.getDictionary());
        q1.printOutput(q1.getOutput());
    }


}
