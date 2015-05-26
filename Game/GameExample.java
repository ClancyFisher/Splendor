import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 * Write a description of class GameExample here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameExample extends GameEngine
{
    Coin[] stacks = new Coin[12];
    final static int BLUE = 0;
    final static int RED = 1;
    final static int GREEN = 2;
    final static int BLACK = 3;
    final static int WHITE = 4;
    final static int YELLOW = 5;

    ArrayList<Integer> chosen = new ArrayList<Integer>();
    int choice = 0;

    ArrayList<Coin> selected = new ArrayList<Coin>();

    public GameExample()
    {
        super("Example");
        setBackground(Color.GRAY.brighter());

        int[] stock = {7, 7, 7, 7, 7, 5};

        int x = 20;
        int y = 100;
        for(int i = 0; i < 6; i++)
        {
            Coin coin = new Coin(x, y, stock[i], i);
            stacks[i] = coin;
            x += 50;
        }

        x = 20;
        y = 540;
        for(int i = 6; i < 12; i++)
        {
            Coin coin = new Coin(x, y, 1, i-6);
            stacks[i] = coin;
            x += 50;
        } 
    }
    //everything that we just said
    public void mouseReleased(MouseEvent mouse)//
    {
        
        
        this.mouse = mouse.getPoint();
        
        //if only one coin is selected cheack to see if the first coin is the same as the one your choseing if so cheack if the stack is > 4 coins
        
        
        for(Coin coin : stacks)
        {
            if(coin.contains(this.mouse))
            {
                System.out.println(coin.getColor());
                int type= coin.type(), stype, ptype;  // actual,  stack, player type
                stype = type;
                ptype = type + 6;
                if(coin.y < getHeight() / 2)
                {
                    if(chosen.size() < 3)
                    {
                        stacks[stype].remove();
                        stacks[ptype].add();
                        chosen.add(type);
                    }
                    
                }
                else
                {
                    stacks[ptype].remove();
                    stacks[stype].add();
                    chosen.remove(chosen.indexOf(type));
                }
            }
        }
        System.out.println((chosen));
    }

    public void update()
    {
    }

    public void draw(Graphics g)
    {
        g.drawRect(15, 60,300,70);
        g.setColor(Color.ORANGE);
        g.fillRect(15, 60,300,70);
        g.setColor(Color.BLACK);
        g.drawString("Available coins", 120, 40);
        if(stacks[0] == null) return;
        for(Coin stack : stacks)
        {
            stack.draw(g);
            if(stack.contains(mouse))
            {
                stack.highlight(g);
            }
        }
        
    }

    public void processKey(int code, boolean pressed)
    {
        System.out.println(code + ":" + pressed);
    }

    public static void main(String[] args)
    {
        new GameExample();
    }
}
