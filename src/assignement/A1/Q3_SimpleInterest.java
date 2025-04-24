package assignement.A1;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

//3. Write a program to input principal, time, and rate (P, T, R) from the user and
//find Simple Interest.

public class Q3_SimpleInterest {

	public static void calcSI(Optional<Double> pOpt, Optional<Double> tOpt, Optional<Float> rOpt)
			throws NegativeInputException {
		double p = pOpt.orElse(0.0);
		double t = tOpt.orElse(0.0);
		float r = rOpt.orElse(0.0f);

		if (p < 0 || t < 0 || r < 0) {
			throw new NegativeInputException("Negative inputs are not allowed. Try again.");
		}

		double si = (p * r * t) / 100;
		System.out.println("Simple Interest (SI) = " + si);
	}

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Program Started");

			boolean wannaContinue = true;

			while (wannaContinue) {
				try {
					System.out.print("Enter Principal Amount (p): ");
					Optional<Double> p = Optional.ofNullable(sc.nextDouble());

					System.out.print("Enter Time (t): ");
					Optional<Double> t = Optional.ofNullable(sc.nextDouble());

					System.out.print("Enter Rate ofNullable Interest (r): ");
					Optional<Float> r = Optional.ofNullable(sc.nextFloat());

					calcSI(p, t, r);

				} catch (InputMismatchException e) {
					System.out.println("Invalid input type. Please enter numeric values.");
					sc.nextLine();
					continue;
				} catch (NegativeInputException ne) {
					System.out.println(ne.getMessage());
					continue;
				}

				System.out.print("Wanna continue mate? (true/false): ");
				wannaContinue = sc.nextBoolean();
			}

		} catch (Exception e) {
			System.out.println("Unexpected error occurred: " + e.getMessage());
		} finally {
			System.out.println("Program Ended");
		}
	}
}

@SuppressWarnings("serial")
class NegativeInputException extends Exception {
	public NegativeInputException(String msg) {
		super(msg);
	}
}
