package com.shoe.dao;

import com.shoe.Service.JwtService;
import com.shoe.dto.Authorize;
import com.shoe.entities.User;
import com.shoe.form.UserForm;
import com.shoe.jpa.JpaUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {
    @Autowired
    private JpaUser jpa;
    @Autowired
    private EntityManager em;

    @Autowired
    private JwtService jwt;

    @Override
    public Authorize authorized(UserForm u) {

//        CriteriaBuilder builder = em.getCriteriaBuilder();
//        CriteriaQuery<User> query = builder.createQuery(User.class);
//        Root<User> from = query.from(User.class);
//        List<Predicate> predicates = new ArrayList<>();
//        predicates.add(builder.equal(from.get(User_.USERNAME),u.getUsername()));
//        predicates.add(builder.equal(from.get(User_.PASSWORD),u.getPassword()));
//        query.select(from).where(builder.and(predicates.toArray(new Predicate[predicates.size()])));
//        TypedQuery<User> typedQuery = em.createQuery(query);
//        List<User> list = new ArrayList<>();
//        typedQuery.getResultList().forEach(i -> {
//
//        });
        Authorize au = new Authorize();
        au.setStatus("ERROR");
        if (u == null) {
            return au;
        }
        Optional<User> user = jpa.findByusername(u.getUsername());

        if (user.isPresent()) {
            User validUser = user.get();
            if (validUser.getPassword().equals(u.getPassword())) {
                String token = jwt.generateTokenLogin(validUser.getUsername());
                validUser.setToken(token);
                au.setStatus("OK");
                au.setToken(token);
                return au;
            }
        }
        return au;
    }

    @Override
    public Authorize checkToken(Authorize auth) {
        if(auth == null){
            return null;
        }
        String username = jwt.getUsernameFromToken(auth.getToken());
        System.out.println(username);
        Optional<User> user = jpa.findByusername(username);
        if (user.isPresent()) {
            String token = user.get().getToken();
            if (token.equals(auth.getToken()) && jwt.validateTokenLogin(token) ) {
                return auth;
            }
        } else {
            auth.setStatus("Expired");
            auth.setToken("");
        }
        return auth;
    }
}
