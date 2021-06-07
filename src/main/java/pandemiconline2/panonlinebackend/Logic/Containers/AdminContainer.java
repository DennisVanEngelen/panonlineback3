package pandemiconline2.panonlinebackend.Logic.Containers;

import org.springframework.stereotype.Component;
import pandemiconline2.panonlinebackend.DAL.Interface.IUserContainer;
import pandemiconline2.panonlinebackend.Logic.Models.User;

@Component
public class AdminContainer
{
    IUserContainer iUserContainer;

    public AdminContainer()
    {
    }

    public void SaveUser(User user)
    {

    }

    public void UpdateUser(User user){

    }

    public void Removeuser(User user){

    }
}
