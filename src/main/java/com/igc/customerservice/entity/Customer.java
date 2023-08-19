package com.igc.customerservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.LifecycleState;

import java.util.List;


@Data
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cid;
    private String cname;
    private String phoneNo;

    @OneToMany(cascade = CascadeType.ALL)
    public List<Orders> ordersList;

    public Customer(int cid, String cname, String phoneNo) {
        this.cid = cid;
        this.cname = cname;
        this.phoneNo = phoneNo;
    }

    public Customer(int cid, String cname, String phoneNo, List<Orders> ordersList) {
        this.cid = cid;
        this.cname = cname;
        this.phoneNo = phoneNo;
        this.ordersList = ordersList;
    }
}
