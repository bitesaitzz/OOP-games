from proj.Plant.Plant import *

class Heracleum(Plant):
    def __init__(self, world: World, point: Point, initiative, power, age):
        super().__init__(world, point, 98, 0, 0)
        self.age = age
        self._typ = 10
        self._sign = 'H'
    def getColor(self):
        return (204, 255, 153)

    def Kolizja(self, org):
        if(org.getSign() != 'C'):
            self._world.deleteOrganizm(org);
        self._world.deleteOrganizm(self);

    def Akcja(self):

        if (self._world.whoIs( Point(self._point.getX(), self._point.getY()-1), self) != None
        and self._world.whoIs( Point(self._point.getX(), self._point.getY()-1), self).getIsAnimal() == True ) :

            temp = self._world.whoIs( Point(self._point.getX(), self._point.getY()-1), self);
            if (temp.getSign() != self.getSign() and temp.getSign() != 'C'):
                self._world.deleteOrganizm(temp);

        
        if (self._world.whoIs( Point(self._point.getX(), self._point.getY()+1), self) != None
        and self._world.whoIs( Point(self._point.getX(), self._point.getY()+1), self).getIsAnimal() == True ) :
            temp = self._world.whoIs( Point(self._point.getX(), self._point.getY()+1), self);

            if (temp.getSign() != self.getSign() and temp.getSign() != 'C'):
                self._world.deleteOrganizm(temp);

        
        if (self._world.whoIs( Point(self._point.getX() - 1, self._point.getY()), self) != None
        and self._world.whoIs( Point(self._point.getX()-1, self._point.getY()), self).getIsAnimal() == True ) :
            temp = self._world.whoIs( Point(self._point.getX()-1, self._point.getY()), self);

            if (temp.getSign() != self.getSign() and temp.getSign() != 'C'):
                self._world.deleteOrganizm(temp);

        
        if (self._world.whoIs( Point(self._point.getX() + 1, self._point.getY()), self) != None
        and self._world.whoIs( Point(self._point.getX()+1, self._point.getY()), self).getIsAnimal() == True ) :
            temp = self._world.whoIs( Point(self._point.getX()+1, self._point.getY()), self);

            if (temp.getSign() != self.getSign() and temp.getSign() != 'C'):
                self._world.deleteOrganizm(temp);

        
        else :
            super().Akcja();
        

