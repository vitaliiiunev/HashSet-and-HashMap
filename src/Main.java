import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Main {

    private static final String TEXT = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua." +
            " Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore" +
            " eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
    public static void main(String[] args) {

        char[] elements = TEXT.toLowerCase().toCharArray();
        Map<Character, Integer> symbols = new HashMap<>();

        for (int i = 0; i < elements.length; i++) {

            if (Character.isLetter(elements[i])) {
                Integer count = symbols.get(elements[i]);
                if (count == null) {
                    symbols.put(elements[i], 1);
                } else {
                    symbols.put(elements[i], ++count);
                }
            }
        }
        System.out.println(symbols);
        System.out.println();

        Integer max = getMax(symbols);
        Integer min = getMin(symbols);


        System.out.println("Максимум: ");
        for (Map.Entry<Character, Integer> symbol : symbols.entrySet()) {
            if (Objects.equals(symbol.getValue(), max)) {
                System.out.println(symbol.getKey() + " : " + symbol.getValue());

            }
        }
        System.out.println();

        System.out.println("Минимум ");
        for (Map.Entry<Character, Integer> symbol : symbols.entrySet()) {
            if (Objects.equals(symbol.getValue(), min)) {
                System.out.println(symbol.getKey() + " : " + symbol.getValue());

            }
        }

        WordsChecker a = new WordsChecker(TEXT);
        System.out.println(a.hasWord("minim"));


    }
    private static Integer getMax(Map<Character, Integer> symbols) {
        int max = Integer.MIN_VALUE;

        for (Map.Entry<Character, Integer> symbol : symbols.entrySet()) {
            if (symbol.getValue() > max) {
                max = symbol.getValue();
            }
        }
        return max;
    }

    private static Integer getMin(Map<Character, Integer> symbols) {
        int min = Integer.MAX_VALUE;

        for (Map.Entry<Character, Integer> symbol : symbols.entrySet()) {
            if (min > symbol.getValue()) {
                min = symbol.getValue();
            }
        }
        return min;
    }
}
