#pragma once 
#include "Animal.h"
#define POWER_WOLF 9
#define INICJATYWA_WOLF 5
#define MODEL_WOLF 'W'

class Wolf : public Animal {
public:
	Wolf(World* world, Punkt pozycja);

};

