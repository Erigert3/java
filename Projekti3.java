package projects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Projekti3 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		char[] simbole = { '♠', '♣', '♥', '♦' };
		String[] grade = { "As", " 2", " 3", " 4", " 5", " 6", " 7", " 8", " 9", "10", " J", " Q", " K" };
		byte[] pako = new byte[52];

		for (int i = 0; i < pako.length; i++) {
			pako[i] = (byte) i;
		}

		perziej(pako);

		byte[] letraLojtari1 = Arrays.copyOfRange(pako, 0, 5);
		pako = Arrays.copyOfRange(pako, 5, pako.length);

		System.out.println("Letrat fillestare jane: ");
		afishoLetra(letraLojtari1, simbole, grade);

		System.out.print("Deshiron ti nderrosh te gjitha? (po/jo) - ");
		String prgj = input.next();

		if (prgj.equalsIgnoreCase("po")) {
			letraLojtari1 = Arrays.copyOfRange(pako, 0, 5);
			pako = Arrays.copyOfRange(pako, 5, pako.length);
		} else {
			int il = 0;
			while (il < 5) {
				System.out
						.print("A do e nderroni letren " + emertim(letraLojtari1[il], simbole, grade) + "? (po/jo) - ");
				prgj = input.next();
				if (prgj.equalsIgnoreCase("po")) {
					letraLojtari1[il] = pako[0];
					pako = Arrays.copyOfRange(pako, 1, pako.length);
					System.out.println("Letra u zevendesua me " + emertim(letraLojtari1[il], simbole, grade) + ".");
				}
				il++;
			}
		}

		System.out.println("Letrat perfundimisht jane: ");
		afishoLetra(letraLojtari1, simbole, grade);

		System.out.println("Letrat formojne \"" + doreLetrash(letraLojtari1) + "\"");

		/****/

		/** ndaj letrat e lojtarit te dyte dhe pyete njesoj si per te parin */

		byte[] letraLojtari2 = Arrays.copyOfRange(pako, 0, 5);
		pako = Arrays.copyOfRange(pako, 5, pako.length);

		System.out.println("Letrat fillestare jane: ");
		afishoLetra(letraLojtari2, simbole, grade);

		System.out.print("Deshiron ti nderrosh te gjitha? (po/jo) - ");
		String prgj2 = input.next();

		if (prgj2.equalsIgnoreCase("po")) {
			letraLojtari2 = Arrays.copyOfRange(pako, 0, 5);
			pako = Arrays.copyOfRange(pako, 5, pako.length);
		} else {
			int i = 0;
			while (i < 5) {
				System.out
						.print("A do e nderroni letren " + emertim(letraLojtari2[i], simbole, grade) + "? (po/jo) - ");
				prgj2 = input.next();
				if (prgj2.equalsIgnoreCase("po")) {
					letraLojtari1[i] = pako[0];
					pako = Arrays.copyOfRange(pako, 1, pako.length);
					System.out.println("Letra u zevendesua me " + emertim(letraLojtari2[i], simbole, grade) + ".");
				}
				i++;
			}
		}

		/** afisho doren e letrave per lojtarin e dyte */

		System.out.println("Letrat perfundimisht jane: ");
		afishoLetra(letraLojtari2, simbole, grade);

		System.out.println("Letrat formojne \"" + doreLetrash(letraLojtari2) + "\"");

		/***
		 * krahaso doren e lojtarit te pare me te lojtarit te dyte per te kuptuar nese
		 * ka fitues apo jane barazim
		 */
		
		gjejFituesin(letraLojtari1, letraLojtari2);

	}
	
	public static void gjejFituesin(byte[] letraLojtari1, byte[] letraLojtari2) {
		if(doreLetrash(letraLojtari1) - doreLetrash(letraLojtari2) > 0) {
			System.out.println("Fituesi eshte lojtari 1!");
		}
		else if(doreLetrash(letraLojtari1) - doreLetrash(letraLojtari2) == 0) {
			System.out.println("Barazim!");			
		}
		else {
			System.out.println("Fituesi eshte lojtari 2!");
		}
	}

	private static byte doreLetrash(byte[] letraLojtari) {
		renditSipasGrades(letraLojtari);
		if (eshteRoyalFlush(letraLojtari)) {
			return 10;
		}
		if (eshteStraightFlush(letraLojtari)) {
			return 9;
		}
		if (eshteFourOfAKind(letraLojtari)) {
			return 8;
		}
		if (eshteFullHouse(letraLojtari)) {
			return 7;
		}
		if (eshteFlush(letraLojtari)) {
			return 6;
		}
		if (eshteStraight(letraLojtari)) {
			return 5;
		}
		if (eshteThreeOfAKind(letraLojtari)) {
			return 4;
		}
		if (eshteTwoPairs(letraLojtari)) {
			return 3;
		}
		if (eshteOnePair(letraLojtari)) {
			return 2;
		}
		return 1;
	}

	private static boolean eshteOnePair(byte[] letraLojtari) {
		for (int i = 0; i < letraLojtari.length - 1; i++) {
			int a = indeksGrade(letraLojtari[i]);
			for (int j = i + 1; j < letraLojtari.length; j++) {
				if (a == indeksGrade(letraLojtari[j])) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean eshteTwoPairs(byte[] letraLojtari) {
		for (int i = 0; i < 2; i++) {
			for (int j = i + 1; j < letraLojtari.length; j++) {
				if (indeksGrade(letraLojtari[i]) == indeksGrade(letraLojtari[j])) {
					letraLojtari[i] = -1;
					letraLojtari[j] = -2;
					if (eshteOnePair(letraLojtari)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	// {12, 4, 7, 23, 44}

	private static boolean eshteThreeOfAKind(byte[] letraLojtari) {
		for (int i = 0; i < 3; i++) {
			int a = indeksGrade(letraLojtari[i]);
			int cnt = 0;
			for (int j = 0; j < letraLojtari.length; j++) {
				if (a == indeksGrade(letraLojtari[j])) {
					cnt++;
				}
			}
			if (cnt == 3) {
				return true;
			}

		}
		return false;
	}

	private static boolean eshteStraight(byte[] letraLojtari) {
		int i = 0;
		if (indeksGrade(letraLojtari[0]) == 0 && indeksGrade(letraLojtari[1]) == 9) {
			i = 1;
		}
		for (; i < letraLojtari.length - 1; i++) {
			if (indeksGrade(letraLojtari[i]) + 1 != indeksGrade(letraLojtari[i + 1])) {
				return false;
			}
		}
		return true;
	}

	private static boolean eshteFlush(byte[] letraLojtari) {
		for (int i = 0; i < letraLojtari.length - 1; i++) {
			int simboli = indeksSimboli(letraLojtari[i]);
			for (int j = i + 1; j < letraLojtari.length; j++) {
				if (simboli != indeksSimboli(letraLojtari[j])) {
					return false;
				}
			}
		}
		return true;
	}

	private static boolean eshteFullHouse(byte[] letraLojtari) {
		for (int i = 0; i < 3; i++) {
			for (int j = i + 1; j < 4; j++) {
				if (indeksGrade(letraLojtari[i]) == indeksGrade(letraLojtari[j])) {
					for (int j2 = j + 1; j2 < letraLojtari.length; j2++) {
						if (indeksGrade(letraLojtari[j]) == indeksGrade(letraLojtari[j2])) {
							letraLojtari[i] = -1;
							letraLojtari[j] = -2;
							letraLojtari[j2] = -3;
							if (eshteOnePair(letraLojtari)) {
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}

	private static boolean eshteFourOfAKind(byte[] letraLojtari) {
		for (int i = 0; i < 2; i++) {
			int a = indeksGrade(letraLojtari[i]);
			int cnt = 0;
			for (int j = 0; j < letraLojtari.length; j++) {
				if (a == indeksGrade(letraLojtari[j])) {
					cnt++;
				}
			}
			if (cnt == 4) {
				return true;
			}

		}
		return false;
	}

	private static boolean eshteStraightFlush(byte[] letraLojtari) {
		return eshteStraight(letraLojtari) && eshteFlush(letraLojtari);
	}

	private static boolean eshteRoyalFlush(byte[] letraLojtari) {
		return eshteStraightFlush(letraLojtari) && indeksGrade(letraLojtari[0]) == 0
				&& indeksGrade(letraLojtari[4]) == 12;
	}

	private static void renditSipasGrades(byte[] letraLojtari) {
		for (int i = 0; i < letraLojtari.length - 1; i++) {
			int indMin = i;
			for (int j = i + 1; j < letraLojtari.length; j++) {
				if (indeksGrade(letraLojtari[j]) < indeksGrade(letraLojtari[indMin])) {
					indMin = j;
				}
			}
			byte tmp = letraLojtari[i];
			letraLojtari[i] = letraLojtari[indMin];
			letraLojtari[indMin] = tmp;
		}
	}

	private static void afishoLetra(byte[] letra, char[] simbole, String[] grade) {
		for (int leter : letra) {
			System.out.print(emertim(leter, simbole, grade) + "  ");
		}
		System.out.println();
	}

	private static void perziej(byte[] pako) {
		for (int i = 0; i < pako.length; i++) {
			byte randomIndexToSwap = (byte) (Math.random() * 52);
			byte temp = pako[randomIndexToSwap];
			pako[randomIndexToSwap] = pako[i];
			pako[i] = temp;
		}
	}

	private static String emertim(int leter, char[] simbole, String[] grade) {
		if (leter < 0 || leter > 53) {
			return "[----]";
		}
		return "[" + grade[indeksGrade(leter)] + " " + simbole[indeksSimboli(leter)] + "]";
	}

	private static int indeksSimboli(int leter) {
		return leter / 13;
	}

	private static int indeksGrade(int leter) {
		return leter % 13;
	}

}
