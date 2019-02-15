package calculator;

import java.io.IOException;

public class Main {
    public static void main(String[] args){
        try {
            System.out.println(new Calculator(args[0]).calculate());
        } catch (ParserException e) {
            System.out.println("Wrong character");
        } catch (IOException e) {
            System.out.println("File doesn't exist");
        } catch (LexerException e) {
            System.out.println("Wrong arguments");
        }
    }
}
