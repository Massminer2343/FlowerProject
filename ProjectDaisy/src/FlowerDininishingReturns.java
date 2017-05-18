

public class FlowerDininishingReturns 
{
		public static double diminishing_returns(double val, double scale)
		{
		    if(val < 0)
		        return -diminishing_returns(-val, scale);
		    double mult = val / scale;
		    double trinum = (Math.sqrt(8.0 * mult + 1.0) - 1.0) / 2.0;
		    return trinum * scale;
		}
		public static void main(String args[])
		{
			for(int i=10; i>0; i--){
				for(int j=10; j>0; j--){
					System.out.println(i+" "+j);
					System.out.println(""+diminishing_returns(i,j));}}
		}
}
