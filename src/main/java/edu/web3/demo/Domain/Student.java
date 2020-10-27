package edu.web3.demo.Domain;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private int id;
    @JsonAlias(value = "name")
    private String name;
    @JsonAlias(value = "password")
    private String password;
    @JsonAlias(value = "major")
    private String major;
    @JsonAlias(value = "email")
    private String email;
    //test
    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMajor() {
        return major;
    }

    public String getEmail() {
        return email;
    }
}
