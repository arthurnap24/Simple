package editor;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.*;

/**
 * Created by Arthur on 3/14/2017.
 */
public class EditorActions
{
  public static void open(Stage primaryStage, EditorPage editor)
  {
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Open File");
    //need the primaryStage so that inputs on the whole window is blocked.
    File selectedFile = fileChooser.showOpenDialog(primaryStage);
    if (selectedFile != null)
    {
      editor.replaceWriteArea(selectedFile);
      editor.filePath = selectedFile.getAbsolutePath();
      System.out.println("editor filePath: " + editor.filePath);
    }
  }
  
  public static void save(Stage primaryStage, EditorPage editor)
  {
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Save File");
    //need the primaryStage so that inputs on the whole window is blocked.
    File selectedFile = null;
    if (editor.filePath != null)
    {
      selectedFile = new File(editor.filePath);
    }
    else if (editor.filePath == null)
    {
      selectedFile = fileChooser.showSaveDialog(primaryStage);
      editor.filePath = selectedFile.getAbsolutePath();
    }
    if (selectedFile != null)
    {
      try
      {
        PrintWriter pW = new PrintWriter(new BufferedWriter(new FileWriter(selectedFile)));
        pW.print(editor.writeArea.getText());
        pW.close();
      }
      catch (IOException ioe)
      {
        System.out.println("IOException");
      }
    }
  }
}
