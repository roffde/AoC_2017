package fr.deroffal.aoc;

import fr.deroffal.aoc.util.Utils;

public class Day09 {

	public static void main(String[] args) {
		final String input = Utils.readLine("day09.txt");

		System.out.println("Partie 1 : " + countScore(input));

	}

	static int countScore(final String in) {
		final String withoutGarbage = removeGarbage(in);
		int score = 0;
		int localScore = 0;
		for (final char c : withoutGarbage.toCharArray()) {
			if (c == '{') {
				localScore++;
			} else if (c == '}') {
				score += localScore--;
			}
		}
		return score;
	}

	static String removeGarbage(final String input) {
		final String whitoutCanceled = removeCanceledCharacters(input);
		StringBuilder out = new StringBuilder();
		for (int i = 0; i < whitoutCanceled.length(); i++) {
			final char charAt = whitoutCanceled.charAt(i);
			if (charAt == '<') {
				i = whitoutCanceled.indexOf('>', i);
			} else {
				out.append(charAt);
			}
		}
		return out.toString();
	}

	static String removeCanceledCharacters(final String in) {
		StringBuilder out = new StringBuilder();
		for (int i = 0; i < in.length(); i++) {
			final char charAt = in.charAt(i);
			if (charAt == '!') {
				++i;
			} else {
				out.append(charAt);
			}
		}
		return out.toString();
	}

}