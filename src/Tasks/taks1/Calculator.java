package Tasks.taks1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        final String SUM_SIGN = "+";
        final String DIFFERENCE_SIGN = "-";
        final String MULTIPLICATION_SIGN = "*";
        final String RATIO_SIGN = "/";
        final String STOP_COMMAND = "stop";
        final String EXCEPTION_AND_ATTEMPTS = "You didn't enter a number. Try again! Attempts: ";

        byte attempts;
        String input = "";
        double first;
        double b;

        while (input.equalsIgnoreCase(STOP_COMMAND) != true) {
            System.out.println("Enter the first number.");
            attempts = 4;
            while (attempts > 0) {
                input = reader.readLine();
                if (input.equals("")) {
                    attempts -= 1;
                    System.out.println(EXCEPTION_AND_ATTEMPTS + attempts);
                } else {
                    try {
                        first = Double.parseDouble(input);
                    } catch (NumberFormatException e) {
                        attempts -= 1;
                        System.out.println(EXCEPTION_AND_ATTEMPTS + attempts);
                    }
                }
            }

        }
    }
}
