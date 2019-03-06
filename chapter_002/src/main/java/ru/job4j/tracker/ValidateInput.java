package ru.job4j.tracker;

/**
 * Класс с проверкой ввода информации.
 *
 * @author Evgeny Novoselov
 */
public class ValidateInput implements Input {
    private final Input input;

    public ValidateInput(final Input input) {
        this.input = input;
    }

    /**
     * Метод задает вопрос и возвращает ответ
     *
     * @param question вопрос.
     * @return ответ.
     */
    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }

    /**
     * Метод задает вопрос и возвращает ответ.
     *
     * @param question вопрос.
     * @param range    возможный ответ.
     * @return возвращает введенный ответ.
     */
    @Override
    public int ask(String question, int[] range) {
        int result = -1;
        boolean invalid = true;
        do {
            try {
                result = this.input.ask(question, range);
                invalid = false;
            } catch (MenuOutException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("--------------------------------");
                System.out.println("Неверный формат ввода." + System.lineSeparator() + "Попробуйте еще раз.");
                System.out.println("--------------------------------");
            }
        } while (invalid);
        return result;
    }
}
