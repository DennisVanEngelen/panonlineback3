package pandemiconline2.panonlinebackend.DAL;

import pandemiconline2.panonlinebackend.DAL.DTO.GameStatisticsDTO;
import pandemiconline2.panonlinebackend.DAL.DTO.UserDTO;
import pandemiconline2.panonlinebackend.DAL.DataModels.AdminDataModel;
import pandemiconline2.panonlinebackend.DAL.DataModels.GameStatisticsDataModel;
import pandemiconline2.panonlinebackend.DAL.DataModels.UserDataModel;
import pandemiconline2.panonlinebackend.DAL.Interface.IUser;
import pandemiconline2.panonlinebackend.DAL.Interface.IUserContainer;
import pandemiconline2.panonlinebackend.Logic.Models.User;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class UserDAL implements IUser, IUserContainer
{
    EntityManagerFactory entityManagerFactory =  Persistence.createEntityManagerFactory("PandemicOnline");
    EntityTransaction entityTransaction;
    private EntityManager entityManager;


    public UserDTO LoginUser(String username, String password){
        entityManager  = entityManagerFactory.createEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserDataModel> query = builder.createQuery(UserDataModel.class);
        Root<UserDataModel> root = query.from(UserDataModel.class);

        Predicate predicateUsername
                = builder.like(root.get("username"), username);
        Predicate predicatePassword
                = builder.like(root.get("password"), password);
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
    public boolean SaveUser(UserDTO userDTO)
    {
        entityManager = entityManagerFactory.createEntityManager();
        try
        {
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            UserDataModel userDataModel = new UserDataModel(userDTO);
            entityManager.persist(userDataModel);
            entityTransaction.commit();
            return true;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            entityTransaction.rollback();
            return false;
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
            userDTO.setPassword(user.getPassword());
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
    public GameStatisticsDTO GetGameStatistics(long id){
        entityManager  = entityManagerFactory.createEntityManager();

        try
        {
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            return new GameStatisticsDTO(entityManager.find(GameStatisticsDataModel.class, id));
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

            entityManager = entityManagerFactory.createEntityManager();
            CriteriaBuilder builder = entityManager.getCriteriaBuilder();
            CriteriaQuery<UserDataModel> query = builder.createQuery(UserDataModel.class);
            Root<UserDataModel> root = query.from(UserDataModel.class);
            query.select(root);
            Converter converter = new Converter();
            try
            {
                return converter.convertUserDataModelToDTO(entityManager.createQuery(query).getResultList());
            }
            catch (Exception ex)
            {
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




}
