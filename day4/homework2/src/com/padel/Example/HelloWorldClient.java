package com.padel.Example;

import com.padel.mypackage.KPSPublicLocator;

import javax.management.remote.rmi.RMIConnection;
import javax.xml.rpc.ServiceException;
import java.rmi.RemoteException;

public class HelloWorldClient {
    public static void main(String[] argv) {
        try {
            KPSPublicLocator locator = new KPSPublicLocator();
            RMIConnection service = locator.get();
            // If authorization is required
            //((KPSPublicSoap_BindingStub)service).setUsername("user3");
            //((KPSPublicSoap_BindingStub)service).setPassword("pass3");
            // invoke business method
            service.businessMethod();
        } catch (ServiceException ex) {
            ex.printStackTrace();
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
    }
}

/*
package example;public class HelloWorldClient {
  public static void main(String[] argv) {
      try {
          KPSPublicLocator locator = new KPSPublicLocator();
          RMIConnection service = locator.get();
          // If authorization is required
          //((KPSPublicSoap_BindingStub)service).setUsername("user3");
          //((KPSPublicSoap_BindingStub)service).setPassword("pass3");
          // invoke business method
          service.businessMethod();
      } catch (javax.xml.rpc.ServiceException ex) {
          ex.printStackTrace();
      } catch (java.rmi.RemoteException ex) {
          ex.printStackTrace();
      }
  }
}
 */
