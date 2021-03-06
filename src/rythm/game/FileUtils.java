/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rythm.game;

/**
 *
 * @author ASUS
 */

import javafx.embed.swing.JFXPanel;
import javafx.application.Platform;
import javafx.stage.FileChooser;
import java.io.File;
import com.badlogic.gdx.files.FileHandle;

public class FileUtils {
    private static boolean finished;
    private static FileHandle fileHandle;
    private static int openDialog = 1;
    private static int saveDialog = 2;
    
    
   public static FileHandle showOpenDialog(){
       return showDialog(openDialog);
   }
   
   public static FileHandle showSaveDialog(){
       return showDialog(saveDialog);
   }
   
   private static FileHandle showDialog(int dialogType){
       new JFXPanel();
       finished = false;
       Platform.runLater(
        ()->
        {
            FileChooser fileChooser = new FileChooser();
            File file;
            
            if (dialogType == openDialog) {
                file = fileChooser.showOpenDialog(null);
            }
            else{
                file = fileChooser.showSaveDialog(null);
            }
            if (file != null) {
                fileHandle = new FileHandle(file);
            }
            else
            {
                fileHandle = null;
            }
            finished = true;
        }
       );
       while(!finished)
       {
           //Waiting for filechooser window to close
       }
       return fileHandle;
   }
}
