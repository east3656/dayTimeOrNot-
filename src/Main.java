import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // define waking hours (customize as needed)
        LocalDateTime startWakingHour = LocalDateTime.of(2024, 1, 1, 6, 0); // 6:00 AM
        LocalDateTime endWakingHour = LocalDateTime.of(2024, 1, 1, 22, 0); // 10:00 PM

        Scanner scanner = new Scanner(System.in);


        //inputs
        System.out.println("Enter the time to add in days: ");
        int daysToAdd = scanner.nextInt();

        System.out.print("Enter the time to add in hours: ");
        int hoursToAdd = scanner.nextInt();

        System.out.print("Enter the time to add in minutes: ");
        int minutesToAdd = scanner.nextInt();

        //get current time.
        LocalDateTime currentTime = LocalDateTime.now();

        //compute future time.
        LocalDateTime futureTime = currentTime.plusDays(daysToAdd).plusHours(hoursToAdd).plusMinutes(minutesToAdd);

        //check if the future time is within waking hours (considering only time part)
        boolean isAwake = !futureTime.toLocalTime().isBefore(startWakingHour.toLocalTime()) &&
                !futureTime.toLocalTime().isAfter(endWakingHour.toLocalTime());

        //formatter creation.
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        //output
        System.out.println("\n--- Task Completion Details ---");
        System.out.println("Current time: " + currentTime.format(formatter));
        System.out.println("Future time (task completion time): " + futureTime.format(formatter));
        System.out.println("Will you be awake? " + (isAwake ? "Yes" : "No bruh"));

        scanner.close();
    }
}
