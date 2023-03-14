package Exercises24_1_3_5;

public class Ex24_1 {
  public static void main(String[] args) {
    new Ex24_1();
  }

  public Ex24_1() {
	  java.util.Set<String> name1 = new java.util.HashSet<>();
	  java.util.Set<String> name2 = new java.util.HashSet<>();
	  
    name1.add("Tom"); 
    name1.add("George"); 
    name1.add("Peter"); 
    name1.add("Jean"); 
    name1.add("Jane");
    
    name2.add("Tom"); 
    name2.add("George"); 
    name2.add("Michael"); 
    name2.add("Michelle"); 
    name2.add("Daniel");
     
    System.out.println("list1:" + name1);
    System.out.println("list2:" + name2);
    name1.addAll(name2);
    System.out.println("After addAll:" + name1 + "\n");
    
    System.out.println("list1:" + name1);
    System.out.println("list2:" + name2);
    name1.removeAll(name2);
    System.out.println("After removeAll:" + name1 + "\n");
    
    System.out.println("list1:" + name1);
    System.out.println("list2:" + name2);
    name1.retainAll(name2);
    System.out.println("After retainAll:" + name1 + "\n");
  }
  
  
}