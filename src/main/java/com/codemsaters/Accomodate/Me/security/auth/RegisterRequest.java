package com.codemsaters.Accomodate.Me.security.auth;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {

    private String fullname;

    private String email;

    private String password;
    private String name;
    private String slogan;
    private int regNo;
    private int totalNumberOfRooms;
    private String phoneNumber;
    private int totalNumberOfSingleRooms;
    private int totalNumberOfDoubleRooms;
    private List<String> utility = new ArrayList<>();
    private String profileImage;
    private List<String> images = new ArrayList<>();
    private String nsfasDocument;

}
