package com.game.utils;

import com.game.skills.hero.ConcreteHeroSkillFastAttack;
import com.game.skills.hero.ConcreteHeroSkillHealing;
import com.game.skills.hero.ConcreteHeroSkillStealthAttack;
import com.game.skills.hero.HeroSkill;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
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
        String actualResult = decoder.encrypt(skills);
        String expectedResult = "Healing,StealthAttack";
        assertEquals(expectedResult, actualResult);
    }

    /*
     * scenario2
     * input: List.of(new ConcreteHeroSkillFastAttack())
     * expected output: FastAttack
     */
    @Test
    void scenario2() {
        List<HeroSkill> skills = List.of(new ConcreteHeroSkillFastAttack());
        String actualResult = decoder.encrypt(skills);
        String expectedResult = "FastAttack";
        assertEquals(expectedResult, actualResult);
    }

    /*
     * scenario3
     * input: Healing,StealthAttack
     * expected output: List.of(new ConcreteHeroSkillHealing(), new ConcreteHeroSkillStealthAttack(), new)
     */
    @Test
    void scenario3() {
        List<HeroSkill> actualResult = decoder.decrypt("Healing,StealthAttack");
        List<HeroSkill> expectedResult = List.of(new ConcreteHeroSkillHealing(), new ConcreteHeroSkillStealthAttack());
        assertEquals(expectedResult, actualResult);
    }

    /*
     * scenario4
     * input: FastAttack
     * expected output: List.of(new ConcreteHeroSkillFastAttack())
     */
    @Test
    void scenario4() {
        List<HeroSkill> actualResult = decoder.decrypt("FastAttack");
        List<HeroSkill> expectedResult = List.of(new ConcreteHeroSkillFastAttack());
        assertEquals(expectedResult, actualResult);
    }

}
