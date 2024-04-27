from proj.Animal.myAnimal import *

class Wolf(Animal):
    def __init__(self, world: World, point: Point, initiative, power, age):
        super().__init__(world, point, 9, 5, 0)
        self._power = power
        self.age = age
        self._typ = 2
        self._sign = 'W'
    '''''
    def __init__(self, world: World, point: Point, inicjatywa=0, power=0, age=0):
        super().__init__(world, point)
        self.inicjatywa = inicjatywa
        self.power = power
        self.age = age
        self._typ = 2
        self._sign = 'W'
    '''''
        #super().__init__()
    def getColor(self):
        return (77, 77,77)
