import java.io.File;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class main {
    public static void main(String[] args) {
        LinkedList<String[]> transactions = new LinkedList<>();
        LinkedList<String[]> customers = new LinkedList<>();
        Queue<String[]> queue = new LinkedList<>();
        Stack<String[]> failedTransactions = new Stack<>();
    
    try(Scanner input = new Scanner(new File("lw02/prelab/transactions.txt"))){
        while(input.hasNextLine()){
            String[] parts = input.nextLine().split(" ");
            
            transactions.add(new String[]{parts[0], parts[1], parts[2]});
            
        }
       } catch(Exception e){
            System.out.println("Could not read transactions.txt: " + e.getMessage());
            return;
       }
       for (String[] transaction : transactions){
        String name = transaction[0];
        boolean customerExist = false;
     for (String[] customer : customers) {
    
    
        if (customer[0].equals(name)) {
        customerExist = true;
        break;
    }
}

if (!customerExist) {
    customers.add(new String[] { name, "0" });
}
       }
for (String[] transaction : transactions) {
    queue.add(transaction);
    
}
while (!queue.isEmpty()) {
    String[] transaction = queue.poll();

    String name = transaction[0];
    String type = transaction[1];
    int amount = Integer.parseInt(transaction[2]);

    for (String[] customer : customers) {
        if (customer[0].equals(name)) {
            int balance = Integer.parseInt(customer[1]);

            if (type.equals("DEPOSIT")) {
                balance += amount;
                customer[1] = String.valueOf(balance);
            } else if (type.equals("WITHDRAW")) {
                if (amount <= balance) {
                    balance -= amount;
                    customer[1] = String.valueOf(balance);
                } else {
                    failedTransactions.push(transaction);
                }
            }

            break;
        }
    }
}
System.out.println("=== Final Balances ===");
for (String[] customer : customers) {
    System.out.println(customer[0] + " : " + customer[1]);
}

System.out.println("=== Failed Transactions ===");
while (!failedTransactions.isEmpty()) {
    String[] failed = failedTransactions.pop();
    System.out.println(failed[0] + " " + failed[1] + " " + failed[2]);
}
    }
    
}