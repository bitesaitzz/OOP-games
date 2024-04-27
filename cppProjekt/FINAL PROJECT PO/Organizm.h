#pragma once
#include <string>
#include "World.h"
#include "Punkt.h"

class World;
class Punkt;
class Organizm {
public:
	enum class TypOrganizmu
	{
		CZLOWIEK,
		WILK,
		OWCA,
		PINE_HOGWEED,
		TURTLE,
		ANTELOPE,
		DANDELION,
		TRAWA,
		WOLFBERRIES,
		GUARANA,
		
		FOX
		//WILCZE_JAGODY,
		//BARSZCZ_SOSNOWSKIEGO
	};
	int GetSila();
	void SetSila(int sila);
	int GetInicjatywa();
	void SetInicjatywa(int inicjatywa);
	void SetPozycja(int x, int y);
	void SetPozycjaPunkt(Punkt point);
	int getX();
	int getY();
	static Organizm* createOrganizm(TypOrganizmu typ, World* world, Punkt pozycja);
	char getModel();
	string getPozycjaStr();
	Punkt getPozycja();
	void setModel(char model);
	virtual void Akcja() = 0;
	virtual void Kolizja(Organizm* other) = 0;
	virtual void Drawing();
	int getColor();
	string getName();
	int getAge();
	void plusAge();
	Punkt getOldPosition();
	void setOldPosition(Punkt point);
	vector <bool> checkDirections();
	TypOrganizmu getTyp();
	bool getIsAnimal();
	
protected:
	bool isAnimal;
	int sila;
	int seed;
	int inicjatywa;
	char model;
	int color;
	int age;
	Punkt OldPosition;
	string name;
	World* world;
	Punkt pozycja;
	TypOrganizmu typOrganizmu;
	Organizm(TypOrganizmu typOrganizmu, World* world, Punkt pozycja, int sila, int inicjatywa);
};