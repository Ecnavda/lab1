/* Lab 1
 * Jorge Ortiz
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class lab1file1 {

    public static void main(String[] args) {
        boolean[] isPassing = new boolean[100];
        double[] scores = new double[100];
        int numItems = 0;

        numItems = getData(scores);
        processPass(isPassing, scores, numItems);

        for (int i = 0; i < numItems; i++) {
            System.out.println("Is " + scores[i] + " a passing grade?  " + isPassing[i]);
        }
    }

    public static int getData(double scores[]) {
       Path filename = Paths.get("lab1data.txt");
       int itemsInScores = 0;

       try (BufferedReader fileContent = Files.newBufferedReader(filename)) {
           String[] words = fileContent.readLine().split(" ");
           itemsInScores = words.length;
           for (int i = 0; i < words.length; i++) {
               scores[i] = Integer.parseInt(words[i]);
           }
       } catch (IOException e) {
           System.out.println("The specified file was not found.");
       }

       return itemsInScores;
    }

    public static void processPass(boolean[] passing, double[] scores,
                                   int length) {
        for (int i = 0; i < length; i++) {
            if (scores[i] >= 60) {
                passing[i]= true;
            } else {
                passing[i] = false;
            }
        }
    }
}
