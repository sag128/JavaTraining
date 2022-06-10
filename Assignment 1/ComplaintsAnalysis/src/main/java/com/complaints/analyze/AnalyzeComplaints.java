package com.complaints.analyze;
import com.complaints.data.LoadComplaints;
import com.complaints.entity.Complaints;
import java.nio.file.Paths;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AnalyzeComplaints {

    static List<Complaints> allComplaints;

    static {
        allComplaints = LoadComplaints.fetch(Paths.get("src/main/resources/complaints.csv"));

    }

    public Optional<Complaints> getComplaintById (long id) {
        return allComplaints.stream().filter(e->e.getComplaintId() == id).findFirst();
    }


    public List<Complaints> getAllComplaintsByYear(int year) {
        return allComplaints.stream().filter(e->(e.getDateReceived().getYear() == year) || e.getClosedDate().getYear() == year).collect(Collectors.toList());
    }

    public List<Complaints> getAllComplaintsByBankName(String bankName) {
        return allComplaints.stream().filter(e->e.getCompany().equalsIgnoreCase(bankName)).collect(Collectors.toList());
    }

    public void getTimeTakenByBankToCloseComplaint(long id) {
        Optional<Complaints> optionalComplaint = getComplaintById(id);
        if(optionalComplaint.isPresent()) {
            Complaints complaints = optionalComplaint.get();

            System.out.println("Time Taken by "+complaints.getCompany()+" to close complaint "+complaints.getComplaintId()+" is "+ ChronoUnit.DAYS.between(complaints.getDateReceived(),complaints.getClosedDate()) + " days");
        }
        else {
            throw new RuntimeException("No record Found");
        }
    }
}
