public class ProjectTest{
    public static void main(String[] args){
        Project fuzzy = new Project();
        Project bark = new Project("Dog", 15.25);
        Project chirp = new Project("Bird", 25.83, "Description for project about birds.");

        // setters
        fuzzy.setProjName("Cat");
        fuzzy.setProjCost(51.77);
        fuzzy.setProjDesc("Project about cats.");
        bark.setProjDesc("Project about dogs.");

        // getters
        System.out.println("Get name: " + bark.getProjName());
        System.out.println("Get initial cost: $" + fuzzy.getProjCost());
        System.out.println("Get description: " + chirp.getProjName());

        // elevator pitches
        System.out.println("Elevator pitches:");
        System.out.println(fuzzy.elevatorPitch());
        System.out.println(bark.elevatorPitch());
        System.out.println(chirp.elevatorPitch());
    }
}