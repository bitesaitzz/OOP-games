import proj.myOrganizm


class Ground(proj.myOrganizm.Organizm):

    def __init__(self, world, point):
        super(Ground, self).__init__(world,point,0,0, 0)

    def getColor(self):
        return (195,130,120)
