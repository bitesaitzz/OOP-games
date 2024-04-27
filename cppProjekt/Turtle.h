#pragma once
#define POWER_TURTLE 2
#define INICJATYWA_TURTLE 1
#define MODEL_TURTLE 'T'

#include "Animal.h"

class Turtle: public Animal {
public:
	Turtle(World* world, Punkt pozycja);
	void Akcja() override;
	void Kolizja(Organizm* other) override;
};