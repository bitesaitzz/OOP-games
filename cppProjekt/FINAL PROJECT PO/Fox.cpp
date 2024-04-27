#pragma once
#include "Fox.h"
#define POWER_FOX 3
#define INICJATYWA_FOX 7
#define MODEL_FOX 'F'

Fox::Fox(World* world, Punkt pozycja)
	:Animal(TypOrganizmu::WILK, world, pozycja, POWER_FOX, INICJATYWA_FOX){
	this->model = MODEL_FOX;
	this->color = ORANGE;
	this->name = "Fox";
	}
void Fox::Akcja() {
	vector <bool> directions = checkDirections();
	bool up = directions[0];
	bool left = directions[1];
	bool right = directions[2];
	bool down = directions[3];
	Punkt oldPosition(this->getX(), this->getY());
	Punkt temp1 = { this->getPozycja().getX(), this->getPozycja().getY()-1 };
	Punkt temp2 = { this->getPozycja().getX()-1, this->getPozycja().getY() };
	Punkt temp3 = { this->getPozycja().getX()+1, this->getPozycja().getY() };
	Punkt temp4 = { this->getPozycja().getX(), this->getPozycja().getY()+1 };
	
		int a = rand() % 100;
		if (a >= 0 && a < 25 && up == true && (world->getElementInMap(temp1) == nullptr || world->getElementInMap(temp1)->GetSila() < this->GetSila())) {
			this->SetPozycjaPunkt(temp1);
			if(world->getElementInMap(temp1) != nullptr)
				world->getElementInMap(temp1)->Kolizja(this);
			
		}
		else if (a >= 25 && a < 50 && left == true && (world->getElementInMap(temp2) == nullptr || world->getElementInMap(temp2)->GetSila() < this->GetSila())) {
			this->SetPozycjaPunkt(temp2);
			if(world->getElementInMap(temp2) != nullptr)
			world->getElementInMap(temp2)->Kolizja(this);
			
		}

		else if (a >= 50 && a < 75 && right == true && (world->getElementInMap(temp3) == nullptr || world->getElementInMap(temp3)->GetSila() < this->GetSila())) {
			this->SetPozycjaPunkt(temp3);
			if(world->getElementInMap(temp3) != nullptr)
			world->getElementInMap(temp3)->Kolizja(this);
		
		}
			
		else if (a >= 75 && a < 100 && down == true && (world->getElementInMap(temp4) == nullptr || world->getElementInMap(temp4)->GetSila() < this->GetSila())) {
			this->SetPozycjaPunkt(temp4);
			if(world->getElementInMap(temp4) != nullptr)
			world->getElementInMap(temp4)->Kolizja(this);
			
		}

	
}