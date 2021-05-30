package pandemiconline2.panonlinebackend.Logic.Models;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Lobby
{
    @Getter
    List<User> users;

    @Getter
    int lobbyNumber;

    public Lobby(int lobbyNumber, List<User> users)
    {
        this.lobbyNumber = lobbyNumber;
        this.users = users;
    }

    public void JoinLobby(User user){
        users.add(user);
    }

    public void LeaveLobby(User user){
        users.remove(user);
    }

    public void StartGame(){

    }
}
