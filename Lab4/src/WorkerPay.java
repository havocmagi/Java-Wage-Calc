import java.util.Locale;
import java.util.Scanner;
import java.text.NumberFormat;
public class WorkerPay
{
public static void main( String args [] )
{
// 1. Instantiate the object “worker” here using the
// no-argument constructor:
	WorkerPay Worker = new WorkerPay();
// 2. Reference the method to prompt for inputs here:
	Worker.prompt4data();
// 3. Reference the method to display the results here:
	System.out.println(Worker.toString());
} // end main
/*
Students must fill in the code for the private instance fields
and the two instance methods: grossPay, fedTax, and display.
Declare the three private instance fields here: */
private double hours;
private double wageRate;
private int dependents;
/* Write the no-argument constructor here: */
public WorkerPay ()
{ // initialize the instance fields to zero.
hours = 0.0;
wageRate=0.0;
dependents=0;
}
public void prompt4data() /* this is an instance method */
{
// This method should prompt for the input data
Scanner console = new Scanner( System.in );
// Fill in the remaining code here by prompting for the
// three inputs and assigning the three instance fields.

System.out.println( "Enter the number of hours worked: " );
hours= console.nextDouble();
System.out.println( "Enter the wage rate: " );
wageRate= console.nextDouble();
System.out.println( "Enter the # of dependents: " );
dependents= console.nextInt();
}
/* Complete the grossPay instance method */
public double grossPay()
{
if(hours<=40)
	return hours*wageRate;
else if (hours<=60)
	return (hours*wageRate) + 1.5*wageRate*(hours-40);
else
	return (hours*wageRate) + (1.5*wageRate*(hours-40)) + (2*wageRate*(hours-60));
}
/* Write the fedTax() instance method here: */
public double fedTax()
{
if (((.1*grossPay())-(25*dependents))<=0)
	return 0;
else
	return (.1*grossPay())-(25*dependents);
}
/* Write the toString() instance method here: */
public String toString()
{
	NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
	
	return "\n Hours worked = " + hours + "\n Hourly rate = " + formatter.format(wageRate) + "\n # of dependents = " + dependents + 
			"\n Gross income = " + formatter.format(grossPay()) + "\n Federal Tax Witheld = " + formatter.format(fedTax()) + 
			"\n Take home pay is = " + formatter.format(grossPay()-fedTax());
}
} // end class