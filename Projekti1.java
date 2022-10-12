package projects;

import java.util.Scanner;

public class Projekti1 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		String[] array = { "Taumata",
				/// shkurt Taumata - emertimi me i gjate i nje vendi, rajon ne Zelanden e re
				"Ouagadougou"
				/// kryeqyteti i Burkina Faso
		};

		String choosenWord = chooseTheWord(array);
		String hiddenWord = hideTheWord(choosenWord);

		System.out.println("Vendos karakter per te zbuluar fjalen!");
		while (!choosenWord.equals(hiddenWord)) {

			System.out.print(hiddenWord + " : ");
			char k = input.next().charAt(0);
			hiddenWord = showCharacter(hiddenWord, k, choosenWord);
		}
		System.out.println("Urime, ju zbuluat fjalen \"" + choosenWord + "\".");
		input.close();
	}

	private static String chooseTheWord(String[] str) {
		return str[(int) (Math.random() * 2)];
		// zevendeso null me instruksion qe perzgjedh nje nga elementet e vektorit ne
		// parameter
	}

	public static String showCharacter(String hiddenWord, char k, String choosenWord) {
		String str = "";
		k = Character.toLowerCase(k);
		for (int i = 0; i < hiddenWord.length(); i++) {
			if ((choosenWord.charAt(i)).equals(k)) {
				hiddenWord.replace(hiddenWord.charAt(i), k);
				str = hiddenWord;
			}
		}
		/// shto ne str karakterin e zbuluar ose ate ekzistent
		return str;
	}

	private static String hideTheWord(String str) {
		String rez = "";
		for (int i = 0; i < str.length(); i++) {
			rez += "*";
		}
		/// zhvillo kod ketu
		return rez; /// rez duhet te permbaje * aq here sa eshte gjatesia e str
	}

}
