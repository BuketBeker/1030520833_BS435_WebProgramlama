package org.webp.intro.jee.ejb.stateless;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;

@Stateless
public class UserBean {
    @PersistenceContext
    private EntityManager em;

    public UserBean(){}

    public void registerNewUser( @NotNull Long id, @NotNull Long userid, @NotNull String username, @NotNull String password){
        if(isRegistered(id)){
            return;
        }

        User user = new User();
        user.setUserid(userid);
        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);

        em.persist(user);
    }

    public boolean isRegistered(@NotNull String id){
        User user = em.find(User.class, id);
        return user != null;
    }

    public long getNumberOfUsers(){
        TypedQuery<Long> query = em.createQuery("select count(u) from User u", Long.class);
        long n = query.getSingleResult();
        return n;
    }
}
