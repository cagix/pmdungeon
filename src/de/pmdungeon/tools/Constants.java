package de.pmdungeon.tools;


public class Constants {
	/**
	 * Default name of the window
	 */
	private static String windowname = "PMDungeon";
	
	/**
	 * Window default height
	 */
	private static int height = 480;
	
	/**
	 * Window default width
	 */
	private static int width = 640;
	
	/**
	 * Default start level of the dungeon
	 */
	private static String startLevel = Constants.pathToLevel+"small_dungeon.json";
	
	/**
	 * Default asset path
	 */
	private static String pathToLevel = "assets/level/";
	
	/**
	 * Default framerate
	 */
	private static int frameRate = 30;
	
	/**
	 * Default virtual height
	 */
	private static float virtualHeight = 5;
	
	/**
	 * Sets if window is resizable, default false
	 */
	private static boolean resizable = false;
	
	/**
	 * Sets whether window should be fullscreen, default false
	 */
	private static boolean fullscreen = false;
	
	/**
	 * @param resizable sets if window is resizable
	 */
    public static void setResizable(boolean resizable) {
    	Constants.resizable = resizable;
    }
    
    /**
     * @return resizable checks whether the window is resizable
     */
    public static boolean isResizable() {
    	return resizable;
    }

    /**
     * 
     * @return windowname returns name of window
     */
	public static String getWindowname() {
		return windowname;
	}


	/**
	 * 
	 * @param windowname sets name of window
	 */
	public static void setWindowname(String windowname) {
		Constants.windowname = windowname;
	}


	/**
	 * 
	 * @return height of window
	 */
	public static int getHeight() {
		return height;
	}


	/**
	 * 
	 * @param height set height of window
	 */
	public static void setHeight(int height) {
		Constants.height = height;
	}


	/**
	 * 
	 * @return width of window
	 */
	public static int getWidth() {
		return width;
	}


	/**
	 * 
	 * @param width set width of window
	 */
	public static void setWidth(int width) {
		Constants.width = width;
	}


	/**
	 * 
	 * @return startLevel returns path and name of starting level
	 */
	public static String getStartLevel() {
		return startLevel;
	}


	/**
	 * 
	 * @param startLevel sets start level filename
	 */
	public static void setStartLevel(String startLevel) {
		Constants.startLevel = Constants.pathToLevel+startLevel;
	}


	/**
	 * 
	 * @return pathToLevel returns path to level assets
	 */
	public static String getPathToLevel() {
		return pathToLevel;
	}


	/**
	 * 
	 * @param pathToLevel sets path to level assets
	 */
	public static void setPathToLevel(String pathToLevel) {
		Constants.pathToLevel = pathToLevel;
	}


	/**
	 * 
	 * @return framerate returns the framerate
	 */
	public static int getFrameRate() {
		return frameRate;
	}


	/**
	 * 
	 * @param frameRate sets the framerate
	 */
	public static void setFrameRate(int frameRate) {
		Constants.frameRate = frameRate;
	}

	/**
	 * 
	 * @return virtualHeight returns virtual height
	 */
	public static float getVirtualHeight() {
		return virtualHeight;
	}

	/**
	 * 
	 * @param virtualHeight sets virtual height
	 */
	public static void setVirtualHeight(float virtualHeight) {
		Constants.virtualHeight = virtualHeight;
	}

	/**
	 * 
	 * @return fullscreen returns whether window is set to be fullscreen
	 */
	public static boolean isFullscreen() {
		return fullscreen;
	}
	
	/**
	 * 
	 * @param fullscreen sets whether window should be fullscreen
	 */
	public static void setFullscreen(boolean fullscreen) {
		Constants.fullscreen = fullscreen;
	}


}
