package lt.vu.services;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Specializes;
import java.text.SimpleDateFormat;
import java.util.Date;

@Specializes
@ApplicationScoped
public class DoublePrefixedGenerator extends PrefixedGenerator {
    @Override
    public String getOrderNumber() {
        return "Dbl" + super.getOrderNumber();
    }
}
