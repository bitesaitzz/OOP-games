#pragma once
#include "Plant.h"
#define POWER_GUARANA 0
#define MODEL_GUARANA char(207)


class Guarana : public Plant {
public:
	Guarana(World* world, Punkt pozycja);
	void Kolizja(Organizm* org) override;
};