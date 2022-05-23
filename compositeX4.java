
package x4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import x4.ComponentX4;


public class CompositeX4 extends ComponentX4 implements Iterable{

    private String name;
    private double weight;
    private ArrayList<ComponentX4> children = new ArrayList<ComponentX4>();
    private String content;


    CompositeX4(String name, double weight, String content) {
        this.name = name;
        this.weight = weight;
        this.content = content;
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
    public Iterator iterator(){
        LinkedList queue = new LinkedList();

        for (ComponentX4 child : children ){
            queue.add(child);
        }

        return new Iterator() {
            @Override
            public boolean hasNext() {
                return !queue.isEmpty();
            }

            @Override
            public Object next() {
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

    public Iterator deepiIterator(){
        LinkedList queue = new LinkedList();

        for (ComponentX4 child : children ){
            queue.add(child);
        }

        return new Iterator() {
            @Override
            public boolean hasNext() {
                return !queue.isEmpty();
            }

            @Override
            public Object next() {
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






}
