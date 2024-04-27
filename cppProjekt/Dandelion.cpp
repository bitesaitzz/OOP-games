#pragma once
#include "Dandelion.h"

Dandelion::Dandelion(World* world, Punkt pozycja) :
	Plant(TypOrganizmu::DANDELION, world, pozycja, POWER_DANDELION) {
	this->color = YELLOW;
	this->inicjatywa = 0;
	this->model = MODEL_DANDELION;
	this->name = "Dandelion";
}

void Dandelion::Akcja() {
	for (int i = 0; i < 3; i++) {
		int a = rand() % 100;
		if (a > 90) {
			Growth();
		}
	}
}