from proj.Plant.Plant import *

class Guarana(Plant):
    def __init__(self, world: World, point: Point, initiative, power, age):
        super().__init__(world, point, 0, 0, 0)
        self.age = age
        self._typ = 8
        self._sign = 'G'
    def getColor(self):
        return (204, 0, 102)

    def Kolizja(self, org):
        org.setPower(org.getSila() + 3)
        self._world.deleteOrganizm(self)

