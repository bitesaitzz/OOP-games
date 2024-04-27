#include "man.h"


Man::Man(World* world, Punkt pozycja)
	:Animal(TypOrganizmu::CZLOWIEK, world, pozycja, SILA_CZLOWIEKA, INICJATYWA_CZLOWIEKA)
{
	this->model = SYMBOL_CZLOWIEKA;
	this->color = WHITE;
	this->name = "Man";
	skillCounter = 5;
}
void Man::Akcja() {
	setOldPosition(this->getPozycja());
	string result = to_string(skillCounter);
	world->info.addInformation(result);

	switch (world->getTemp()) {
	case 1:
		if (this->getY() > 1)
		SetPozycja(getX(), getY()-1);
		break;
	case 2:
		if (this->getX() > 1)
		SetPozycja(getX() - 1, getY());
		
		break;
	case 3:
		if (this->getX() < world->getX())
		SetPozycja(getX() + 1, getY());
		break;
		
	case 4:
		if (this->getY() < world->getY())
		SetPozycja(getX() , getY()+1);
		break;
	case 5:
		SetPozycjaPunkt(getOldPosition());
		break;
	case 6:
		Skill();
		SetPozycjaPunkt(getOldPosition());
		break;
	default:
		break;
	}
	if (isSkillActivated) {
		Skill();
	}
	else if (world->getElementInMap(this->getPozycja()) != nullptr && world->getElementInMap(this->getPozycja()) != this) {
		world->getElementInMap(this->getPozycja())->Kolizja(this);
	}
	skillCounter++;
	

}


void Man::Skill() {
	if (skillCounter > 5 && isSkillActivated == false) {
	isSkillActivated = true;
	string result = "MAN GOT SKILL!";
	world->info.addInformation(result);
	skillCounter = 5;
	}
	else if (skillCounter > 10 && isSkillActivated == true) {
		isSkillActivated = false;
		string result = "MAN LOST SKILL!";
		world->info.addInformation(result);
		skillCounter = 0;
	}
	else if (isSkillActivated) {
		if (world->getElementInMap(this->getPozycja()) != nullptr) {
			Punkt temp = this->getPozycja();
			vector <bool> directions = world->getElementInMap(temp)->checkDirections();
			bool up = directions[0];
			bool left = directions[1];
			bool right = directions[2];
			bool down = directions[3];
			if (up == true) {
				world->getElementInMap(temp)->SetPozycja( temp.getX(), temp.getY() + 1 );
			}
			else if (down == true) {
				world->getElementInMap(temp)->SetPozycja(temp.getX(), temp.getY() -1);
			}
			else if (left == true) {
				world->getElementInMap(temp)->SetPozycja(temp.getX()-1, temp.getY() );
			}
			else {
				world->getElementInMap(temp)->SetPozycja(temp.getX() + 1, temp.getY());
			}
		}
		


	}

}

void Man::Kolizja(Organizm* other ) {
	if (isSkillActivated && other->getIsAnimal() == true) {
		while (other->getPozycja() == this->getPozycja() ) {
			other->Akcja();
		}
	}
	else {
		Animal::Kolizja(other);
	}
	
}
bool Man::getIsSkillActivated() {
	return isSkillActivated;
}
int Man::getskillCounter() {
	return skillCounter;
}

void Man::setIsSkillActivated(bool IsSkillActivated) {
	this->isSkillActivated = IsSkillActivated;
}
void Man::setskillCounter(int skillCounter) {
	this->skillCounter = skillCounter;
}