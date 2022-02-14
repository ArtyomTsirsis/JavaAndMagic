package repository.enemy;

import lombok.Data;

@Data
public class Orc implements Enemy {

    private final static EnemyClass ENEMY_CLASS = EnemyClass.ORC;
    private Integer health = 500;
    private Integer dexterity = 10;
    private Integer physicalDamage = 150;
    private Integer magicalDamage = 0;
    private Integer physicalDefense = 40;
    private Integer magicalDefense = 0;

    public EnemyClass getEnemyClass() {
        return ENEMY_CLASS;
    }

    @Override
    public void setHealth(Integer health) {
        this.health = health;
    }

}
