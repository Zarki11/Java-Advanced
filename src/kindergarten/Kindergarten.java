package kindergarten;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Kindergarten {

    private String name;

    private int capacity;

    private List<Child> registry;

    public Kindergarten(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.registry = new ArrayList<>();
    }

    public boolean addChild(Child child) {
        if (capacity > this.registry.size()) {
            this.registry.add(child);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeChild(String firstName) {
        Child child = this.registry.stream()
                .filter(r -> r.getFirstName().equals(firstName))
                .findFirst()
                .orElse(null);
        return this.registry.remove(child);
    }

    public int getChildrenCount() {
        return registry.size();
    }

    public Child getChild(String firstName){
        Child child = this.registry.stream()
                .filter(r -> r.getFirstName().equals(firstName))
                .findFirst()
                .orElse(null);
        return child;
    }

    public String registryReport() {
        Collections.sort(registry, Comparator.comparing(Child::getAge)
                .thenComparing(Child::getFirstName)
                .thenComparing(Child::getLastName));

        StringBuilder report = new StringBuilder();
        report.append("Registered children in ").append(this.name).append(":").append(System.lineSeparator());

        for (Child child : this.registry) {
            report.append("--").append(System.lineSeparator());
            report.append(child).append(System.lineSeparator());
        }
        // return the report string
        return report.toString();
    }

}
