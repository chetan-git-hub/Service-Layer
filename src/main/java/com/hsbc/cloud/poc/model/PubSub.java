package com.hsbc.cloud.poc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class PubSub {
	
	private String id;
	private String resourcePubSubTopic;
	private String resourcePubSubTopicDeadLetter;
	private String resourcePubSubSubscription;
	private String pubSubTopicName;	
    private String pubSubTopicDeadLetterName;
    private String pubSubSubscriptionName;
    private String topic;
    private String dead_letter_topic;
    private String max_delivery_attempts;
    
    @Id
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getResourcePubSubTopic() {
		return resourcePubSubTopic;
	}

	public void setResourcePubSubTopic(String resourcePubSubTopic) {
		this.resourcePubSubTopic = resourcePubSubTopic;
	}

	public String getResourcePubSubTopicDeadLetter() {
		return resourcePubSubTopicDeadLetter;
	}

	public void setResourcePubSubTopicDeadLetter(String resourcePubSubTopicDeadLetter) {
		this.resourcePubSubTopicDeadLetter = resourcePubSubTopicDeadLetter;
	}

	public String getResourcePubSubSubscription() {
		return resourcePubSubSubscription;
	}

	public void setResourcePubSubSubscription(String resourcePubSubSubscription) {
		this.resourcePubSubSubscription = resourcePubSubSubscription;
	}

	public String getPubSubTopicName() {
		return pubSubTopicName;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public void setPubSubTopicName(String pubSubTopicName) {
		this.pubSubTopicName = pubSubTopicName;
	}

	public String getPubSubTopicDeadLetterName() {
		return pubSubTopicDeadLetterName;
	}

	public void setPubSubTopicDeadLetterName(String pubSubTopicDeadLetterName) {
		this.pubSubTopicDeadLetterName = pubSubTopicDeadLetterName;
	}

	public String getPubSubSubscriptionName() {
		return pubSubSubscriptionName;
	}

	public void setPubSubSubscriptionName(String pubSubSubscriptionName) {
		this.pubSubSubscriptionName = pubSubSubscriptionName;
	}

	public String getDead_letter_topic() {
		return dead_letter_topic;
	}

	public void setDead_letter_topic(String dead_letter_topic) {
		this.dead_letter_topic = dead_letter_topic;
	}

	public String getMax_delivery_attempts() {
		return max_delivery_attempts;
	}

	public void setMax_delivery_attempts(String max_delivery_attempts) {
		this.max_delivery_attempts = max_delivery_attempts;
	}

	
	@Override
	public String toString() {
		
		return 	"\r\n # Create a Pub-Sub" +
				"\r\n # Create a pub-sub topic" +
        		"\r\n resource "+ resourcePubSubTopic +" { " +        		
        		"\r\n name = \""+ pubSubTopicName + "\"" +
        		"\r\n }" +
        		"\r\n # Create a pub-sub topic dead letter" +
        		"\r\n resource "+ resourcePubSubTopicDeadLetter +" { " +
        		"\r\n name = \""+ pubSubTopicDeadLetterName + "\"" +        		
        		"\r\n }" +
        		"\r\n # Create a pub-sub subscription" +
        		"\r\n resource "+ resourcePubSubSubscription +" { " +        		
        		"\r\n name = \""+ pubSubSubscriptionName + "\"" +
        		"\r\n topic = \""+ topic + "\"" +        		
        		"\r\n dead_letter_policy { " +
        		"\r\n dead_letter_topic = \""+ dead_letter_topic + "\"" +
        		"\r\n max_delivery_attempts = \""+ max_delivery_attempts + "\"" +
        		"\r\n  }"+
        		"\r\n }";
		}
	
	
	
}
