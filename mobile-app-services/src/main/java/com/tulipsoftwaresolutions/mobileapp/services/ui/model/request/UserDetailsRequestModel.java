package com.tulipsoftwaresolutions.mobileapp.services.ui.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDetailsRequestModel {
    @NotNull(message = "First Name can not be null")
    private String firstName;

    @NotNull(message = "Last Name can not be null")
    private String lastName;

    @NotNull(message = "Email can not be null")
    @Email
    private String email;

    @NotNull(message = "Password can not be null")
    @Size(min = 8, max = 16, message = "password can not be within 8 to 16 character range")
    private String password;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
