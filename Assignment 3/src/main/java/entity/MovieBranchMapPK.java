package entity;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

public class MovieBranchMapPK implements Serializable {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MovieBranchMapPK)) return false;
        MovieBranchMapPK that = (MovieBranchMapPK) o;
        return getMovie().equals(that.getMovie()) && getBranch().equals(that.getBranch());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMovie(), getBranch());
    }


    protected Movie movie;


    protected Branch branch;

    public MovieBranchMapPK() {}

    public MovieBranchMapPK(Movie movie, Branch branch) {
        this.movie = movie;
        this.branch = branch;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }
}
