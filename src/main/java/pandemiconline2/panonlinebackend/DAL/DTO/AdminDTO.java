package pandemiconline2.panonlinebackend.DAL.DTO;

import lombok.Getter;
import pandemiconline2.panonlinebackend.DAL.DataModels.AdminDataModel;
@Getter
public class AdminDTO
{
    long id;
    String username;
    String password;

    public AdminDTO(AdminDataModel adminDataModel)
    {
        this.username = adminDataModel.getUsername();
        this.password = adminDataModel.getPassword();
        this.id = adminDataModel.getId();
    }
}
