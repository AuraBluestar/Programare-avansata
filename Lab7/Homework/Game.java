package lab7.lab_7;

import java.util.ArrayList;
import java.util.List;

public class Game implements Runnable {

    private List<Player> players = new ArrayList<>();
    private Bag board;
    private long timeLimit;

    public Game(List<Player> players, Bag board) {
        this.players = players;
        this.board = board;
        this.board.setNrPlayers(players.size());
        initPlayers();
    }

    private void initPlayers() {
        for (int index = 0; index < this.players.size(); index++) {
            this.players.get(index).setId(index);
        }
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Bag getBoard() {
        return board;
    }

    public void setBoard(Bag board) {
        this.board = board;
    }

    public long getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(long timeLimit) {
        this.timeLimit = timeLimit;
    }

    @Override
    public void run() {
        int numTokens = board.getTokens().size();
        int numPlayers = players.size();
        int totalTokensExtracted = 0;
        List<Thread> threads = new ArrayList<>();

        while (totalTokensExtracted < numTokens - numPlayers) {
            for (Player player : players) {
                Thread thread = new Thread(player);
                threads.add(thread);
                thread.start();
                totalTokensExtracted++;
            }
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        displayWinner();
    }

    private void displayWinner() {
        List<Player> winners = new ArrayList();
        List<Player> losers = new ArrayList();
        int scorMaxim = 0;
        for (Player player : players) {
            if (player.getLongestIteration() > scorMaxim) {
                losers.addAll(winners);
                winners = new ArrayList();
                winners.add(player);
                scorMaxim = player.getLongestIteration();
            } else if (player.getLongestIteration() < scorMaxim) {
                losers.add(player);
            } else {
                winners.add(player);
            }
        }
        System.out.println("Winner(s): ");
        for (Player player : winners) {
            System.out.println(player.getName() + " with a score of " + scorMaxim);
            System.out.println(player.getValues());
        }
        System.out.println("Loser(s): ");
        for (Player player : losers) {
            System.out.println(player.getName());
        }
    }

}
