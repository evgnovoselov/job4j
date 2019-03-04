package ru.job4j.tracker;

/**
 * Класс с проверкой ввода информации.
 *
 * @author Evgeny Novoselov
 */
public class ValidateInput extends ConsoleInput {
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
                result = super.ask(question, range);
                invalid = false;
            } catch (MenuOutException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("--------------------------------");
                System.out.println("¯\\_(ツ)_/¯ Неверный формат ввода." + System.lineSeparator() + "Попробуйте еще раз :)");
                System.out.println("--------------------------------");
            }
        } while (invalid);
        return result;
    }
}
