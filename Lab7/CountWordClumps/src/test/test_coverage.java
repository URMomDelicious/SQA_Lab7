package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import sqa.main.CountWordClumps;

class test_coverage {
	
	@ParameterizedTest
	@CsvSource({
		"null, 0",
		"'', 0",
		"'{}', 0",
		"'1', 0",
		"'1,2,3', 0",
		"'1,2,2,3', 1",
		"'1,1,2,2,2,3', 2",
		"'1,1,1,1,1', 1",
		"'1,2,2,3,4,4', 2"
	})
	void testCountClumps(String inputStr, int expected) {
		int[] input = parseIntArray(inputStr);
		int actual = CountWordClumps.countClumps(input);
		assertEquals(expected, actual);
	}

	static int[] parseIntArray(String s) {
		if (s == null || s.isBlank() || s.equals("{}"))
			return (s == null || s.isBlank()) ? null : new int[0];
		s = s.replaceAll("[{}\\s]", "");
		if (s.isEmpty())
			return new int[0];
		String[] nums = s.split(",");
		int[] arr = new int[nums.length];
		for (int i = 0; i < nums.length; i++)
			arr[i] = Integer.parseInt(nums[i]);
		return arr;
	}
}
