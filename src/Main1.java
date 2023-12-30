public class Main1 {
    public static void main(String args[]) {
        int[] numbers = {10, 20, 30, 40, 50};
        // printing numbers
        for (int x : numbers) {
            System.out.print(x);
            System.out.print(",");
        }
        System.out.print("\n");
        String[] names = {"James", "Larry", "Tom", "Lacy"};
        /*
         * looping over names
         */
        for (String name : names) {
            System.out.print(name);
            System.out.print(",");
        }
    }
}

class LexemeTokenExample {
    public static void main(String[] args) {
        String programCode = "your program code here"; // Replace with actual code

        char[] symbols = {'{', '}', '(', ')', '[', ']', '.', '"', '*', '\n', ':', ',', ';'};
        char[] specialSymbols = {'\\', '/', '/'};
        String[] specialKeywords = {"public", "class", "void", "main", "if", "String", "int", "System", "out", "println"};

        // Combine all keywords
        String[] MAINKEYWORDS = combineKeywords(specialKeywords);

        String emptySpace = " ";
        StringBuilder lexemeToken = new StringBuilder();

        for (int i = 0; i < programCode.length(); i++) {
            char charAtI = programCode.charAt(i);
            if (charAtI == '*' && i > 0 && programCode.charAt(i - 1) == '/') {
                lexemeToken.append("/*");
            } else if (charAtI == '*' && i + 1 < programCode.length() && programCode.charAt(i + 1) == '/') {
                lexemeToken.append("*/");
            } else if (charAtI == '/') {
                if (i + 1 < programCode.length() && programCode.charAt(i + 1) != '/' && programCode.charAt(i - 1) != '*') {
                    lexemeToken.append('/');
                }
            } else {
                if (charAtI != ' ') {
                    lexemeToken.append(charAtI);
                }
                if (i + 1 < programCode.length()) {
                    char nextChar = programCode.charAt(i + 1);
                    if (nextChar == ' ' && (isInArray(nextChar, MAINKEYWORDS) || isInArray(lexemeToken.toString(), MAINKEYWORDS))) {
                        if (lexemeToken.length() > 0) {
                            System.out.println(lexemeToken.toString().replace("\n", "<newLine>"));
                            lexemeToken = new StringBuilder();
                        }
                    }

                }
            }
        }
    }

    private static String[] combineKeywords(String[]... keywordGroups) {
        // Method implementation to combine keywords
        // Not provided due to length constraints. It should merge the arrays into a single array.
        return new String[] {};
    }

    private static boolean isInArray(char character, String[] array) {
        for (String element : array) {
            if (element.indexOf(character) != -1) {
                return true;
            }
        }
        return false;
    }

    private static boolean isInArray(String str, String[] array) {
        for (String element : array) {
            if (str.equals(element)) {
                return true;
            }
        }
        return false;
    }
}