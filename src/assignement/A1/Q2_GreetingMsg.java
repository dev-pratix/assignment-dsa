package assignement.A1;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

//2. Take name as input and print a greeting message for that particular name.

public class Q2_GreetingMsg {

	public static void greetYou(String name) {
		if (name == null || name.isEmpty()) {
			greetYou("NameLessFollowInTheHouse");
		}
		System.out.println("Yoh " + name + " !! Enjoy this 24 hours of your life man!!");
		System.out.println("Keep living man life too hard here");
	}

	public static void greetYouOptional(String name) {
		String opName = Optional.ofNullable(name).orElse("NameLessFollowInTheHouse");
		System.out.println("It's cool AF !! Using the optional... Right my pal");
		System.out.println("Sorry i forget your name it's " + opName + " right !? Hehehe... :)");
		System.out.println(
				"Nevermind !! be the guy where people remeber ur name... LoL sorry but i really did'nt meant to hurt u");
		System.out.println("I know man ur not that soft to get hurt easily");
	}

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Program Started");
			while (true) {
				System.out.print("Enter Your Name (greet without optional) : ");
				String name = sc.nextLine();
				greetYou(name);

				System.out.print("Enter Your Name (greet with optional) : ");
				name = sc.nextLine();
				greetYouOptional(name);
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
