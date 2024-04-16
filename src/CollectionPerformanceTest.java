import java.util.ArrayList;
import java.util.LinkedList;

public class CollectionPerformanceTest {

    public static void main(String[] args) {
        int numOperationsAdd = 1000000;
        int numOperationsGet = 10000;

        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        long startTime = System.nanoTime();
        for (int i = 0; i < numOperationsAdd; i++) {
            arrayList.add(i);
        }
        long arrayListAddTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        for (int i = 0; i < numOperationsAdd; i++) {
            linkedList.add(i);
        }
        long linkedListAddTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        for (int i = 0; i < numOperationsGet; i++) {
            int a = arrayList.get(i);
        }
        long arrayListGetTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        for (int i = 0; i < numOperationsGet; i++) {
            int a = linkedList.get(i);
        }
        long linkedListGetTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        for (int i = numOperationsAdd - 1; i >= 0; i--) {
            arrayList.remove(i);
        }
        long arrayListDeleteTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        for (int i = numOperationsAdd - 1; i >= 0; i--) {
            linkedList.remove(i);
        }
        long linkedListDeleteTime = System.nanoTime() - startTime;
    }
}
