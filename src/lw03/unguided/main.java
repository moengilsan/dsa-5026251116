package lw03.unguided;
import java.util.*;

public class main {
    public static void main (String[] args){
  
        Scanner sc = new Scanner(main.class.getResourceAsStream("enrollment.txt"));
        Map<String, Integer> courses = new LinkedHashMap<>();
        List<String> checks = new ArrayList<>();

        int rejected = 0;

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");
        
            String type = parts[0];
            String course = parts[1];
        
            if (type.equals("REGISTER")) {
                int count = Integer.parseInt(parts[2]);
                if (count <= 0) {
                    rejected++;
                } else {
                    if (courses.containsKey(course)){
                        int current = courses.get (course);
                        courses.put(course, current + count);
                    } else {
                        courses.put(course, count);
                    }
                }
                 }  else if (type.equals("WITHDRAW")) {
                    int count = Integer.parseInt(parts[2]);
                
                if (count <= 0) {
                    rejected++;
                 } else {
                  if (courses.containsKey(course) && courses.get(course) >= count) {
                 int current = courses.get(course);
                courses.put(course, current - count);
                    } else {
                        rejected++;
                    }
                }
           } else if (type.equals("CHECK")) {
             if (courses.containsKey(course)) {
            checks.add(course + ": " + courses.get(course) + " students");
            } else {
                checks.add(course + ": Not found");
             }
            }
        }

        System.out.println("===== Enrollment Checks =====");
        for (String c : checks) {
            System.out.println(c);
        }

        System.out.println("===== Final Enrollment =====");
        for (String c : courses.keySet()) {
            System.out.println(c + ": " + courses.get(c) + " students");
        }

        System.out.println("Rejected operations: " + rejected);
    }
}
    

