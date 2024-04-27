#include "Information.h"

void Information::addInformation(string& str) {
    strings.push_back(str);
}
void Information::drawInformation() {
    for (const auto& str : strings) {
       cout << str <<endl;
    }
}

void Information::deleteAll() {
    strings.clear();
}