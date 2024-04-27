from proj.Plant.Plant import *

class Grass(Plant):
    def __init__(self, world: World, point: Point, initiative, power, age):
        super().__init__(world, point, 0, 0, 0)
        self.age = age
        self._typ = 6
        self._sign = 'R'
    def getColor(self):
        return (0, 255, 0)