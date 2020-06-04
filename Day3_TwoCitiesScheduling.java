import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

class Day3_TwoCitiesScheduling{
	Day3_TwoCitiesScheduling twoCitiesScheduling;
    @BeforeEach
    public void init() {
        twoCitiesScheduling = new Day3_TwoCitiesScheduling();
    }

    @org.junit.jupiter.api.Test
    public void firstTest() {
        int[][] in = new int[][]{{259, 770}, {926, 667}, {577, 469}, {448, 54}, {184, 139}, {840, 118}};
        int res = twoCitiesScheduling.twoCitySchedCost(in);
        Assertions.assertEquals(1859,res);
    }

    public int twoCitySchedCost(int[][] costs) {
    	
    	Arrays.sort(costs,((a,b) -> Math.abs(b[0]-b[1])-Math.abs(a[0]-a[1])));
    	
    	int N = costs.length/2;
    	int a = 0;
    	int b = 0;
    	int sum = 0;
    	for(int[]cost:costs) {
    		if(b>=N||cost[0]<=cost[1]&& a<N) {
    			a++;
    			sum += cost[0];
    		}else {
    			sum +=cost[1];
    			b++;
    		}
    	}
        return sum;
    }
}
