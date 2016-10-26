package com.craftwoman.pin;

import java.util.logging.Level;
import java.util.logging.Logger;

public class PinValidator {

	private static final String NON_NUMERIC_ERROR_MESSAGE = "pin must be numerical";

	private static final Logger LOGGER = Logger.getLogger(PinValidator.class.getName());

	private static final int PIN_SIZE = 4;

	public Boolean validate(String pin) {

		return isNumeric(pin) && isFourCharacters(pin) && isNotDecreasingOrIncreasingSequence(pin);
	}

	private boolean isNotDecreasingOrIncreasingSequence(String pin) {
		boolean result = false;
		for (int i = PIN_SIZE; i > 1; i--) {
			final int DiffDigits = getIntValue(pin.substring(i - 1, i)) - getIntValue(pin.substring(i - 2, i - 1));
			result = Math.abs(DiffDigits) != 1;
		}
		return result;
	}

	private int getIntValue(String pin) {
		return Integer.parseInt(pin);
	}

	private boolean isFourCharacters(String pin) {
		return pin.length() == PIN_SIZE;
	}

	private boolean isNumeric(String pin) {
		boolean result = false;
		try {
			getIntValue(pin);
			result = true;
		} catch (final NumberFormatException e) {
			LOGGER.log(Level.INFO, NON_NUMERIC_ERROR_MESSAGE, e);
		}
		return result;
	}

}
