#pragma once
#include <string>
#include <vector>
#include <iostream>
using namespace std;
class Information {
private:
	vector <string> strings;
public:
	void addInformation(string& str);
	void drawInformation();
	void deleteAll();
};