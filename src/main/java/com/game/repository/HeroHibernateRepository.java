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
    public void save(Hero hero) {
        sessionFactory.getCurrentSession().persist(new Hero(hero));
    }

    @Override
    public Optional<Hero> findById(String heroName) {
        Hero toReturn = sessionFactory.getCurrentSession().get(Hero.class, heroName);
        return Optional.ofNullable(toReturn);
    }

    @Override
    public List<Hero> findAll() {
        return sessionFactory.getCurrentSession().createNativeQuery("SELECT * FROM heroes", Hero.class).getResultList();
    }

    @Override
    public void deleteById(String heroName) {
        sessionFactory.getCurrentSession().delete(findById(heroName).get());
    }

}
