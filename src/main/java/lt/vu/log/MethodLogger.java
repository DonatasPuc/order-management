package lt.vu.log;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.io.Serializable;

@Interceptor
@LoggedInvocation
public class MethodLogger implements Serializable{
    @AroundInvoke
    public Object logMethodInvocation(InvocationContext context) throws Exception {
        System.out.println("!!! INTERCEPTOR: Called " + context.getMethod().getDeclaringClass().getSimpleName() +
                " method: " + context.getMethod().getName());
        return context.proceed();
    }
}
