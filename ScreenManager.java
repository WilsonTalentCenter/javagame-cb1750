import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

/**
 * Created by dbaker on 1/7/2022.
 */
public class ScreenManager extends JPanel implements KeyListener, ActionListener{

    private HashMap<String, Screen> screenMap;
    private Screen currentScreen;
    public ScreenManager(){
        this.setLayout(null);
        screenMap = new HashMap<>();
        addScreen("titleScreen" , new TitleScreen(),true);
        addScreen("optionsScreen",new OptionsScreen(),false);
        addScreen("playScreen",new PlayScreen(),false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        currentScreen.update();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        currentScreen.draw(g);
    }

    /**
     * will change the screen and call the other screen's unload method
     * @param screenName the new screen to switch to
     * @returns true if successful and false if no screen with name exists.
     */
    public void changeScreen(String screenName){
        if (screenName.equals("exit")){
            for (String key : screenMap.keySet()) {
               removeScreen(key);
               System.exit(0);
            }
        }
        else if(screenMap.containsKey(screenName)) {
            if(currentScreen != null) { //this is to make it work for the first add
                currentScreen.unload(this);
            }
            currentScreen = screenMap.get(screenName);
            currentScreen.load(this);
            this.requestFocus();
        }
    }

    /**
     * adds screen and sets it to active screen
     * @param screenName the name of the screen to add (the key)
     * @param newScreen the new Screen object to be added
     * @param makeActive true if you want to switch to this screen
     * @returns true if added false if name already exists
     */
    public boolean addScreen(String screenName,Screen newScreen, boolean makeActive){
        if(screenMap.containsKey(screenName)){
            return false;
        }
        screenMap.put(screenName,newScreen);
        if(makeActive){
            changeScreen(screenName);
        }
        return true;
    }

    /**
     * calls the screen's remove function and removes screen if it exists
     * if this screen is the currentScreen then it will remain active until changed.
     * @param screenName name of screen to remove
     */
    public void removeScreen(String screenName){
        if(screenMap.containsKey(screenName)) {
            Screen screenToRemove = screenMap.get(screenName);
            screenToRemove.remove();
            screenMap.remove(screenName);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e){
        currentScreen.keyPressed(e);
    }
    public void keyReleased(KeyEvent e){
        currentScreen.keyReleased(e);
    }


}
