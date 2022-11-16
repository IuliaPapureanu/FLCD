package Model;

public class PIFelement {
    public String id;
    public Pair<Integer, Integer> positionInSymbolTable;

    public PIFelement(String id, Pair<Integer, Integer> positionInSymbolTable) {
        this.id = id;
        this.positionInSymbolTable = positionInSymbolTable;
    }
}
