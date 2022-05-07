package splayTree;


import java.util.Random;

public class Main {
    private static final long SEED = 2022;
    public static void main(String [] args) {
        SplayTree tree = new SplayTree();
        Random random = new Random(SEED);
        for (int i = 0; i < 1000000; i++) {
            tree.insert(random.nextInt(100));
        }
        Long start = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            tree.deleteNode(random.nextInt(100));
        }
        Long finish = System.nanoTime();
        long elapsed = finish - start;
        System.out.println(elapsed/1000);
//        tree.prettyPrint();

    }
}

