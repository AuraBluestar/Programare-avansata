package lab7.lab_7;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Player implements Runnable {

    private String name;
    private List<Token> tokenList = new ArrayList<>();
    private final List<Integer> values = new ArrayList();
    private Bag board;
    private Integer id;
    private boolean isBot;

    public Player(String name, Bag board) {
        this.name = name;
        this.board = board;
    }

    public boolean isBot() {
        return isBot;
    }

    public void setBot(boolean bot) {
        isBot = bot;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bag getBoard() {
        return board;
    }

    public void setBoard(Bag board) {
        this.board = board;
    }

    public int getLongestIteration() {
        Collections.sort(values);
        int longestIteration=0;
        int nr=1;
        for(int i=1; i<values.size();i++)
        {
            if(values.get(i)==values.get(i-1)+1)
            {
                nr++;
                longestIteration = Math.max(longestIteration, nr);
            }
            else nr=1;
        }
        return longestIteration;
    }

    public List<Token> getTokenList() {
        return tokenList;
    }

    public List<Integer> getValues() {
        Collections.sort(values);
        return values;
    }

    public void setTokenList(List<Token> tokenList) {
        this.tokenList = tokenList;
    }

    /*
@Override
public void run() {
    List<Token> extractedTokens = new ArrayList<>();
    List<Integer> values = new ArrayList();
    int iteration = 0;
    Token currentToken; // Tokenul curent extras
    while (!board.getTokens().isEmpty()) { // Cat timp mai sunt tokenuri disponibile
        currentToken = extractToken(); // Extragem un token
        if (currentToken == null) // Dacă nu mai sunt tokenuri disponibile, ieșim din buclă
            break;
        System.out.println(this.name + "["+ currentToken.getV1() + ", " + currentToken.getV2() + "]");
        boolean found = false;
        for (int i : values) {
            if (currentToken.getV1().equals(i) || currentToken.getV2().equals(i)) 
            {
                found = true;
                this.tokenList.add(currentToken);
                iteration++;
                break;
            }
        }
        if (!found) {
            extractedTokens.add(currentToken);
            values.add(currentToken.getV1());
            values.add(currentToken.getV2());
            iteration++;
            this.tokenList.add(currentToken);
        }
        else {
            break; // Dacă am găsit un token valabil, opriti extragerea
        }
    }
    this.longestIteration = iteration;
}
     */
    @Override
public void run() {
    Token currentToken; 

    currentToken = extractToken();
    if (currentToken != null) {
        boolean v1Found = false, v2Found = false;
        for (int i : values) {
            if (currentToken.getV1().equals(i)) {
                v1Found = true;
            }
            if (currentToken.getV2().equals(i)) {
                v2Found = true;
            }
        }
        if (!v1Found) {
            values.add(currentToken.getV1());
        }
        if (!v2Found) {
            values.add(currentToken.getV2());
        }
        this.tokenList.add(currentToken); 
    }
}


    public Token extractToken() {
        if (!board.getTokens().isEmpty()) {
            Token token = board.getTokens().get(0); 
            board.getTokens().remove(0);
            return token;
        } else {
            return null;
        }
    }

}
