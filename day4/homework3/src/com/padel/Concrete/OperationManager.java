package com.padel.Concrete;

import com.padel.Abstract.OperationService;
import com.padel.Entities.Campaign;
import com.padel.Entities.Customer;
import com.padel.Entities.Game;
import com.padel.Entities.Operation;

public class OperationManager implements OperationService {

    @Override
    public void add(Customer customer, Game game, Campaign campaign) {
        Operation operation;
        operation = campaign != null ? new Operation(0,game.getId(),customer.getId(),campaign.getId()) : new Operation(0,game.getId(),customer.getId());
        message(operation);
    }

    @Override
    public void cancel(Operation operation) {
        System.out.println("Satın alma işlemi iptal edildi.");
    }

    @Override
    public void message(Operation operation) {
        System.out.println("Satın alma işlemi başarıyla gerçekleşti.");
    }
}
