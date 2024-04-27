import proj.Animal.myAnimal
from proj.Animal.myAnimal import Animal
from proj.myPoint import Point
from proj.myWorld import World
class Man(Animal):
    def __init__(self, world: World, point: Point, initiative, power, age):
        super().__init__(world, point, 5, 5, 0)
        self._power = power
        self.skillCounter = 0
        self._age = age
        self._typ = 0
        self._sign = 'M'
    def getColor(self):
        return (0,0,0)
    def Akcja(self):
        left = True

        right = True

        up = True

        down = True

        if (0 + self.getPosition().getX() - 1 < 0):
            left = False
        if (0 + self.getPosition().getX() + 2 > 0 + self._world.getX()):
            right = False
        if (self.getPosition().getY() - 1 < 0):
            up = False
        if (self.getPosition().getY()+ 2 > 0 + self._world.getY()):
            down = False

        if(self._world.getTemp() == 1 and up == True):
            self._point.changePositionToUp()
        elif(self._world.getTemp() == 2 and left == True):
            self._point.changePositionToLeft()
        elif(self._world.getTemp() == 3 and right == True):
            self._point.changePositionToRight()
        elif(self._world.getTemp() == 4 and down == True):
            self._point.changePositionToDown()
        elif(self._world.getTemp() == 5):
           self.skill()

        if (self._world.skillActivated()):
            self.skill()

        if (self._world.whoIs(self.getPosition(), self) != None and
        self._world.whoIs(self.getPosition(),self).getSign() != self.getSign()):
            self._world.whoIs(self.getPosition(), self).Kolizja(self)

        self.skillCounter +=1
    def skill(self):
       
        
        if (self.skillCounter > 5 and
        self._world.skillActivated() == False):
            self._world.setSkillActivated(True)
        

            self.skillCounter = 5
        
        elif (self.skillCounter > 10 and self._world.skillActivated() == True) :
            self._world.setSkillActivated(False)
       

            self.skillCounter = 0
        
        elif (self._world.skillActivated()):
            if (self._world.whoIs(self._point, self) != None) :

                left = True
                right = True
                up = True
                down = True

                if (0+self.getPosition().getX() - 1 < 0) :
                    left = False
        
                elif (0 + self.getPosition().getX() + 2 > 0 + self._world.getX()) :
                    right = False
        
                if (self.getPosition().getY() - 1 < 0) :
                    up = False
        
                elif (self.getPosition().getY()+ 2 > 0 + self._world.getY()) :
                    down = False
        

                if (up == True) :
                    self._world.whoIs(self._point, self).getPosition().changePositionToUp()


        
                elif (down == True) :
                    self._world.whoIs(self._point, self).getPosition().changePositionToDown()

        
                elif (left == True) :
                    self._world.whoIs(self._point, self).getPosition().changePositionToLeft()

        
                else:
                    self._world.whoIs(self._point, self).getPosition().changePositionToRight()
       

    def Kolizja(self, org):
        if (self._world.skillActivated() and org.getIsAnimal() == True):
            while (self._point.isEqual(org.getPosition())):
                left = True
                right = True
                up = True
                down = True
                if (0+self.getPosition().getX() - 1 < 0) :
                     left = False
                elif(0 + self.getPosition().getX() + 2 > 0 + self._world.getX()) :

                    right = False
                if (self.getPosition().getY() - 1 < 0):
                    up = False
                elif (self.getPosition().getY()+ 2 > 0 + self._world.getY()):
                    down = False
                if (up == True) :

                    org.getPosition().changePositionToUp()
                elif (down == True) :
                    org.getPosition().changePositionToDown()
                elif (left == True) :
                    org.getPosition().changePositionToLeft()
                else :
                    org.getPosition().changePositionToRight()

            print("man kicked out\n")
        else:
             super().Kolizja(org)

    def getSkillCounter(self):
        return self.skillCounter
    def setSkillCounter(self, temp):
        self.skillCounter = temp