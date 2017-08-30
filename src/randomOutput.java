import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Files;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class randomOutput {

    public String filename;
    public int numOfRand, upperBound;

    randomOutput() {
        this.filename = "defaultFile.txt";
        this.numOfRand = 100;
        this.upperBound = 100;
    }

    randomOutput(String filename, int numOfRand, int upperBound) {
        this.filename = filename;
        this.numOfRand = numOfRand;
        this.upperBound = upperBound;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String filename = "";
        List<String> output = new ArrayList();
        int numOfRand, upperBound;

        System.out.print("Enter filename: ");
        filename = input.nextLine();

        System.out.println("Enter the quantity of random numbers you would like: ");
        numOfRand = input.nextInt();

        System.out.print("Enter the number you would like to be the upper bound of the numbers generated:(Inclusive) ");
        upperBound = input.nextInt();

        output.add(randOutputOneLine(createRandList(numOfRand, upperBound)));

        fileCreate(filename, output);
    }

    public static List<String> createRandList(int numOfRand, int upperBound) {
        List<String> numList = new ArrayList<String>();
        upperBound += 1; //Adding one for inclusivity
        for (int i = 0; i < numOfRand; i++) {
            numList.add(Integer.toString(ThreadLocalRandom.current().nextInt(upperBound)));
        }

        return numList;
    }

    public static String randOutputOneLine(List<String> numList) {
        String temp = "";
        for (int i = 0; i < numList.size(); i++) {
            temp += numList.get(i) + " ";
        }

        return temp;
    }

    public static void fileCreate(String filename, List<String> output){
        try {
            Files.write(Paths.get(filename), output, StandardCharsets.UTF_8, StandardOpenOption.CREATE,
                    StandardOpenOption.WRITE);
        } catch (IOException e) {
            System.out.println("Error handling the file.");
        }
    }

}
