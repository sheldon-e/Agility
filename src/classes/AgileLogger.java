/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sheldon
 */
public class AgileLogger {
    public static Logger loggerHandler(Logger LOGGER){
        Handler consoleHandler;
        Handler fileHandler;
        try{
            consoleHandler = new ConsoleHandler();
            fileHandler = new FileHandler("logs/agility.jump", 10 * 1024 * 1024, 10);
            //Assigning Handler to logger
            LOGGER.addHandler(fileHandler);
            LOGGER.addHandler(consoleHandler);
            
            //Set Logging Levels
            consoleHandler.setLevel(Level.ALL);
            fileHandler.setLevel(Level.ALL);
            LOGGER.setLevel(Level.ALL);
            LOGGER.config("Agile Logger is Operating. . .");
        }catch(IOException | SecurityException ex){
            LOGGER.log(Level.SEVERE,"Exception Occurred Loading Agile Logger!", ex);
        }
        return LOGGER;
    }
}
