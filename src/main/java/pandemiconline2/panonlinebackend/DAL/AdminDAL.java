package pandemiconline2.panonlinebackend.DAL;

import pandemiconline2.panonlinebackend.DAL.DTO.AdminDTO;
import pandemiconline2.panonlinebackend.DAL.DataModels.AdminDataModel;
import pandemiconline2.panonlinebackend.DAL.DataModels.UserDataModel;
import pandemiconline2.panonlinebackend.DAL.Interface.IAdmin;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class AdminDAL implements IAdmin
{
    static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PandemicOnline");
    EntityTransaction entityTransaction;
    private EntityManager entityManager;


    public AdminDTO LoginAdmin(String username, String password){
        AdminDTO dto;
        entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<AdminDataModel> query = builder.createQuery(AdminDataModel.class);
        Root<AdminDataModel> root = query.from(AdminDataModel.class);

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
            AdminDataModel dataModel = entityManager.createQuery(query).getSingleResult();
            entityTransaction.commit();
            dto = new AdminDTO(dataModel);
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
        return dto;
    }

    public void SaveAdmin(AdminDTO adminDTO){
        entityManagerFactory =  Persistence.createEntityManagerFactory("PandemicOnline");
        entityManager = entityManagerFactory.createEntityManager();
        try
        {
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.persist(new AdminDataModel(adminDTO));
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
