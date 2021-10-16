package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.scanners.string.PasswordInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;
import org.academiadecodigo.bootcamp.store.UserStore;
import org.academiadecodigo.bootcamp.utils.Messages;

public class LoginPrompt {

    private Prompt prompt;
    private UserStore userStore;

    public void setPrompt(Prompt prompt) {
        this.prompt = prompt;
    }

    public void setUserStore(UserStore userStore) {
        this.userStore = userStore;
    }

    public void show() {
        showWelcomeMessage();
        showLoginPrompt();
    }

    private void showWelcomeMessage() {
        System.out.println("\n" + Messages.STARTUP_MSG);
    }

    private void showLoginPrompt() {

        System.out.println("\n" + Messages.LOGIN_MSG);

        scanCredentials();

    }

    private void scanCredentials() {

        StringInputScanner userScanner = new StringInputScanner();
        PasswordInputScanner passwordScanner = new PasswordInputScanner();

        userScanner.setMessage("Username: ");
        String username = prompt.getUserInput(userScanner);

        passwordScanner.setMessage("Password: ");
        String password = prompt.getUserInput(passwordScanner);

        if (!onLogin(username, password)) {
            System.out.println(Messages.LOGIN_ERROR);
            return;
        }

        System.out.println("\n" + Messages.LOGIN_SUCCESS + "\n" + Messages.WELCOME_MSG + username + "!");

    }

    private boolean onLogin(String username, String password) {
        return userStore.authenticate(username, password);
    }


}
