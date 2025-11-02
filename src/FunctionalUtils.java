import java.util.ArrayList;
import java.util.List;

public final class FunctionalUtils {
    private FunctionalUtils() {}

    // Применяет mapper ко всем элементам списка и возвращает новый список
    public static <T, P> List<P> map(List<T> list, Mapper<T, P> mapper) {
        List<P> result = new ArrayList<>();
        for (T item : list) {
            result.add(mapper.apply(item));
        }
        return result;
    }
}