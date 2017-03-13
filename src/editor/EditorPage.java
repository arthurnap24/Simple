package editor;

import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;

import java.io.*;

public class EditorPage
{
  BorderPane bPane;
  TextArea writeArea;
  
  EditorPage()
  {
    super();
    bPane = new BorderPane();
    writeArea = new TextArea();
    
    bPane.setCenter(writeArea);
  }
  
  public void replaceWriteArea(File file)
  {
    writeArea.setText("");
    try
    {
      BufferedReader bR = new BufferedReader(new FileReader(file));
      StringBuilder sB = new StringBuilder();
      int c = ' ';
      while ((c=bR.read()) != -1)
      {
        sB.append((char)c+"");
      }
      writeArea.setText(sB.toString());
    }
    catch (FileNotFoundException fnfe)
    {
      System.out.println("File not found!");
    }
    catch (IOException iOE)
    {
      System.out.println("IOException");
    }
  }
  
}
