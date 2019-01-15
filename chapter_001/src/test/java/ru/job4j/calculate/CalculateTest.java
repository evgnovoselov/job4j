package ru.job4j.calculate;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class CalculateTest
 * 
 * @author Evgeny Novoselov
 */
public class CalculateTest {

	/**
	 * Test echo
	 */
	@Test
	public void whenTakeNameThenThreeEchoPlusName() {
		String input = "Evgeny Novoselov";
		String expect = "Echo, echo, echo : Evgeny Novoselov";

		Calculate calc = new Calculate();
		String result = calc.echo(input);
		assertThat(result, is(expect));
	}
}