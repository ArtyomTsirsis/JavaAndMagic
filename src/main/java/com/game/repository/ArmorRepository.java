package com.game.repository;

import com.game.domain.armor.Armor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface ArmorRepository extends JpaRepository<Armor, Integer> {

    List<Armor> findByOwner(String owner);
    void deleteById(Integer id);
    void deleteByOwner(String name);
    @Modifying
    @Query("UPDATE armor u SET durability = :#{#a.durability} WHERE armorID = :#{#a.armorID}")
    void update(@Param("a") Armor armor);

}
