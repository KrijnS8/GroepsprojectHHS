package nl.groep4b.beans;

public class DocentBean
{
    //Variables:
    private String name;
    private String passwordHashed;

    //Getters:
    public String getName()
    {
        return name;
    }
    public String getPasswordHashed()
    {
        return passwordHashed;
    }

    //Setters:
    public void setName(String name)
    {
        this.name = name;
    }
    public void setPasswordHashed(String passwordHashed)
    {
        this.passwordHashed = passwordHashed;
    }
}
