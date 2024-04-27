import proj.myOrganizm
from random import *
from proj.myOrganizm import Point
from proj.myWorld import World
class Animal(proj.myOrganizm.Organizm):
    def __init__(self, world: World, point: Point, power=0, initiative=0, age=0):

        super().__init__(world, point, power, initiative, age)
        self.isAnimal = True
    def Kolizja(self, org):
        if (self.getSila() > org.getSila()) :
            self._world.deleteOrganizm(org)
        elif (self.getSila() < org.getSila()) :
            self._world.deleteOrganizm(self)
        
        elif (self.getAge() > org.getAge()) :

            self._world.deleteOrganizm(org)
        else :
            self._world.deleteOrganizm(self)
        

    def Akcja(self):

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

        if (self.getPositionY()+ 2 > 0 + self._world.getY()):
            down = False



        while (True):
            a = randint(0,99)
            if (a >= 0 and a < 25 and up == True):
                self._point.changePositionToUp()
                break
            elif (a >= 25 and a < 50 and down == True):
                self._point.changePositionToDown()
                break



            elif (a >= 50 and a < 75 and left == True):
                self._point.changePositionToLeft()
                break

            elif (a >= 75 and right == True):
                self._point.changePositionToRight()
                break



        if (self._world.whoIs(self.getPosition(), self) != None
        and self._world.whoIs(self.getPosition(), self).getSign() != self.getSign()):
            self._world.whoIs(self.getPosition(), self).Kolizja(self)

        elif (self._world.whoIs(self.getPosition(), self) != None 
              and self._world.whoIs(self.getPosition(), self).getSign() == self.getSign()and self.getAge() > 10
              and self._world.whoIs(self.getPosition(), self).getAge() > 10):
              self.breeding(self._world.whoIs(self._point, self))
        self.plusAge()

    def breeding(self, org):
        
        left = True
        
        right = True
        
        up = True
        
        down = True
        if (self.getPosition().getX() - 3 < 0) :
            left = False
        
        elif (0 + self.getPosition().getX() + 3 > 0 + self._world.getX()) :
            right = False
        
        if (self.getPosition().getY() - 3 < 0) :
            up = False
        
        elif (self.getPosition().getY()+ 3 > 0 + self._world.getY()) :
            down = False
        
        
        newPosition = Point(self.getPosition().getX(), self.getPosition().getY())


        if (self._world.whoIs(Point(self._point.getX() + 1, self._point.getY()), self) == None and right == True) :
            newPosition.setX(self._point.getX() + 1)
            newPosition.setY(self._point.getY())
        
        elif (self._world.whoIs(Point( self._point.getX() - 1, self._point.getY() ), self) == None and left == True):
            newPosition.setX(self._point.getX() - 1)
            newPosition.setY(self._point.getY())
        
        elif (self._world.whoIs(Point( self._point.getX(), self._point.getY()-1 ), self) == None and up == True):
            newPosition.setX(self._point.getX())
            newPosition.setY(self._point.getY()-1)
        
        elif (self._world.whoIs(Point( self._point.getX(), self._point.getY()+1 ), self) == None and down == True):
            newPosition.setX(self._point.getX() )
            newPosition.setY(self._point.getY()+1)
        
        else:
            return
        self._world.createOrganizm(self.getTyp(), newPosition)