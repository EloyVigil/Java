import java.util.ArrayList;

public class CafeUtil {

    int numWeeks = 10;
    public int getStreakGoal(){
        int sum = 0;
        for(int i = 1; i <= numWeeks; i++){
            sum = sum + i;
        }
        return sum;
    }

    double getOrderTotal(double[] prices){
        double sum = 0;
        for(int i = 0; i < prices.length; i++){
            sum = sum + prices[i];
        }
        return sum;
    }

    void displayMenu(ArrayList<String> menuItems){
        // System.out.println(myArray[0]);
        for(int i = 0; i < menuItems.size(); i++){
            System.out.println(i);
            System.out.println(menuItems.get(i));
        }
    }

    void addCustomer(ArrayList<String> customers){
        System.out.println("Please enter your name: ");
        String userName = System.console().readLine();
        System.out.println("Hello, " + userName + "!");
        System.out.println("There are " + customers.size() + " people ahead of you.");
        customers.add(userName);
        System.out.println(customers);
    }
}

