package domain.enums;

public enum ValueClass {

    LOW("baixa"),
    MEDIUM("media"),
    HIGH("alta");

    private String classifcation;


    ValueClass(String classifcation) {
        this.classifcation = classifcation;
    }

    @Override
    public String toString() {
        return classifcation;
    }
}
