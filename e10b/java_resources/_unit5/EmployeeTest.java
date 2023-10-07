class EmployeeTest
{
   public static void main (String [] args)
   {
       Employee joe = new Employee();
       Manager mary = new Manager();
       
       System.out.println ("Joe's yearly salary = " + joe.getSalary() );
       System.out.println ("Mary's yearly salary = " + mary.getSalary() );
   }
}