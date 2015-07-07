/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.dpc.edu.javase.demo.annotation;

import hu.dpc.edu.javase.demo.generics.DAO;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 *
 * @author IQJB
 */
public class ProxyFactory {

    public <T> T createProxy(final T original, Class<T> type) {
        T proxy;
        proxy = (T) Proxy.newProxyInstance(ProxyFactory.class.getClassLoader(), new Class[]{type}, new InvocationHandler() {
            
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("calling " + method + " with params " + Arrays.toString(args));
                
                Method origMethod = original.getClass().getDeclaredMethod(method.getName(), method.getParameterTypes());
                RolesAllowed rolesAllowed = origMethod.getAnnotation(RolesAllowed.class);
                if (rolesAllowed != null) {
                    if (Arrays.asList(rolesAllowed.value()).contains(Role.ADMIN)) {
                        throw new IllegalAccessException("Not allowed for non-admins");
                    }
                }
                
                long startTime = System.nanoTime();
                try {
                    return method.invoke(original, args);
                } finally {
                    long endTime = System.nanoTime();
                    System.out.println("call succeeded in " + (endTime - startTime) + " ns");
                }
            }
        });
        return proxy;
    }

}
