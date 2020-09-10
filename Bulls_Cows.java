/*You are playing the following Bulls and Cows game with your friend: You write down a number and ask your friend to guess what the number is. 
Each time your friend makes a guess, you provide a hint that indicates how many digits in said guess match your secret number exactly in both 
digit and position (called "bulls") and how many digits match the secret number but locate in the wrong position (called "cows"). Your friend 
will use successive guesses and hints to eventually derive the secret number.

Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls and B to indicate the cows. 

Please note that both secret number and friend's guess may contain duplicate digits.

Example 1:

Input: secret = "1807", guess = "7810"

Output: "1A3B"

Explanation: 1 bull and 3 cows. The bull is 8, the cows are 0, 1 and 7.
Example 2:

Input: secret = "1123", guess = "0111"

Output: "1A1B"

Explanation: The 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow.
Note: You may assume that the secret number and your friend's guess only contain digits, and their lengths are always equal.



Solution :
1) First iterate over both the strings and find the no of bulls in the guess. If bull is encountered increment bulls variable and if not add the number in a 
different freqeuncy calculation array to calculate cows in the second iteration.
2) if a bull is encountered append a character like I chose "a" so that the same bull digit is not used in the cows calculation.
3)iterate over guesses again and now if "a" is encountered in the guess string it means it was a bull and continue for the next iteration and do nothing.
4)other than "a" in the guess string check in the frequency array we built if its frequecy is greater than zero, if so increment the cows variable.
5)make the result string usind cows and bulls variable.
*/
class Solution {
    public String getHint(String secret, String guess) {
        int[] arr = new int[10];
        int bulls = 0;
        int cows = 0;
        String result = "";
        for(int i=0; i<secret.length();i++)
        {
            if(secret.charAt(i)==guess.charAt(i))
            {
                bulls++;
                guess = guess.substring(0,i) +"a" + guess.substring(i+1,secret.length());
            }
            else{
                arr[Integer.valueOf(String.valueOf(secret.charAt(i)))]++;
            }
        }
        
        for(int j =0; j<guess.length();j++)
        {
            if(guess.charAt(j)=='a')
            {
                continue;
            }
            else{
                if(arr[Integer.valueOf(String.valueOf(guess.charAt(j)))]>0)
                {
                    cows++;
                    arr[Integer.valueOf(String.valueOf(guess.charAt(j)))]--;
                }
            }
        }
        
        result += String.valueOf(bulls)+"A"+String.valueOf(cows)+"B";
        return result;
    }
}
