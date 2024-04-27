from proj.Animal.myAnimal import *

class CyberSheep(Animal):
    def __init__(self, world: World, point: Point, initiative, power, age):
        super().__init__(world, point, 11, 5, 0)
        self.age = age
        self._typ = 11
        self._power = power
        self._sign = 'C'
    def getColor(self):
        return (51, 204, 255)
    def Akcja(self):
        if(self._world.findHeracleum(self) != None):
            self.setPower(11)
            aim = self._world.findHeracleum(self)
            left = True

            right = True

            up = True

            down = True

            if (0 + self.getPositionX() - 1 < 0):
                left = False

            if (0 + self.getPositionX() + 2 > 0 + self._world.getX()):
                right = False

            if (self.getPositionY() - 1 < 0):
                up = False

            if (self.getPositionY() + 2 > 0 + self._world.getY()):
                down = False

            if(aim.getPositionX() > self.getPositionX() and right==True):
                self.getPosition().changePositionToRight()
            elif(aim.getPositionX() < self.getPositionX() and left==True):
                self.getPosition().changePositionToLeft()
            elif (aim.getPositionY() > self.getPositionY() and down == True):
                self.getPosition().changePositionToDown()
            elif (aim.getPositionY() < self.getPositionY() and up == True):
                self.getPosition().changePositionToUp()
            if (self._world.whoIs(self.getPosition(), self) != None
                    and self._world.whoIs(self.getPosition(), self).getSign() != self.getSign()):
                self._world.whoIs(self.getPosition(), self).Kolizja(self)

            elif (self._world.whoIs(self.getPosition(), self) != None
                  and self._world.whoIs(self.getPosition(), self).getSign() == self.getSign() and self.getAge() > 10
                  and self._world.whoIs(self.getPosition(), self).getAge() > 10):
                self.breeding(self._world.whoIs(self._point, self))
            self.plusAge()


        else:
            self.setPower(4)
            super().Akcja()