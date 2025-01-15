package BookMyShowLLD;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThreaterController {
    Map<City, List<Threater>> cityListMap;
    List<Threater> threaterList;

    ThreaterController(){
        cityListMap=new HashMap<>();
        threaterList=new ArrayList<>();
    }

    void addTheatre(Threater threater, City city){
        threaterList.add(threater);

        List<Threater> threaters=cityListMap.getOrDefault(city,new ArrayList<>());
        threaters.add(threater);
        cityListMap.put(city,threaters);
    }

    Map<Threater,List<Show>> getAllShow(Movie movie,City city){
        Map<Threater,List<Show>> threaterVsShows = new HashMap<>();
        List<Threater> threaters=cityListMap.get(city);

        for(Threater threater: threaters){
            List<Show> givenMovieShows=new ArrayList<>();
            List<Show> shows=threater.getShowsList();
            for(Show show:shows)
            {
                if(show.getMovie().getName().equalsIgnoreCase(movie.getName())){
                    givenMovieShows.add(show);
                }
            }
            if(!givenMovieShows.isEmpty())
           threaterVsShows.put(threater,givenMovieShows);
        }
        return  threaterVsShows;
    }

}
