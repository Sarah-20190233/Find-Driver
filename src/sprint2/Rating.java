package sprint2;

public abstract class Rating {

    private int arr[] = new int[5];

    public abstract int get_rate();

    public Rating() {

        for (int i = 0; i < 5; i++) {
            arr[i] = i + 1;
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        Rating r;

    }

}
