package globant.talentpod.restSample.adapters.queue;

import globant.talentpod.restSample.domain.process.EmployeeProcessorImpl;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.config.annotation.EnableSqs;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@EnableSqs
@Slf4j
public class QueueSqsListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(QueueSqsListener.class);

    @Autowired
    EmployeeProcessorImpl employeeProcessor;

    @SqsListener(value = "${amazonProperties.queueName}")
    public void listen(String messageReaded) throws IOException {
        LOGGER.info("!!!! received employee : {} ", messageReaded);
        employeeProcessor.storeEmployee(messageReaded);
    }
}
