import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Files;
import java.util.concurrent.ThreadLocalRandom;

public class randomOutput {

    public static void main(String[] args) {
        String filename = "randomData.txt";
        List<String> numList = new ArrayList(); //Each index holds an individual number
        List<String> output = new ArrayList(); //To transfer 'temp' into in it's first position
        String temp = ""; //As an accumulator for all of the numbers
        Charset utf8 = StandardCharsets.UTF_8;
        int randInt = ThreadLocalRandom.current().nextInt(101);


        for (int i = 0; i < randInt; i++) {
            numList.add(Integer.toString(ThreadLocalRandom.current().nextInt(101)));
        }

        for (int i = 0; i < numList.size(); i++) {
            temp += numList.get(i) + " ";
        }

        output.add(temp);

        try {
            Files.write(Paths.get(filename), output, utf8, StandardOpenOption.CREATE,
                    StandardOpenOption.WRITE);
        } catch (IOException e) {
            System.out.println("Error handling the file.");
        }
    }
}
