package lab7.lab_7;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class Bag {
    private CopyOnWriteArrayList<Token> tokens = new CopyOnWriteArrayList<>();
    private boolean available = true;
    private int count = 0;
    private int nrPlayers;

    public Bag(CopyOnWriteArrayList<Token> tokens) {
        this.tokens = tokens;
    }

    public synchronized CopyOnWriteArrayList<Token> getTokens() {
        return tokens;
    }

    public synchronized List<Token> getTokens(int numberOfTokens){
        Random random = new Random();
        List<Token> tokenList = new ArrayList<>();
        for(int index = 0; index < numberOfTokens; index++){
            if(!tokens.isEmpty()){
                int indexToken = random.nextInt(tokens.size());
                tokenList.add(tokens.get(indexToken));
                tokens.remove(indexToken);
            }
            else{
                break;
            }
        }
        return tokenList;
    }

    public int getNrPlayers() {
        return nrPlayers;
    }

    public void setNrPlayers(int nrPlayers) {
        this.nrPlayers = nrPlayers;
    }

    public synchronized Token getToken(Integer tokenIndex) {
        while (!available) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Random random = new Random();
        Token dup = null;
        if (!this.tokens.isEmpty()) {
            int indexToken;
            if (tokenIndex != null && tokenIndex < tokens.size()) {
                indexToken = tokenIndex;
            } else {
                indexToken = random.nextInt(tokens.size());
            }
            dup = tokens.get(indexToken);
            tokens.remove(indexToken);
            if (count < nrPlayers - 1) {
                count++;
            } else {
                count = 0;
            }
        }
        available = false;
        notifyAll();
        return dup;
    }

    public synchronized void setTokensAvailable() {
        while (available) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        available = true;
        notifyAll();
    }

    public void setTokens(CopyOnWriteArrayList<Token> tokens) {
        this.tokens = tokens;
    }

    public boolean isTokensEmpty() {
        return tokens.isEmpty();
    }

    public int getCount() {
        return count;
    }

    public int getTokensSize() {
        return tokens.size();
    }
}
