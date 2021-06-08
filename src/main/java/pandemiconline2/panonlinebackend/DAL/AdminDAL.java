package pandemiconline2.panonlinebackend.DAL;

import pandemiconline2.panonlinebackend.DAL.DTO.AdminDTO;
import pandemiconline2.panonlinebackend.DAL.DataModels.AdminDataModel;

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
}
