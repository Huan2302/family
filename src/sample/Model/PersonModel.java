package sample.Model;

public class PersonModel {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String nameFather;
    private String name;
    private String birth;
    private int status;
    private int numberChild;
    private int generation;

    public int getGeneration() {
        return generation;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }

    public String getNameFather() {
        return nameFather;
    }

    public void setNameFather(String nameFather) {
        this.nameFather = nameFather;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getNumberChild() {
        return numberChild;
    }

    public void setNumberChild(int numberChild) {
        this.numberChild = numberChild;
    }

    @Override
    public String toString() {
        return "PersonModel{" +
                "id=" + id +
                ", nameFather='" + nameFather + '\'' +
                ", name='" + name + '\'' +
                ", birth='" + birth + '\'' +
                ", status=" + status +
                ", numberChild=" + numberChild +
                '}';
    }
}
