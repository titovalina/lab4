public final class Storage<T> {
    private final T value;

    public Storage(T value) {
        this.value = value;
    }

    public T getOrElse(T alternative) {
        return value != null ? value : alternative;
    }

    public T getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Storage{" + "value=" + value + '}';
    }
}