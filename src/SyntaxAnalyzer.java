public class SyntaxAnalyzer {
    private String inputString;
    private char currentToken;
    private int currentPosition;

    public SyntaxAnalyzer(String inputString) {
        this.inputString = inputString;
        this.currentToken = '\0'; // Initialize with a null character
        this.currentPosition = 0;
    }

    public char getNextToken() {
        if (this.currentPosition < this.inputString.length()) {
            this.currentToken = this.inputString.charAt(this.currentPosition);
            this.currentPosition++;
            return this.currentToken;
        } else {
            return '\0'; // Return null character if end of input is reached
        }
    }

    public int parseExpression() {
        this.getNextToken(); // Initialize the currentToken
        int result = this.parseTerm();
        while (this.currentToken != '\0' && (this.currentToken == '+' || this.currentToken == '-')) {
            char op = this.currentToken;
            this.getNextToken();
            int term = this.parseTerm();
            if (op == '+') {
                result += term;
            } else if (op == '-') {
                result -= term;
            }
        }
        return result;
    }

    public int parseTerm() {
        int result = this.parseFactor();
        while (this.currentToken != '\0' && (this.currentToken == '*' || this.currentToken == '/')) {
            char op = this.currentToken;
            this.getNextToken();
            int factor = this.parseFactor();
            if (op == '*') {
                result *= factor;
            } else if (op == '/') {
                result /= factor;
            }
        }
        return result;
    }

    public int parseFactor() {
        if (Character.isDigit(this.currentToken)) {
            int value = Character.getNumericValue(this.currentToken);
            this.getNextToken();
            return value;
        } else {
            throw new SyntaxError("Unexpected token: " + this.currentToken);
        }
    }
}
