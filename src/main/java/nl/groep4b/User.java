package nl.groep4b;

public class User
{
    //Variables:
    private String name;
    private byte[] passwordHashed;

    //Constructors:
    public User(String name, byte[] passwordHashed)
    {
        this.name = name;
        this.passwordHashed = passwordHashed;
    }

    //Getters:
    public String getName()
    {
        return name;
    }

    //Setters:
    public byte[] getPasswordHashed()
    {
        return passwordHashed;
    }
}
