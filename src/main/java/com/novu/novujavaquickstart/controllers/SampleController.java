package com.novu.novujavaquickstart.controllers;

import co.novu.api.common.SubscriberRequest;
import co.novu.api.subscribers.requests.UpdateSubscriberRequest;
import co.novu.api.subscribers.responses.CreateSubscriberResponse;
import co.novu.api.subscribers.responses.SingleSubscriberResponse;
import com.novu.novujavaquickstart.service.NovuSample;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/novu")
@RequiredArgsConstructor
public class SampleController {

    private final NovuSample novuSample;

    @PostMapping
    public ResponseEntity<CreateSubscriberResponse> createSubscriber(@RequestBody SubscriberRequest request){
        return new ResponseEntity<>(novuSample.createSubscriber(request), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<SingleSubscriberResponse> updateSubscriber(@RequestBody UpdateSubscriberRequest request, @PathVariable String subscriberId){
        return new ResponseEntity<>(novuSample.updateSubscriber(request, subscriberId), HttpStatus.CREATED);
    }



}
