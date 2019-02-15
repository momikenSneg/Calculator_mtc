package calculator;

import java.io.IOException;

public class Parser {
    private Lexer lexer;
    private Lexeme current;

    public Parser(Lexer lexer) throws IOException, LexerException {
        this.lexer = lexer;
        current = this.lexer.getLexeme();
    }

    public double parseExpression() throws IOException, LexerException, ParserException {
        double temp = parseTerm();
        while(current.getType() == LexemeType.PlUS || current.getType() == LexemeType.MINUS){
            if(current.getType() == LexemeType.PlUS){
                current = lexer.getLexeme();
                temp += parseTerm();
            } else {
                current = lexer.getLexeme();
                temp -= parseTerm();
            }
        }
        return temp;
    }

    private double parseTerm() throws IOException, LexerException, ParserException {
        double temp = parseFactor();
        while(current.getType() == LexemeType.MULT || current.getType() == LexemeType.DIV){
            if(current.getType() == LexemeType.MULT){
                current = lexer.getLexeme();
                temp *= parseFactor();
            } else {
                current = lexer.getLexeme();
                temp /= parseFactor();
            }
        }
        return temp;
    }

    private double parseFactor() throws IOException, LexerException, ParserException {
        double temp = parsePower();
        if (current.getType() == LexemeType.POWER){
            current = lexer.getLexeme();
            temp = Math.pow(temp, parseFactor());
        }
        return temp;
    }

    private double parsePower() throws IOException, LexerException, ParserException {
        double temp;
        if(current.getType() == LexemeType.MINUS){
            current = lexer.getLexeme();
            temp = (-1) * parseAtom();
        } else {
            temp = parseAtom();
        }
        return temp;
    }

    private double parseAtom() throws IOException, LexerException, ParserException {
        double temp;
        if (current.getType() == LexemeType.NUM){
            temp = Integer.valueOf(current.getValue());
            current = lexer.getLexeme();
            return temp;
        }
        if (current.getType() == LexemeType.OPEN) {
            current = lexer.getLexeme();
            temp = parseExpression();
            if (current.getType() != LexemeType.CLOSE) {
                throw new ParserException("Parse exception");
            }
            current = lexer.getLexeme();
            return temp;
        }
        throw new ParserException("Parse exception");
    }

}
