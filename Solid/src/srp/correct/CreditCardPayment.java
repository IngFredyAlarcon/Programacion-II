package srp.correct;

public class CreditCardPayment implements Payment{

    @Override
    public void pay() {
        System.out.println("Paying with Credit Card");
    }

}
