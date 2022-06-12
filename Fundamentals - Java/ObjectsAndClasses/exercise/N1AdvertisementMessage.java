package ObjectsAndClasses.exercise;

import java.util.*;


public class N1AdvertisementMessage {
    public static void main(String[] args) {
        List<String> phrases = new ArrayList<>(Arrays.asList("Excellent product.", "Such a great product.", "I always use that product.", "Best product of its category.", "Exceptional product.", "I can't live without this product."));
        List<String> events = new ArrayList<>(Arrays.asList("Now I feel good.", "I have succeeded with this product.", "Makes miracles. I am happy of the results!", "I cannot believe but now I feel awesome.", "Try it yourself, I am very satisfied.", "I feel great!"));
        List<String> authors = new ArrayList<>(Arrays.asList("Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"));
        List<String> cities = new ArrayList<>(Arrays.asList("Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"));

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Random rndPhrase = new Random();
        Random rndEvent = new Random();
        Random rndAuthor = new Random();
        Random rndCity = new Random();
        for (int i = 0; i < n; i++) {
            int rndP = rndPhrase.nextInt(phrases.size());
            int rndE = rndEvent.nextInt(events.size());
            int rndA = rndAuthor.nextInt(authors.size());
            int rndC = rndCity.nextInt(cities.size());
            //print random messages
            System.out.printf("%s %s %s - %s.%n",phrases.get(rndP),events.get(rndE), authors.get(rndA),cities.get(rndC));

        }
    }
}
