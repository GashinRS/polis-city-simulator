package simulation;

import javafx.scene.paint.Color;
import polis.MouseMovementTracker;
import tiles.bigPictureTile.CommerceTile;

import java.util.Properties;

public class Trader extends Actor{

    private final CommerceTile shop;

    public Trader(MouseMovementTracker mouseMovementTracker, int r, int k, Properties engineProperties, CommerceTile shop) {
        super(mouseMovementTracker, r, k, engineProperties);
        this.shop=shop;
        shop.addTrader(this);
        setFill(Color.TRANSPARENT);
        setAge(Integer.parseInt(engineProperties.getProperty("trader.age")));
    }

    @Override
    public void act() {
        setAge(getAge()-1);
        if (getAge() == 0){
            shop.removeTrader(this);
            Shopper shopper = new Shopper(getMouseMovementTracker(), getHomeLocation().getKey(),
                    getHomeLocation().getValue(), getEngineProperties());
            setNewActor(shopper);
        }
    }

    @Override
    public boolean isValid() {
        return getAge() > 0;
    }
}