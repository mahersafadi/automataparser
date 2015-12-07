package com.automata.handler;

import java.util.Scanner;

public class MainProgram {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		SentenseHandler sentenseHandler = new SentenseHandler();
		System.out.println("Welcom To Our Sentense Generator Test.......");
		System.out.println("Enter file path of grammars");
		String filePath = scanner.nextLine();
		System.out.println("Please Enter The number Of Sentenses > 0");
		int numberofSentenses = scanner.nextInt();
		if (numberofSentenses > 0) {
			while (numberofSentenses != 0) {
				StringBuffer s = sentenseHandler.handleSentense("<sentence>",
						filePath);
				System.out.println(s.toString());
				numberofSentenses--;
			}
		} else {
			System.out.println("Wrong number entered, it is less than zero");
		}
		System.out.println(" Enter -1 to exi");

	}
}
