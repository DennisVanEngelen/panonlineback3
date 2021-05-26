package pandemiconline2.panonlinebackend.DAL;

import pandemiconline2.panonlinebackend.DAL.DTO.UserDTO;
import pandemiconline2.panonlinebackend.DAL.DataModel.UserDataModel;
import pandemiconline2.panonlinebackend.DAL.Interface.IUser;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UserDAL implements IUser
{
    static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("playcatan-back-end");
    EntityTransaction entityTransaction;
    private EntityManager entityManager;

    //AuthenticationInterface
    public void SaveUser(UserDTO userDTO)
    {
        entityManager = entityManagerFactory.createEntityManager();
        try
        {
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.persist(new UserDataModel(userDTO));
            entityTransaction.commit();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            entityTransaction.rollback();
        }
        finally
        {
            if(entityManager.isOpen())
            {
                entityManager.close();
            }
            entityTransaction = null;
        }
    }
}
