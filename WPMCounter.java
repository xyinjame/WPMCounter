import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.time.LocalTime;
import java.util.Random;

public class WPMCounter {
  public static double calculateCharacterAccuracy(String presentedString, String userTyped) {
    int minLength = Math.min(presentedString.length(), userTyped.length());
    int errors = 0;

    for (int i = 0; i < minLength; i++) {
      if (presentedString.charAt(i) != userTyped.charAt(i)) {
        errors++;
      }
    }

    errors += Math.abs(presentedString.length() - userTyped.length()); // Add errors for
                                                                       // extra/missing characters

    return (1.0 - (double) errors / presentedString.length()) * 100; // Convert fraction to
                                                                     // percentage
  }

  public static String randomizeCapitalization(String word, Random rand) {
    StringBuilder randomizedWord = new StringBuilder();
    for (char c : word.toCharArray()) {
      boolean capitalize = rand.nextBoolean();
      if (capitalize) {
        randomizedWord.append(Character.toUpperCase(c));
      } else {
        randomizedWord.append(Character.toLowerCase(c));
      }
    }
    return randomizedWord.toString();
  }

  static String[] easyWords = {"hello", "how", "dog", "cat", "easy", "pet", "iron", "gold", "zoo"};
  static String[] mediumWords =
      {"elephant", "cashew", "medium", "wallet", "example", "tissue", "paper", "towel", "bottle", "backpack"};
  static String[] hardWords = {"Excruciating", "Religious", "Microphone", "Mischievous",
      "Xenotransplantation", "Incomprehensibility", "Onomatopoeia", "Phenomenon", "Interdisciplinary", "Connoisseur"};

  public static void main(String[] args) throws InterruptedException {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Welcome to Words Per Minute Counter program.");
    System.out.println("Please choose a difficulty level.");
    System.out.println("1: Easy");
    System.out.println("2. Medium");
    System.out.println("3. Hard");
    System.out.println("4. Nightmare (Randomized capitalization)");

    Random rand = new Random();
    String input = scanner.nextLine().trim();

    // Start countdown
    System.out.println("");
    System.out.println("3");
    TimeUnit.SECONDS.sleep(1);
    System.out.println("2");
    TimeUnit.SECONDS.sleep(1);
    System.out.println("1");
    TimeUnit.SECONDS.sleep(1);

    StringBuilder presentedString = new StringBuilder();
    switch (input) {
      case "1":
        for (int i = 0; i < 10; i++) {
          String word = easyWords[rand.nextInt(easyWords.length)];
          System.out.print(word + " ");
          presentedString.append(word).append(" ");
        }
        break;
      case "2":
        for (int i = 0; i < 10; i++) {
          String word = mediumWords[rand.nextInt(mediumWords.length)];
          System.out.print(word + " ");
          presentedString.append(word).append(" ");
        }
        break;
      case "3":
        for (int i = 0; i < 10; i++) {
          String word = hardWords[rand.nextInt(hardWords.length)];
          System.out.print(word + " ");
          presentedString.append(word).append(" ");
        }
        break;
      case "4":
        for (int i = 0; i < 10; i++) {
          String word = hardWords[rand.nextInt(hardWords.length)];
          String randomizedWord = randomizeCapitalization(word, rand);
          System.out.print(randomizedWord + " ");
          presentedString.append(randomizedWord).append(" ");
        }
        break;
    }
    System.out.println();

    double start = LocalTime.now().toNanoOfDay();

    Scanner userScan = new Scanner(System.in);
    String typedWords = userScan.nextLine();

    double end = LocalTime.now().toNanoOfDay();
    double elapsedTime = end - start;
    double seconds = elapsedTime / 1000000000.0;
    int numChars = typedWords.length();
    int wpm = (int) ((((double) numChars / 5) / seconds) * 60);

    double accuracy = calculateCharacterAccuracy(presentedString.toString().trim(), typedWords);
    System.out.println("\nYour accuracy is " + accuracy + "%");
    System.out.println("Your calculated WPM is " + wpm);


  }

}
