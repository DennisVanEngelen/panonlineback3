package pandemiconline2.panonlinebackend.DAL;

import pandemiconline2.panonlinebackend.DAL.DTO.AdminDTO;
import pandemiconline2.panonlinebackend.DAL.DTO.UserDTO;
import pandemiconline2.panonlinebackend.DAL.DataModel.AdminDataModel;
import pandemiconline2.panonlinebackend.DAL.DataModel.UserDataModel;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class AdminDAL
{
    static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PandemicOnline");
    EntityTransaction entityTransaction;
    private EntityManager entityManager;


    public AdminDTO LoginAdmin(String username, String password){
        entityManager  = entityManagerFactory.createEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<AdminDataModel> query = builder.createQuery(AdminDataModel.class);
        Root<AdminDataModel> root = query.from(AdminDataModel.class);

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
            return new AdminDTO(entityManager.createQuery(query).getSingleResult());
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
}
