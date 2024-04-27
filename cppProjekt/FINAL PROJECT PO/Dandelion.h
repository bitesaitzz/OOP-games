#pragma once
#include "Plant.h"
#define POWER_DANDELION 0
#define MODEL_DANDELION char(190)


class Dandelion : public Plant {
public:
	Dandelion(World* world, Punkt pozycja);
	void Akcja() override;
};