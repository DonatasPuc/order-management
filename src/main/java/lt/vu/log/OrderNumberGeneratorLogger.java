package lt.vu.log;

import lt.vu.services.OrderNumberGenerator;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

@Decorator
public class OrderNumberGeneratorLogger implements OrderNumberGenerator {
    @Inject
    @Delegate
    private OrderNumberGenerator orderNumberGenerator;

    @Override
    public String getOrderNumber() {
        String orderNumber = orderNumberGenerator.getOrderNumber();
        System.out.println("Order number generated: " + orderNumber);
        return orderNumber;
    }
}
