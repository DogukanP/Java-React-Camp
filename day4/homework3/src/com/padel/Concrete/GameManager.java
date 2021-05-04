package com.padel.Concrete;

import com.padel.Abstract.GameService;
import com.padel.Entities.Game;

public class GameManager implements GameService {
    @Override
    public void add(Game game) {
        System.out.println(game.getName() + " adlı oyun kaydedildi.");
    }

    @Override
    public void update(Game game) {
        System.out.println(game.getName() + " adlı oyun güncellendi.");
    }


    @Override
    public void delete(Game game) {
        System.out.println(game.getName() + " adlı oyun kaldırıldı.");
    }

}
