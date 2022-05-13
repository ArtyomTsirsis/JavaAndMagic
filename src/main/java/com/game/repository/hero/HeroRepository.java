package com.game.repository.hero;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface HeroRepository extends JpaRepository<Hero, String> {

    void deleteById(String heroName);
    @Modifying
    @Query("UPDATE hero u SET health = :#{#h.health}, level = :#{#h.level}, armorID = :#{#h.armorID}" +
            ", weaponID = :#{#h.weaponID} WHERE name = :#{#h.name}")
    void update(@Param("h") Hero hero);

}
