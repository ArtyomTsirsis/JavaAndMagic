package com.game.utils;

import com.game.skills.hero.HeroSkill;
import com.game.skills.hero.HeroSkillFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class StringToSkillsDecoder {

    public List<HeroSkill> decrypt(String encryptedSkills) {
        String[] decryptedSkills = encryptedSkills.split(",");
        List<HeroSkill> skills = new ArrayList<>();
        Arrays.stream(decryptedSkills).toList().forEach(o -> skills.add(HeroSkillFactory.createSkill(o)));
        return skills;
    }

    public String encrypt(List<HeroSkill> decryptedSkills) {
        StringBuilder sb = new StringBuilder();
        decryptedSkills.forEach(o -> sb.insert(sb.length(), o.getName() + ","));
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

}
