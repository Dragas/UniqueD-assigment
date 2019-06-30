package lt.saltyjuice.dragas.uniqued.sorter;

import lt.saltyjuice.dragas.uniqued.Student;

import java.util.List;

public class HeapSort implements Sorter {
    @Override
    public List<Student> sort(List<Student> comparable) {
        buildMaxHeap(comparable);
        int end = comparable.size() - 1;
        while(end > 0) {
            swap(comparable, end, 0);
            end -= 1;
            siftDown(comparable, 0, end);
        }
        return comparable;
    }

    private int getLeftChildIndex(int idx) {
        return idx * 2  + 1;
    }

    private int getRightChildIndex(int idx) {
        return idx * 2 + 2;
    }

    private int getParentIndex(int idx) {
        return (idx - 1) / 2;
    }

    private void buildMaxHeap(List<Student> comparable) {
        int count = comparable.size();
        int start = getParentIndex(count - 1);
        while(start >= 0) {
            siftDown(comparable, start, count - 1);
            start -= 1;
        }
    }

    private void siftDown(List<Student> comparable, int from, int to) {
        int root = from;

        while(getLeftChildIndex(root) <= to) {
            int child = getLeftChildIndex(root);
            int swapable = root;
            Student swapStudent = comparable.get(swapable);
            Student childStudent = comparable.get(child);
            if(swapStudent.compareTo(childStudent) < 0) {
                swapable = child;
                swapStudent = childStudent; // an optimization so that you wouldnt need to fetch the same element twice
            }
            if(child + 1 <= to && swapStudent.compareTo(comparable.get(child+1)) < 0)
                swapable = child+1;
            if(swapable == root)
                return;
            else {
                swap(comparable, root, swapable);
                root = swapable;
            }
        }
    }

    private void swap(List<Student> comparable, int firstIndex, int secondIndex) {
        Student first = comparable.get(firstIndex);
        Student second = comparable.get(secondIndex);
        comparable.set(firstIndex, second);
        comparable.set(secondIndex, first);
    }
}
