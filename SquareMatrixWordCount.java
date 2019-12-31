package com.coding;

import java.util.Scanner;

public class SquareMatrixWordCount {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int inputSize = in.nextInt();
		String[] inputValues = new String[inputSize];
		for (int j = 0; j < inputValues.length; j++) {
			inputValues[j] = in.next();
		}
		String searchVal = in.next();
		getWordCount(inputSize, inputValues, searchVal);
		in.close();
	}

	public static void getWordCount(int inputArraySize, String[] inputStringArray, String searchValue) {
		int outputCount = 0;
		StringBuilder firstDiagonal = new StringBuilder();
		StringBuilder secondDiagonal = new StringBuilder();
		try {
			StringBuilder[] inputAlphabets = new StringBuilder[inputStringArray.length];
			StringBuilder[] columns = new StringBuilder[inputStringArray.length];
			for (int i = 0; i < inputStringArray.length; i++) {
				inputAlphabets[i] = new StringBuilder();
				inputStringArray[i] = inputStringArray[i].replace("#", "");
				inputAlphabets[i].append(inputStringArray[i]);
				outputCount += getMatchInMatrixFormed(inputStringArray[i], searchValue);
				outputCount += getMatchInMatrixFormed(inputAlphabets[i].reverse().toString(), searchValue);
				firstDiagonal.append(inputStringArray[i].charAt(i));
				secondDiagonal.append(inputStringArray[i].charAt(inputArraySize - i - 1));
				for (int j = 0; j < inputArraySize; j++) {
					if (columns[j] == null) {
						columns[j] = new StringBuilder();
					}
					columns[j].append(inputStringArray[i].charAt(j));
				}
			}
			outputCount += getMatchInMatrixFormed(firstDiagonal.toString(), searchValue);
			outputCount += getMatchInMatrixFormed(firstDiagonal.reverse().toString(), searchValue);
			outputCount += getMatchInMatrixFormed(secondDiagonal.toString(), searchValue);
			outputCount += getMatchInMatrixFormed(secondDiagonal.reverse().toString(), searchValue);
			for (int j = 0; j < inputArraySize; j++) {
				outputCount += getMatchInMatrixFormed(columns[j].toString(), searchValue);
				outputCount += getMatchInMatrixFormed(columns[j].reverse().toString(), searchValue);
			}
		} catch (Exception e) {
			e.getMessage();
		}
		System.out.print(outputCount);
	}

	public static int getMatchInMatrixFormed(String ip, String input) {
		return (ip.length() - ip.replace(input, "").length()) / input.length();
	}

}
