#include<iostream>
#include<cmath>
using namespace std;

int main(){
	int n;
	
	do{
		cout << "Nhap vao n (n>0) ";
		cin >> n;
		
	}while(n<=0);
	
	int temp = n; // luu bien phu
	int sodaonguoc=0;
	
	int dem = log10((double)temp);
	
	while(temp!=0)
	{
		int chuso = temp % 10;
		temp /= 10;
		
		sodaonguoc += chuso * pow(10.0, dem--);
	}
	cout << "So dao nguoc cua " << n << " la " << sodaonguoc;
	
	if(n==sodaonguoc)
	{
		cout << "la so doi xung";
	}
	else cout << "khong phai la so doi xung";
	
	
	// Kiem tra so chinh phuong
	if(sqrt((double)n) == (int) sqrt((double)n))
	{
		cout << endl << n << "La so chinh phuong";
	}else{
		cout << n << "Khong phai la so chinh phuong ";
	}
	
	/*
	So nguyen to la so bat dau tu 2 va chi co chia het duy nhat cho 1 va chinh no
	
	*/
	
	if(n<2)
	{
		cout << "Khong phai la so nguyen to";
	}
	else
	{
		int Check=1; //true
		for(int i=2;i<n;i++) // Cach 2:n/2 Cach 3: sqrt((double)n)
		{                   // Cach 4: for(int i=3;i<=sqrt((double)n);i+=2) 
			if(n%i == 0)
			{
				Check=0; // false
				break;
			}
		}
		if(Check == 1)
		cout << "la so nguyen to ";
		if(Check==0)
		cout << "khong phai la so nguyen to";
		
	}
	
	// Kiem tra tang dan
	int Temp = n;
	int checktang = 1;
	int checkgiam =1;
	// 12345
	while(Temp > 9 ) //temp / 10 != 0
	{
		int chuso1 = Temp % 10; // 5
		Temp /= 10;
		int chuso2 = Temp % 10; // 4
		
		if(chuso1 <= chuso2)
		{
			checktang = 0;
			//break;
		}
		if(chuso1 >= chuso2)
		{
			checkgiam = 0;
			
		}
	}
	if(checktang==1)
	{ 
		cout << endl;
		cout <<  n << " Tang dan ";
	}
	else if(checkgiam==1)
	{
		cout << endl;
		cout << n << " Giam dan ";
	}
	else
	{
		cout << endl;
		cout << "Khong tang Khong giam";
	}
	
	
	return 0;
}
