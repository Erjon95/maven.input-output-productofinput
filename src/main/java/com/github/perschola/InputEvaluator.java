package com.github.perschola;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputEvaluator {
    public void run() {
        // prompt user to input number
        // get user input
        // create product variable

        // create counter variable
        // evaluate input from user
            // multiply counter by product
            // increment counter by 1

        // display product to user
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter an integer");
        do{
            int input = scanner.nextInt();



        int product = 1;

        for (int i = 1; i <= input; i++)
            product *= i;

        System.out.println("The factorial of " + input + " " + product);


    }
}
