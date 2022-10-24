package kr.or.ddit.dao;

public class test {

	public static void main(String[] args) {
		int i=0, j=0;
		//(가;나;다) => 가->다->나->다->나->다->나
		for(int k=0;k<3;k++) {
			//false&&안봄
			//true&&1>1
			//3>1&&2>1
			if((++i>1)&&(++j>1)) 
				i++;
		}
		System.out.println(i + " " + j);
	}

}
