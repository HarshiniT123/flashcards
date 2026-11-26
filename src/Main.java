import static java.lang.System.out;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> cards = new ArrayList<>();
        try {
            Scanner file = new Scanner(new File("terms.txt"));
            while (file.hasNextLine()) {
                cards.add(file.nextLine());

            }
            file.close();

        } catch (FileNotFoundException e) {
            out.println("Could not find terms.txt");
            return;
        }
        for (String card : cards) {
            String[] parts = card.split("\\|");
            out.println("Terms: " + parts[0].trim());
            out.println("Definition: " + parts[1].trim());
        }
    }
}