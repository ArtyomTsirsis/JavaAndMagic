package core;

import repository.enemy.Orc;
import repository.hero.HeroRepository;
import skills.hero.ConcreteHeroSkillFastAttack;

public class StartAdventureService {

    private final HeroRepository repository;
    private ConcreteHeroSkillFastAttack concreteHeroSkillFastAttack = new ConcreteHeroSkillFastAttack();

    public StartAdventureService(HeroRepository repository) {
        this.repository = repository;
    }

    public void startAdventure(String heroName){
        var hero = repository.findById(heroName);
        var orc = new Orc();

        repository.findAll().forEach(System.out::println);
        var hp = orc.getHealth();
        System.out.println(hp);

        concreteHeroSkillFastAttack.execute(hero,orc);




        var print = repository.findById(heroName);
        var hpAfterBattle = orc.getHealth();
        System.out.println(hpAfterBattle);
        System.out.println(print);




    }
}
