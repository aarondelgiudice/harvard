class Movie
{
    // first we define the INSTANCE VARIABLES
	private int acting;
	private int directing;
	private int script;

    // second, we define the following CONSTRUCTOR for Movie objects
    public Movie (int a, int d, int s)
    {
        acting = a;
        directing = d;
        script = s;
    }

    //third, we define INSTANCE METHODS
	public int rating ()
	{
       return (acting + directing + script);
	}

}

