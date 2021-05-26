package pandemiconline2.panonlinebackend.Logic.Models;

import pandemiconline2.panonlinebackend.DAL.DTO.UserDTO;
import  pandemiconline2.panonlinebackend.API.ViewModel.UserViewModel;
import lombok.Getter;
import lombok.Setter;
import pandemiconline2.panonlinebackend.DAL.Interface.IUser;

import java.util.List;
@Getter
@Setter
public class User
{
    private long id;
    private String Username;
    private String Password;
    private String EmailAddress;

    //Converters

    //Constructors
    public User(UserDTO user)
    {
        id = user.getId();
        Username = user.getUsername();
        EmailAddress = user.getEmailAddress();
    }

    public User(UserViewModel user)
    {
        id = user.getID();
        Username = user.getUsername();
        EmailAddress = user.getEmailAddress();
    }

    public void DeleteUser()
    {

    }

    public void UpdateUser()
    {

    }

}
