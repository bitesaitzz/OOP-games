from proj.Plant.Plant import *

class Wolfberries(Plant):
    def __init__(self, world: World, point: Point, initiative, power, age):
        super().__init__(world, point, 10, 0, 0)
        self.age = age
        self._typ = 9
        self._sign = 'B'
    def getColor(self):
        return (179, 0, 0)

    def Kolizja(self, org):
        self._world.deleteOrganizm(org)
        self._world.deleteOrganizm(self)



