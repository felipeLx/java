package org.lxgames.com.ExceptionPlay;

import java.awt.Container;
import exceptions.FileException;
import exceptions.NotEnoughPermissionsException;

public class FileManager extends File {


    private File[] file;
    private String name;
    private Container type;

    type.

    public FileManager() {
        File[] file = new File[3];
        this.file = file;
    }

    public void LogIn() throws NotEnoughPermissionsException {

        String logIn = file.getName();
        if (logIn != null) {
            try {
                getFile(name);
            } catch (Exception e) {
                FleException(e);
            }
        } else {
            LogOut();
        }
    }


    public void LogOut() {

        String logOut = file.getName();
        if (logOut == null) {
            System.out.println("you will be logout of the System\n") ;
        } else {
            file.getName();
        }
    }


    public String getFile(String fileName) throws Exception {

        return createFile();
    }

    public String createFile() throws Exception {

        if (getFile(name) == null) {
            LogIn();
        } else {
            LogOut();
        }
        return name;
    }
}


