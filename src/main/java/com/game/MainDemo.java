package com.game;

import com.game.config.AppConfig;
import com.game.config.DBConfig;
import com.game.reposervices.hero.CreateHeroService;
import com.game.reposervices.hero.FindHeroByNameService;
import com.game.repository.armor.Armor;
import com.game.repository.armor.ArmorRepository;
import com.game.repository.armor.templates.MagicalShield;
import com.game.repository.hero.Hero;
import com.game.repository.hero.HeroRepository;
import com.game.repository.weapon.Weapon;
import com.game.repository.weapon.WeaponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

public class MainDemo {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class, DBConfig.class);
        var demo = context.getBean(Demo.class);
        demo.run();
    }

}

@Component
class Demo {

    @Autowired
    private HeroRepository heroRepository;
    @Autowired
    private CreateHeroService createHeroService;
    @Autowired
    private FindHeroByNameService findHeroByNameService;
    @Autowired
    private WeaponRepository weaponRepository;
    @Autowired
    private ArmorRepository armorRepository;

    public void run() {
//        createAndSaveHero(new Knight("Archie"));
        createAndSaveArmor(new MagicalShield());
//        createAndSaveWeapon(new Bow());
    }

    private void createAndSaveHero(Hero hero) {
//        System.out.println(createHeroService.createHero(new CreateHeroRequest(hero.getHeroClass(), hero.getName())));
//        new Scanner(System.in).nextLine();
//        Hero hero2 = heroRepository.findById(hero.getName()).get();
//        System.out.println(hero2.toString());
//        try {
//            System.out.println(findHeroByNameService.findByName(hero.getName()));
//        }
//        catch (Exception e) {
//            System.out.println("findHeroByNameService throws exception");
//        }
        List<Hero> heroes = heroRepository.findAll();
        heroes.forEach(System.out::println);
        heroRepository.deleteById("");
    }

    private void createAndSaveArmor(Armor armor) {
//        armorRepository.save(armor);
//        List<Armor> armorList = armorRepository.findAll();
//        armorList.forEach(System.out::println);
        System.out.println(armorRepository.findById(-1));
    }

    private void createAndSaveWeapon(Weapon weapon) {
        List<Weapon> weaponList = weaponRepository.findAll();
        weaponList.forEach(System.out::println);
        System.out.println(weaponRepository.findById(-1));
    }

}
