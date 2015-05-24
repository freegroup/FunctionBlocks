/*
 * Created on 23.10.2006
 *
 */
package iec61499.runtime;

import iec61499.runtime.datatype.BOOL;
import iec61499.runtime.datatype.EVENT;
import iec61499.runtime.datatype.REAL;
import iec61499.runtime.datatype.TIME;
import iec61499.runtime.datatype.VALUE;
import iec61499.runtime.ui.in.EventButton;
import iec61499.runtime.ui.out.EventCheckBox;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

public class CompositeFunctionBlock extends AbstractFunctionBlock implements Runnable
{

  public CompositeFunctionBlock(String name)
  {
    super(name);
  }

  @Override
  public void tick()
  {
  }
 
  public final void run()
  {
    while(true)
    {
      tick();
      resetInputEvents();
      try
      {
        Thread.sleep(100);
      }
      catch (InterruptedException e)
      {
        return;
      }
    }
  }
  
  public JComponent buildPanel() 
  {

    String columnString="";
      int eventCount =Math.max(getInputEvents().size(), getOutputEvents().size());
      int valueCount =Math.max(getInputValues().size(),getOutputValues().size());
      
      columnString = columnString +"10dlu";
      for (int i = 0; i < eventCount; i++)
      {
        columnString = columnString + ",pref,5dlu";
      }
      
      columnString = columnString + ",100dlu:grow,10dlu";
      for (int i = 0; i < valueCount; i++)
      {
        columnString = columnString + ",pref,5dlu";
      }
      columnString = columnString+",10dlu";

      
      FormLayout layout = new FormLayout(
              "10dlu, pref, 5dlu,pref,100dlu:grow,pref,5dlu,pref,10dlu",
              columnString);
      
      // Create a panel that uses the layout.
//      JPanel panel = new FormDebugPanel(layout);
      JPanel panel = new JPanel(layout);
      // Create a reusable CellConstraints instance.
      CellConstraints cc = new CellConstraints();

      panel.add(new JLabel(name),"5, 2, c, c");
      panel.add(new JLabel(new ImageIcon(BasicFunctionBlock.class.getResource("functionblock.png"))),"5,3,1,"+(4+(eventCount*2)+", c, c"));
      panel.setBackground(Color.white);
      // INPUT Events
      int x=2;
      int y=2;
      for (EVENT event : getInputEvents())
      {
        EventButton button = new EventButton(event);
        button.setText(" ");
        panel.add(button,cc.xy(x,y));
        panel.add(new JLabel(event.getName()),cc.xy(x+2,y));
        y=y+2;
      } 

      // OUTPUT Events
      x=8;
      y=2;
      for (EVENT event : getOutputEvents())
      {
        EventCheckBox button = new EventCheckBox(event);
        panel.add(button,cc.xy(x,y));
        panel.add(new JLabel(event.getName()),cc.xy(x-2,y));
        y=y+2;
      } 

      // INPUT Values
      x=2;
      y=4+(eventCount*2);
      for (VALUE value : getInputValues())
      {
        JComponent component;
        if(value instanceof BOOL)
          component = new iec61499.runtime.ui.in.ValueCheckBox((BOOL)value);
        else if(value instanceof REAL)
          component = new iec61499.runtime.ui.in.ValueRealField((REAL)value);
        else if(value instanceof TIME)
          component = new iec61499.runtime.ui.in.ValueTimeField((TIME)value);
        else
          component = new iec61499.runtime.ui.in.ValueTextField(value);
        panel.add(component,cc.xy(x,y));
        panel.add(new JLabel(value.getName()),cc.xy(x+2,y));
        y=y+2;
      } 

      // OUTPUT Values
      x=8;
      y=4+(eventCount*2);
      for (VALUE value : getOutputValues())
      {
        JComponent component;
        if(value instanceof BOOL)
          component = new iec61499.runtime.ui.out.ValueCheckBox((BOOL)value);
        else if(value instanceof REAL)
          component = new iec61499.runtime.ui.out.ValueRealField((REAL)value);
        else if(value instanceof TIME)
          component = new iec61499.runtime.ui.out.ValueTimeField((TIME)value);
        else
          component = new iec61499.runtime.ui.out.ValueTextField(value);
        
        panel.add(component,cc.xy(x,y));
        panel.add(new JLabel(value.getName()),cc.xy(x-2,y));
        y=y+2;
      } 

      return panel;
  }
  
}
