package java1.Exc_1.question9;

public class EnumDisplay {
    public static void main(String[] args) {
        for(house h:house.values())
        {
            System.out.println("Price of "+h+" is "+h.getPrice());
        }
    }
}
enum house{
    house1(100000),
    house2(200000),
    house3(300000);
    private int price;
    house(int p)
    {
        price = p;
    }
    int getPrice(){
        return price;
    }
}
