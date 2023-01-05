import java.util.Arrays;

public class LCS
{
    private StringBuilder result;
    private int[][] dp;
    private int[][] m;
    public int getLCS(String x, String y)
    {
        result = new StringBuilder();
        dp = new int[x.length() + 1][y.length() + 1];
        m = new int[x.length() + 1][y.length() + 1];
        Arrays.fill(dp[0], 0);
        for(int i = 0; i < dp.length; i++)
        {
            dp[i][0] = 0;
        }
        for(int i = 0; i < x.length(); i++)
        {
            for(int j = 0; j < y.length(); j++)
            {
                if(x.charAt(i) == y.charAt(j))
                {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                    m[i + 1][j + 1] = 0;
                }
                else
                {
                    if(dp[i][j + 1] > dp[i + 1][j])
                    {
                        dp[i + 1][j + 1] = dp[i][j + 1];
                        m[i + 1][j + 1] = 1;
                    }
                    else
                    {
                        dp[i + 1][j + 1] = dp[i + 1][j];
                        m[i + 1][j + 1] = 2;
                    }
                }
            }
        }
        lcs(x, x.length() - 1, y.length() - 1);
        System.out.println(result);
        return dp[x.length()][y.length()];
    }
    private void lcs(String x, int i, int j)
    {
        if(i == -1 || j == -1)
        {
            return ;
        }
        switch (m[i + 1][j + 1])
        {
            case 0:
                lcs(x, i - 1, j - 1);
                result.append(x.charAt(i));
                break;
            case 1:
                lcs(x, i - 1, j);
                break;
            default:
                lcs(x, i, j - 1);
                break;
        }
    }
    public int lastAdded(String s)
    {
        StringBuilder temp = new StringBuilder(s);
        temp.reverse();
        String y = temp.toString();
        int length = getLCS(s, y);
        return s.length() - length;
    }
}
