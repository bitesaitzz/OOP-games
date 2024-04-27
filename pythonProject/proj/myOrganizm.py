
from abc import ABC, abstractmethod

from proj.myPoint import Point
from proj.myWorld import World


class Organizm(ABC):
    _point: Point

    def __init__(self, world: World, point: Point, power=0, initiative=0, age=0):
        self._world = world
        #self._position = position
        # self._colour = colour
        self._point = point
        self._power = power
        self._initiative = initiative
        self._sign = None
        self._typ = None
        self._age = age
        self.isAnimal = False

    def getTyp(self):
        return self._typ
    def getSila(self):
        return self._power
    def setPower(self, power):
        self._power = power
    def getInitiative(self):
        return self._initiative
    def setInitiative(self, initiative):
        self._initiative = initiative
    def returnColor(self):
        pass
    def returnPower(self):
        pass
    def returnInitiative(self):
        pass
    def getSign(self):
        return self._sign
    def setPosition(self, point):
        set(self._point, point)
    def getPosition(self):
        return self._point
    def getPositionX(self):
        return self._point.getX()

    def getPositionY(self):
        return self._point.getY()
    def Kolizja(self):
        pass
    def Akcja(self):
        pass
    def plusAge(self):
        self._age += 1
    def getAge(self):
        return self._age
    def getIsAnimal(self):
        return self.isAnimal
    def setTyp(self, typ):
        self._typ = typ