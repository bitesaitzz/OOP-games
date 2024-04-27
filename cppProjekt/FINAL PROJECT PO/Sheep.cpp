#include "Sheep.h"

Sheep::Sheep(World* world, Punkt pozycja)
	:Animal(TypOrganizmu::OWCA, world, pozycja, POWER_SHEEP, INICJATYWA_SHEEP)
{
	this->model = MODEL_SHEEP;
	this->name = "Sheep";
}