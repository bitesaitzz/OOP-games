#pragma once 
#include <iostream>
#include <vector>
#include "Information.h"
#include "Organizm.h"
#include "Punkt.h"
#define GREEN 11
#define WHITE 10
#define RED 12
#define YELLOW 13
#define ORANGE 14
#define BROWN 15
#define BRIGHT_RED 16
#define BRIGHT_GREEN 17
#define BLACK 18
#define GRAY 19


#define START_X 4
#define START_Y 2
//#include "Man.h"
using namespace std;
class Organizm;
class Man;
class Wolf;
class Sheep;
class World {
protected:
	int x;
	int y;
	int temp;
	//temp is used to save the place Hero go
	//char map[50][50];
	char** map;
	int Tour;
	Man* man;
	vector <Organizm*> organizmy;
	bool isGame;
public:
	Information info;
	World(int x, int y);
	~World();
	int getTour();
	void saveTheGame();
	void openTheGame();
	void setTour(int tour);
	int Randomizer();
	void addOrganizm(Organizm* organizm);
	void deleteOrganizm(Organizm* organizm);
	int getX();
	int getY();
	Organizm* getElementInMap(Punkt pozycja);
	void CreateWorld();
	void drawWorld();
	void drawAnimal();
	void Controller();
	int getTemp();
	bool getIsGame();
	void nextStep();
	void drawAdditional();

};