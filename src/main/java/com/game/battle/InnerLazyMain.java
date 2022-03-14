package com.game.battle;

import com.game.repository.stuff.enemy.Orc;
import com.game.repository.hero.Knight;

public class InnerLazyMain {

    public static void main(String[] args) {

        Battle battle = new Battle(new Knight("Rex"), new Orc());
        battle.fightSimulator();
    }

}
