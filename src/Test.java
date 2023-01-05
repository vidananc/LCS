import java.util.Scanner;

public class Test
{
    public static void main(String[] args)
    {
        LCS l = new LCS();
        Scanner input = new Scanner(System.in);
        Scanner checkInput;
        String line;
        while(!(line = input.nextLine()).equals("exit"))
        {
            checkInput = new Scanner(line);
            if(checkInput.next().equals("1"))
            {
                l.getLCS(checkInput.next(), checkInput.next());
            }
            else
            {
                System.out.println(l.lastAdded(checkInput.next()));
            }
        }
    }
}
