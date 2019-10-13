public class ArrayInsertSort {

    public static void main(String[] args) {
        int [] in = {9, 7, 5, 4, 2, 1, 5, 3};
        SortingOutput out = arrayInsertSort(in);

        System.out.print("Input:  ");
        for(int val : in) {
            System.out.printf("%d ", val);
        }
        System.out.printf("%n");

        System.out.print("Output: ");
        for(int val : out.sortedArray) {
            System.out.printf("%d ", val);
        }
        System.out.printf("%n");

        System.out.printf("Number of comparisons: %d%n", out.compCount);
    }

    public static SortingOutput arrayInsertSort(int[] src) {
        if (src.length < 2) return new SortingOutput(src, 0);

        int[] mod = src.clone();
        int compCount = 0;

        for(int i = 1; i < mod.length; i++) {
            for (int j = 0; j < i; j++) {
                compCount++;
                if(mod[i] <= mod[j]) {
                    mod = arrayInsertShiftRight(mod, i, j);
                    break;
                }
            }
        }

        return new SortingOutput(mod, compCount);
    }

    private static int[] arrayInsertShiftRight(int[] src, int from, int to) {
        if (to >= from || to < 0 || from > src.length - 1) return src;
        int temp = src[from];

        int[] mod = src.clone();

        for (int i = from; i > to; i--) {
            mod[i] = mod[i - 1];
        }

        mod[to] = temp;

        return mod;
    }
}

class SortingOutput {
    int [] sortedArray;
    int compCount;

    public SortingOutput(int[] src, int count) {
        sortedArray = src;
        compCount = count;
    }
}
