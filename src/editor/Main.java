package editor;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;

public class Main extends Application
{
  BorderPane root;
  Scene scene;
  @Override
  public void start(Stage primaryStage)
  {
//    root = new Group();
//    scene = new Scene(root, null);
   
    setUp(primaryStage);
    
    primaryStage.setTitle("Simple");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
  
  private void setUp(Stage primaryStage)
  {
    EditorPage editor = new EditorPage();
    scene = new Scene(editor.bPane, null);
  
    MenuBar menuBar = new MenuBar();
    Menu menuFile = new Menu("File");
    MenuItem openFile = new MenuItem("Open\t\tCtrl+O");
    openFile.setOnAction(new EventHandler<ActionEvent>() {
      public void handle(ActionEvent t)
      {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open File");
        //need the primaryStage so that inputs on the whole window is blocked.
        File selectedFile = fileChooser.showOpenDialog(primaryStage);
        if (selectedFile != null)
        {
          editor.replaceWriteArea(selectedFile);
        }
      }
    });
  
    MenuItem saveFile = new MenuItem("Save\t\t\tCtrl+S");
    saveFile.setOnAction(
            ae ->
            {
              FileChooser fileChooser = new FileChooser();
              fileChooser.setTitle("Save File");
              //need the primaryStage so that inputs on the whole window is blocked.
              File selectedFile = fileChooser.showSaveDialog(primaryStage);
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
    );
    
    
    menuFile.getItems().addAll(openFile, saveFile);
    menuBar.getMenus().addAll(menuFile);
  
    editor.bPane.setTop(menuBar);
  }
}
