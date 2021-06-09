package pandemiconline2.panonlinebackend;

import pandemiconline2.panonlinebackend.DAL.DTO.AdminDTO;
import pandemiconline2.panonlinebackend.DAL.DTO.UserDTO;
import pandemiconline2.panonlinebackend.DAL.Interface.IAdmin;
import pandemiconline2.panonlinebackend.Logic.Models.Admin;

import java.util.ArrayList;
import java.util.List;

public class AdminTestRepo implements IAdmin
{
    List<AdminDTO> admins = new ArrayList<>();


    public AdminTestRepo()
    {
        for (long i = 0; i < 5; i++) {
            admins.add(new AdminDTO(i,"testadmin"+i,"testpass"+i));
        }
    }

    public AdminDTO LoginAdmin(String username, String password){
        for (AdminDTO adminDTO:admins)
        {
            if (adminDTO.getUsername().equals(username)&&adminDTO.getPassword().equals(password)){
                return adminDTO;
            }
        }
        return null;
    }
}
