package nl.groep4b;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class LoginText
{
    ArrayList<User> users = new ArrayList<>(Arrays.asList(
            new User("user1", PasswordHasher.hashToByteArray("wachtwoord1")),
            new User("user2", PasswordHasher.hashToByteArray("wachtwoord2")),
            new User("user3", PasswordHasher.hashToByteArray("wachtwoord3"))
    ));

    @Test
    public void loginTest(){
        //assert everyting is correct
        String[] answers1 = new String[] {"user2","wachtwoord2"};
        assertTrue(Main.login(1, users, new TestScanner(answers1)));

        //assert wrong password
        String[] answers2 = new String[] {"user1","wachtwoord3", "\n"};
        assertFalse(Main.login(1, users, new TestScanner(answers2)));

        //assert wrong user type
        String[] answers3 = new String[] {"user1","wachtwoord3", "\n"};
        assertFalse(Main.login(2, users, new TestScanner(answers3)));
    }
}
