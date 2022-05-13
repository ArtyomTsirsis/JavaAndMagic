package com.game.utils;

import com.game.skills.hero.ConcreteHeroSkillFastAttack;
import com.game.skills.hero.ConcreteHeroSkillHealing;
import com.game.skills.hero.ConcreteHeroSkillStealthAttack;
import com.game.skills.hero.HeroSkill;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class StringToSkillsDecoderTest {

    private final StringToSkillsDecoder decoder = new StringToSkillsDecoder();

    /*
    * scenario1
    * input: List.of(new ConcreteHeroSkillHealing(), new ConcreteHeroSkillStealthAttack())
    * expected output: Healing,StealthAttack
     */
    @Test
    void scenario1() {
        List<HeroSkill> skills = List.of(new ConcreteHeroSkillHealing(), new ConcreteHeroSkillStealthAttack());
        String actual = decoder.encrypt(skills);
        String expected = "Healing,StealthAttack";
        assertEquals(expected, actual);
    }

    /*
     * scenario2
     * input: List.of(new ConcreteHeroSkillFastAttack())
     * expected output: FastAttack
     */
    @Test
    void scenario2() {
        List<HeroSkill> skills = List.of(new ConcreteHeroSkillFastAttack());
        String actual = decoder.encrypt(skills);
        String expected = "FastAttack";
        assertEquals(expected, actual);
    }

    /*
     * scenario3
     * input: Healing,StealthAttack
     * expected output: List.of(new ConcreteHeroSkillHealing(), new ConcreteHeroSkillStealthAttack(), new)
     */
    @Test
    void scenario3() {
        List<HeroSkill> actual = decoder.decrypt("Healing,StealthAttack");
        List<HeroSkill> expected = List.of(new ConcreteHeroSkillHealing(), new ConcreteHeroSkillStealthAttack());
        assertEquals(expected, actual);
    }

    /*
     * scenario4
     * input: FastAttack
     * expected output: List.of(new ConcreteHeroSkillFastAttack())
     */
    @Test
    void scenario4() {
        List<HeroSkill> actual = decoder.decrypt("FastAttack");
        List<HeroSkill> expected = List.of(new ConcreteHeroSkillFastAttack());
        assertEquals(expected, actual);
    }

}
