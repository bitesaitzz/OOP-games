#pragma once 

class Punkt {
protected: 
	int x;
	int y;
public:

	Punkt(int x, int y);
	Punkt();
	void setX(int x);
	
	void setY(int y);
	
	
	int getX();
	
	int getY();
	bool operator==(const Punkt& other); 
	
};