package ExamTraining.random;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputText = scanner.nextLine();

        List<String> emojis = foundEmoji(inputText);
        BigInteger bigInteger = foundCoolThreshold(inputText);
        int emojisCount = emojis.size();

        System.out.println("Cool threshold: " + bigInteger);
        System.out.println(emojisCount + " emojis found in the text. The cool ones are:");

        printTheCoolEmojis(emojis, bigInteger);

    }

    public static List<String> foundEmoji(String inputText) {
        List<String> emojis = new ArrayList<>();

        Pattern pattern = Pattern.compile("([*?:?]{1})\\1[A-Z][a-z]{2,}\\1\\1");
        Matcher matcher = pattern.matcher(inputText);

        boolean isFond = matcher.find();

        while (isFond) {
            emojis.add(matcher.group());
            isFond = matcher.find();
        }

        return emojis;
    }

    public static BigInteger foundCoolThreshold(String inputText) {
        BigInteger bigInteger = new BigInteger("1");
        Pattern pattern = Pattern.compile("\\d");
        Matcher matcher = pattern.matcher(inputText);

        boolean isFond = matcher.find();

        while (isFond) {
            bigInteger = bigInteger.multiply(BigInteger.valueOf(Long.parseLong(matcher.group().toString())));
            isFond = matcher.find();
        }

        return bigInteger;
    }

    private static void printTheCoolEmojis(List<String> emojis, BigInteger bigInteger) {

        for (String emoji : emojis) {
            char[] emojiAsCharSequence = emoji.toCharArray();
            long coolPowerOfEmoji = 0;
            for (int i = 2; i < emojiAsCharSequence.length - 2; i++) {
                coolPowerOfEmoji += emojiAsCharSequence[i];
            }
            int compare = bigInteger.compareTo(BigInteger.valueOf(coolPowerOfEmoji));
            if (compare <= 0) {
                System.out.println(emoji);
            }
        }

    }
}
