#include <iostream>
#include <math.h>
#include <stdio.h>

using namespace std;

double theBiggest ( double x1, double x2, double x3 );

double Average ( double x1, double x2, double x3 );

double standardDeviation ( double x1, double x2, double x3 );

int main ()
{

	double x1 = { 0.0 }, x2 = { 0.0 }, x3 = { 0.0 };

		cout << "Please enter three numbers, all different "  << endl;
		cout << "The program will find the biggest, " << endl;
		cout << "the average and the standard deviation" << endl;

		cout << "Please enter the first number ";

		cin >> x1;

		cout << "Please enter the second number ";

		cin >> x2;

		cout << "Please enter the third number ";

		cin >> x3;

		double theBiggestNumber = theBiggest( x1, x2, x3 );

		cout <<"The the Biggest Number is: " << theBiggestNumber << endl;

		double theAverage = Average( x1, x2, x3 );

		cout << "The average is " << theAverage << endl;

		double theStandardDeviation = standardDeviation( x1, x2, x3 );

		cout << "The Standard Deviation is " << theStandardDeviation << endl;

return 0;

}//end of funct

double theBiggest ( double x1, double x2, double x3 )
{

		double theBiggestNumber = 0;

		if ( (x1 == x2) ) 
		{ 
			   cout << "The numbers must be all different" << endl;
		       exit (0);
		}

		else if ( (x1 == x3) ) 
		{ 
			   cout << "The numbers must be all different" << endl;
		       exit (0);
		}

		else if ( (x2 == x3) ) 
		{ 
			   cout << "The numbers must be all different" << endl;
		       exit (0);
		}

		else if ( (x1 > x2) && (x1 > x3) ) theBiggestNumber = x1;

		else if ( (x2 > x1) && (x2 > x3) ) theBiggestNumber = x2;

		else if ( (x3 > x1) && (x3 > x2) ) theBiggestNumber = x3;

	return theBiggestNumber;


}//end of function

double Average ( double x1, double x2, double x3 )
{

	return ((double)( x1 + x2 + x3 ) / 3) ;

}//end funct

double standardDeviation ( double x1, double x2, double x3 )
{

	double AverageValue = Average ( x1, x2, x3 );
	double rsum = 0;

	rsum =  sqrt(  ((double)(   ((x1 - AverageValue ) * (x1 - AverageValue)) +
	                            ((x2 - AverageValue ) * (x2 - AverageValue)) +
                                ((x3 - AverageValue ) * (x3 - AverageValue)) 
			   
			                ) / 3)  );

	return rsum;
}//end of funct