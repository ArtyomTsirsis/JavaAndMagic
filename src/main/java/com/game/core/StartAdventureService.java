package com.game.core;

import com.game.repository.hero.HeroRepository;
import com.game.ui.MoveForwardUIAction;
import com.game.repository.enemy.Orc;
import com.game.repository.hero.HashMapHeroRepository;
import com.game.skills.hero.ConcreteHeroSkillFastAttack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StartAdventureService {


    private String heroName;

    @Autowired
    private HeroRepository repository;

    private MoveForwardUIAction moveForwardUIAction = new MoveForwardUIAction();
    private ConcreteHeroSkillFastAttack concreteHeroSkillFastAttack = new ConcreteHeroSkillFastAttack();

    public void moveForward(String heroName) {
        var hero = repository.findById(heroName);

        moveForwardUIAction.execute();




        var orc = new Orc();

        repository.findAll().forEach(System.out::println);
        var hp = orc.getHealth();
        System.out.println(hp);

//        concreteHeroSkillFastAttack.execute(hero, orc);


        var print = repository.findById(heroName);
        var hpAfterBattle = orc.getHealth();
        System.out.println(hpAfterBattle);
        System.out.println(print);
    }

    public void moveLeft(String heroName) {
        var hero = repository.findById(heroName);
        var orc = new Orc();

        repository.findAll().forEach(System.out::println);
        var hp = orc.getHealth();
        System.out.println(hp);

//        concreteHeroSkillFastAttack.execute(hero, orc);


        var print = repository.findById(heroName);
        var hpAfterBattle = orc.getHealth();
        System.out.println(hpAfterBattle);
        System.out.println(print);
    }

    public void moveRight(String heroName) {
        var hero = repository.findById(heroName);
        var orc = new Orc();

        repository.findAll().forEach(System.out::println);
        var hp = orc.getHealth();
        System.out.println(hp);

//        concreteHeroSkillFastAttack.execute(hero, orc);


        var print = repository.findById(heroName);
        var hpAfterBattle = orc.getHealth();
        System.out.println(hpAfterBattle);
        System.out.println(print);
    }
}
