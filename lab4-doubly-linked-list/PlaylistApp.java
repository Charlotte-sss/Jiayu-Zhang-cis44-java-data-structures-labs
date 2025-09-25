// PlaylistApp.java (main class with menu)
import java.util.Scanner;

public class PlaylistApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Playlist playlist = new Playlist();
        int choice;

        do {
            System.out.println("\n=== Playlist Manager ===");
            System.out.println("1. Add Song");
            System.out.println("2. Remove Song");
            System.out.println("3. Play Next");
            System.out.println("4. Display Playlist");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = input.nextInt();
            input.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter song title: ");
                    String title = input.nextLine();
                    System.out.print("Enter artist: ");
                    String artist = input.nextLine();
                    playlist.addSong(new Song(title, artist));
                    break;
                case 2:
                    System.out.print("Enter song title to remove: ");
                    String removeTitle = input.nextLine();
                    playlist.removeSong(removeTitle);
                    break;
                case 3:
                    playlist.playNext();
                    break;
                case 4:
                    playlist.displayPlaylist();
                    break;
                case 5:
                    System.out.println("Exiting Playlist Manager...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);

        input.close();
    }
}
