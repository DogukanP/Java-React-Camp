package com.padel.Abstract;

import com.padel.Entities.Campaign;
import com.padel.Entities.Customer;
import com.padel.Entities.Game;
import com.padel.Entities.Operation;

public interface OperationService {
    void add(Customer customer, Game game, Campaign campaign);
    void cancel(Operation operation);
    void message(Operation operation);
}
