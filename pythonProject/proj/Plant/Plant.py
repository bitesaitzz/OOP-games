import proj.myOrganizm
from random import *
from proj.myOrganizm import Point
from proj.myWorld import World
class Plant(proj.myOrganizm.Organizm):
    def __init__(self, world: World, point: Point, power=0, initiative=0, age=0):

        super().__init__(world, point, power, initiative, age)
        self.isAnimal = True
    def Kolizja(self, org):
        self._world.deleteOrganizm(self)


    def Akcja(self):
        a = randint(0, 100)
        if (a > 93):
            self.growth()

    def growth(self):
        a = randint(0, 3)
        newTemp = self._point
        if(a==0):
            if (self._point.getY() - 1 > 0):
                newTemp = Point(self._point.getX(), self._point.getY() - 1)
                
        elif(a==1):
            if (self._point.getX() - 1 > 0):
                newTemp = Point(self._point.getX() - 1, self._point.getY())
           

        elif(a==2):
            if (self._point.getX() + 2 < self._world.getX()):
                newTemp = Point(self._point.getX() + 1, self._point.getY())
        elif(a==3):
            if (self._point.getY() + 2 < self._world.getY()):
                newTemp = Point(self._point.getX(), self._point.getY() + 1)
        
        
        if (self._world.whoIs(newTemp, newTemp) == None):
            self._world.createOrganizm(self.getTyp(), newTemp)

