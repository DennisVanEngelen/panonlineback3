package pandemiconline2.panonlinebackend.DAL.DTO;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;
import pandemiconline2.panonlinebackend.DAL.DataModel.GameStatisticsDataModel;
import pandemiconline2.panonlinebackend.DAL.DataModel.UserDataModel;
import pandemiconline2.panonlinebackend.Logic.Models.User;

import java.util.HashSet;
import java.util.Set;

@Getter @Setter
public class UserDTO
{
    private long id;
    private String username;
    private String password;
    private String emailAddress;
    private Set<GameStatisticsDTO> gamesPlayed = new HashSet<>();

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
}

