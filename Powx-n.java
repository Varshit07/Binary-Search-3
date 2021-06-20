/** 
 * TC: O(logn)
 * SC: O(logn)
 * Approach: Use divide and conquer
             x^n = x^n/2 * x^n/2
             The above equation works w/o correction for even powers
             For odd powers, there is a correction
             2^5 = 2^2 * 2^2 * 2^1
             2^-5 = 2^-2 * 2^-2 * 2^-1
 */
class Solution {
    public double myPow(double x, int n) {
        // base case
        if(n == 0) {
            return 1;
        }
        
        // logic
        // divide the problem
        double temp = myPow(x, n/2);
        
        // if current power is even then just square the temp
        // 2^6 = 2^3 * 2^3
        // 2^-6 = 2^-3 * 2^-3
        if(n % 2 == 0) {
            return temp * temp;
        }
        else{
            // if the current power is odd and negative then square and divide by base
            // 2^-5 = 2^-2 * 2^-2 * [2^-1]
            if(n < 0) {
                return temp * temp / x;
            }
            // if the current power is odd and positive then square and multiply the base base
            // 2^5 = 2^2 * 2^2 * [2]
            return temp * temp * x;
        }
        
    }
}
