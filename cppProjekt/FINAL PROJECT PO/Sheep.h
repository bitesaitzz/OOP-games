#pragma once
#include "Animal.h"
#define INICJATYWA_SHEEP 4
#define POWER_SHEEP 4
#define MODEL_SHEEP 'O'

class Sheep : public Animal {
public:
	Sheep(World* world, Punkt pozycja);

};