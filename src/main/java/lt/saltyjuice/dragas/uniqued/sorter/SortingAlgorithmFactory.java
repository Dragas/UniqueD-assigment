package lt.saltyjuice.dragas.uniqued.sorter;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.TreeMap;

public class SortingAlgorithmFactory {
    private static final Map<String, Class<? extends Sorter>> registered = new TreeMap<>();

    public static void register(String shorthand, Class<? extends Sorter> clazz) {
        registered.put(shorthand, clazz);
    }

    public static Sorter get(String shorthand) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<? extends Sorter> clazz = registered.get(shorthand);
        if(clazz == null) {
            System.err.format("No such algorithm: %s", shorthand);
            System.exit(255);
        }
        return clazz.getConstructor().newInstance();
    }
}
