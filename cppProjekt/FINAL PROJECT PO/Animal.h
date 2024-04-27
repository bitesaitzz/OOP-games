#pragma once
#include "Organizm.h"
#include <cstdlib>
#include <ctime>
#include <chrono>

class Animal : public Organizm {
protected:
	Animal(TypOrganizmu typOrganizmu, World* world, Punkt pozycja, int sila, int inicjatywa);
	
	
public:
	
	
	virtual void Akcja() override;
	void Breeding(Organizm* other);
	virtual void Kolizja(Organizm* other) override;
	vector <bool> checkDirections();
};