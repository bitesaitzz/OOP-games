#pragma once
#include "Animal.h"

class Fox : public Animal {
public:
	Fox(World* world, Punkt pozycja);
	void Akcja() override;
};