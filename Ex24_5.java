import java.util.LinkedList;

@SuppressWarnings({ "rawtypes", "serial" })
public class Ex24_5<E> extends LinkedList {
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		 
		System.out.println("List before enqueue: " + list);
		System.out.print("List after enqueue: ");
		enqueue(list);
		System.out.println(list);
		
		System.out.println(" ");
		
		System.out.println("List before dequeue: " + list);
		System.out.print("List after dequeue: ");
		dequeue(list);
		System.out.println(list);
	 }
	
	 @SuppressWarnings("unchecked")
	public static void enqueue(LinkedList list) {
      list.push("Test");
    }

	public static Object dequeue(LinkedList list) {
      return list.removeFirst();
    }
    
    public LinkedList getString(LinkedList list) {
    	return list;
    }
}
