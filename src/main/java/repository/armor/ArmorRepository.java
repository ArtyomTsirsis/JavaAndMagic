package repository.armor;

import java.util.HashMap;
import java.util.Map;

public class ArmorRepository {

    private final static Map<ArmorClass, Armor> armorRepo = new HashMap<>();

    //    Create Heroes in Factory and put them to Map.
    public Armor save(ArmorClass armorClass) {
        Armor toReturn = ArmorFactory.createArmor(armorClass);
        armorRepo.put(armorClass, toReturn);
        return toReturn;
    }

    //    Find hero by id
    public Armor findById(ArmorClass armorClass) {
        return armorRepo.get(armorClass);
    }

    //    Find all heroes
    public Iterable<Armor> findAll() {
        return armorRepo.values();
    }

    //    Delete Hero by id
    public void deleteById(ArmorClass armorClass) {
        armorRepo.remove(armorClass);
    }

}
