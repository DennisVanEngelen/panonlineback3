package pandemiconline2.panonlinebackend.API;

import org.springframework.web.bind.annotation.*;
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
@RequestMapping("lobby")
@CrossOrigin
public class LobbyAPI {

    private final LobbyContainer lobbyContainer;

    public LobbyAPI(){
        this.lobbyContainer = new LobbyContainer();
    }

    @PostMapping(value= "/", consumes = "application/json", produces = "application/json")
    public boolean JoinLobby(@RequestBody UserRegisterViewModel model) {

    return true;
    }

    @PutMapping(value="/", consumes="application/json", produces = "application/json")
    public boolean LeaveLobby(@RequestBody UserViewModel model){
        return true;
    }

    @GetMapping(value ="/", consumes = "application/json", produces = "application/json")
    public List<LobbyViewModel> GetLobbies( HttpServletRequest request)

    {
        Converter converter = new Converter();
        List<LobbyViewModel> lobbies = new ArrayList<>();
        for (Lobby lobby:lobbyContainer.GetAllLobbies()
             )
        {
            LobbyViewModel model = new LobbyViewModel();
            model.setLobbynumber(lobby.getLobbyNumber());
            model.setUsers(converter.UserListToViewModels(lobby.getUsers()));
        }
        return lobbies;
    }

}
