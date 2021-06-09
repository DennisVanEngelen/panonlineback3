package pandemiconline2.panonlinebackend.DAL.DTO;

import lombok.Getter;
import lombok.Setter;
import pandemiconline2.panonlinebackend.DAL.DataModels.AdminDataModel;
@Getter@Setter
public class AdminDTO
{
    long id;
    String username;
    String password;

    public AdminDTO(){}

    public AdminDTO(AdminDataModel adminDataModel)
    {
        this.username = adminDataModel.getUsername();
        this.password = adminDataModel.getPassword();
        this.id = adminDataModel.getId();
    }


    public AdminDTO(long id, String username, String password){
        this.id = id;
        this.username = username;
        this.password = password;
    }
}
