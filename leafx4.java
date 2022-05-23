
package x4;

import java.util.ArrayList;

public class LeafX4 extends ComponentX4 {

    private String name;
    private double weight;
    private String content;

    LeafX4(String name, double weight, String content) {
        this.name = name;
        this.weight = weight;
        this.content = content;
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
