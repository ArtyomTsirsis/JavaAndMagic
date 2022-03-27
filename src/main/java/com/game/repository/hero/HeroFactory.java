package com.game.repository.hero;

import com.game.repository.hero.templates.Archer;
import com.game.repository.hero.templates.Knight;
import com.game.repository.hero.templates.Thief;
import com.game.repository.hero.templates.Wizard;
import org.springframework.stereotype.Component;

@Component
public class HeroFactory {

    public static Hero createHero(HeroClass heroClass, String name) {
        return switch (heroClass) {
            case ARCHER -> new Archer(name);
            case KNIGHT -> new Knight(name);
            case THIEF -> new Thief(name);
            case WIZARD -> new Wizard(name);
            default -> null;
        };
    }

}
