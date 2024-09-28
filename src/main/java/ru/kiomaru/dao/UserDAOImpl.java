package ru.kiomaru.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import ru.kiomaru.entity.User;

import java.util.List;

@Repository
public class UserDAOImpl {

    @PersistenceContext
    private EntityManager em;

    public List<User> getAllUsers() {
        TypedQuery<User> query = em.createQuery("from User", User.class);
        return query.getResultList();
    }

    public void save(User user) {
        em.persist(user);
    }
}
