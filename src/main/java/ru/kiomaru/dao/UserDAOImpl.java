package ru.kiomaru.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import ru.kiomaru.entity.User;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> getAllUsers() {
        TypedQuery<User> query = em.createQuery("from User", User.class);
        return query.getResultList();
    }

    @Override
    public void save(User user) {
        em.persist(user);
    }

    @Override
    public void delete(int id) {
        try {
            em.remove(em.getReference(User.class, id));
        } catch (EntityNotFoundException e) {
            System.out.println("User with id " + id + " not found");
        }
    }

    @Override
    public void saveEditedUser(int id, User user) {
        User oldUser = em.find(User.class, id);
        oldUser.setFirstName(user.getFirstName());
        oldUser.setLastName(user.getLastName());
        oldUser.setEmail(user.getEmail());
        oldUser.setAge(user.getAge());
        oldUser.setUserLogin(user.getUserLogin());
    }

    @Override
    public User getUserById(int id) {
        return em.find(User.class, id);
    }
}
