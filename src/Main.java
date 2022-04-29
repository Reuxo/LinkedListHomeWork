public class Main {
    public static void main(String[] args) {
        Integer[] array = {2, 1, 2, 3, 2, 4, 5, 6, 7, 2};
        Integer[] arr = {1, 2, 3, 5, 6, 3, 2, 1};
        Integer[] array2 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        String[] arrOfStr = {"tube", "year", "speed", "year", "tube", "range", "year", "tube", "tube",
                "stock", "object", "year"};
        Integer[] arraySort = {3, 56, 17, 88, 34, 2, 1, 77};

        List list = new List(arraySort);
      list.bubbleSort();
      list.printList();


    }
}
