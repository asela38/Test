package com.asela.jndi;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

public class JNDITest {

    /** @param args
     */
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        @SuppressWarnings("rawtypes")
        Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY,
                "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldap://localhost:389/o=JNDITutorial");

        try {
            // Create the initial directory context
            DirContext ctx = new InitialDirContext(env);

            // Ask for all attributes of the object
            Attributes attrs = ctx.getAttributes("cn=Ted Geisel, ou=People");

            // Find the surname attribute ("sn") and print it
            System.out.println("sn: " + attrs.get("sn").get());

        } catch (NamingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
