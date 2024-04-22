package lab7.lab_7;

import com.github.javafaker.Faker;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class Lab_7 {

    public static void main(String[] args) {

        CopyOnWriteArrayList<Token> tokens = new CopyOnWriteArrayList<>();
        Random random = new Random();
        int n = 0;
        while (n < 4) {
            for (int index1 = 1; index1 <= 50; index1++) {
                int index2 = (index1 % 50) + 1; // tn, tn+1
                tokens.add(new Token(index1, index2));
            }
            n++;
        }

        // Amestecarea token-urilor
        Collections.shuffle(tokens);

        Bag bag = new Bag(tokens);

        List<Player> playerList = new ArrayList<>();
        Faker faker = new Faker();

        // Adăugați doar doi jucători în lista playerList
        Player player1 = new Player(faker.name().firstName(), bag);
        Player player2 = new Player(faker.name().firstName(), bag);
        Player player3 = new Player(faker.name().firstName(), bag);
        Player player4 = new Player(faker.name().firstName(), bag);
        Player player5 = new Player(faker.name().firstName(), bag);
        player1.setBot(random.nextBoolean());
        player2.setBot(random.nextBoolean());
        player3.setBot(random.nextBoolean());
        player4.setBot(random.nextBoolean());
        player5.setBot(random.nextBoolean());
        playerList.add(player1);
        playerList.add(player2);
        playerList.add(player3);
        playerList.add(player4);
        playerList.add(player5);

        Game game = new Game(playerList, bag);
        Thread thread = new Thread(game);
        TimeKeeper timeKeeper = new TimeKeeper(thread, 90000);
        Thread timer = new Thread(timeKeeper);
        timer.setDaemon(true);

        thread.start();
        timer.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
