package com.game.ui;

import java.util.Scanner;

public class MoveForwardUIAction implements UIAction{

    public MoveForwardUIAction() {

    }

    @Override
    public void execute() {
        System.out.println("\033[H\033[2J");
        System.out.flush();

        System.out.println("**************************************");
        System.out.println();
        System.out.print("        _\n" +
                "       / \\      _-'\n" +
                "     _/|  \\-''- _ /\n" +
                "__-' { |          \\\n" +
                "    /             \\\n" +
                "    /       \"o.  |o }\n" +
                "    |            \\ ;\n" +
                "                  ',\n" +
                "       \\_         __\\\n" +
                "         ''-_    \\.//\n" +
                "           / '-____'\n" +
                "          /\n" +
                "        _'\n" +
                "      _-'\n");

        System.out.println("                 \n" +
                "                |\\             \n" +
                "    ___________/  \\____________________________\n" +
                "   /  Not so fast hero! Njam...njam...          \\\n" +
                "  |  First of all answer on my three questions! |\n" +
                "  |    If u are wrong, I'm eat you!             |\n" +
                "   \\___________________________________________/\n" +
                "  ");
        System.out.println();

        Scanner sc = new Scanner(System.in);
        System.out.println("**************************************");
        System.out.println("OMG...what we gonna do?");
        System.out.println();
        System.out.println("1) Try to answer the question.");
        System.out.println("2) Start fight with the werewolf!");
        System.out.println();
        System.out.print("What your choice?: ");


        int selector = Integer.parseInt(sc.nextLine());
        switch (selector) {
            case 1 -> System.out.println("Not implemented yet");
            case 2 -> System.out.println("Not implemented yet");

            default -> System.out.println("Please make a choice between 1 and 2.");
        }

    }





}
