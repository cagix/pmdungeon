package de.pmdungeon.desktop;


import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import de.pmdungeon.game.Controller.MainController;
import de.pmdungeon.game.GameSetup;
import de.pmdungeon.tools.Constants;

import org.apache.commons.cli.*;

public class DesktopLauncher {

	
    /**
     * Runs the dungeon.
     *
     * @param mc MainController of the Dungeon
     * @param args Launch parameters to override the default values
     */
    public static void run(MainController mc, String[] args) {
    	
    	Options options = new Options();
    	
    	Option height = new Option("h", "height", true, "window height in px");
    	Option width = new Option("w", "width", true, "window width in px");
    	Option ptl = new Option("ptl", "pathToLevel", true, "path to level");
    	Option sl = new Option("sl", "startLevel", true, "stat level");
    	Option fps = new Option("fr", "framerate", true, "framerate");
    	Option virtualHeight = new Option("vh", "virtualHeight", true, "Virtual height");
    	Option resizable = new Option("re", "resizable", true, "Resizable true/false, defaults to false");
    	Option fullscreen = new Option("fs", "fullscreen", true, "Fullscreen true/false, defaults to false");
    	CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        CommandLine cmd = null;
    	
        try {
        	cmd = parser.parse(options, args);
        }catch(ParseException e){
            System.out.println(e.getMessage());
            formatter.printHelp("utility-name", options);

            System.exit(1);
        }
    	
        
        if(cmd.hasOption("h")) {
            try {
				Constants.setHeight((int) cmd.getParsedOptionValue("height"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        if(cmd.hasOption("w")) {
            try {
				Constants.setWidth((int) cmd.getParsedOptionValue("width"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        if(cmd.hasOption("ptl")) {
            try {
				Constants.setPathToLevel((String) cmd.getParsedOptionValue("ptl"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        if(cmd.hasOption("sl")) {
            try {
				Constants.setStartLevel((String) cmd.getParsedOptionValue("sl"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        if(cmd.hasOption("fr")) {
            try {
				Constants.setFrameRate((int) cmd.getParsedOptionValue("fr"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        if(cmd.hasOption("vh")) {
            try {
				Constants.setVirtualHeight((int) cmd.getParsedOptionValue("vh"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        if(cmd.hasOption("re")) {
        	if(cmd.getOptionValue("re")=="true") {
                Constants.setResizable(true);
        	}
        }
        if(cmd.hasOption("fs")) {
        	if(cmd.getOptionValue("fs")=="true") {
                Constants.setFullscreen(true);
        	}
        }
        
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();

        config.setTitle(Constants.getWindowname());
        config.setForegroundFPS(Constants.getFrameRate());
        //appropiately sets borderless window mode if toggled
        if(Constants.isFullscreen()) {
        	config.setFullscreenMode(Lwjgl3ApplicationConfiguration.getDisplayMode());
        }else {
            config.setWindowedMode(Constants.getWidth(), Constants.getHeight());
            config.setResizable(Constants.isResizable());
        }
        new Lwjgl3Application(new GameSetup(mc), config);
    }


}
