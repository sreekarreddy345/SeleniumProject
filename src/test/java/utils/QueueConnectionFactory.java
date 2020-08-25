package utils;

import com.solacesystems.jms.SupportedProperty;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.Hashtable;

public class QueueConnectionFactory {
    public static void main(String[] args) {
        Hashtable<String, Object> env = new Hashtable<String, Object>();

        env.put(InitialContext.INITIAL_CONTEXT_FACTORY, "com.solacesystems.jndi.SolJNDIInitialContextFactory");
        env.put(InitialContext.PROVIDER_URL, "smf://inteai2.ntrs.com:5555");
        env.put(SupportedProperty.SOLACE_JMS_VPN, "intvpn28");
        env.put(Context.SECURITY_PRINCIPAL, "intmgw@intvpn28");
    }
}
