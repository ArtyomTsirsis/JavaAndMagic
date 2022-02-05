package GameDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
class DataBaseHeroRepository implements HeroRepository {

    private long counter = 1;
    private List<Hero> memory;

    public DataBaseHeroRepository() {
        this.memory = new ArrayList<>();

    }

    @Override
    public Long save(Hero hero) {
        memory.add(hero);
        hero.setId(counter);
        counter++;
        return counter;
    }

    @Override
    public String index() {
        return memory.toString();
    }

    @Override
    public void deleteById(Long heroId) {
        for (int i = 0; i < memory.size(); i++) {
            if (memory.get(i).getId().equals(heroId)) {
                memory.remove(memory.get(i));
                i -= 1;
            }
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataBaseHeroRepository that = (DataBaseHeroRepository) o;
        return counter == that.counter && Objects.equals(memory, that.memory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(counter, memory);
    }

    @Override
    public String

    toString() {
        return "GameDemo.DataBaseHeroRepository{" +
                "counter=" + counter +
                ", memory=" + memory +
                '}';
    }
}