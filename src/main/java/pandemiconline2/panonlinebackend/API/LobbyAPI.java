package pandemiconline2.panonlinebackend.API;

import org.springframework.web.bind.annotation.*;
import pandemiconline2.panonlinebackend.API.ViewModel.LobbyAccessModel;
import pandemiconline2.panonlinebackend.API.ViewModel.LobbyViewModel;
import pandemiconline2.panonlinebackend.API.ViewModel.UserRegisterViewModel;
import pandemiconline2.panonlinebackend.API.ViewModel.UserViewModel;
import pandemiconline2.panonlinebackend.DAL.UserDAL;
import pandemiconline2.panonlinebackend.Logic.Containers.LobbyContainer;
import pandemiconline2.panonlinebackend.Logic.Containers.UserContainer;
import pandemiconline2.panonlinebackend.Logic.Models.Lobby;
import pandemiconline2.panonlinebackend.Logic.Models.User;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api")
@CrossOrigin
public class LobbyAPI {

    private final LobbyContainer lobbyContainer;

    public LobbyAPI(){
        this.lobbyContainer = new LobbyContainer();
    }

    @PostMapping(value= "/lobby/{id}", consumes = "application/json")
    public String JoinLobby(@RequestBody LobbyAccessModel model ,@PathVariable int id) {

        if (lobbyContainer.JoinLobby(new User(model.getUsername()), id)){
            return "joined lobby";
        }
        return "couldnt join lobby";
    }

    @PutMapping(value="/leave{id}", consumes="application/json")
    public String LeaveLobby(@RequestBody LobbyAccessModel model, @PathVariable int id){
        lobbyContainer.LeaveLobby(new User(model.getUsername()),id);
        return "Left lobby";

    }

    @GetMapping(value ="/lobby", produces = "application/json")
    public List<LobbyViewModel> GetLobbies()

    {
        Converter converter = new Converter();
        List<LobbyViewModel> lobbies = new ArrayList<>();
        for (Lobby lobby:lobbyContainer.GetAllLobbies()
             )
        {
            LobbyViewModel model = new LobbyViewModel();
            model.setLobbynumber(lobby.getLobbyNumber());
            model.setUsers(converter.UserListToViewModels(lobby.getUsers()));
            lobbies.add(model);
        }
        return lobbies;
    }

}
