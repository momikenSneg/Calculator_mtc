package calculator;

public class Lexeme {
    private String value;
    private LexemeType type;

    public Lexeme(String value, LexemeType type) {
        this.value = value;
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public LexemeType getType() {
        return type;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setType(LexemeType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object obj) {
        return ((Lexeme)obj).getValue().equals(this.value) && ((Lexeme)obj).getType().equals(this.type);
    }
}
