import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        demonstrateStorage();
        demonstrateLine();

        demonstrateMap();
        demonstrateFilter();
        demonstrateReduce();
        demonstrateCollect();
    }

    private static void demonstrateStorage() {
        System.out.println("Задание 1.2:");

        Storage<Integer> numberNull = new Storage<>(null);
        System.out.println("Хранилище чисел (null): " + numberNull.getOrElse(0));

        Storage<Integer> numberValue = new Storage<>(99);
        System.out.println("Хранилище чисел (99): " + numberValue.getOrElse(-1));

        Storage<String> stringNull = new Storage<>(null);
        System.out.println("Хранилище строк (null): " + stringNull.getOrElse("default"));

        Storage<String> stringValue = new Storage<>("hello");
        System.out.println("Хранилище строк (hello): " + stringValue.getOrElse("hello world"));

        System.out.println();
    }

    private static void demonstrateLine() {
        System.out.println("Задания 1.5 и 2.1:");

        System.out.println("Создание линии в 2D:");
        Point2D p1 = new Point2D(1, 1);
        Point2D p2 = new Point2D(10, 15);
        Line<Point2D> line2D = new Line<>(p1, p2);
        System.out.println("Создано: " + line2D);
        System.out.println("Длина линии (2D): " + line2D.getLengthInt());
        System.out.println();

        System.out.println("Создание линии в 3D:");
        double x1 = readDouble("Введите X1: ");
        double y1 = readDouble("Введите Y1: ");
        double z1 = readDouble("Введите Z1: ");
        double x2 = readDouble("Введите X2: ");
        double y2 = readDouble("Введите Y2: ");
        double z2 = readDouble("Введите Z2: ");

        Point3D a = new Point3D(x1, y1, z1);
        Point3D b = new Point3D(x2, y2, z2);
        Line<Point3D> line3D = new Line<>(a, b);
        System.out.println("Создано: " + line3D);
        System.out.println("Длина линии (3D): " + line3D.getLengthInt());
        System.out.println();

        System.out.println("Сдвигаем линию 3D по оси X на 10 единиц с учетом знака:");
        LineUtils.shiftLineX(line3D);
        System.out.println("После сдвига: " + line3D);
        System.out.println();
    }

    private static double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Double.parseDouble(SCANNER.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите число.");
            }
        }
    }

    private static void demonstrateMap() {
        System.out.println("Задание 3.1:");

        List<String> strings = List.of("qwerty", "asdfg", "zx");
        List<Integer> lengths = FunctionalUtils.map(strings, String::length);
        System.out.println("Длины строк: " + lengths);

        List<Integer> numbers = List.of(1, -3, 7);
        List<Integer> positiveNumbers = FunctionalUtils.map(numbers, n -> n < 0 ? -n : n);
        System.out.println("Позитивные числа: " + positiveNumbers);

        List<int[]> arrays = List.of(new int[]{1, 5, 3}, new int[]{7, 2}, new int[]{0, -1, -2});
        List<Integer> maxValues = FunctionalUtils.map(arrays, arr -> {
            int max = arr[0];
            for (int v : arr) if (v > max) max = v;
            return max;
        });
        System.out.println("Максимумы массивов: " + maxValues);

        System.out.println();
    }

    private static void demonstrateFilter() {
        System.out.println("Задание 3.2:");

        List<String> strings = List.of("qwerty", "asdfg", "zx");
        List<String> filteredStrings = FilterUtils.filter(strings, s -> s.length() >= 3);
        System.out.println("Строки >=3 символов: " + filteredStrings);

        List<Integer> numbers = List.of(1, -3, 7);
        List<Integer> negativeNumbers = FilterUtils.filter(numbers, n -> n <= 0);
        System.out.println("Отрицательные числа: " + negativeNumbers);

        List<int[]> arrays = List.of(new int[]{-1, -2}, new int[]{0, -1}, new int[]{1, -2});
        List<int[]> nonPositiveArrays = FilterUtils.filter(arrays, arr -> {
            for (int v : arr) if (v > 0) return false;
            return true;
        });
        System.out.println("Массивы без положительных чисел: " + nonPositiveArrays.size());

        System.out.println();
    }

    private static void demonstrateReduce() {
        System.out.println("Задание 3.3:");

        List<String> strings = List.of("qwerty", "asdfg", "zx");
        String concatenated = ReduceUtils.reduce(strings, String::concat, "");
        System.out.println("Склеивание строк: " + concatenated);

        List<Integer> numbers = List.of(1, -3, 7);
        int sum = ReduceUtils.reduce(numbers, Integer::sum, 0);
        System.out.println("Сумма чисел: " + sum);

        List<List<Integer>> listOfLists = List.of(List.of(1, 2), List.of(3, 4, 5), List.of());
        int totalCount = ReduceUtils.reduce(listOfLists, (a, b) -> {
            a.addAll(b);
            return a;
        }, new ArrayList<>()).size();
        System.out.println("Общее количество элементов во всех списках: " + totalCount);

        System.out.println();
    }

    private static void demonstrateCollect() {
        System.out.println("Задание 3.4:");

        List<Integer> numbers = List.of(1, -3, 7);
        Map<String, List<Integer>> splitNumbers = new HashMap<>();
        splitNumbers.put("Положительные", numbers.stream().filter(n -> n > 0).toList());
        splitNumbers.put("Отрицательные", numbers.stream().filter(n -> n < 0).toList());
        System.out.println("Разделение по знаку: " + splitNumbers);

        List<String> strings = List.of("qwerty", "asdfg", "zx", "qw");
        Map<Integer, List<String>> byLength = strings.stream().collect(Collectors.groupingBy(String::length));
        System.out.println("Разделение по длине строки: " + byLength);

        List<String> stringsWithDuplicates = List.of("qwerty", "asdfg", "qwerty", "qw");
        Set<String> uniqueStrings = new HashSet<>(stringsWithDuplicates);
        System.out.println("Строки без дубликатов: " + uniqueStrings);

        System.out.println();
    }
}