package com.hobbyprojects.userservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;

/**
 * @author Depinder Kaur
 * @version 0.1
 * <h2>PatchUserRequest</h2>
 * @date 2024-04-02
 */
public class PatchUserRequest {

    @JsonProperty(value = "first_name")
    @NotEmpty(message = "First name can not be null or empty")
    private String firstName;

    @JsonProperty(value = "last_name")
    @NotEmpty(message = "Last name can not be null or empty")
    private String lastName;

    @JsonProperty(value = "email")
    @NotEmpty(message = "Email can not be null or empty")
    private String email;

    public PatchUserRequest() {
    }

    public PatchUserRequest(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

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
}
