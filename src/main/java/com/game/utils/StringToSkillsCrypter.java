package com.game.utils;

import com.game.skills.hero.HeroSkill;
import com.game.skills.hero.HeroSkillFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class StringToSkillsCrypter {

    public List<HeroSkill> decrypt(String encryptedSkills) {
        String[] decryptedSkills = encryptedSkills.split(", ");
        List<HeroSkill> skills = new ArrayList<>();
        Arrays.stream(decryptedSkills).toList().forEach(o -> skills.add(HeroSkillFactory.createSkill(o)));
        return skills;
    }

}
