package service;

import entity.*;
import enums.OrderStatus;
import repository.GenericRepository;

import java.time.LocalDateTime;
import java.time.Period;

public class OrderService {


    private GenericRepository genericRepository;

    public OrderService(GenericRepository genericRepository) {
        this.genericRepository = genericRepository;
    }

    public void rent(int customer_id, int movie_id,int branch_id) {

        User fetchedUser = genericRepository.fetch(User.class, customer_id);

        Movie movie = genericRepository.fetch(Movie.class,movie_id);
        if(fetchedUser.getBalance() > movie.getRentalFee()) {
            Branch branch = genericRepository.fetch(Branch.class, branch_id);
            MovieBranchMap movieBranchMap = genericRepository.fetch(MovieBranchMap.class, new MovieBranchMapPK(movie, branch));
            if (movieBranchMap.getInventory() > 0) {
                movieBranchMap.setInventory(movieBranchMap.getInventory() - 1);
                genericRepository.save(movieBranchMap);

                Order order = new Order();

                order.setTotal(movie.getRentalFee());
                order.setRentedOn(LocalDateTime.now());
                order.setReturnDate(LocalDateTime.now().plusHours(24));
                genericRepository.save(order);
            } else {
                throw new RuntimeException("No copies available, please check another store");
            }
        }
        else {
            throw  new RuntimeException("You don't have enough balance");
        }
    }

    public void returnMovie(int orderId) {

        Order order = genericRepository.fetch(Order.class, orderId);
        MovieBranchMap movieBranchMap = genericRepository.fetch(MovieBranchMap.class, order.getMovieAndBranch());
        movieBranchMap.setInventory(movieBranchMap.getInventory()+1);
        genericRepository.save(movieBranchMap);
        order.setStatus(OrderStatus.LATE_RETURN);
        order.setActualReturnDate(order.getReturnDate().plusDays(5));
        order.setLateFee(Period.between(order.getActualReturnDate().toLocalDate(),order.getReturnDate().toLocalDate()).getDays()*movieBranchMap.getMovie().getLateFeePerHour());
        order.setTotal(order.getTotal()+order.getLateFee());
        genericRepository.save(order);
    }
}
