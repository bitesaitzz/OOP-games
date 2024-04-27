from proj.Plant.Plant import *

class Dandelion(Plant):
    def __init__(self, world: World, point: Point, initiative, power, age):
        super().__init__(world, point, 0, 0, 0)
        self.age = age
        self._typ = 7
        self._sign = 'D'
    def getColor(self):
        return (255, 255, 26)
    def Akcja(self):
        for i in range(3):
            super().Akcja()
