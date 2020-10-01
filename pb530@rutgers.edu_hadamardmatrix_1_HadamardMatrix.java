/*************************************************************************
 *  Compilation:  javac HadamardMatrix.java
 *  Execution:    java HadamardMatrix 2
 *
 *  @author: Prithish Balakrishnan
 *
 * The program HadamardMatrix prints H(n)
 *
 *  % java HadamardMatrix 2
 *  T T
 *  T F
 *
 *************************************************************************/

public class HadamardMatrix {

    public static void main(String[] args) {
    	//int dim=8;
    	int dim=Integer.parseInt(args[0]);
    	//boolean[][] starter=new boolean[1][1];
    	boolean[][] starter={{true}};
    	boolean[][] maybe=starter;
    	boolean[][] idk=starter;
    	if(dim==1){
   		 	System.out.print("T"+" ");
   		 	System.out.println();
   		 	return;

    	}

    	for(int i=1;i<=logTwo(dim);i++){
    		boolean[][] result=buildNext(maybe);
    		if(i==logTwo(dim)){
    			idk=result;
    			break;
    		}
    		else{
    			maybe=result;
    		}
    	}

    	printHad(idk);
	
    }

    public static boolean[][] buildNext(boolean[][] previous){
    	int dim =previous.length;
    	boolean[][] result=new boolean[2*dim][2*dim];
    	for(int i=0;i<previous.length; i++){
    		for(int j=0;j<previous[i].length; j++){
    			result[i][j]=previous[i][j];
    		}
    	}

    	for(int i=0;i<previous.length; i++){
    		for(int j=0;j<previous[i].length; j++){
    			result[i+dim][j]=previous[i][j];
    		}
    	}

    	for(int i=0;i<previous.length; i++){
    		for(int j=0;j<previous[i].length; j++){
    			result[i][j+dim]=previous[i][j];
    		}
    	}

    	for(int i=0;i<previous.length; i++){
    		for(int j=0;j<previous[i].length; j++){
    			result[i+dim][j+dim]=!(previous[i][j]);
    		}
    	}
    	return result;
    }




    public static int logTwo(int input){
    	int count=0;
    	while(input>1){
    		count++;
    		input/=2;
    	}
    	return count;
    }

    public static void printHad(boolean[][] starter){
    	for(int i=0;i<starter.length; i++){
    		for(int j=0;j<starter[i].length; j++){
    			if(starter[i][j]){
   		 			System.out.print("T"+" ");

    			}
    			else{
   		 			System.out.print("F"+" ");
    			}
    		}
    		System.out.println();
    	}
    }
}
