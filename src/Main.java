import static java.lang.System.out;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> cards = new ArrayList<>();
        Scanner keyboard = new Scanner(System.in);
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
        String[] parts = cards.get(0).split("\\|");
        out.println("Term: " + parts[0].trim());
        out.print("Your answer: ");
        keyboard.nextLine();
        out.println("Definition: " + parts[1].trim());
        out.print("Did you get it right? (y/n): ");
        if (keyboard.nextLine().equals("y")) {
            out.println("Correct!");

        } else {
            out.println("Missed it.");
        }
    }
}