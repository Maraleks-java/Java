package Tasks.taks1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculator {

    public static boolean checkMathCommand(char command) {
        char[] commands = {'+', '-', '*', '/' };
        for(int i = 0; i < commands.length; i++) {
            if(command == commands[i])
                return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        boolean processingIsAvailable = true;
        while (processingIsAvailable){
            byte attempts = 3;
            String input;
            double firstNumber = 0;
            double secondNumber = 0;
            int userCommand = 0;
            byte stage = 1;
            while (attempts > 0) {
                try {

                    if(stage == 1 || stage == 3) {
                        System.out.println("Enter the number. To exit - enter \"stop\"");
                        input = reader.readLine();
                        if(input.equalsIgnoreCase("stop")){
                            processingIsAvailable = false;
                            break;
                        }
                        if(stage == 1) {
                            firstNumber = Double.parseDouble(input);
                        }
                        if(stage == 3) {
                            secondNumber = Double.parseDouble(input);
                        }
                        stage++;
                    }

                    if(stage == 2) {
                        System.out.println( "Enter the command [+ , -, *, /]");
                        userCommand = reader.read();
                        char[] commands = {'+', '-', '*', '/' };
                        for (int i = 0; i < commands.length; i++) {
                            if(commands[i] == userCommand) {
                                stage++;
                                break;
                            }
                        }
                        if(userCommand == 'd') {
                            attempts--;
                            System.out.println( "You entered the wrong command! Attempts: " + attempts);
                        }
                    }

                    if(stage == 4) {
                        switch (userCommand) {
                            case '+':
                                System.out.println(firstNumber + secondNumber);
                                break;
                            case '-':
                                System.out.println(firstNumber - secondNumber);
                                break;
                            case '*':
                                System.out.println(firstNumber * secondNumber);
                                break;
                            case '/':
                                System.out.println(firstNumber / secondNumber);
                                break;
                        }
                        break;
                    }

                } catch (NumberFormatException e) {
                    attempts--;
                    System.out.println("You didn't enter a number. Try again! Attempts: " + attempts);
                }
            }
        }
    }
}
