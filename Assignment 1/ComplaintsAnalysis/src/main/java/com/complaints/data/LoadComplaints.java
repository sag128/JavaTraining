package com.complaints.data;

import com.complaints.entity.Complaints;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class LoadComplaints {






    public static List<Complaints> fetch(Path path) {

        List <Complaints> complaints;
        try {

            int initialCapacity = ( int ) Files.lines(path).count();
            complaints = new ArrayList <>( initialCapacity );



            BufferedReader reader = Files.newBufferedReader(path);

            Iterable < CSVRecord > records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse( reader );
            records.forEach(record->{

                LocalDate dateReceived = parseDate(record.get(0));
                String product = record.get(1);
                String subProduct = record.get(2);
                String issue = record.get(3);
                String subIssue = record.get(4);
                String company = record.get(5);
                String state = record.get(6);
                String zipCode = record.get(7);
                String submittedVia = record.get(8);
                LocalDate closedDate = parseDate(record.get(9));
                String companyResponseToCustomer = record.get(10);
                boolean isTimelyResponse = record.get(11).equalsIgnoreCase("yes") ? true : false;
                boolean isConsumerDisputed = record.get(12).equalsIgnoreCase("yes") ? true : false;
                long complaintId = Long.parseLong(record.get(13));

                Complaints complaint = new Complaints( dateReceived , product , subProduct , issue,subIssue,company,state,zipCode,submittedVia,closedDate,companyResponseToCustomer,isTimelyResponse,isConsumerDisputed,complaintId );

                complaints.add(complaint );

            });
            return complaints;
        } catch ( IOException e )
        {
            e.printStackTrace();
            throw new RuntimeException("Error Fetching Records");
        }

    }


    public static LocalDate parseDate(String date) {
        final LocalDate[] parsedDate = new LocalDate[1];
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("MM-dd-yy");
        DateTimeFormatter dateTimeFormatter3 = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        DateTimeFormatter dateTimeFormatter4 = DateTimeFormatter.ofPattern("MM/dd/yy");

        List<DateTimeFormatter> dateTimeFormatters = new ArrayList<>();

        dateTimeFormatters.add(dateTimeFormatter);
        dateTimeFormatters.add(dateTimeFormatter2);
        dateTimeFormatters.add(dateTimeFormatter3);
        dateTimeFormatters.add(dateTimeFormatter4);

        dateTimeFormatters.forEach(dateTimeFormatterEach -> {

            try {
                parsedDate[0] = LocalDate.parse(date, dateTimeFormatterEach);
            }
            catch (Exception e) {}
        } );

        return parsedDate[0];


    }
}
