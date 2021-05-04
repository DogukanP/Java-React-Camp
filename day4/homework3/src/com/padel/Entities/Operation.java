package com.padel.Entities;

import com.padel.Abstract.Entity;

public class Operation implements Entity {
    private int id;
    private int gameId;
    private int customerId;
    private int campaignId;

    public Operation() {
    }

    public Operation(int id, int gameId, int customerId, int campaignId) {
        this.id = id;
        this.gameId = gameId;
        this.customerId = customerId;
        this.campaignId = campaignId;
    }
    public Operation(int id, int gameId, int customerId) {
        this.id = id;
        this.gameId = gameId;
        this.customerId = customerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(int campaignId) {
        this.campaignId = campaignId;
    }
}
