#include "Organizm.h"
#include "Man.h"
#include "Wolf.h"
#include "Grass.h"
#include "Sheep.h"
#include "Fox.h"
#include "Turtle.h"
#include "Antelope.h"
#include "Dandelion.h"
#include "Guarana.h"
#include "Wolfberries.h"
#include "Pine_Hogweed.h"
Organizm::Organizm(TypOrganizmu typOrganizmu,World* world, Punkt pozycja, int sila, int inicjatywa)
{
	this->typOrganizmu = typOrganizmu;
	this->world = world;
	this->pozycja = pozycja;
	//this->color
	//this->turaUrodzenia = turaUrodzenia;
	this->sila = sila;
	this->inicjatywa = inicjatywa;
	this->age = 0;
}

void Organizm::Drawing() {

	cout << model;
}

int Organizm::GetSila() {
	return sila;
}
void Organizm::SetSila(int sila) {
	this->sila = sila;
}
int Organizm::GetInicjatywa() {
	return inicjatywa;
}
void Organizm::SetInicjatywa(int inicjatywa) {
	this->inicjatywa = inicjatywa;
}
void Organizm::SetPozycja(int x, int y)
{
	pozycja.setX(x);
	pozycja.setY(y);
}
Punkt Organizm::getPozycja() {
	return pozycja;
}
void Organizm::setModel(char model) {
	this->model = model;
}

int Organizm::getX() {
	return pozycja.getX();
}
int Organizm::getY() {
	return pozycja.getY();
}
char Organizm::getModel() {
	return model;
}
int Organizm::getColor() {
	return color;
}
string Organizm::getPozycjaStr() {
	return "[" + to_string(getX()) + ", " + to_string(getY()) + "]";
}
string Organizm::getName() {
	return name;
}
Organizm* Organizm::createOrganizm(TypOrganizmu typ,World* world, Punkt pozycja) {
	switch (typ) {
	case TypOrganizmu::CZLOWIEK:
		return new Man(world, pozycja);
	case TypOrganizmu::WILK:
		return new Wolf(world, pozycja);
	case TypOrganizmu::OWCA:
		return new Sheep(world, pozycja);
	case TypOrganizmu::TRAWA:
		return new Grass(world, pozycja);
	case TypOrganizmu::FOX:
		return new Fox(world, pozycja);
	case TypOrganizmu::TURTLE:
		return new Turtle(world, pozycja);
	case TypOrganizmu::ANTELOPE:
		return new Antelope(world, pozycja);
	case TypOrganizmu::DANDELION:
		return new Dandelion(world, pozycja);
	case TypOrganizmu::GUARANA:
		return new Guarana(world, pozycja);
	case TypOrganizmu::WOLFBERRIES:
		return new Wolfberries(world, pozycja);

	case TypOrganizmu::PINE_HOGWEED:
		return new Pine_Hogweed(world, pozycja);
	}
}

int Organizm::getAge() {
	return age;
}
void Organizm::plusAge() {
	age += 1;
}
Punkt Organizm::getOldPosition() {
	return OldPosition;
}
void Organizm::SetPozycjaPunkt(Punkt point) {
	pozycja.setX(point.getX());
	pozycja.setY(point.getY());
}
void Organizm::setOldPosition(Punkt point) {
	OldPosition.setX(point.getX());
	OldPosition.setY(point.getY());
}

vector <bool> Organizm::checkDirections() {
	bool left = true;
	bool right = true;
	bool up = true;
	bool down = true;
	vector <bool> directions;
	if (START_X + getX() - 2 < START_X) {
		left = false;
	}
	else if (START_X + getX() + 2 > START_X + world->getX()) {
		right = false;
	}
	if (START_Y + getY() - 2 < START_Y) {
		up = false;
	}
	else if (START_Y + getY() + 3 > START_Y + world->getY()) {
		down = false;
	}
	directions.push_back(up);
	directions.push_back(left);
	directions.push_back(right);
	directions.push_back(down);
	setOldPosition(this->getPozycja());
	return directions;

}

bool Organizm::getIsAnimal() {
	return isAnimal;
}

Organizm::TypOrganizmu Organizm::getTyp()
{
	return typOrganizmu;
}