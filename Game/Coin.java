import java.awt.*;
/**
 * Write a description of class Coins here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Coin
{
    // instance variables
    int n; // number of coins in the stack
    int x, y; // position on screen
    Color c;
    int type;

    Color[] colors = { Color.BLUE, Color.RED, Color.GREEN.darker(), Color.GRAY, Color.WHITE, Color.YELLOW};
    final static int BLUE = 0;
    final static int RED = 1;
    final static int GREEN = 2;
    final static int BLACK = 3;
    final static int WHITE = 4;
    final static int YELLOW = 5;

    /**
     * Constructor for objects of class Coins
     */
    public Coin(int x, int y, int n, int color)
    {
        this.x = x;
        this.y = y;
        this.n = n;
        this.c = colors[color];
        type = color;
    }

    public void add()
    {
        this.n += 1;
    }
    
    public void remove()
    {
        this.n -= 1;
    }
    
    public int type()
    {
        return type;
    }
    
    public Color getColor()
    {
        return c;
    }
    
    public boolean contains(Point p)
    {
        if(n == 0) return false;
        return contains(p.x, p.y);
    }
    public boolean contains(int x, int y)
    {
        Rectangle bound = new Rectangle(this.x, this.y-(5*n)+5, 40, 5*n + 15);
        return bound.contains(x, y);
    }
    
    public void draw(Graphics g)
    {
        if(n == 0) return;
        
        int h = n * 5;
        g.setColor(c);
        g.fillRect(x, (y+12) - h, 40, h);
        g.setColor(Color.BLACK);
        g.drawRect(x, (y+12) - h, 40, h);

        g.setColor(c);
        g.fillOval(x, (y+5), 40, 15);
        g.setColor(Color.BLACK);
        g.drawOval(x, (y+5), 40, 15);

        for(int i = 0; i < n; i++)
        {
            int offset = i * 5;
            g.setColor(c);
            g.fillOval(x, y - offset, 40, 15);
            g.setColor(Color.BLACK);
            g.drawOval(x, y - offset, 40, 15);
        }        
    }

    
    public void highlight(Graphics g)
    {
        Rectangle bound = new Rectangle(x, y-(5*n)+5, 40, 5*n + 15);
        g.setColor(Color.YELLOW);
        g.drawRect(bound.x, bound.y, bound.width, bound.height);
    }
}
