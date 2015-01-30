import java.util.*;

public class JavaCollections {

	public static void fnTestCollections(){
		
		// LISTS
		
		List arrList = new ArrayList();
		List linList = new LinkedList();
		
		arrList.add(1);
		arrList.add(2);
		arrList.add(2);
		System.out.println("Array List size: " + arrList.size());
		
		linList.add(1);
		linList.add(1);
		System.out.println("Linked List size: " + linList.size());
		
		
		// SETS 
		
		Set arrSet = new HashSet();
		Set linSet = new LinkedHashSet();
		Set treSet = new TreeSet();
		
		arrSet.add(1);
		arrSet.add(2);
		arrSet.add(2);
		Iterator arrIterator = arrSet.iterator();
		while(arrIterator.hasNext()){
			System.out.print(arrIterator.next());
		}
		System.out.println();
		
		linSet.add(2);
		linSet.add(1);
		linSet.add(2);
		Iterator linIterator = linSet.iterator();
		while(linIterator.hasNext()){
			System.out.print(linIterator.next());
		}
		System.out.println();
		
		treSet.add(3);
		treSet.add(2);
		treSet.add(3);
		treSet.add(7);
		Iterator treIterator = treSet.iterator();
		while(treIterator.hasNext()){
			System.out.print(treIterator.next());
		}
		System.out.println();

		
		// MAPS
		
		Map hshMap = new HashMap();
		Map treMap = new TreeMap();
		
		hshMap.put(3, "c");
		hshMap.put(2, "b");
		hshMap.put(5, "e");
		
		Iterator hshIterator = hshMap.keySet().iterator();
		while(hshIterator.hasNext()){
			
			System.out.print(hshMap.get(hshIterator.next()));
			
		}
		System.out.println();
		
		treMap.put(3, "c");
		treMap.put(2, "z");
		treMap.put(5, "e");
		
		Iterator treeIterator = treMap.keySet().iterator();
		while(treeIterator.hasNext()){
			
			System.out.print(treMap.get(treeIterator.next()));
			
		}
		System.out.println();
		
		Iterator treeIterator1 = treMap.values().iterator();
		while(treeIterator1.hasNext()){
			
			System.out.print(treeIterator1.next());
			
		}
		System.out.println();
	}
	
}