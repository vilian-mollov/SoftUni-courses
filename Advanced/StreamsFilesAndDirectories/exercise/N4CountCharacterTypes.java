package StreamsFilesAndDirectories.exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class N4CountCharacterTypes {
    public static void main(String[] args) {
        int vowels = 0;
        int consonants = 0;
        int punctuation = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            int oneByte = reader.read();
            char ch;
            while (oneByte >= 0) {
                ch = (char) oneByte;
                switch (ch) {
                    case 'a':
                    case 'o':
                    case 'e':
                    case 'i':
                    case 'u':
                        vowels++;
                        break;
                    case '.':
                    case '!':
                    case '?':
                    case ',':
                        punctuation++;
                        break;
                    case ' ':
                    case '\n':
                    case '\r':
                        break;
                    default:
                        consonants++;
                }
                oneByte = reader.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
        System.out.println("Punctuation: " + punctuation);

    }
}
