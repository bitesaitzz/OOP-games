#pragma once
#include "Turtle.h"
#define POWER_TURTLE 2
#define INICJATYWA_TURTLE 1
#define MODEL_TURTLE 'T'
Turtle::Turtle(World* world, Punkt pozycja)
	:Animal(TypOrganizmu::WILK, world, pozycja, POWER_TURTLE, INICJATYWA_TURTLE) {
	this->model = MODEL_TURTLE;
	this->color = GREEN;
	this->name = "Turtle";
}
void Turtle::Akcja() {
	vector <bool> directions = checkDirections();
	bool up = directions[0];
	bool left = directions[1];
	bool right = directions[2];
	bool down = directions[3];
	Punkt oldPosition(this->getX(), this->getY());
	int goOrNo = rand() % 100;
	if (goOrNo > 75) {
		while (true) {
			int a = rand() % 100;


			if (a >= 0 && a < 25 && up == true) {
				SetPozycja(this->getX(), this->getY() - 1);
				break;
			}
			else if (a >= 25 && a < 50 && down == true) {
				SetPozycja(this->getX(), this->getY() + 1);
				break;
			}

			else if (a >= 50 && a < 75 && left == true) {
				SetPozycja(this->getX() - 1, this->getY());
				break;
			}
			else if (a >= 75 && right == true) {
				SetPozycja(this->getX() + 1, this->getY());
				break;
			}

		}
		if (world->getElementInMap(this->getPozycja()) != nullptr && world->getElementInMap(this->getPozycja())->getModel() != this->getModel()) {
			Kolizja(world->getElementInMap(this->getPozycja()));
		}
		else if (world->getElementInMap(this->getPozycja()) != nullptr && world->getElementInMap(this->getPozycja())->getModel() == this->getModel() && this->getAge() > 5 && world->getElementInMap(this->getPozycja())->getAge() > 5) {

			Breeding(world->getElementInMap(this->getPozycja()));
			this->SetPozycja(oldPosition.getX(), oldPosition.getY());
		}
		
	}
	this->plusAge();

}
void Turtle::Kolizja(Organizm * other) {
	if (other->GetSila() > 5) {
		world->deleteOrganizm(this);
		string result = other->getName() + " killed " + this->getName() + " on position " + this->getPozycjaStr() + ".";
		world->info.addInformation(result);
	}
	else {
		other->SetPozycjaPunkt(other->getOldPosition());
		string result = this->getName() + " kicked out " + other->getName() + " on position " + this->getPozycjaStr() + ".";
		world->info.addInformation(result);
	}
}