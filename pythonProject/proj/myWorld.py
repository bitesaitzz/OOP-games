import os
import pickle

from myPoint import Point
from mapPanel import *
from myOrganizm import *
from random import *
from proj.Animal import *

class World:
    def __init__(self,width, height):
        self._width = width
        self._height = height
        self._map = [[0 for i in range (width)] for j in range (height)]
        self._alive = []
        self.emptyWorld()
        self.creationWorld()
        self.mapPanel = OrganismMap(width, height, self._map, self)
        self._temp = 0
        self._isActivated = False


    def emptyWorld(self):
        import myGround
        for i in range (self._width):
            for j in range (self._height):
                self._map[i][j] = myGround.Ground(self, Point(i, j))
    def getWidth(self):
        return self._width
    def creationWorld(self):
        #import proj.Animal.Man
        from proj.Animal.Man import Man
        from proj.Animal.Sheep import Sheep
        man = Man(self, Point(0,0), 4, 4, 0)
        self.addOrganizm(man)
        for i in range(self._width*self._height//20):
            wid = randint(1, self._width-1)
            heigh = randint(1, self._height-1)
            typ = randint(1,11)
            self.createOrganizm(typ, Point(wid, heigh))



    def setTemp(self, temp):
        self._temp = temp
    def getTemp(self):
        return self._temp
    def getX(self):
        return self._width
    def getY(self):
        return self._height
    def printMap(self):
        #mapa = OrganismMap(self._width, self._height, self._map, self )
        self.mapPanel.run()

    def addOrganizm(self, org):
        self._map[org.getPositionY()][org.getPosition().getX()] = org
        self._alive.append(org)
    def nextTurn(self):
        self._alive=sorted(self._alive, key=lambda x: x._initiative, reverse=True)
        for i in range (len(self._alive)):
            if(i < len(self._alive)):
                self._alive[i].Akcja()
        self.emptyWorld()
        for i in range(len(self._alive)):
            org = self._alive[i]
            self._map[org.getPositionX()][org.getPositionY()] = org

    def whoIs(self, position, exception):
        for i in range (len(self._alive)):
            if(self._alive[i] != exception and self._alive[i].getPosition().isEqual(position)):
                return self._alive[i]
        return None
    def createOrganizm(self, typ, point):
        from proj.Animal.Man import Man
        from proj.Animal.Sheep import Sheep
        from proj.Animal.Wolf import Wolf
        from proj.Animal.Turtle import Turtle
        from proj.Animal.Fox import Fox
        from proj.Animal.Antelope import Antelope
        from proj.Plant.Grass import Grass
        from proj.Plant.Dandelion import Dandelion
        from proj.Plant.Heracleum import Heracleum
        from proj.Plant.Wolfberries import Wolfberries
        from proj.Plant.Guarana import Guarana
        from proj.Animal.CyberSheep import CyberSheep

        if(typ == 1):
            sheep = Sheep(self, point, 4, 4, 0)
            self.addOrganizm(sheep)
        elif(typ == 2):
            wolf = Wolf(self, point, 6, 9, 0)
            self.addOrganizm(wolf)
        elif(typ == 3):
            turtle = Turtle(self, point, 2, 2, 0)
            self.addOrganizm(turtle)
        elif(typ == 4):
            fox = Fox(self, point, 7, 3, 0)
            self.addOrganizm(fox)
        elif (typ == 5):
            antelope = Antelope(self, point, 4, 4, 0)
            self.addOrganizm(antelope)
        elif(typ == 6):
            grass = Grass(self,point, 0,0,0)
            self.addOrganizm(grass)
        elif (typ == 7):
            dandelion = Dandelion(self, point, 0, 0, 0)
            self.addOrganizm(dandelion)
        elif (typ == 8):
            guarana = Guarana(self, point, 0, 0, 0)
            self.addOrganizm(guarana)
        elif (typ == 9):
            wolfberries = Wolfberries(self, point, 10, 0, 0)
            self.addOrganizm(wolfberries)
        elif (typ == 10):
            heracleum = Heracleum(self, point, 98, 0, 0)
            self.addOrganizm(heracleum)
        elif(typ == 11):
            cyber = CyberSheep(self, point, 11, 0, 0)
            self.addOrganizm(cyber)
        else:
            pass
    def deleteOrganizm(self, org):
        self._alive.remove(org)
    def skillActivated(self):
        return self._isActivated
    def setSkillActivated(self, bool):
        self._isActivated = bool
    def findHeracleum(self, org):
        min = 999999
        orgToReturn = None
        for i in range(len(self._alive)):
            if(self._alive[i].getSign() == 'H'):
                if(min > self.pifagor(org.getPosition(), self._alive[i].getPosition())):
                    min = self.pifagor(org.getPosition(), self._alive[i].getPosition())
                    orgToReturn = self._alive[i]
        return orgToReturn

    def pifagor(self, a, b):
        import math
        x = abs(a.getX() - b.getX())
        y = abs(a.getY() - b.getY())
        return math.sqrt(pow(x,2)+pow(y,2))

    def save(self):
        filename='testPython.txt'
        save=""
        save += f"{self._width} {self._height} {self._temp} {self._isActivated} {len(self._alive)}\n"
        for i in range(len(self._alive)):
            if self._alive[i].getSign() == 'M':
                save += f"{self._alive[i].getSign()} "
                save += f"{self._alive[i]._point.getX()} "
                save += f"{self._alive[i]._point.getY()} "
                save += f"{self._alive[i].getAge()} "
                save += f"{self._alive[i].getSila()} "
                save += f"{self._alive[i].getInitiative()} "
                save += f"{self._alive[i].getSkillCounter()} "
            else:
                save += f"{self._alive[i].getSign()} "
                save += f"{self._alive[i]._point.getX()} "
                save += f"{self._alive[i]._point.getY()} "
                save += f"{self._alive[i].getAge()} "
                save += f"{self._alive[i].getSila()} "
                save += f"{self._alive[i].getInitiative()} "
                # save += f"{self._alive[i].getName()} "
            save += "\n"

        with open(filename, 'w') as file:
            file.write(save)

    def load_the_game(self):
        file_name="testPython.txt"
        if os.path.exists(file_name):
            #clear_game()
            map = None
            self._alive.clear()
            with open(file_name, 'r') as file:
                line = file.readline()
                elements = line.split(" ")

                self._width = int(elements[0])
                self._height = int(elements[1])
                self.mapPanel.setSize(self._width, self._height)
                self._temp = int(elements[2])
                self._isActivated = bool(elements[3])
                tempSize = int(elements[4])

                self.emptyWorld()
                from proj.Animal.Sheep import Sheep
                from proj.Animal.Wolf import Wolf
                from proj.Animal.Turtle import Turtle
                from proj.Animal.Fox import Fox
                from proj.Animal.Antelope import Antelope
                from proj.Plant.Grass import Grass
                from proj.Plant.Dandelion import Dandelion
                from proj.Plant.Heracleum import Heracleum
                from proj.Plant.Wolfberries import Wolfberries
                from proj.Plant.Guarana import Guarana
                from proj.Animal.Man import Man
                from proj.Animal.CyberSheep import CyberSheep
                for i in range(tempSize):
                    line = file.readline()
                    elements = line.split(" ")
                    sign = elements[0]
                    position_x = int(elements[1])
                    position_y = int(elements[2])
                    age = int(elements[3])
                    power = int(elements[4])
                    initiative = int(elements[5])

                    if sign == "M":
                        org = Man(self, Point(position_x, position_y), initiative, power, age)
                        org.setSkillCounter(int(elements[6]))
                        org.setTyp(0)
                        self.addOrganizm(org)
                    elif sign == "A":
                        org = Antelope(self, Point(position_x, position_y),   initiative, power, age)
                        org.setTyp(5)
                        self.addOrganizm(org);

                    elif sign == "B":
                        org = Wolfberries(self, Point(position_x, position_y),  initiative, power, age)
                        org.setTyp(9)
                        self.addOrganizm(org);
                    elif sign == "F":
                        org = Fox(self, Point(position_x, position_y),  initiative, power, age)
                        org.setTyp(4)
                        self.addOrganizm(org);
                    elif sign == "S":
                        org = Sheep(self, Point(position_x, position_y),  initiative, power, age)
                        org.setTyp(1)
                        self.addOrganizm(org);
                    elif sign == "T":
                        org = Turtle(self, Point(position_x, position_y),  initiative, power, age)
                        org.setTyp(3)
                        self.addOrganizm(org);
                    elif sign == "H":
                        org = Heracleum(self, Point(position_x, position_y),  initiative, power, age)
                        org.setTyp(10)
                        self.addOrganizm(org);
                    elif sign == "G":
                        org = Guarana(self, Point(position_x, position_y),  initiative, power, age)
                        org.setTyp(8)
                        self.addOrganizm(org);
                    elif sign == "W":
                        org = Wolf(self, Point(position_x, position_y),  initiative, power, age)
                        org.setTyp(2)
                        self.addOrganizm(org);
                    elif sign == "R":
                        org = Grass(self, Point(position_x, position_y), initiative, power, age)
                        org.setTyp(6)
                        self.addOrganizm(org)
                    elif sign == "D":
                        org = Dandelion(self, Point(position_x, position_y),  initiative, power, age)
                        org.setTyp(7)
                        self.addOrganizm(org);
                    elif sign == "C":
                        org = CyberSheep(self, Point(position_x, position_y),  initiative, power, age)
                        org.setTyp(11)
                        self.addOrganizm(org);


            self.printMap()
