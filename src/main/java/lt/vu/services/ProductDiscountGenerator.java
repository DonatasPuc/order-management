package lt.vu.services;

import lt.vu.entities.Product;

import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.util.Random;

@ApplicationScoped
public class ProductDiscountGenerator implements Serializable {

    private static int getLinearRandomNumber(int maxSize){
        //Get a linearly multiplied random number
        int randomMultiplier = maxSize * (maxSize + 1) / 2;
        Random r=new Random();
        int randomInt = r.nextInt(randomMultiplier);

        //Linearly iterate through the possible values to find the correct one
        int linearRandomNumber = 0;
        for(int i=maxSize; randomInt >= 0; i--){
            randomInt -= i;
            linearRandomNumber++;
        }

        return linearRandomNumber;
    }

    public Integer calculateProductDiscount(Product product) {
        try {
            Thread.sleep(3000); // Simulate intensive work
        } catch (InterruptedException e) {
        }
        return getLinearRandomNumber(50);
    }
}
