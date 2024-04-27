#include "Grass.h"

Grass::Grass(World* world, Punkt pozycja) :
	Plant(TypOrganizmu::TRAWA, world, pozycja, POWER_GRASS) {
	this->color = GREEN;
	this->model = char(176);
	this->name = "Grass";
}
