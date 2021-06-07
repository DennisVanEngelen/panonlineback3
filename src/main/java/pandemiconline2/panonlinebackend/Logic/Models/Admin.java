package pandemiconline2.panonlinebackend.Logic.Models;

import lombok.Getter;
import lombok.Setter;
import pandemiconline2.panonlinebackend.DAL.DTO.AdminDTO;
@Getter
@Setter
public class Admin
{
    private long id;
    private String Username;
    private String Password;
    public Admin(AdminDTO dto){

    }
}
