public class Person {
    private String name;
    public static String species = "human";
    public Person(String name) {
        this.name = name;
    }
    public static void printSpecies(){
        System.out.println(species);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
