import pygame
from myWorld import World


# Инициализация Pygame
#pygame.init()
import pygame
#from pygame_textinput import TextInput

number1 = input("Enter width: ")
number2 = input("Enter height: ")

world = World(int(number1), int(number2))
world.printMap()