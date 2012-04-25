package puArcade.princetonTD.game;

public class Mode {
	
	public static final int MODE_SOLO = 0;
    public static final int MODE_VERSUS = 1;
    public static final int MODE_COOP = 2;
    
    public static String getModeName(int mode)
    {
        switch(mode)
        {
            case 0 : return "Solo";
            case 1 : return "Versus";
            case 2 : return "Coop";
        }
        
        return "Unknown";
    }
    
    public static int getMode(String mode)
    {
        if(mode.equals("Solo"))
            return MODE_SOLO;
        else if(mode.equals("Versus"))
            return MODE_VERSUS;
        else if(mode.equals("Coop"))
            return MODE_COOP;
        else
            return -1;
    }

}
