package com.codeminders;

import com.codeminders.businesLogic.SimpleRowCounter;
import com.codeminders.gui.ConsoleUserGui;
import com.codeminders.gui.SimplePathValidator;
import com.codeminders.gui.UserGui;

public class App {
    public static void main(String[] args) {
        UserGui gui = new ConsoleUserGui(new SimpleRowCounter(),new SimplePathValidator());
        gui.startGui();
    }
}
