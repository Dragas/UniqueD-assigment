package lt.saltyjuice.dragas.uniqued;

import lt.saltyjuice.dragas.uniqued.sorter.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        if (args.length != 2) {
            System.err.println("Usage: [sorting algorithm] [csv file]");
            System.err.println("Sorting algorithm is one of:");
            System.err.println("-m | --merge for merge sort");
            System.err.println("-b | --bubble for bubble sort");
            System.err.println("-h | --heap for heap sort");
            System.exit(0);
        }
        File csv = new File(args[1]); // expected that file does contain 3 columns and no more
        if (!csv.exists()) {
            System.err.format("No such file: %s", args[1]);
            System.exit(255);
        }

        SortingAlgorithmFactory.register("-m", MergeSort.class);
        SortingAlgorithmFactory.register("--merge", MergeSort.class);
        SortingAlgorithmFactory.register("-b", BubbleSort.class);
        SortingAlgorithmFactory.register("--bubble", BubbleSort.class);
        SortingAlgorithmFactory.register("-h", HeapSort.class);
        SortingAlgorithmFactory.register("--heap", HeapSort.class);


        Sorter algorithm = SortingAlgorithmFactory.get(args[0]);

        Scanner fin = new Scanner(csv);
        List<Student> students = new ArrayList<>();
        while(fin.hasNextLine()) {
            String line = fin.nextLine();
            String[] columns = line.split(",");
            if(columns.length != 2)
                throw new RuntimeException(String.format("Malformed file. Expected 2 columns, got %s", columns.length));
            Student student = new Student(columns[0], new Float(columns[1]));
            students.add(student);
        }
        long start = System.nanoTime();
        students = algorithm.sort(students);
        long end = System.nanoTime();
        System.err.format("Sorted %d records. Took %d nano seconds", students.size(), end - start);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < students.size(); i++) { // regular for loop so it wouldnt create an iterator
            Student student = students.get(i); // since performance is the target here
            sb.append(String.format("%s,%s%n", student.getName(), student.getScore()));
        }
        System.out.print(sb);
        System.err.println("Save to file? [y/n]");
        int symbol = System.in.read();
        if(symbol == 'y' || symbol == 'Y') {
            FileWriter fout = new FileWriter(args[1] + ".sorted");
            fout.write(sb.toString());
            fout.close();
        }
    }
}
