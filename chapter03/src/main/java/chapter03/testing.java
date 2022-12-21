package chapter03;
import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
public class testing {

	public static HashMap<Integer, Integer> sortByValue(HashMap<Integer, Integer> hm){
	    // 1
	    List<Map.Entry<Integer, Integer> > list =
	           new LinkedList<Map.Entry<Integer, Integer>>(hm.entrySet());
	    // 2
	    Collections.sort(list, new Comparator<Map.Entry<Integer, Integer> >() {
	        public int compare(Map.Entry<Integer, Integer> o1,
	                           Map.Entry<Integer, Integer> o2)
	        {
	            return (o2.getValue()).compareTo(o1.getValue());
	        }
	    });
	    // 3
	    HashMap<Integer, Integer> temp = new LinkedHashMap<Integer, Integer>();
	    for (Map.Entry<Integer, Integer> aa : list) {
	        temp.put(aa.getKey(), aa.getValue());
	    }
	    // 4
	    return temp;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k= 4;
		int[] tenger = {1, 3, 2, 5, 4, 5, 2, 3};
		int answer = 0;
		
		Arrays.sort(tenger);
		//1,2,2,3,3,4,5,5
		HashMap<Integer,Integer> counts = new HashMap<Integer,Integer>();
		for(int i=0; i<tenger.length;i++) {
			if(i==0) {
				counts.put(tenger[i], 1);
			}
			else {
				if(tenger[i] == tenger[i-1]) {
					counts.put(tenger[i], counts.get(tenger[i])+1);
				}
				else {
					counts.put(tenger[i], 1);
				}
			}
		}
		
		
		HashMap<Integer,Integer> fcounts = sortByValue(counts);
		for (Entry<Integer, Integer> entrySet : fcounts.entrySet()) {
            //System.out.println(entrySet.getKey() + " : " + entrySet.getValue());
			k -= entrySet.getValue();
			if(k<=0) {
				answer++;
				break;
			}
			else
				answer++;
        }
		
		System.out.println(answer);

	}

}
