import srp.bad.Report;
import srp.correct.CreditCardPayment;
import srp.correct.FileManager;
import srp.correct.PaypalPayment;
import srp.correct.ReportOk;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Example SRP");
        System.out.println("Incorrect Implementation");
        Report report = new Report();
        report.generateReport();
        report.saveToFile();

        System.out.println("Correct Implementation");
        ReportOk reportOk = new ReportOk();
        reportOk.generateReport();

        FileManager fm = new FileManager();
        fm.saveToFile();

        System.out.println("open/closed principle");
        PaypalPayment paypal = new PaypalPayment();
        paypal.pay();

        CreditCardPayment creditCard = new CreditCardPayment();
        creditCard.pay();
    }
}
