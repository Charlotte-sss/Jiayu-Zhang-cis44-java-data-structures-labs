import java.util.Scanner;

public class TextEditorApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TextEditor editor = new TextEditor();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add text");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Print current");
            System.out.println("5. Exit");
            System.out.print("Choose: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter text to add: ");
                    String text = scanner.nextLine();
                    editor.add(text);
                    break;
                case 2:
                    editor.undo();
                    break;
                case 3:
                    editor.redo();
                    break;
                case 4:
                    editor.printCurrent();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
