#pragma once
#include "Guarana.h"

Guarana::Guarana(World* world, Punkt pozycja) :
	Plant(TypOrganizmu::GUARANA, world, pozycja, POWER_GUARANA) {
	this->color = BRIGHT_RED;
	this->inicjatywa = 0;
	this->model = MODEL_GUARANA;
	this->name = "Guarana";
}
void Guarana::Kolizja(Organizm* other) {
	other->SetSila(other->GetSila() + 3);
	string result = other->getName() + " ate " + this->getName() + " on position " + this->getPozycjaStr() + ".";
	world->info.addInformation(result);
	world->deleteOrganizm(this);
}