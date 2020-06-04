package com.codeminders.gui;

import java.io.File;

public class SimplePathValidator implements PathValidator {

    public void validate(String path) throws IllegalArgumentException{
        File tmpDir = new File(path);
        if(tmpDir.isFile() || tmpDir.isDirectory()){
            return;
        }
        throw new IllegalArgumentException("error no such file or directory: "+path);
    }
}
