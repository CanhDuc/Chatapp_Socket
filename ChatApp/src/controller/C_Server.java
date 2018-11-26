/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.Server;

/**
 *
 * @author Duc Canh HNA
 */
public class C_Server {

    private static final int port = 8000;
    public static ServerSocket server;
    public static Socket socket;
    public static String rev_client = "";

    public C_Server() {
        try {
            server = new ServerSocket(port);
            socket = server.accept();
        } catch (IOException ex) {
            Logger.getLogger(C_Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String ServerReceive() {
        try {
            DataInputStream input = new DataInputStream(socket.getInputStream());
            rev_client = input.readUTF();
            return rev_client;
        } catch (IOException ex) {
            Logger.getLogger(C_Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    public static void ServerResponse(String res_server) {
        try {
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());
            output.writeUTF(res_server);
        } catch (IOException ex) {
            Logger.getLogger(C_Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
