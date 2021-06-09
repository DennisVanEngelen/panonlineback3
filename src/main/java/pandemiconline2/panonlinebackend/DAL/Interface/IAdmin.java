package pandemiconline2.panonlinebackend.DAL.Interface;

import pandemiconline2.panonlinebackend.DAL.DTO.AdminDTO;

public interface IAdmin
{
    AdminDTO LoginAdmin(String username, String password);
}
