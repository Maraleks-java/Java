package Tasks.taks1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Calculator {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        final String STOP_COMMAND = "stop";
        final String EXCEPTION_AND_ATTEMPTS = "You didn't enter a number. Try again! Attempts: ";
        final String PROMPT_TO_ENTER = "Enter the number. To exit - enter \"" + STOP_COMMAND + "\"";
        final String PROMPT_TO_COMMAND = "Enter the command [+ , -, *, /]. To exit - enter \"" + STOP_COMMAND + "\"";
        final String DIVISION_BY_ZERO = "You cannot divide by zero! Attempts: ";
        final String INCORRECT_COMMAND = "You entered the wrong command! Attempts: ";
        byte inputСounter = 1;
        String input = "";
        double first = 0;
        double second = 0;
        boolean flag = true;
        char command = 'd';


        while (flag) {
            byte attempts = 3;
            while (attempts > 0) {
                if(inputСounter == 2) {
                    System.out.println(PROMPT_TO_COMMAND);
                    input = reader.readLine();
                } else if (inputСounter < 4) {
                    System.out.println(PROMPT_TO_ENTER);
                    input = reader.readLine();
                }
                if (input.equalsIgnoreCase(STOP_COMMAND)) {
                    flag = false;
                    break;
                }
                try {
                    if (inputСounter == 1) {
                        first = Double.parseDouble(input);
                        inputСounter++;
                        break;
                    }

                    if(inputСounter == 2 || inputСounter == 4){

                        if(inputСounter == 2){
                            command = input.charAt(0);
                            inputСounter++;
                            break;
                        } else {
                            switch (command) {
                                case '+':
                                    System.out.println(first + second);
                                    inputСounter = 1;
                                    break;
                                case '-':
                                    System.out.println(first - second);
                                    inputСounter = 1;
                                    break;
                                case '*':
                                    System.out.println(first * second);
                                    inputСounter = 1;
                                    break;
                                case '/':
                                    if (second == 0) {
                                        attempts--;
                                        System.out.println(DIVISION_BY_ZERO + attempts);
                                        inputСounter = 1;
                                        break;
                                    }
                                    System.out.println(first / second);
                                    break;
                                default:
                                    attempts--;
                                    System.out.println(INCORRECT_COMMAND + attempts);
                            }
                        }

                    }

                    if (inputСounter == 3) {
                        second = Double.parseDouble(input);
                        inputСounter++;
                        break;
                    }

                } catch (NumberFormatException e) {
                    attempts--;
                    System.out.println(EXCEPTION_AND_ATTEMPTS + attempts);
                }
            }
        }
    }
}