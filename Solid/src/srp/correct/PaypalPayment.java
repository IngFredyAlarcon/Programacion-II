package srp.correct;

public class PaypalPayment implements Payment{

    @Override
    public void pay() {
        System.out.println("Paying with Paypal");
    }

}
