import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public final class CollectUtils {
    private CollectUtils() {}

    public static <T, P> P collect(
            List<T> list,
            Supplier<P> collectionSupplier,
            Function<List<T>, P> collectorFunction) {
        return collectorFunction.apply(list);
    }
}