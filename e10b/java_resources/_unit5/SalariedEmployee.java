public class SalariedEmployee
{
    protected double salary;
    protected String name;

    public SalariedEmployee (String n)
    {
        name = n;  
        salary = 50000;
    }

    public double getSalary()
    {
        return salary;
    }
}
