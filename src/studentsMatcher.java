import java.io.FileNotFoundException;
import java.util.*;

public class studentsMatcher {

	public static TreeMap<String, String> findMatches(TreeMap<String, TreeSet<String>> NameMovies) {
		// treeMap to add to
		TreeMap<String, String> endMap = new TreeMap<String, String>();
		// getting first student
		for (String student : NameMovies.keySet()) {
			TreeSet<String> studentMovies = NameMovies.get(student);
			String similarName = "";
			int similarVal = 0;
			// getting second student
			for (String student2 : NameMovies.keySet()) {
				int currentVal = 0;
				// no the same student
				if (!student.equals(student2)) {
					for (String movie : NameMovies.get(student2)) {
						if (studentMovies.contains(movie)) {
							currentVal++;
						}
					}
				}
				// compare values
				if (currentVal > similarVal) {
					similarVal = currentVal;
					similarName = student2;
				}
			}
			// add to map
			endMap.put(student, similarName);
		}
		return endMap;

	}

}
