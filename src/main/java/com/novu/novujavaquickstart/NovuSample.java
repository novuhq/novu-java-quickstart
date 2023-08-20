package com.novu.novujavaquickstart;

import co.novu.api.common.SubscriberRequest;
import co.novu.api.events.requests.TriggerEventRequest;
import co.novu.api.subscribers.requests.UpdateSubscriberRequest;
import co.novu.api.subscribers.responses.CreateSubscriberResponse;
import co.novu.api.subscribers.responses.SingleSubscriberResponse;
import co.novu.api.topics.requests.SubscriberAdditionRequest;
import co.novu.api.topics.requests.TopicRequest;
import co.novu.common.base.Novu;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@Slf4j
public class NovuSample {
        public CreateSubscriberResponse createSubscriber() {
            String apiKey = "API_KEY";
            Novu novu = new Novu(apiKey);

            SubscriberRequest subscriberRequest = new SubscriberRequest();
                    subscriberRequest.setEmail("email");
                    subscriberRequest.setFirstName("fName");
                    subscriberRequest.setLastName("lName");
                    subscriberRequest.setPhone("phone");
                    subscriberRequest.setAvatar("avatar");
                    subscriberRequest.setSubscriberId("subscriberId");
            try {
                return novu.createSubscriber(subscriberRequest);
            }catch (Exception e){
                log.error("Error Triggering Event", e);
            }

            return null;
        }

        public SingleSubscriberResponse updateSubscriber() {
            String apiKey = "API_KEY";
            Novu novu = new Novu(apiKey);

            UpdateSubscriberRequest updateSubscriberRequest = new UpdateSubscriberRequest();
                    updateSubscriberRequest.setEmail("email");
                    updateSubscriberRequest.setFirstName("fName");
                    updateSubscriberRequest.setLastName("lName");
                    updateSubscriberRequest.setPhone("phone");
                    updateSubscriberRequest.setAvatar("avatar");

            String subscriberId = "subscriberId";

            try {
                return novu.updateSubscriber(updateSubscriberRequest, subscriberId);
            }catch (Exception e){
                log.error("Error updating Subscriber", e);
            }

            return null;


        }

        public Object triggerNotification() {
            String apiKey = "API_KEY";
            Novu novu = new Novu(apiKey);

            co.novu.api.events.pojos.SubscriberRequest subscriberRequest = new co.novu.api.events.pojos.SubscriberRequest();
                    subscriberRequest.setSubscriberId("subscriberId");
                    subscriberRequest.setEmail("email;");
                    subscriberRequest.setFirstName("fName");
                    subscriberRequest.setLastName("lName");

            TriggerEventRequest triggerEventRequest = new TriggerEventRequest();
                    triggerEventRequest.setName("name");
                    triggerEventRequest.setTo(subscriberRequest);


            try {
                return novu.triggerEvent(triggerEventRequest);
            }catch (Exception e){
                log.error("Error triggering event", e);
            }

            return null;
        }

        public Object createTopic() {
            String apiKey = "API_KEY";
            Novu novu = new Novu(apiKey);

            TopicRequest createTopicRequest = new TopicRequest();
                    createTopicRequest.setKey("key");
                    createTopicRequest.setName("name");
            try {
                return novu.createTopic(createTopicRequest);
            }catch (Exception e){
                log.error("Error creating Topic", e);
            }

            return null;
        }

        public Object addSubscriberToTopic() {
            String apiKey = "API_KEY";
            Novu novu = new Novu(apiKey);

            String topicKey = "key";
            SubscriberAdditionRequest requestBody = new SubscriberAdditionRequest();
            requestBody.setSubscribers(Collections.singletonList(new SubscriberRequest()));

            try {
                return novu.addSubscriberToTopic(requestBody,topicKey);
            }catch (Exception e){
                log.error("Error Adding Subscriber To Topic", e);
            }

            return null;
        }

        public Object removeSubscriberFromTopic() {
            String apiKey = "API_KEY";
            Novu novu = new Novu(apiKey);

            String topicKey = "key";
            SubscriberAdditionRequest requestBody = new SubscriberAdditionRequest();
            requestBody.setSubscribers(Collections.singletonList(new SubscriberRequest()));

            try {
                return novu.removeSubscriberFromTopic(requestBody, topicKey);
            }catch (Exception e){
                log.error("Error Removing Subscriber From Topic", e);
            }

            return null;
        }


}
