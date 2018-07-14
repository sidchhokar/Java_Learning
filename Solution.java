import java.util.*;

public class Solution {

	static Set<String> obstacles = new HashSet<String>();
	static int max;

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);       

		max = in.nextInt();

		int k = in.nextInt();        

		int rQueen = in.nextInt();

		int cQueen = in.nextInt();
		StringBuffer obstacle = new StringBuffer("");

		for(int i = 0; i < k; i++){

			int rObstacle = in.nextInt();

			int cObstacle = in.nextInt();

			obstacle.append(rObstacle+","+cObstacle);
			if(!(obstacles.contains(obstacle.toString()))) {
				obstacles.add(obstacle.toString());
			}
			obstacle.setLength(0);
		}     

		System.out.println("" + getCount(rQueen,cQueen));
		in.close();
	}

	static int getCount(int rq,int cq) {
		int sum = 0;
		sum += coverdown(rq--,cq);
        System.out.println("down: "+sum);
		sum += coverdownright(rq--,cq++);
		System.out.println("downright: "+sum);
		sum += coverdownleft(rq-=1,cq-=1);
		System.out.println("downleft: "+sum);
		sum += coverleft(rq,cq-=1);
		System.out.println("left: "+sum);
		sum += coverleftup(rq+=1,cq-=1);
		System.out.println("leftup: "+sum);
		sum += coverright(rq,cq+=1);
		System.out.println("right: "+sum);
		sum += coverrightup(rq+=1,cq+=1);
		System.out.println("rightup: "+sum);
		sum += coverup(rq+=1,cq);
		System.out.println("up: "+sum);
		return sum;
	}



	static boolean checkObstacles(int rq,int cq) {
		String cordinates = rq + "," + cq; 
		if(obstacles.contains(cordinates)) {
			return true;
		}
		else {
			return false;
		}
	}

	static int coverdown(int rq, int cq) {
		int ret = 0;
		if(rq >= 1 ) {
			if(!checkObstacles(rq,cq)) {            	               
				ret = coverdown(rq-=1,cq) + 1;
			}
		}		
		return ret;
	}

	static int coverdownright(int rq, int cq) {
		int ret = 0;
		if((rq >= 1) && (cq <= max)) {
			if(!checkObstacles(rq,cq)) {            	               
				ret = coverdownright(rq-=1,cq+=1) + 1;
			}
		}		
		return ret;
	}
	static int coverdownleft(int rq, int cq) {
		int ret = 0;
		if(rq >= 1 && cq >= 1) {
		System.out.println("rq: "+rq);
                System.out.println("cq: "+cq);
			if(!checkObstacles(rq,cq)) {            	               
				ret = coverdownleft(rq-=1,cq-=1) + 1;
			}
		}		
		return ret;
	}

	static int coverleft(int rq, int cq) {
		int ret = 0;
		if( cq >= 1) {
			if(!checkObstacles(rq,cq)) {            	               
				ret = coverleft(rq,cq-=1) + 1;
			}
		}		
		return ret;
	}

	static int coverleftup(int rq, int cq) {
		int ret = 0;
		if(rq <= max && cq >= 1) {
			if(!checkObstacles(rq,cq)) {            	               
				ret = coverleftup(rq+=1,cq-=1) + 1;
			}
		}		
		return ret;
	}

	static int coverright(int rq, int cq) {
		int ret = 0;
		if( cq <= max) {
			if(!checkObstacles(rq,cq)) {            	               
				ret = coverright(rq,cq+=1) + 1;
			}
		}		
		return ret;
	}

	static int coverrightup(int rq, int cq) {
		int ret = 0;
		if( rq <= max && cq <= max) {
			if(!checkObstacles(rq,cq)) {            	               
				ret = coverrightup(rq+=1,cq+=1) + 1;
			}
		}		
		return ret;
	}

	static int coverup(int rq, int cq) {
		int ret = 0;
		if( rq <= max) {
			if(!checkObstacles(rq,cq)) {            	               
				ret = coverup(rq+=1,cq) + 1;
			}
		}		
		return ret;
	}

}


