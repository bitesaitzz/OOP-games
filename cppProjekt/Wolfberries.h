#pragma once
#include "Plant.h"
#define POWER_WOLFBERRIES 99
#define MODEL_WOLFBERRIES char (167)


class Wolfberries : public Plant {
public:
	Wolfberries(World* world, Punkt pozycja);
	void Kolizja(Organizm* other) override; 
};