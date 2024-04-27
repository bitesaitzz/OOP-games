#pragma once
#include "Pine_Hogweed.h"

Pine_Hogweed::Pine_Hogweed(World* world, Punkt pozycja) :
	Plant(TypOrganizmu::PINE_HOGWEED, world, pozycja, POWER_PINE_HOGWEED) {
	this->color = BRIGHT_GREEN;
	this->inicjatywa = 0;
	this->model = MODEL_PINE_HOGWEED;
	this->name = "Pine Hogweed";
}

void Pine_Hogweed::Akcja() {
	if (world->getElementInMap({ this->getPozycja().getX(), this->getPozycja().getY() - 1 }) != nullptr && world->getElementInMap({ this->getPozycja().getX(), this->getPozycja().getY() - 1 })->getIsAnimal() == true) {
		Organizm* temp = world->getElementInMap({ this->getPozycja().getX(), this->getPozycja().getY() - 1 });
		string result = temp->getName() + " touched " + this->getName() + " and died of a burn on the position " + temp->getPozycjaStr() + ".";
		world->info.addInformation(result);
		world->deleteOrganizm(temp);
	}
	if(world->getElementInMap({ this->getPozycja().getX()-1, this->getPozycja().getY() }) != nullptr && world->getElementInMap({ this->getPozycja().getX() -1, this->getPozycja().getY() })->getIsAnimal() == true) {
		Organizm* temp = world->getElementInMap({ this->getPozycja().getX()-1, this->getPozycja().getY() });
		string result = temp->getName() + " touched " + this->getName() + " and died of a burn on the position " + temp->getPozycjaStr() + ".";
		world->info.addInformation(result);
		world->deleteOrganizm(temp);
	}
	 if(world->getElementInMap({ this->getPozycja().getX()+1, this->getPozycja().getY()  }) != nullptr && world->getElementInMap({ this->getPozycja().getX()+1, this->getPozycja().getY()  })->getIsAnimal() == true) {
		Organizm* temp = world->getElementInMap({ this->getPozycja().getX()+1, this->getPozycja().getY()  });
		string result = temp->getName() + " touched " + this->getName() + " and died of a burn on the position " + temp->getPozycjaStr() + ".";
		world->info.addInformation(result);
		world->deleteOrganizm(temp);
	}
	if(world->getElementInMap({ this->getPozycja().getX(), this->getPozycja().getY() +1 }) != nullptr && world->getElementInMap({ this->getPozycja().getX(), this->getPozycja().getY() + 1 })->getIsAnimal() == true) {
		Organizm* temp = world->getElementInMap({ this->getPozycja().getX(), this->getPozycja().getY() + 1 });
		string result = temp->getName() + " touched " + this->getName() + " and died of a burn on the position " + temp->getPozycjaStr() + ".";
		world->info.addInformation(result);
		world->deleteOrganizm(temp);
	}
	else {
		int a = rand() % 100;
		if (a > 92) {
			Growth();
		}
	}
}

void Pine_Hogweed::Kolizja(Organizm* other) {
	if (other->getIsAnimal() == true) {
		string result = other->getName() + " ate " + this->getName() + " and dead on position " + this->getPozycjaStr() + ".";
		world->info.addInformation(result);
		//world->deleteOrganizm(this);
		world->deleteOrganizm(other);
	}
}