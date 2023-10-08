package com.ecommerce.productcatalog.api.inheritance.singleclass;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "sct_mentor")
@DiscriminatorValue("3")
public class Mentor extends User {
    private int numberOfSessions;
    private int numberOfMentees;
}
