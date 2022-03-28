package nl.groep4b.beans;

public class DocentBean
{
    private String name;
    private String passwordHashed;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getPasswordHashed()
    {
        return passwordHashed;
    }

    public void setPasswordHashed(String passwordHashed)
    {
        this.passwordHashed = passwordHashed;
    }
}
