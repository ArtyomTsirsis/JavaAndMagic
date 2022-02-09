package ui;

import hero.HeroClass;
import hero.HeroRepository;

import java.util.Scanner;

public class CreateHeroUIAction implements UIAction {

    private HeroRepository heroRepo;
    HeroClass heroClass;
    String heroName;


    public CreateHeroUIAction(HeroRepository repository) {
        this.heroRepo = repository;
    }

    public void execute() {

        System.out.println("\033[H\033[2J");
        System.out.flush();
        // запрашиваем данные о герое с консоли у пользолвателя (пока только имя и класс =))
        Scanner sc = new Scanner(System.in);
        System.out.print("Пожалуйста, введите имя героя: ");
        heroName = sc.nextLine();

        System.out.println("На выбор есть четыре вида класса, выберите тот - который вам больше подходит!");
        System.out.println("1) Лучник. (Меткий стрелок, использующий лук как главное оружие.)");
        System.out.println("2) Рыцарь. (Облачённый в блестящие латы, с двуручным мечом.)");
        System.out.println("3) Волшебник. (Мантия с капющоном скрвыает под собой его 'тёмные' как ночь глаза.)");
        System.out.println("4) Вор. (Гроза базарных площадей, берегите ваши кошельки! Вооружён 2-я кортиками.)");
        System.out.print("Какой ваш выбор?: ");


        int selector = Integer.parseInt(sc.nextLine());
        switch (selector) {
            case 1:
                heroClass = HeroClass.ARCHER;
                break;
            case 2:
                heroClass = HeroClass.KNIGHT;
                break;
            case 3:
                heroClass = HeroClass.WIZARD;
            case 4:
                heroClass = HeroClass.THIEF;
                break;
            default:
                System.out.println("Пожалуйста сделайте выбор от 1 до 4-х.");
                break;
        }

        // сохранение его в базу данных
        heroRepo.save(heroClass, heroName);

    }
}
