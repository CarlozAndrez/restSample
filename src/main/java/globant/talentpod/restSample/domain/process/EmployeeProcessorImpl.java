package globant.talentpod.restSample.domain.process;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import globant.talentpod.restSample.domain.payroll.Employee;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class EmployeeProcessorImpl implements EmployeeProcessor {


    @Value("${amazonProperties.bucketName}")
    private String bucketName;

    @Override
    public void storeEmployee(String employeeInfo) throws IOException {
        Employee employee = mapFromMessage(employeeInfo);

        AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                .withRegion(Regions.US_EAST_2)
                .build();
        s3Client.putObject(bucketName, employee.getId() + "_" + employee.getName(), employee.toString());

    }

    public Employee mapFromMessage(String message) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(message, Employee.class);
    }
}
