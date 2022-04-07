package com.game.repository.armor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class ArmorMySQLRepository implements ArmorRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ArmorMySQLRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Armor save(Armor armor) {
        String query = "INSERT INTO armor(armorClass, owner, durability, physicalDefense, magicalDefense) " +
                "VALUES (?, ?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, armor.getArmorClass().toString());
            ps.setString(2, armor.getOwner());
            ps.setInt(3, armor.getDurability());
            ps.setInt(4, armor.getPhysicalDefense());
            ps.setInt(5, armor.getMagicalDefense());
            return ps;
        }, keyHolder);
        armor.setArmorID(Objects.requireNonNull(keyHolder.getKey()).intValue());
        return armor;
    }

    @Override
    public Optional<Armor> findById(Integer id) {
        try {
            return Optional.ofNullable(jdbcTemplate.
                    queryForObject("SELECT * FROM armor WHERE armorID=?",
                            new BeanPropertyRowMapper<>(Armor.class), id));
        }
        catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<Armor> findByOwner(String owner) {
        return jdbcTemplate.query("SELECT * FROM armor WHERE owner=?", new BeanPropertyRowMapper<>(Armor.class), owner);    }

    @Override
    public List<Armor> findAll() {
        return jdbcTemplate.query("SELECT * FROM armor", new BeanPropertyRowMapper<>(Armor.class));
    }

    @Override
    public void deleteById(Integer id) {
        jdbcTemplate.update("DELETE FROM armor WHERE armorClass=?",  id);
    }

    @Override
    public void deleteByOwner(String name) {
        jdbcTemplate.update("DELETE FROM armor WHERE owner=?",  name);
    }

}
