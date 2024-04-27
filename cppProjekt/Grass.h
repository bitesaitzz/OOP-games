#pragma once
#include "Plant.h"
#define POWER_GRASS 0

class Grass : public Plant {
public:
	Grass(World* world, Punkt pozycja);
};