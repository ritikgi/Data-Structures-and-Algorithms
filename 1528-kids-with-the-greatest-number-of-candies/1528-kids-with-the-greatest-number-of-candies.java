class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        List<Boolean> res = new ArrayList<Boolean>(candies.length);
        for(int candy : candies){
            // if(candy > max){
            //     max = candy;
            // } instead of this use the below 
            max = Math.max(max, candy);
        }
        for(int i =0; i<candies.length; i++){
            // if (candies[i] + extraCandies >= max) {
            //     res.add(true);
            // } else {
            //     res.add(false);
            // } instead of this use the below
            res.add(candies[i] + extraCandies >= max);
        }
        return res;
    }
}