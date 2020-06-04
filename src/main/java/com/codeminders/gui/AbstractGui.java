package com.codeminders.gui;

import com.codeminders.businesLogic.RowCounter;

public abstract class AbstractGui{
    private RowCounter rowCounter;
    private PathValidator pathValidator;

    public AbstractGui(RowCounter rowCounter, PathValidator pathValidator) {
        this.rowCounter = rowCounter;
        this.pathValidator = pathValidator;
    }

    void action(String path) throws IllegalArgumentException {
        this.pathValidator.validate(path);
        this.rowCounter.countRows(path);
    }
}
