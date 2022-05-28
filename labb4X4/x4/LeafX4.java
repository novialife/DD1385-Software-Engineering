
package x4;

import java.util.ArrayList;

public class LeafX4 extends ComponentX4 {

    private String name;
    private double weight;
    
    public LeafX4(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    LeafX4(String name) {
        this.name = name;

    }

    @Override
    public String toString() {
        return name;

    }

    @Override
    public boolean hasChildren() {
        return false;
    }

    @Override
    public ArrayList<ComponentX4> getChildren() {
        return null;
    }

}
