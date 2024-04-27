#pragma once
#include "Organizm.h"

class Plant : public Organizm {
public:
	virtual void Akcja() override;
protected:
	Plant(TypOrganizmu typOrganizmu, World* world, Punkt pozycja, int sila);
	void Growth();
private:
	void Kolizja(Organizm* other) override;
};