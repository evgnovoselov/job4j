package ru.job4j.array;

/**
 * Проверка постфикса.
 *
 * @author Evgeny Novoselov
 */
public class EndsWith {
    /**
     * Проверяет, что слово оканчивается на постфикс.
     *
     * @param word Слово.
     * @param post Постфикс.
     * @return Если слово оканчивается на постфикс true
     */
    public boolean endsWith(String word, String post) {
        boolean result = true;
        char[] pst = post.toCharArray();
        char[] wrd = word.toCharArray();
        if (pst.length > wrd.length) {
            result = false;
        }
        int wrdEndIter = wrd.length - 1;
        for (int i = pst.length - 1; i > 0; i--) {
            if (wrd[wrdEndIter] != pst[i]) {
                result = false;
            }
            wrdEndIter--;
            if (wrdEndIter < 0 || !result) {
                break;
            }
        }
        return result;
    }
}
