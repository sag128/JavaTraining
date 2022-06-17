package repository;

import entity.Movie;
import entity.User;

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


}
