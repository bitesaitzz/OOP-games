#include "Plant.h"

Plant::Plant(TypOrganizmu typOrganizmu, World* world, Punkt pozycja, int sila):
	Organizm(typOrganizmu,world , pozycja, sila, inicjatywa) {
	this->world = world;
	this->typOrganizmu = typOrganizmu;
	this->world = world;
	this->pozycja = pozycja;
	this->sila = sila;
	this->inicjatywa = 0;
	this->isAnimal = false;
	
}
void Plant::Akcja() {
	int a = rand() % 100;
	if (a > 80) {
		Growth();
	}
}
void Plant::Growth() {
	int a = rand() % 4;
	Punkt newTemp = this->getPozycja();
	
	switch (a) {
	case 0:
		if (this->getY() - 2 > 0 )
		newTemp = { this->getX(), this->getY() - 1 };
		break;
	case 1:
		if (this->getX() - 2 > 0)
		newTemp = { this->getX() - 1, this->getY() };
		break;
	case 2:
		if (this->getX() + 2 < world->getX())
		newTemp = { this->getX() + 1, this->getY() };
		break;
	case 3:
		if (this->getY() + 3 < world->getY())
		newTemp = { this->getX() , this->getY() + 1 };
		break;
	default:
		break;
	}
	if (world->getElementInMap(newTemp) == nullptr ) {
		world->addOrganizm(createOrganizm(this->typOrganizmu, this->world, newTemp));
	}

	
}
void Plant::Kolizja(Organizm* other) {
	world->deleteOrganizm(this);
}