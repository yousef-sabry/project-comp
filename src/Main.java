
class SyntaxError extends RuntimeException {
    public SyntaxError(String message) {
        super(message);
    }
}

public class Main {
    public static void main(String[] args) {


        String inputString = "3+5*6+2-4";
        SyntaxAnalyzer syntaxAnalyzer = new SyntaxAnalyzer(inputString);
        try {
            int result = syntaxAnalyzer.parseExpression();
            System.out.println("Parsing successful. Result: " + result);
        } catch (SyntaxError e) {
            System.out.println("Syntax Error: " + e.getMessage());
        }
    }
}