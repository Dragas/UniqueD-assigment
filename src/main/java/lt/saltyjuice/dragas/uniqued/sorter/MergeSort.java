package lt.saltyjuice.dragas.uniqued.sorter;

import lt.saltyjuice.dragas.uniqued.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Recursive implementation for merge sort algorithm with minor optimization
 * in cases where either "left" or "right" is "empty".
 */
public class MergeSort implements Sorter {
    @Override
    public List<Student> sort(List<Student> comparables) {
        if(comparables.size() == 1)
            return comparables;
        int midpoint = comparables.size() / 2;
        List<Student> left = comparables.subList(0, midpoint);
        List<Student> right = comparables.subList(midpoint, comparables.size());
        left = sort(left);
        right = sort(right);
        return merge(left, right);
    }

    private List<Student> merge(List<Student> left, List<Student> right) {
        List<Student> returnable = new ArrayList<>();
        int targetSize = left.size() + right.size();
        int leftIndex = 0;
        int rightIndex = 0;
        while(rightIndex + leftIndex < targetSize) {
            Student assignable;
            if(leftIndex == left.size()) {
                returnable.addAll(right);
                break;
            }
            if(rightIndex == right.size()) {
                returnable.addAll(left);
                break;
            }
            Student leftElement = left.get(leftIndex);
            Student rightElement = right.get(rightIndex);
            if(leftElement.compareTo(rightElement) < 0) {
                assignable = leftElement;
                leftIndex++;
            }
            else {
                assignable = rightElement;
                rightIndex++;
            }
            returnable.add(assignable);
        }
        return returnable;
    }
}
