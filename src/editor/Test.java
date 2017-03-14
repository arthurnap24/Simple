package editor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

/**
 * Created by Arthur on 3/14/2017.
 */
public class Test
{
  public static void main(String[] args)
  {
    JFrame jf = new JFrame();
   
    JLabel l = new JLabel("Press CTRL+S");
    JPanel jp = new JPanel();
    jp.add(l);
    jp.setPreferredSize(new Dimension(200, 200));
    jf.add(jp);
    
    jp.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK),
            "key");
    jp.getActionMap().put("key", action());
    
    jf.setSize(new Dimension(200, 200));
    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jf.setVisible(true);
  }
  
  static AbstractAction action()
  {
    return
            (
              new AbstractAction()
              {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                  System.out.println("pressed ctrl+s");
                }
                
              }
            );
  }
}
