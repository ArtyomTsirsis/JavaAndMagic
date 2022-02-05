package GameDemo;

public interface HeroRepository {

    Long save(Hero hero);

    String index();

    void deleteById(Long heroId);


}
