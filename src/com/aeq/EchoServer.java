package com.aeq;

import java.io.*;
import java.net.*;

public class EchoServer
{
    public EchoServer(int portnum)
    {
        try
        {
            server = new ServerSocket( portnum);  //1. Open Port and Listen

        }
        catch (Exception err)
        {
            System.out.println(err);
        }
    }

    public void serve()
    {
        try
        {
            while (true)
            {
                Socket client = server.accept();    // 2. Wait for Connection 3. When a client is connected

                BufferedReader r = new BufferedReader(new InputStreamReader(client.getInputStream()));

                PrintWriter w = new PrintWriter(client.getOutputStream(), true);
                w.println("Welcome to the Java EchoServer.  Type 'bye' to close.");
                String line;
                do
                {
                    line = r.readLine();    // Reading input from client
                    if ( line != null )
                        w.println("Got: "+ line);   // sending response to client
                }
                while ( !line.trim().equals("bye") );
                client.close();
            }
        }
        catch (Exception err)
        {
            System.err.println(err);
        }
    }

    public static void main(String[] args)
    {
        EchoServer s = new EchoServer(9999);
        s.serve();
    }

    private ServerSocket server;
}
