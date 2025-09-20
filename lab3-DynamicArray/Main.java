public class Main {
    public static void main(String[] args) {
        DynamicArray<String> arr = new DynamicArray<>();

        arr.add("alpha");
        arr.add("beta");
        arr.add("sigma");

        System.out.println("Size: " + arr.size());
        System.out.println("Element at index 1: " + arr.get(1));

        arr.remove(1);
        System.out.println("After removal, size: " + arr.size());
        System.out.println("Element at index 1: " + arr.get(1));
    }
}
