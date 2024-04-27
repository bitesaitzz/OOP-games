from proj.Animal.myAnimal import *

class Sheep(Animal):

    def __init__(self, world: World, point: Point, initiative, power, age):
        super().__init__(world, point, 4, 4, 0)
        self._power = power
        self.age = age
        self._typ = 1
        self._sign = 'S'

        #super().__init__()
    def getColor(self):
        return (255, 255,255)
