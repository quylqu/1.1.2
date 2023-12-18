package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.hibernate_entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import jm.task.core.jdbc.util.Util;
import org.hibernate.query.Query;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    SessionFactory factory = Util.getConfiguration().addAnnotatedClass(User.class).buildSessionFactory();

    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            String sql = "CREATE TABLE IF NOT EXISTS User (id BIGINT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(255) NOT NULL, lastName VARCHAR(255) NOT NULL, age INT NOT NULL";
            Query query = session.createSQLQuery(sql).addEntity(User.class);
            session.getTransaction().commit();
            session.close();
        }
    }

    @Override
    public void dropUsersTable() {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            String sql = "DROP TABLE IF EXISTS User";
            Query query = session.createSQLQuery(sql).addEntity(User.class);
            session.getTransaction().commit();
            session.close();
        }
    }

    @Override
    public void saveUser(String name, String lastName, Byte age) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            session.save(new User(name, lastName, age));
            session.getTransaction().commit();
        }
    }

    @Override
    public void removeUserById(Long id) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            session.delete(id);
            session.getTransaction().commit();
        }
    }

    @Override
    public List<User> getAllUsers() {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            List<User> userList = session.createQuery("from User")
                    .getResultList();
            session.getTransaction().commit();
            return userList;
        }
    }

    @Override
    public void cleanUsersTable() {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            session.createQuery("delete User");
            session.getTransaction().commit();
        }
    }
}
