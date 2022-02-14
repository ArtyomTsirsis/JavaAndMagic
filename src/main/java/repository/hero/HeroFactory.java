package repository.hero;

public class HeroFactory {

    public static Hero createHero(HeroClass heroClass, String name) {
        Hero toReturn;
        switch (heroClass) {
            case ARCHER:
                toReturn = new Archer(name);
                break;
            case KNIGHT:
                toReturn = new Knight(name);
                break;
            case THIEF:
                toReturn = new Thief(name);
                break;
            case WIZARD:
                toReturn = new Wizard(name);
                break;
            default:
                toReturn = null;
        }
        return toReturn;
    }

}
