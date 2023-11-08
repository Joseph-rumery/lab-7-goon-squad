import java.util.*;
import java.util.Map.Entry;

public class movieNight {

	public boolean rankMovies(TreeMap<String, TreeSet<String>> favmov,
			ArrayList<String> list) {
		//search through treemap for the students in the arraylist 
		//to find common movies from their treesets
		String firstStu = list.get(0);
		
		ArrayList<String> movies = new ArrayList<String>();
		
		for(String name : favmov.get(firstStu)) {
			movies.add(name);
		}
		
		for(Entry<String, TreeSet<String>> student: favmov.entrySet()) {
			
			for(int i = 0; i < movies.size()-1;i++) {
				
				if(!student.getValue().contains(movies.get(i))) {
					
					movies.remove(i);
					
				}
				
				
			}
			
		}
		
		if(movies.isEmpty()) {
			return false;
		} else {
			return true;
		}
		
	}
}
