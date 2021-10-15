package com.app.kinesis.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.cloudwatch.CloudWatchAsyncClient;
import software.amazon.awssdk.services.dynamodb.DynamoDbAsyncClient;
import software.amazon.awssdk.services.kinesis.KinesisAsyncClient;
import software.amazon.kinesis.common.ConfigsBuilder;
import software.amazon.kinesis.common.KinesisClientUtil;

@Configuration
public class ClientConfiguration {

    @Value("${aws.access.key}")
    private String accessKey;

    @Value("${aws.secret.key}")
    private String secretKey;

    @Bean
    public Region region(){
        return Region.US_WEST_2;
    }

    @Bean
    public KinesisAsyncClient kinesisAsyncClient(){

        AwsCredentials awsCreds = AwsBasicCredentials.create(accessKey,
                secretKey);
        AwsCredentialsProvider awsCredential = StaticCredentialsProvider.create(awsCreds);
        KinesisAsyncClient kinesisClient = KinesisClientUtil.createKinesisAsyncClient(
                KinesisAsyncClient.builder().credentialsProvider(awsCredential).region( region ()));

      return kinesisClient;
    }

    @Bean
    public DynamoDbAsyncClient dynamoDbAsyncClient() {
        return DynamoDbAsyncClient.builder ( ).region ( region() ).build ( );
    }

    @Bean
    public CloudWatchAsyncClient cloudWatchAsyncClient(){
        return  CloudWatchAsyncClient.builder().region(region()).build();
    }


}
