package com.microlearn.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("TEACHER")
public class Teacher extends Account {

}
