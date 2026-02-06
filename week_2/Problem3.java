package week_2;
interface paymentStrategy{
    void makePayment();
}
class creditCardPayment implements paymentStrategy{
    public void makePayment(){
        System.out.println("Payment through credit card");
    }
}
class upiPayment implements paymentStrategy{
    public void makePayment(){
        System.out.println("Payment through UPI");
    }
}
public class Problem3 {
    public static void main(String []args){
        paymentStrategy pt = new creditCardPayment();
        paymentStrategy pt2 = new upiPayment();

        pt.makePayment();
        pt2.makePayment();
    }
}
