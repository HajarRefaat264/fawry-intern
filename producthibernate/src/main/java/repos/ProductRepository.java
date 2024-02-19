package repos;


import entity.ProductEntity;




import java.util.List;

import jakarta.persistence.*;

public class ProductRepository {




    public ProductRepository()  {

    }

    public List<ProductEntity> findProducts() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            TypedQuery<ProductEntity> query = entityManager.createQuery("SELECT p FROM ProductEntity p", ProductEntity.class);
            List<ProductEntity> productList = query.getResultList();

            transaction.commit();

            return productList;
        }catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

//    public List<Product> getProducts() {
//        return findProducts();
//    }
    public void saveProduct(ProductEntity product) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {

            transaction.begin();


            entityManager.persist(product);


            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }

    }
    public void addProduct(ProductEntity product) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {

            transaction.begin();

            String sql = "INSERT INTO Product (name, price) SELECT name, price FROM Product";
            Query query = entityManager.createNativeQuery(sql);
            int result = query.executeUpdate();
            System.out.println("Rows affected: " + result);

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }}

    public boolean deleteProduct(int id) {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();

            try {

                // start a transaction

                transaction.begin();

                ProductEntity product = entityManager.find(ProductEntity.class, id);
                if (product != null) {
                    entityManager.remove(product);
                    transaction.commit();
                    return true;
                }
            } catch (Exception e) {
                if (transaction != null && transaction.isActive()) {
                    transaction.rollback();
                }
                e.printStackTrace();
            } finally {
                if (entityManager != null && entityManager.isOpen()) {
                    entityManager.close();
                }
            return false;
        }
}}
