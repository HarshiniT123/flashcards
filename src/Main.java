import static java.lang.System.out;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * A flashcard quiz that re-quizzes only the terms the user misses.
 *
 * @author Harshini Tammineedi
 * @version November 2026
 */

public class Main {
    /**
     * Reads flashcards from a file into a list.
     *
     */

    public static ArrayList<String> loadCards(String fileName) {
        ArrayList<String> cards = new ArrayList<>();
        try {
            Scanner file = new Scanner(new File(fileName));
            while (file.hasNextLine()) {
                String line = file.nextLine();
                if (line.contains("|")) {
                    cards.add(line);
                }
            }
            file.close();
        } catch (FileNotFoundException e) {
            out.println("Could not find " + fileName);
        }
        return cards;
    }
    /**
     * Quizzes the user on every card once.
     *
     */

    public static ArrayList<String> quiz(ArrayList<String> cards, Scanner keyboard) {
        ArrayList<String> missed = new ArrayList<>();
        int score = 0;
        for (String card : cards) {
            String[] parts = card.split("\\|");
            out.println();
            out.println("Term: " + parts[0].trim());
            out.print("Your answer: ");
            keyboard.nextLine();
            out.println("Definition: " + parts[1].trim());
            out.print("Did you get it right? (y/n): ");
            if (keyboard.nextLine().equals("y")) {
                score++;
            } else {
                missed.add(card);
            }
        }
        out.println("Score: " + score + "/" + cards.size());
        return missed;
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        ArrayList<String> cards = loadCards("terms.txt");
        if (cards.isEmpty()) {
            out.println("No cards found. Add lines like: term | definition");
            return;
        }
        ArrayList<String> missed = quiz(cards, keyboard);
        if(missed.isEmpty()) {
            out.println("Perfect, nothing to review!");
        } else {
            out.println("Re-quizzing " + missed.size() + " missed terms...");
            quiz(missed, keyboard);
        }
    }
}