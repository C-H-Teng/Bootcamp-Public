import java.text.NumberFormat;

public class Project{
    private String projName;
    private String projDesc;
    private double initialCost;

    public Project(){
        this("Kitten", 10.50, "This is a description about project Kitten.");
    }

    public Project(String projName, double projCost){
        this.projName = projName;
        this.projDesc = "";
        this.initialCost = projCost;
    }

    public Project(String projName, double projCost, String projDesc){
        this.projName = projName;
        this.projDesc = projDesc;
        this.initialCost = projCost;
    }


    // methods
    public String elevatorPitch(){
        return this.projName + " ($" + this.initialCost + "): " + this.projDesc;
    }

    public String getProjName(){
        return this.projName;
    }

    public void setProjName(String projName){
        this.projName = projName;
    }

    public String getProjDesc(){
        return this.projDesc;
    }

    public void setProjDesc(String projDesc){
        this.projDesc = projDesc;
    }

    public double getProjCost(){
        return this.initialCost;
    }

    public void setProjCost(double projCost){
        this.initialCost = projCost;
    }
} // class end