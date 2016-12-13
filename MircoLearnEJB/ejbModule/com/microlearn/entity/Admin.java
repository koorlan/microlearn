package com.microlearn.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(com.microlearn.type.TAccount.ADMIN)
public class Admin extends Account{

}
