package ru.job4j.calculate;

/**
 * Calculate now have only main() method
 *
 * @author Evgeny Novoselov
 */
public class Calculate {

	/**
	 * Method only println "Hello World" in console
	 * 
	 * @param args Array string arguments
	 */
	public static void main(String[] args) {
		System.out.println("Hello world");
	}

    /**
     * Method echo
     *
     * @param name Your name.
     * @return Echo plus your name.
     */
	public String echo(String name) {
		return "Echo, echo, echo : " + name;
	}
}