package test;

import calculator.*;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static junit.framework.TestCase.assertEquals;

public class Tests {
    private Lexer lexer1 = new Lexer("1.txt");
    private Lexer lexer2 = new Lexer("2.txt");
    private Lexer lexer3 = new Lexer("3.txt");
    private Lexer lexer4 = new Lexer("4.txt");
    private Lexer lexer5 = new Lexer("5.txt");
    private Lexer lexer6 = new Lexer("6.txt");
    //Parser parser1 = new Parser(lexer1);
    Parser parser2 = new Parser(lexer2);
    Parser parser3 = new Parser(lexer3);
    Parser parser4 = new Parser(lexer4);
    Parser parser5 = new Parser(lexer5);
    Parser parser6 = new Parser(lexer6);

    public Tests() throws IOException, LexerException {

    }

    @Test
    public void testLexer() throws IOException, LexerException {
        Lexeme actual = lexer1.getLexeme();
        Lexeme expected = new Lexeme("(", LexemeType.OPEN);
        assertEquals(expected, actual);

        actual = lexer1.getLexeme();
        expected = new Lexeme("5", LexemeType.NUM);
        assertEquals(expected, actual);

        actual = lexer1.getLexeme();
        expected = new Lexeme("+", LexemeType.PlUS);
        assertEquals(expected, actual);

        actual = lexer1.getLexeme();
        expected = new Lexeme("6", LexemeType.NUM);
        assertEquals(expected, actual);

        actual = lexer1.getLexeme();
        expected = new Lexeme(")", LexemeType.CLOSE);
        assertEquals(expected, actual);

        actual = lexer1.getLexeme();
        expected = new Lexeme("^", LexemeType.POWER);
        assertEquals(expected, actual);

        actual = lexer1.getLexeme();
        expected = new Lexeme("3", LexemeType.NUM);
        assertEquals(expected, actual);

        actual = lexer1.getLexeme();
        expected = new Lexeme("*", LexemeType.MULT);
        assertEquals(expected, actual);

        actual = lexer1.getLexeme();
        expected = new Lexeme("2", LexemeType.NUM);
        assertEquals(expected, actual);
    }

    @Test
    public void testPearceExpression() throws ParserException, IOException, LexerException {
        double expected = 4194304.25;
        double actual = parser2.parseExpression();
        assertEquals(expected, actual);
    }

    @Test
    public void testPearceTerm() throws ParserException, IOException, LexerException {
        double expected = 270;
        double actual = parser3.parseTerm();
        assertEquals(expected, actual);
    }

    @Test
    public void testPearceFactor() throws ParserException, IOException, LexerException {
        double expected = 0.5;
        double actual = parser4.parseFactor();
        assertEquals(expected, actual);
    }

    @Test
    public void testPearcePower() throws ParserException, IOException, LexerException {
        double expected = -8;
        double actual = parser5.parsePower();
        assertEquals(expected, actual);
    }

    @Test
    public void testPearceAtom() throws ParserException, IOException, LexerException {
        double expected = 6;
        double actual = parser6.parseAtom();
        assertEquals(expected, actual);
    }

}
