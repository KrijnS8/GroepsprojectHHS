package nl.groep4b;



public class BeheerderBean
{
    //Variables:
    private String name;
    private byte[] passwordHashed;

    //Getters:
    public String getName()
    {
        return name;
    }
    public byte[] getPasswordHashed()
    {
        return passwordHashed;
    }

    //Setters:
    public void setName(String name)
    {
        this.name = name;
    }
    public void setPasswordHashed(byte[] passwordHashed)
    {
        this.passwordHashed = passwordHashed;
    }
}