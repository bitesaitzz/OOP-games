// FINAL PROJECT PO.cpp : Этот файл содержит функцию "main". Здесь начинается и заканчивается выполнение программы.
//

#include <iostream>
#include <conio.h>
#include <stdlib.h>
#include "World.h"

using namespace std;
int main()
{
	int x, y;
	char zn;
	bool isMenu = true;
	bool isGame = false;
	//World* world;
	while (isMenu) {
		cout << "PRESS ENTER TO START" << endl;
		zn = _getch();
		switch (zn) {
		case '\r':
			system("cls");
			cout << "WRITE THE SIZE OF MAP(x and y): ";
			cin >> x >> y;
			isMenu = false;
			isGame = true;
			system("cls");
			break;
		case 'q':
			cout << "BYE";
			isMenu = false;
			break;
		
		default:
			break;
		}

		
	}
	if (isGame == true) {
		World* world = new World(x, y);
		world->CreateWorld();
		while (world->getIsGame()) {
			world->nextStep();
			system("cls");
		}
	}
		
		//if (zn == 'q') {
			//cout << endl << "quit" << endl;
			//isGame = false;
		
		

		
		
		
	
	


   
}

