package test01;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ArrayList;
import java.math.BigInteger;

public class Main {
	 public static void main(String[] args){
		 int[] a1 = {33, 66, 99};		 
		 String[] list = {"a", "b", "c","d"};
		 String[] list2 = {"1", "2", "3"};
		 Integer[] problem4 = {90, 2, 1,9};
		 //ダメぽ
		 //Arrays.sort(problem4, Comparator.naturalOrder());		 	
		 
		 sum(a1);
		 System.out.println(sum_rec(a1));
		 myzip(list,list2);
		 fib();
		 sortMerge(problem4);
		 calcsub();
    }
	 
	 public static void sum(int[] list){
		 int sum1 =0, sum2 =0;
		 for (int i = 0; i < list.length; i++){
			 sum1 += list[i];			 
			}
		 int i =0;
		 while(i < list.length){
			 sum2 += list[i];
			 i++;
		 }
		 System.out.println(sum1);
		 System.out.println(sum2);
	 }
	 
	 public static int sum_rec(int[] list){
		 if(list.length==1){
			 return list[0];
		 } else {
			 int[] list2 = Arrays.copyOfRange(list, 1, list.length);
			 return list[0] + sum_rec(list2);
		 }
	 }
	 
	 public static void myzip(String[] list, String[] list2){
		 ArrayList<String> result = new ArrayList<String>();
		 for(int i=0; i < Math.min(list.length,list2.length); i++){
			 result.add(list[i]);
			 result.add(list2[i]);
		 }
		 System.out.println(result);
	 }
	 
	 public static void fib() {
		 ArrayList<BigInteger> result = new ArrayList<BigInteger>();
		 for(int i =0; i<100; i++){
			 if(i==0){
				 result.add(BigInteger.ZERO);
			 }else if(i==1){
				 result.add(BigInteger.ONE);
			 }else {
				 result.add(result.get(i-2).add(result.get(i-1)));
			 }			 
		 }
		 System.out.println(result);
	 }
	 public static String sortMerge(Integer[] input){
		 Arrays.sort(input, new Comparator<Integer>() {
			 
			 @Override
	            public int compare(Integer i1, Integer i2) {
	                String s1 = i1.toString();
	                String s2 = i2.toString();
	                return (s1 + s2).compareTo(s2 + s1) * -1;
	            }
	        });
		 
		 String result = "";
		 for (Integer output : input) {
	            result += output.toString();
	        }

	        System.out.println(result);
		 return result;		 
	 }
	 
	 public static void calcsub(){
		 String[] cal = {"+","-",""};
		 String[] zerocal = {"-",""};
		 String[] problem = new String[9];
		 String result="";
		 for(int a=0; a<zerocal.length; a++){
			 problem[0] = "0" + zerocal[a] + "1";
			 for(int b=0; b<cal.length; b++){
				 problem[1] = cal[b] + "2";
				 for(int c=0; c<cal.length; c++){
					 problem[2]= cal[c] + "3";
					 for(int d=0; d<cal.length; d++){
						 problem[3]= cal[d] + "4";
						 for(int e=0; e<cal.length; e++){
							 problem[4]= cal[e] + "5";
							 for(int f=0; f<cal.length; f++){
								 problem[5] = cal[f] + "6";
								 for(int g=0; g<cal.length; g++){
									 problem[6] = cal[g] + "7";
									 for(int h=0; h<cal.length; h++){
										 problem[7] = cal[h] + "8";
										 for(int i=0; i<cal.length; i++){
											 problem[8] = cal[i] + "9";
											 result ="";
											 for(int j=0; j<problem.length; j++){
												 result	+= problem[j];											 
											 }
											 calc(result);
										 }
									 }
								 }
							 }		 
						 }
					 }
				 }
			 }
		 }
	 }
	 public static void calc(String input){
		 String cal = "";
		 int calc1 = 0;
		 int calc2 = 0;
		 for(int i=0; i<input.length(); i++){
			 if(input.charAt(i) == '+'){
				 if(cal.equals("+")){
					 calc1 += calc2;
				 }else if(cal.equals("-")){
					 calc1 -= calc2;
				 } else{
					 calc1 += calc2;  
				 }
				calc2=0;
				cal = "+"; 
			 } else if(input.charAt(i) == '-'){
				 if(cal.equals("+")){
					 calc1 += calc2;
				 }else if(cal.equals("-")){
					 calc1 -= calc2;
				 } else{
					 calc1 += calc2;  
				 }
				 calc2=0;
				 cal = "-";
			 } else {
				 calc2 = calc2 * 10 + Character.getNumericValue(input.charAt(i));				 
			 }			 
		 }
		 if(cal.equals("+")){
			 calc1 += calc2;
		 }else if(cal.equals("-")){
			 calc1 -= calc2;
		 }
		 if(calc1==100){
			 System.out.println(input.substring(1, input.length())); 
		 }
		 
	 }
	 
}
