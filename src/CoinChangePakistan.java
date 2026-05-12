public class CoinChangePakistan {
    public static void main(String[] args) {

        int amount = 1988;
        int[] denominations = {5000, 1000, 500, 100, 50, 20, 10, 5, 2, 1};
        System.out.println("Amount = Rs. " + amount);
        System.out.println("Required denominations for each currency :\n");

        for (int note : denominations) {
            if (amount >= note) {
                int count = amount / note;
                amount = amount % note;
                System.out.println("Rs. " + note + " * " + count);
            }
        }
    }
}