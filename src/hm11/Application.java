package hm11;

public class Application {
    public static void main(String[] args) {
        Planet[] planets = Planet.values();
        Planet.EARTH.setRadius(6371);

        for (Planet planet : planets) {
            System.out.println(
                    planet.name() + "\n" +
                    "name: " + planet.getName() + "\n" +
                    "weight: " + planet.getWeight() + "\n" +
                    "radius: " + planet.getRadius() + "\n"
            );
        }
    }
}
