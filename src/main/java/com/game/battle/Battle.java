package com.game.battle;

import com.game.repository.stuff.enemy.Enemy;
import com.game.repository.hero.Hero;
import com.game.skills.enemy.EnemySkill;
import com.game.skills.enemy.EnemySkillContext;
import com.game.skills.hero.HeroSkill;
import com.game.skills.hero.HeroSkillContext;

import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

class Battle {

    private Hero hero;
    private Enemy enemy;
    private Random random = new Random();
    private Scanner scanner = new Scanner(System.in);
    private HeroSkillContext heroSkillActivator = new HeroSkillContext();
    private EnemySkillContext enemySkillActivator = new EnemySkillContext();

    // Пока будем на одном потоке, потом переделаем конечно.
    public Battle(Hero hero, Enemy enemy) {
        this.hero = hero;
        this.enemy = enemy;
    }

    public Hero fightSimulator() {
        while (enemy.getHealth() >= 0 && hero.getHealth() >= 0) {
            heroSkillsMenu(hero);
            int choseSkill = scanner.nextInt();
            HeroSkill chosenHeroSkill = skillBookOperator(hero, choseSkill);
            System.out.println("[ Attack ]");
            System.out.println("Press - [1] for ATTACK enemy [ HEAD ]");
            System.out.println("Press - [2] for ATTACK enemy [ CHEST ]");
            System.out.println("Press - [3] for ATTACK enemy [ HANDS ]");
            System.out.println("Press - [4] for ATTACK enemy [ LEGS ]");
            int attackVariant = scanner.nextInt();
            System.out.println("[ Defence ]");
            System.out.println("Press - [1] for DEFENCE hero [ HEAD ]");
            System.out.println("Press - [2] for DEFENCE hero [ CHEST ]");
            System.out.println("Press - [3] for DEFENCE hero [ HANDS ]");
            System.out.println("Press - [4] for DEFENCE hero [ LEGS ]");
            int defenceVariant = scanner.nextInt();
            EnemySkill enemySkill = enemySkillRandomGenerator(enemy);
            fightLogic(chosenHeroSkill, enemySkill, attackVariant, defenceVariant);
        }
        return this.hero;
    }

    private int enemyAttackRoll() {
        return random.nextInt(4) + 1;
    }

    private int enemyDefenceRoll() {
        return random.nextInt(4) + 1;
    }

    private boolean heroBlockAttack(int playerDefenceChose) {
        return playerDefenceChose == enemyAttackRoll();
    }

    private boolean enemyBlockAttack(int playerAttackChose) {
        return playerAttackChose == enemyDefenceRoll();
    }

    private void fightLogic(HeroSkill heroSkill, EnemySkill enemySkill, int attack, int defence) {
        if (!enemyBlockAttack(attack)) {
            System.out.println(heroAttackEnemy(heroSkill));
        } else {
            System.out.println("Enemy block your attack!");
        }
        if (!heroBlockAttack(defence)) {
            System.out.println(enemyAttackHero(enemySkill));
        } else {
            System.out.println("You block an enemy attack!");
        }
        if (enemy.getHealth() <= 0) {
            System.out.println("[ The enemy has been killed! ]");
        }
        if (hero.getHealth() <= 0) {

            System.out.println("[ Hero was fallen! ]");
        }
    }

    private HeroSkill skillBookOperator(Hero hero, int skillIndex) {
        for (int i = 0; i < hero.getSkills().size(); i++) {
            if (i == skillIndex) {
                return hero.getSkills().get(i);
            }
        }
        return hero.getSkills().get(0);
    }

    private void heroSkillsMenu(Hero hero) {
        System.out.println("[ Skill Menu ] u have a [ " + hero.getSkills().size() + " ] skills at book.");
        IntStream.range(0, hero.getSkills().size()).mapToObj(i -> "Pres [ " + i + " ] to use " +
                hero.getSkills().get(i).getName() + ".").forEach(System.out::println);
    }

    private String heroAttackEnemy(HeroSkill heroSkill) {
        return heroSkill.execute(hero, enemy);
    }

    private String enemyAttackHero(EnemySkill enemySkill) {
        return enemySkill.execute(hero, enemy);
    }

    private EnemySkill enemySkillRandomGenerator(Enemy enemy) {
        int randomSkill = random.nextInt(hero.getSkills().size());
        for (int i = 0; i < enemy.getSkills().size(); i++) {
            if (i == randomSkill) {
                return enemy.getSkills().get(i);
            }
        }
        return null;
    }

}
