package persistence;

import entity.Family;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Root;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;

import java.util.List;

public class FamilyData {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Get Family by id
     *
     */
    public Family getById(int id) {
        Session session = sessionFactory.openSession();
        Family family = session.get(Family.class, id);
        session.close();
        return family;
    }

    /**
     * update Family
     *
     * @param family  Family to be updated
     */
    public void update(Family family) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(family);
        transaction.commit();
        session.close();
    }

    /**
     * Insert a new Family
     *
     * @param family  Family to be inserted
     */
    public int insert(Family family) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(family);
        transaction.commit();
        id = family.getId();
        session.close();
        return id;
    }

    /**
     * Delete a Family
     *
     * @param family Family to be deleted
     */
    public void delete(Family family) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(family);
        transaction.commit();
        session.close();
    }


    /**
     * Return a list of all Families
     *
     * @return All families
     */
    public List<Family> getAll() {
        Session session = sessionFactory.openSession();

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Family> query = builder.createQuery(Family.class);
        Root<Family> root = query.from(Family.class);
        List<Family> famalies = session.createSelectionQuery( query ).getResultList();

        logger.debug("The list of families " + famalies);
        session.close();

        return famalies;
    }

    /**
     * Get Family by property (exact match)
     *
     * sample usage: getByPropertyEqual("familyName", "Spriggs Family")
     */
    public List<Family> getByPropertyEqual(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for family with " + propertyName + " = " + value);

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Family> query = builder.createQuery(Family.class);
        Root<Family> root = query.from(Family.class);
        query.select(root).where(builder.equal(root.get(propertyName), value));
        List<Family> families = session.createSelectionQuery( query ).getResultList();

        session.close();
        return families;
    }

    /**
     * Get Family by property (like)
     *
     * sample usage: getByPropertyLike("familyName", "Spriggs")
     */
    public List<Family> getByPropertyLike(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for user with {} = {}",  propertyName, value);

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Family> query = builder.createQuery(Family.class);
        Root<Family> root = query.from(Family.class);
        Expression<String> propertyPath = root.get(propertyName);

        query.where(builder.like(propertyPath, "%" + value + "%"));

        List<Family> families = session.createQuery( query ).getResultList();
        session.close();
        return families;
    }

}
