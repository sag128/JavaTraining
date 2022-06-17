package repository;

import entity.Movie;
import entity.User;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.List;

public class MoviesRepository extends GenericRepository{

    public List<Movie> findAllAvailableMoviesInAShop(int branchId) {
       return entityManagerFactory
                .createEntityManager()
                .createQuery("select mb.movie from MovieBranchMap mb inner join mb.branch b where b.id = :branchId and mb.inventory > 0 ",Movie.class)
                .setParameter("branchId",branchId)
                .getResultList();
    }


    public List<User> findAllUsersWhoHaveNotSubmittedTheirMovieOnDueDate() {
        return entityManagerFactory
                .createEntityManager()
                .createQuery("select o.customer from tbl_order o where FUNCTION('datediff',hour,o.returnDate,o.actualReturnDate)  > 0 ",User.class)
                .getResultList();
    }


    // hacky way
    public List<User> getTime(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("h");
        DateTimeFormatter dateTimeFormatterAmPm = DateTimeFormatter.ofPattern("a");
        String ampm = LocalDateTime.now().format(dateTimeFormatterAmPm);
        String currentHour = LocalDateTime.now().format(dateTimeFormatter);
        return entityManagerFactory
                .createEntityManager()
                .createQuery("select ms.staff from ManagerStaffMap ms where :currentHour " +
                        "BETWEEN CAST(SUBSTRING( ms.shiftStart,1,2) as string) AND" +
                        "  CAST(SUBSTRING( ms.shiftEnd ,1,2) as string) AND" +
                        " SUBSTRING( ms.shiftEnd ,3,LEN(ms.shiftEnd)) LIKE :ampm",User.class)
                .setParameter("ampm",ampm)
                .setParameter("currentHour",currentHour)
                .getResultList();

    }


}
