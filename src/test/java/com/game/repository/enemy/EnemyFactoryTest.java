package com.game.repository.enemy;

import com.game.domain.enemy.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EnemyFactoryTest {

    /*
     * scenario1
     * input: EnemyClass.ORC
     * expected output: new Orc()
     */
    @Test
    void scenario1() {
        Enemy actual = EnemyFactory.createEnemy(EnemyClass.ORC);
        Enemy expected = new Orc();
        assertEquals(expected, actual);
    }

    /*
     * scenario2
     * input: EnemyClass.SKELETON
     * expected output: new Skeleton()
     */
    @Test
    void scenario2() {
        Enemy actual = EnemyFactory.createEnemy(EnemyClass.SKELETON);
        Enemy expected = new Skeleton();
        assertEquals(expected, actual);
    }

}