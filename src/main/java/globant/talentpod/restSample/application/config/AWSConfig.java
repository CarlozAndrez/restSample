package globant.talentpod.restSample.application.config;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.sqs.AmazonSQSAsyncClient;
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AWSConfig {

    @Value("${amazonProperties.endpointUrl}")
    private String amazonSqsEndpoint;

    @Value("${amazonProperties.region}")
    private String amazonRegion;

    @Bean
    @Primary
    public AmazonSQSAsyncClient amazonSQSAsyncClient() {

        AmazonSQSAsyncClient amazonSQSAsyncClient = (AmazonSQSAsyncClient) AmazonSQSAsyncClientBuilder.standard()
                .withCredentials(new ProfileCredentialsProvider())
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(amazonSqsEndpoint, amazonRegion))
                .build();
        return amazonSQSAsyncClient;

    }

}