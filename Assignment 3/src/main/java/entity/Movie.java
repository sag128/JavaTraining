package entity;


import javax.persistence.*;

@Entity
@Table(name = "tbl_movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name = "is_parental_guidance_required")
    private boolean isParentalGuidanceNeeded;

    @Column(name = "late_fee_per_hour")
    private int lateFeePerHour;


    @Column(name = "rental_fee")
    private int rentalFee;


    @Column(name = "duration_in_hours",columnDefinition = "DECIMAL(4,2)")
    private double durationInHours;

    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isParentalGuidanceNeeded() {
        return isParentalGuidanceNeeded;
    }

    public void setParentalGuidanceNeeded(boolean parentalGuidanceNeeded) {
        isParentalGuidanceNeeded = parentalGuidanceNeeded;
    }

    public int getLateFeePerHour() {
        return lateFeePerHour;
    }

    public void setLateFeePerHour(int lateFeePerHour) {
        this.lateFeePerHour = lateFeePerHour;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", isParentalGuidanceNeeded=" + isParentalGuidanceNeeded +
                ", lateFeePerHour=" + lateFeePerHour +
                ", rentalFee=" + rentalFee +
                ", durationInHours=" + durationInHours +
                ", name='" + name + '\'' +
                '}';
    }

    public int getRentalFee() {
        return rentalFee;
    }

    public void setRentalFee(int rentalFee) {
        this.rentalFee = rentalFee;
    }

    public double getDurationInHours() {
        return durationInHours;
    }

    public void setDurationInHours(double durationInHours) {
        this.durationInHours = durationInHours;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
