package com.aeq;

import java.io.*;
import java.net.*;

public class EchoClient
{
    public static void main(String[] args)
    {
        try
        {
            Socket s = new Socket("127.0.0.1", 9999);   // connect to server

            BufferedReader r = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter w = new PrintWriter(s.getOutputStream(), true);

            BufferedReader con = new BufferedReader(new InputStreamReader(System.in));
            String line;
            do
            {
                line = r.readLine();        // reading from server
                if ( line != null )
                    System.out.println(line);
                line = con.readLine();      // get input from user
                w.println(line);            // send to server
            }
            while ( !line.trim().equals("bye") );
        }
        catch (Exception err)
        {
            System.err.println(err);
        }
    }
}
