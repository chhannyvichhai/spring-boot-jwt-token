package com.chhai.friendlyjwt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private int userid;
    private String username;
    private String address;
    private String gender;
    private String email;
    private String password;
}
