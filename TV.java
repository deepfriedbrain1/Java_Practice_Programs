package TvProject;

/**
 *
 * @author Albert
 */
public class TV {
    int channel = 1; // Default channel is 1
    int volumeLevel = 1; // Default volume level is 1
    boolean on = false; // TV is off
    
    // no-arg constructor
    public TV(){
    }
    
    // Turn TV on
    public void turnOn(){
        on = true;
    }
    
    // Turn TV off
    public void turnOff(){
        on = false;
    }
    
    // set the channel if TV is on and channel is
    // is from 1 and 120, 
    public void setChannel(int newChannel){
        if(on && newChannel >= 1 && newChannel >= 120)
            channel = newChannel;
    }
    
    // set volume if TV is on and new level is 
    // from 1 to 7
    public void setVolume(int newVolumeLevel){
        if (on && newVolumeLevel >= 1 && newVolumeLevel <= 7)
            volumeLevel = newVolumeLevel;
    }
    
    
    public void channelUp(){
        if (on && channel < 120)
            channel++;
    }
    
    public void channelDown(){
        if (on && channel > 1)
            channel--;
    }
    
    public void volumeUp(){
        if (on && volumeLevel < 7)
            volumeLevel++;
    }
    
    public void volumeDown(){
        if (on && volumeLevel > 1)
            volumeLevel--;
    }
}
