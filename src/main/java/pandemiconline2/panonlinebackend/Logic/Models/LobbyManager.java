package pandemiconline2.panonlinebackend.Logic.Models;

import java.util.ArrayList;
import java.util.List;

public class LobbyManager
{
    List<Lobby> activeLobbies;

    public LobbyManager(List<Lobby> activeLobbies)
    {
        this.activeLobbies = activeLobbies;
        for (int i = 0; i < 3; i++) {
            activeLobbies.add(new Lobby(i,new ArrayList<>()));
        }

    }

    public void NewLobby(User lobbyOwner){
        Lobby newLobby = new Lobby(activeLobbies.size()+1, new ArrayList<>());
        newLobby.JoinLobby(lobbyOwner);
        activeLobbies.add(newLobby);
    }

    public void DeleteLobby(int lobbyNumber){
        activeLobbies.remove(lobbyNumber-1);
    }
}
