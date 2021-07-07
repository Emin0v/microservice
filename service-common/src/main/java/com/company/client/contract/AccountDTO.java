package com.company.client.contract;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountDTO {
    private String id;
    private String username;
    private String name;
    private String surname;
    private String email;
    private Date birthDate;
    private String password;
    private Date createdAt;
    private Boolean active;


    public String getNameSurname(){
        return this.name + " " + this.surname;
    }
}
