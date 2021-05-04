package com.padel;

import com.padel.Adapters.ValidationService;
import com.padel.Concrete.CampaignManager;
import com.padel.Concrete.CustomerManager;
import com.padel.Concrete.GameManager;
import com.padel.Concrete.OperationManager;
import com.padel.Entities.Campaign;
import com.padel.Entities.Customer;
import com.padel.Entities.Game;

public class Main {

    public static void main(String[] args) {
        CustomerManager customerManager = new CustomerManager(new ValidationService());
        Customer dogukan = new Customer(1,"d.padel@outlook.com","Doğukan","Padel",22,"123456789");
        customerManager.login(dogukan);
        customerManager.edit(dogukan);
        customerManager.delete(dogukan);
        GameManager gameManager = new GameManager();
        Game game = new Game(1,"GTA",49.90);
        gameManager.add(game);
        gameManager.delete(game);
        gameManager.update(game);
        CampaignManager campaignManager = new CampaignManager();
        Campaign campaign = new Campaign(1,"Yaz Kampanyası",20);
        campaignManager.add(campaign);
        campaignManager.update(campaign);
        campaignManager.delete(campaign);
        OperationManager operationManager = new OperationManager();
        operationManager.add(dogukan,game,campaign);

    }
}
