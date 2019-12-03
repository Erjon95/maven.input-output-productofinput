package com.github.perschola;

import java.util.Scanner;

public class InputEvaluator {
    public void run() {

        int input = -1;

        System.out.println("Please enter a positive integer:");
        Scanner scanner = new Scanner(System.in);

        do {
            if (!scanner.hasNextInt()) {
              
                System.out.println("Please enter a positive integer:");
                scanner.nextLine();
            } else {
                input = scanner.nextInt();

                if (input < 0)
                {
                    System.out.println("Please enter a positive integer:");
                    
                } else {
                    int product = 1;

                    if (input > 0)
                        for (int i = 1; i <= input; i++)
                            product *= i;

                    System.out.println("The factorial of " + input + " is " + product);
                    break;
                }
            }
        }while (!scanner.hasNextInt() || (input < 0));
    }
}
