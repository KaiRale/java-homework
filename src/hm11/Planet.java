package hm11;

public enum Planet {
    EARTH("Earth", 1234, 5.98),
    MARS("Mars", 3397, 6.44),
    JUPITER("Jupiter", 69911, 1.9),
    SATURN("Saturn", 58000, 5.68);

    private String name;
    private int radius;
    private double weight;

    Planet(String name, int radius, double weight) {
        this.name = name;
        this.radius = radius;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        if (radius < 1) {
            throw new IllegalArgumentException("Invalid data. Radius should be bigger then 0.");
        }
        this.radius = radius;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if (weight < 1) {
            throw new IllegalArgumentException("Invalid data. Weight should be bigger then 0.");
        }
        this.weight = weight;
    }
}
