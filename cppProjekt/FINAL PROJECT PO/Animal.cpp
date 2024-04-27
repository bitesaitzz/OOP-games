#include "Animal.h"
#include "Turtle.h"

vector <bool> Animal::checkDirections() {
	bool left = true;
	bool right = true;
	bool up = true;
	bool down = true;
	vector <bool> directions;
	if ( getX() - 2 < 0) {
		left = false;
	}
	else if (getX() + 2 >  world->getX()) {
		right = false;
	}
	if ( getY() - 2 < 0) {
		up = false;
	}
	else if ( getY() + 1 > world->getY()) {
		down = false;
	}
	directions.push_back(up);
	directions.push_back(left);
	directions.push_back(right);
	directions.push_back(down);
	setOldPosition(this->getPozycja());
	return directions;

}

void Animal::Akcja() {
	/*
	bool left = true;
	bool right = true;
	bool up = true;
	bool down = true;
	if (START_X + getX() - 2 < START_X) {
		left = false;
	}
	else if (START_X + getX() + 2> START_X + world->getX()) {
		right = false;
	}
	if (START_Y + getY() - 2 < START_Y) {
		up = false;
	}
	else if (START_Y + getY() + 3> START_Y + world->getY()) {
		down = false;
	}
	*/
	/// <summary>
	/// tut
	/// </summary>
	
	
	vector <bool> directions = checkDirections();
	bool up = directions[0];
	bool left = directions[1];
	bool right = directions[2];
	bool down = directions[3];
	
	
	
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
		world->getElementInMap(this->getPozycja())->Kolizja(this);
	}
	else if(world->getElementInMap(this->getPozycja()) != nullptr && world->getElementInMap(this->getPozycja())->getModel() == this->getModel() && this->getAge() > 5 && world->getElementInMap(this->getPozycja())->getAge() > 5){
	
		Breeding(world->getElementInMap(this->getPozycja()));
		this->SetPozycja(getOldPosition().getX(), getOldPosition().getY());
	}
	this->plusAge();
}

void Animal::Kolizja(Organizm* other) {
	
	if (this->GetSila()>other->GetSila()) {
		world->deleteOrganizm(other);
		if (other->GetSila() > 0) {
			string result = this->getName()+ " killed " + other->getName() + " on position "+this->getPozycjaStr()+".";
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



Animal::Animal(TypOrganizmu typOrganizmu, World* world, Punkt pozycja, int sila, int inicjatywa)
	:Organizm(typOrganizmu, world, pozycja, sila, inicjatywa)
{
	int seed = std::chrono::duration_cast<std::chrono::milliseconds>(
		std::chrono::system_clock::now().time_since_epoch()
		).count();
	std::srand(seed);
	this->isAnimal = true;
}
void Animal::Breeding(Organizm* other) {
	vector <bool> directions = checkDirections();
	bool up = directions[0];
	bool left = directions[1];
	bool right = directions[2];
	bool down = directions[3];
	Punkt newPosition;
	if (world->getElementInMap({this->getX()+1, this->getY()}) == nullptr && right == true) {
		newPosition.setX(this->getX() + 1);
		newPosition.setY(this->getY());
	}
	else if (world->getElementInMap({ this->getX() - 1, this->getY() }) == nullptr && left == true) {
		newPosition.setX(this->getX() - 1);
		newPosition.setY(this->getY());
	}
	else if (world->getElementInMap({ this->getX() , this->getY()-1 }) == nullptr && up == true) {
		newPosition.setX(this->getX() );
		newPosition.setY(this->getY() -1);
	}
	else {
		newPosition.setX(this->getX());
		newPosition.setY(this->getY() + 1);
	}
	
	world->addOrganizm(createOrganizm(this->typOrganizmu, this->world, newPosition));
	string result = "A new " + this->getName() + " was born in the position ";
	world->info.addInformation(result);
}

