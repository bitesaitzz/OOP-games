#include "conio.h"
#include <chrono>
#include <random>
#include <algorithm>
#include <ctime>
#include <fstream>
#include <sstream>
#include "World.h"
#include "Organizm.h"
#include "Man.h"
#include "Fox.h"
#include "Wolf.h"
#include "Sheep.h"
#include "Grass.h"




World::World(int x, int y) {

	this->x = x;
	this->y = y;
	map = new char* [y+2];
	for (int i = 0; i < y+2; i++) {
		map[i] = new char[x+2];
	}
	for (int i = 0; i < y+2; i++) {
		for (int j = 0; j < x+2; j++) {
			if (i == 0 || i == y+1 || j == 0 || j == x+1) {
				map[i][j] = '#';
			}
			else {
				map[i][j] = ' ';
			}
		}
	}
	isGame = true;
}
World::~World() {
	for (int i = 0; i < x; i++) {
		delete[] map[i];
	}
	delete[] map;

	delete man;

	for (int i = 0; i < organizmy.size(); i++) {
		delete organizmy[i];
	}

}

void World::addOrganizm(Organizm* organizm) {
	organizmy.push_back(organizm);
	map[organizm->getY()][organizm->getX()] = organizm->getModel();
}
void World::deleteOrganizm(Organizm* organizm) {
	organizmy.erase(std::remove(organizmy.begin(), organizmy.end(), organizm), organizmy.end());
}

void World::CreateWorld() {
	//Organizm* tmpOrganizm = new Man(this, { 4,4 });
	Organizm* tmpOrganizm = Organizm::createOrganizm(Organizm::TypOrganizmu::CZLOWIEK, this, { 1,1 });
	addOrganizm(tmpOrganizm);
	man = (Man*)tmpOrganizm;
	//Organizm* tmp2 = new Wolf(this, { 5,5 });
	int i = 0;
	int x = 0, y = 0;
	int temp = 0;
	while (i < getX() * getY() / 3) {
		if (i % 2 == 0 && i != 0) {
			temp = i;
			y = (rand() % 122 * temp + temp) % getY() + 1;
			x = (Randomizer() * temp - temp) % getX() + 1;
		}
		else {
			temp = i + 3;
			x = (rand() % 53 * temp + temp) % getX() + 1;
			y = (Randomizer() * temp - temp) % getY() + 1;
		}
		int a = i%10+1;
		
		
		if (getElementInMap({ x,y }) == nullptr)
			addOrganizm(Organizm::createOrganizm(static_cast<Organizm::TypOrganizmu>(a), this, { x,y }));
		i++;
	
	}/*
	addOrganizm(Organizm::createOrganizm(Organizm::TypOrganizmu::WILK, this, { 3,6 }));
	addOrganizm(Organizm::createOrganizm(Organizm::TypOrganizmu::OWCA, this, { 7,6 }));
	addOrganizm(Organizm::createOrganizm(Organizm::TypOrganizmu::TRAWA, this, { 5,5 }));
*/
}
int World::getX() {
	return x;
}
int World::getY() {
	return y;
}

void World::drawWorld() {
	drawAnimal();
	for (int i = 0; i < START_Y-1; i++) {
		cout << endl;
	}
	for (int i = 0; i < START_X+1; i++) {
		cout << " ";
	}
	for (int i = 0; i < x; i++) {
		
		cout << " " << (i + 1) % 10;
	}
	cout << endl;


	for (int i = 0; i < y+2; i++) {

		for (int k = 0; k < START_X-1; k++) {
			cout << " ";
			
			if (k == START_X - 2 && i > 0 && i != y + 1) {
				cout << i % 10;
			}
			else if (k == START_X - 2 && (i == 0 || i == y+1)) {
				cout << " ";
			}
		}
		for (int j = 0; j < x+2; j++) {
			if (getElementInMap({ j,i }) != nullptr) {
				switch (getElementInMap({ j,i })->getColor()) {
				case RED:
					cout << "\033[31m";
					break;
				case GREEN:
					cout << "\033[32m";
					break;
				case YELLOW:
					cout << "\033[33m";
					break;
				case ORANGE:
					cout << "\033[38;5;208m";
					break;
				case BROWN:
					cout << "\033[33;2m";
					break;
				case BRIGHT_RED:
					cout << "\033[38;5;196m";
					break;
				case BRIGHT_GREEN:
					cout << "\033[38;5;118m";
					break;
				case BLACK:
					cout << "\033[30m";
					break;
				case GRAY:
					cout << "\033[38;5;242m";
					break;
				
				default:
					break;
				}
			}
			cout << map[i][j] << " ";
			cout << "\033[0m";
		}
		cout << endl;
	}
	info.drawInformation();
	info.deleteAll();

}
void World::drawAnimal() {
	/*
	for (int i = 0; i < START_X; i++) {
		for (int j = 0; j < START_Y; j++) {
			cout << " ";
		}
		cout << endl;
	}
	*/
	for (int i = 0; i < y+2; i++) {
		for (int j = 0; j < x+2; j++) {
			if (i == 0 || i == y+1  || j == 0 || j == x+1) {
				map[i][j] = '#';
			}
			else {
				map[i][j] = '_';
			}
		}
	}
	for (const auto& o : organizmy) {
		map[o->getY()][o->getX()] = o->getModel();
	}

}

void World::nextStep() {
	sort(organizmy.begin(), organizmy.end(), [](Organizm* a, Organizm* b) {
		return a->GetInicjatywa() > b->GetInicjatywa();
		});

	drawAnimal();
	drawWorld();
	Controller();
	Tour++;
	string result = "Tour: " + to_string(Tour) + ".";
	info.addInformation(result);
	//for (const auto& o : organizmy) {
	for (int i = 0; i < organizmy.size(); i++) {
		auto& o = organizmy[i];
		o->Akcja();
		drawAnimal();
	}
	
	
	
}
int World::getTemp() {
	return temp;
}

void World::Controller() {
	bool pressed = false;
	while (!pressed) {
		char zn = _getch();
		if (zn == -32) {
			zn = _getch();
			switch (zn) {
			case 75:
				temp = 2;
				pressed = true;
				break;// left
			case 77:
				temp = 3;
				pressed = true;
				break;// right
			case 72:
				temp = 1;
				pressed = true;
				break;// up
			case 80:
				temp = 4;//down
				pressed = true;
				break;
			
			default:
				break;
			}
		}
		else if (zn == '\r') {
			temp = 5;
			pressed = true;
		}
		else if (zn == 's') {
			temp = 6;
			pressed = true;

		}
		else if (zn == 'q') {
			isGame = false;
			pressed = true;
		}
		else if (zn == 'c') {
			info.deleteAll();
			
		}
		else if (zn == 'g') {
			saveTheGame();
			pressed = true;
			break;
		}
		else if (zn == 'l') {
			openTheGame();
			pressed = true;
			break;
		}
	}

}
Organizm* World::getElementInMap(Punkt pozycja) {
	char a = map[pozycja.getY()][pozycja.getX()];
	
		for (const auto& o : organizmy) {
			if (o->getX() == pozycja.getX() && o->getY() == pozycja.getY() && a == o->getModel()) {
				return o;
			}
		}
	
	
		return nullptr;
	
}
int World::Randomizer() {
	auto now = std::chrono::high_resolution_clock::now();
	auto ms = std::chrono::duration_cast<std::chrono::milliseconds>(now.time_since_epoch());
	mt19937 gen(ms.count());
	uniform_int_distribution<> dis(0, 999);
	return dis(gen);
}

bool World::getIsGame() {
	return isGame;
}

void World::setTour(int Tour) {
	this->Tour = Tour;
}
int World::getTour() {
	return Tour;
}

void World::saveTheGame() {
	system("cls");
	cout << "Enter the name of the game: ";
	string result;
	cin >> result;
	ofstream file(result);
	if (file.is_open()) {
		file << x << " " << y << " " << temp << endl;


		for (int i = 0; i < y+2; i++) {
			for (int j = 0; j < x+2; j++) {
				file << map[i][j] << " ";
			}
			file << endl;
		}

		file << Tour << endl;



		for (int i = 0; i < organizmy.size(); i++) {
			auto& org = organizmy[i];
			if (int(org->getTyp()) == 0) {
				file << int(org->getTyp()) << " " << org->getX() << " " << org->getY() << " " << org->getAge() << " " << org->GetSila() << " " << man->getIsSkillActivated() << " " << man->getskillCounter() << endl;
			}
			else
			{
				file << int(org->getTyp()) << " " << org->getX() << " " << org->getY() << " " << org->getAge() << " " << org->GetSila() << std::endl;
			}
		}

		file << isGame << endl;
		file.close();
		string temp = "Successfuly saved.";
		drawAnimal();
		drawWorld();
	}
	
	
	}


void World::openTheGame() {
	system("cls");
	cout << "Enter the name of the game: ";
	string name;
	cin >> name;
	ifstream file(name);
	if (file.is_open()) {

		string line;
		stringstream ss;

		// чтение размеров игрового поля и временного параметра
		getline(file, line);
		ss << line;
		ss >> x >> y >> temp;
		ss.clear();

		// создание двумерного массива для карты
		map = new char* [y+2];
		for (int i = 0; i < y+2; i++) {
			map[i] = new char[x+2];
		}
		for (int i = 0; i < y+2; i++) {
			getline(file, line);
			ss << line;
			for (int j = 0; j < x+2; j++) {
				ss >> map[i][j];
			}
			ss.clear();
		}
		for (auto org : organizmy) {
			delete org;
		}
		organizmy.clear();
	getline(file, line);
		ss << line;
		ss >> Tour;
		ss.clear();
		while (file) {
			int orgType, orgX, orgY, orgAge, orgSila;
			bool isSkillActivated;
			int skillCounter;
			file >> orgType >> orgX >> orgY >> orgAge >> orgSila;
			Punkt temp(orgX, orgY);
			if (orgType == 0) {
				file >> isSkillActivated >> skillCounter;
				
				Organizm* org = Organizm::createOrganizm(static_cast<Organizm::TypOrganizmu>(orgType), this, temp);
				man = (Man*)org;
				man->setIsSkillActivated(isSkillActivated);
				man->setskillCounter(skillCounter);
				addOrganizm(org);
			}
			else {
				addOrganizm(Organizm::createOrganizm(static_cast<Organizm::TypOrganizmu>(orgType), this, temp));
				
			}
		}
		file.close();
		string temp = "Successfuly loaded.";
		info.deleteAll();
		drawAnimal();
		drawWorld();
		
		}


	
}




