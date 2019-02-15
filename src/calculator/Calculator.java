package calculator;

import java.io.IOException;

public class Calculator {
    private Lexer lexer;
    private Parser parser;

    public  Calculator(String fileName) throws IOException, LexerException {
        lexer = new Lexer(fileName);
        parser = new Parser(lexer);
    }

    public double calculate() throws ParserException, IOException, LexerException {
        return parser.parseExpression();
    }
}
