package BookMyShowLLD;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookMyShow {

    MovieController movieController;
    ThreaterController threaterController;

    BookMyShow(){
        movieController =new MovieController();
        threaterController=new ThreaterController();
    }

    public static void main(String[] args) {
        BookMyShow bookMyShow=new BookMyShow();
        bookMyShow.initialize();
        bookMyShow.createBooking(City.BANGLORE,"pushpa2");
    }

    private void initialize(){
        createMovies();
        createThreatre();
    }

    private void createBooking(City userCity,String movieName){

        List<Movie> movieList= movieController.getMoviesByCity(userCity);
        Movie interestedMovie = null;
        for(Movie movie: movieList){
            if(movie.getName().equalsIgnoreCase(movieName))
            {
                interestedMovie=movie;
            }
        }

        Map<Threater,List<Show>> showThreatreWise = threaterController.getAllShow(interestedMovie,userCity);

        Map.Entry<Threater,List<Show>> entry = showThreatreWise.entrySet().iterator().next();
        List<Show> runningShows = entry.getValue();
        Show interestedShow = runningShows.get(0);

        int seatNumber = 30;
        List<Integer> bookedSeats = interestedShow.getBookingList();
        if(!bookedSeats.contains(seatNumber)){
            bookedSeats.add(seatNumber);
            Booking booking = new Booking();
            List<Seat> myBookedSeats = new ArrayList<>();
            for(Seat screenSeat : interestedShow.getScreen().getSeatList()) {
                if(screenSeat.getId() == seatNumber) {
                    myBookedSeats.add(screenSeat);
                }
            }
            booking.setSeatList(myBookedSeats);
            booking.setShow(interestedShow);
        } else {
            //throw exception
            System.out.println("seat already booked, try again");
            return;
        }

        System.out.println("BOOKING SUCCESSFUL");


    }

    private void createThreatre(){
        Movie pushpa2 = movieController.getMovieByName("pushpa2");
        Movie bahubali= movieController.getMovieByName("Bahubali");

        Threater inoxThreatre=new Threater();
        inoxThreatre.setId(1);
        inoxThreatre.setScreenList(createScreen());
        inoxThreatre.setCity(City.BANGLORE);
        List<Show> inoxShows=new ArrayList<>();
        Show inoxMorningShow = createShow(1,inoxThreatre.getScreenList().get(0),pushpa2,8);
        Show inoxEveningShow = createShow(2,inoxThreatre.getScreenList().get(0),bahubali,16);
        inoxShows.add(inoxMorningShow);
        inoxShows.add(inoxEveningShow);
        inoxThreatre.setShowsList(inoxShows);

        Threater pvrTheatre = new Threater();
        pvrTheatre.setId(2);
        pvrTheatre.setScreenList(createScreen());
        inoxThreatre.setCity(City.INDORE);
        List<Show> pvrShows=new ArrayList<>();
        Show pvrMorningShow=createShow(1,pvrTheatre.getScreenList().get(0),pushpa2,10);
        Show pvrEveningShow=createShow(2,pvrTheatre.getScreenList().get(0),bahubali,20);
        pvrShows.add(pvrMorningShow);
        pvrShows.add(pvrEveningShow);
        pvrTheatre.setShowsList(pvrShows);

        threaterController.addTheatre(inoxThreatre,City.BANGLORE);
        threaterController.addTheatre(pvrTheatre,City.INDORE);
    }

    private List<Screen> createScreen(){
        List<Screen> screens=new ArrayList<>();
        Screen screen1=new Screen();
        screen1.setId(1);
        screen1.setSeatList(createSeats());
        screens.add(screen1);
        return screens;
    }

    private Show createShow(int showId,Screen screen,Movie movie,int showStartTime){
        Show show=new Show();
        show.setId(1);
        show.setScreen(screen);
        show.setMovie(movie);
        show.setLocalDateTime(LocalDateTime.now());
        return show;
    }

    private List<Seat> createSeats(){
        List<Seat> seats=new ArrayList<>();
        for(int i=0;i<40;i++){
            Seat seat=new Seat();
            seat.setId(i);
            seat.setSearCatagory(Catagory.SILVER);
            seats.add(seat);
        }

        for(int i=40;i<70;i++)
        {
            Seat seat=new Seat();
            seat.setId(i);
            seat.setSearCatagory(Catagory.GOLD);
            seats.add(seat);
        }

        for(int i=70;i<100;i++)
        {
            Seat seat=new Seat();
            seat.setId(i);
            seat.setSearCatagory(Catagory.PLATINUM);
            seats.add(seat);
        }
        return seats;
    }


    private void createMovies(){
        Movie pushpa2=new Movie();
        pushpa2.setId(1);
        pushpa2.setName("pushpa2");
        pushpa2.setDuration(180);

        Movie bahubali=new Movie();
        bahubali.setId(2);
        bahubali.setName("Bahubali");
        bahubali.setDuration(120);

        movieController.addMovie(pushpa2,City.BANGLORE);
        movieController.addMovie(pushpa2,City.INDORE);
        movieController.addMovie(bahubali,City.BANGLORE);
        movieController.addMovie(bahubali,City.INDORE);
    }
}
