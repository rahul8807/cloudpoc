package com.app.kinesis.consumer;

import org.springframework.stereotype.Component;
import software.amazon.kinesis.lifecycle.events.*;
import software.amazon.kinesis.processor.ShardRecordProcessor;
import software.amazon.kinesis.retrieval.KinesisClientRecord;


@Component
public class KCLRecordProcessor implements ShardRecordProcessor {


    @Override
    public void initialize ( InitializationInput initializationInput ) {
        System.out.println ( "Initialize" );
    }

    @Override
    public void processRecords ( ProcessRecordsInput processRecordsInput ) {
        for (KinesisClientRecord record : processRecordsInput.records()) {
            System.out.println (record );
        }
    }

    @Override
    public void leaseLost ( LeaseLostInput leaseLostInput ) {

    }

    @Override
    public void shardEnded ( ShardEndedInput shardEndedInput ) {

    }

    @Override
    public void shutdownRequested ( ShutdownRequestedInput shutdownRequestedInput ) {

    }
}
