package com.game.repository;

import com.game.repository.hero.Hero;
import com.game.repository.hero.HeroRepository;
import com.game.repository.hero.Knight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class HeroMySQLRepository implements HeroRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public HeroMySQLRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(Hero hero) {
        String query = "INSERT INTO heroes(name, heroClass, health, strength, level, dexterity, weaponID, armorID, skillBook) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, hero.getName());
            ps.setString(2, hero.getHeroClass().toString());
            ps.setInt(3, hero.getHealth());
            ps.setInt(4, hero.getStrength());
            ps.setInt(5, hero.getLevel());
            ps.setInt(6, hero.getDexterity());
            ps.setInt(7, hero.getWeapon().getId());
            ps.setInt(8, hero.getArmor().getId());
            ps.setString(9, hero.getSkills());
            return ps;
        });
    }

    @Override
    public Hero findById(String heroName) {
        return new Knight("Arthur");
    }



//    public Optional<Hero> findById(String heroName) {
//        var toReturn = (Hero) jdbcTemplate.queryForObject("SELECT * FROM heroes WHERE name=?",
//                new Object[]{heroName}, new BeanPropertyRowMapper(Hero.class));
//        return Optional.ofNullable(toReturn);
//    }

//    Row types to Generic
    @Override
    public List<Hero> findAll() {
        return jdbcTemplate.query("SELECT * FROM heroes", new BeanPropertyRowMapper(Hero.class));
    }

    @Override
    public void deleteById(String heroName) {

    }

}
