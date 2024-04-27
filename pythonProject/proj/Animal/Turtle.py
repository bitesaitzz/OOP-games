from proj.Animal.myAnimal import *

class Turtle(Animal):
    def __init__(self, world: World, point: Point, initiative, power, age):
        super().__init__(world, point, 2, 2, 0)
        self._power = power
        self.age = age
        self._typ = 3
        self._sign = 'T'
    def getColor(self):
        return (31, 122, 31)

    def Akcja(self):
        
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
    
        elif (self.getPosition().getY()+ 2 > 0 + self._world.getY()) :
            down = False
    

        ifGo = randint(0, 100)
        if (ifGo > 75):
            while (True) :

                a = randint(0, 100)

                if (a >= 0 and a < 25 and up == True) :
                    self._point.changePositionToUp()
                    break
    
                elif (a >= 25 and a < 50 and down == True) :
                    self._point.changePositionToDown()
                    break



                elif (a >= 50 and a < 75 and left == True) :
                    self._point.changePositionToLeft()
                    break

                elif (a >= 75 and right == True) :
                    self._point.changePositionToRight()
                    break



            if (self._world.whoIs(self.getPosition(), self) != None and self._world.whoIs(self.getPosition(), self).getSign() != self.getSign()) :
                self._world.whoIs(self.getPosition(), self).Kolizja(self)

            elif (self._world.whoIs(self.getPosition(), self) != None and self._world.whoIs(self.getPosition(), self).getSign() == self.getSign() and self.getAge() > 10 and self._world.whoIs(self.getPosition(), self).getAge() > 10):
                self.breeding(self._world.whoIs(self._point, self))
        self.plusAge()

    def Kolizja(self, org):
        if (org.getSila() > 5) :
            self._world.deleteOrganizm(self)



        else :

            org.getPosition().changePositionToLeft()

