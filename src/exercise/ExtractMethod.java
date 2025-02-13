package exercise;

import java.util.Enumeration;

public class ExtractMethod {

    public static void main(String[] args) {
        ExtractMethod test = new ExtractMethod("Andi");
        test.printOwing();
    }

    private Order orders;
    private String name;

    public String getName() {
        return name;
    }

    public ExtractMethod(String name) {
        this.name = name;
        orders = new Order();
    }

    void printOwing() {
        printBanner();
        double outstanding = calculateOutstanding();
        printDetails(outstanding);
    }

    private void printBanner() {
        System.out.println("*****************************");
        System.out.println("****** Customer totals ******");
        System.out.println("*****************************");
    }

    private double calculateOutstanding() {
        Enumeration<Order> elements = orders.elements();
        double outstanding = 0.0;

        while (elements.hasMoreElements()) {
            Order each = elements.nextElement();
            outstanding += each.getAmount();
        }

        return outstanding;
    }

    private void printDetails(double outstanding) {
        System.out.println("name: " + name);
        System.out.println("amount: " + outstanding);
    }

    class Order implements Enumeration<Order> {
        private double[] amounts;
        private int currentIndex;

        public Order() {
            amounts = new double[]{12.0, 2.5, 3.2, 7.05, 6.0};
            currentIndex = 0;
        }

        public boolean hasMoreElements() {
            return currentIndex < amounts.length;
        }

        public Enumeration<Order> elements() {
            return this;
        }

        public double getAmount() {
            return amounts[currentIndex - 1];
        }

        public Order nextElement() {
            currentIndex++;
            return this;
        }
    }
}
