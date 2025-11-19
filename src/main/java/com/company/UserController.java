package com.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private KafkaTemplate<String, User.UserDetails> kafkaTemplate;

    private List<User.UserDetails> userList = new ArrayList<>();

    // GET endpoint returning a list of users (custom object)
    @GetMapping
    public ResponseEntity<List<User.UserDetails>> getAllUsers() {
        return ResponseEntity.ok(userList);
    }

    // POST endpoint creating user, sending to Kafka, and returning the object
    @PostMapping
    public ResponseEntity<List<User.UserDetails>> createUser(@RequestBody User user) {

        User.UserDetails userDetails =  user.getData().getUserDetails();


        System.out.println(">>> POST /users called: " + userDetails);
        userList.add(userDetails);

        // Send user to Kafka
        kafkaTemplate.send(KafkaProducerConfig.TOPIC_NAME, userDetails);

        return ResponseEntity.ok(userList);
    }
}
