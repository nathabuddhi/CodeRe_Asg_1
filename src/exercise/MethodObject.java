package exercise;

public class MethodObject {

    class Account {
        public int gamma(int inputVal, int quantity, int yearToDate) {
            return new GammaCalculator(this, inputVal, quantity, yearToDate).compute();
        }

        protected int delta() {
            return 10;
        }
    }

    class GammaCalculator {
        private final Account account;
        private final int inputVal;
        private final int quantity;
        private final int yearToDate;

        private int val1;
        private int val2;
        private int val3;

        public GammaCalculator(Account account, int inputVal, int quantity, int yearToDate) {
            this.account = account;
            this.inputVal = inputVal;
            this.quantity = quantity;
            this.yearToDate = yearToDate;
        }

        public int compute() {
            val1 = (inputVal * quantity) + account.delta();
            val2 = (inputVal * yearToDate) + 100;

            if ((yearToDate - val1) > 100) {
                val2 -= 20;
            }

            val3 = val2 * 7;
            return val3 - 2 * val1;
        }
    }

    private void test() {
        Account account = new Account();
        System.out.println(account.gamma(15, 10, 2010));
    }

    public static void main(String[] args) {
        MethodObject p = new MethodObject();
        p.test();
    }
}
