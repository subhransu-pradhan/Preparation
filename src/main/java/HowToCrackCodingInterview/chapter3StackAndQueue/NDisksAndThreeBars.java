package HowToCrackCodingInterview.chapter3StackAndQueue;


import java.util.Arrays;
import java.util.stream.IntStream;

class Disk{
    int size;

    public Disk(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return size + ",\t";
    }
}

class Stack{

    Stack next;
    Disk disk;

    public Stack(Stack next, Disk disk) {
        this.next = next;
        this.disk = disk;
    }

    public Stack push(Disk disk){
        return new Stack(this, disk);
    }

    public Disk pop(){
        this.next = null;
        return this.disk;
    }

    @Override
    public String toString() {
        return disk + (next!= null?next.toString():"");
    }
}

class Bar{
    Stack head;

    public void addDisk(Disk disk){
        if(head == null){
            head = new Stack(null, disk);
        }
        else {
            head = head.push(disk);
        }
    }

    public Disk removeDisk(){
        Stack current = head;
        if(head == null){
            return null;
        }
        head = head.next;
        return current.pop();
    }

    @Override
    public String toString() {
        return "Bar\t[" + head + "\b\b]\n";
    }
}

public class NDisksAndThreeBars {

    Bar[] bars;

    public NDisksAndThreeBars(){
        bars = new Bar[3];
        bars[0] = new Bar();
        bars[1] = new Bar();
        bars[2] = new Bar();
        IntStream.range(1, 51).forEach(size -> bars[0].addDisk(new Disk(size)));
    }

    @Override
    public String toString() {
        return "NDisksAndThreeBars{" +
                "bars=" + Arrays.toString(bars) +
                '}';
    }

    public static void main(String[] data) {

        NDisksAndThreeBars allBars = new NDisksAndThreeBars();
        while(allBars.bars[0].head != null){
            allBars.bars[1].addDisk(allBars.bars[0].removeDisk());
            System.out.println(allBars);
        }
        while(allBars.bars[1].head != null){
            allBars.bars[2].addDisk(allBars.bars[1].removeDisk());
            System.out.println(allBars);
        }

    }

}
