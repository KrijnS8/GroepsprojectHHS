package nl.groep4b.Users;

public class User
{
    //Variables:
    private final String NAME;
    private final byte[] PASSWORDHASHED;

    //Constructors:
    public User(String NAME, byte[] PASSWORDHASHED)
    {
        this.NAME = NAME;
        this.PASSWORDHASHED = PASSWORDHASHED;
    }

    //Getters:
    public String getName()
    {
        return NAME;
    }

    //Setters:
    public byte[] getPasswordHashed()
    {
        return PASSWORDHASHED;
    }
}
