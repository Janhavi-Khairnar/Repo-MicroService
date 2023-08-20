package com.igc.customerservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int oid;
    private String date;
    private String items;
    private int amount;
    private int cid;

    //@ManyToOne
    //@JoinColumn(name = "cid")
    //private Customer customer;



}
