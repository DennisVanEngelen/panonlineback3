package pandemiconline2.panonlinebackend.DAL.DTO;

import lombok.Getter;
import lombok.Setter;
import pandemiconline2.panonlinebackend.DAL.DataModels.GameStatisticsDataModel;
import pandemiconline2.panonlinebackend.DAL.DataModels.UserDataModel;
import pandemiconline2.panonlinebackend.Logic.Models.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter @Setter
public class UserDTO
{
    private long id;
    private String username;
    private String password;
    private String emailAddress;
    private List<GameStatisticsDTO> gamesPlayed = new ArrayList<>();

    public UserDTO(){

    }
    public UserDTO (User user)
    {
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.emailAddress = user.getEmailAddress();
    }
    public UserDTO (UserDataModel user)
    {
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.emailAddress = user.getEmail_address();
        if (user.getGamesPlayed() != null)
        {
            for (GameStatisticsDataModel gamestats : user.getGamesPlayed())
            {
                gamesPlayed.add(new GameStatisticsDTO(gamestats));
            }
        }
    }

    public UserDTO(long id, String username, String password, String email, List<GameStatisticsDTO> stats){
        this.id = id;
        this.username = username;
        this.password = password;
        this.emailAddress = email;
        this.gamesPlayed = stats;
    }
}

