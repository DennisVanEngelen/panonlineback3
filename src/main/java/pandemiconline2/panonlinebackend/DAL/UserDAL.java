package pandemiconline2.panonlinebackend.DAL;

import pandemiconline2.panonlinebackend.DAL.DTO.UserDTO;
import pandemiconline2.panonlinebackend.DAL.DataModels.UserDataModel;
import pandemiconline2.panonlinebackend.DAL.Interface.IUser;
import pandemiconline2.panonlinebackend.DAL.Interface.IUserContainer;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class UserDAL implements IUser, IUserContainer
{
    EntityManagerFactory entityManagerFactory;
    EntityTransaction entityTransaction;
    private EntityManager entityManager;


    public UserDTO LoginUser(String username, String password){
        entityManagerFactory =  Persistence.createEntityManagerFactory("PandemicOnline");
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
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
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
            entityTransaction = null;
        }
    }
    public UserDTO GetUser(long userID){
        entityManager  = entityManagerFactory.createEntityManager();

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
        entityManagerFactory =  Persistence.createEntityManagerFactory("PandemicOnline");
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

    public void UpdateUser(UserDTO userDTO)
    {
        entityManager  = entityManagerFactory.createEntityManager();
        try
        {
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            UserDataModel user = entityManager.find(UserDataModel.class, userDTO.getId());
            if(user.getGamesPlayed() != null)
            {
                user.getGamesPlayed().clear();
            }
            user = new UserDataModel(userDTO);
            entityManager.merge(user);
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
    public void DeleteUser(long userID){

        entityManager = entityManagerFactory.createEntityManager();
        try
        {
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            UserDataModel user = entityManager.find(UserDataModel.class,userID);
            entityManager.remove(user);
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

    public List<UserDTO> GetAllUsers(){
        return new ArrayList<>();
    }




}
