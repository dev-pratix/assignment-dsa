package assignement.A1;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * 1. Write a program to print whether a number is even or odd, also take
	input from the user.
 */

public class Q1_EvenNumber {
	public static boolean isEven(int number) {
		if (number < 0)
			number = number * -1;

		return number % 2 == 0;
	}

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Program Started");
			System.out.println("For exit press any character (A-Z)(a-z)");
			while (true) {
				System.out.print("Enter Number : ");
				int number = sc.nextInt();
				if (isEven(number)) {
					System.out.println("Even : " + number);
				} else {
					System.out.println("Odd : " + number);
				}
			}

		} catch (InputMismatchException ip) {
			System.out.println("Exiting the Program");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Program Ended");
		}

	}

}
