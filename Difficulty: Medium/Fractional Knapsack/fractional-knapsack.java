class Solution {
     class Item {
        int val, wt;
        double ratio;
        
        Item(int v, int w) {
            val = v;
            wt = w;
            ratio = (double) v / w;
        }
    }
    
    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        
        int n = val.length;
        Item[] items = new Item[n];
        
        // Step 1: Create items with ratio
        for (int i = 0; i < n; i++) {
            items[i] = new Item(val[i], wt[i]);
        }
        
        // Step 2: Sort by ratio (descending)
        Arrays.sort(items, (a, b) -> Double.compare(b.ratio, a.ratio));
        
        double totalValue = 0.0;
        
        // Step 3: Pick items
        for (int i=0;i<items.length;i++) {
            
            if (capacity >= items[i].wt) {
                // take full item
                totalValue += items[i].val;
                capacity -= items[i].wt;
            } else {
                // take fraction
                totalValue += items[i].ratio * capacity;
                break;
            }
        }
        
        // Step 4: round to 6 decimal places
        return Math.round(totalValue * 1e6) / 1e6;
    }
    
}