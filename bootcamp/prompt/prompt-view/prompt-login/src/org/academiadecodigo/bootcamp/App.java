package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.domain.User;
import org.academiadecodigo.bootcamp.store.UserStore;
import org.academiadecodigo.bootcamp.store.UserStoreImp;
import org.academiadecodigo.bootcamp.utils.Security;

public class App {

    public static void main(String[] args) {

        // Instantiate LoginPrompt
        LoginPrompt loginPrompt = new LoginPrompt();
        Prompt prompt = new Prompt(System.in, System.out);

        // Instantiate Users
        UserStore userStore = new UserStoreImp();

        User u1 = new User("Rui", Security.getHash("academiadecodigo"));
        User u2 = new User("Faustino", Security.getHash("academiadecodigo"));
        User u3 = new User("Audrey", Security.getHash("academiadecodigo"));

        userStore.add(u1);
        userStore.add(u2);
        userStore.add(u3);

        // Wiring
        loginPrompt.setPrompt(prompt);
        loginPrompt.setUserStore(userStore);

        // Start APP
        loginPrompt.show();

    }
}
