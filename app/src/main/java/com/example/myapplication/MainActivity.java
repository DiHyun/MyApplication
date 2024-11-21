package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Scanner;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            System.out.println("Welcome to Word Guessing Game!");

            System.out.print("Enter words for the game (separated by spaces): ");
            String wordsInput = input.nextLine().toLowerCase();
            String[] words = wordsInput.split(" ");

            String secretWord = getRandomWord(words);
            int attempts = 6;
            StringBuilder guessedWord = new StringBuilder();
            //hello test
            for (int i = 0; i < secretWord.length(); i++) {
                guessedWord.append("_");
            }

            while (attempts > 0 && !secretWord.equals(guessedWord.toString())) {
                System.out.println("Attempts remaining: " + attempts);
                System.out.println("Guessed Word: " + guessedWord.toString());

                System.out.print("Guess a letter: ");
                String guess = input.nextLine().toLowerCase();

                if (guess.length() != 1) {
                    System.out.println("Please enter a single letter.");
                    continue;
                }

                char letter = guess.charAt(0);
                boolean found = false;

                for (int i = 0; i < secretWord.length(); i++) {
                    if (secretWord.charAt(i) == letter) {
                        guessedWord.setCharAt(i, letter);
                        found = true;
                    }
                }

                if (found) {
                    System.out.println("Correct!");
                } else {
                    System.out.println("Incorrect.");
                    attempts--;
                }

                if (guessedWord.toString().equals(secretWord)) {
                    System.out.println("Congratulations! You guessed the word: " + secretWord);
                    break;
                }
            }

            if (attempts == 0) {
                System.out.println("Game over! The word was: " + secretWord);
            }

            input.close();
        }

        // Helper method to select a random word from an array of words
        private static String getRandomWord(String[] words) {
            return words[(int) (Math.random() * words.length)];
        }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}