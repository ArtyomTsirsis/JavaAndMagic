package com.game.domain.hero;

import com.game.domain.hero.Hero;
import com.game.domain.hero.HeroClass;
import com.game.domain.hero.HeroFactory;
import com.game.domain.hero.templates.Archer;
import com.game.domain.hero.templates.Knight;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HeroFactoryTest {

    /*
     * scenario1
     * input: HeroClass.KNIGHT, "Arthur"
     * expected output: new Hero(new Knight("Arthur"))
     */
    @Test
    void scenario1() {
        Hero actual = HeroFactory.createHero(HeroClass.KNIGHT, "Arthur");
        Hero expected = new Hero(new Knight("Arthur"));
        assertEquals(expected, actual);
    }

    /*
     * scenario2
     * input: HeroClass.ARCHER, "test123"
     * expected output: new Hero(new Archer("test123"))
     */
    @Test
    void scenario2() {
        Hero actual = HeroFactory.createHero(HeroClass.ARCHER, "test123");
        Hero expected = new Hero(new Archer("test123"));
        assertEquals(expected, actual);
    }

}