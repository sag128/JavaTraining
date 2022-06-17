package repository;

import entity.*;
import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;

public class CustomerTest {

    private GenericRepository genericRepository;

    @BeforeEach
    public void init() {
        genericRepository = new GenericRepository();

    }

    @Test
    public void addCustomer() {

        User user = new User();
        user.setName("Sagar");
        user.setDob(LocalDate.of(1999,03,17));
        user.setMembershipNumber(421345678L);
        user.setEmp(false);
        genericRepository.save(user);
    }


    @Test
    public void addEmployee() {

        User user = new User();
        user.setName("Yash");
        user.setDob(LocalDate.of(1998,10,10));
        user.setEmp(true);
        genericRepository.save(user);
    }



    @Test
    public void addRegion() {
        Region region = new Region();
        region.setName("Bandra");
        genericRepository.save(region);
    }




    @Test
    public void addBranch() {
        Branch branch = new Branch();
        branch.setName("Bandra 2");
        Region region = genericRepository.fetch(Region.class,1);
        branch.setRegion(region);
        genericRepository.save(branch);
    }


    @Test
    public void addManagerWithStaff() {
        ManagerStaffMap manager = new ManagerStaffMap();
        Branch branch = genericRepository.fetch(Branch.class,1);
        User managerEmp = genericRepository.fetch(User.class,2);
        User staff = genericRepository.fetch(User.class,1);


        manager.setBranch(branch);
        manager.setManager(managerEmp);
        manager.setStaff(staff);
        manager.setShiftStart("3 PM");
        manager.setShiftEnd("9 PM");

        genericRepository.save(manager);
    }

    @Test
    public void addMovies() {
        Movie movie = new Movie();
        movie.setName("Dhoom2");
        movie.setDurationInHours(4);
        movie.setRentalFee(55);
        movie.setLateFeePerHour(2);
        movie.setParentalGuidanceNeeded(false);
        genericRepository.save(movie);
    }


    @Test
    public void assignMovieToBranch() {
        MovieBranchMap movieBranchMap = new MovieBranchMap();
        Branch branch = genericRepository.fetch(Branch.class,1);
        Movie movie = genericRepository.fetch(Movie.class,1);
        movieBranchMap.setBranch(branch);
        movieBranchMap.setMovie(movie);
        movieBranchMap.setInventory(2);
        genericRepository.save(movieBranchMap);
    }


    @Test
    public void issueMovieToCustomer() {
        Order order = new Order();
        User user = genericRepository.fetch(User.class,1);
        Movie movie = genericRepository.fetch(Movie.class,1);
        Branch branch = genericRepository.fetch(Branch.class,1);
        MovieBranchMap movieBranchMap = genericRepository.fetch(MovieBranchMap.class,new MovieBranchMapPK(movie,branch));

        order.setCustomer(user);
        order.setMovieAndBranch(movieBranchMap);
        order.setTotal(100);
        genericRepository.save(order);
    }

    @Test
    public void findAllAvailableMoviesInAShop() {
        MoviesRepository moviesRepository = new MoviesRepository();
        moviesRepository.findAllAvailableMoviesInAShop(1).stream().forEach(System.out::println);
    }


    @Test
    public void findAllUsersWhoHaveNotSubmittedTheirMovieOnDueDate()
    {
        MoviesRepository moviesRepository = new MoviesRepository();
        moviesRepository.findAllUsersWhoHaveNotSubmittedTheirMovieOnDueDate().stream().forEach(System.out::println);
    }












}
