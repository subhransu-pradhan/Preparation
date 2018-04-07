package HowToCrackCodingInterview.chapter3StackAndQueue;

import java.util.stream.IntStream;

public class ThreeStackUsingSingleArray {

    int[] array = new int[600];

    int[] stackSize = new int[3];

    public void push(int data, int index){
        if(index > 3 || index < 1){
            throw new RuntimeException("Wrong Index.");
        }
        int indexToEntry = stackSize[index - 1] * 3 + index - 1;
        if(indexToEntry > 599){
            throw new RuntimeException("Stack is full for index : " + index);
        }
        array[indexToEntry] = data;
        stackSize[index - 1]++;
    }

    public int pop(int index){
        if(index > 3 || index < 1){
            throw new RuntimeException("Wrong Index.");
        }
        if(stackSize[index - 1] < 1){
            throw new RuntimeException("Stack is empty for index : " + index);
        }
        stackSize[index - 1]--;
        int indexToPop = stackSize[index - 1] * 3 + index - 1 ;
        return array[indexToPop];
    }

    public static void main(String[] args){
        ThreeStackUsingSingleArray stacks = new ThreeStackUsingSingleArray();
        stacks.push(100, 1);
        stacks.push(200, 1);
        stacks.push(300, 1);
        stacks.push(400, 1);

        System.out.println(stacks.pop(1));
        System.out.println(stacks.pop(1));
        System.out.println(stacks.pop(1));
        System.out.println(stacks.pop(1));
        //System.out.println(stacks.pop(1));


        stacks.push(101, 2);
        stacks.push(201, 2);
        stacks.push(301, 2);
        stacks.push(401, 2);

        System.out.println(stacks.pop(2));
        System.out.println(stacks.pop(2));
        System.out.println(stacks.pop(2));
        System.out.println(stacks.pop(2));
        //System.out.println(stacks.pop(2));

        stacks.push(102, 3);
        stacks.push(202, 3);
        stacks.push(302, 3);
        stacks.push(402, 3);

        System.out.println(stacks.pop(3));
        System.out.println(stacks.pop(3));
        System.out.println(stacks.pop(3));
        System.out.println(stacks.pop(3));
        //System.out.println(stacks.pop(3));

        IntStream.range(1, 202).forEach(data -> stacks.push(data, 1));
        System.out.println(stacks.stackSize[0]);
        System.out.println("Complete");
    }
}
