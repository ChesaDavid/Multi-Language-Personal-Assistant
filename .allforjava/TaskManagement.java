import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.lang.*;
public class TaskKiller {
@SuppressWarnings("IndexOfReplaceableByContains")
public static void main(String[] args) {
    JOptionPane pane = new JOptionPane();
    String userInput1 = JOptionPane.showInputDialog("Hours: "); 
    String userInput2 = JOptionPane.showInputDialog("Minutes: ");
    String userInput3 = JOptionPane.showInputDialog("Seconds: ");
    long inputHours = Long.parseLong(userInput1);
    long inputMinutes = Long.parseLong(userInput2);
    long inputSeconds = Long.parseLong(userInput3);
    long hours = inputHours * 3600000;
    long minutes = inputMinutes * 60000;
    long seconds = inputSeconds * 1000;
    long time = (hours + minutes) + seconds;
    String OS = System.getProperty("os.name").toLowerCase();
 int run = 1;   



while (run > 0){
 JOptionPane.showMessageDialog(null,"Program names: chrome, firefox, safari, gta, csgo", "Info", JOptionPane.INFORMATION_MESSAGE);
    String prog = JOptionPane.showInputDialog("Program: ");
    String gta="gta";
    String chrome="chrome";
    String firefox="firefox";     
    String safari="safari";   
    String csgo="csgo";       
    int gt=prog.compareTo(gta);
    int ch=prog.compareTo(chrome);
    int fi=prog.compareTo(firefox);
    int sa=prog.compareTo(safari);
    int cs=prog.compareTo(csgo);

if (gt == 0) {
    if(OS.indexOf("win") >= 0){
    try {
        TimeUnit.MILLISECONDS.sleep(time);
    Runtime.getRuntime().exec("cmd /c Taskkill /IM GTA5.exe /F");
        TimeUnit.MILLISECONDS.sleep(5000);
        Runtime.getRuntime().exec("cmd /c Taskkill /IM GTAVLauncher.exe /F");
        System.out.println("Win");
        run=run-1;
    }
    catch (InterruptedException ex) {
    } 
    catch (IOException ex) {
        Logger.getLogger(TaskKiller.class.getName()).log(Level.SEVERE, null, ex);
    }
    }else if(OS.indexOf("mac") >= 0){
        try {
            Runtime.getRuntime().exec("/bin/bash -c  sudo killall process PID");
            System.out.println("Mac");
            run=run-1;
        } catch (IOException ex) {
            Logger.getLogger(TaskKiller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
else if (ch==0) {
if(OS.indexOf("win") >= 0){
    try {
        TimeUnit.MILLISECONDS.sleep(time);
    Runtime.getRuntime().exec("cmd /c Taskkill /IM chrome.exe /F");
        System.out.println("Win");
        run=run-1;
    }
    catch (InterruptedException ex) {
    } 
    catch (IOException ex) {
        Logger.getLogger(TaskKiller.class.getName()).log(Level.SEVERE, null, ex);
    }
    }else if(OS.indexOf("mac") >= 0){
        try {
            Runtime.getRuntime().exec("/bin/bash -c  sudo killall process PID");
            System.out.println("Mac");
            run=run-1;
        } catch (IOException ex) {
            Logger.getLogger(TaskKiller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
else if (fi==0) {
    if(OS.indexOf("win") >= 0){
    try {
        TimeUnit.MILLISECONDS.sleep(time);
    Runtime.getRuntime().exec("cmd /c Taskkill /IM firefox.exe /F");
        System.out.println("Win");
        run=run-1;
    }
    catch (InterruptedException ex) {
    } 
    catch (IOException ex) {
        Logger.getLogger(TaskKiller.class.getName()).log(Level.SEVERE, null, ex);
    }
    }else if(OS.indexOf("mac") >= 0){
        try {
            Runtime.getRuntime().exec("/bin/bash -c  sudo killall process PID");
            System.out.println("Mac");
            run=run-1;
        } catch (IOException ex) {
            Logger.getLogger(TaskKiller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
else if (sa==0) {
    if(OS.indexOf("win") >= 0){
    try {
        TimeUnit.MILLISECONDS.sleep(time);
    Runtime.getRuntime().exec("cmd /c Taskkill /IM safari.exe /F");
        System.out.println("Win");
        run=run-1;
    }
    catch (InterruptedException ex) {
    } 
    catch (IOException ex) {
        Logger.getLogger(TaskKiller.class.getName()).log(Level.SEVERE, null, ex);
    }
    }else if(OS.indexOf("mac") >= 0){
        try {
            Runtime.getRuntime().exec("/bin/bash -c  sudo killall process PID");
            System.out.println("Mac");
            run=run-1;
        } catch (IOException ex) {
            Logger.getLogger(TaskKiller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
else if (cs==0) {
    if(OS.indexOf("win") >= 0){
    try {
        TimeUnit.MILLISECONDS.sleep(time);
    Runtime.getRuntime().exec("cmd /c Taskkill /IM csgo.exe /F");
        System.out.println("Win");
        run=run-1;
    }
    catch (InterruptedException ex) {
    } 
    catch (IOException ex) {
        Logger.getLogger(TaskKiller.class.getName()).log(Level.SEVERE, null, ex);
    }
    }else if(OS.indexOf("mac") >= 0){
        try {
            Runtime.getRuntime().exec("/bin/bash -c  sudo killall process PID");
            System.out.println("Mac");
            run=run-1;
        } catch (IOException ex) {
            Logger.getLogger(TaskKiller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
else {
    JOptionPane.showMessageDialog(null, "Invalid name. Try Again or quit", "Error", JOptionPane.ERROR_MESSAGE);
    run=run+1;
}
}
}
}