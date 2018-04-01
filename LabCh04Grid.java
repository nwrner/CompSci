import java.awt.Color;

public class LabCh04Grid extends Basic {
  double x1;
  double x2;
  double x3;
  double x4 = 0.0D;
  
  private static double SIZE = 100.0D;
  private int number;
  
  public static void main(String[] paramArrayOfString) { LabCh04Grid localLabCh04Grid = new LabCh04Grid("Lab 4.4", 0, 0, 620, 650); }
  



  public LabCh04Grid(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramString, paramInt1, paramInt2, paramInt3, paramInt4);
    pads.add(new Sketchpad(10, 40, 600, 600, 0.0D, SIZE, 0.0D, Color.white));
    
    number = 10;
    
    super.start();
  }
  
  public synchronized void step()
  {
    Sketchpad localSketchpad = (Sketchpad)pads.get(0);
    localSketchpad.activate();
    



    number = 6;
    localSketchpad.setColor(Color.red);
    double d = SIZE / number;
    for (int i = 0; i < number + 1; i++) {
      localSketchpad.setColor(Color.green);
      localSketchpad.drawLine(x2 + d, 0.0D, x2 + d, 100.0D);
      localSketchpad.drawLine(0.0D, x2 + d, 100.0D, x2 + d);
      d += SIZE / number;
    }
  }
  



  public synchronized void keyPressed(java.awt.event.KeyEvent paramKeyEvent)
  {
    int i = paramKeyEvent.getKeyCode();
    
    if ((i == 37) && (number > 5)) {
      number -= 1;
      System.out.println(number);
    }
    else if ((i == 39) && (number < 50)) {
      number += 1;
      System.out.println(number);
    }
  }
}
