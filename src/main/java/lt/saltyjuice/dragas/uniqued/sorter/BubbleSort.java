package lt.saltyjuice.dragas.uniqued.sorter;

import lt.saltyjuice.dragas.uniqued.Student;

import java.util.List;

/**
 * Iterative bubblesort implementation with minor optimization to reduce its complexity
 * from n^2
 */
public class BubbleSort implements Sorter {
    public List<Student> sort(List<Student> comparable) {
        boolean swapped = false;
        do {
            swapped = false;
            for(int i = 0; i < comparable.size() - 1; i++) {
                Student first = comparable.get(i);
                Student second = comparable.get(i+1);
                if(first.compareTo(second) > 0) {
                    swapped = true;
                    comparable.set(i+1, first);
                    comparable.set(i, second);
                }
            }
        } while(swapped);
        return null;
    }
}
