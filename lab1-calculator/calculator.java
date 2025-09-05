import java.util.Scanner;

public class calculator {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        double currentvalue=0;
        String operator="";
        boolean firstinput=true;
        System.out.println("Calculator (type 'exit' to quit)");

        while (true) {
            System.out.print("Enter number/operator: ");
            String input = sc.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Calculator exited.");
                break;
            }
            if (input.equals("+") || input.equals("-") ||
                        input.equals("*") || input.equals("/") || input.equals("=")) {
                    operator = input;
                    if (operator.equals("=")) {
                        System.out.println("Result: " + currentvalue);
                    } else {
                        System.out.println(currentvalue);
                    }
                }
    else {
            try {
                double number = Double.parseDouble(input);
                if (firstinput) {
                    currentvalue = number;
                    firstinput = false;
                    } else {
                        switch (operator) {
                            case "+": currentvalue += number; break;
                            case "-": currentvalue -= number; break;
                            case "*": currentvalue *= number; break;
                            case "/":
                                if (number != 0) currentvalue /= number;
                                else System.out.println("Error: Division by zero");
                                break;
                        }
                    }
                    System.out.println(currentvalue);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input, try again.");
                }
            }}
        sc.close();
    }
}