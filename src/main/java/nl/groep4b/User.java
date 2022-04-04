package nl.groep4b;

public class User
{
    private String name;
    private byte[] passwordHashed;

    public User(String name, byte[] passwordHashed)
    {
        this.name = name;
        this.passwordHashed = passwordHashed;
    }

    public String getName()
    {
        return name;
    }

    public byte[] getPasswordHashed()
    {
        return passwordHashed;
    }
}
