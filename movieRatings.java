/**
 * @author Josh Thyng
 * @version November 8th, 2023
 * movieRatings - Returns ranked list of students favorite movies
 */

import java.util.*;

public class movieRatings {

  public static List<Map.Entry<String, Integer>> rankMovies(
    TreeMap<String, TreeSet<String>> studentMoviePick
  ) {
    Map<String, Integer> movieCount = new HashMap<>();
    for (TreeSet<String> favorites : studentMoviePick.values()) {
      for (String movie : favorites) {
        movieCount.put(movie, movieCount.getOrDefault(movie, 0) + 1);
      }
    }
    List<Map.Entry<String, Integer>> movieList = new ArrayList<>(
      movieCount.entrySet()
    );
    movieList.sort((firstEntry, secondEntry) -> {
      int countCompare = secondEntry
        .getValue()
        .compareTo(firstEntry.getValue());
      if (countCompare != 0) {
        return countCompare;
      }
      return firstEntry.getKey().compareTo(secondEntry.getKey());
    });

    return movieList;
  }
}
