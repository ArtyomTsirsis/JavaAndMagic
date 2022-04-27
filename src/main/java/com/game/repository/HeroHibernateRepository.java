package com.game.repository;

import com.game.repository.hero.Hero;
import com.game.repository.hero.HeroRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class HeroHibernateRepository implements HeroRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Hero save(Hero hero) {
        sessionFactory.openSession().persist(hero);
        return hero;
    }

    @Override
    public Optional<Hero> findById(String heroName) {
        return Optional.ofNullable(sessionFactory
                .openSession()
                .get(Hero.class, heroName));
    }

    @Override
    public List<Hero> findAll() {
        return sessionFactory.openSession()
                .createNativeQuery("SELECT * FROM heroes", Hero.class)
                .getResultList();
    }

    @Override
    public void deleteById(String heroName) {
        sessionFactory.openSession()
                .createQuery("DELETE hero h WHERE h.name=:param")
                .setParameter("param", heroName)
                .executeUpdate();
    }

    @Override
    public void update(Hero hero) {
        sessionFactory.openSession().update(hero);
    }

}
