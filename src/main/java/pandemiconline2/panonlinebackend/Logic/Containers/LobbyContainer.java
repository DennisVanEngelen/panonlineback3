package pandemiconline2.panonlinebackend.Logic.Containers;

import pandemiconline2.panonlinebackend.Logic.Models.Lobby;
import pandemiconline2.panonlinebackend.Logic.Models.User;

import java.util.ArrayList;
import java.util.List;

public class LobbyContainer
{
    List<Lobby> lobbies;
    int lobbyIDgenerator = 1;
    public LobbyContainer(){
        lobbies = new ArrayList<>();
        for(int i = 0; i < 3;i++){
            lobbies.add(new Lobby(lobbyIDgenerator, new ArrayList<>()));
            lobbyIDgenerator++;
        }
    }

    public void AddLobby(){
        lobbies.add(new Lobby(lobbyIDgenerator, new ArrayList<>()));
        lobbyIDgenerator++;
    }

    public void DeleteLobby(int lobbyid)
    {
        lobbies.removeIf(lobby -> lobby.getLobbyNumber() == lobbyid);
    }


    public boolean JoinLobby(User user, int lobbynumber)
    {
        for (Lobby lobby: lobbies)
        {
            if(lobby.getLobbyNumber() == lobbynumber ){
                if(lobby.getUsers().size() < 4){
                    lobby.JoinLobby(user);
                    return true;
                }
            }
        }
        return false;
    }
    public List<Lobby> GetAllLobbies(){
        return lobbies;
    }
}
