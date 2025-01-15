package BookMyShowLLD;

import java.util.*;

public class MovieController {
    Map<City, List<Movie>> cityListMap;
    Set<Movie> movieList;

    MovieController(){
        cityListMap=new HashMap<>();
        movieList=new HashSet<>();
    }

    void addMovie(Movie movie,City city){
        movieList.add(movie);
        List<Movie> movies=cityListMap.getOrDefault(city,new ArrayList<>());
        movies.add(movie);
        cityListMap.put(city,movies);
    }

    Movie getMovieByName(String movieName){

        for(Movie movie: movieList){
            if(movie.getName().equalsIgnoreCase(movieName)){
                return movie;
            }
        }
        return null;
    }

    List<Movie> getMoviesByCity(City city){
        return cityListMap.get(city);
    }

}
