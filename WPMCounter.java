import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.time.LocalTime;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class WPMCounter {
  public static double calculateAccuracy(List<String> presentedWords, String userTyped) {
    String[] typedWords = userTyped.split(" ");
    int correctCount = 0;

    for (int i = 0; i < presentedWords.size() && i < typedWords.length; i++) {
        if (presentedWords.get(i).equals(typedWords[i])) {
            correctCount++;
        }
    }

    return (double) correctCount / presentedWords.size();
}
  
  static String[] easyWords = {"hello", "how", "dog", "cat", "easy"};
  static String[] mediumWords = {"elephant", "cashew", "medium", "wallet", "example"};
  static String[] hardWords = {"Excruciating", "Religious", "Microphone", "Mischievous", "Xenotransplantation"};
  
  public static void main(String[] args) throws InterruptedException {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Welcome to Words Per Minute Counter program.");
    System.out.println("Please choose a difficulty level");
    System.out.println("1: Easy");
    System.out.println("2. Medium");
    System.out.println("3. Hard");
    Random rand = new Random();
    String input = scanner.nextLine().trim();
    System.out.println("3");
    TimeUnit.SECONDS.sleep(1);
    System.out.println("2");
    TimeUnit.SECONDS.sleep(1);
    System.out.println("1");
    TimeUnit.SECONDS.sleep(1);
    List<String> presentedWords = new ArrayList<>();
    switch(input) {
      case "1": 
        for (int i = 0; i < 10; i++) {
          String word = easyWords[rand.nextInt(easyWords.length)];
          System.out.print(word + " ");
          presentedWords.add(word);
        }
        break;
      case "2": 
        for (int i = 0; i < 10; i++) {
          String word = mediumWords[rand.nextInt(mediumWords.length)];
          System.out.print(word + " ");
          presentedWords.add(word);
        }
        break;
      case "3": 
        for (int i = 0; i < 10; i++) {
          String word = hardWords[rand.nextInt(hardWords.length)];
          System.out.print(word + " ");
          presentedWords.add(word);
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
    
    double accuracy = calculateAccuracy(presentedWords, typedWords);
    System.out.println("Your accuracy is " + (accuracy * 100) + "%");
    System.out.println("Your calculated WPM is " + wpm);
    
   
  }
  
}
