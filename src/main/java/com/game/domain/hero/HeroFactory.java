package com.game.domain.hero;

import com.game.domain.hero.templates.Archer;
import com.game.domain.hero.templates.Knight;
import com.game.domain.hero.templates.Thief;
import com.game.domain.hero.templates.Wizard;
import org.springframework.stereotype.Component;

@Component
public class HeroFactory {

    public static Hero createHero(HeroClass heroClass, String name) {
        return new Hero(switch (heroClass) {
            case ARCHER -> new Archer(name);
            case KNIGHT -> new Knight(name);
            case THIEF -> new Thief(name);
            case WIZARD -> new Wizard(name);
        });
    }

}
