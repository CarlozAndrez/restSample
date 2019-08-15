package globant.talentpod.restSample.application.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sqs.AmazonSQSAsyncClient;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AWSConfig {

    @Value("${amazonProperties.accesskey}")
    private String amazonAWSAccessKey;

    @Value("${amazonProperties.secretKey}")
    private String amazonAWSSecretKey;

    @Value("${amazonProperties.endpointUrl}")
    private String amazonSqsEndpoint;

    @Bean
    @Primary
    public AmazonSQSAsyncClient amazonSQSAsyncClient() {

        AmazonSQSAsyncClient amazonSQSAsyncClient = new AmazonSQSAsyncClient(amazonAWSCredentials());
        if (!StringUtils.isEmpty(amazonSqsEndpoint)) {
            amazonSQSAsyncClient.setEndpoint(amazonSqsEndpoint);
        }

        return amazonSQSAsyncClient;

    }

    @Bean
    public AWSCredentials amazonAWSCredentials() {
        return new BasicAWSCredentials(amazonAWSAccessKey, amazonAWSSecretKey);
    }
}