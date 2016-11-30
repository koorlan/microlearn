package com.microlearn.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("STUDENT")
public class Student extends Account {

}
