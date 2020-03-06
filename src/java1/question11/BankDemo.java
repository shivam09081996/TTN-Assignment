package java1.question11;

class Bank {
    private String name;
    private double worth;
    private int customerCount;
    private String yearOfEstablishmment;

    public void getDetails(){
        System.out.println("name - " + name);
        System.out.println("established in - " + yearOfEstablishmment);
        System.out.println("total worth - $" + worth);
        System.out.println("number of customers - " + customerCount);
    }

    public void setDetails(String a, double b, int c, String d){
        name = a;
        worth = b;
        customerCount = c;
        yearOfEstablishmment = d;
    }
}

class BOI extends Bank{
    private double interestRate;

    BOI(double rate){
        this.interestRate = rate;
    }
    public void getDetails(){
        super.getDetails();
        System.out.println("interest rate - " + interestRate);
    }
}

class SBI extends Bank{
    private double interestRate;

    SBI(double rate){
        this.interestRate = rate;
    }
    public void getDetails(){
        super.getDetails();
        System.out.println("interest rate - " + interestRate);
    }
}

class ICICI extends Bank{
    private double interestRate;

    ICICI(double rate){
        this.interestRate = rate;
    }
    public void getDetails(){
        super.getDetails();
        System.out.println("interest rate - " + interestRate);
    }
}

 class BankDemo{
    public static void main(String[] args) {
        SBI s = new SBI(7.5);
        s.setDetails("SBI", 29400000, 5600000, "1901");
        s.getDetails();
        System.out.println("------------");

        BOI b = new BOI(3.4);
        b.setDetails("BOI",3400000, 5600, "2001");
        b.getDetails();
        System.out.println("------------");

        ICICI i = new ICICI(6.3);
        i.setDetails("ICICI", 99000000, 900, "2010");
        i.getDetails();
    }
}

