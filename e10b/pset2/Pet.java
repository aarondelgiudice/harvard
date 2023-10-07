public abstract class Pet {
    private String name;
    private int year;

    public Pet(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    // Abstract method that should be implemented by subclasses
    public abstract String speak();
}