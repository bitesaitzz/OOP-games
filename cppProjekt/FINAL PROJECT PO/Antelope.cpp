#pragma once
#include "Antelope.h"

Antelope::Antelope(World* world, Punkt pozycja)
	:Animal(TypOrganizmu::ANTELOPE, world, pozycja, POWER_ANTELOPE, INICJATYWA_ANTELOPE) {
	this->model = MODEL_ANTELOPE;
	this->color = BROWN;
	this->name = "Antelope";
}
void Antelope::Akcja() {
	bool left = true;
	bool right = true;
	bool up = true;
	bool down = true;
	if (START_X + getX() - 3 < START_X) {
		left = false;
	}
	else if (START_X + getX() + 3 > START_X + world->getX()) {
		right = false;
	}
	if (START_Y + getY() - 3 < START_Y) {
		up = false;
	}
	else if (START_Y + getY() + 4 > START_Y + world->getY()) {
		down = false;
	}


	while (true) {
		int a = rand() % 100;


		if (a >= 0 && a < 25 && up == true) {
			SetPozycja(this->getX(), this->getY() - 2);
			break;
		}
		else if (a >= 25 && a < 50 && down == true) {
			SetPozycja(this->getX(), this->getY() + 2);
			break;
		}

		else if (a >= 50 && a < 75 && left == true) {
			SetPozycja(this->getX() - 2, this->getY());
			break;
		}
		else if (a >= 75 && right == true) {
			SetPozycja(this->getX() + 2, this->getY());
			break;
		}

	}
	if (world->getElementInMap(this->getPozycja()) != nullptr && world->getElementInMap(this->getPozycja())->getModel() != this->getModel()) {
		world->getElementInMap(this->getPozycja())->Kolizja(this);
	}
	else if (world->getElementInMap(this->getPozycja()) != nullptr && world->getElementInMap(this->getPozycja())->getModel() == this->getModel() && this->getAge() > 5 && world->getElementInMap(this->getPozycja())->getAge() > 5) {

		Breeding(world->getElementInMap(this->getPozycja()));
		this->SetPozycja(getOldPosition().getX(), getOldPosition().getY());
	}
	this->plusAge();
}
void Antelope::Kolizja(Organizm* other) {
	int a = rand() % 100;
	if (a >= 50) {
		vector <bool> directions = checkDirections();
		bool up = directions[0];
		bool left = directions[1];
		bool right = directions[2];
		bool down = directions[3];
		if (up == true && world->getElementInMap({ this->getX(), this->getY() - 1 }) == nullptr) {
			this->SetPozycjaPunkt({ this->getX(), this->getY() - 1 });
			string result = this->getName() + " ran away from " + other->getName() + " to the position " + this->getPozycjaStr() + ".";
			world->info.addInformation(result);
			
		}
		else if (down == true && world->getElementInMap({ this->getX(), this->getY() + 1 }) == nullptr) {
			this->SetPozycjaPunkt({ this->getX(), this->getY() + 1 });
			string result = this->getName() + " ran away from " + other->getName() + " to the position " + this->getPozycjaStr() + ".";
			world->info.addInformation(result);
		}
		else if (left == true && world->getElementInMap({ this->getX() - 1, this->getY() }) == nullptr) {
			this->SetPozycjaPunkt({ this->getX() - 1, this->getY() });
			string result = this->getName() + " ran away from " + other->getName() + " to the position " + this->getPozycjaStr() + ".";
			world->info.addInformation(result);
		}
		else if (right == true && world->getElementInMap({ this->getX() + 1, this->getY() }) == nullptr) {
			this->SetPozycjaPunkt({ this->getX() + 1, this->getY() });
			string result = this->getName() + " ran away from " + other->getName() + " to the position " + this->getPozycjaStr() + ".";
			world->info.addInformation(result);
		}
		else {
			a = 49;
		}
	}
	if (a < 50){
		if (this->GetSila() > other->GetSila()) {
			world->deleteOrganizm(other);
			if (other->GetSila() > 0) {
				string result = this->getName() + " killed " + other->getName() + " on position " + this->getPozycjaStr() + ".";
				world->info.addInformation(result);
			}
		}
		else if (this->GetSila() < other->GetSila()) {

			string result = other->getName() + " killed " + this->getName() + " on position " + this->getPozycjaStr() + ".";
			world->info.addInformation(result);
			world->deleteOrganizm(this);
		}
		else if (this->getAge() > other->getAge()) {
			string result = this->getName() + " killed " + other->getName() + " on position " + this->getPozycjaStr() + ".";
			world->info.addInformation(result);
			world->deleteOrganizm(other);

		}
		else {
			string result = other->getName() + " killed " + this->getName() + " on position " + this->getPozycjaStr() + ".";
			world->info.addInformation(result);
			world->deleteOrganizm(this);
		}

		
	}
}

