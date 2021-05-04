package com.padel.Concrete;

import com.padel.Abstract.CampaignService;
import com.padel.Entities.Campaign;

public class CampaignManager implements CampaignService {
    @Override
    public void add(Campaign campaign) {
        System.out.println(campaign.getName() + " adlı kampanya oluşturuldu.");
    }

    @Override
    public void update(Campaign campaign) {
        System.out.println(campaign.getName() + " adlı kampanya güncellendi.");
    }

    @Override
    public void delete(Campaign campaign) {
        System.out.println(campaign.getName() + " adlı kampanya kaldırıldı.");
    }
}
