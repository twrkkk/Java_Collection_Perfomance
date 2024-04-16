import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

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

        long arrayListAddTimeMillis = TimeUnit.NANOSECONDS.toMillis(arrayListAddTime);
        long linkedListAddTimeMillis = TimeUnit.NANOSECONDS.toMillis(linkedListAddTime);
        long arrayListGetTimeMillis = TimeUnit.NANOSECONDS.toMillis(arrayListGetTime);
        long linkedListGetTimeMillis = TimeUnit.NANOSECONDS.toMillis(linkedListGetTime);
        long arrayListDeleteTimeMillis = TimeUnit.NANOSECONDS.toMillis(arrayListDeleteTime);
        long linkedListDeleteTimeMillis = TimeUnit.NANOSECONDS.toMillis(linkedListDeleteTime);

        System.out.println("Operation\t| Operation Count\t| ArrayList\t| LinkedList");
        System.out.println("------------------------------------------------");
        System.out.println(String.format("Add\t\t\t| %14d\t| %11d ms\t| %10d ms", numOperationsAdd, arrayListAddTimeMillis, linkedListAddTimeMillis));
        System.out.println(String.format("Get\t\t\t| %14d\t| %11d ms\t| %10d ms", numOperationsGet, arrayListGetTimeMillis, linkedListGetTimeMillis));
        System.out.println(String.format("Delete\t\t| %14d\t| %11d ms\t| %10d ms", numOperationsAdd, arrayListDeleteTimeMillis, linkedListDeleteTimeMillis));
    }
}
