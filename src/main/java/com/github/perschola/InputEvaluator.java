package com.github.perschola;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class InputEvaluator {

    private int number;
    private long factorial;
    private boolean exc, posInput;

    public boolean isPosInput() {
        return posInput;
    }

    public void setPosInput(boolean posInput) {
        this.posInput = posInput;
    }

    public InputEvaluator(){exc = true; posInput = false; factorial = 1; number = -1;}

    private boolean isExc() {
        return exc;
    }

    private void setExc(boolean exc) {
        this.exc = exc;
    }

    private int getNumber() {
        return number;
    }

    private void setNumber(int number) {
        this.number = number;
    }

    private long getFactorial() {
        return factorial;
    }

    private void setFactorial(long factorial) {
        this.factorial = factorial;
    }

    private void readInputFromUser(Scanner scanner) {
        while (!isPosInput()) {
            while (isExc()) {
                setExc(false);
                try {
                    setNumber(scanner.nextInt());
                } catch (InputMismatchException ime) {
                    System.out.println("Please, enter an integer");
                    setExc(true);
                    setPosInput(false);
                    scanner.nextLine();
                }

                if (!isExc() & (getNumber() < 0)) {
                    setPosInput(false);
                    setExc(true);
                    System.out.println("Please enter a positive integer:");
                    scanner.nextLine();
                }
                if (!isExc() & (getNumber() >= 0)) {
                    setPosInput(true);
                    scanner.close();
                }
            }
        }
    }

    private void calculateFactorialOfInput()
    {
        if (getNumber() == 0)
            setFactorial(1);
        else {
            for (AtomicInteger i = new AtomicInteger(getNumber()); i.get() > 1; i.getAndDecrement())
                setFactorial(getFactorial() * i.get());
        }
    }

    protected void run() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please, enter an integer");

        readInputFromUser(scanner);
        calculateFactorialOfInput();
        System.out.println("The factorial of " + getNumber() + " is " + getFactorial());
    }
}
