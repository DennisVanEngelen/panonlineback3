package pandemiconline2.panonlinebackend.DAL;

import pandemiconline2.panonlinebackend.DAL.DTO.UserDTO;
import pandemiconline2.panonlinebackend.DAL.DataModel.UserDataModel;
import pandemiconline2.panonlinebackend.DAL.Interface.IUser;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class UserDAL implements IUser
{
    static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("playcatan-back-end");
    EntityTransaction entityTransaction;
    private EntityManager entityManager;


    public UserDTO LoginUser(String username, String password){
        entityManager  = entityManagerFactory.createEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserDataModel> query = builder.createQuery(UserDataModel.class);
        Root<UserDataModel> root = query.from(UserDataModel.class);

        Predicate predicateUsername
                = builder.like(root.get("Username"), username);
        Predicate predicatePassword
                = builder.like(root.get("Password"), password);
        Predicate predicateLogIn
                = builder.and(predicateUsername, predicatePassword);

        query.select(root).where(predicateLogIn);

        try
        {
            return new UserDTO(entityManager.createQuery(query).getSingleResult());
        }
        catch (NoResultException ex)
        {
            System.out.println("ex");
            return null;
        }
        finally
        {
            if(entityManager.isOpen())
            {
                entityManager.close();
            }
        }
    }
    public UserDTO GetUser(long userID){
        entityManager  = entityManagerFactory.createEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserDataModel> query = builder.createQuery(UserDataModel.class);
        Root<UserDataModel> root = query.from(UserDataModel.class);


        try
        {
           return new UserDTO(entityManager.find(UserDataModel.class, userID));
        }
        catch (NoResultException ex)
        {
            System.out.println("ex");
            return null;
        }
        finally
        {
            if(entityManager.isOpen())
            {
                entityManager.close();
            }
        }

    }
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
