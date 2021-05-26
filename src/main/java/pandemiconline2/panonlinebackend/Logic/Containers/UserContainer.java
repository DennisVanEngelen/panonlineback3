package pandemiconline2.panonlinebackend.Logic.Containers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pandemiconline2.panonlinebackend.DAL.DTO.UserDTO;
import pandemiconline2.panonlinebackend.DAL.Interface.IUser;
import pandemiconline2.panonlinebackend.DAL.Interface.IUserContainer;
import pandemiconline2.panonlinebackend.Logic.Models.User;
@Component
public class UserContainer {
    IUserContainer iUserContainer;

    public UserContainer()
    {
    }

    public void SaveUser(User user)
    {

    }

    public void UpdateUser(User user){

    }
}
