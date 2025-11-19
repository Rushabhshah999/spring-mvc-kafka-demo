package com.company;


import lombok.Data;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.util.List;

@Data
public class User {

    private String status;
    private DataWrapper data;

    @Data
    public static class DataWrapper {
        private UserDetails userDetails;
        private String timestamp;
    }

    @Data
    public static class UserDetails {
        private int id;

        @NotBlank(message = "Name is required")
        private String name;
        @Min(value = 0, message = "Age cannot be negative")
        private int age;
        private Address address;
        private List<String> roles;

        @Data
        public static class Address {
            private String street;
            private String city;
            private String zip;
        }
    }
}