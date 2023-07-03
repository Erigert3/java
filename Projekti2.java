package projects;

import java.util.Arrays;
import java.util.Scanner;
 
public class Projekti2 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);

		char[][] table = { 
				{ '-', '-', '-' }, 
				{ '-', '-', '-' }, 
				{ '-', '-', '-' } 
			};

		char symbol1 = 'O', symbol2 = 'X';

		char playerSymbol = symbol1;

		if ((byte) (Math.random() * 2) == 1) {
			playerSymbol = symbol2;
		}

		while (!win(table) && possibleWinner(table)) { 
			if(playerSymbol == symbol1) {
				playerSymbol = symbol2;
			}
			else {
				playerSymbol = symbol1;
			}
			show(table);
			System.out.println("The player with the symbol '" + playerSymbol + "' "
					+ "has his turn.");
			System.out.print("Insert the identifying number of row [1-3]: ");
			int ir = input.nextInt(); 
			while(ir < 1 || ir > 3) {
				System.out.println("Incorrect input!");
				System.out.print("Insert the identifying number of row [1-3]: ");
				ir = input.nextInt(); 
			}
			System.out.print("Insert the identifying number of column [1-3]: ");
			int ik = input.nextInt();
			while(ik < 1 || ik > 3) {
				System.out.println("Incorrect input!");
				System.out.print("Insert the identifying number of column [1-3]: ");
				ik = input.nextInt(); 
			}
			if(table[ir - 1][ik - 1] != '-') {
				System.out.println("Incorrect input!");
				continue;
			}
			table[ir - 1][ik - 1] = playerSymbol;
		} 
		System.out.println("\n\n");
		show(table);
		System.out.println("\n\n");
		if(win(table)) {
			System.out.println("The winner is " + playerSymbol + ".");
		}
		else {
			System.out.println("It's a tie!");
		}
		
	}

	public static void show(char[][] table) {
		System.out.println("---------");
		for(char[] r : table) {
			System.out.println(Arrays.toString(r));
		}
		System.out.println("---------");
	}

	public static boolean possibleWinner(char[][] table) {
		for (int i = 0; i < table.length; i++) {
			if(thereIsUpToOneSymbol(table[i]) ||
			   thereIsUpToOneSymbol(convertColumnToArray(table, i))) {
				return true;
			}
		}
		if(thereIsUpToOneSymbol(convertDiagonal1toArray(table)) ||
		   thereIsUpToOneSymbol(convertDiagonal2toArray(table))) {
			return true;
		}
		return false;
	}

	private static char[] convertDiagonal2toArray(char[][] table) {
		char[] v = new char[table.length];
		v[0] = table[0][2];
		v[1] = table[1][1];
		v[2] = table[2][0];
		return v;
	}
	
	private static char[] convertDiagonal1toArray(char[][] table) {
		char[] v = new char[table.length];
		v[0] = table[0][0];
		v[1] = table[1][1];
		v[2] = table[2][2];
		return v;
	}

	private static char[] convertColumnToArray(char[][] table, int i) {
		if(i < 0 || i > table.length) {
			return null;
		}
		char[] v = new char[table.length];
		v[0] = table[0][i];
		v[1] = table[1][i];
		v[2] = table[2][i];
		return v;
	}

	private static boolean thereIsUpToOneSymbol(char[] v) {
		String str = ""; 
		for (int i = 0; i < v.length; i++) {
			if(v[i] != '-') {
				str += v[i];
			}
		}
		return str.length() < 2;
	}

	public static boolean win(char[][] table) {
		for (int i = 0; i < table.length; i++) {
			if(hasSameSymbol(table[i]) ||
			   hasSameSymbol(convertColumnToArray(table, i))) {
				return true;
			}
		}
		if(hasSameSymbol(convertDiagonal1toArray(table)) ||
		   hasSameSymbol(convertDiagonal2toArray(table))) {
			return true;
		}
		return false;
	}

	private static boolean hasSameSymbol(char[] v) {
		if(v[0] == '-') {
			return false;
		} 
		if((v[0] == 'O' && v[1] == 'O' && v[2] == 'O') || (v[0] == 'X' && v[1] == 'X' && v[2] == 'X')) {
			return true;
		}
		return false;
	}

}
