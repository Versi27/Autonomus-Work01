package PaqI04;

public class Container {
    //ATTRIBUTES:
    int id, weight, priority;
    String country, description, emisor, receptor;
    boolean inspected;


    //CONSTRUCTORS:
    public Container() {

    }
    public Container(int id, int weight, String country, int priority, String description, String emisor, String receptor, boolean inspected){
        this();
        if (id < 0) id = -id;
        else this.id = id;
        this.setWeight(weight);
        this.setCountry(country);
        this.setPriority(priority);
        this.setDescription(description);
        this.setEmisor(emisor);
        this.setReceptor(receptor);
        this.inspected = inspected;
    }


    //GETTERS & SETTERS:
    public int getId() {
        return id;
    }
    public void setId(int id) {
        if (id < 0) id = -id;
        else this.id = id;
    }

    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        if(country != null) this.country = country;
    }

    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        if (weight < 0) this.weight = -weight;
        else this.weight = weight;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        if (description != null) this.description = description;
    }

    public int getPriority() {
        return priority;
    }
    public void setPriority(int priority) {
        if (priority >= 1 && priority <= 3) {
            this.priority = priority;
        }
    }

    public String getEmisor() {
        return emisor;
    }
    public void setEmisor(String emisor) {
        if (emisor != null) this.emisor = emisor;
    }

    public String getReceptor() {
        return receptor;
    }
    public void setReceptor(String receptor) {
        if (receptor != null) this.receptor = receptor;
    }

    public boolean isInspected() {
        return inspected;
    }


    //TO STRING:
    public String toString(){
        String s = new String();
        s += "---------------------CONTAINER INFORMATION----------------------\n";
        s += "Id: "+this.id+ "\n";
        s += "Weight: "+this.weight+" kg \n";
        s += "Country of origin: "+this.country+"\n";
        if(priority == 1) s+= "Priority: 1 \n";
        else if (priority == 2) s += "Priority: 2 \n";
        else if (priority == 3) s += "Priority: 3 \n";
        else s += "Error in the priority \n";
        s += "Description: "+this.description+"\n";
        s += "Company that sends the container: "+this.emisor+"\n";
        s += "Company that receives the container: "+this.receptor+"\n";
        s += "Is inspected?: ";
        if(inspected) s += "Inspected";
        else s += "Not inspected" + "\n";
        return s;
    }

}
