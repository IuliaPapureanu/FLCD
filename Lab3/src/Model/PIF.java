package Model;

import java.util.ArrayList;
import java.util.List;

public class PIF {
    public PIF() {}

    public List<PIFelement> pif = new ArrayList<>();

    public void add(String id, Pair<Integer, Integer> positionInSymbolTable){
        pif.add(new PIFelement(id,positionInSymbolTable));
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (PIFelement piFelement:this.pif) {
            result.append("pos in ST: " + piFelement.positionInSymbolTable.toString() + " | id: " + piFelement.id.toString()+ "\n" );
        }
        return result.toString();
    }
}
