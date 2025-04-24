package assignement.A1;

import java.util.InputMismatchException;
import java.util.Scanner;

//4. Take in two numbers and an operator (+, -, *, /) and calculate the value.
//(Use if conditions)

public class Q4_CalcLite {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Program Started");
			boolean wannaResume = true;

			while (wannaResume) {
				try {
					System.out.println("Please enter two numbers: ");
					float fNum1 = sc.nextFloat();
					float fNum2 = sc.nextFloat();

					System.out.println("Enter the arithmetic operation (+, -, *, /): ");
					char choice = sc.next().charAt(0);

					float result = 0;
					boolean validOperation = true;

					switch (choice) {
						case '+':
							result = fNum1 + fNum2;
							break;
						case '-':
							result = fNum1 - fNum2;
							break;
						case '*':
							result = fNum1 * fNum2;
							break;
						case '/':
							if (fNum2 == 0) {
								System.out.println("Division by zero is not allowed!");
								validOperation = false;
							} else {
								result = fNum1 / fNum2;
							}
							break;
						default:
							throw new InvalidInputOperatorException("Invalid operator entered! Please use +, -, *, or /.");
					}

					if (validOperation) {
						System.out.println("Result: " + result);
					}

					System.out.println("Do you want to perform another calculation? (yes/no)");
					String resumeInput = sc.next().toLowerCase();
					wannaResume = resumeInput.equals("yes");

				} catch (InputMismatchException ip) {
					System.out.println("Invalid input! Please enter numeric values.");
					sc.nextLine();
				} catch (InvalidInputOperatorException iioe) {
					System.out.println(iioe.getMessage());
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Program Ended");
		}
	}

	@SuppressWarnings("serial")
	static class InvalidInputOperatorException extends Exception {
		public InvalidInputOperatorException(String message) {
			super(message);
		}
	}
}
