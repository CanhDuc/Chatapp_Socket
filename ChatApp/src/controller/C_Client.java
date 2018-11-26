/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.Client;

/**
 *
 * @author Duc Canh HNA
 */
public class C_Client {

    private static final int port = 8000;
    private static final String serverName = "localhost";
    public static Socket socket;
    public static String rev_server = "";

    public C_Client() {
        try {
            socket = new Socket(serverName, port);
        } catch (IOException ex) {
            Logger.getLogger(C_Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void clientRequest(String req_client) {
        try {
            DataOutputStream request = new DataOutputStream(socket.getOutputStream());
            request.writeUTF(req_client);
        } catch (IOException ex) {
            Logger.getLogger(C_Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String clientReceive() {
        try {
            DataInputStream input = new DataInputStream(socket.getInputStream());
            rev_server = input.readUTF();
            return rev_server;
        } catch (IOException ex) {
            Logger.getLogger(C_Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
}
