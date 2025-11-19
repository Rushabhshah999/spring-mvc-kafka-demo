package com.company;


import lombok.Data;
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
        private String name;
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