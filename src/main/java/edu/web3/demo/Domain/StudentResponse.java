package edu.web3.demo.Domain;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponse {
    private String code;



    public void setCode(String code) {
        this.code = code;
    }
}
