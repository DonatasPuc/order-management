package lt.vu.services;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import java.text.SimpleDateFormat;
import java.util.Date;

@Alternative
@ApplicationScoped
public class SequentialGenerator implements OrderNumberGenerator {
    @Override
    public String getOrderNumber() {
        Date currentDate = new Date();

        // Create a SimpleDateFormat object with the desired format
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");

        // Format the date into a string
        String dateString = dateFormat.format(currentDate);

        return dateString;
    }
}
