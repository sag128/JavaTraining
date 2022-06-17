package entity;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.Objects;

public class ManagerStaffMapPK implements Serializable {

    private Branch branch;

    private User manager;

    public ManagerStaffMapPK() {}

    public ManagerStaffMapPK(Branch branch, User manager) {
        this.branch = branch;
        this.manager = manager;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ManagerStaffMapPK)) return false;
        ManagerStaffMapPK that = (ManagerStaffMapPK) o;
        return getBranch().equals(that.getBranch()) && getManager().equals(that.getManager());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBranch(), getManager());
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public User getManager() {
        return manager;
    }

    public void setManager(User manager) {
        this.manager = manager;
    }
}
