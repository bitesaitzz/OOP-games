#pragma once
#pragma once
#include "Wolfberries.h"
Wolfberries::Wolfberries(World* world, Punkt pozycja) :
	Plant(TypOrganizmu::WOLFBERRIES, world, pozycja, POWER_WOLFBERRIES) {
	this->color = RED;
	this->inicjatywa = 0;
	this->model = MODEL_WOLFBERRIES;
	this->name = "Wolfberries";
}
void Wolfberries::Kolizja(Organizm* other) {
	
	string result = other->getName() + " ate " + this->getName() + " and dead on position " + this->getPozycjaStr() + ".";
	world->info.addInformation(result);
	world->deleteOrganizm(this);
	world->deleteOrganizm(other);
}