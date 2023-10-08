package com.ecommerce.productcatalog.api.inheritance.tableperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Entity(name = "tpc_mentor")
public class Mentor extends User{
    private int numberOfSessions;
    private int numberOfMentees;
}
