#include "Wolf.h"

Wolf::Wolf(World* world, Punkt pozycja)
	:Animal(TypOrganizmu::WILK, world, pozycja, POWER_WOLF, INICJATYWA_WOLF)
{
	this->model = MODEL_WOLF;
	this->color = GRAY;
	this->name = "Wolf";
}



