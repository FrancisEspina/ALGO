import javax.swing.*;
import java.awt.*;

public class ALGO extends javax.swing.JFrame {
    public static JFrame mainFrame = new JFrame();
    public static JPanel mainPanel = new JPanel();
    public static CardLayout card = new CardLayout();

    public static MainMenu mainMenu = new MainMenu();
    public static SplashScreen splashScreen = new SplashScreen();
    public static About about = new About();
    public static Help help = new Help();
    public static Select select = new Select();
    public static Input input = new Input();
    public static Results results = new Results();
    
    public static boolean sound = true;
    
    public ALGO() {
        mainFrame.setSize(1280, 720);
        mainFrame.setTitle("Terminated");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setUndecorated(true);
        
        mainPanel.setLayout(card);
        mainPanel.add(mainMenu, "1");
        mainPanel.add(splashScreen, "2");
        mainPanel.add(about, "3");
        mainPanel.add(help, "4");
        mainPanel.add(select, "5");
        mainPanel.add(input, "6");
        mainPanel.add(results, "7");
        
        mainFrame.add(mainPanel);
        mainFrame.pack();
        
        mainFrame.setVisible(true);
        mainFrame.setLocationRelativeTo(null);
        
        card.show(mainPanel, "2");
        Music.bgMusic();
        
        new java.util.Timer().schedule(new java.util.TimerTask() {
            @Override
            public void run() {
                card.show(mainPanel, "1");
            }
        }, 2 * 1000); // Miliseconds
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ALGO();
            }
        });
    }
}