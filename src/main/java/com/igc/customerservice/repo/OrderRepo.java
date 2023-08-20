package com.igc.customerservice.repo;

import com.igc.customerservice.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Orders, Integer> {


    //Custom Query
    @Query(nativeQuery = true, value="SELECT * FROM ORDERS WHERE CID=:custid")
    List<Orders> findOrdersByCid(@Param ("custid") int custid);
}
