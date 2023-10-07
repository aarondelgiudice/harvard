class Manager extends Employee
{
    int bonus = 500;
    
    public double getSalary()
    {
        double base = super.getSalary();
        return base + bonus;
    }
}