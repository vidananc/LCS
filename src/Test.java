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
            System.out.println(l.getLCS(checkInput.next(), checkInput.next()));
        }
    }
}
