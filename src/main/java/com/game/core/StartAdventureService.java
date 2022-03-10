package com.game.core;

import com.game.ui.MoveForwardUIAction;
import repository.enemy.Orc;
import repository.hero.HeroRepository;
import skills.hero.ConcreteHeroSkillFastAttack;

public class StartAdventureService {


    private String heroName;
    private final HeroRepository repository;
    private MoveForwardUIAction moveForwardUIAction = new MoveForwardUIAction();
    private ConcreteHeroSkillFastAttack concreteHeroSkillFastAttack = new ConcreteHeroSkillFastAttack();

    public StartAdventureService(HeroRepository repository) {
        this.repository = repository;
    }

    public void moveForward(String heroName) {
        var hero = repository.findById(heroName);

        moveForwardUIAction.execute();




        var orc = new Orc();

        repository.findAll().forEach(System.out::println);
        var hp = orc.getHealth();
        System.out.println(hp);

        concreteHeroSkillFastAttack.execute(hero, orc);


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

        concreteHeroSkillFastAttack.execute(hero, orc);


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

        concreteHeroSkillFastAttack.execute(hero, orc);


        var print = repository.findById(heroName);
        var hpAfterBattle = orc.getHealth();
        System.out.println(hpAfterBattle);
        System.out.println(print);
    }
}
