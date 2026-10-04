import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class main {

    public static void main(String[] args) {

        final int MAX_BORROW = 2;

        LinkedList<String[]> requests = new LinkedList<>();
        LinkedList<String[]> books = new LinkedList<>();
        LinkedList<String[]> members = new LinkedList<>();
        LinkedList<String[]> successfulRequests = new LinkedList<>();

        Queue<String[]> requestQueue = new LinkedList<>();
        Stack<String[]> failedRequests = new Stack<>();

        books.add(new String[]{"Kalkulus", "2"});
        books.add(new String[]{"Fisika", "1"});
        books.add(new String[]{"Statistika", "2"});

   try {

      Scanner scanner = new Scanner(new File("borrowing.txt"));

    while (scanner.hasNext()) {

       String name = scanner.next();
       String bookTitle = scanner.next();
   String[] request = {name, bookTitle};
      requests.add(request);
       boolean memberExists = false;
       for (String[] member : members) {
      if (member[0].equals(name)) {
         memberExists = true;
        }
       }
      if (!memberExists) {
        members.add(new String[]{name, "0"});
              }
        }

      scanner.close();

     } catch (FileNotFoundException e) {

      System.out.println("borrowing.txt not found.");
      return;
        }

    for (String[] request : requests) {
         requestQueue.add(request);
         while (!requestQueue.isEmpty()) {

          String[] request = requestQueue.poll();

        String name = request[0];
         String requestedBook = request[1];
         String[] bookFound = null;
          String[] memberFound = null;

        for (String[] book : books) {

           if (book[0].equals(requestedBook)) {
               bookFound = book;
          }
    }

      for (String[] member : members) {

        if (member[0].equals(name)) {
           memberFound = member;
           }
      }
 }
 }
    

