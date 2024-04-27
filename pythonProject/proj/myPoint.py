class Point:
    def __init__(self, x, y):
        self._x = x
        self._y = y

    def isEqual(self, point):
        return self._x == point._x and self._y == point._y

    def set(self, point):
        self._x = point._x
        self._y = point._y
    def setX(self, x):
        self._x = x
    def setY(self, y):
        self._y = y

    def getX(self):
        return self._x

    def getY(self):
        return self._y

    def getPoint(self):
        return self

    def changePositionToUp(self):
        self._y-=1

    def changePositionToRight(self):
        self._x += 1


    def changePositionToLeft(self):
        self._x -= 1

    def changePositionToDown(self):
        self._y+=1