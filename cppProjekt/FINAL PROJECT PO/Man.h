#pragma once
#include "Animal.h"
#define SYMBOL_CZLOWIEKA 'C'
#define ZASIEG_RUCHU_CZLOWIEKA 1
#define SZANSA_WYKONYWANIA_RUCHU_CZLOWIEKA 1
#define SILA_CZLOWIEKA 5
#define INICJATYWA_CZLOWIEKA 4



class Man : public Animal {
private:
	int skillCounter;
	bool isSkillActivated;
public:
	Man(World* world, Punkt pozycja);
	void Akcja() override;
	void Skill();
	void Kolizja(Organizm*other) override;
	bool getIsSkillActivated();
	int getskillCounter();
	void setIsSkillActivated(bool IsSkillActivated);
	void setskillCounter(int skillCounter);
		
	
	
};