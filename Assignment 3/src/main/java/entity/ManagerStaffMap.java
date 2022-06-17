package entity;


import javax.persistence.*;

@Entity
@Table(name = "tbl_manager_staff")
@IdClass(ManagerStaffMapPK.class)
public class ManagerStaffMap {


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

    @Id
    @OneToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;

    @Id
    @OneToOne
    @JoinColumn(name = "manager_id")
    private User manager;


    public User getStaff() {
        return staff;
    }

    public void setStaff(User staff) {
        this.staff = staff;
    }

    public String getShiftStart() {
        return shiftStart;
    }

    public void setShiftStart(String shiftStart) {
        this.shiftStart = shiftStart;
    }

    public String getShiftEnd() {
        return shiftEnd;
    }

    public void setShiftEnd(String shiftEnd) {
        this.shiftEnd = shiftEnd;
    }



    @OneToOne
    @JoinColumn(name = "staff_id")
    private User staff;

    @Column(name = "shift_start")
    private String shiftStart;

    @Column(name = "shift_end")
    private String shiftEnd;


}
