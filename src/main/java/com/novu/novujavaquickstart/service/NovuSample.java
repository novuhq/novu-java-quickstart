package com.novu.novujavaquickstart.service;

import co.novu.api.common.SubscriberRequest;
import co.novu.api.subscribers.requests.UpdateSubscriberRequest;
import co.novu.api.subscribers.responses.CreateSubscriberResponse;
import co.novu.api.subscribers.responses.SingleSubscriberResponse;
import co.novu.common.base.Novu;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NovuSample {

    //Using the API Key only
    String apiKey = "Api-Key";

    public CreateSubscriberResponse createSubscriber(SubscriberRequest request){
        try {
            Novu novu = new Novu(apiKey);
            return novu.createSubscriber(request);
        }catch (Exception e){
            log.error("Error creating subscriber Event", e);
        }
        return null;

    }

    public SingleSubscriberResponse updateSubscriber(UpdateSubscriberRequest request,  String subscriberId){
        try {
            Novu novu = new Novu(apiKey);
            return novu.updateSubscriber(request, subscriberId);
        }catch (Exception e){
            log.error("Error creating subscriber Event", e);
        }
        return null;

    }


}
