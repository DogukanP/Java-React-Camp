package com.padel.Adapters;

import com.padel.Abstract.CustomerCheckService;
import com.padel.Entities.Customer;
import com.padel.mypackage.KPSPublicSoap12Stub;
import com.padel.mypackage.KPSPublicSoap_PortType;
import org.apache.axis.AxisFault;

import java.rmi.RemoteException;

public class MernisServiceAdapter implements CustomerCheckService {
    @Override
    public boolean personIsReal(Customer customer){
        KPSPublicSoap_PortType client = null;
        try {
            client = new KPSPublicSoap12Stub();
        } catch (AxisFault axisFault) {
            axisFault.printStackTrace();
        }
        boolean result = false;
        try {
            result = client.TCKimlikNoDogrula(new Long(customer.getNationalId()), customer.getFirstName().toUpperCase(), customer.getLastName().toUpperCase(),customer.getBirthDate().getYear() );
        }catch (NumberFormatException e){
            e.printStackTrace();
        }catch (RemoteException e){
            e.printStackTrace();
        }
        return result;
    }
}

/*




    @Override
    public boolean personIsReal(Customer customer) {
        KPSPublicSoap_PortType client = null;
        try {
            client = new KPSPublicSoap_BindingStub();
        } catch (AxisFault axisFault) {
            axisFault.printStackTrace();
        }
        boolean result = false;
        try {
            result = client.TCKimlikNoDogrula(new Long(customer.getNationalId()), customer.getFirstName().toUpperCase(), customer.getLastName().toUpperCase(),customer.getBirthDate().getYear() );
        }catch (NumberFormatException e){
            e.printStackTrace();
        }catch (RemoteException e){
            e.printStackTrace();
        }
        return result;
    }
 */