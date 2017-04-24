package es.uniovi.asw.producers;

import javax.annotation.ManagedBean;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import es.uniovi.asw.domain.Proposal;

@ManagedBean
public class KafkaProposalProducer {

	 private static final Logger logger = Logger.getLogger(KafkaProducer.class);

	    @Autowired
	    private KafkaTemplate<String, Proposal> kafkaTemplate;	 
	    
	    @Autowired
	    private MockProposalGenerator generator;
	    
	    @Scheduled(cron = "*/5 * * * * *")
	    public void send() {
	    	
	    	Proposal proposal = generator.generate();
	    	
	        ListenableFuture<SendResult<String, Proposal>> future = kafkaTemplate.send("exampleTopic", proposal);
	        future.addCallback(new ListenableFutureCallback<SendResult<String, Proposal>>() {
	            @Override
	            public void onSuccess(SendResult<String, Proposal> result) {
	                logger.info("Success on sending proposal object \"" + proposal + "\"");
	            }

	            @Override
	            public void onFailure(Throwable ex) {
	                logger.error("Error on sending message \"" + proposal   + "\", stacktrace " + ex.getMessage());
	            }
	        });
	    }
	    
}
