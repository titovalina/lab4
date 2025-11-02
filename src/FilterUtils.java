import java.util.ArrayList;
import java.util.List;

public final class FilterUtils {
    private FilterUtils() {}

    public static <T> List<T> filter(List<T> list, Tester<T> tester) {
        List<T> result = new ArrayList<>();
        for (T item : list) {
            if (tester.test(item)) {
                result.add(item);
            }
        }
        return result;
    }
}