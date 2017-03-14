package editor;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
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
    openFile.setOnAction(ae -> EditorActions.open(primaryStage, editor));
    openFile.setAccelerator(new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_DOWN));
    
    MenuItem saveFile = new MenuItem("Save\t\t\tCtrl+S");
    saveFile.setOnAction(ae -> EditorActions.save(primaryStage, editor));
    saveFile.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN));
    
    menuFile.getItems().addAll(openFile, saveFile);
    menuBar.getMenus().addAll(menuFile);
  
    editor.bPane.setTop(menuBar);
  }
}
