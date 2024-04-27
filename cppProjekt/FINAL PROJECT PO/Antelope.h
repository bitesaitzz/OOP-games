#pragma once
#include "Animal.h"
#define POWER_ANTELOPE 4
#define INICJATYWA_ANTELOPE 4
#define MODEL_ANTELOPE 'A'

class Antelope : public Animal {
public:
	Antelope(World* world, Punkt pozycja);
	void Akcja() override;
	void Kolizja(Organizm* other) override;
};