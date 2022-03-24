package com.game;

import com.game.config.AppConfig;
import com.game.config.DBConfig;
import com.game.ui.MainMenu;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class, DBConfig.class);
        var menu = context.getBean(MainMenu.class);
        menu.run();
    }

}
