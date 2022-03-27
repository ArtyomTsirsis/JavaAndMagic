package com.game.repository;

import com.game.repository.armor.Armor;
import com.game.repository.armor.ArmorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

@Repository
public class ArmorMySQLRepository implements ArmorRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ArmorMySQLRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(Armor armor) {
        String query = "INSERT INTO armor(armorClass, owner, durability, physicalDefense, magicalDefense) " +
                "VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, armor.getArmorClass().toString());
            ps.setString(2, armor.getOwner());
            ps.setInt(3, armor.getDurability());
            ps.setInt(4, armor.getPhysicalDefense());
            ps.setInt(5, armor.getMagicalDefense());
            return ps;
        });
    }

    @Override
    public Optional<Armor> findById(Integer id) {
        return Optional.ofNullable(jdbcTemplate.
                queryForObject("SELECT * FROM armor WHERE armorClass=?",
                        new BeanPropertyRowMapper<>(Armor.class), id));
    }

    @Override
    public List<Armor> findAll() {
        return jdbcTemplate.query("SELECT * FROM armor", new BeanPropertyRowMapper<>(Armor.class));
    }

    @Override
    public void deleteById(Integer id) {
        jdbcTemplate.update("DELETE FROM armor WHERE armorClass=?",  id);
    }
}
