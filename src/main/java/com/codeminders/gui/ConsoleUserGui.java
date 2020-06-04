package com.codeminders.gui;

import com.codeminders.businesLogic.RowCounter;

import java.util.Scanner;

public class ConsoleUserGui  extends AbstractGui implements UserGui {

    public ConsoleUserGui(RowCounter rowCounter, PathValidator pathValidator) {
        super(rowCounter, pathValidator);
    }

    public void startGui() {
        while (true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please type path to file/folder or 'X' to exit:");
            String path = scanner.nextLine();
            if(path.equalsIgnoreCase("x")){
                break;
            }
            try {
                action(path);
            }catch (IllegalArgumentException ex){
                System.out.println(ex.getMessage());
                continue;
            }
        }
    }



}
