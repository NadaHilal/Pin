package com.craftwoman.pin;

import org.junit.Assert;
import org.junit.Test;

public class PinValidatorTest {

	PinValidator pinValidator = new PinValidator();

	@Test
	public void should_only_allow_numbers() {
		// Given
		final String pin = "abcd";

		// When
		final boolean result = pinValidator.validate(pin);

		// Then
		Assert.assertFalse(result);
	}

	@Test
	public void should_be_only_four_character_length() {
		// Given
		final String pin = "12356";
		// When
		final boolean result = pinValidator.validate(pin);
		// Then
		Assert.assertFalse(result);
	}

	@Test
	public void should_not_allow_increasing_sequences() {
		// Given
		final String pin = "1234";
		// When
		final boolean result = pinValidator.validate(pin);
		// Then
		Assert.assertFalse(result);
	}

	@Test
	public void should_not_allow_decreasing_sequences() {
		// Given
		final String pin = "4321";
		// When
		final boolean result = pinValidator.validate(pin);
		// Then
		Assert.assertFalse(result);
	}
}
