package com.padel.Abstract;

import com.padel.Entities.Customer;
import org.apache.axis.AxisFault;

public interface CustomerCheckService {
    boolean personIsReal(Customer customer);
}
