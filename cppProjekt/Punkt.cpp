#include "Punkt.h"

Punkt::Punkt(int x, int y) {
	this->x = x;
	this->y = y;
}
Punkt::Punkt() {
	x = 1;
	y = 1;
}
void Punkt::setX(int x) {
	this->x = x;
}
void Punkt::setY(int y) {
	this->y = y;
}
int Punkt::getX() {
	return x;
}
int Punkt::getY() {
	return y;
}
bool Punkt::operator==(const Punkt& other) {
	return (x == other.x) && (y == other.y);
}