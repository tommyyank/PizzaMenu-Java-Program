/* Tom Yankowski
 * This program will create a frame for a pizza parlor
 * It will use a border and grid layout with 3 panels
 * It allows the user to pick their size, add multiple toppings, and add an order of wings
 * It calculates the total price of everything the user chooses
 * */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*; 
import java.text.NumberFormat;

public class pizzaframe extends JFrame implements  ItemListener, ListSelectionListener
{
  double pprice = 0.00;
  double tprice = 0.00;
  double topprice;
  String origprice = "0.00";
  
  double s = 7.00;
  double m = 9.00;
  double l = 11.00;
  double xl = 13.00;
  double w = 5.00;
  String total;
  
  JLabel title = new JLabel("HVCC Pizza Parlor");
  Font titlefont = new Font("Courier ", Font.BOLD, 20);
  Font font = new Font("TimesRoman", Font.BOLD, 18);
  JLabel instructions = new JLabel("Choose your pizza size and toppings($1 each)");
  JRadioButton small = new JRadioButton("Small($7)");
  JRadioButton medium = new JRadioButton("Medium($9)");
  JRadioButton large = new JRadioButton("Large($11)");
  JRadioButton xlarge = new JRadioButton("X-Large($13)");
  
  
  ButtonGroup group = new ButtonGroup();//user can only select one of the buttons now they are in a group
  String[] toppings = {"Eggplant", "Green Peppers", "Hot Peppers", "Pepperoni", "Sausage", "Mushrooms", "Anchovies"};
  JList<String> toplist = new JList<String>(toppings);
  JLabel price = new JLabel(" Price of your pizza is $" + origprice);
  JCheckBox wings = new JCheckBox("Side Order Hot Wings - add $5.00");
  Container c;
  
  
  BorderLayout bord = new BorderLayout();
  JPanel north = new JPanel();
  JPanel center = new JPanel();
  JPanel south = new JPanel();
  GridLayout centergrid = new GridLayout(1, 5);//each panel needs a different grid layout
  GridLayout northgrid = new GridLayout(2, 1);
  GridLayout southgrid = new GridLayout(1,2);  

  
  
  
  public pizzaframe()
  {
     setSize(550,250);
     c = getContentPane();
     c.setLayout(bord);
     
     title.setFont(titlefont);
     title.setHorizontalAlignment(JLabel.CENTER);
     title.setForeground(Color.red);
     
     instructions.setHorizontalAlignment(JLabel.CENTER);
     instructions.setForeground(Color.red);
     north.setLayout(northgrid);
     north.setBackground(Color.yellow);
     north.add(title);
     north.add(instructions);
     
     
     c.add(north, bord.NORTH);
     center.setLayout(centergrid);
     group.add(small);
     group.add(medium);
     group.add(large);
     group.add(xlarge);
     
     center.add(small);
     center.add(medium);
     center.add(large);
     center.add(xlarge);
     toplist.setForeground(Color.red);
     center.add(toplist);
    
    c.add(center, bord.CENTER);//add the panel to the BorderLayout
    south.setLayout(southgrid);
    price.setForeground(Color.red);
    wings.setForeground(Color.red);
    wings.setBackground(Color.yellow);
    south.add(price);
    south.add(wings);
    south.setBackground(Color.yellow);
    c.add(south, bord.SOUTH);
    
    small.addItemListener(this);
    medium.addItemListener(this);
    large.addItemListener(this);
    xlarge.addItemListener(this);
    wings.addItemListener(this);
    toplist.addListSelectionListener(this);
    setVisible(true);
    
  }
  
  public void itemStateChanged(ItemEvent e)
  {
   
    if(small.isSelected())
    {
        pprice = s;//when one of the size buttons is selected the price will be updated
     
    }
    else if(medium.isSelected())
    {
        pprice = m;
    
    }
    else if(large.isSelected())
    {
        pprice = l;
     
    }
    else if(xlarge.isSelected())
    {
        pprice = xl;
   
    }
      if(wings.isSelected())
      {  
        pprice += w;
      }
 tprice = topprice + pprice;
 NumberFormat curnum;
 curnum = NumberFormat.getCurrencyInstance();
 total = curnum.format(tprice);
 
 price.setText( " Price of your pizza is  " + total);//updates the JLabel declared above
  }
  public void valueChanged(ListSelectionEvent e)
  {
    int i;
    int[] toppingselect;
    toppingselect = toplist.getSelectedIndices();
    topprice = 0.00;
    for(i = 0; i < toppingselect.length; i++)
      { 
        topprice += 1.00;
      }
    tprice = topprice + pprice;
    NumberFormat curnum;
    curnum = NumberFormat.getCurrencyInstance();
    total = curnum.format(tprice);//will format the price value to a proper currency form
    price.setText( " Price of your pizza is  " + total);
      
    
     
   }
  public static void main(String[] args)
  {
    pizzaframe f = new pizzaframe();
  }
}
