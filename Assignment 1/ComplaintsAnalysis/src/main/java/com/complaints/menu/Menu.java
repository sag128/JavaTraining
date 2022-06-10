package com.complaints.menu;

import com.complaints.analyze.AnalyzeComplaints;
import com.complaints.entity.Complaints;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Menu {

    Scanner scanner = new Scanner(System.in).useDelimiter("\\n");
    AnalyzeComplaints analyzeComplaints = new AnalyzeComplaints();

    public void getMainMenu() {
        int option = -1;


        do {
            System.out.println("-----Menu-----");
            System.out.println("1. Fetch complaint based on complaint id");
            System.out.println("2. Fetch all the complaints based on year");
            System.out.println("3. Fetch complaints based on the bank name");
            System.out.println("4. Fetch time taken by the bank to close any complaint");
            System.out.println("0. Exit");
            System.out.println("--------------");
            System.out.println("Enter Your Choice");


            option = scanner.nextInt();
            switch (option) {
                case 0:
                    System.out.println("Bye bye!");
                    System.exit(0);
                case 1:
                    System.out.println("Please enter complaint ID");
                    Optional<Complaints> optionalComplaints = analyzeComplaints.getComplaintById(scanner.nextInt());
                    if(optionalComplaints.isPresent()) {
                        Complaints complaints = optionalComplaints.get();
                        System.out.println(complaints);
                    }
                    else {
                        System.out.println("No complaint found");
                    }
                    break;
                case 2:
                    System.out.println("Please enter year");
                    int year = scanner.nextInt();
                    List<Complaints> complaintsList = analyzeComplaints.getAllComplaintsByYear(year);
                    if(!complaintsList.isEmpty()) {
                        complaintsList.forEach(System.out::println);
                        System.out.println("Total "+complaintsList.size()+" records");
                    }
                    else {
                        System.out.println("Complaints with year "+year+" not found");
                    }
                    break;
                case 3:
                    System.out.println("Please enter bank name");
                    String bankName = scanner.next();
                    List<Complaints> complaints = analyzeComplaints.getAllComplaintsByBankName(bankName);
                    if(!complaints.isEmpty()) {
                        complaints.forEach(System.out::println);
                        System.out.println("Total "+complaints.size()+" records");

                    }
                    else {
                        System.out.println("Complaints with bank "+bankName+" not found");
                    }
                    break;
                case 4:
                    System.out.println("Please enter complaint ID");
                    try {
                        analyzeComplaints.getTimeTakenByBankToCloseComplaint(scanner.nextInt());
                    }
                    catch (RuntimeException e) {
                        System.out.println("No complaint found");
                    }
                    break;
                default:
                    System.out.println("Invalid Choice Please select a valid option");
                    break;

            }


        } while (option != 0);
    }



}
