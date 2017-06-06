/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import classes.AgileLogger;
import dal.DataConnect;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sheldon
 */
public class AgilityServer {

    public static final Logger LOGGER = Logger.getLogger(DataConnect.class.getName());

    public static void main(String args[]) {
        Logger agility = AgileLogger.loggerHandler(LOGGER);
        System.out.println("Server Running...");

        try {
            InetAddress addr = InetAddress.getByName("127.0.0.1");
            ServerSocket serverSocket = new ServerSocket(9615, 50, addr);

            File fileToSend = new File("server/dbconfig.xml");

            while (true) {

                Socket socket = serverSocket.accept();
                byte[] fileSize = new byte[(int) fileToSend.length()];
                FileInputStream fileInputStream = new FileInputStream(fileToSend);
                BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
                bufferedInputStream.read(fileSize, 0, fileSize.length);
                OutputStream outputStream = socket.getOutputStream();
                outputStream.write(fileSize, 0, fileSize.length);
                outputStream.flush();
                bufferedInputStream.close();
                outputStream.close();
                socket.close();
                serverSocket.close();

            }

        } catch (IOException ex) {
            agility.log(Level.SEVERE, null, ex);
        }

    }
}
