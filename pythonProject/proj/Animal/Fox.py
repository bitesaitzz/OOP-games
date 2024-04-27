from proj.Animal.myAnimal import *
from random import *
class Fox(Animal):
    def __init__(self, world: World, point: Point, initiative, power, age):
        super().__init__(world, point, 3, 7, 0)
        self.age = age
        self._power = power
        self._typ = 4
        self._sign = 'F'
    def getColor(self):
        return (255, 153, 51)
    def Akcja(self):
        left = True
        right = True
        up = True
        down = True


        if (0 + self.getPosition().getX() - 2 < 0) :
            left = False
        
        elif (0 + self.getPosition().getX() + 3 > 0 + self._world.getX()) :
            right = False
        
        if (self.getPosition().getY() - 2 < 0) :
            up = False
        
        elif (self.getPosition().getY()+ 3 > 0 + self._world.getY()) :
            down = False
        




        temp1 = Point(self._point.getX(), self._point.getY() - 1)

        temp2 = Point(self._point.getX() - 1, self._point.getY())

        temp3 = Point(self._point.getX() + 1, self._point.getY())

        temp4 = Point(self._point.getX(), self._point.getY() + 1)



        a = randint(0, 100)

        if (a >= 0  and a < 25 and up == True and (self._world.whoIs(temp1, self) == None or self._world.whoIs(temp1, self).getSila() < self.getSila())) :
            self._point.set(temp1)
            if (self._world.whoIs(temp1, self) != None):
                self._world.whoIs(temp1, self).Kolizja(self)
        elif (a >= 25 and a < 50  and left == True  and (self._world.whoIs(temp2, self) == None or self._world.whoIs(temp2, self).getSila() < self.getSila())) :
            self._point.set(temp2)
            if (self._world.whoIs(temp2, self) != None):
                self._world.whoIs(temp2, self).Kolizja(self)
        elif (a >= 50 and a < 75  and right == True  and (self._world.whoIs(temp3, self) == None or self._world.whoIs(temp3, self).getSila() < self.getSila())) :
            self._point.set(temp3)
            if (self._world.whoIs(temp3, self) != None):
                self._world.whoIs(temp3, self).Kolizja(self)
        elif (a >= 75  and a < 100 and  down == True and (self._world.whoIs(temp4, self) == None or self._world.whoIs(temp4, self).getSila() < self.getSila())) :
            self._point.set(temp4)
            if (self._world.whoIs(temp4, self) != None):
                self._world.whoIs(temp4, self).Kolizja(self)

        
