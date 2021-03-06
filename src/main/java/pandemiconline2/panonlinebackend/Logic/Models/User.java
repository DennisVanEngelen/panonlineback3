package pandemiconline2.panonlinebackend.Logic.Models;

import pandemiconline2.panonlinebackend.API.ViewModel.UserRegisterViewModel;
import pandemiconline2.panonlinebackend.DAL.DTO.GameStatisticsDTO;
import pandemiconline2.panonlinebackend.DAL.DTO.UserDTO;
import  pandemiconline2.panonlinebackend.API.ViewModel.UserViewModel;
import lombok.Getter;
import lombok.Setter;
import pandemiconline2.panonlinebackend.DAL.Interface.IUser;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter @Setter
public class User
{
    private long id;
    private String Username;
    private String Password;
    private String EmailAddress;
    private List<GameStatistics> gameStatistics = new ArrayList<>();

    //Converters

    //Constructors
    public User(UserDTO user)
    {
        if (user != null)
        {
            id = user.getId();
            Username = user.getUsername();
            EmailAddress = user.getEmailAddress();
            if (user.getGamesPlayed() != null)
            {
                for (GameStatisticsDTO gamestats : user.getGamesPlayed())
                {
                    gameStatistics.add(new GameStatistics(gamestats));
                }
            }
        }
    }

    public User(UserViewModel user)
    {
        id = user.getUserid();
        Username = user.getUsername();
        EmailAddress = user.getEmail();
    }

    public User(long id){
        this.id = id;
    }
    public User(UserRegisterViewModel user)
    {
        Username = user.getUsername();
        Password = user.getPassword();
        EmailAddress = user.getEmailadress();
    }

    public User(String username){
        Username = username;
    }

    public boolean AddUser(IUser dal){
        return dal.SaveUser(new UserDTO(this));

    }

    public void UpdateUser(IUser dal){
        dal.UpdateUser(new UserDTO(this));

    }
    public void DeleteUser(IUser dal){
        dal.DeleteUser(this.id);
    }


}
