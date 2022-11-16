package Model;

import java.util.Arrays;
import java.util.List;

public class Language {
    private List<String> operators = Arrays.asList("+", "-", "*", "/", "%", "=", "==", "!=", "<", ">", "<=", ">=");
    private List<String> keywords = Arrays.asList("int", "string", "for", "while", "if", "else", "read", "print");
    private List<String> separators = Arrays.asList("(", ")", ";", "{", "}","[", "]", " ", "\t", "\n");


    private String identifierPattern = "^[a-zA-Z]([a-z|A-Z|0-9|_])*$";
    private String numericPattern = "^0|[+|-][1-9]([0-9])*|[1-9]([0-9])*$";
//    private String charPattern = "^\'[a-zA-Z0-9_?!#*./%+=<>;)(}{ ]\'";
    private String stringPattern = "^\"[a-zA-Z0-9_?!#*./%+=<>;)(}{ ]+\"";

    public boolean isOperator(String token) {
        return operators.contains(token);
    }

    public boolean isKeyword(String token){
        return keywords.contains(token);
    }

    public boolean isSeparator(String token){
        return separators.contains(token);
    }

    public boolean isIdentifier(String token) {
        return token.matches(identifierPattern);
    }

    public boolean isConstant(String token) {
        return token.matches(numericPattern) ||
                token.matches(stringPattern);
    }

    public boolean isReservedWord(String token) {
        return keywords.contains(token);
    }


    public boolean isPartOfOperator(char op) {
        return op == '!' || isOperator(String.valueOf(op));
    }
}
