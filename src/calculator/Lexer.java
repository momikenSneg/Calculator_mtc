package calculator;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Lexer {
    private Reader reader;
    private int current;

    public Lexer(String name) throws IOException {
        reader = new FileReader(name);
        current = reader.read();
    }

    public Lexeme getLexeme() throws IOException, LexerException {
        if (current == -1){
            return new Lexeme("\n", LexemeType.EOF);
        }
        char l = (char)current;
        Lexeme lexeme;
        switch (l){
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                StringBuilder val = new StringBuilder();
                val.append(l);
                current = reader.read();
                char v = (char)current;
                while (v > '0' && v < '9'){
                    val.append(v);
                }
                lexeme = new Lexeme(val.toString(), LexemeType.NUM);
                return lexeme;
            case '+':
                lexeme = new Lexeme(String.valueOf(l), LexemeType.PlUS);
                break;
            case '-':
                lexeme = new Lexeme(String.valueOf(l), LexemeType.MINUS);
                break;
            case '*':
                lexeme = new Lexeme(String.valueOf(l), LexemeType.MULT);
                break;
            case '/':
                lexeme = new Lexeme(String.valueOf(l), LexemeType.DIV);
                break;
            case '(':
                lexeme = new Lexeme(String.valueOf(l), LexemeType.OPEN);
                break;
            case ')':
                lexeme = new Lexeme(String.valueOf(l), LexemeType.CLOSE);
                break;
            case '^':
                lexeme = new Lexeme(String.valueOf(l), LexemeType.POWER);
                break;
            default:
                throw new LexerException("Lexer exeption");
        }
        current = reader.read();
        return lexeme;
    }

}