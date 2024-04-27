from proj.Animal.myAnimal import *
from random import *

class Antelope(Animal):
    def __init__(self, world: World, point: Point, initiative, power, age):
        super().__init__(world, point, 4, 4, 0)
        self.age = age
        self._typ = 5
        self._power = power
        self._sign = 'A'
    def getColor(self):
        return (153, 77, 0)
    def Akcja(self):
        left = True
        right = True
        up = True
        down = True
        #oldself._point.set(position)
        if (self.getPosition().getX() - 3 < 0) :
            left = False
        
        elif ( self.getPosition().getX() + 3 > self._world.getX()) :
            right = False
        
        if (self.getPosition().getY() - 3 < 0) :
            up = False
        
        elif (self.getPosition().getY() + 4 > self._world.getY()) :
            down = False

        while (True) :
            a = randint(0, 100)

            if (a >= 0 and a < 25 and up == True) :
                self._point.set( Point(self._point.getX(), self._point.getY() -2))
                break
        
            elif (a >= 25 and a < 50 and down == True) :
                self._point.set(
                Point(self._point.getX(), self._point.getY() + 2))

                break
            elif (a >= 50 and a < 75 and left == True) :
                self._point.set(Point(self._point.getX() - 2, self._point.getY()))
                break


            elif (a >= 75 and right == True) :
                self._point.set(Point(self._point.getX() + 2, self._point.getY()))
                break



            if (self._world.whoIs(self.getPosition(), self) != None and
            self._world.whoIs(self.getPosition(), self).getSign() != self.getSign()) :
                self._world.whoIs(self.getPosition(), self).Kolizja(self)

            elif (self._world.whoIs(self.getPosition(), self) != None and self._world.whoIs(self.getPosition(), self).getSign() == self.getSign() and self.getAge() > 10 and self._world.whoIs(self.getPosition(), self).getAge() > 10):
                self.breeding(self._world.whoIs(self._point, self))



        self.plusAge()

    def Kolizja(self, org):

        a = randint(0,100)
        if (a >= 50) :
            left = True
            right = True
            up = True
            down = True

            if (0 + self.getPosition().getX() - 1 < 0) :
                left = False
            elif (0 + self.getPosition().getX() + 2 > 0 + self._world.getX()) :
                right = False

            if (self.getPosition().getY() - 1 < 0) :
                up = False
            elif (self.getPosition().getY() + 2 > 0 + self._world.getY()) :
                down = False



            if (up == True and self._world.whoIs( Point(self._point.getX(), self._point.getY() - 1), self) == None) :
                self._point.set(
                Point(self._point.getX(), self._point.getY() - 1))
            elif (down == True and self._world.whoIs( Point(self._point.getX(), self._point.getY() + 1), self) == None) :
                self._point.set(Point(self._point.getX(), self._point.getY() + 1))
        
            elif (left == True and self._world.whoIs( Point(self._point.getX() - 1, self._point.getY()), self) == None) :
                self._point.set(
                Point(self._point.getX() - 1, self._point.getY()))

            elif (right == True and self._world.whoIs( Point(self._point.getX() + 1, self._point.getY()), self) == None) :
                self._point.set(Point(self._point.getX() + 1, self._point.getY()))
            else :
                a = 49


        if (a < 50) :
            super().Kolizja(org)


