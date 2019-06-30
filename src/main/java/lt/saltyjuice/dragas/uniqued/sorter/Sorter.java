package lt.saltyjuice.dragas.uniqued.sorter;

import lt.saltyjuice.dragas.uniqued.Student;

import java.util.List;

/**
 * Common interface for sorting algorithm implementations.
 *
 * Implementations are encouraged to choose their own iteration mechanism instead
 * of imposing only recursive or iterative access on data structure.
 */
public interface Sorter {

    List<Student> sort(List<Student> comparable);
}
