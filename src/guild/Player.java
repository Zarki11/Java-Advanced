package guild;

import java.util.LinkedHashMap;
import java.util.Map;

public class Player {

    private String name;

    private int capacity;

    private Map<String, Player> players;

    public Player(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.players = new LinkedHashMap<>();
    }

    public void addPlayer(Player player){
        if (capacity > players.size()){
           // this.players.put(play player);
        }
    }
}
