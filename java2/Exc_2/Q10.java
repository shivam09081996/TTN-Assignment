package java2.Exc_2;//10. Design classes having attributes and method(only skeleton) for a coffee shop.

class Customer
{
    protected int order_id;
    protected  double payment;
    protected boolean is_active;
    protected boolean is_waiting;

    public void pay_cash(double c)
    {
        payment = c;
        is_waiting = true;
    }

    public void collect()
    {
        if(is_waiting )
        {

        }
    }
}

class Cashier {

    public void take_order(int order_id) {

        create_order(order_id);
    }

    public void create_order(int id) {
        //put order in the order Queue
    }

    public int hand_token() {
        //give customer the ordered item.
        //remove the order from order queue
        //return the id.

        return 0;
    }

    public void deliver()
    {

    }
}

    class Barista
    {
        public void get_next_order(int id)
        {
            //adds the id to the order queue
        }

        public void prepare(int id)
        {
            //prepares the order with given id.
        }

        public void notifies()
        {
            //notifies the cashier that the order is prepared.
        }

    }



public class Q10
{
    public static void main(String[] args)
    {

    }
}
