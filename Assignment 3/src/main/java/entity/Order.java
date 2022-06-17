package entity;


import enums.OrderStatus;

import javax.persistence.*;
import java.time.LocalDateTime;


@Table
@Entity(name = "tbl_order")
public class Order {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public LocalDateTime getRentedOn() {
        return rentedOn;
    }

    public void setRentedOn(LocalDateTime rentedOn) {
        this.rentedOn = rentedOn;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    public LocalDateTime getActualReturnDate() {
        return actualReturnDate;
    }

    public void setActualReturnDate(LocalDateTime actualReturnDate) {
        this.actualReturnDate = actualReturnDate;
    }

    public int getLateFee() {
        return lateFee;
    }

    public void setLateFee(int lateFee) {
        this.lateFee = lateFee;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(
                    name = "movie_id",
                    referencedColumnName = "movie_id"),
            @JoinColumn(
                    name = "branch_id",
                    referencedColumnName = "branch_id")
    })
    private MovieBranchMap movieAndBranch;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private User customer;

    private OrderStatus status;


    @Column(name = "rented_on")
    private LocalDateTime rentedOn;


    @Column(name = "return_date")
    private LocalDateTime returnDate;


    @Column(name = "actual_return_date")
    private LocalDateTime actualReturnDate;

    @Column(name = "late_fee")
    private int lateFee;

    public MovieBranchMap getMovieAndBranch() {
        return movieAndBranch;
    }

    public void setMovieAndBranch(MovieBranchMap movieAndBranch) {
        this.movieAndBranch = movieAndBranch;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    @Column(name = "total_fee")
    private long total;


}
