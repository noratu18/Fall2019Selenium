package officeHours;

import java.util.*;

public class Java_Maps {

    /*
    Deque -> double sided
    we can add and retrieve elements from dequeue from
    both sides ( head, end)
     */
    public static void main(String[] args) {

        Deque<Integer> numbers = new ArrayDeque<>();
        numbers.addFirst(20);
        numbers.addFirst(30);
        numbers.addFirst(50);
        System.out.println("numbers = " + numbers);
        numbers.addLast(90); // will add in the end of list
        System.out.println("numbers = " + numbers);
        numbers.add(33);//will add in the las too
        System.out.println("numbers = " + numbers);
        Integer num = numbers.pollFirst(); // returns and deletes first element
        System.out.println("num = " + num);
        System.out.println(numbers);
        System.out.println(numbers.getLast()+" peek: "+ numbers.peekLast());
        // peek() returns the value for you (similar to get())
        // poll() -> returns the value and remove it from the Queue
        System.out.println("dequeu after peek: "+ numbers);


        /*
        What collections you are using in your project?
        Describe all different collections (List, Queue, Set)
        explain the difference between them

        List -> ArrayList most of the times, becasue I would usually just need to store some values
        I would use LinkedList if I know I will to manipulate my date
        (consistently add, remove, ets.)

        Set -> HashSet -  for unique values
               TreeSet -> for unique sorted values

        Queue -> if I need to check FIRST IN FIRST OUT (FIFO) logic in my project
        
        
                                    Map Interface:
                                    
          -> Map interface does not accept any duplicate keys                        
          -> HashMap - key/value, can accept null,doesn't keep order
          -> HashTable - synchronized / no null value
          -> LinkedHashMap - extends the HashMap, allows nulls, slower than HashMap it is linked
          -> TreeMap - sorted, no null values
         */

        HashMap<String, String> user1 = new HashMap<>();
        
        user1.put("First Name",null);
        user1.put("Last Name", "Smith");
        user1.put("Account number","A2654");
        user1.put("DOB","02.20.1980");
        System.out.println("user1 = " + user1);// HashMap doesn't keep order


        LinkedHashMap<String, String> user2 = new LinkedHashMap<>();
        user2.put("First Name","John");
        user2.put("Last Name", null);
        user2.put("Last Name", "White");
        user2.put("Last Name", "Green");// overwrites the previous one
        user2.put("Account number", "A4738957");
        user2.put("DOB", "12.02.1964");
        System.out.println("user2 = " + user2);// LinkedHashMap keeps order
        
        List<HashMap<String, String>> users = new ArrayList<>();
        //We can use LinkedHashMap as well
        users.add(user1);
        users.add(user2);
        System.out.println("users = " + users);
        
        HashMap<String, String> user3 = new HashMap<>(user1);
        user3.put("Account number", "A7328943");
        user3.put("DOB", "12.08.1990");
        
        
        users.add(user3);
        
        // print account number for all users along with last name

        System.out.println("===========LIST===============");
        /*
        user = {Account number=A2654, DOB=02.20.1980, First Name=null, Last Name=Smith}
       user = {First Name=John, Last Name=Green, Account number=A4738957, DOB=12.02.1964}
       user = {First Name=null, Last Name=Smith, Account number=A7328943, DOB=12.08.1990}
         */
        
       for( HashMap<String, String> user : users){

           System.out.println("Account number: " + user.get("Account number")+" | Last Name: "+ user.get("Last Name"));
        }

        System.out.println("====================================");


       int i =1; // this prints user1

       for(HashMap<String,String> each : users){

           System.out.println("User "+ i);// user1
           Iterator<String> keys = each.keySet().iterator();
           while (keys.hasNext()){
               String key = keys.next();
               System.out.println(key + ": " +each.get(key));
           }
           i++;// this adds user like user2 user3
       }









    }
}
