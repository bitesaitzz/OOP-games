#pragma once

#include "Plant.h"
#define MODEL_PINE_HOGWEED char(178)
#define POWER_PINE_HOGWEED 10


class Pine_Hogweed : public Plant {
public:
	Pine_Hogweed(World* world, Punkt pozycja);
	void Akcja() override;
	void Kolizja(Organizm* other) override;
};
