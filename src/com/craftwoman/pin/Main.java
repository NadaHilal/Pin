package com.craftwoman.pin;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean result = false;
		final String pin = "4321";
		for (int i = pin.length(); i > 1; i--) {
			final int DiffDigits = Integer.parseInt(pin.substring(i - 1, i))
					- Integer.parseInt(pin.substring(i - 2, i - 1));
			result = DiffDigits != Math.abs(1);
			System.out.println(DiffDigits + "  " + Math.abs(-1));
		}
		System.out.println(result);
	}

}
