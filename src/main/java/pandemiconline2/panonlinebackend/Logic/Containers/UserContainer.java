package pandemiconline2.panonlinebackend.Logic.Containers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pandemiconline2.panonlinebackend.DAL.DTO.UserDTO;
import pandemiconline2.panonlinebackend.DAL.Interface.IUser;
import pandemiconline2.panonlinebackend.DAL.Interface.IUserContainer;
import pandemiconline2.panonlinebackend.Logic.Models.User;

import java.util.ArrayList;
import java.util.List;

public class UserContainer {
    IUserContainer iUserContainer;
    public UserContainer(IUserContainer container)
    {
        this.iUserContainer = container;
    }

    public User GetUser(long userID){

        User user = new User(iUserContainer.GetUser(userID));
        if(user.getEmailAddress() != null){
            return user;
        }
        return null;
    }
    public List<User> GetAllUsers()
    {
        List<User> users = new ArrayList<>();
        for (UserDTO user : iUserContainer.GetAllUsers())
        {
            users.add(new User(user));
        }
        return users;
    }
}
