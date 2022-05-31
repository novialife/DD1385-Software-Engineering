
package x4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;


public class CompositeX4 extends ComponentX4 implements Iterable<ComponentX4>{

    private String name;
    private double weight;
    private ArrayList<ComponentX4> children = new ArrayList<ComponentX4>();
    
    public CompositeX4(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    CompositeX4(String name) {
        this.name = name;

    }

    @Override
    public String toString() {
        return name;

    }

    public void addChild(ComponentX4 child) {
        children.add(child);
    }

    public void removeChild(ComponentX4 child) {
        children.remove(child);
    }

    @Override
    public ArrayList<ComponentX4> getChildren(){
        return children;

    }

    @Override
    public boolean hasChildren(){
        return children.size() > 0;
    }   

    @Override
    public Iterator<ComponentX4> iterator(){
        LinkedList<ComponentX4> queue = new LinkedList<ComponentX4>();

        for (ComponentX4 child : children ){
            queue.add(child);
        }

        return new Iterator<ComponentX4>() {
            @Override
            public boolean hasNext() {
                return !queue.isEmpty();
            }

            @Override
            public ComponentX4 next() {
                ComponentX4 child = (ComponentX4) queue.pop();
                if (child.hasChildren()){
                    for (ComponentX4 child2 : child.getChildren()){
                        queue.add(child2);
                    }
                }
                return child;
            }
        };
        
    }

  public Iterator<ComponentX4> deepiIterator(){
        LinkedList<ComponentX4> DFSStack = new LinkedList<ComponentX4>();

        for (int i = children.size() - 1; i >= 0; i--) {
            DFSStack.addFirst(children.get(i));

        }
        return new Iterator<ComponentX4>() {
            @Override
            public boolean hasNext() {
                return !DFSStack.isEmpty();
            }

            @Override
            public ComponentX4 next() {
                ComponentX4 child = (ComponentX4) DFSStack.pop();
                if (child.hasChildren()){
                    for (ComponentX4 child2 : child.getChildren()){
                        DFSStack.addFirst(child2);
                    }
                }
                return child;
            }
        };
        }
        
    }







}
